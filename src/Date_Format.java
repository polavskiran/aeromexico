import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Calendar calendar = Calendar.getInstance();
		
		System.out.println("The current date is: "+ calendar.getTime());
		calendar.add(Calendar.MONTH, 3);
		System.out.println("3 months later :"+calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, -2);
		System.out.println("4 months later on the day is :"+calendar.getTime());
		
		String sDate4 = "13-Mar-2018";
		DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");*/
		
		
		/*SimpleDateFormat formatter	=	new SimpleDateFormat("E, MMM dd yyyy");
		String dateString	=	"Fri, June 7 2013";
		
		try{
			String pattern = formatter.toPattern();
			Date date = formatter.parse(dateString);
			System.out.println(date);
			System.out.println(formatter.format(date));
		}catch(ParseException e){
			e.printStackTrace();
		}*/
		
		/*SimpleDateFormat formatter = new SimpleDateFormat();
		
		Calendar cal = Calendar.getInstance();
		
		String pattern = "yyyy-MMMMMM-dd";
		formatter.applyPattern(pattern);
		
		String reqDate = formatter.format(cal.getTime());
		
		System.out.println("Pattern:"+formatter.toPattern());
		System.out.println("Date today:"+reqDate);*/
		
		/*Calendar mycal = new GregorianCalendar();
		String myDate = "March 19,2018";
		
		try {
			Date theDate = new SimpleDateFormat("MMM d,yyyy",Locale.ENGLISH).parse(myDate);
			mycal.setTime(theDate);
			System.out.println("year   -> "+mycal.get(Calendar.YEAR));
			System.out.println("month   -> "+mycal.get(Calendar.MONTH));
			System.out.println("day   -> "+mycal.get(Calendar.DAY_OF_MONTH));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String str_date = "2018-03-19";
		
		DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = (Date) parser.parse(str_date);
			DateFormat formatter = new SimpleDateFormat("yyyy-MMMMM-dd");
			System.out.println(formatter.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(date);
	}	
}