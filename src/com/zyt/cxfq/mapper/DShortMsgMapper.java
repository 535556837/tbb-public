package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DShortMsg;
import com.zyt.cxfq.model.DShortMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DShortMsgMapper {
    /**
     *
     * @mbggenerated 2019-01-11
     */
    int countByExample(DShortMsgExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int deleteByExample(DShortMsgExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int deleteByPrimaryKey(String tMessagemanagerid);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int insert(DShortMsg record);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int insertSelective(DShortMsg record);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    List<DShortMsg> selectByExample(DShortMsgExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    DShortMsg selectByPrimaryKey(String tMessagemanagerid);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") DShortMsg record, @Param("example") DShortMsgExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int updateByExample(@Param("record") DShortMsg record, @Param("example") DShortMsgExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int updateByPrimaryKeySelective(DShortMsg record);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int updateByPrimaryKey(DShortMsg record);
}