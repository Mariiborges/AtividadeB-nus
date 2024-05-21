import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Acervo {
    private List<ObraDeArte> obras;

    public Acervo() {
        obras = new ArrayList<>();
    }

    public void adicionarObra(ObraDeArte obra) {
        obras.add(obra);
    }

    public List<ObraDeArte> listarObras() {
        return obras;
    }

    public ObraDeArte buscarObraPorTitulo(String titulo) {
        for (ObraDeArte obra : obras) {
            if (obra.getTitulo().equalsIgnoreCase(titulo)) {
                return obra;
            }
        }
        return null;
    }

    public boolean atualizarObra(String titulo, ObraDeArte novaObra) {
        for (int i = 0; i < obras.size(); i++) {
            if (obras.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                obras.set(i, novaObra);
                return true;
            }
        }
        return false;
    }

    public boolean excluirObra(String titulo) {
        return obras.removeIf(obra -> obra.getTitulo().equalsIgnoreCase(titulo));
    }

    public void salvarDados(String caminhoArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(obras);
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarDados(String caminhoArquivo) throws IOException, ClassNotFoundException {
        File arquivo = new File(caminhoArquivo);
        if (arquivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
                Object obj = ois.readObject();
                if (obj instanceof List) {
                    obras = (List<ObraDeArte>) obj;
                } else {
                    throw new IOException("Formato de arquivo inválido");
                }
            }
        }
    }

    public List<ObraDeArte> buscarObrasPorArtista(String artista) {
        List<ObraDeArte> resultado = new ArrayList<>();
        for (ObraDeArte obra : obras) {
            if (obra.getArtista().equalsIgnoreCase(artista)) {
                resultado.add(obra);
            }
        }
        return resultado;
    }

    public List<ObraDeArte> buscarObrasPorAno(int ano) {
        List<ObraDeArte> resultado = new ArrayList<>();
        for (ObraDeArte obra : obras) {
            if (obra.getAnoDeCriacao() == ano) {
                resultado.add(obra);
            }
        }
        return resultado;
    }

    public List<ObraDeArte> buscarObrasPorTipo(String tipo) {
        List<ObraDeArte> resultado = new ArrayList<>();
        for (ObraDeArte obra : obras) {
            if (obra.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(obra);
            }
        }
        return resultado;
    }
}
