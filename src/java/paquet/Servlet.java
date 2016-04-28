/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ivan
 */
public class Servlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            iniciarJoc(1, "Jugador 1");
//            iniciarJoc(1, "Jugador 2");
            int codiPartida = 23;
            String Jug1 = "Jugador 1";
            String Jug2 = "Jugador 2";
            int pedra = 1;
            int paper = 2;
            int tisora = 3;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Iniciar Joc " + iniciarJoc(codiPartida, Jug1) + "</h1>");
            out.println("<h1>Iniciar Joc " + iniciarJoc(codiPartida, Jug2) + "</h1>");
            out.println("<h1>MoureJugador " + moureJugador(pedra,Jug1,codiPartida) + "</h1>");
            out.println("<h1>MoureJugador " + moureJugador(paper,Jug2,codiPartida) + "</h1>");
            int cons = consultarEstatPartida(codiPartida);
            out.println("<h1>consultarEstatPartida " + cons + "</h1>");
            
            if(cons > 1){
                out.println("<h1>Guanya " + Jug2 + "</h1>");
                out.println("<h1>Guanya " + acabarJoc(codiPartida) + "</h1>");
            }else if(cons < -1){
                out.println("<h1>Guanya " + Jug1 + "</h1>");
                out.println("<h1>Guanya " + acabarJoc(codiPartida) + "</h1>");
            }
            
            out.println("<h1>MoureJugador " + moureJugador(tisora,Jug1,codiPartida) + "</h1>");
            out.println("<h1>MoureJugador " + moureJugador(pedra,Jug2,codiPartida) + "</h1>");
            cons = consultarEstatPartida(codiPartida);
            out.println("<h1>consultarEstatPartida " + cons + "</h1>");
            
            if(cons > 1){
                out.println("<h1>Guanya " + Jug2 + "</h1>");
                out.println("<h1>Guanya " + acabarJoc(codiPartida) + "</h1>");
            }else if(cons < -1){
                out.println("<h1>Guanya " + Jug1 + "</h1>");
                out.println("<h1>Guanya " + acabarJoc(codiPartida) + "</h1>");
            }
            
            
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    
    private static Boolean iniciarJoc(int codiPartida, java.lang.String jug1) {
        paquet.Soap_Service service = new paquet.Soap_Service();
        paquet.Soap port = service.getSoapPort();
        return port.iniciarJoc(codiPartida, jug1);
    }

    private static Boolean moureJugador(int tipus, java.lang.String jug, int codiPartida) {
        paquet.Soap_Service service = new paquet.Soap_Service();
        paquet.Soap port = service.getSoapPort();
        return port.moureJugador(tipus, jug, codiPartida);
    }

    private static Integer consultarEstatPartida(int codiPartida) {
        paquet.Soap_Service service = new paquet.Soap_Service();
        paquet.Soap port = service.getSoapPort();
        return port.consultarEstatPartida(codiPartida);
    }

    private static Boolean acabarJoc(int codiPartida) {
        paquet.Soap_Service service = new paquet.Soap_Service();
        paquet.Soap port = service.getSoapPort();
        return port.acabarJoc(codiPartida);
    }

    
    
    
}
