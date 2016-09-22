import javax.print.attribute.standard.MediaName;

/**
 * 選擇排序
 * 原理是先選排出最小的再選
 * @author Jay-Tang
 *
 */
public class xuanzepaixu {
     static int[] arrayint ={12,23,223,11,22};
	
     //外層循環
     public static void paixu(){
    	 //
    	 for(int i=0;i<arrayint.length;i++){
    		 for(int j=i+1;j<arrayint.length;j++){
    			 //如果比第n個小
    		 if (arrayint[i]>arrayint[j]) {
    			 int tmp=arrayint[i];
    			 arrayint[i]=arrayint[j];
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
