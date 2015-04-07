<%@ page import="com.google.common.collect.Lists" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="com.desmond.entity.User" %>


<%final List<User> userNames = (List<User>) request.getSession().getAttribute("servletResponse");
    application.setAttribute("people", userNames);
%>
<html>


<%--<title>Crud application< /title>--%>
<body BACKGROUND="background1.jpg">
<br>
<form align="center" name="posResetForm" action="servlet" method="post">
    <input align="center" style="width: 200px" class="button" type="submit" name="button_id" value="Show me all Users from BD"/>
</form>

<%
    if (userNames !=null) {
%>
<br>
<form  align="center" name="Search" action="servlet" method="post" >
    <%--<td align="center"><input type="text" name="searchName" size="30"></td>--%>
     <td align="center"><input type="text" size="30" name="searchName" style="color: #777;" value="Search by name" onfocus="if (this.value == 'Search by name')
     {this.value = ''; this.style.color = '#000';}" onblur="if (this.value == '') {this.value = 'Search by name';
     this.style.color = '#777';}" /></td>
    <td><input  align="center" style="width: 100px" class="button" type="submit" name="button_id" value="Search"/></td>

</form>

<table align="center" border="1" cellpadding="5" cellspacing="1">
    <tr bgcolor="#ffa07a">
        <td style="width: 100px"><c:out value="Name" /></td>
        <td style="width: 30px"><c:out value="Age" /></td>
        <td style="width: 200px" align="center" ><c:out value="CreatedDate" /></td>
        <td style="width: 50px"><c:out value="Admin" /></td>
        <td style="width: 70px" align="center"><c:out value="Function" /></td>
    </tr>
    <c:forEach var="person" items="${people}">
        <tr bgcolor="#ccffcc">
            <td ><c:out value="${person.name}" /></td>
            <td><c:out value="${person.age}" /></td>
            <td><c:out value="${person.createdDate}" /></td>
            <td align="center"><c:out value="${person.admin}" /></td>

            <c:set var="user_id" scope="session" value="${person.id}"/>
            <td>
                <form  style="margin: 0;"   name="deleteUser" action="servlet" method="post">
                  <input style="width: 70px" align="center" class="button" id="${person.id}" type="submit" name="button_id" value="delete" />
                    <input name="userId" style="display: none" value="<c:out value="${person.id}" />"/>
                </form>
                <form  style="margin: 0" name="editUser" action="servlet" method="post">
                    <input style="width: 70px" align="center" class="button" id="${person.id}" type="submit" name="button_id" value="edit" />
                </form>
            </td>
        </tr>
    </c:forEach>



</table>
<br>

<table align="center">
    <tr>
        <td>
            <form align="center" name="posResetForm" action="servlet" method="post">
               <input align="center" class="button"  type="submit" name="button_id" value="hide"/>
            </form>
        </td>
        <td>
            <form align="center" name="posResetForm" action="servlet" method="post">
              <input align="center" class="button"  type="submit" name="button_id" value="reset"/>
            </form>
        </td>
    </tr>
</table>

<%
        }
%>


<table align="center" cellpadding="5" cellspacing="1">
    <tr>
        <td align="center"><c:out value="Name" /></td>
        <td align="center"><c:out value="Age" /></td>
        <td align="center"><c:out value="Admin" /></td>
    </tr>
    <tr>

            <form  align="center" name="CreateNewUser" action="servlet" method="post" >
                <td align="center"><input type="text" name="inputName" size="15"></td>
                <td align="center"><input type="text" name="inputAge" size="15"></td>
                <td align="center"><input type="checkbox" name="inputAdm" ></td>
                <tr><td><input  align="center" style="width: 138px" class="button" type="submit" name="button_id" value="Create new user"/></td></tr>
            </form>

    <tr>

</table>



</body>
</html>
