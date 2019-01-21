package com.zyt.cxfq.common.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.zyt.cxfq.util.BusinessException;

public class FileUtil {

    /**
     * 读取文件内容，作为字符串返回
     */
    public static String readFileAsString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } 

        if (file.length() > 1024 * 1024 * 1024) {
            throw new IOException("File is too large");
        } 

        StringBuilder sb = new StringBuilder((int) (file.length()));
        FileInputStream fis = new FileInputStream(filePath);  
        byte[] bbuf = new byte[10240];  
        int hasRead = 0;  
        while ( (hasRead = fis.read(bbuf)) > 0 ) {  
            sb.append(new String(bbuf, 0, hasRead));  
        }  
        fis.close();  
        return sb.toString();
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }
    //移动from路径的文件  为to路径的文件
    public static void MoveFolderAndFileWithSelf(String from, String to) throws Exception {  
        try {  
            File dir = new File(from);  
            // 目标  
           // to +=  File.separator + dir.getName();  
            File moveDir = new File(to);  
            if(dir.isDirectory()){  
                if (!moveDir.exists()) {  
                    moveDir.mkdirs();  
                }  
            }else{  
                File tofile = new File(to);  
                dir.renameTo(tofile);  
                return;  
            }  
              
            // 文件一览  
            File files = dir;  
            if (files == null){  
                return;  
            }
            // 文件移动  
            System.out.println("文件名："+files.getName());  
            if (files.isDirectory()) {  
                MoveFolderAndFileWithSelf(files.getPath(), to);  
                // 成功，删除原文件  
                files.delete();  
            }  
            File moveFile = new File(moveDir.getPath() + File.separator + files.getName());  
            // 目标文件夹下存在的话，删除  
            if (moveFile.exists()) {  
                moveFile.delete();  
            }  
            files.renameTo(moveFile);  
            dir.delete();  
        } catch (Exception e) {  
            throw e;  
        }  
    } 
    //读取有中文的文件内容
    public static String getFileUtf8Data(String path) throws Exception{
    	File firstFile = new File(path);  
	 	StringBuilder sb = new StringBuilder((int) (firstFile.length()));
	 	
        BufferedReader in = null;  
        try {          
            in = new BufferedReader(new InputStreamReader(new FileInputStream(firstFile), "UTF-8"));  
            String line = "";  
            while((line = in.readLine())!=null){  
            	sb.append(line);
            }  
           
        } catch (FileNotFoundException e) {  
            System.out.println("file is not fond");  
        } catch (IOException e) {  
            System.out.println("Read or write Exceptioned");  
        }finally{ 
        	
            if(null!=in){   
                try {  
                    in.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }}  
            }
        return sb.toString();
		
    }
    
  
}
