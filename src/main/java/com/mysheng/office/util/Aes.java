package com.mysheng.office.util;

import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密类
 * 
 * @author risenb-003
 * 
 */
public class Aes {

	private static String sKey = "1234567890123456";// 16位数字

	/**
	 * 
	 * @param sSrc
	 *            加密内容
	 * @param sKey
	 *            加密Key
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static String Encrypt(String sSrc) throws Exception {
		if (sKey == null) {
			System.out.print("Key不能为null");
			return null;
		}
		// 16位key
		if (sKey.length() != 16) {
			System.out.print("Key的长度不是16位");
			return null;
		}
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//
		IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes());
		String enString = byte2hex(encrypted).toLowerCase();// new
		enString = URLEncoder.encode(enString);
		return enString;// 加密
	}

	/**
	 * 解密
	 * 
	 * @param sSrc
	 *            要解密的内容
	 * @param sKey
	 * @return
	 * @throws Exception
	 */
	public static String Decrypt(String sSrcs) throws Exception {
		if (sKey == null) {
			System.out.print("Key不能为null");
			return null;
		}
		// 16位key
		if (sKey.length() != 16) {
			System.out.print("Key的长度不是16位");
			return null;
		}
		byte[] raw = sKey.getBytes("ASCII");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		// String deString = URLDecoder.decode(sSrc);
		byte[] encrypted1 = hex2byte(sSrcs);
		byte[] original = cipher.doFinal(encrypted1);
		String originalString = new String(original);
		return originalString;

	}

	public static byte[] hex2byte(String strhex) {
		if (strhex == null) {
			return null;
		}
		int l = strhex.length();
		if (l % 2 == 1) {
			return null;
		}
		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; i++) {
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
					16);
		}
		return b;
	}

	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		Aes aes = new Aes();
		String aa = aes.Encrypt("27");
		System.out.println("加密" + aa);

		String bb = aes.Decrypt("3b58b7d9ec3bc4bd43bb037104e2eb4a");
		System.out.println("解密" + bb);
		System.out.println(14*24*60*60);
	}
}