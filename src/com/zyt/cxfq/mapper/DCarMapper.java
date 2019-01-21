package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DCar;
import com.zyt.cxfq.model.DCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DCarMapper {
    /**
     *
     * @mbggenerated 2019-01-17
     */
    int countByExample(DCarExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int deleteByExample(DCarExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int deleteByPrimaryKey(String carId);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int insert(DCar record);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int insertSelective(DCar record);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    List<DCar> selectByExample(DCarExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    DCar selectByPrimaryKey(String carId);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByExampleSelective(@Param("record") DCar record, @Param("example") DCarExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByExample(@Param("record") DCar record, @Param("example") DCarExample example);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByPrimaryKeySelective(DCar record);

    /**
     *
     * @mbggenerated 2019-01-17
     */
    int updateByPrimaryKey(DCar record);
}