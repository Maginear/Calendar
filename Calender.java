import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Magy on 2015/6/6.
 * desc:
 */
public class Calender {
    private static final String TAG = "Calender";

    public static void main(String[] args) {
        //construct d as current date
        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        //set d to start data of the month
        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);

        //get first Day of week
        int firstDayOfWeek = d.getFirstDayOfWeek();

        //determine the required indentation for the first line
        int indent = 0;
        while (weekday != firstDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        //print weekdays name
        String[] weekDayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekDayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);

        System.out.println();
        for (int i = 0; i <= indent; i++) {
            System.out.print("    ");
        }

        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            //print day
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%6d", day);

            //mark current day
            if (day == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }

            //advance d to next day
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            //start a new day at the start of week
            if (weekday == firstDayOfWeek) {
                System.out.println();
            }

        } while (d.get(Calendar.MONTH) == month);

        if (weekday != firstDayOfWeek)
            System.out.println();

    }
}