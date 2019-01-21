package cxfq;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.List;


public abstract class TestBase {
	@Autowired
	private HttpSession session;


	@Before
	public void init(){
		/*List<BMember> bMembers = memberMapper.selectByExample(new BMemberExample());
		String userid = bMembers.get(0).getbMemberid();
		session.setAttribute("userID",userid);*/
	}

	public ApplicationContext getContext(){
		String[] conf = {"config/spring-db.xml","config/spring-mvc.xml","config/spring-mybatis.xml",
				"config/spring-bean.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		return ac;
	}

}
