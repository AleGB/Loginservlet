/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import BD.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;

@WebServlet(name = "ServletValidaUsuario", urlPatterns = {"/index.html"})
public class ServletValidaUsuario extends HttpServlet {

    String nombre;
    String password;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        nombre = request.getParameter("nombre");
        password = request.getParameter("contrasenia");

        String sql = "select * from usuario where usuario='" + nombre + "' and " + "contrasenia = '" + password + "';";

        try {
            Conexion con = new Conexion();
            ResultSet rs = con.Function(sql);
            while (rs.next()) {
                PrintWriter out = new PrintWriter(response.getOutputStream());
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>HOLA, BIENVENIDO</h1>");
                out.println("<p> Usuario sí existe </p>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (SQLException ex) {

            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lo lamento, no existe</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
