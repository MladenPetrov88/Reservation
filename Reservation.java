import java.util.Scanner;

public class Reservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dayNow = Integer.parseInt(scanner.nextLine());
        int monthNow = Integer.parseInt(scanner.nextLine());

        int checkInDay = Integer.parseInt(scanner.nextLine());
        int checkInMonth = Integer.parseInt(scanner.nextLine());

        int checkOutDay = Integer.parseInt(scanner.nextLine());
        int checkOutMonth = Integer.parseInt(scanner.nextLine());

        int nights = checkOutDay - checkInDay;
        int daysApart = Math.abs(dayNow - checkInDay);
        int monthsApart = Math.abs(monthNow - checkInMonth);

        boolean earlyBooking10days = false;
        boolean earlyBooking1month = false;
        double price = 30;

        if (daysApart >= 10) {
            earlyBooking10days = true;
        }

        if (monthsApart >= 1) {
            earlyBooking1month = true;
            earlyBooking10days = true;
        }

        double cost = nights * price;
        if (earlyBooking10days) {
            cost = nights * 25;
        }

        if (earlyBooking1month) {
            cost *= 0.8;
        }

        System.out.printf("Your stay from %s/%s to %s/%s will cost %.2f",
                checkInDay, checkInMonth,
                checkOutDay, checkOutMonth,
                cost);
    }
}
