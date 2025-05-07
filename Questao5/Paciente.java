public class Paciente extends Pessoa {
    private String sintoma;

    public Paciente(String nome, String sintoma) {
        super(nome);
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return "Nome = " + getNome() + ", Sintoma = " + getSintoma();
    }
    
    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }
}
