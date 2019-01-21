package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DCarOwner;
import com.zyt.cxfq.model.DCarOwnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DCarOwnerMapper {
    /**
     *
     * @mbggenerated 2019-01-14
     */
    int countByExample(DCarOwnerExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int deleteByExample(DCarOwnerExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int deleteByPrimaryKey(String carOwnersId);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int insert(DCarOwner record);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int insertSelective(DCarOwner record);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    List<DCarOwner> selectByExample(DCarOwnerExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    DCarOwner selectByPrimaryKey(String carOwnersId);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int updateByExampleSelective(@Param("record") DCarOwner record, @Param("example") DCarOwnerExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int updateByExample(@Param("record") DCarOwner record, @Param("example") DCarOwnerExample example);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int updateByPrimaryKeySelective(DCarOwner record);

    /**
     *
     * @mbggenerated 2019-01-14
     */
    int updateByPrimaryKey(DCarOwner record);
}