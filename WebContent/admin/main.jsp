<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>网上订餐后台- 管理页面</title>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
</head>
<!-- frameset 元素可定义一个框架集。
         它被用来组织多个窗口（框架）。
         每个框架存有独立的文档。
        在其最简单的应用中，
    frameset 元素仅仅会规定在框架集中存在多少列或多少行。
       您必须使用 cols 或 rows 属性。 -->
<frameset rows="64,*"  frameborder="0" border="0" framespacing="0">
  <frame src="admin_top.jsp" noresize="noresize" frameborder="0" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main" />
  <frameset cols="200,*" id="frame">
	<frame src="admin_left.jsp" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main" />
	<frame src="menus.jsp" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" />
  </frameset>
</frameset>
<noframes>
  <body></body>
</noframes> 
</html>
