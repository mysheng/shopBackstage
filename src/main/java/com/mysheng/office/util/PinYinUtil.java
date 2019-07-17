package com.mysheng.office.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PinYinUtil {

    /**
     * 获取字符串拼音的第一个字母
     * @param chinese
     * @return
     */
    public static String toFirstCharFirst(String chinese){
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();  //转为单个字符
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        if (newChar[0] > 128 &&String.valueOf(newChar[0]).matches("[\u4e00-\u9fa5]+")) {
            try {
                pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[0], defaultFormat)[0].charAt(0);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else{
            pinyinStr += newChar[0];
        }

        return pinyinStr.toUpperCase();
    }
    /**
     * 获取字符串拼音的第一个字母
     * @param chinese
     * @return
     */
    public static String toFirstChar(String chinese){
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();  //转为单个字符
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128 &&String.valueOf(newChar[i]).matches("[\u4e00-\u9fa5]+")) {
                try {
                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else{
                pinyinStr += newChar[i];
            }
        }
        return pinyinStr.toUpperCase();
    }

    /**
     * 汉字转为拼音
     * @param chinese
     * @return
     */
    public static String toPinyin(String chinese){
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0];
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            }else{
                pinyinStr += newChar[i];
            }
        }
        return pinyinStr.toUpperCase();
    }


    public static  void randomB(BigDecimal count, BigDecimal price){
        //已砍价格的集合
        List<BigDecimal> alreadyList = new ArrayList<>();
        //已砍的钱的总和
        BigDecimal alreadyCut = BigDecimal.ZERO;
        for(int i = 0;i<count.intValue();i++){
            //此次砍价的最低钱数（总价-已砍总价/总次数-已砍次数）（相当于是向上随机）（转换为单位分）
            Integer min = (price.subtract(alreadyCut)).divide(count.subtract(new BigDecimal(alreadyList.size())),2,BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            System.out.println("min:"+min);
            //此次砍价的最高钱数（最低价格的2倍）
            //这个倍数越高，砍价的幅度跳动越大。建议设置到1-2.（不能超过2.因为有可到导致总刀数不准确）
            Integer max = min*2;
            //此次砍的价格（最低钱数到最高钱数的随机）
            BigDecimal cutPrice = new BigDecimal(min + new Random().nextInt(max-min)).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_UP);
            System.out.println("cutPrice:"+cutPrice);
            //最后一刀保证价格准确
            if(i==count.intValue()-1){
                cutPrice = price.subtract(alreadyCut);
            }
            alreadyCut = alreadyCut.add(cutPrice);
            alreadyList.add(cutPrice);
        }
        System.out.println(alreadyCut);
        System.out.println(alreadyList.size());
    }
    //测试
    public static void main(String[] args) {
//        System.out.println("全屏:"+toFirstChar("杨娜娜"));
//        System.out.println("缩写:"+toFirstCharFirst("杨娜娜"));
//        System.out.println("缩写:"+toPinyin("杨娜娜"));
        BigDecimal num1 = new BigDecimal(20);
        BigDecimal num2 = new BigDecimal(   299);
        randomB(num1,num2);
    }
}
