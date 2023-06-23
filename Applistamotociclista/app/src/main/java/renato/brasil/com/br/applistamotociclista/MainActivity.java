package renato.brasil.com.br.applistamotociclista;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import renato.brasil.com.br.applistamotociclista.controller.PessoaController;
import renato.brasil.com.br.applistamotociclista.model.Pessoa;

public class MainActivity extends Activity {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip; // aqui eu estou deixando com publico

    public static final String NOME_PREFERENCES = "pref_listamotociclista";

    PessoaController controller; // estou criando uma estância , ate o momento ela e null

    Pessoa pessoa; //declarando  um objeto pessoa
    Pessoa outraPessoa;
    // EditText é uma classe que faz parte  da classe android widget
    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editQualProfissional;
    EditText editTelefoneDeContato;

    Button btnLimpar; //Ctrl + B a gente busca a classe
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0); // o zero é para leitura e escrita
        listaVip = preferences.edit(); // criando o editor


        controller = new PessoaController(); // criando o objeto controller
        controller.toString();

        pessoa = new Pessoa(); // criando um objeto pessoa

        pessoa.setPrimeiroNome(preferences.getString("primmeiroNome", "não existe ..."));
        pessoa.setSobreNome(preferences.getString("sobreNome", "NA"));
        pessoa.setProfissionalDesejado(preferences.getString("qualProfissional", "NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "NA"));


        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editQualProfissional = findViewById(R.id.editQualProfissional);
        editTelefoneDeContato = findViewById(R.id.editTelefoneDeContato);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editQualProfissional.setText(pessoa.getProfissionalDesejado());
        editTelefoneDeContato.setText(pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // pegando o clik do botão
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editQualProfissional.setText("");
                editTelefoneDeContato.setText("");

                listaVip.clear(); // estou limpando o campo
                listaVip.apply(); // salvando os dados
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNome.getText().toString());
                pessoa.setProfissionalDesejado(editQualProfissional.getText().toString());
                pessoa.setTelefoneContato(editTelefoneDeContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();
                finish();

                listaVip.putString("primmeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome", pessoa.getSobreNome());
                listaVip.putString("qualProfissional", pessoa.getProfissionalDesejado());
                listaVip.putString("telefoneContato", pessoa.getTelefoneContato());

                listaVip.apply(); // estou salvando o contato

                controller.salvar(pessoa); // passando o objeto pessoa para o controller
            }
        });
        Log.i("POOAndroid", "Objeto pessoa :" + pessoa.toString());

    }
}