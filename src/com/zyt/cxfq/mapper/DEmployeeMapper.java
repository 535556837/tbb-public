package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.model.DEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DEmployeeMapper {
    /**
     *
     * @mbggenerated 2019-01-11
     */
    int countByExample(DEmployeeExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int deleteByExample(DEmployeeExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int deleteByPrimaryKey(String uId);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int insert(DEmployee record);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int insertSelective(DEmployee record);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    List<DEmployee> selectByExample(DEmployeeExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    DEmployee selectByPrimaryKey(String uId);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") DEmployee record, @Param("example") DEmployeeExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int updateByExample(@Param("record") DEmployee record, @Param("example") DEmployeeExample example);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int updateByPrimaryKeySelective(DEmployee record);

    /**
     *
     * @mbggenerated 2019-01-11
     */
    int updateByPrimaryKey(DEmployee record);
}