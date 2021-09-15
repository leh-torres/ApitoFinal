/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import classes.ArvoreB;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Competicao;
import classes.No;
import classes.Partida;
import classes.Time;
import java.lang.Character;
import classes.Usuario;
import dao.BarraDeMenuDAO;
import dao.CompeticaoDAO;
import dao.PartidaDAO;
import dao.TimeDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import selecaocampeonato.SelecaoCampeonato;
import tela.estatisticas.TelaEstatisticas;
import telaEditCampeonato.TelaEditCampeonato;
import telaEditPartidas.TelaEditPartidas;
import telaEditTimes.TelaEditTimes;
import telaUsuario.TelaUsuario;

/**
 *
 * @author Zairo Bastos
 */
public class HomeController implements Initializable {
    

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private ImageView image9;

    @FXML
    private ImageView image10;

    @FXML
    private ImageView image11;

    @FXML
    private ImageView image12;

    @FXML
    private ImageView image13;
    
    @FXML
    private ImageView image14;

    @FXML
    private ImageView imagem_user;

    @FXML
    private Label labelPremio;

    @FXML
    private Label descricaoLabel;

    
    @FXML
    private Label nome_user;

    @FXML
    private Label labelDataInicio;

    @FXML
    private Label labelDataTerm;

    @FXML
    private Label labelSituacao;

    @FXML
    private Button btnEditarCamp;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button gol1;
    
    @FXML
    private Button gol2;
    
    @FXML
    private Button gol3;
    
    @FXML
    private Button gol4;
    
    @FXML
    private Button gol5;
    
    @FXML
    private Button gol6;
    
    @FXML
    private Button gol7;
    
    private Competicao competicao = new Competicao();
    private CompeticaoDAO competicaoDAO = new CompeticaoDAO();
    private BarraDeMenuDAO barra = new BarraDeMenuDAO();
    private int[] id_selecionado = new int[16];
    private int[] id_ganhador = new int[8];
    PartidaDAO part = new PartidaDAO();
    ArvoreB arvore = new ArvoreB();
    private No no;
    @FXML
    private ImageView image15;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat dateFormat1 = new SimpleDateFormat("HH:mm");
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        PartidaDAO partida = new PartidaDAO();
        Time time = new Time();
        id_ganhador = time.getId_ganhador();
        id_selecionado = partida.getId_selecionado();
        nome_user.setText(barra.Nome());
        imagem_user.setImage(barra1.Imagem());
        competicao = competicaoDAO.gCompeticao(competicao.getIdSelecionaCampeonato());

        labelPremio.setText(competicao.getPremiacao());
        descricaoLabel.setText(competicao.getDescricao());   
        labelDataInicio.setText(competicao.getData_inicio());
        labelDataTerm.setText(competicao.getData_terminio());
        labelSituacao.setText(competicao.getSituacao());
        
        for(int i = 0; i<7 ; i++){
            arvore.inserir(no, part.getMinIdPart(competicao.getIdSelecionaCampeonato(), i));
        }
        
        arvore.emordem(no);
        
        /*gol1.setDisable(true);
        gol1.setVisible(false);
        gol2.setDisable(true);
        gol2.setVisible(false);
        gol3.setDisable(true);
        gol3.setVisible(false);
        gol4.setDisable(true);
        gol4.setVisible(false);
        gol5.setDisable(true);
        gol5.setVisible(false);
        gol6.setDisable(true);
        gol6.setVisible(false);
        gol7.setDisable(true);
        gol7.setVisible(false);*/
        
        TimeDAO time1 = new TimeDAO();
        
        image1.setImage(part.Imagem(1));
        image2.setImage(part.Imagem(2));
        image3.setImage(part.Imagem(3));
        image4.setImage(part.Imagem(4));
        image5.setImage(part.Imagem(10));
        image6.setImage(part.Imagem(9));
        image7.setImage(part.Imagem(12));
        image8.setImage(part.Imagem(14));
        image9.setImage(part.Imagem(11));
        image10.setImage(part.Imagem(13));
        image11.setImage(part.Imagem(5));
        image12.setImage(part.Imagem(6));
        image13.setImage(part.Imagem(7));
        image14.setImage(part.Imagem(8));  
        
        String dataFormatada = dateFormat.format(dataAtual);
        String horaFormatada = dateFormat1.format(dataAtual);
        
        
        /*if(dataFormatada.compareTo(part.getData(1)) < 0){
            if(horaFormatada.compareTo(part.getHora(1)) >0){
                gol1.setVisible(true);
                gol1.setDisable(false);
            }
        }
        if(dataFormatada.compareTo(part.getData(2)) < 0){
            if(horaFormatada.compareTo(part.getHora(2)) > 0){
                gol2.setVisible(true);
                gol2.setDisable(false);
            }
        }
        if(dataFormatada.compareTo(part.getData(3)) < 0){
            if(horaFormatada.compareTo(part.getHora(3)) > 0){
                gol3.setVisible(true);
                gol3.setDisable(false);
            }
        }
        if(dataFormatada.compareTo(part.getData(4)) < 0){
            if(horaFormatada.compareTo(part.getHora(4)) > 0){
                gol4.setVisible(true);
                gol4.setDisable(false);
            }
        }*/
        
    }    
    
    @FXML
    private void acaoGol1() throws Exception{
        Partida part1 = new Partida();
        part1.setId_part(part.recuperaId(id_selecionado[0]));
        part1.setId_part1(4+part.recuperaId(id_selecionado[0]));
        part1.setId_time1(id_selecionado[0]);
        part1.setId_time2(id_selecionado[1]);
        telaGols();
        fecha();
    }
    
    @FXML
    private void acaoGol2() throws Exception{
        Partida part1 = new Partida();
        part1.setId_part(part.recuperaId(id_selecionado[2]));
        part1.setId_part1(3+part.recuperaId(id_selecionado[2]));
        part1.setId_time1(id_selecionado[2]);
        part1.setId_time2(id_selecionado[3]);
        telaGols();
        fecha();
    }
    
    @FXML
    private void acaoGol3() throws Exception{
        Partida part1 = new Partida();
        part1.setId_part(part.recuperaId(id_selecionado[4]));
        part1.setId_part1(4+part.recuperaId(id_selecionado[4]));
        part1.setId_time1(id_selecionado[4]);
        part1.setId_time2(id_selecionado[5]);
        telaGols();
        fecha();
    }
    
    @FXML
    private void acaoGol4() throws Exception{
        Partida part1 = new Partida();
        part1.setId_part(part.recuperaId(id_selecionado[6]));
        part1.setId_part1(3+part.recuperaId(id_selecionado[6]));
        part1.setId_time1(id_selecionado[6]);
        part1.setId_time2(id_selecionado[7]);
        telaGols();
        fecha();
    }
    
    @FXML
    private void acaoGol5() throws Exception{
        Partida part1 = new Partida();
        part1.setId_part(part.recuperaId(id_selecionado[8]));
        part1.setId_part1(4+part.recuperaId(id_selecionado[8]));
        part1.setId_time1(id_selecionado[8]);
        part1.setId_time2(id_selecionado[9]);
        telaGols();
        fecha();
    }
    
    @FXML
    private void acaoGol6() throws Exception{
        Partida part1 = new Partida();
        part1.setId_part(part.recuperaId(id_selecionado[10]));
        part1.setId_part1(3+part.recuperaId(id_selecionado[10]));
        part1.setId_time1(id_selecionado[10]);
        part1.setId_time2(id_selecionado[12]);
        telaGols();
        fecha();
    }
    
    @FXML
    private void acaoGol7() throws Exception{
        Partida part1 = new Partida();
        part1.setId_part(part.recuperaId(id_selecionado[13]));
        part1.setId_part1(4+part.recuperaId(id_selecionado[13]));
        part1.setId_time1(id_selecionado[13]);
        part1.setId_time2(id_selecionado[14]);
        telaGols();
        fecha();
    }
    
    private void telaGols() throws Exception{
        TelaEstatisticas tela = new TelaEstatisticas();
        
        tela.start(new Stage());
        fecha();
    }

    @FXML
    private void voltar(ActionEvent event){
        SelecaoCampeonato selecao = new SelecaoCampeonato();
        fecha();

        try {
            selecao.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void deletaComp(ActionEvent event) {
        boolean retorno = competicaoDAO.excluirCompeticao(competicao.getId_competicao());
        if(retorno == true){
            JOptionPane.showMessageDialog(null, "Campeonato excluido com sucesso!");
            SelecaoCampeonato selecao = new SelecaoCampeonato();
            fecha();
            try {
                selecao.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void telaEditCamp(ActionEvent event){
        TelaEditCampeonato edit = new TelaEditCampeonato();
        fecha();
        try {
            edit.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void fecha(){
        Home.getStage().close();
    }

    @FXML
    private void voltar(MouseEvent event) {
        SelecaoCampeonato camp = new SelecaoCampeonato();
        fecha();

        try {
            camp.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void editarPartida(ActionEvent event){
        TelaEditPartidas editPart = new TelaEditPartidas();
        fecha();

        try {
            editPart.start(new Stage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void editarTime(ActionEvent event){
        TelaEditTimes editTimes = new TelaEditTimes();
        fecha();

        try {
            editTimes.start(new Stage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
