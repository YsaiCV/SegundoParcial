<%-- 
    Document   : formularioProducto
    Created on : 23 may. de 2023, 20:46:37
    Author     : Ysai
--%>

<%@page import="com.emergentes.modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Producto producto = (Producto) request.getAttribute("producto");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <%if(producto.getId() == -1){%>
            <h1>Nuevo Producto</h1>
        <%}else{%>
            <h1>Editar Producto</h1>
        <%}%>
        <form action="ControladorMain" method="post">
            <td><input type="text" name="id" hidden="true" value="${producto.id}"></td>
            <table>
                <tr>
                    <td>Descripcion: </td>
                    <td><input type="text" name="descripcion" value="${producto.descripcion}"></td>
                </tr>
                <tr>
                    <td>Cantidad: </td>
                    <td><input type="number" min="0" name="cantidad" value="${producto.cantidad}"></td>
                </tr>
                <tr>
                    <td>Precio: </td>
                    <td><input type="number" min="0" step="0.01" name="precio" value="${producto.precio}"></td>
                </tr>
                <tr>
                    <td>Categoria: </td>
                    <td><input type="text" name="categoria" value="${producto.categoria}"></td>
                </tr>
            </table>
            <input type="submit" value="Guardar">
        </form>
    </body>
</html>
