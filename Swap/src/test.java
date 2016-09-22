
public class test {
public static void main(String[] args) {
	int i=0;
	int j=0;
	while(j++<5){
		LL:
			for ( i= 0; i <5; i++) {
				System.out.println(j+":"+i);
				if (i==2) {
					continue LL;
				}
			}
	}
	System.out.println("end");	
}
}
