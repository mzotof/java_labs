import java.util.ArrayList;
import java.util.List;
// Создать класс Park (парк) с внутренним классом, с помощью объектов которого можно хранить
// информацию об аттракционах, времени их работы и стоимости.
class Park {
    private final List<Attraction> attractions;

    public Park() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(String name, int price, String startTime, String endTime) {
        attractions.add(new Attraction(name, price, startTime, endTime));
    }

    public void removeAttraction(String name) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equals(name)) {
                attractions.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Аттракционы парка:\n");
        for (Park.Attraction attraction : this.attractions)
            res.append(attraction.getName()).append(" - ").append(attraction.getPrice())
                    .append(" рублей\nРаботает с ").append(attraction.getStartTime())
                    .append(" до ").append(attraction.getEndTime()).append("\n");
        return res.toString();
    }

    public static class Attraction {
        private final String name;
        private final int price;
        private final String startTime;
        private final String endTime;

        public Attraction(String name, int price, String startTime, String endTime) {
            this.name = name;
            this.price = price;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }
    }
}

public class var1_ex9 {
    public static void main(String[] args) {
        Park park = new Park();

        park.addAttraction("Карусель", 100, "10:00", "18:00");
        park.addAttraction("Горка", 150, "11:00", "19:00");
        park.addAttraction("Качели", 50, "12:00", "20:00");

        System.out.println(park);

        park.removeAttraction("Качели");

        System.out.println(park);
    }
}
