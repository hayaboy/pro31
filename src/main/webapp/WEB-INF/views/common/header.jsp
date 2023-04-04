<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">


<script>
var loopSearch=true;
function keywordSearch(){
	if(loopSearch==false)
		return;
	var value=document.frmSearch.searchWord.value;
	$.ajax({
		type : "get",
		async : true, //false�� ��� ��������� ó���Ѵ�.
		url : "${contextPath}/goods/keywordSearch.do",
		data : {keyword:value},
		success : function(data, textStatus) {
		    var jsonInfo = JSON.parse(data);
			displayResult(jsonInfo);
		},
		error : function(data, textStatus) {
			alert("������ �߻��߽��ϴ�."+data);
		},
		complete : function(data, textStatus) {
			//alert("�۾����Ϸ� �߽��ϴ�");
			
		}
		
		
	});
	
}


function displayResult(jsonInfo){
	var count = jsonInfo.keyword.length;
	if(count > 0){
		var html = '';
		for(var i in jsonInfo.keyword){
			html += "<a href=\"javascript:select('"+jsonInfo.keyword[i]+"')\">"+jsonInfo.keyword[i]+"</a><br/>";
		}
		var listView = document.getElementById("suggestList");
	    listView.innerHTML = html;
	    show('suggest');
	}else{
		 hide('suggest');
	}
	
	
}

function select(selectedKeyword) {
	 document.frmSearch.searchWord.value=selectedKeyword;
	 loopSearch = false;
	 hide('suggest');
}


function show(elementId) {
	 var element = document.getElementById(elementId);
	 if(element) {
	  element.style.display = 'block';
	 }
	}
	
	
function hide(elementId){
	   var element = document.getElementById(elementId);
	   if(element){
		  element.style.display = 'none';
	   }
	}

</script>
</head>
<body>
<div id="logo">
	<a href="${contextPath}/main/main.do">
		<img width="176" height="80" src="${contextPath}/resources/image/tiger.jpg">
		</a>
	</div>
	<div id="head_link">
	<ul>
		<c:choose>
		     <c:when test="${isLogOn==true and not empty memberInfo }">
			   <li><a href="${contextPath}/member/logout.do">�α׾ƿ�</a></li>
			   <li><a href="${contextPath}/mypage/myPageMain.do">����������</a></li>
			   <li><a href="${contextPath}/cart/myCartList.do">��ٱ���</a></li>
			   <li><a href="#">�ֹ����</a></li>
			 </c:when>
			 <c:otherwise>
			   <li><a href="${contextPath}/member/loginForm.do">�α���</a></li>
			   <li><a href="${contextPath}/member/memberForm.do">ȸ������</a></li> 
			 </c:otherwise>
			</c:choose>
	<li><a href="#">������</a></li>
	<c:if test="${isLogOn==true and memberInfo.member_id =='admin' }">  
	   	   <li class="no_line"><a href="${contextPath}/admin/goods/adminGoodsMain.do">������</a></li>
	    </c:if>
	
	</ul>	
	</div>
	<br>
	
	<div id="search" >
		<form name="frmSearch" action="${contextPath}/goods/searchGoods.do" >
			<input name="searchWord" class="main_input" type="text"  onKeyUp="keywordSearch()"> 
			<input type="submit" name="search" class="btn1"  value="�� ��" >
		</form>
	</div>
	  <div id="suggest">
        <div id="suggestList"></div>
   </div>
	
	
	
	
	
	
	
</body>
</html>