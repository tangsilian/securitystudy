package com.plug;

import com.plug.InterfacePlug;
    public class PlugImpl  implements InterfacePlug{
        @Override
        public String function_01() {
            return null;
        }

        @Override
        public int function_02(int a, int b) {
            return a+b;
        }
        public static void main(String[] args) {
			PlugImpl plugImpl=new PlugImpl();
        	InterfacePlug interfacePlug=plugImpl;
			System.out.println(interfacePlug.function_02(1, 2));
		}
    }