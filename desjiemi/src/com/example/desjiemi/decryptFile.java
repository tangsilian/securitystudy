package com.example.desjiemi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import android.content.res.AssetManager;

public class decryptFile {
	String password = "dangdang";
	static MainActivity context;

	public static void main(String[] args) {
		String content = "DESTest";
		// ���볤�ȱ�����8�ı���
		String password = "12345678";
		System.out.println("�ܡ�Կ��" + password);
		System.out.println("����ǰ��" + content);
		System.out.println("���ܺ�" + new String(makefile()));
		String decryResult = decrypt(makefile(), password);
		System.out.println("���ܺ�" + decryResult);
	}

	/**
	 * �ȴ�asset�ļ�
	 */
	AssetManager m_assetManager = context.getResources().getAssets();
	public static byte[] makefile() {
		String line="";
        String Result="";  
		try { 
              InputStreamReader inputReader = new InputStreamReader( context.getResources().getAssets().open("wuhahah.data.data") ); 
             BufferedReader bufReader = new BufferedReader(inputReader);
             while((line = bufReader.readLine()) != null)
                 Result += line;
             return Result.getBytes();
         } catch (Exception e) { 
             e.printStackTrace(); 
         }
		return Result.getBytes();
	}
	

	/**
	 * ����
	 * 
	 * @param content
	 *            ����������
	 * @param key
	 *            ���ܵ���Կ
	 * @return
	 */
	public static String decrypt(byte[] content, String key) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, securekey, random);
			byte[] result = cipher.doFinal(content);
			return new String(result);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

}
