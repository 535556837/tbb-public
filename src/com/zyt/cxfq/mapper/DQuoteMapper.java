package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DQuote;
import com.zyt.cxfq.model.DQuoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DQuoteMapper {
    /**
     *
     * @mbggenerated 2019-01-17
     */
    int countByExample(DQuoteExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int deleteByExample(DQuoteExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int deleteByPrimaryKey(String quoteId);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int insert(DQuote record);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int insertSelective(DQuote record);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    List<DQuote> selectByExample(DQuoteExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    DQuote selectByPrimaryKey(String quoteId);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByExampleSelective(@Param("record") DQuote record, @Param("example") DQuoteExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByExample(@Param("record") DQuote record, @Param("example") DQuoteExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByPrimaryKeySelective(DQuote record);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByPrimaryKey(DQuote record);
}