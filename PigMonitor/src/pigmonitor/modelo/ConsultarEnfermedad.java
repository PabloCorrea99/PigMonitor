/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConsultarEnfermedad extends Conexion {
    
    public boolean registrar(Enfermedad enf){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO enfermedad (codigoEnfermedad, nombreEnfermedad, cerdosAfectados) VALUES(?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, enf.getCodigoEnfermedad());
            ps.setString(2, enf.getNombreEnfermedad());
            ps.setInt(3, enf.getCerdosAfectados());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    } 
    
    public boolean modificar(Enfermedad enf){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "UPDATE enfermedad SET codigoEnfermedad=? ,nombreEnfermedad=?, cerdosAfectados=? WHERE idEnfermedad=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, enf.getCodigoEnfermedad());
            ps.setString(2, enf.getNombreEnfermedad());
            ps.setInt(3, enf.getCerdosAfectados());
            ps.setInt(4, enf.getIdEnfermedad());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(Enfermedad enf){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM enfermedad WHERE idEnfermedad=?";
        
        try{
         
            ps = con.prepareStatement(sql);
            ps.setInt(1, enf.getIdEnfermedad());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean buscar(Enfermedad enf){
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM enfermedad WHERE codigoEnfermedad=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, enf.getCodigoEnfermedad());
            rs = ps.executeQuery();
            
            if(rs.next()){
               enf.setIdEnfermedad(Integer.parseInt(rs.getString("idEnfermedad")));
               enf.setCodigoEnfermedad(rs.getString("codigoEnfermedad"));
               enf.setNombreEnfermedad(rs.getString("nombreEnfermedad"));
               enf.setCerdosAfectados(Integer.parseInt(rs.getString("cerdosAfectados")));
               return true;         
            }
      
            return false;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
}
