<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.nio.file.Paths"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.io.output.*"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="SQLSEVERDataAccess.jsp" %>
        <%
            try{
           MultipartRequest multi= new MultipartRequest(request, "D:/JavaBE/WebApp_QUANLYBANHANGONLINE/src/main/webapp/images");//"C:/Users/AD/Documents/NetBeansProjects/WebApp_QUANLYBANHANGONLINE/web/images"
           String TENSANPHAM=multi.getParameter("txtTensanpham");                   
          String DONGIA=multi.getParameter("txtDongia");
            String SOLUONG=multi.getParameter("txtSoluong");
          String MADANHMUC=multi.getParameter("selMadanhmuc");
          String MOTA=multi.getParameter("txtMota");
          String fileName=multi.getFilesystemName("file");
          SQLSEVERDataAccess con=new SQLSEVERDataAccess();
         String SQL=" insert into tbSANPHAM(TENSANPHAM,DONGIA,SOLUONG,HINHANH,MOTA,MADANHMUC)"
                + "values(?,?,?,?,?,?)";        
           Object []  param={TENSANPHAM,DONGIA,SOLUONG,fileName,MOTA,MADANHMUC};
              int k= con.ExecuteSQL(SQL, param);
         response.sendRedirect("index.jsp");
            }catch(Exception ex){
                out.print("loi");
            }  
        %>
</body>
</html>