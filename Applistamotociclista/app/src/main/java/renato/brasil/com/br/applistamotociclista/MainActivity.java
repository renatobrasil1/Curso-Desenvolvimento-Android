package renato.brasil.com.br.applistamotociclista;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import renato.brasil.com.br.applistamotociclista.model.Pessoa;

public class MainActivity extends Activity {


    Pessoa pessoa; //declarando  um objeto pessoa
    Pessoa outraPessoa;

    String dadosPessoa; // pascalCase - camecase
    String dadosOutraPessoa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa(); // criando um objeto pessoa


        // Atribuindo conteúdo, dados  valores para o objeto
        // Conforme o nosso modelo de template

        pessoa.setPrimeiroNome("renato");
        pessoa.setSobreNome("brasil");
        pessoa.setProfissionalDesejado("daril");
        pessoa.setTelefoneContato("18-981292591");

        outraPessoa = new Pessoa();

        outraPessoa.setPrimeiroNome("luzia");
        outraPessoa.setSobreNome("silva");
        outraPessoa.setProfissionalDesejado("lima");
        outraPessoa.setTelefoneContato("18-981963216");

       /* dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += "Profissional desejado: ";
        dadosPessoa += pessoa.getProfissionalDesejado();
        dadosPessoa += "Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();


        dadosOutraPessoa = "Primeiro nome: ";
        dadosOutraPessoa += outraPessoa.getPrimeiroNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSobreNome();
        dadosOutraPessoa += "Profissional desejado: ";
        dadosOutraPessoa += outraPessoa.getProfissionalDesejado();
        dadosOutraPessoa += "Telefone de Contato: ";
        dadosOutraPessoa += outraPessoa.getTelefoneContato();*/

        Log.i("POOAndroid","Objeto pessoa :" +pessoa.toString());
        Log.i("POOAndroid","Objeto outraPessoa :"+outraPessoa.toString());


    }
}