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
    
    public boolean cadastrarPart(String data_part,String hora_part, String local_part, int fk_comp,int fk_time1,int fk_time2){
        conexao = data.getConnection();
        String SQL = "SELECT * FROM partida WHERE local_part = ? and fk_comp = ? and fk_time1 = ? and fk_time2 =? ";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setString(1, local_part);
            ps.setInt(2, fk_comp);
            ps.setInt(3, fk_time1);
            ps.setInt(4, fk_time2);
            rs = ps.executeQuery();

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Partida já cadastrado");
                data.closeDataSource();

                return true;
            } else{
                SQL = "INSERT INTO partida (data_part,horario_part,local_part,fk_comp,fk_time1,fk_time2) VALUES (?,?,?,?,?,?)";

                try {
                    ps = (PreparedStatement)conexao.prepareStatement(SQL);
                    ps.setString(1, data_part);
                    ps.setString(2, hora_part);
                    ps.setString(3, local_part);
                    ps.setInt(4, fk_comp);
                    ps.setInt(5, fk_time1);
                    ps.setInt(6, fk_time2);
                    retUpdate = ps.executeUpdate();


                    if(retUpdate == 1){
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
                        data.closeDataSource();
    
                        return true;
                    } else{
                        JOptionPane.showMessageDialog(null, "----ERRO!----");
                    }
                    
                } catch (SQLException exSQL) {
                    System.out.println("------------ERRO: INSERT INTO----------");
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
