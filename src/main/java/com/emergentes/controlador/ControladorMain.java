package com.emergentes.controlador;

import com.emergentes.DAO.ProductoDAO;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ysai
 */
@WebServlet(name = "ControladorMain", urlPatterns = {"/ControladorMain"})
public class ControladorMain extends HttpServlet {

    ProductoDAO productosDAO = new ProductoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action") != null ? request.getParameter("action") : "list";
        System.out.println(action);

        if (action.equals("list")) {
            try {
                request.setAttribute("lista", productosDAO.getAll());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } else if (action.equals("insert")) {
            Producto producto = new Producto();
            producto.setId(-1);
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("formularioProducto.jsp").forward(request, response);
            
        } else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Producto producto = null;
            try {
                 producto = productosDAO.getById(id);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("formularioProducto.jsp").forward(request, response);
            
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                productosDAO.delete(id);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            response.sendRedirect("ControladorMain");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.parseFloat(request.getParameter("precio"));
        String categoria = request.getParameter("categoria");
        
        Producto producto = new Producto();
        
        producto.setId(id);
        producto.setDescripcion(descripcion);
        producto.setCantidad(cantidad);
        producto.setPrecio(precio);
        producto.setCategoria(categoria);
        
        if(producto.getId() == -1){
            try {
                productosDAO.insert(producto);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }finally{
                response.sendRedirect("ControladorMain");
            }
        }else{
            try {
                productosDAO.update(producto);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }finally{
                response.sendRedirect("ControladorMain");
            }
        }
        
    }

}
