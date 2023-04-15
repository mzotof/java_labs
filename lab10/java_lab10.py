from pyspark.sql import SparkSession, functions as f

# https://www.kaggle.com/datasets/ashishraut64/internet-users

spark = SparkSession.builder.getOrCreate()
spark.sparkContext.setLogLevel("ERROR")
raw_data = spark.read.format("csv").option("header", True).load("Final.csv")
raw_data.filter((f.col('year') > 1989) &
                (~ f.col('entity').isin('Low and middle income', 'Low income', 'Lower middle income',
                                          'Middle income', 'Upper middle income'))).createOrReplaceTempView("src")

print("\n1. Среднее количество пользователей интернета по годам:")
spark.sql("select year, round(avg(internet_users_num), 2) as avg_internet_users_num "
          "from src "
          "where code = 'Region' "
          "group by 1 "
          "order by 1").show(truncate=False)

print("2. Прирост количества пользователей интернета относительно прошлого года")
spark.sql("with tmp as ("
          "    select year, avg(internet_users_num) as avg_internet_users_num "
          "    from src "
          "    where code = 'Region' "
          "    group by 1) "
          "select year, "
          "    round(coalesce(avg_internet_users_num - "
          "                   lag(avg_internet_users_num) over (order by year), avg_internet_users_num)"
          "          , 2) as internet_users_num_increase "
          "from tmp "
          "order by 1").show()

print("3. Страны, где доля пользователей интернета с 2000 по 2020 год была выше 40%:")
spark.sql("select entity, round(avg(internet_users_perc), 2) avg_internet_users_perc "
          "from src "
          "where internet_users_perc > 40 "
          "    and code <> 'Region' "
          "    and year between 2000 and 2020 "
          "group by 1 "
          "having count(*) = 21 "
          "order by 2 desc").show(truncate=False)

print("4. Список регионов по максимальной доле пользователей мобильной связи:")
spark.sql("with tmp as ("
          "    select entity, round(avg(mobile_users), 2) as avg_mobile_users "
          "    from src "
          "    where code = 'Region' "
          "    group by 1) "
          "select "
          "    row_number() over (order by cast(avg_mobile_users as int) desc) as num, "
          "    tmp.* "
          "from tmp "
          "order by 1").show(truncate=False)

print("5. Страны с долей пользователей интернета за 2020 год выше среднего:")
spark.sql("select entity, internet_users_perc "
          "from src "
          "where year = 2020"
          "    and code <> 'Region' "
          "    and internet_users_perc > (select avg(internet_users_perc) from src where year = 2020) "
          "order by 2 desc").show(truncate=False)

print("6. Года, когда в России доля пользователей интернета было ниже среднего по миру:")
spark.sql("with tmp as ("
          "    select year, avg(internet_users_perc) as avg_internet_users_perc "
          "    from src "
          "    group by 1) "
          "select src.year "
          "from src join tmp "
          "on src.year = tmp.year "
          "where entity = 'Russia' "
          "    and internet_users_perc < avg_internet_users_perc "
          "order by 1").show()

print("7. Топ 3 страны по доле пользователей мобильной связи:")
spark.sql("with tmp as ("
          "    select entity, max(mobile_users) as mobile_users "
          "    from src "
          "    where code <> 'Region' "
          "    group by 1)"
          "select src.entity, src.year, src.mobile_users "
          "from src join tmp "
          "on src.entity = tmp.entity and src.mobile_users = tmp.mobile_users "
          "order by 3 desc "
          "limit 3").show(truncate=False)

print("8. Количество стран, у которых доля пользователей интернета была выше 30, по годам:")
spark.sql("select year, count(*) as count_of_countries "
          "from src "
          "where internet_users_perc > 30 "
          "    and code <> 'Region' "
          "group by 1 "
          "order by 1").show()

print("9. Последние страны подключившиеся к интернету:")
spark.sql("with tmp as ("
          "    select entity, max(year) + 1 as connect_year "
          "    from src "
          "    where internet_users_num = 0 "
          "        and code <> 'Region' "
          "    group by 1 "
          "    having max(year) < (select max(year) from src)) "
          "select entity, cast(connect_year as int) "
          "from tmp "
          "where connect_year = (select max(connect_year) from tmp) "
          "order by 1").show()

print("10. Страны-рекордсменки по доле пользователей интернета по годам:")
spark.sql("select distinct year, "
          "    first_value(entity) over (partition by year order by internet_users_perc desc) as country, "
          "    max(internet_users_perc) over (partition by year) as internet_users_perc "
          "from src "
          "order by 1").show(truncate=False)
