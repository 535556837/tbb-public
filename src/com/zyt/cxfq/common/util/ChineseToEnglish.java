/*    */ package com.zyt.cxfq.common.util;
/*    */ 
/*    */ /*    */ import net.sourceforge.pinyin4j.PinyinHelper;
/*    */ import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
/*    */ import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
/*    */ import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
/*    */ import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
/*    */ import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/*    */ 
/*    */ public class ChineseToEnglish
/*    */ {
/*    */   public static String getPingYin(String src)
/*    */   {
/* 15 */     char[] t1 = null;
/* 16 */     t1 = src.toCharArray();
/* 17 */     String[] t2 = new String[t1.length];
/* 18 */     HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
/*    */ 
/* 20 */     t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
/* 21 */     t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
/* 22 */     t3.setVCharType(HanyuPinyinVCharType.WITH_V);
/* 23 */     String t4 = "";
/* 24 */     int t0 = t1.length;
/*    */     try {
/* 26 */       for (int i = 0; i < t0; i++)
/*    */       {
/* 28 */         if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+"))
/*    */         {
/* 30 */           t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
/* 31 */           t4 = t4 + t2[0];
/*    */         } else {
/* 33 */           t4 = t4 + Character.toString(t1[i]);
/*    */         }
/*    */       }
/* 36 */       return t4;
/*    */     } catch (BadHanyuPinyinOutputFormatCombination e1) {
/* 38 */       e1.printStackTrace();
/*    */     }
/* 40 */     return t4;
/*    */   }
/*    */ 
/*    */   public static String getPinYinHeadChar(String str)
/*    */   {
/* 46 */     String convert = "";
/* 47 */     for (int j = 0; j < str.length(); j++) {
/* 48 */       char word = str.charAt(j);
/* 49 */       String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
/* 50 */       if (pinyinArray != null)
/* 51 */         convert = convert + pinyinArray[0].charAt(0);
/*    */       else {
/* 53 */         convert = convert + word;
/*    */       }
/*    */     }
/* 56 */     return convert;
/*    */   }
/*    */ 
/*    */   public static String getCnASCII(String cnStr)
/*    */   {
/* 61 */     StringBuffer strBuf = new StringBuffer();
/* 62 */     byte[] bGBK = cnStr.getBytes();
/* 63 */     for (int i = 0; i < bGBK.length; i++) {
/* 64 */       strBuf.append(Integer.toHexString(bGBK[i] & 0xFF));
/*    */     }
/* 66 */     return strBuf.toString();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 70 */     System.out.println(getPingYin("陈大勇"));
/* 71 */     System.out.println(getPinYinHeadChar("陈大勇"));
/* 72 */     System.out.println(getCnASCII("綦江县"));
/*    */   }
/*    */ }

/* Location:           C:\Users\tpc\Desktop\sczx.lib-0.1.180.jar
 * Qualified Name:     com.lyxx.sczx.base.ChineseToEnglish
 * JD-Core Version:    0.6.2
 */