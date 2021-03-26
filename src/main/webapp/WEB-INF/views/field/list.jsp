<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
<h1>야구장 리스트</h1>
<hr/>

<table class="table">
    <thead>
      <tr>
        <th>번호</th>
        <th>야구장이름</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="field" items="${fields}">
        <tr>
          <td>${field.id}</td>
          <td>${field.fieldName}
          <button class="btn btn-danger" onClick="deleteField(${field.id})">삭제</button>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<script>
  function deleteField(id) {
    console.log(id);
    $.ajax({
      method:"DELETE",
      url: "/field/"+id
    })
    .done((data) => {
      console.log(data);
      if(data === "ok"){
        $(".list-"+id).remove();
      }
    });
    
  }
</script>





</body>
</html>