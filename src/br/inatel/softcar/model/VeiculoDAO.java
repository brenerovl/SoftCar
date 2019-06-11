/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.softcar.model;

import com.sun.javafx.geom.ConcentricShapePair;
import controller.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Brener
 */
public class VeiculoDAO {

    public void create(Veiculo v, int idUser) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO veiculo (placa, modelo, tipo)VALUES(?, ?, ?)");

            stmt.setString(1, v.getPlaca());
            stmt.setString(2, v.getModelo());
            stmt.setString(3, v.getTipo());

            stmt.executeUpdate();

            createLinkUserVehicle(idUser, v.getPlaca());
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar. 'carinha tisti'" + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }

    public void createLinkUserVehicle(int idUser, String placa) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO usuario_has_veiculo (usuario_idUsuario, veiculo_placa)VALUES(?, ?)");

            stmt.setInt(1, idUser);
            stmt.setString(2, placa);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar. 'carinha tisti'" + ex);
        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }

    }

    public void deletarVeiculo(String placa) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM veiculo WHERE placa = ?");

            stmt.setString(1, placa);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }

    }
}
