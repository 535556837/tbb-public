package com.zyt.cxfq.common.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageHandleHelper {

    /** 
     * @Description:小图片贴到大图片形成一张图(合成) 

     */  
    public static final void overlapImage(String bigPath, String smallPath, String outFile) {  
        try {  
            BufferedImage big = ImageIO.read(new File(bigPath));  
            BufferedImage small = ImageIO.read(new File(smallPath));  
            Graphics2D g = big.createGraphics();  
            int x = (big.getWidth() - small.getWidth()) / 2;  
            int y = (big.getHeight() - small.getHeight()) / 2+75;  
            g.drawImage(small, x, y, small.getWidth(), small.getHeight(), null);  
            g.dispose();  
            ImageIO.write(big, outFile.split("\\.")[1], new File(outFile));  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    } 
    public static void main(String[] args) {
         String ot="D:\\out.jpg";
    	overlapImage("E:\\车友招募1.png","E:\\test嵌入.jpg","E:\\test嵌入.jpg");
    	System.out.println(ot);
    }
}
