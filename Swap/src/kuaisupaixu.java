
public class kuaisupaixu {
	//һ�����M
	static int [] intarray={12,232,23,232,32,32};
    //�Д��Ƿ���
	public static boolean  isEmpty(int[] n){
		return n==null||n.length==0;	
    }
	public static void quicksort(int [] n){
		if (isEmpty(n)) {
			return;
		}
		quicksort(n,0,n.length-1);
		
	}
	private static void quicksort(int[] n, int l, int h) {
		if (isEmpty(n)) {
			return;
		}
		if (l<h) {
			//����pivot
			int pivot=partion(n,l,h);
			//�����һ��
			quicksort(n,l,pivot-1);
			//�����һ��
			quicksort(n,pivot+1,h);
		}
		
	}
	//�ų�����
	private static int partion(int[] n, int start, int end) {
	//����ʼ��λ����
		int tmp=n[start];
	//����ʼֵС��end
		while(start<end){
		//�����һλ�����ڻ���  ����
			while(n[end]>=tmp&&start<end){
				//���һλ��ָ��ǰ��һλ
				end--;	}
               //���򽻻�λ��
				if (start<end) {
					n[start++]=n[end];
				}
				while(n[start]<tmp&&start<end){
				start++;
				}
				//���򽻻�λ��	
				if (start<end) {
					n[end]=n[start];
					end--;
				}
				}
				
		n[start]=tmp;	
		return start;

	}

	
	public static void main(String[] args) {
	quicksort(intarray);
	for(int i=0;i<intarray.length;i++){
		System.out.println(intarray[i]);
		
	}
}
	
	
}
