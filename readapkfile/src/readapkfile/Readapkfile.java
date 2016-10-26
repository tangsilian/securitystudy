package readapkfile;
import java.io.File;  
import java.text.SimpleDateFormat;
import java.util.ArrayList;  
import java.util.List; 
import java.util.Scanner;
public class Readapkfile {
	static int pathlevel=0;
//先写一个方法读取文件
	private static void readdir(String  filepathString) {
       //新建一個文件
		File file=null;
		file=new File(filepathString);
		File[] files = file.listFiles();//得到所有files文件夾下面的文件
		  List<File> list = new ArrayList<File>();  
		  List<File> list2 = new ArrayList<File>();  
		for (File zifile:files) {
			if (zifile.isFile()) {
				if(zifile.getName().endsWith(".apk")) {
					list2.add(zifile);
				}
				//list.add(zifile);
			}else {
				pathlevel++;
				readdir(zifile.getAbsolutePath());
			}
		}

   for (int i = 0; i < list2.size(); i++) {
	   //修改时间格式
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	   String time = sdf.format(list2.get(i).lastModified());  
	System.out.println(list2.get(i)+":最后的修改时间为"+time);
   }
	}
	
	
	public static void main(String[] args) {
		System.out.println("輸入文件的目錄\n");
		//輸入
		Scanner scan=new Scanner(System.in);
		String filepathString=scan.next();
		readdir(filepathString);
    }

}
