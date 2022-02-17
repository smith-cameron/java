import java.util.ArrayList;
import java.util.Arrays;

public class Basics {
    //Print 1 - 255
    public void printNums() {
        for(int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }
    //Print 1 - 255. Odds only
    public void printOdds() {
        for(int i = 1; i <= 255; i+=2) {
            System.out.println(i);
        }
    }
    //Sigma 255
    public int sigma255() {
        int sum = 0;
        for(int i = 1; i<= 255; i+=2) {
            sum += i;
        }
        return sum;
    }
    //Iterate through array
    public void printValues( int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //Find Max
    public int findMax(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    //List Of Odd Numbers
    public ArrayList<Integer> allOdds(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i <= 255; i+=2) {
            arr.add(i);
        }
        return arr;
    }
    //Find Avgerage
    public double findAvg(double[] arr) {
        double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = sum / arr.length;
        return avg;
    }
    //Greater Than Y
    public int greaterThan(int[] arr, int y) {
        int sum = 0;
        for(int i : arr) {
            if(i > y) {
                sum += 1;
            }
        }
        return sum;
    }
    //Square the Values
    public String squareValues(int[] arr) {
        for( int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }
        return Arrays.toString(arr);
    }
    //Eliminate Negative Numbers
    public String elimNegative(int[] arr) {
        for( int i = 0; i < arr.length; i++) {
            if( arr[i] < 0) {
                arr[i] = 0;
            }
        }
        return Arrays.toString(arr);
    }
    //Max, Min, and Average
    public void maxMinAvg(double[] arr) {
        System.out.println(Arrays.toString(arr));
        double max = arr[0];
        double min = arr[0];
        double sum = 0;
        for( double i : arr) {
            if(i > max) {
                max = i;
            }
            if(i < min) {
                min = i;
            }
            sum += i;
        }
        double avg = sum / arr.length;
        System.out.println("Max: "+max+" Min: "+min+" Avg: "+avg);
    }
    //Shifting the values in the array
    public String getShwifty(int[] arr) {
        for(int i = 0; i < arr.length -1; i++) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        arr[arr.length-1] = 0;
        return Arrays.toString(arr);
    }
}