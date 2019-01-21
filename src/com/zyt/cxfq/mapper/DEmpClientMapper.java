package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DEmpClient;
import com.zyt.cxfq.model.DEmpClientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DEmpClientMapper {
    /**
     *
     * @mbggenerated 2019-01-16
     */
    int countByExample(DEmpClientExample example);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    int deleteByExample(DEmpClientExample example);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    int deleteByPrimaryKey(String empClientId);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    int insert(DEmpClient record);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    int insertSelective(DEmpClient record);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    List<DEmpClient> selectByExample(DEmpClientExample example);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    DEmpClient selectByPrimaryKey(String empClientId);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    int updateByExampleSelective(@Param("record") DEmpClient record, @Param("example") DEmpClientExample example);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    int updateByExample(@Param("record") DEmpClient record, @Param("example") DEmpClientExample example);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    int updateByPrimaryKeySelective(DEmpClient record);

    /**
     *
     * @mbggenerated 2019-01-16
     */
    int updateByPrimaryKey(DEmpClient record);
}