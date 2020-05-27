
public class Pi {

	public static void main(String[] args) {
		
		double x;
		double y;
		double counter = 0;
		double durchläufe = 0;
		double result;
		for(int i = 0; i <= 1000000; i++) {

			x = Math.random();
			y = Math.random();
			if(Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
				counter++;
			}
			durchläufe++;
		}
		result = counter / durchläufe;
		System.out.println(4 *result);
		System.out.println("zum Vergleich : " + Math.PI);
		
	}
}
