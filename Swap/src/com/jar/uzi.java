package com.jar;

import java.util.function.Function;

public class uzi  implements Interface {
	static uzi uzi1=new uzi();
	@Override
	public  String function_01() {
		// TODO Auto-generated method stub
		return "uzi";
	}

	  @Override
      public int function_02(int a, int b) {
          return a+b;
      }
	public static void main(String[] args) {
		//System.out.println(uzi1.function_01());
	}

}
