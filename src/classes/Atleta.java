/**
 * Classe destinada a criação e manipulação do objeto atleta
 */
package classes;

/**
 * @author Leticia Torres
 *
 */
public class Atleta {
    private int id_atleta;
    private String nome_atleta;
    private String sobrenome_atleta;

    public Atleta(){

    }

    public void setId(int id_atleta){
        this.id_atleta = id_atleta;
    }

    public int getId(){
        return id_atleta;
    }
    
    public void setNomeAtleta(String nome_atleta){
        this.nome_atleta = nome_atleta;
    }

    public String getNomeAtleta(){
        return nome_atleta;
    }

    public void setSobrenomeAtleta(String sobrenome_atleta){
        this.sobrenome_atleta = sobrenome_atleta;
    }

    public String getSobrenomeAtleta(){
        return sobrenome_atleta;
    }
}
