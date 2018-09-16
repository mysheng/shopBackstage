package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.MessageMapper;
import com.mysheng.office.model.ChatModel;
import com.mysheng.office.model.Goods;
import com.mysheng.office.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;


    @Override
    public List<ChatModel> queryChatModel() {
//        Map<String, Object> data = new HashMap<>();
//        data.put("currIndex", currPage-1);
//        data.put("pageSize", pageSize);
        return messageMapper.queryChatModel();
    }



    @Override
    public int insertMessage(ChatModel chatModel) {
        return messageMapper.insertMessage(chatModel);
    }
}
