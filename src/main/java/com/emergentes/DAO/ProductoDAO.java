package com.emergentes.DAO;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ysai
 */
public class ProductoDAO extends ConexionBD implements IProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PRODUCTOS (DESCRIPCION, CANTIDAD, PRECIO) "
                    + "VALUES (?,?,?)";
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());
            ps.setFloat(3, producto.getPrecio());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PRODUCTOS SET DESCRIPCION=?, CANTIDAD=?, PRECIO=? "
                    + "WHERE ID=?";
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());
            ps.setFloat(3, producto.getPrecio());
            ps.setInt(4, producto.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM PRODUCTOS WHERE ID=?";
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public List<Producto> getAll() throws Exception {
        ArrayList<Producto> listaProducto = new ArrayList<Producto>();
        try {
            this.conectar();
            String sql = "SELECT * FROM PRODUCTOS";
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getFloat("precio"));
                listaProducto.add(producto);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return listaProducto;
    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto producto = new Producto();
        try{
            this.conectar();
            String sql = "SELECT * FROM PRODUCTOS WHERE ID=?";
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                producto.setId(rs.getInt("id"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getFloat("precio"));
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return producto;
    }
}
