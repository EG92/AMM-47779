<%-- 
    Document   : venditore
    Created on : 4-mag-2016, 17.42.53
    Author     : Eleonora
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp" />

    <body> 
        <div class="page">
            <div class="barra">
                <ul>
                    <li><a href="descrizione.jsp">Descrizione </a></li>
                    <div class="accessoutente">
                        <p> Bentornato!!</p>       
                    </div>
                </ul>
            </div>  
            
            <div class="header">
                <header>
                     <h2> Inserimento Nuovo Oggetto </h2>
                </header>
            </div>

            <div id="form">
                <form action="venditore.html" method="POST">
                    <p>
                        Nome Oggetto <input type=text name="NomeOggetto" id="NomeOggetto" placeholder='Inserire nome oggetto'/>
                    </p>
                    <p>
                        URL immagine <input type=text name="ImmagineUrl" id="ImmagineUrl" placeholder='Inserire URL immagine'/> 
                    </p>
                    <p>
                        Descrizione oggetto<br><br>
                        <textarea name="Descrizione" id="Descrizione" rows=4 cols=20>  </textarea>
                    </p>
                    <p>
                        Quantita' <input type=text name="Quantita" id="Quantita" placeholder='Inserire quantita'/>
                    </p>
                    <p>
                        Prezzo <input type=text name=PrezzoOggetto id="PrezzoOggetto" placeholder='Inserire prezzo'/> 
                    </p>
                    
                    <p><input type="submit" name="submit"></p>
                </form>
            </div>
        </div>
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
