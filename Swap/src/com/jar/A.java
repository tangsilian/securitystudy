package com.jar;

import java.util.Scanner;


public class A {
	public static void main(String[] args) {
		//����
		Scanner in = new Scanner(System.in);
		//int����
		Integer n = null;
	

		while((n = in.nextInt())!=null){
		//��ʼ�۸�Ϊ1
		int price = 1;
		//�ӵڶ��쿪ʼ
		int i=2;int j=3;
		//ѭ��������С���������� m++
		for(int m=1;m<n;m++){
			//����Ǽӵ�����
			if(m==i){
				//�۸��һ
				price--;
				//ʱ���Ϊ��
				i=i+j;
				//�ӵ�������һ
				j++;
			}
			else{
			price++;
			}
		}
		System.out.println(price);
		
		}
	}
	
}