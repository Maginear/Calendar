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
        int month = d.get(Calendar.DAY_OF_MONTH);

        //set d to start data of the month
        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);

        //get first Day of week
        int firstDayOfWeek = d.getFirstDayOfWeek();

        //determine the required indentation for the first line
        int indent = 0;
        while (weekday != firstDayOfWeek){
            indent++;
            d.add(Calendar.DAY_OF_WEEK, -1);
        }
    }
}