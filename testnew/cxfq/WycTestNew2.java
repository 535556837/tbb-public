package cxfq;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.zyt.cxfq.common.util.ConfigManager;
import com.zyt.cxfq.model.DCar;
/*import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;*/
public class WycTestNew2 {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			arr.add((int)(0+Math.random()*(100-0+1)));
			arr2.add((int)(0+Math.random()*(100-0+1)));
		}
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				t1(arr);
				
			}
		});
		t1.start();
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				t2(arr2);
				
			}
		});
		t2.start();
		
		
	}
	
	public static void t1(List<Integer> arr)  {
		arr.forEach(li -> System.out.print( li+","));
		System.out.println("==");
		
		long start =System.currentTimeMillis();
		for (int i = 0; i < arr.size()-1; i++) {
			for (int j = i+1; j < arr.size(); j++) {
				if (arr.get(i)>arr.get(j)) {
					int temp  =arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
				}
			}
		}
		System.out.println("t1用时："+(System.currentTimeMillis()-start));
		arr.forEach(li -> System.out.print( li+","));
	}
	
	public static void t2(List<Integer> arr) {
		System.err.println();
		arr.forEach(li -> System.err.print( li+","));
		long start = System.currentTimeMillis();
		for (int i = 0; i < arr.size() - 1; i++) {
			int x = i;
			for (int j = i + 1; j < arr.size(); j++) {
				if (arr.get(x) > arr.get(j)) {
					x = j;
				}
			}
			int temp = arr.get(i);
			arr.set(i, arr.get(x));
			arr.set(x, temp);
		}
		System.err.println();
		System.out.println("t2用时："+(System.currentTimeMillis()-start));
		arr.forEach(li -> System.out.print( li+","));
	}

}
