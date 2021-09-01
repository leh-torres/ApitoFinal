package classes;

import java.sql.Time;
import java.sql.Date;



public class Partida {
    private static int id_part;
    private static int id_part1;
    private String data_part;
    private Time hora_part;
    private String loacl_part;
    private String placar_part;
    private int fk_comp;
    private int fk_time1;
    private int fk_time2;
    private static int id_time1;
    private static int id_time2;
    private static int id_comp;
    
    public Partida (){
        
    }

    public int getId_part1() {
        return id_part1;
    }

    public void setId_part1(int id_part1) {
        Partida.id_part1 = id_part1;
    }

    

    /**
     * @return int return the id_part
     */
    public int getId_part() {
        return id_part;
    }

    /**
     * @param id_part the id_part to set
     */
    public void setId_part(int id_part) {
        Partida.id_part = id_part;
    }

    /**
     * @return Date return the data_part
     */
    public String getData_part() {
        return data_part;
    }

    /**
     * @param data_part the data_part to set
     */
    public void setData_part(String data_part) {
        this.data_part = data_part;
    }

    /**
     * @return Time return the hora_part
     */
    public Time getHora_part() {
        return hora_part;
    }

    /**
     * @param hora_part the hora_part to set
     */
    public void setHora_part(Time hora_part) {
        this.hora_part = hora_part;
    }

    /**
     * @return String return the loacl_part
     */
    public String getLoacl_part() {
        return loacl_part;
    }

    /**
     * @param loacl_part the loacl_part to set
     */
    public void setLoacl_part(String loacl_part) {
        this.loacl_part = loacl_part;
    }

    /**
     * @return String return the placar_part
     */
    public String getPlacar_part() {
        return placar_part;
    }

    /**
     * @param placar_part the placar_part to set
     */
    public void setPlacar_part(String placar_part) {
        this.placar_part = placar_part;
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
        this.fk_comp = fk_comp;
    }

    /**
     * @return int return the fk_time1
     */
    public int getFk_time1() {
        return fk_time1;
    }

    /**
     * @param fk_time1 the fk_time1 to set
     */
    public void setFk_time1(int fk_time1) {
        this.fk_time1 = fk_time1;
    }

    /**
     * @return int return the fk_time2
     */
    public int getFk_time2() {
        return fk_time2;
    }

    /**
     * @param fk_time2 the fk_time2 to set
     */
    public void setFk_time2(int fk_time2) {
        this.fk_time2 = fk_time2;
    }

    public int getId_time1() {
        return id_time1;
    }

    public void setId_time1(int id_time1) {
        Partida.id_time1 = id_time1;
    }

    public int getId_time2() {
        return id_time2;
    }

    public void setId_time2(int id_time2) {
        Partida.id_time2 = id_time2;
    }

    public int getId_comp() {
        return id_comp;
    }

    public void setId_comp(int id_comp) {
        Partida.id_comp = id_comp;
    }
    
    

}
