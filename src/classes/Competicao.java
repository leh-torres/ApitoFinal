package classes;

import java.util.ArrayList;

public class Competicao {
    private int id_competicao;
    private String nomeCompeticao;
    private static String descricao;
    private static String premiacao;
    private String data_inicio;
    private String data_terminio;
    private String situacao;
    private int qtd_times;
    private static int fk_user;
    private static int idSelecionaCampeonato;

    public Competicao(){

    }

    public int getId_competicao() {
        return id_competicao;
    }

    public void setId_competicao(int id_competicao) {
        this.id_competicao = id_competicao;
    }


    /**
     * @return String return the nomeCompeticao
     */
    public String getNomeCompeticao() {
        return nomeCompeticao;
    }

    /**
     * @param nomeCompeticao the nomeCompeticao to set
     */
    public void setNomeCompeticao(String nomeCompeticao) {
        this.nomeCompeticao = nomeCompeticao;
    }

    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return String return the premiacao
     */
    public String getPremiacao() {
        return premiacao;
    }

    /**
     * @param premiacao the premiacao to set
     */
    public void setPremiacao(String premiacao) {
        this.premiacao = premiacao;
    }

    /**
     * @return String return the data_inicio
     */
    public String getData_inicio() {
        return data_inicio;
    }

    /**
     * @param data_inicio the data_inicio to set
     */
    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    /**
     * @return String return the data_terminio
     */
    public String getData_terminio() {
        return data_terminio;
    }

    /**
     * @param data_terminio the data_terminio to set
     */
    public void setData_terminio(String data_terminio) {
        this.data_terminio = data_terminio;
    }

    /**
     * @return String return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return String return the qtd_times
     */
    public int getQtd_times() {
        return qtd_times;
    }

    /**
     * @param qtd_times the qtd_times to set
     */
    public void setQtd_times(int qtd_times) {
        this.qtd_times = qtd_times;
    }

    /**
     * @return int return the fk_user
     */
    public int getFk_user() {
        return fk_user;
    }

    /**
     * @param fk_user the fk_user to set
     */
    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public int getIdSelecionaCampeonato() {
        return idSelecionaCampeonato;
    }

    public void setIdSelecionaCampeonato(int idSelecionaCampeonato) {
        Competicao.idSelecionaCampeonato = idSelecionaCampeonato;
    }
}
