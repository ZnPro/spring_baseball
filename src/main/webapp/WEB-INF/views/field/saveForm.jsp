<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h1>야구장 등록</h1>
	<hr />

	<!--경기장 등록 폼-->
	<form action="/field/save" method="post">
		<input type="text" name="fieldName" class="form-control" placeholder="야구장 이름" required="required">
		<br/><button class="btn btn-primary">등록</button>
	</form>
	<!--경기장 등록 폼end-->
</div>

</body>
</html>