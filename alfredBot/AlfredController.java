public class AlfredController {
    public static void main(String[] args) {
        Alfred alfredBot = new Alfred();
        System.out.println(alfredBot.basicGreeting());
        System.out.println(alfredBot.guestGreeting("Pretty Lady", "evening"));
        System.out.println(alfredBot.conversationResponse("Alexis! Play some low-fi beats."));
        System.out.println("------------------");
        System.out.println(alfredBot.conversationResponse("I can't find my yo-yo. Maybe Alfred will know where it is."));
        System.out.println("------------------");
        System.out.println(alfredBot.conversationResponse("Maybe that's what Batman is about. Not winning. But failing..."));
        System.out.println(alfredBot.volumeUP("This is me yelling!"));
        System.out.println(alfredBot.dateAnnouncement());
        System.out.println(alfredBot.guestGreetingBonus("Beth Kane"));
    }
}
