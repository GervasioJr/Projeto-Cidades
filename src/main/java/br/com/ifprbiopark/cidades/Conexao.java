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
    public ResultSet ExecutarConsulta(String sql){
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:bancocidades.db");
            Statement stm = c.createStatement();
            PreparedStatement psm = c.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            return rs;
        } catch (SQLException ex){
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
