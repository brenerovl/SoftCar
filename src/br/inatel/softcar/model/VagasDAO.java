/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.softcar.model;

import controller.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Brener
 */
public class VagasDAO {

    public int id;
    public String nome;

    public void alterarEstacionamento(Vagas v) {

        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO vagas (id, setor, estado)VALUES(?, ?, ?)");

            stmt.setInt(1, v.getId());
            stmt.setBoolean(2, v.isEstado());
            stmt.setString(3, v.getSetor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar." + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }
}
