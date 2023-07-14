package renato.brasil.com.br.appgaseta.model;

public class Combustivel {
    private  String nomeDoCombustivel;
    private  double precoDoCombustivel;
    private String melhorOpcao;


    public String getNomeDoCombustivel() {
        return nomeDoCombustivel;
    }

    public double getPrecoDoCombustivel() {
        return precoDoCombustivel;
    }

    public void setPrecoDoCombustivel(double precoDoCombustivel) {

        this.precoDoCombustivel = precoDoCombustivel;
    }

    public String getMelhorOpcao() {
        return melhorOpcao;
    }

    public void setMelhorOpcao(String melhorOpcao) {
        this.melhorOpcao = melhorOpcao;
    }

    public void setNomeDoCombustivel(String nomeDoCombustivel) {
        this.nomeDoCombustivel = nomeDoCombustivel;


    }
}
