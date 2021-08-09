import java.util.Arrays;
import java.util.Random;

class PuzzleJava {
    public String getTenRolls(){
        Random random = new Random();
        int[] output = new int[10];
        for( int i = 0; i <= 9; i++){
            output[i] = random.nextInt(20);
        }
        return Arrays.toString(output);
    }
    public String alphabetSoup(ArrayList<Character> input){
        for(char alph = 'a'; alph <= 'z'; ++alph){
            input.add(alph);
        }
        System.out.println("A-Z: "+input);
        Collections.shuffle(input);
        System.out.println("Shuffled: "+input);
        System.out.println("First Letter: "+input.get(0));
        System.out.println("Last Letter: "+input.get(25));
        char first = input.get(0);
        char[] vowels = {'a','e','i','o','u'};
        for(int i = 0; i < vowels.length; i++){
            if(vowels[i] == first){
                System.out.print("The first letter seems to be a vowel! ");
            }
        }
        return input;
    }
}