/*
 * To /change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import amm.model.*;
import amm.factory.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Eleonora
 */

@WebServlet(name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        /*Genero la stringa usata per la connessione al db */
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*Stringhe di connessione per tutte le factory che devono connettersi al db*/
        OggettiFactory.getInstance().setConnectionString(dbConnection);
        ClienteFactory.getInstance().setConnectionString(dbConnection);
        VenditoreFactory.getInstance().setConnectionString(dbConnection);
        SaldoFactory.getInstance().setConnectionString(dbConnection);
        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        /*creo la sessione*/
        HttpSession session = request.getSession(true);
        
        if (request.getParameter("submit") != null) {
            //È stato premuto Accedi, controlliamo se le credenziali sono valide
            String username = (String) request.getParameter("user");
            String password = (String) request.getParameter("psw");

            //Inizio controllando se è un cliente
            Cliente cliente = ClienteFactory.getInstance().cercaCliente(username, password);
            if(cliente != null){
                //l'utente si è loggato come cliente
                //Imposto gli attributi di sessione
                    session.setAttribute("user", cliente);
                    //Preparo la lista di oggetti e passo il controllo alla jsp
                    request.setAttribute("listaOggetti", OggettiFactory.getInstance().getOggettiList());
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
            //Devo controllare se è un venditore, visto che il controllo dei clienti non lo 
            //ha loggato
            Venditore venditore = VenditoreFactory.getInstance().cercaVenditore(username, password);
            if(venditore != null){
                //l'utente si è loggato come cliente
                //Imposto gli attributi di sessione
                    session.setAttribute("user", venditore);
                    //Preparo la lista di oggetti e passo il controllo alla jsp
                    request.setAttribute("listaOggetti", OggettiFactory.getInstance().getOggettiVend(((Venditore) session.getAttribute("user")).getId()));
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }

            //Se sono arrivato qui le credenziali non sono valide
            request.setAttribute("inputError", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        //Se sono in questo punto del codice non è stato tentato il login
        if (session.getAttribute("user") != null) {
            //L'utente è gia autenticato, lo rimando alla sua pagina
            if (session.getAttribute("user") instanceof Venditore) {
                //Preparo la lista di oggetti e passo il controllo alla jsp
                request.setAttribute("listaOggetti", OggettiFactory.getInstance().getOggettiList());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            } else {
                request.setAttribute("listaOggetti", OggettiFactory.getInstance().getOggettiVend(((Venditore) session.getAttribute("user")).getId()));
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }
        } else {
            //L'utente  deve ancora fare il login
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

        