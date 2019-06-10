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
public class UsuarioDAO {
    public int id;
    public String nome;
    public void create(Usuario u) {

        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario (nome, email, senha)VALUES(?, ?, ?)");

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar. " + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean login(String email, String senha) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idUsuario");
                nome = rs.getString("nome");
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
    public ArrayList<String> carregarVeiculos(int id) {
        ArrayList<String> listaVeiculos = new ArrayList();
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT veiculo.placa, veiculo.modelo, veiculo.tipo FROM veiculo, usuario_has_veiculo WHERE veiculo.placa = usuario_has_veiculo.veiculo_placa and usuario_has_veiculo.usuario_idUsuario = ?");
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            while(rs.next()){
                listaVeiculos.add(rs.getString("placa")+"    "+rs.getString("modelo")+"    "+rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return listaVeiculos;
    }
    
    public String carregaDadosTelaCliente(int idUsuarioLogado) {
        String nomeUsuario = "";
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT nome FROM usuario WHERE idUsuario = ?");
            
            stmt.setInt(1, idUsuarioLogado);
            
            rs = stmt.executeQuery();
            if(rs.next()){
                nomeUsuario = rs.getString("nome");
            }
            
        } catch (SQLException ex){
            
        } finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        
        return nomeUsuario;
    }
}
