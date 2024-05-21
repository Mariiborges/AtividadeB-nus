import java.io.Serializable;

public abstract class ObraDeArte implements Serializable {
    private String titulo;
    private String artista;
    private int anoDeCriacao;
    private String localizacao;

    public ObraDeArte(String titulo, String artista, int anoDeCriacao, String localizacao) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoDeCriacao = anoDeCriacao;
        this.localizacao = localizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "ObraDeArte [titulo=" + titulo + ", artista=" + artista + ", anoDeCriacao=" + anoDeCriacao + ", tipo=" + getTipo() + ", localizacao=" + localizacao + "]";
    }
}
