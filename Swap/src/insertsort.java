/**
 * ��������
 * @author Jay-Tang
 *
 */
public class insertsort {
	
	   static int[] arrayint ={12,23,223,11,22};

	 
 	   private static void paixu() {
		//���ѭ�h
 		   for(int i=0;i<arrayint.length-1;i++){
 			   for(int j=i+1; j>0; j-- ){
 				 while(arrayint[i+1]>arrayint[i]){
 					 break;
 				 }
 				   if (arrayint[j-1]>arrayint[j]) {
 					   //���Qλ��
 					  int tmp=arrayint[j-1];
 	    			 arrayint[j-1]=arrayint[j];
 	    			 arrayint[j]=tmp;
				   }
 			   }
 		   }
	   } 
	  //ݔ������ĺ���
	  public static void main(String[] args) {
		paixu();
	   for(int i=0;i<arrayint.length;i++){
		System.out.println(arrayint[i]);
     	}
	}

	
}
