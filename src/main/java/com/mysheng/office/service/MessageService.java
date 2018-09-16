package com.mysheng.office.service;

import com.mysheng.office.model.ChatModel;
import com.mysheng.office.model.Goods;

import java.util.List;

public interface MessageService {
    /**
     * 查询聊天信息
     *
     * @return
     */
    List<ChatModel> queryChatModel();


    /**
     * 新增用户
     * @param chatModel
     * @return
     */
    int insertMessage(ChatModel chatModel);

}
