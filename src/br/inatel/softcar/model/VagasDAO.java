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

    public void alterarEstacionamento(int idVagaOcupada, int idUsuarioLogado) {

        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            int isOccupied = 0;
            stmt = con.prepareStatement("SELECT vagas_idVagas FROM usuario WHERE idUsuario = ?");

            stmt.setInt(1, idUsuarioLogado);
            rs = stmt.executeQuery();
            if (rs.next()) {
                isOccupied = rs.getInt("vagas_idVagas");
            }

            if (isOccupied == 0) {
                stmt = con.prepareStatement("UPDATE vagas SET estado = 1 WHERE idVagas = ?");

                stmt.setInt(1, idVagaOcupada);

                stmt.executeUpdate();

                stmt = con.prepareStatement("UPDATE usuario SET vagas_idVagas = ? WHERE idUsuario = ?");

                stmt.setInt(1, idVagaOcupada);
                stmt.setInt(2, idUsuarioLogado);

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Você já está ocupando uma vaga!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar." + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt, rs);
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

    public void desocuparVaga(int idUsuarioLogado) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            int vagaOcupada = 0;
            stmt = con.prepareStatement("SELECT vagas_idVagas FROM usuario WHERE idUsuario = ?");

            stmt.setInt(1, idUsuarioLogado);

            rs = stmt.executeQuery();
            if (rs.next()) {
                vagaOcupada = rs.getInt("vagas_idVagas");
                System.out.println(vagaOcupada);
            }

            if (vagaOcupada != 0) {
                stmt = con.prepareStatement("UPDATE vagas SET estado = 0 WHERE idVagas IN ( SELECT usuario.vagas_idVagas FROM usuario WHERE idUsuario = ?)");

                stmt.setInt(1, idUsuarioLogado);

                stmt.executeUpdate();

                stmt = con.prepareStatement("UPDATE usuario SET vagas_idVagas = null WHERE idUsuario = ?");

                stmt.setInt(1, idUsuarioLogado);

                stmt.executeUpdate();
            } else if (vagaOcupada == 0) {
                JOptionPane.showMessageDialog(null, "Você não está ocupando nenhuma vaga!");
            }
            if (vagaOcupada != 0) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar." + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }
    }

    public void atualizarVagas(ArrayList<Integer> listaVagas) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int[] vagasOcupadas = new int[13];
        boolean auxAtualizar = false;
        for (int i = 0; i < 13; i++) {
            vagasOcupadas[i] = 0;
        }
        try {
            stmt = con.prepareStatement("SELECT vagas_idVagas FROM usuario");

            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                    vagasOcupadas[rs.getInt("vagas_idVagas")] = rs.getInt("vagas_idVagas");
            
            }
            for (int i = 1; i <= listaVagas.size(); i++) {
                
                if (vagasOcupadas[i] == 0) {
                    
                    stmt = con.prepareStatement("UPDATE vagas SET estado = ? WHERE idVagas = ?");

                    stmt.setInt(1, listaVagas.get(i - 1));
                    stmt.setInt(2, i);
                    
                    stmt.executeUpdate();
                } else {
                    auxAtualizar = true;
                }
            }
            if (auxAtualizar) {
                JOptionPane.showMessageDialog(null, "Algumas vagas não puderam ser atualizadas por estarem ocupadas!");
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(VagasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }
}
