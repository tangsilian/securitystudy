/**
 * 插入排序
 * @author Jay-Tang
 *
 */
public class insertsort {
	
	   static int[] arrayint ={12,23,223,11,22};

	 
 	   private static void paixu() {
		//外層循環
 		   for(int i=0;i<arrayint.length-1;i++){
 			   for(int j=i+1; j>0; j-- ){
 				 while(arrayint[i+1]>arrayint[i]){
 					 break;
 				 }
 				   if (arrayint[j-1]>arrayint[j]) {
 					   //交換位置
 					  int tmp=arrayint[j-1];
 	    			 arrayint[j-1]=arrayint[j];
 	    			 arrayint[j]=tmp;
				   }
 			   }
 		   }
	   } 
	  //輸出排序的函數
	  public static void main(String[] args) {
		paixu();
	   for(int i=0;i<arrayint.length;i++){
		System.out.println(arrayint[i]);
     	}
	}

	
}
