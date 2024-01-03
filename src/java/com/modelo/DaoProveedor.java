
package com.modelo;

import com.conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * 
 * @author JC
 */
public class DaoProveedor extends Conexion{
    
    public List<Proveedor> mostrarProveedor() throws SQLException{
        
       ResultSet rs;
       
       List<Proveedor> lst = new ArrayList();
        try {
            this.conectar();
            String sql ="Select * from proveedor";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Proveedor p = new Proveedor();
                p.setCodigoProveedor(rs.getInt("codigoProveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                lst.add(p);
            }
            
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
        
        return lst;
    }
    
    public void insertarProveedor(Proveedor p) throws SQLException{
        try {
            this.conectar();
            String sql = "Insert into proveedor values (?,?,?,?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, p.getCodigoProveedor());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getDireccion());
            pst.setString(4, p.getTelefono());
            pst.executeUpdate();
            
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    
    public void modificarProveedor(Proveedor p) throws Exception{
        try {
            this.conectar();
            String sql = "Update proveedor set nombre = ?, direccion = ?, telefono = ? where codigoProveedor=?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getDireccion());
            pst.setString(3, p.getTelefono());
            pst.setInt(4, p.getCodigoProveedor());
            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    
    public void eliminarProveedor(Proveedor p) throws SQLException{
        try {
            this.conectar();
            String sql = "Delete from proveedor where codigoProveedor=?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, p.getCodigoProveedor());
            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
            
    }
    
}
