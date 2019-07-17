package com.mysheng.office.util;

import java.util.regex.Pattern;

public class RegexUtils {
    /**
     * 验证中文
     * @param chinese 中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex,chinese);
    }

    /**
     * 验证英文
     * @param letter
     * @return
     */
    public static boolean checkLetter(String letter) {
        String regex = "^[a-zA-Z]+$";
        return Pattern.matches(regex,letter);
    }
}
