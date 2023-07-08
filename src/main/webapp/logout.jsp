<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    HttpSession sessionOBJ = request.getSession();
    session.invalidate(); // Hủy phiên (logout)
%>
<!-- Chuyển hướng người dùng đến trang đăng nhập sau khi logout -->
<script>
    window.location.href = "Login.jsp";
</script>
