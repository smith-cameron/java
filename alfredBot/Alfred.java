import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Alfred{
    public String basicGreeting(){
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name, String dayPeriod){
        return "Good "+dayPeriod+", "+name+". Lovely to see you!";
    }

    public int dateAnnouncement(){
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println();
        System.out.println("The hour is "+hour);
        return hour;
    }

    public String conversationResponse(String conversation){
        int alfred = conversation.indexOf("Alfred");
        System.out.println(alfred);
        int alexis = conversation.indexOf("Alexis");
        System.out.println(alexis);
        if(alfred >= 0){
            return "At your service. As you wish, naturally.";
        }
        if(alexis >= 0){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else{
            return "Right. And with that I shall retire.";
        }
    }
    
    public String volumeUP(String input){
        return input.toUpperCase();
    }
    public String guestGreetingBonus(String name) {
        // use SDF to pull the hour of day
        String dayPeriod = "";
        String pattern = "h";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String hour = simpleDateFormat.format(new Date());
        int i = this.dateAnnouncement();
        // System.out.println(i);
        if (i >= 1 && i <= 11) {
            dayPeriod = "Morning";
        }
        if (i > 11 && i <= 17) {
            dayPeriod = "Afternoon";
        }
        else {
            dayPeriod = "Evening";
        }
        return String.format("Good %s, %s, How are you?", dayPeriod, name);
    }
}