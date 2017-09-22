package com.nms.core.util;

import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.nms.core.util.kit.HashKit;

/**
 * 3DES加解密工具类
 * @author cja
 * @date 2017年9月21日
 */
public class Des3Util {
	
	private static final String ALGORITHM = "DESede";//加密算法，可用DES,DESede,Blowfish
	
	/**
	 * 数据流加密
	 * @param des3Key
	 * @param outputStream
	 * @return
	 * @throws Exception
	 */
	public static OutputStream encStream(String des3Key,OutputStream outputStream) throws Exception{
		OutputStream os = null;
		try{
			SecretKey secretKey = new SecretKeySpec(des3Key.getBytes(), ALGORITHM);//生成密钥
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			os = new CipherOutputStream(outputStream, cipher);
		}catch(Exception e){
			e.printStackTrace();
		}
		return os;
	}
	
	/**
	 * 数据流解密
	 * @param des3Key
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	public static InputStream decStream(String des3Key,InputStream inputStream) throws Exception{
		InputStream is = null;
		try{
			SecretKey secretKey = new SecretKeySpec(des3Key.getBytes(), ALGORITHM);//生成密钥
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			is = new CipherInputStream(inputStream, cipher);
		}catch(Exception e){
			e.printStackTrace();
		}
		return is;
	}
	
	/**
	 * 字符串加密
	 * @param des3Key
	 * @param src
	 * @return Base64编码byte[]
	 * @throws Exception
	 */
	public static String encString(String des3Key,String src) {
		String s = "";
		try{
			SecretKey secretKey = new SecretKeySpec(des3Key.getBytes(), ALGORITHM);//生成密钥
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] b = cipher.doFinal(src.getBytes("UTF-8"));
			s = new String(Base64.encodeBase64(b));
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * 字符串解密
	 * @param des3Key
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public static String decString(String des3Key,String src) {
		String s = "";
		try{
			SecretKey secretKey = new SecretKeySpec(des3Key.getBytes(), ALGORITHM);//生成密钥
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] b = cipher.doFinal(Base64.decodeBase64(src));
			s = new String(b,"UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		String des3Key = "123456781234567812345678";//DESede算法密钥长度必须是24
		String src = "abc呵呵";
		System.out.println("HASH后："+HashKit.sha256(src));
		String encStr = Des3Util.encString(des3Key, HashKit.sha256(src));
		System.out.println("加密后："+encStr);
		String decStr = Des3Util.decString(des3Key, encStr);
		System.out.println("解密后："+decStr);
	}

}
