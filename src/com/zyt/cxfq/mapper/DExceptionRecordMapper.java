package com.zyt.cxfq.mapper;

import com.zyt.cxfq.model.DExceptionRecord;
import com.zyt.cxfq.model.DExceptionRecordExample;
import com.zyt.cxfq.model.DExceptionRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DExceptionRecordMapper {
    /**
     *
     * @mbggenerated 2019-01-10
     */
    int countByExample(DExceptionRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int deleteByExample(DExceptionRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int deleteByPrimaryKey(String exceptionrecordid);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int insert(DExceptionRecordWithBLOBs record);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int insertSelective(DExceptionRecordWithBLOBs record);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    List<DExceptionRecordWithBLOBs> selectByExampleWithBLOBs(DExceptionRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    List<DExceptionRecord> selectByExample(DExceptionRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    DExceptionRecordWithBLOBs selectByPrimaryKey(String exceptionrecordid);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int updateByExampleSelective(@Param("record") DExceptionRecordWithBLOBs record, @Param("example") DExceptionRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int updateByExampleWithBLOBs(@Param("record") DExceptionRecordWithBLOBs record, @Param("example") DExceptionRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int updateByExample(@Param("record") DExceptionRecord record, @Param("example") DExceptionRecordExample example);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int updateByPrimaryKeySelective(DExceptionRecordWithBLOBs record);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int updateByPrimaryKeyWithBLOBs(DExceptionRecordWithBLOBs record);

    /**
     *
     * @mbggenerated 2019-01-10
     */
    int updateByPrimaryKey(DExceptionRecord record);
}