package com.zyt.cxfq.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zyt.cxfq.common.interceptor.CheckLoginInterceptor;
import com.zyt.cxfq.common.util.CommonMethod;
import com.zyt.cxfq.common.util.ConfigManager;
import com.zyt.cxfq.nativedao.CommonDao;
import com.zyt.cxfq.nativedao.Data;
import com.zyt.cxfq.nativedao.XmlPaser;
import com.zyt.cxfq.plugin.page.BootPage;
import com.zyt.cxfq.util.BusinessException;
import com.zyt.cxfq.util.EncryptUntil;

/**
 * @Package com.casit.web.comm 
 * @ClassName: CommonAction 
 * @Description:
 * @author 黄胜  hs 
 * @date 2016年7月5日 上午11:55:03 
 *
 */
@Controller
@RequestMapping(value="/commonAction")
public class CommonAction extends BaseAction {

	@Autowired
	private HttpSession session;
	
	
	private static List<Data> cachelist;
	
	@RequestMapping("/getSessionId")
	@ResponseBody
	public String getSessionId() {
		Object sessionId = session.getAttribute(CheckLoginInterceptor.SESSION_ID);
		if (sessionId == null || "".equals(sessionId) || "null".equals(sessionId)) {
			return UUID.randomUUID().toString();
		} else {
			return sessionId.toString();
		}
	}

	@RequestMapping("/GetSqlList")
	@ResponseBody
	public List<Data> GetSqlList(@RequestParam Map<String, Object>  map) throws Exception {	
		

		
		if(map.get("cache")==null){
			List<String>  names=XmlPaser.getXMLnames();	
		    List<Data> list=XmlPaser.getShowMethods(names.toArray(new String[names.size()]));	//list 转为数组传入方法
		    cachelist=list;
		}
		if(cachelist==null){
			List<String>  names=XmlPaser.getXMLnames();	
		    List<Data> list=XmlPaser.getShowMethods(names.toArray(new String[names.size()]));	//list 转为数组传入方法
		    cachelist=list;
		}

		List<Data> ret=cachelist.stream().collect(Collectors.toList());
		
	    if(map.get("classname")!=null){
	    	ret=ret.stream().filter(m->m.getClassname().contains(map.get("classname").toString())).collect(Collectors.toList());
	    }
	    
	    if(map.get("id")!=null){
	    	ret=ret.stream().filter(m->m.getId().contains(map.get("id").toString())).collect(Collectors.toList());
	    }
	    

		return ret;
	}

	 
	/**
	 * @Title: download 
	 * @Description:下载文件
	 * @param fileName
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @author 黄胜  hs  
	 * @date 2016年7月5日 下午7:49:46
	 */
	@RequestMapping("/download")
 	public String download(String fileName, String filePath, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("fileName:"+ fileName + "     filePath:"+filePath);
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
		
		String ctxPath = ConfigManager.getInstance().getValue("filedir");// request.getSession().getServletContext().getRealPath(   "/") ;
		File f=new File(ctxPath + "/" + filePath);
		long len=f.length();
		response.setContentLength((int) len);
		InputStream inputStream = new FileInputStream(f);
//		InputStream inputStream = new FileInputStream(new File(ctxPath + filePath));



		OutputStream os = response.getOutputStream();
		byte[] b = new byte[2048];
		int length;
		while ((length = inputStream.read(b)) > 0) {
			os.write(b, 0, length);
		}
		// 这里主要关闭。
		os.close();
		inputStream.close();
		// 返回值要注意，要不然就出现下面这句错误！
		// java+getOutputStream() has already been called for this response
		return null;
	}

	/**
	 * 	oss	getimg
	 * @param fileName 文件名
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	/**
	 *  ueditor 得到本地文件
	 * @param fileName
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getimg2")
	public String getimg2(String fileName, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String imgfilepath=ConfigManager.getInstance().getValue("imgfilepath");// request.getSession().getServletContext().getRealPath(   "/") ;
		//String imgfilepath="http://127.0.0.1:8888";
		fileName=fileName.replaceAll(" ", "%20");  //解决urlecode空格问题
		fileName = URLEncoder.encode(				//中文转application/x-www-form-urlencoded MIME字符串
				 fileName , "UTF-8");
		imgfilepath=imgfilepath+"/"+fileName;
//		response.setHeader("Access-Control-Allow-Origin", "*");//可跨域
		return "redirect:"+imgfilepath;
		//return imgfilepath;
		//return "redirect:http://test.happyinstallment.com:8888/"+fileName;

	}
	
	/*@RequestMapping("/gethttpsimg")
	public String gethttpsimg(String fileName, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String ctxPath = ConfigManager.getInstance().getValue("filedir");
		//String imgfilepath=ConfigManager.getInstance().getValue("imgfilepath");// request.getSession().getServletContext().getRealPath(   "/") ;
		fileName=fileName.replaceAll(" ", "%20");  //解决urlecode空格问题
		fileName = URLEncoder.encode(				//中文转application/x-www-form-urlencoded MIME字符串
				 fileName , "UTF-8");
		ctxPath=ctxPath+"/"+fileName;
		response.setHeader("Access-Control-Allow-Origin", "*");//可跨域
		return "redirect:"+ctxPath;
		//return imgfilepath;
		//return "redirect:http://test.happyinstallment.com:8888/"+fileName;

	}*/
	
	/**
	 * @Title: getImage 
	 * @Description: TODO(验证码) 
	 * @param request
	 * @param resp
	 * @author 唐远泉 tyq   
	 * @date 2016年8月17日 下午12:02:02 te
	 * @修改信息 (修改人修改内容及修改时间)
	 */
	@RequestMapping(value="/getImage.json")
	@ResponseBody
	public void getImage(HttpServletRequest request,HttpServletResponse resp) {
		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-store");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream out = null;
		try {
			out = resp.getOutputStream();
			BufferedImage buffImg = this.creatImage(request);
			ImageIO.write(buffImg, "jpeg", out);
			out.flush();
//			resp.flushBuffer();
			// resp.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	private BufferedImage creatImage(HttpServletRequest request) {

		char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		// 在内存中创建图象
		int width = 80, height = 30;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(100, 250));
		g.fillRect(0, 0, width, height);
		// 设定字体
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		// 画边框
		// g.setColor(new Color());
		// g.drawRect(0,0,width-1,height-1);
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 160; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		// String rand = request.getParameter("rand");
		// rand = rand.substring(0,rand.indexOf("."));
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			// String rand = String.valueOf(random.nextInt(10));
			String rand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110))); // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 18 * i + 6, 22);
		}
		request.getSession().setAttribute("validateCode", sRand);
		// 图象生效
		g.dispose();
		return image;
	}

	
	private String replace(String str){
		String returnstr = "";
		if(str != null){
			returnstr = str;
		}
		return returnstr;
	}
}