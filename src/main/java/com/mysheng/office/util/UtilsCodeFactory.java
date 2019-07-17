package com.mysheng.office.util;

import com.mysheng.office.aspect.HttpAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UtilsCodeFactory {


    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    /** 订单类别头 */
    private static final String ORDER_CODE = "1";
    /** 退货类别头 */
    private static final String RETURN_ORDER = "2";
    /** 退款类别头 */
    private static final String REFUND_ORDER = "3";
    /** 未付款重新支付别头 */
    private static final String AGAIN_ORDER = "4";
    /** 随即编码 */
    private static final int[] r = new int[]{7, 9, 6, 2, 8 , 1, 3, 0, 5, 4};
    /** 用户id和随机数总长度 */
    private static final int maxLength = 14;//14
    
    /**
      * 更具id进行加密+加随机数组成固定长度编码
      */
    private static String toCode(String idStr) {
        StringBuilder idsb = new StringBuilder();
        for (int i = idStr.length() - 1 ; i >= 0; i--) {
            idsb.append(r[idStr.charAt(i)-'0']);
        }

//        logger.info("手机号加密:"+idsb);
//        logger.info("随机生成码："+getRandom(maxLength - idStr.length())+"");
//        logger.info("手机号+加随机号:"+idsb.append(getRandom(maxLength - idStr.length())).toString());
        return idsb.append(getRandom(maxLength - idStr.length())).toString();
    }
     
    /**
     * 生成时间戳
     */
    private static String getDateTime(){
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }
    /**
     * 生成日期
     */
    private static String getDate(){
        DateFormat sdf = new SimpleDateFormat("yyyyssSSS");
        return sdf.format(new Date());
    }
    
     /**
      * 生成固定长度随机码
      * @param n    长度
      */
    private static long getRandom(long n) {
        long min = 1,max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min ;
        return rangeLong;
    }
    
    /**
      * 生成不带类别标头的编码
      * @param userId
      */
    private static synchronized String getCode(String userId){
        return getDateTime() + toCode(userId);
    }
    /**
     * 生成店铺编码
     * @param userId
     */
    private static synchronized String getShopCode(String userId){
        return getDate() + toCode(userId);
    }
    /**
     * 生成店铺编码
     * @param userId
     */
    public static String getShopCodeNum(String userId){
        return getShopCode(userId);
    }
    /**
      * 生成订单单号编码
      * @param userId
      */
    public static String getOrderCode(String userId){
        return ORDER_CODE + getCode(userId);
    }
    
    /**
      * 生成退货单号编码
      * @param userId
      */
    public static String getReturnCode(String userId){
        return RETURN_ORDER + getCode(userId);
    }
    
    /**
      * 生成退款单号编码
      * @param userId
      */
    public static String getRefundCode(String userId){
        return REFUND_ORDER + getCode(userId);
    }
    
    /**
      * 未付款重新支付
      * @param userId
      */
    public static String getAgainCode(String userId){
        return AGAIN_ORDER + getCode(userId);
    }


    //测试
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            //String code=getShopCode("15701570988");
            String code=UUIDUtil.getUUID();
            logger.info(code);
        }



    }
}
