package classes;

import java.sql.Date;

public class Competicao {
    private String nomeCompeticao;
    private String descricao;
    private String premiacao;
    private String   data_inicio;
    private String   data_terminio;
    private String situacao;
    private String qtd_times;

    public Competicao(){

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

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String date) {
        this.data_inicio = date;
    }

    public String getData_terminio() {
        return data_terminio;
    }

    public void setData_terminio(String data_terminio) {
        this.data_terminio = data_terminio;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getQtd_times() {
        return qtd_times;
    }

    public void setQtd_times(String qtd_times) {
        this.qtd_times = qtd_times;
    }

}
