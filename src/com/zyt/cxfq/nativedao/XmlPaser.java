package com.zyt.cxfq.nativedao;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class XmlPaser {
	/**
	 * 
	 * @param xmlnames  不定参 xml的名字
	 * @return
	 * @throws Exception
	 */
	 public static List<Data> getShowMethods(String... xmlnames) throws Exception{  
		  List<Data> list=new ArrayList<>();
		 for (String arg : xmlnames) {  
	            System.out.println(arg); 
	            List<Data> newlist = showmethod(arg);
	           list.addAll(newlist);
	        }  
		
		 return list;
	    } 

	 public static List<Data> showmethod(String xmlName) throws Exception{
		   // xmlName="CommonDao.xml";
		    List<Data> map=new ArrayList<>();
		    Iterator<Element>   iterator= getrootElement(xmlName).elementIterator();
			while (iterator.hasNext()) {				
				Element e = iterator.next();
			
				String key = e.attribute("id").getValue();
				String resultType ="";
				if (e.attribute("resultType")!=null) {
					resultType= e.attribute("resultType").getValue();
				}
				String value=e.asXML();			
				value=value.substring(value.indexOf(">")+1);
				value=value.substring(0,value.lastIndexOf("</"));
				
				Data da=new Data();
				da.setId(key);
				da.setText(value);
				da.setClassname(xmlName);
				da.setResultType(resultType);
				if(value.indexOf("<!--")!=-1){
					String name=value.substring(value.indexOf("<!--")+4);
					name=name.substring(0,name.lastIndexOf("-->"));
					da.setName(name);
				}
				//value=value.substring("");
				map.add( da);
			}
		return map;	 
	 }
	 public static Element getrootElement(String xmlName) throws Exception{
		 String template =  XmlPaser.class.getResource(xmlName).getFile().substring(1);
		 File file = new File(template);
		    SAXReader reader = new SAXReader();
			Document document = null;
			try {
				document = reader.read(file);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Element root = document.getRootElement();
			return root;
	}
		public static void update(String id,String text,String resultType,String XMLname) throws DocumentException{	
			 String template =  XmlPaser.class.getResource(XMLname).getFile().substring(1);
			File file = new File(template);
			    SAXReader reader = new SAXReader();
				Document document = null;
			
				document = reader.read(file);
				
				Element root = document.getRootElement();
				Iterator<Element> list=root.elementIterator();
				while(list.hasNext()){
					Element e=list.next();
					if(e.attribute("id").getValue().equals(id)){
						root.remove(e);					
						break;
					};
				}
				if(text!=null){
					add(root,id,resultType,text);
				}
				writerDocument(document,file);			
		}
		public static void add(Element e,String id,String resultType,String text){
			System.out.println("++++++++++++++++++++++++++++++++"+id);
			System.out.println("++++++++++++++++++++++++++++++++"+text);
			String resultstr="";
			if (resultType!=null&&!resultType.equals("")) {
				resultstr="resultType=\""+resultType+"\">";
			}
			String str1="<select id=\""+id+"\" parameterType=\"java.util.HashMap\" "+resultstr;
			String str2="</select>";
			String element=str1+text+str2;
			try {
				Document document=DocumentHelper.parseText(element);
				
				e.add(document.getRootElement());
			} catch (DocumentException e1) {	
				e1.printStackTrace();
			}
		
		}
		public static void writerDocument(Document document,File file){
			OutputFormat format=OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			try {
			XMLWriter writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream(file)));		
				writer.write(document);
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		/**
		 * 获取mybatis-config.xml 里面配置的xml
		 * @return  xmlnames的集合
		 * @throws DocumentException 
		 *@author WYC
		 * @throws UnsupportedEncodingException 
		 */
		public static List<String> getXMLnames() throws DocumentException, UnsupportedEncodingException{
			InputStream is = XmlPaser.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			SAXReader reader = new SAXReader();
			Document document = reader.read(isr);
			String value = document.asXML();
			List<String> list = new ArrayList<String>();
			String[] arrs = value.split("nativedao/"); // 分隔
			for (int i = 1; i < arrs.length; i++) { // 1开始 ，去掉0的那个
				list.add(arrs[i].substring(0, arrs[i].indexOf("\"/>")));
			}
			return list;
		}
}
