/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.cidades;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UFPR
 */
public class Conexao {
    
    private static Conexao unique;
    Connection c;
    
    private Conexao(){
        
    }
    
    public static Conexao getInstance(){
        if (unique == null) {
            unique = new Conexao();
        }
        return unique;
    }
    
    public ResultSet ExecutarConsulta(String sql){
        try {
            c = DriverManager.getConnection("jdbc:sqlite:bancocidades.db");
            Statement stm = c.createStatement();
            PreparedStatement psm = c.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            //c.close();
            return rs;
        } catch (SQLException ex){
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    void close() {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
