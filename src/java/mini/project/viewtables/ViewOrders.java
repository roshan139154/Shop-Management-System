/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.project.viewtables;

import db.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author doodl
 */
public class ViewOrders extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            int shop_id=Integer.parseInt(request.getParameter("shop_id"));
            DatabaseConnection db=new DatabaseConnection();
            Statement st=db.con.createStatement();
            ResultSet rs=null;
            String query="select * from orders where shop_id="+shop_id;
            rs=st.executeQuery(query);
            List ls=new ArrayList();
            while(rs.next())
            {
                ls.add(rs.getInt("order_id"));
                ls.add(rs.getDate("order_date"));
                ls.add(rs.getString("cust_id"));
                ls.add(rs.getInt("hardware_id"));
                ls.add(rs.getString("email"));
                ls.add(rs.getInt("phone"));
                ls.add(rs.getInt("shop_id"));
                ls.add(rs.getInt("stock"));
                ls.add(rs.getFloat("price"));
            }
            RequestDispatcher rd=request.getRequestDispatcher("vieworders.jsp");
            request.setAttribute("orders",ls);
            rd.forward(request, response);
        }
        catch(IOException | ClassNotFoundException | NumberFormatException | SQLException | ServletException e)
        {
            out.println("Error    :"+e);
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

}
