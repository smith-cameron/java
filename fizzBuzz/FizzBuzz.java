
class FizzBuzz{
    public String fizzBuzz(int input){
        if(input % 3 == 0 && input % 5 == 0){
            return "FizzBuzz";
        }
        if(input % 3 == 0){
            return "Fizz";
        }
        if(input % 5 == 0){
            return "Buzz";
        }
        String output = String.format("%d", input);
        return output;
    }
}