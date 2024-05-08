<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="SQLSEVERDataAccess.jsp"%>
<%@page import="java.util.Map"%>
<%@page import="Model.Cart"%>
<%@page import="Model.Item"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Electronix Store</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="giohang.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>

	<h1 class="text-center" style="text-align: center">Giỏ hàng</h1>
	<div class="row">
		<div class="col col-md-12">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã sản phẩm</th>
						<th>Hình sản phẩm</th>
						<th>Tên sản phẩm</th>
						<th>Số lượng</th>
						<th>Đơn giá</th>
						<th>Thành tiền</th>
						<th>Hành động</th>
					</tr>
				</thead>
				<tbody id="datarow">
				<%
			try {
				SQLSEVERDataAccess con = new SQLSEVERDataAccess();
				Cart cart = (Cart) session.getAttribute("cart");
				if (cart == null) {
					cart = new Cart();
					session.setAttribute("cart", cart);
				}
			%>
			<%
			for (Map.Entry<Long, Item> list : cart.getListItem().entrySet()) {
			%>
					<tr>
						<td><%=list.getValue().getProduct().getMasanpham()%></td>
						<td><img src="images/<%=list.getValue().getProduct().getHinhanh() %>"
							class="hinhdaidien"></td>
						<td><%=list.getValue().getProduct().getTensanpham()%></td>
						<td class="text-right"><%=list.getValue().getQuantity()%></td>
						<td class="text-right"><%=list.getValue().getProduct().getDongia()%></td>
						<td class="text-right"><%=list.getValue().getQuantity() * list.getValue().getProduct().getDongia()%></td>
						<td>
							<a id="delete_3" data-sp-ma="4" href="cartServlet?command=remove&productID=<%=list.getValue().getProduct().getMasanpham()%>"
							class="btn btn-danger btn-delete-sanpham">   Xóa
						</a> 
						</td>
					</tr>
					<%
			}
			
			%>
			<%
		} catch (Exception ex) {
		out.print(ex.getMessage());
		}
		%>
				</tbody>
			</table>
			<a href="index.jsp" class="btn btn-warning btn-md"><i
				class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;Quay về trang
				chủ</a> <a href="checkout.html" class="btn btn-primary btn-md"><i
				class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;Thanh toán</a>
		</div>
	</div>
</body>
</html>
