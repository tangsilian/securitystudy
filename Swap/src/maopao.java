import javax.xml.transform.Templates;


/**
 * ���µ�����
 * @author Jay-Tang
 *
 */
public class maopao {
	//����
	static int [] intarray={12,232,23,232,32,32};
	
	//
public static void main(String[] args) {

	//�������ѭ�h
	for(int i=0;i<intarray.length;i++){
	//�ȴ�ѭ�h  �������һ�������Q ע�┵�MԽ��Ć��}   
		for(int j=intarray.length-1;j>0;j--){
			if (intarray[j-1]>intarray[j]) {
				int tmp=intarray[j-1];
				intarray[j-1]=intarray[j];
				intarray[j]=tmp;
			}
		}
}
for(int i=0;i<intarray.length;i++){
	System.out.println(intarray[i]);
}
}
}
