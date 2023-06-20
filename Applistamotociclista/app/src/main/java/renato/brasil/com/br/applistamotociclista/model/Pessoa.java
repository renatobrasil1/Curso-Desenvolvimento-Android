package renato.brasil.com.br.applistamotociclista.model;
public class Pessoa {
    // Eu preciso de um construtor para criar o objeto
    // construtor
    // Atributos - Objetos - Molde - Modelo - Template

    // Metodos de acesso - Getts and Setts
     // para a classe pessoa a gente tem os atributos candidatos

    private String primeiroNome;  // para duplicar a linha podemos --> Ctrl + d
    private String sobreNome;
    private String profissionalDesejado; // aqui eu substitui  o (nome do curso desejado) cada profissional é um objeto
    private String telefoneContato;


    public Pessoa(){}

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getProfissionalDesejado() {
        return profissionalDesejado;
    }

    public void setProfissionalDesejado(String profissionalDesejado) {
        this.profissionalDesejado = profissionalDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", profissionalDesejado='" + profissionalDesejado + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                '}';
    }
}
