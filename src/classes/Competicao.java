package classes;

import java.sql.Date;

public class Competicao {
    private int    id_competicao;
    private String nomeCompeticao;
    private String descricao;
    private String premiacao;
    private Date   data_inicio;
    private Date   data_terminio;
    private String situacao;
    private int    qtd_times;

    public Competicao(){

    }

    public int getId_competicao() {
        return id_competicao;
    }

    public void setId_competicao(int id_competicao) {
        this.id_competicao = id_competicao;
    }

    public String getNomeCompeticao() {
        return nomeCompeticao;
    }

    public void setNomeCompeticao(String nomeCompeticao) {
        this.nomeCompeticao = nomeCompeticao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(String premiacao) {
        this.premiacao = premiacao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_terminio() {
        return data_terminio;
    }

    public void setData_terminio(Date data_terminio) {
        this.data_terminio = data_terminio;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getQtd_times() {
        return qtd_times;
    }

    public void setQtd_times(int qtd_times) {
        this.qtd_times = qtd_times;
    }

    /**Criar get e sets */
}
