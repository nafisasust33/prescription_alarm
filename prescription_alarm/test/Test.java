
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Test {

   // private static Object datePicker;
    
   private static String reverse(String input){
       String output = null,date,month,year;
      year=(String) input.subSequence(0, 4);
      month=input.substring(5, 7);
      date=input.substring(8, 10);
       
       return date+"/"+month+"/"+year;
   }

    public static void main(String ars[]) {
//        Date date = new Date();
//        Instant instant = date.toInstant();
//        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
//        String time = reverse("" + localDate);
//
//        System.out.println("DATE:" + date + "\n" + instant + "\n" + localDate);
        
    }

    
}
