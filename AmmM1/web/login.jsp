<%-- 
    Document   : login
    Created on : 4-mag-2016, 17.42.28
    Author     : Eleonora
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <jsp:include page="head.jsp" />
    
    <body>       
        <div class="barra">
            <ul>
                <li><a href="descrizione.jsp"> Indietro </a></li>
            </ul>
        </div>

        <div class="header">
            <header>
                <h2> Entra su Nerd Stock! </h2>
            </header>
        </div>

        <div class="container">
            <div id="form">
                <!-- Form per il Login -->

                        <form action="login.html" method="POST">
                                <input type="hidden" name="cmd" value="login">
                                <p>
                                    <label for="user">Username</label>
                                    <input type="text" name="user" id="user"> 
                                </p>
                                <p>
                                    <label for="password">Password</label>
                                    <input type="password" name="psw" id="psw"> 
                                </p>
                                <p>
                                    <input type="submit" name="submit" value="Login">˙
                                </p>
                        </form>

                    
                    <c:if test="${inputError == true}">
                        <p class="errore"> Accesso negato! </p>
                    </c:if>

                    
            </div>
            <jsp:include page="footer.jsp" />
        </div>
     </body>
</html>