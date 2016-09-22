
public class kuaisupaixu {
	//一個數組
	static int [] intarray={12,232,23,232,32,32};
    //判斷是否為空
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
			//基质pivot
			int pivot=partion(n,l,h);
			//正向比一次
			quicksort(n,l,pivot-1);
			//反向比一次
			quicksort(n,pivot+1,h);
		}
		
	}
	//排出基质
	private static int partion(int[] n, int start, int end) {
	//以起始点位基质
		int tmp=n[start];
	//当初始值小于end
		while(start<end){
		//当最后一位数大于基数  不变
			while(n[end]>=tmp&&start<end){
				//最后一位的指针前移一位
				end--;	}
               //否则交换位置
				if (start<end) {
					n[start++]=n[end];
				}
				while(n[start]<tmp&&start<end){
				start++;
				}
				//否则交换位置	
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
