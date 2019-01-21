
package com.zyt.cxfq.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zyt.cxfq.common.entity.ExceptionData;
import com.zyt.cxfq.mapper.DExceptionRecordMapper;
import com.zyt.cxfq.model.DExceptionRecord;
import com.zyt.cxfq.model.DExceptionRecordExample;
import com.zyt.cxfq.model.DExceptionRecordWithBLOBs;
import com.zyt.cxfq.nativedao.CommonDao;
import com.zyt.cxfq.plugin.page.BootPage;

/**
 * Created by Ivan on 2017/7/19.
 */

@Controller
@RequestMapping("/ExceptionService")
public class ExceptionRecordAction extends BaseAction {
	
	@Autowired
	private DExceptionRecordMapper exceptionrecordMapper;
	@Autowired
    protected CommonDao commonDao;
	
	/**
	 * 进入页面跳转
	 * @return
	 */
	@RequestMapping("/list.html")
	public String Exceptionmain() {
		return "/server/sysexception";
	}
	
	/**
	 * 删除一条 错误信息
	 * @param exid 主键id
	 * @return 受影响行数  ，为0则失败。
	 */
	@ResponseBody
	@RequestMapping("/delExceptionById")
	public int delMeetingById(String exid) {
		return exceptionrecordMapper.deleteByPrimaryKey(exid);
	}
	/**
	 * 得到某条错误的具体信息
	 * @param exid 主键id
	 * @return exceptionrecord 类属性为
	 * 
	 */
	@ResponseBody
	@RequestMapping("/getExceptionById")
	public DExceptionRecordWithBLOBs getExceptionById(String exid) {
		DExceptionRecordWithBLOBs result = exceptionrecordMapper.selectByPrimaryKey(exid);
	/*		打开把 id改为 用户名 再传
	 * BMember b=  bMemberMapper.selectByPrimaryKey(result.getMeetmemberid());
		result.setMeetmemberid(b.getNickname());*/
		return result;
	}
	/**
	 * 模糊查询所有的ExceptionRecords
	 * @param page 	(offset :开始列-1   limit ：每页几行 )	分页对象     
	 * @return 格式示例：
	 */
	@ResponseBody
	@RequestMapping("/getExceptionRecords")
	public BootPage<DExceptionRecord> getLaterMeetings(BootPage<DExceptionRecord> page,DExceptionRecord example1 ) {
		DExceptionRecordExample example = new DExceptionRecordExample();
		DExceptionRecordExample.Criteria  criteria =  example.createCriteria();
		
		if (!StringUtils.isEmpty(example1.getBmemberid())) {			//用户id
			criteria.andBmemberidLike("%"+example1.getBmemberid()+"%");
		}
		if (!StringUtils.isEmpty(example1.getRequesturl())) {			//请求路径
			criteria.andRequesturlLike("%"+example1.getRequesturl()+"%");
		}
		if (!StringUtils.isEmpty(example1.getIpaddr())) {				//请求ip
			criteria.andIpaddrLike("%"+example1.getIpaddr()+"%");
		}
		if (!StringUtils.isEmpty(example1.getClassname())) {			//异常类型
			criteria.andClassnameLike("%"+example1.getClassname()+"%");
		}
		if (example1.getCreatetime()!=null) {//用户id
			criteria.andCreatetimeGreaterThanOrEqualTo(example1.getCreatetime());
		}
		example.setOrderByClause("createtime");
		int totals= exceptionrecordMapper.countByExample(example);
		example.setPage(page);
		
		List<DExceptionRecord> list =exceptionrecordMapper.selectByExample(example);
		
		page.setRows(list);
		page.setTotal(totals);
		
		return page;
	}
	
	
	/**
	 * 新模糊查询所有的ExceptionRecords
	 * @param page 	(offset :开始列-1   limit ：每页几行 )	分页对象     
	 * @return 格式示例：
	 */
	@ResponseBody
	@RequestMapping("/getExceptionsMohu")
	public  BootPage<ExceptionData> pagegetExceptionsMohu(BootPage<ExceptionData> page,
			ExceptionData example) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sqlid", "getExceptionMoho");
		//map.put("Phone", Phone);
		map.put("example",example);
		map.put("page", page);
		List<Map<String, Object>> sss = commonDao.GetListData(map);
		 List<ExceptionData> list  = new ArrayList<ExceptionData>();
		 for (Map<String, Object> map2 : sss) {
			list.add( JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(map2)), ExceptionData.class));
		} 
		page.setRows(list);
		
		return page;
	}

}