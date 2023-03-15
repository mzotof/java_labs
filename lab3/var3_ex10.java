public class var3_ex10 {
    public static void main(String[] args) {
        Year year1 = new Year(2023, 3, 15);
        Year year2 = new Year(2023, 2, 2);
        Year year3 = new Year(2023);

        year3.setDate(2, 2);

        System.out.println("Years 1 and 2 are equal: " + year1.equals(year2));
        System.out.println("Years 2 and 3 are equal: " + year2.equals(year3));

        System.out.println("Hash code for year 1: " + year1.hashCode());

        System.out.println("Year 2 = " + year2);

        System.out.println("Day of week for year 1: " + year1.getDayOfWeek());

        System.out.println("Months between year 2 and year 1: " + year2.calculateMonthsBetween(year1));
        System.out.println("Days between year 2 and year 1: " + year2.calculateDaysBetween(year1));
    }
}
