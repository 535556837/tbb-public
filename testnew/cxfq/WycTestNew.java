package cxfq;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.alibaba.fastjson.JSON;
import com.zyt.cxfq.common.util.ConfigManager;
import com.zyt.cxfq.model.DCar;
/*import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;*/
public class WycTestNew {
	public static void main(String[] args) throws IOException {
		//t0();
		//t1();
		//t3();
		
		/*String indir=ConfigManager.getInstance().getValue("PolicInDir");
		String u =URLEncoder.encode("川AF07196", "utf-8");
		Path carPath = Paths.get(indir, u+","+System.currentTimeMillis());
		Files.createFile(carPath);
		*/
	}
	static void t3() {
		System.out.println("0c5214d69fc3adbb8e56c748461055ce".length());
	}
/*	static void t0() {
		List<TAutocarnews>  datalist = new ArrayList<TAutocarnews>();
		try
		{
		    Document document = Jsoup.connect("http://auto.163.com/buy/").get();
		    Elements a = document.getElementsByClass("sec-list-item");
		    Elements ga =a.select(".ga");
		    for (int i = 0; i < a.size(); i++) {
		    	 Element b = a.get(i);
			  
			    System.out.println(b);
		    }
		   
		    //getElementsByClass
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
	
	
	static void t1() {
		List<TAutocarnews>  alllist = new ArrayList<TAutocarnews>();
		List<TAutocarnews>  datalist = new ArrayList<TAutocarnews>();
		List<TAutocarnews>  galist = new ArrayList<TAutocarnews>();
		try
		{
		    Document document = Jsoup.connect("http://auto.163.com/buy/").get();
		    Elements a = document.getElementsByClass("sec-list-item");
		    Elements ga =a.select(".ga");
		    alllist =parseData(a);
		    galist =parseData(ga);
		    datalist =alllist;
			for (int j = 0; j < alllist.size(); j++) {
				for (int i = 0; i < galist.size(); i++) {
					if (galist.get(i).getImgurl().equals(alllist.get(j).getImgurl())) {
						alllist.remove(j);
						break;
					}
				}
			}
		    System.out.println(datalist);
		    //getElementsByClass
		} 
		
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
	static List<TAutocarnews>  parseData(Elements a){
		List<TAutocarnews> datalist = new ArrayList<TAutocarnews>();
		 for (int i = 0; i < a.size(); i++) {
	    	 Element b = a.get(i);
		    TAutocarnews n = new TAutocarnews();
		    Elements imgs = b.select("img");
		    Elements titles = b.select("h3 a");
		    Elements commentnums = b.select(".item-comment");
		    Elements backurls = b.select("h3 a");
		    Elements codes = b.select(".item-time");
		    
		    String imgurl = imgs.size()==0?"":imgs.get(0).attr("src");
		    String title = titles.size()==0?"":titles.get(0).text();
		    String commentnum = commentnums.size()==0?"":commentnums.get(0).text();
		    String backurl =backurls.size()==0?"":backurls.get(0).attr("href");
		    String code =commentnums.size()==0?"":commentnums.get(0).text();
		    
		    
		    n.setImgurl(imgurl);
		    n.setTitle(title);
		    n.setCommentnum(commentnum);
		    n.setBackurl(backurl);
		    n.setCode(code);
		    n.setType("2");
		    datalist.add(n);
	    }
		 return datalist;
	}
	private static String TARGET_URL = "http://green.xcar.com.cn/";
	 
	public static void main(String[] args)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException {
		// 模拟一个浏览器
		WebClient webClient = new WebClient();
		//webclient参数载体
		WebClientOptions clientOptions = webClient.getOptions();
		// 设置webClient的相关参数
		clientOptions.setJavaScriptEnabled(true);
		clientOptions.setCssEnabled(false);
		webClient.waitForBackgroundJavaScript(10000);
		webClient.setJavaScriptTimeout(0);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());
		clientOptions.setTimeout(35000);
		clientOptions.setThrowExceptionOnScriptError(false);
		// 模拟浏览器打开一个目标网址
		HtmlPage rootPage = webClient.getPage(TARGET_URL);
 
		//保存页面
		//rootPage.save(new File("/home/share/Test/1"));
		
		//body html信息
		HtmlElement htmlElement = rootPage.getBody();
		String xmlContent = htmlElement.asXml();
		System.out.println(xmlContent);
	}*/

}
