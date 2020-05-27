
public class Würfel {
	
	public static void main(String[] args) {
		
		int a = (int) (Math.random() * 6 + 1);
		switch (a) {
		case 1: System.out.println("     ");
				System.out.println("  *  ");
				System.out.println("     ");
				break;
		
		case 2: System.out.println("*    ");
				System.out.println("     ");
				System.out.println("    *");
				break;
			
		case 3: System.out.println("*    ");
				System.out.println("  *  ");
				System.out.println("    *");
				break;
				
		case 4: System.out.println("*    *");
				System.out.println("      ");
				System.out.println("*    *");
				break;
				
		case 5: System.out.println("*     *");
				System.out.println("   *  ");
				System.out.println("*     *");
				break;
				
		case 6: System.out.println("*    *");
				System.out.println("*    *");
				System.out.println("*    *");
				break;
		
		}
	}
		
}
