package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DQuoteRecord;
import com.zyt.cxfq.model.DQuoteRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DQuoteRecordMapper {
    /**
     *
     * @mbggenerated 2019-01-15
     */
    int countByExample(DQuoteRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    int deleteByExample(DQuoteRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    int deleteByPrimaryKey(String quoteRecordId);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    int insert(DQuoteRecord record);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    int insertSelective(DQuoteRecord record);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    List<DQuoteRecord> selectByExample(DQuoteRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    DQuoteRecord selectByPrimaryKey(String quoteRecordId);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    int updateByExampleSelective(@Param("record") DQuoteRecord record, @Param("example") DQuoteRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    int updateByExample(@Param("record") DQuoteRecord record, @Param("example") DQuoteRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    int updateByPrimaryKeySelective(DQuoteRecord record);

    /**
     *
     * @mbggenerated 2019-01-15
     */
    int updateByPrimaryKey(DQuoteRecord record);
}