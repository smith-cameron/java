
public class Controller {
	public static void main(String[] args) {
	int[] array = {1,2,4,6};
	System.out.println(lucky13(array));
	}

	public static boolean lucky13(int[] input){
		boolean present1 = false;
		boolean present3 = false;
		for(int i = 0; i<input.length; i++){
			if(input[i] == 1){
				present1 = true;
			}
			if(input[i] == 3){
				present3 = true;
			}
		}
		if(present1 == true && present3 == true){
			return false;
		}
		else{
			return true;
		}
	}
}
