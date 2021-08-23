package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

import classes.Partida;

public class PartidaDAO {

    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int retUpdate;
    DataSource data = new DataSource();

    public PartidaDAO(){
    
    }

    public boolean setPlacar(Partida partida){
        conexao = data.getConnection();

        String SQL = "SELECT * FROM partida WHERE id_part = ?";

        try{
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, partida.getId_part());
            rs = ps.executeQuery();

            if(rs.next()){
                SQL = "Update partida set placar_part = ? where id_part = ?";

                try {
                    ps = (PreparedStatement)conexao.prepareStatement(SQL);
                    ps.setString(1, partida.getPlacar_part());
                    ps.setInt(2, partida.getId_part());
                    retUpdate = ps.executeUpdate();

                    if(retUpdate == 1){
                        JOptionPane.showMessageDialog(null, "Placar cadastrado com sucesso!");
                        data.closeDataSource();
    
                        return true;
                    } else{
                        JOptionPane.showMessageDialog(null, "----ERRO!----");
                    }

                } catch (SQLException exSQL) {
                    System.out.println("------------ERRO: UPDATE----------");
                    JOptionPane.showMessageDialog(null, exSQL);
                }
            }
        } catch (SQLException exSQL) {
            System.out.println("-----------ERRO: SELECT FROM----------");
            JOptionPane.showMessageDialog(null, exSQL);
        }


        return false;
    }
}
