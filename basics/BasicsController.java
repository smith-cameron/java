public class BasicsController {
    public static void main(String[] args) {
        Basics algorithm = new Basics();
		double[] myArr1 = {1,3,5,7,20};
        System.out.println("#1------------");
		algorithm.printNums();
        System.out.println("#2------------");
		algorithm.printOdds();
        System.out.println("#3------------");
		System.out.println(algorithm.sigma255());
        System.out.println("#4------------");
        int[] myArr = {25,-3,10,72,94,-4};
		algorithm.printValues(myArr);
        System.out.println("#5------------");
		System.out.println(algorithm.findMax(myArr));
        System.out.println("#6------------");
		System.out.println(algorithm.findAvg(myArr1));
        System.out.println("#7------------");
		System.out.println(algorithm.allOdds());
        System.out.println("#8------------");
		System.out.println(algorithm.greaterThan(myArr, 10));
        System.out.println("#9------------");
        int[] sqValues = {1, 5, 10, -2};
		System.out.println(algorithm.squareValues(sqValues));
        System.out.println("#10------------");
		System.out.println(algorithm.elimNegative(myArr));
        System.out.println("#11------------");
        double[] MMAInput = {1, 5, 10, -2};
        algorithm.maxMinAvg(MMAInput);
        System.out.println("#12------------");
        int[] shwiftyList = {1, 5, 10, 7, -2};
		System.out.println(algorithm.getShwifty(shwiftyList));
    }
}