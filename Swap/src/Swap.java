
public class Swap {
	public static int a = 10;
	public static int b = 110;

	public static void main(String[] args) {
	/*	Swap swap = new Swap();
		// swap2(swap);
	    // swap(a, b);
		check();
		*/
				
	while(a<b) System.err.println(a++); 
	System.out.println("111");

	}

	private static void swap(int a, int b) {
		// TODO Auto-generated method stub
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println(a + "\n" + b);
	}

	private static void swap2(Swap swap) {
		// TODO Auto-generated method stub
		int tmp = swap.a;
		swap.a = swap.b;
		swap.b = tmp;
	}
	//check ||
	public static void check() {
		int a=1;
		int b=2;
		if (a>2||b>=44) {
			System.out.println("11");
		}else {
			System.out.println("2");
		}
	}
	
}
