package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DQuoteDtl;
import com.zyt.cxfq.model.DQuoteDtlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DQuoteDtlMapper {
    /**
     *
     * @mbggenerated 2019-01-17
     */
    int countByExample(DQuoteDtlExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int deleteByExample(DQuoteDtlExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int deleteByPrimaryKey(String quoteDelId);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int insert(DQuoteDtl record);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int insertSelective(DQuoteDtl record);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    List<DQuoteDtl> selectByExample(DQuoteDtlExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    DQuoteDtl selectByPrimaryKey(String quoteDelId);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByExampleSelective(@Param("record") DQuoteDtl record, @Param("example") DQuoteDtlExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByExample(@Param("record") DQuoteDtl record, @Param("example") DQuoteDtlExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByPrimaryKeySelective(DQuoteDtl record);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByPrimaryKey(DQuoteDtl record);
}