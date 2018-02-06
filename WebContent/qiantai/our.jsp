<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>关于我们</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />

</head>


<script type="text/javascript" src="js/common.js"></script>

 
<body >
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  
    
  <jsp:include flush="fasle" page="top.jsp"/>
    
    </td>
  </tr>
  <tr >
  <td height="50"></td>
  
</tr>
  
  <tr>
    <td align="center" valign="top" height="400">
    
    <table border="0" cellspacing="0"  width="100%">
    
		<tr>
		  <td  align="center" vlign="top"  >
			 <strong><span style="font-family: Helvetica, sans-serif;font-size: 20px;">
			       关于我们
			 </span></strong>
			 <br>
		  </td>
		</tr>
		<tr>
		  <td  align="left" vlign="top" >
             <p style=" font-size: 16px;">
              <br><br>
 
             &nbsp;&nbsp;&nbsp;&nbsp;河南工业大学网上订餐系统是由新开普集团下的完美校园所开发的一个可以专注于河南工业大学大学生的在线订餐平台！<br><br>
             &nbsp;&nbsp;&nbsp;&nbsp;了解详情请点击  &nbsp; <a href="http://www.newcapec.com.cn/chanxue/">新开普官方网站</a>
             </p>
        
		  </td>
		</tr>
		<tr>
		  <td  align="center"  >
			 <a href="index.jsp" target="_self">
			
			 <span style="font-family: Helvetica, sans-serif;font-size: 20px;color: blue">
			     返回
			 </span></a>
		  </td>
		</tr>	
   </table>
 
 
    
    
    
  
  <tr>
    <td height="10">&nbsp;</td>
  </tr>
  <tr>
    <td height="50" align="center" valign="middle">&nbsp; 
   
        <jsp:include flush="fasle" page="copyright.jsp"/>
    </td>
  </tr>
  
</table>


 
</body>
</html>
