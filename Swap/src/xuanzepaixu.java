import javax.print.attribute.standard.MediaName;

/**
 * �x������
 * ԭ�������x�ų���С�����x
 * @author Jay-Tang
 *
 */
public class xuanzepaixu {
     static int[] arrayint ={12,23,223,11,22};
	
     //���ѭ�h
     public static void paixu(){
    	 //
    	 for(int i=0;i<arrayint.length;i++){
    		 for(int j=i+1;j<arrayint.length;j++){
    			 //����ȵ�n��С
    		 if (arrayint[i]>arrayint[j]) {
    			 int tmp=arrayint[i];
    			 arrayint[i]=arrayint[j];
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
