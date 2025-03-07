package Clock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {
	
	public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        while (true)
        {
            Date now = new Date();
            System.out.print("\r" + formatter.format(now));
            try 
            {
                Thread.sleep(1000); 
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
