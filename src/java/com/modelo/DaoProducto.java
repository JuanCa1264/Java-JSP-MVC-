
package com.modelo;

import com.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JC
 */
public class DaoProducto extends Conexion{
    public List<Producto> mostrarProducto() throws Exception{
        ResultSet rs;
        List<Producto> lst = new ArrayList();
        try {
            this.conectar();
            String sql = "select * from producto";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            Producto prod;
            rs = pst.executeQuery();
            while(rs.next()){
                Proveedor prov = new Proveedor();
                prov.setCodigoProveedor(rs.getInt("codigoProveedor"));
                prod = new Producto(rs.getInt("codigoProducto"),
                rs.getString("nombre"), rs.getString("categoria"),
                rs.getDouble("precio"),rs.getInt("anioFabricacion"),
                rs.getInt("anioVencimiento"),prov);
                lst.add(prod);
                
                
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
        return lst;
 
    }
    
    public void insertarProducto(Producto pro) throws Exception{
        try {
            this.conectar();
            String sql = "insert into producto values (?,?,?,?,?,?,?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, pro.getCodigoProducto());
            pst.setString(2, pro.getNombre());
            pst.setString(3, pro.getCategoria());
            pst.setDouble(4, pro.getPrecio());
            pst.setInt(5, pro.getAnioFabricacion());
            pst.setInt(6, pro.getAnioVencimiento());
            pst.setInt(7, pro.getProveedor().getCodigoProveedor());
            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    
    public void modificarProducto(Producto pro) throws Exception{
        try {
            this.conectar();
            String sql = "update producto set nombre = ?, categoria = ?, precio = ?, anioFabricacion = ?, anioVencimiento = ?, codigoProveedor = ? where codigoProducto = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            
            pst.setString(1, pro.getNombre());
            pst.setString(2, pro.getCategoria());
            pst.setDouble(3, pro.getPrecio());
            pst.setInt(4, pro.getAnioFabricacion());
            pst.setInt(5, pro.getAnioVencimiento());
            pst.setInt(6, pro.getProveedor().getCodigoProveedor());
            pst.setInt(7, pro.getCodigoProducto());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    
    public void eliminarProducto(Producto pro) throws Exception{
        try {
            this.conectar();
            String sql = "delete from producto where codigoProducto = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
         
            pst.setInt(1, pro.getCodigoProducto());
            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    
    public List<Proveedor> listarProveedores() throws Exception{
        ResultSet rs;
        List<Proveedor> lst = new ArrayList();
        try {
            this.conectar();
            String sql = "Select * from proveedor";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Proveedor prov = new Proveedor();
                prov.setCodigoProveedor(rs.getInt("codigoProveedor"));
                prov.setNombre(rs.getString("nombre"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setTelefono(rs.getString("telefono"));
                lst.add(prov);
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
        return lst;
    }
    
}
