public class Escultura extends ObraDeArte {
    public Escultura(String titulo, String artista, int anoDeCriacao, String localizacao) {
        super(titulo, artista, anoDeCriacao, localizacao);
    }

    @Override
    public String getTipo() {
        return "Escultura";
    }
}
