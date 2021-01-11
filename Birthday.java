package BirthdayCalculator;
import java.util.Scanner;
import java.time.*;
import static java.time.temporal.ChronoUnit.DAYS;

public class Birthday {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your birthday?"); //day/month/year format
        String birthday = in.nextLine();

        String[] parts = birthday.split("/"); //assuming the user uses "/" to separate the digits
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        int theDay = Integer.parseInt(day);
        int theMonth = Integer.parseInt(month);
        int theYear = Integer.parseInt(year);

        LocalDate birthDate = LocalDate.of(theYear, theMonth, theDay);

        System.out.println("That means you were born on a " + birthDate.getDayOfWeek() + "!");

        LocalDate todayDate = LocalDate.now(); //it's format is year/month/day
        LocalDate thisYearBday = LocalDate.of(todayDate.getYear(), theMonth, theDay);
        System.out.println("This year it falls on a " + thisYearBday.getDayOfWeek() + "...");

        System.out.println("And since today is " + todayDate + ",");

        long daysTillNextBday = DAYS.between(todayDate, thisYearBday);
        Period age = Period.between(birthDate, todayDate);
        System.out.printf("there's only %d days more days until the next one when you turn %d!\n",
                daysTillNextBday, age.getYears() + 1);

    }
}
