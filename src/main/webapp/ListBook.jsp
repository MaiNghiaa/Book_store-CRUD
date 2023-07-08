	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ page import="DAO.BookDAO" %>
<%@ page import="DAO.BookDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Book" %>
	
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionOBJ = request.getSession();
    String username = (String) session.getAttribute("username");
%>

<%
BookDAO bookDAO = new BookDAOImpl();
    int pageNumber = Integer.parseInt(request.getParameter("page") != null ? request.getParameter("page") : "1");
    int itemsPerPage = 3;
    int startIndex = (pageNumber - 1) * itemsPerPage;
    List<Book> bookList = bookDAO.getBookByOffsetAndPageSize(startIndex, itemsPerPage);
    int totalItems = bookDAO.getTotalRecord();
    int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
%>

	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style>
	.center{
	display: flex;
	flex-direction: column;
	justify-content:center;
	align-items: center;
	}
	td{
	padding:7px 12px;
	}
	</style>
	</head>
	<body>
			<div class="center">
			<%= username %>
			<form action="logout.jsp" method="post">
    <button type="submit">Logout</button>
</form>
			<h3 style="color:red">${err }</h3>
			<h3 style="color:green">${success }</h3>
				<h1>List Books</h1>
				<button>
				<a href="InsertBook.jsp">Add</a>
				</button>
        
			<table border="1" style="border-collapse: collapse; padding:10px 12px">
				<tr>
					<th style="padding:0px 20px">id</th>
					<th>name</th>
					<th>Code</th>
					<th>image</th>
					<th>price</th>
					<th style="padding:30px 40px">action</th>
				</tr>
				<c:forEach items="${list}" var="s">
				<tr class="list">
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.book_code }</td>
				<td><img src="${s.images }" style="width:width:50px; height:150px; object-fit:cover"></td>
				<td>${s.price }</td>
				<td>
				<a href="PreUpdateBook?id=${s.id }">Update</a>
				 <a href="DeleteBook?id=${s.id }" onclick="return confirm('Ban chac chua?')">Delete</a>
				</td>
				</tr>
				</c:forEach>
				
			</table>
			<div style="margin-top: 10px;">
            <% if (pageNumber > 1) { %>
                <a href="ListBook.jsp?page=<%= pageNumber - 1 %>">&lt; Prev</a>
            <% } %>
            
            <% for (int i = 1; i <= totalPages; i++) { %>
                <% if (i == pageNumber) { %>
                    <strong><%= i %></strong>
                <% } else { %>
                    <a href="ListBook.jsp?page=<%= i %>"><%= i %></a>
                <% } %>
            <% } %>
            
            <% if (pageNumber < totalPages) { %>
                <a href="ListBook.jsp?page=<%= pageNumber + 1 %>">Next &gt;</a>
            <% } %>
        </div>
			</div>
	</body>
	</html> 