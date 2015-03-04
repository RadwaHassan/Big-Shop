<%@page  import="bean.User" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<jsp:useBean id= "user" class="bean.User" scope="session" />
 <jsp:setProperty name= "user" property="*"/>
<jsp:forward page="/update"/>
