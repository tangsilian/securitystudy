package readapkfile;
import java.io.File;  
import java.text.SimpleDateFormat;
import java.util.ArrayList;  
import java.util.List; 
import java.util.Scanner;
public class Readapkfile {
	static int pathlevel=0;
//��дһ��������ȡ�ļ�
	private static void readdir(String  filepathString) {
       //�½�һ���ļ�
		File file=null;
		file=new File(filepathString);
		File[] files = file.listFiles();//�õ�����files�ļ��A������ļ�
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
	   //�޸�ʱ���ʽ
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	   String time = sdf.format(list2.get(i).lastModified());  
	System.out.println(list2.get(i)+":�����޸�ʱ��Ϊ"+time);
   }
	}
	
	
	public static void main(String[] args) {
		System.out.println("ݔ���ļ���Ŀ�\n");
		//ݔ��
		Scanner scan=new Scanner(System.in);
		String filepathString=scan.next();
		readdir(filepathString);
    }

}
