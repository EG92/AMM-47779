<%-- 
    Document   : Cliente
    Created on : 4-mag-2016, 17.41.04
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
                <li><a href="descrizione.jsp"> Descrizione </a></li> 
                <div class="accessoutente">
                    <p> Bentornato!!</p>       
                </div>
                
            </ul>
        </div>
    <br><br>
        <div class="container">
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Foto</th>
                    <th>Quantita'</th>
                    <th>Prezzo</th>
                    <th>link</th>
                </tr>
                <tr>
                    <td> One piece vol. 1 </td>
                    <td><img title="OPv1" alt="OP vol.1" src="Immagini/OPv1.png" width="80" height="100"></td>
                    <td> 10 </td>
                    <td> 3.50 E </td>
                <td> <a href='cliente.html'> Aggiungi al carrello </a> </td>
                </tr>
                <tr>
                    <td> Funko Pop: Batman </td>
                    <td><img title="FPBat" alt="Funko Pop: Batman" src="Immagini/FPBat.jpg" width="80" height="100"></td>
                    <td> 5 </td>
                    <td> 15 E </td>
                    <td> <a href='cliente.html'> Aggiungi al carrello </a> </td>
                </tr>
                <tr>
                    <td> Cable & Deadpool 2 </td>
                    <td><img title="CD2" alt="CABLE & DEADPOOL 2" src="Immagini/C&D2.jpg" width="80" height="100"></td>
                    <td> 10 </td>
                    <td> 3.50 E </td>
                    <td> <a href='cliente.html'> Aggiungi al carrello </a> </td>
                </tr>
                <tr>
                    <td> Action Figure Sailor Moon </td>
                    <td><img title="ACSailorM" alt="Action Figure Sailor Moon" src="Immagini/SailorMoon.jpg" width="80" height="100"></td>
                    <td> 2 </td>
                    <td> 30 E </td>
                    <td> <a href='cliente.html'> Aggiungi al carrello </a> </td>
                </tr>
                <tr>
                    <td> Uncharted Drake Collection </td>
                    <td><img title="Uncharted" alt="Uncharted" src="Immagini/uncharted.jpg" width="80" height="100"></td>
                    <td> 3 </td>
                    <td> 45.50 E </td>
                    <td><a href='cliente.html'> Aggiungi al carrello </a> </td>
                </tr>
            </table>
        </div>
            
            <%-- 
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Foto</th>
                    <th>Quantita'</th>
                    <th>Prezzo</th>
                    <th>link</th>
                </tr>
                <c:forEach var = "ogg" items = "${listaOggetti}"> 
                    <tr>
                         <!-- Genero la lista dinaminca degli Oggetti -->
                        <td>   ${ogg.getNome}   </td>
                        <td>    <img src="${ogg.getURL}" title="${ogg.getNome}" alt="${ogg.getNome}"</td>
                        <td> ${ogg.getQuantita}</td>
                        <td> ${ogg.getPrezzo}</td> 
                        <td> <a href="cliente.html?idOggetto=${ogg.getId}"> Acquista </a></td> 
                    </tr>
                </c:forEach>
                
            </table>
            --%>

        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
