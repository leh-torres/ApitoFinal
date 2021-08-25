package classes;

import java.sql.Blob;
import java.util.ArrayList;

public class Time {
    private static int id_time;
    private String nome_time;
    private Blob imagem_time;
    private String abreviacao_time;
    private static int fk_usuario;
    private static int fk_comp;
    private static ArrayList<Time> arrayTimes = new ArrayList<>();
    
    public Time(){
        
    }

    /**
     * @return int return the id_time
     */
    public int getId_time() {
        return id_time;
    }

    /**
     * @param id_time the id_time to set
     */
    public void setId_time(int id_time) {
        Time.id_time = id_time;
    }

    /**
     * @return String return the nome_time
     */
    public String getNome_time() {
        return nome_time;
    }

    /**
     * @param nome_time the nome_time to set
     */
    public void setNome_time(String nome_time) {
        this.nome_time = nome_time;
    }

    /**
     * @return String return the abreviacao_time
     */
    public String getAbreviacao_time() {
        return abreviacao_time;
    }

    /**
     * @param abreviacao_time the abreviacao_time to set
     */
    public void setAbreviacao_time(String abreviacao_time) {
        this.abreviacao_time = abreviacao_time;
    }

    /**
     * @return int return the fk_usuario
     */
    public int getFk_usuario() {
        return fk_usuario;
    }

    /**
     * @param fk_usuario the fk_usuario to set
     */
    public void setFk_usuario(int fk_usuario) {
        Time.fk_usuario = fk_usuario;
    }

    /**
     * @return int return the fk_comp
     */
    public int getFk_comp() {
        return fk_comp;
    }

    /**
     * @param fk_comp the fk_comp to set
     */
    public void setFk_comp(int fk_comp) {
        Time.fk_comp = fk_comp;
    }


    /**
     * @return Blob return the imagem_time
     */
    public Blob getImagem_time() {
        return imagem_time;
    }

    /**
     * @param imagem_time the imagem_time to set
     */
    public void setImagem_time(Blob imagem_time) {
        this.imagem_time = imagem_time;
    }


    /**
     * @return ArrayList<Time> return the arrayTimes
     */
    public ArrayList<Time> getArrayTimes() {
        return arrayTimes;
    }

    /**
     * @param arrayTimes the arrayTimes to set
     */
    public void setArrayTimes(ArrayList<Time> arrayTimes) {
        this.arrayTimes = arrayTimes;
    }

}
