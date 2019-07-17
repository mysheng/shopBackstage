package com.mysheng.office.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {
    private static String token = "WnbVm6GTQj4BPmLliSday4K";//这里是自定义的token，需和你提交的token一致

         public static boolean checkSignature(String signature, String timestamp, String nonce) {
             String checktext = null;
            if (null != signature) {
                   // 对ToKen,timestamp,nonce 按字典排序
                  String[] paramArr = new String[] { token, timestamp, nonce };
                    Arrays.sort(paramArr);
                     // 将排序后的结果拼成一个字符串
                     String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

                   try {
                           MessageDigest md = MessageDigest.getInstance("SHA-1");
                           // 对接后的字符串进行sha1加密
                             byte[] digest = md.digest(content.toString().getBytes());
                            checktext = byteToStr(digest);
                         } catch (NoSuchAlgorithmException e) {
                          e.printStackTrace();
                       }
                }
           // 将加密后的字符串与signature进行对比
          return checktext != null ? checktext.equals(signature.toUpperCase()) : false;
        }

        private static String byteToStr(byte[] byteArrays) {
            String str = "";
            for (int i = 0; i < byteArrays.length; i++) {
                     str += byteToHexStr(byteArrays[i]);
            }
            return str;
         }

        private static String byteToHexStr(byte myByte) {
            char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
            char[] tampArr = new char[2];
            tampArr[0] = Digit[(myByte >>> 4) & 0X0F];
            tampArr[1] = Digit[myByte & 0X0F];
            String str = new String(tampArr);
            return str;
        }

}
