<%-- 
    Document   : logout
    Created on : Aug 31, 2020, 12:55:19 PM
    Author     : Roshan Withanage
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    session.invalidate();
    response.sendRedirect("login.jsp");
    %>
</html>
