package com.mysheng.office.service.impl;

import com.mysheng.office.model.Goods;
import com.mysheng.office.service.GoodsService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadImage {
    private String imagePath;
    private String compressImage;
    private String imgUrl;
    @Autowired
    private GoodsService goodsService;
    public boolean imageUpload( int goodsId,MultipartFile[] file){

        imgUrl=goodsService.findGoodsImageUrl(goodsId);
            if("null".equals(imgUrl)){
                int num=imgUrl.split(",").length-1;
                if(num>5){
                    imgUrl="";
                }
            }


        for (int i=0;i<file.length;i++){

            String fileName = file[i].getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            imagePath = "/Users/mayansheng/";

            fileName = System.currentTimeMillis()+i + suffixName;
            File dest = new File(imagePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file[i].transferTo(dest);
                compressImage = "/Users/mayansheng/mysheng/";
                File dest2 = new File(compressImage + fileName);
                if (!dest2.getParentFile().exists()) {
                    dest2.getParentFile().mkdirs();
                }
                Thumbnails.of(dest).scale(0.5).outputQuality(1f).toFile(dest2);

            } catch (IllegalStateException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

            imgUrl+=fileName+",";
        }


        Goods goods=new Goods();
        goods.setGoodsId(goodsId);
        goods.setImageUrl(imgUrl);
        goodsService.updateGoods(goods);
        return true;
    }
}
