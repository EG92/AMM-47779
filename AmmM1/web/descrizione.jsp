<%-- 
    Document   : descrizione
    Created on : 4-mag-2016, 17.41.29
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
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </div>
            
        <div class="header">
            <header>
                <h1> Nerd Stock! </h1>
            </header>  
        </div>
            
        <div class="menu">
            <p><a href='#tit1'> Di cosa si tratta?! </a></p>
            <p><a href='#tit2'> Come comprare! </a></p>
        </div> 

        <div class="main">
            <a id='tit1'>
                <h2> Di cosa si tratta?! </h2>
            </a>
            Il sito permettera' la compravendita online di vari articoli e di vari generi di collezionismo.
            <a id='tit2'>
                <h3> Come comprare! </h3>
            </a>
            Per poter comprare sul nostro sito e' necessario iscriversi. Una volta effettuato l'accesso al proprio account 
            sara' possibile visionare il catalogo completo del sito e comprare cio' che si desidera.
            
        </div>
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
