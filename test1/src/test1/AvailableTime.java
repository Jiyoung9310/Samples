import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AvailableTime {
	
	private static final String formatTimeTo_OnlyHour = "HH:mm";
	private static final String[] week = { "토", "일", "월", "화", "수", "목", "금" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		//String n = sc.nextLine();
		String n = "수 10:00~18:30/목,토 09:00~13:00";
		
		System.out.println(isTimePatternIn(n));
	}

	
	private static boolean isTimePatternIn(String timePattern) {

		Calendar calendar = Calendar.getInstance();
		int dateOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		String[] timeArr = timePattern.split("/");
		for(String time : timeArr) {
			String regex = "(\\d{2}:\\d{2})~(\\d{2}:\\d{2})";
			Pattern groupPattern = Pattern.compile(regex);
			Matcher groupMatcher = groupPattern.matcher(time);
	
			while(groupMatcher.find()) {
				if(time.contains(week[dateOfWeek])) {
					
					try {
						calendar.clear(Calendar.YEAR);
						calendar.set(Calendar.MONTH, 0);
						calendar.set(Calendar.DAY_OF_MONTH, 1);
						Date currentTime = calendar.getTime();
						
						SimpleDateFormat format = new SimpleDateFormat(formatTimeTo_OnlyHour);
						Date start = format.parse(groupMatcher.group(1));
						Date end = format.parse(groupMatcher.group(2));
						
						if(start.before(currentTime) && end.after(currentTime)) {
							return true;
						} else {
							return false;
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
	
				}
			}
		}

		return false;
	}
}

