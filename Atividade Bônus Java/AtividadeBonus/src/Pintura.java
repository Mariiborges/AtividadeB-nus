public class Pintura extends ObraDeArte {
    public Pintura(String titulo, String artista, int anoDeCriacao, String localizacao) {
        super(titulo, artista, anoDeCriacao, localizacao);
    }

    @Override
    public String getTipo() {
        return "Pintura";
    }
}
