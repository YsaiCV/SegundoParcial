<%-- 
    Document   : index
    Created on : 23 may. de 2023, 18:47:17
    Author     : Ysai
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Producto> listaProducto = (List<Producto>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div>
            <ul>
                <li>Segundo Parcial</li>
                <li>Nombre: Ysai Javier Condori Velez</li>
                <li>Carnet: 10032357 LP</li>
            </ul>
        </div>

        <h1>Gestión de productos</h1>
        <a href="ControladorMain?action=insert">Nuevo producto</a>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>DESCRIPCION</th>
                    <th>CANTIDAD</th>
                    <th>PRECIO</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Producto producto : listaProducto){
                %>
                    <tr>
                        <td><%=producto.getId()%></td>
                        <td><%=producto.getDescripcion()%></td>
                        <td><%=producto.getCantidad()%></td>
                        <td><%=producto.getPrecio()%></td>
                        <td><a href="ControladorMain?action=update&id=<%=producto.getId()%>">Editar</a></td>
                        <td><a href="ControladorMain?action=delete&id=<%=producto.getId()%>">Eliminar</a></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
