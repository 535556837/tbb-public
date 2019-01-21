<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true" 
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>      
<%response.setStatus(500);%>

<%
String er=exception.getMessage();
exception.printStackTrace();
int index= er.indexOf(":");
er=er.substring(index+1);
out.print(er);%>



