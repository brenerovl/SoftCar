/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.softcar.model;

import controller.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Brener
 */
public class VagasDAO {

    public int id;
    public String nome;
    

    public void alterarEstacionamento(int idVagaOcuapda) {
        
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE vagas SET estado = 1 WHERE idVagas = ?");
            
            stmt.setInt(1, idVagaOcuapda);
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar." + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Integer> lerEstacionamento() {
        ArrayList<Integer> listaVagas = new ArrayList();
        
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM vagas");

            rs = stmt.executeQuery();

            while (rs.next()) {
                listaVagas.add(rs.getInt("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return listaVagas;
    }
    public void desocuparVaga(int id) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE vagas SET estado = 0 WHERE idVagas = ?");
            
            stmt.setInt(1, id);
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar." + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }
}
