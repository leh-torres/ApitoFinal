package telacadcampeonato;

public class Situacao {
    private int id;
    private String nome_situacao;

    public Situacao(int id, String nome){
        this.id = id;
        nome_situacao = nome;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setNome(String nome){
        nome_situacao = nome;
    }

    public String getNome(){
        return nome_situacao;
    }

    public String toString(){
        return getNome();
    }

}
