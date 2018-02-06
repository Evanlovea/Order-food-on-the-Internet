<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
<title>网上订餐管理员登陆</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	/* background-color: #1D3647; */
}
-->
</style> 

<script language="JavaScript">
	function login11() {

		if (document.form1.name.value == "") {
			alert("请输入用户名!");
			document.form1.name.focus();
			return false;
		}
		if (document.form1.pwd.value == "") {
			alert("请输入密码!");
			document.form1.pwd.focus();
			return false;
		}
	}
</script>

<link href="images/skin.css" rel="stylesheet" type="text/css">
</head>

<body>

	<table width="100%" height="166" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="42" valign="top"><table width="100%" height="42"
					border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
					<tr>
						<td width="1%" height="21">&nbsp;</td>
						<td height="42">&nbsp;</td>
						<td width="17%">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td valign="top"><table width="100%" height="532" border="0"
					cellpadding="0" cellspacing="0" class="login_bg">
					<tr>
						<td width="49%" align="right"><table width="91%" height="532"
								border="0" cellpadding="0" cellspacing="0" class="login_bg2">
								<tr>
									<td height="138" valign="top"><table width="89%"
											height="427" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td height="149">&nbsp;</td>
											</tr>
											<tr>
												<td height="80" align="right" valign="top"><img
													src="images/logo4.png" width="279" height="68"></td>
											</tr>
											<tr>
												<td height="198" align="right" valign="top"><table
														width="100%" border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td width="35%">&nbsp;</td>
															<td height="25" colspan="2" class="left_txt"
																align="center"><p>
															
																</p></td>
														</tr>
														<tr>
															<td>&nbsp;</td>
															<td height="25" colspan="2" class="left_txt"
																align="center"><p>
																	<img src="images/666.png" width="17" height="14">
																	官方网站：http://www.haut.edu.cn/
																</p></td>
														</tr>
														<tr>
															<td>&nbsp;</td>
															<td height="25" colspan="2" class="left_txt"></td>
														</tr>
														<tr>
															<td>&nbsp;</td>
															
														</tr>
													</table></td>
											</tr>
										</table></td>
								</tr>

							</table></td>
						<td width="1%">&nbsp;</td>
						<td width="50%" valign="bottom"><table width="100%"
								height="59" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="4%">&nbsp;</td>
									<td width="96%" height="38"><span class="login_txt_bt">登陆网上订餐后台管理</span></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td height="21"><table cellSpacing="0" cellPadding="0"
											width="100%" border="0" id="table211" height="328">
											<tr>
												<td height="164" colspan="2" align="middle">
														<!--  提交进行登录的表单AdminLoginServlet-->
											
													<form name="form1" action="../AdminLoginServlet"
														method="post" onSubmit="return login11()">
														<table cellSpacing="0" cellPadding="0" width="100%"
															border="0" height="143" id="table212">
															<tr>
																<td width="13%" height="38" class="top_hui_text" style="width: 74px; "><span
																	class="login_txt">管理员姓名：&nbsp;&nbsp; </span></td>
																<td height="38" colspan="2" class="top_hui_text" style="width: 361px; "><input
																	name="name" class="name" value="" size="20"></td>
															</tr>
															<tr>
																<td width="13%" height="35" class="top_hui_text" style="width: 69px; "><span
																	class="login_txt"> 登录密 码： &nbsp;&nbsp; </span></td>
																<td height="35" colspan="2" class="top_hui_text" style="width: 333px; "><input
																	class="pwd" type="password" size="20" name="pwd">
																	
																</td>
															</tr>
															<tr>
																<td width="13%" height="35">&nbsp;</td>
																<td height="35" colspan="2" class="top_hui_text"><input
																	class=AutoLogin name=AutoLogin type=checkbox value="Y"
																	maxLength=4 size=10 id="AutoLogin"> <span
																	class="login_txt"> 5天内自动登录</span></td>
															</tr>
															<tr>
																<td height="35">&nbsp;</td>
																<td width="20%" height="35"><input name="Submit"
																	type="submit" class="button" id="Submit" value="登 陆">
																</td>
																<td width="67%" class="top_hui_text"><input
																	name="cs" type="button" class="button" id="cs"
																	value="取 消" onClick="showConfirmMsg1()"></td>
															</tr>
														</table>
														<br>
													</form>

												</td>
											</tr>
											<tr>
												<td width="433" height="164" align="right" valign="bottom"></td>
												<td width="57" align="right" valign="bottom">&nbsp;</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="20"><table width="100%" border="0" cellspacing="0"
					cellpadding="0" class="login-buttom-bg">
					<tr>
						<td align="center"><span class="login-buttom-txt">Copyright
								&copy; 2018-2030</span></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
