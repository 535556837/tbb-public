package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DClient;
import com.zyt.cxfq.model.DClientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DClientMapper {
    /**
     *
     * @mbggenerated 2019-01-14
     */
    int countByExample(DClientExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int deleteByExample(DClientExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int deleteByPrimaryKey(String clientId);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int insert(DClient record);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int insertSelective(DClient record);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    List<DClient> selectByExample(DClientExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    DClient selectByPrimaryKey(String clientId);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int updateByExampleSelective(@Param("record") DClient record, @Param("example") DClientExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int updateByExample(@Param("record") DClient record, @Param("example") DClientExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int updateByPrimaryKeySelective(DClient record);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int updateByPrimaryKey(DClient record);
}