<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<!-- 添加类目jsp页面 -->
<script language="JavaScript">
/*  进行空检查*/
	function check11() {

		if (document.form1.name.value == "") {
			alert("类别名称不能为空!");
			document.form1.name.focus();
			return false;
		}

	}
</script>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="body">

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="17" valign="top" background="images/mail_leftbg.gif"><img
				src="images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">添加类别</div></td>
					</tr>
				</table></td>
			<td width="16" valign="top" background="images/mail_rightbg.gif"><img
				src="images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">
				<p>&nbsp;</p>

				<div align="center">

					<form action="../TypeAddServlet" method="post" name="form1"
						onSubmit="return check11()">


						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">

							<tr>
								<td class="line_table" height="25" align="right" width="40%"><span
									class="left_bt2">菜品类别：</span></td>
								<td class="line_table" height="25" width="60%"><input
									type="text" name="name" size="45" value=""></td>
							</tr>

							<tr>
								<td class="line_table" height="25" align="center" colspan="2">
									<input type="submit" value="添加">
								</td>
							</tr>
						</table>
					</form>
				</div>


			</td>


			<td background="images/mail_rightbg.gif">&nbsp;</td>
		</tr>
		<tr>
			<td valign="bottom" background="images/mail_leftbg.gif"><img
				src="images/buttom_left2.gif" width="17" height="17" /></td>
			<td background="images/buttom_bgs.gif"><img
				src="images/buttom_bgs.gif" width="17" height="17"></td>
			<td valign="bottom" background="images/mail_rightbg.gif"><img
				src="images/buttom_right2.gif" width="16" height="17" /></td>
		</tr>
	</table>
</body>
</html>
