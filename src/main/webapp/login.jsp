<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <base href='${pageContext.request.requestURL}' />
<meta charset="utf-8">
<title>登录界面</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/style.css" />
</head>

<body>
<%-- <jsp:include page="include/header.jsp" /> --%>
<!-- <div class="container"> -->
<!-- 	<div class="subMainNav"> -->
<!-- 		<div class="currentLocation"> -->
<!-- 			<a href="main.jsp">在线教学</a>> <a href="#">教学排课</a>> <a href="#">学期课表生成</a> -->
<!-- 		</div> -->
<%-- 		<jsp:include page="include/menu2.jsp"></jsp:include> --%>
<!-- 	</div> -->
<!-- </div> -->

<div class="container">
	<div class="mainbox login-mainbox">
    	<div class="loginBox">
        	<div class="model-header">
            	<div class="logobox">
                	<span class="logo-a te">在线<span id="logo-a-add">教学</span></span>
                    <div class="logo-b">登录后使用相关功能</div>
                </div>
            	<div class="login-tit"><h3>登录</h3></div>
            </div>
            <form id="login-form" class="login-form" method="post" action="login/login">
            	<input type="hidden" name="role" value="student" id="loginRole"/>
            	<div class="login-student-box pullleft login-img gray" id="sturole" title="学生"></div>
            	<div class="model-body pullleft">
                	<fieldset class="fieldStyle">
                    	<div class="form-field-group">
                        	<label for="id_username" class="inputLable" id="login-input-unl">学　号</label>
                            <div class="login-inputbox login-iun">
                            	<input type="text" name="username" id="id_username" class="inputField teslowly" />
                            </div>
                        </div>
                    	<div class="form-field-group">
                        	<label for="id_password" class="inputLable">密　码</label>
                            <div class="login-inputbox login-ipw">
                            	<input type="password" name="password" id="id_password" class="inputField teslowly" />
                            </div>
                        </div>
                    </fieldset>
                </div>
            	<div class="login-teacher-box pullleft login-img gray" id="tchrole" title="教师"></div>
            	<div class="clearboth"></div>
                <div class="model-footer">
                	<a href="help.jsp" class="btn te pullleft">使用帮助</a>
                    <input type="submit" class="btn submitBtn te pullright" value="登录"/>
                </div>
            </form>
        </div>
    </div>
</div>

<div id="tipCtn">
	<div class="${requestScope.oktip}" id="oktip" style="display:none;">${requestScope.tip}</div>
</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/script/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/js.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/js_preview.js"></script>

</body>
</html>
