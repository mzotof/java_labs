import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Year {
    private int year;
    private Month month;
    private Day day;

    public Year(int year, int month, int day) {
        try {
            LocalDate date = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid date value");
        }
        this.year = year;
        this.month = new Month(month);
        this.day = new Day(day);
    }

    public Year(int year) {
        this.year = year;
        this.month = new Month(1);
        this.day = new Day(1);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setDate(int month, int day) {
        try {
            LocalDate date = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid date value");
        }
        this.month = new Month(month);
        this.day = new Day(day);
    }

    public DayOfWeek getDayOfWeek() {
        LocalDate date = LocalDate.of(year, month.getMonth(), day.getDay());
        return date.getDayOfWeek();
    }

    public int calculateDaysBetween(Year otherYear) {
        LocalDate date1 = LocalDate.of(year, this.month.getMonth(), this.day.getDay());
        LocalDate date2 = LocalDate.of(otherYear.getYear(), otherYear.month.getMonth(), otherYear.day.getDay());
        return (int) ChronoUnit.DAYS.between(date1, date2);
    }

    public int calculateMonthsBetween(Year otherYear) {
        YearMonth yearMonth1 = YearMonth.of(year, this.month.getMonth());
        YearMonth yearMonth2 = YearMonth.of(otherYear.getYear(), otherYear.month.getMonth());
        return (int) ChronoUnit.MONTHS.between(yearMonth1, yearMonth2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Year year1)) return false;
        return year == year1.year && month.equals(year1.month) && day.equals(year1.day);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month.hashCode();
        result = 31 * result + day.hashCode();
        return result;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.of(year, month.getMonth(), day.getDay());
        return "Year{" +
                "date=" + formatter.format(date) +
                '}';
    }
}
class Month {
    private final int month;

    public Month(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month value");
        }
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Month month1)) return false;
        return month == month1.month;
    }

    @Override
    public int hashCode() {
        return month;
    }

    @Override
    public String toString() {
        return "Month{" +
                "month=" + month +
                '}';
    }
}
class Day {
    private final int day;

    public Day(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day value");
        }
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Day day1)) return false;
        return day == day1.day;
    }

    @Override
    public int hashCode() {
        return day;
    }

    @Override
    public String toString() {
        return "Day{" +
                "day=" + day +
                '}';
    }
}
