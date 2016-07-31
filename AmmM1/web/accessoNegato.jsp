<%-- 
    Document   : accessoNegato
    Created on : 24-lug-2016, 17.53.52
    Author     : Eleonora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp" />
    
    <body>
        <div class="barra">
            <ul>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="Descrizione.jsp">Home</a></li>
            </ul>
        </div>
        
        <div class="header">
            <header>
                <h1> Nerd Stock! </h1>
        </header> 
        
        <c:if test="${sessionScope.utente != null}">
            <div id="logout"><a href="logout.html">Logout</a></div>
        </c:if>
            
            <div id="main">
                <h1> ACCESSO NEGATO! </h1>
                <p align="center"> Non hai i permessi per accedere a questa pagine!</p>
            </div>
     <jsp:include page="footer.jsp" />    
    </body>
</html>
