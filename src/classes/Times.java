package classes;

public class Times {
    private int id_time;
    private String nome_time;
    private byte[] imagem_time;
    private String abreviacao_time;
    private int fk_usuario;
    
    public Times(){
        
    }

    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    public String getNome_time() {
        return nome_time;
    }

    public void setNome_time(String nome_time) {
        this.nome_time = nome_time;
    }

    public byte[] getImagem_time() {
        return imagem_time;
    }

    public void setImagem_time(byte[] imagem_time) {
        this.imagem_time = imagem_time;
    }

    public String getAbreviacao_time() {
        return abreviacao_time;
    }

    public void setAbreviacao_time(String abreviacao_time) {
        this.abreviacao_time = abreviacao_time;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
    
}
