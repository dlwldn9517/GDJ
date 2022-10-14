<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>${param.a + param.b}</div>
	<div>${param.a - param.b}</div>
	<div>${param.a * param.b}</div>
	<div>${param.a / param.b}, ${a div b}</div>
	<div>${param.a % param.b}, ${a mod b}</div>
	
	<div>${param.a <  param.b}, ${param.a lt param.b}</div>
	<div>${param.a <= param.b}, ${param.a le param.b}</div>
	<div>${param.a >  param.b}, ${param.a gt param.b}</div>
	<div>${param.a >= param.b}, ${param.a ge param.b}</div>
	<div>${param.a == param.b}, ${param.a eq param.b}</div>
	<div>${param.a != param.b}, ${param.a ne param.b}</div>
	
	<div>${param.a == 7 && param.b == 2}, ${param.a eq 7 and param.b eq 2}</div>
	<div>${param.a == 7 || param.b == 2}, ${param.a eq 7 or  param.b eq 2}</div>
	<div>${!(param.a == 7)}, ${not (param.a eq 7)}</div>
	
	<div>${a == 7 ? "a는 7이다" : 'a는 7이 아니다'}</div>



</body>
</html>