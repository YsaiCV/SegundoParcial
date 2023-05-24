package com.emergentes.DAO;

import com.emergentes.modelo.Producto;
import java.util.List;

/**
 *
 * @author Ysai
 */
public interface IProductoDAO {
    public void insert(Producto producto) throws Exception;
    public void update(Producto producto) throws Exception;
    public void delete(int id) throws Exception;
    public List<Producto> getAll() throws Exception;
    public Producto getById(int id) throws Exception;
}
