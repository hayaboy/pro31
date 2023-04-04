<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<nav>
<ul>
<c:choose>
<c:when test="${side_menu=='admin_mode' }">
	<li>
		<H3>�ֿ���</H3>
		<ul>
			<li><a href="${contextPath}/admin/goods/adminGoodsMain.do">��ǰ����</a></li>
			<li><a href="${contextPath}/admin/order/adminOrderMain.do">�ֹ�����</a></li>
			<li><a href="${contextPath}/admin/member/adminMemberMain.do">ȸ������</a></li>
			<li><a href="#">��۰���</a></li>
			<li><a href="#">�Խ��ǰ���</a></li>
		</ul>
	</li>
</c:when>
<c:when test="${side_menu=='my_page' }">
     <li>
		<h3>�ֹ�����</h3>
		<ul>
			<li><a href="${contextPath}/mypage/listMyOrderHistory.do">�ֹ�����/��� ��ȸ</a></li>
			<li><a href="#">��ǰ/��ȯ ��û �� ��ȸ</a></li>
			<li><a href="#">��� �ֹ� ����</a></li>
			<li><a href="#">���� ��꼭</a></li>
		</ul>
	</li>
	<li>
		<h3>��������</h3>
		<ul>
			<li><a href="${contextPath}/mypage/myDetailInfo.do">ȸ����������</a></li>
			<li><a href="#">���� �ּҷ�</a></li>
			<li><a href="#">�������� ���ǳ���</a></li>
			<li><a href="#">ȸ��Ż��</a></li>
		</ul>
	</li>
</c:when>
<c:otherwise>
    <li>
		<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������ ����</h3>
		<ul>
			<li><a href="${contextPath}/goods/goodsList.do">IT/���ͳ�</a></li>
			<li><a href="#">����/�濵</a></li>
			<li><a href="#">���б���</a></li>
			<li><a href="#">�ڱ���</a></li>
			<li><a href="#">�ڿ�����/����</a></li>
			<li><a href="#">����/�ι���</a></li>
		</ul>
	</li>
	<li>
		<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����</h3>
		<ul>
			<li><a href="#">����</a></li>
			<li><a href="#">��</a></li>
			<li><a href="#">Ŭ����</a></li>
			<li><a href="#">��������</a></li>
			<li><a href="#">����</a></li>
			<li><a href="#">��Ÿ</a></li>
		</ul>
	</li>
</c:otherwise>
</c:choose>
</ul>
</nav>



<div class="clear"></div>
<div id="banner">
	<a href="#"><img width="190" height="163" src="${contextPath}/resources/image/n-pay.jpg"> </a>
</div>
<DIV id="notice">
	<H2>��������</H2>
	<UL>
	
	<c:forEach  var="i" begin="1" end="5" step="1">
		<li><a href="#">���������Դϴ�.${ i}</a></li>
	</c:forEach>
	</ul>
</div>


<div id="banner">
	<a href="#"><img width="190" height="362" src="${contextPath}/resources/image/side_banner1.jpg"></a>
</div>
<div id="banner">
	<a href="#"><img width="190" height="104" src="${contextPath}/resources/image/call_center_logo.jpg"></a>
</div>
<div id="banner">
	<a href="#"><img width="190" height="69" src="${contextPath}/resources/image/QnA_logo.jpg"></a>





</body>
</html>