package com.zyt.cxfq.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;


//import org.apache.catalina.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyt.cxfq.util.BusinessException;
import com.zyt.cxfq.util.EncryptUntil;







/**
 * 
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * 
 * shiro 认证 + 授权   重写
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年6月2日 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0,2016年6月2日 <br/>
 * 
 */
public class SampleRealm extends AuthorizingRealm {

	
/*	@Autowired
	BMemberService userService;*/
	/*@Autowired
	SysMenuService2 sysMenuService;*/
	
	 @Autowired
	    private HttpSession session;

	
	public SampleRealm() {
		super();
	}
	/**
	 *  认证信息，主要针对用户登录， 
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		
		/*	UsernamePasswordToken  token =(UsernamePasswordToken) authcToken;
			 Subject subject = SecurityUtils.getSubject();
			//通过token获取用户信息,这里我们一般从数据库中查询  
			String name =(String) token.getUsername();
			String password =EncryptUntil.md5(new String(token.getPassword()));//调用转码工具 转为数据库字段。
			
			BMemberExample example =  new BMemberExample();
            example.createCriteria().andPhoneEqualTo(StringUtils.trim(name));
            BMember bmember =  bMemberMapper.selectByExample(example).get(0);//得到用户
           
			if(null == bmember){
				throw new BusinessException("帐号不存在！");
				
			}else if (!password.equals(bmember.getPassword())){
                throw new BusinessException("密码不正确！");
            }
			
			else{				
				return new SimpleAuthenticationInfo(bmember,token.getPassword(), getName());
			}*/	//需要shiro 再实现
			return  null;
    }

	 /** 
     * 授权 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
    	/*    	
    	Long userId = TokenManager.getUserId();

		//根据用户ID查询角色（role），放入到Authorization里。
		Set<String> roles = roleService.findRoleByUserId(userId);
		info.setRoles(roles);
		//根据用户ID查询权限（permission），放入到Authorization里。
		Set<String> permissions = permissionService.findPermissionByUserId(userId);
		info.setStringPermissions(permissions);
        return info;  */
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		// String phone = WxTokenManagerCache.getToken().getbMemberid(); 换成下面这种获取用户id
		/*BMember bMember = (BMember) principals.fromRealm(this.getClass().getName()).iterator().next();
		String memberid = bMember.getbMemberid();*/
		System.out.println("通过了认证方法");
		List<String> slist =new ArrayList<String>();
/*	========	List<String> slist =sysMenuService.findPermissionByUserId();*/
		info.addStringPermissions(slist); 
		
		 /*List<String> rolse=sysMenuService.GetroleByuserid();
		 System.out.println( "==============="+rolse);
		 info.addRoles(rolse);
 	     if(rolse.size()!=0){
 	    	 List<String> menus=sysMenuService.GetMenusByRoleIDs(rolse);
 	 	    if(menus.size()!=0){
 	 	    	List<String> pages=sysMenuService.GetMenuURLByMenuIDs(menus);
 	 	    	for(String meu:pages ){
 	 	    		if(meu!=null&&!"".equals(meu)){
 	 	    			info.addStringPermission(meu);
 	 	    		} 	 	  
 	 	    	}
 	 	    	
 	 	    }
 	    }*/
 	   
	
		return info;
    }  
    /**
     * 清空当前用户权限信息
     */
	public  void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
	 * 指定principalCollection 清除
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
}
