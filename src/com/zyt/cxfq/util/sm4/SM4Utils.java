package com.zyt.cxfq.util.sm4;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SM4Utils
{
    public static String secretKeyWeb = "11HDESaAhiHHugDz";//16位
    public  String secretKey ="";
    public static String secretKeyDB = "YFSDESaAhiHHugDz";
    private String iv = "";
    private boolean hexString = false; 
    
    public SM4Utils()
    {
    }
    
    public String encryptData_ECB(String plainText)
    {
        try 
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_ENCRYPT;
            
            byte[] keyBytes;
            keyBytes = secretKey.getBytes();
            SM4 sm4 = new SM4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("UTF-8"));
            String cipherText = new BASE64Encoder().encode(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0)
            {
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(cipherText);
                cipherText = m.replaceAll("");
            }
            return cipherText;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String decryptData_ECB(String cipherText)
    {
        try 
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_DECRYPT;
            
            byte[] keyBytes;
            keyBytes = secretKey.getBytes();
            SM4 sm4 = new SM4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
            return new String(decrypted, "UTF-8");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String encryptData_CBC(String plainText){  
         try{  
                SM4_Context ctx = new SM4_Context();  
                ctx.isPadding = true;  
                ctx.mode = SM4.SM4_ENCRYPT;  
                  
                byte[] keyBytes;  
                byte[] ivBytes;  
               
                keyBytes = secretKey.getBytes();  
                ivBytes = iv.getBytes();  
                  
                SM4 sm4 = new SM4();  
                sm4.sm4_setkey_enc(ctx, keyBytes);  
                byte[] encrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, plainText.getBytes("UTF-8"));  
                String cipherText = new BASE64Encoder().encode(encrypted);  
                if (cipherText != null && cipherText.trim().length() > 0)  
                {  
                    Pattern p = Pattern.compile("\\s*|\t|\r|\n");  
                    Matcher m = p.matcher(cipherText);  
                    cipherText = m.replaceAll("");  
                }  
                return cipherText;  
            }   
            catch (Exception e)   
            {  
                e.printStackTrace();  
                return null;  
            }  
        }  
          
        public String decryptData_CBC(String cipherText)  
        {  
            try   
            {  
                SM4_Context ctx = new SM4_Context();  
                ctx.isPadding = true;  
                ctx.mode = SM4.SM4_DECRYPT;  
                  
                byte[] keyBytes;  
                byte[] ivBytes;  
                if (hexString)  
                {  
                    keyBytes = Util.hexStringToBytes(secretKey);  
                    ivBytes = Util.hexStringToBytes(iv);  
                }  
                else  
                {  
                    keyBytes = secretKey.getBytes();  
                    ivBytes = iv.getBytes();  
                }  
                  
                SM4 sm4 = new SM4();  
                sm4.sm4_setkey_dec(ctx, keyBytes);  
                byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, new BASE64Decoder().decodeBuffer(cipherText));  
                return new String(decrypted, "UTF-8");  
            }   
            catch (Exception e)  
            {  
                e.printStackTrace();
                return null;  
            }  
        }  
          
    
    public static void main(String[] args) throws IOException 
    {
       /* String plainText ="梵蒂冈的金额，142342,";
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = "11HDESaAhiHHugDz";
        plainText.getBytes("UTF-8");        
        System.out.println("ECB模式");
        String cipherText = sm4.encryptData_ECB(plainText);
        System.out.println("密文: " + cipherText);
        System.out.println("");*/
        
        //Z+Y+z03bI9czWd7JZn6Zjv+yp9KKTK8QdB7LdnyGpq4=
    	 SM4Utils sm4 = new SM4Utils();
         sm4.secretKey = "11HDESaAhiHHugDz";
         String plainText ="123456";
         plainText.getBytes("UTF-8");   
         String cipherText = sm4.encryptData_ECB(plainText);
         System.out.println("密文: " + cipherText);
         
         sm4.secretKey = "11HDESaAhiHHugDz";
         String  plainText2 = sm4.decryptData_ECB(cipherText);
        System.out.println("明文: " + plainText2);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace(); 
        }
        sm4.secretKey = "YFSDESaAhiHHugDz";
        cipherText = sm4.encryptData_ECB(plainText2);
        System.out.println("密文: " + cipherText);
        
        plainText2 = sm4.decryptData_ECB(cipherText);
        System.out.println("明文: " + plainText2);
        
      /*  System.out.println("CBC模式");  
        sm4.iv = "UISwD9fW6cFh9SNS";  
        cipherText = sm4.encryptData_CBC(plainText);  
        System.out.println("密文: " + cipherText);  
        System.out.println("");  
          
        plainText = sm4.decryptData_CBC(cipherText);  
        System.out.println("明文: " + plainText);*/
        //PI4ke7HMoUMD/LOSHWX5/g==	obLEruIrr7sr+7RFp6/jhQSa8mH0TErNL3N8izMZvI8=
        
    }
}