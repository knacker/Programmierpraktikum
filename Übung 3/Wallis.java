
public class Wallis {

	public static void main(String[] args) {
		
		double result = 1;
		double x = 2;
		double y = 1;
		for(int i = 1; i <=1000000; i++) {
			result = x / y * result;
			y = y + 2;
			result = x / y * result;
			x = x + 2;
			if(i% 100000 == 1) {
				System.out.println(result * 2);
			}
		}	
		System.out.println(result * 2);

	}

}
