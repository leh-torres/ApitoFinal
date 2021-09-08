package dao;

import classes.Competicao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

import classes.Partida;
import classes.Time;
import classes.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.scene.image.Image;

public class PartidaDAO {

    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private int retUpdate;
    private int id;
    private String resultado;
    DataSource data = new DataSource();
    public  static int[] id_selecionado = new int[16];

    public PartidaDAO(){
    
    }

    public int[] getId_selecionado() {
        return id_selecionado;
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
    
    public Image Imagem(int alterna){
        Competicao comp = new Competicao();
        conexao = data.getConnection();
        id = comp.getIdSelecionaCampeonato();
        if(alterna == 1){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time1 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part) FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[0] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 2){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time2 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part) FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[1] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 3){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time1 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+1 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[2] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 4){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time2 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+1 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[3] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 5){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time1 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+2 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[4] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 6){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time2 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+2 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[5] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 7){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time1 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+3 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[6] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 8){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time2 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+3 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[7] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 9){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time1 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+4 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[8] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 10){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time2 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+4 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[9] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 11){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time1 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+5 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[10] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 12){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time2 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+5 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[11] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }  
        else if(alterna == 13){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time1 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+6 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[12] = rs.getInt("id_time");
                Time time = new Time();
                time.setId_sorteado(id_selecionado);
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        } 
        else if(alterna == 14){
        String SQL = "SELECT * FROM times WHERE id_time = (SELECT fk_time2 FROM partida WHERE fk_comp = ? AND id_part = (SELECT MIN(id_part)+6 FROM partida WHERE fk_comp = ?))";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_time") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_time");
                id_selecionado[13] = rs.getInt("id_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        } 
        return null;
    }
    
    public String getData(int alterna){
        DataSource data = new DataSource();
        Connection conn = null;
        conn = data.getConnection();
        Competicao comp = new Competicao();
        id = comp.getIdSelecionaCampeonato();
        if(alterna == 1){
        String SQL = "SELECT MIN(data_part) as data_part FROM partida WHERE fk_comp = ?";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = rs.getString("data_part");
                data.closeDataSource();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            }

            return resultado;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 2){
        String SQL = "SELECT MIN(data_part)+1 as data_part FROM partida WHERE fk_comp = ?";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = rs.getString("data_part");
                data.closeDataSource();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            }

            return resultado;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 3){
        String SQL = "SELECT MIN(data_part)+2 as data_part FROM partida WHERE fk_comp = ?";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = rs.getString("data_part");
                data.closeDataSource();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            }

            return resultado;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 4){
        String SQL = "SELECT MIN(data_part)+3 as data_part FROM partida WHERE fk_comp = ?";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = rs.getString("data_part");
                data.closeDataSource();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            }

            return resultado;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        return null;
    } 
    
    public String getHora(int alterna){
        DataSource data = new DataSource();
        Connection conn = null;
        conn = data.getConnection();
        Competicao comp = new Competicao();
        id = comp.getIdSelecionaCampeonato();
        if(alterna == 1){
        String SQL = "SELECT MIN(horario_part) as horario_part FROM partida WHERE fk_comp = ?";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = rs.getString("horario_part");
                data.closeDataSource();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            }

            return resultado;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 2){
        String SQL = "SELECT MIN(horario_part)+1 as horario_part FROM partida WHERE fk_comp = ?";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = rs.getString("horario_part");
                data.closeDataSource();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            }

            return resultado;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 3){
        String SQL = "SELECT MIN(horario_part)+2 as horario_part FROM partida WHERE fk_comp = ?";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = rs.getString("horario_part");
                data.closeDataSource();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            }

            return resultado;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(alterna == 4){
        String SQL = "SELECT MIN(horario_part)+3 as horario_part FROM partida WHERE fk_comp = ?";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = rs.getString("horario_part");
                data.closeDataSource();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            }

            return resultado;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        return null;
    } 
    
     public int recuperaId(int id_time){
        Connection conn = null;
        DataSource data1 = new DataSource();
        conn = data1.getConnection();
        
        String SQL = "SELECT id_part FROM partida WHERE fk_time1 = ?";
        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, id_time);
            rs = ps.executeQuery();
            
            if(rs.next()){
                id = rs.getInt("id_part");
            }
            data1.closeDataSource();
            return id;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }   
     
     public boolean adicionaImagemUsuario(int id_part, int id_time, int escolhe) throws FileNotFoundException{
        DataSource data2 = new DataSource();
        conexao = data2.getConnection();
        if(escolhe == 1){
        String SQL = "UPDATE partida SET fk_time1 = ? WHERE id_part=?";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1,id_time);
            ps.setInt(2,id_part);
            retUpdate = ps.executeUpdate();
            data.closeDataSource();
            
            if(retUpdate == 1){
                JOptionPane.showMessageDialog(null,"Imagem cadastrada");
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Imagem não cadastrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else if(escolhe == 2){
        String SQL = "UPDATE partida SET fk_time2 = ? WHERE id_part=?";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1,id_time);
            ps.setInt(2,id_part);
            retUpdate = ps.executeUpdate();
            data.closeDataSource();
            
            if(retUpdate == 1){
                JOptionPane.showMessageDialog(null,"Imagem cadastrada");
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Imagem não cadastrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
       return false;
    }
     
}
