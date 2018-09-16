package com.mysheng.office.mapper;

import com.mysheng.office.model.ChatModel;
import com.mysheng.office.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MessageMapper {
    /**
     * 查询全部用户
     *
     * @return
     */
    List<ChatModel> queryChatModel();

    /**
     * 根据信息id查询消息
     * @param mesId
     * @return
     */
    Goods queryChatModelById(int mesId);

    /**
     * 新增用户
     * @param chatModel
     * @return
     */
    int insertMessage(ChatModel chatModel);

}
