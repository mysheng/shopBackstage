package com.mysheng.office.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ChatModel {
    public int mesId;//消息Id
    public  int mesType;//消息类型
    public int mesTime;//消息时长
    public  String IconPath;//  头像地址
    public  String content;//消息内容
    public String contentPath;//消息内容地址
    public String sendUser;//发送人
    public String receiveUser;//接收人
    public String mesStatus;//消息状态
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    public Date mesDate; //消息时间

    public int getMesId() {
        return mesId;
    }

    public void setMesId(int mesId) {
        this.mesId = mesId;
    }

    public int getMesType() {
        return mesType;
    }

    public void setMesType(int mesType) {
        this.mesType = mesType;
    }

    public int getMesTime() {
        return mesTime;
    }

    public void setMesTime(int mesTime) {
        this.mesTime = mesTime;
    }

    public String getIconPath() {
        return IconPath;
    }

    public void setIconPath(String iconPath) {
        IconPath = iconPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public String getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser;
    }

    public String getMesStatus() {
        return mesStatus;
    }

    public void setMesStatus(String mesStatus) {
        this.mesStatus = mesStatus;
    }

    public Date getMesDate() {
        return mesDate;
    }

    public void setMesDate(Date mesDate) {
        this.mesDate = mesDate;
    }
}
