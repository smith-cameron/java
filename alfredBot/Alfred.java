import java.util.Date;

class Alfred{
    public String basicGreeting(){
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name, String dayPeriod){
        return "Good "+dayPeriod+", "+name+". Lovely to see you!";
    }

    public String dateAnnouncement(){
        Date today = new Date();
        return "Today is "+today;
    }

    public String conversationResponse(String conversation){
        int alfred = conversation.indexOf("Alfred");
        int alexis = conversation.indexOf("Alexis");
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
}