public class Produto {
    private String nome;
    private int quant;

    public Produto(String nome) {
        this.nome = nome;
        this.quant = 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}
