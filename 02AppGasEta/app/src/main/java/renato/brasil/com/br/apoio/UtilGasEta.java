package renato.brasil.com.br.apoio;

public class UtilGasEta {
    public static void metodoNaoEstatico(){} // tenho que declara new na classe view

    public static  void  metodoEstatico(){}

    public  static String mensagem(){

        return  "Qualquer mensagem...";
    }

    public  static  String calcularMelhorOpcao(double gasolina, double etanol){

        // preço da gasolina: 5,12
        // preço do etanol: 3,99
        // preço ideal = gasolina * 0.70 = R$ 3,54

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol <= precoIdeal){
            mensagemDeRetorno = "Abasteça com Etanol";
        }else {
            mensagemDeRetorno = "Abasteça com Gasolina";
        }
        // se o etanol for igual ou menor que o preço ideal,
        // melhor abastecer com etanol, caso contrario,  gasolina é
        // a melhor opção.

        return  mensagemDeRetorno; // Abastecer com gasolina ou Etanol

    }
}
