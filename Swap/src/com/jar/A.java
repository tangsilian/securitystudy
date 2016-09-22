package com.jar;

import java.util.Scanner;


public class A {
	public static void main(String[] args) {
		//日期
		Scanner in = new Scanner(System.in);
		//int对象
		Integer n = null;
	

		while((n = in.nextInt())!=null){
		//初始价格为1
		int price = 1;
		//从第二天开始
		int i=2;int j=3;
		//循环当天数小于输入日期 m++
		for(int m=1;m<n;m++){
			//如果是加的天数
			if(m==i){
				//价格减一
				price--;
				//时间改为第
				i=i+j;
				//加的天数加一
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