import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MuseuApp {
    private static final String CAMINHO_ARQUIVO = "acervo.dat";
    private static Acervo acervo = new Acervo();

    public static void main(String[] args) {
        try {
            acervo.carregarDados(CAMINHO_ARQUIVO);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum dado encontrado, começando com um acervo vazio.");
        }

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Obra de Arte");
            System.out.println("2. Listar Obras de Arte");
            System.out.println("3. Buscar Obra por Título");
            System.out.println("4. Atualizar Obra");
            System.out.println("5. Excluir Obra");
            System.out.println("6. Salvar Dados");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarObra(scanner);
                    break;
                case 2:
                    listarObras();
                    break;
                case 3:
                    buscarObraPorTitulo(scanner);
                    break;
                case 4:
                    atualizarObra(scanner);
                    break;
                case 5:
                    excluirObra(scanner);
                    break;
                case 6:
                    try {
                        acervo.salvarDados(CAMINHO_ARQUIVO);
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    break;
                case 0:
                     System.out.println("Saindo...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }

    private static void cadastrarObra(Scanner scanner) {
        System.out.println("Digite o título da obra:");
        String titulo = scanner.nextLine();

        System.out.println("Digite o artista da obra:");
        String artista = scanner.nextLine();

        System.out.println("Digite o ano de criação da obra:");
        int ano = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Digite o tipo da obra (Pintura/Escultura):");
        String tipo = scanner.nextLine();

        System.out.println("Digite a localização da obra:");
        String localizacao = scanner.nextLine();

        ObraDeArte obra;
        if (tipo.equalsIgnoreCase("Pintura")) {
            obra = new Pintura(titulo, artista, ano, localizacao);
        } else if (tipo.equalsIgnoreCase("Escultura")) {
            obra = new Escultura(titulo, artista, ano, localizacao);
        } else {
            System.out.println("Tipo de obra desconhecido.");
            return;
        }

        acervo.adicionarObra(obra);
        System.out.println("Obra cadastrada com sucesso.");
    }

    private static void listarObras() {
        List<ObraDeArte> obras = acervo.listarObras();
        if (obras.isEmpty()) {
            System.out.println("Nenhuma obra cadastrada.");
        } else {
            for (ObraDeArte obra : obras) {
                System.out.println(obra);
            }
        }
    }

    private static void buscarObraPorTitulo(Scanner scanner) {
        System.out.println("Digite o título da obra:");
        String titulo = scanner.nextLine();

        ObraDeArte obra = acervo.buscarObraPorTitulo(titulo);
        if (obra == null) {
            System.out.println("Obra não encontrada.");
        } else {
            System.out.println(obra);
        }
    }

    private static void atualizarObra(Scanner scanner) {
        System.out.println("Digite o título da obra a ser atualizada:");
        String titulo = scanner.nextLine();

        ObraDeArte obraExistente = acervo.buscarObraPorTitulo(titulo);
        if (obraExistente == null) {
            System.out.println("Obra não encontrada.");
            return;
        }

        System.out.println("Digite os novos dados da obra.");

        System.out.println("Digite o novo título da obra:");
        String novoTitulo = scanner.nextLine();

        System.out.println("Digite o novo artista da obra:");
        String novoArtista = scanner.nextLine();

        System.out.println("Digite o novo ano de criação da obra:");
        int novoAno = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo tipo da obra (Pintura/Escultura):");
        String novoTipo = scanner.nextLine();

        System.out.println("Digite a nova localização da obra:");
        String novaLocalizacao = scanner.nextLine();

        ObraDeArte novaObra;
        if (novoTipo.equalsIgnoreCase("Pintura")) {
            novaObra = new Pintura(novoTitulo, novoArtista, novoAno, novaLocalizacao);
        } else if (novoTipo.equalsIgnoreCase("Escultura")) {
            novaObra = new Escultura(novoTitulo, novoArtista, novoAno, novaLocalizacao);
        } else {
            System.out.println("Tipo de obra desconhecido.");
            return;
        }

        if (acervo.atualizarObra(titulo, novaObra)) {
            System.out.println("Obra atualizada com sucesso.");
        } else {
            System.out.println("Erro ao atualizar a obra.");
        }
    }

    private static void excluirObra(Scanner scanner) {
        System.out.println("Digite o título da obra a ser excluída:");
        String titulo = scanner.nextLine();

        if (acervo.excluirObra(titulo)) {
            System.out.println("Obra excluída com sucesso.");
        } else {
            System.out.println("Erro ao excluir a obra.");
        }
    }
}
