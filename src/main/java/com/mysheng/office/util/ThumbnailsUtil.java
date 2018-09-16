package com.mysheng.office.util;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ThumbnailsUtil {
    /**
     *  @param oldPath 原图片路径
     * @param newOld  压缩后的图片路径
     * @param scale  大小缩放 0～1，1表示不缩放
     * @param quality 图片质量 0～1 越接近1的质量越好
     */
    public static  void imageCompress(String oldPath, String newOld, float scale, float quality){
        try {
            Thumbnails.of(oldPath).scale(1f).outputQuality(quality).toFile(newOld);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param oldPath 原图片路径
     * @param newOld  新图片路径
     * @param width   宽度
     * @param height  高度
     */
    public static void scaleSize(File oldPath,String newOld,int width,int height){
        try {
            Thumbnails.of(oldPath).scale(width,height).toFile(oldPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean compressPic(String inputFile, String outputFile, int size, float quality) {
        File input = new File(inputFile);
        try {
            Thumbnails.Builder<File> fileBuilder = Thumbnails.of(input).scale(1.0).outputQuality(1.0);
            BufferedImage src = fileBuilder.asBufferedImage();
            if(src.getHeight(null) > size || src.getWidth(null) > size) {
                Thumbnails.Builder<File> builder = Thumbnails.of(input);
                builder.size(size, size); //取最大的尺寸变成size，然后等比缩放
                builder.outputQuality(quality).toFile(outputFile);
            } else {
                Thumbnails.of(input).scale(1.0).outputQuality(quality).toFile(outputFile);
            }
            return true;
        } catch (IOException e) {
           e.printStackTrace();
        }
        return false;
    }
}
