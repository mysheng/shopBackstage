package com.mysheng.office.util;

import java.util.Date;

/**
 * 上传图片模型
 * @author Administrator
 * @param sesscess 上传状态 true或false
 * @param errorMsg 错误信息
 * @param url 图片访问路径
 * @param dir 图片保存路径
 * @param fileName 图片原名
 * @param height 图片高度
 * @param width 图片宽度
 * @param size 图片大小
 * @param createTime 上传时间
 */
public class Img {
	private Boolean sesscess;//是否上传成功
	
	private String errorMsg;//上传错误信息
	
	private String url;//文件访问
	
	private String dir;//文件存放路径
	
	private String fileName;//文件原名字
	
	private int height;//图片高  单位像素
	
	private int width;//图片宽度 单位像素
	
	private Long size;//文件大小
	
	private Date createTime;//上传时间
	
	private String thumbUrl;//缩略图url
	
	private int thumbHeight;//缩略图高度
	
	private int thumbWidth;//缩略图宽度 单位像素

	public Boolean getSesscess() {
		return sesscess;
	}

	public void setSesscess(Boolean sesscess) {
		this.sesscess = sesscess;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public int getThumbHeight() {
		return thumbHeight;
	}

	public void setThumbHeight(int thumbHeight) {
		this.thumbHeight = thumbHeight;
	}

	public int getThumbWidth() {
		return thumbWidth;
	}

	public void setThumbWidth(int thumbWidth) {
		this.thumbWidth = thumbWidth;
	}
	
}
