// Nessa questão decidi inovar um pouco, ele atribui um formato de arquivo automaticamente de forma aleatória
import java.util.Random;
public class Documento {
    private final String nomeUsuario, nomeArquivo;
    Random random = new Random();
    int indexFormatoArquivo = random.nextInt(7); // Gera um número aleatório de 0 a 6
    String[] formatosArquivo = {".pdf", ".txt", ".docx", ".jpg", ".jpeg", ".png", ".tiff"};

    public Documento(String nomeUsuario, String nomeArquivo) {
        this.nomeUsuario = nomeUsuario;
        this.nomeArquivo = nomeArquivo + formatosArquivo[indexFormatoArquivo];
    }

    @Override
    public String toString() {
        return "Nome de usuário: " + nomeUsuario +
                ", Nome do arquivo: " + nomeArquivo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }
}
