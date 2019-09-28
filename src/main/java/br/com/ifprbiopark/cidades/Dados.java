/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.cidades;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UFPR
 */
public class Dados {
    public List<Estado>getEstados(){
        
        List<Estado> lista = new ArrayList();
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:bancocidades.db");
            Statement stm = c.createStatement();
            String sql = "SELECT * FROM ESTADO";
            PreparedStatement psm = c.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()){
                Estado e = new Estado();
                e.setId(rs.getInt("ID"));
                e.setNome(rs.getString("NOME"));
                e.setSigla(rs.getString("SIGLA"));
                lista.add(e);
            }
        c.close();
        } catch (SQLException ex){
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public List<Cidade>getCidades(int idEstado){
        List<Cidade> lista2 = new ArrayList();
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:bancocidades.db");
            Statement stm = c.createStatement();
            String sql = "SELECT * FROM CIDADE WHERE ESTADO_ID = ";
            sql += String.valueOf(idEstado);
            PreparedStatement psm = c.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()){
                Cidade city = new Cidade();
                city.setId(rs.getInt("ID"));
                city.setNome(rs.getString("NOME"));
                lista2.add(city);
            }
        c.close();
        } catch (SQLException ex){
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista2;
    }
}
