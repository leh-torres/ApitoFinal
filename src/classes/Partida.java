package classes;

import java.sql.Time;
import java.sql.Date;



public class Partida {
    private int id_part;
    private Date data_part;
    private Time hora_part;
    private String loacl_part;
    private String placar_part;
    private int fk_comp;
    
    public Partida (){
        
    }

    public int getId_part() {
        return id_part;
    }

    public void setId_part(int id_part) {
        this.id_part = id_part;
    }

    public Date getData_part() {
        return data_part;
    }

    public void setData_part(Date data_part) {
        this.data_part = data_part;
    }

    public Time getHora_part() {
        return hora_part;
    }

    public void setHora_part(Time hora_part) {
        this.hora_part = hora_part;
    }

    public String getLoacl_part() {
        return loacl_part;
    }

    public void setLoacl_part(String loacl_part) {
        this.loacl_part = loacl_part;
    }

    public String getPlacar_part() {
        return placar_part;
    }

    public void setPlacar_part(String placar_part) {
        this.placar_part = placar_part;
    }

    public int getFk_comp() {
        return fk_comp;
    }

    public void setFk_comp(int fk_comp) {
        this.fk_comp = fk_comp;
    }
    
    
}
