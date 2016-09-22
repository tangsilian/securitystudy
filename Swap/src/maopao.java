import javax.xml.transform.Templates;


/**
 * 從下到大排
 * @author Jay-Tang
 *
 */
public class maopao {
	//数组
	static int [] intarray={12,232,23,232,32,32};
	
	//
public static void main(String[] args) {

	//排序外層循環
	for(int i=0;i<intarray.length;i++){
	//內存循環  如果比下一個大就替換 注意數組越界的問題   
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
