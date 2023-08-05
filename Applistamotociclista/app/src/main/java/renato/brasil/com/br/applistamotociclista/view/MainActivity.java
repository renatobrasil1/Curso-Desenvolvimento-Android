package renato.brasil.com.br.applistamotociclista.view;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import renato.brasil.com.br.applistamotociclista.R;
import renato.brasil.com.br.applistamotociclista.controller.PessoaController;
import renato.brasil.com.br.applistamotociclista.controller.ProfissionalController;
import renato.brasil.com.br.applistamotociclista.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listamotociclista";

    PessoaController controller; // estou criando uma estância , ate o momento ela e null
    ProfissionalController profissionalController;

    Pessoa pessoa; //declarando  um objeto pessoa

    List<String> nomesDosProfissionais;



    Pessoa outraPessoa;
    // EditText é uma classe que faz parte  da classe android widget
    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editQualProfissional;
    EditText editTelefoneDeContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

      Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner); // ao iniciar chama atela activity_spinner

        preferences = getSharedPreferences(NOME_PREFERENCES,0); // o zero é para leitura e escrita
         SharedPreferences.Editor listaVip = preferences.edit(); // criando o editor


       controller = new PessoaController(MainActivity.this); // criando o objeto controller
        controller.toString();

        profissionalController = new ProfissionalController();
         nomesDosProfissionais = profissionalController.dadosParaSpinner();

        pessoa = new Pessoa(); // criando um objeto pessoa

      //  controller.buscar(pessoa);

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editQualProfissional = findViewById(R.id.editQualProfissional);
        editTelefoneDeContato = findViewById(R.id.editTelefoneDeContato);
        spinner = findViewById((R.id.spinner));

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editQualProfissional.setText(pessoa.getProfissionalDesejado());
        editTelefoneDeContato.setText(pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Adpter
        // Layout
        // Iniciar o adapter ao Sprinner - A lista gerar
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                profissionalController.dadosParaSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

              spinner.setAdapter((adapter));


        // pegando o clik do botão
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editQualProfissional.setText("");
                editTelefoneDeContato.setText("");
                controller.limpar();
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
            public void onClick(View view)
            {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNome.getText().toString());
                pessoa.setProfissionalDesejado(editQualProfissional.getText().toString());
                pessoa.setTelefoneContato(editTelefoneDeContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();
                finish();

                listaVip.putString("primmeiroNome",pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome",pessoa.getSobreNome());
                listaVip.putString("qualProfissional",pessoa.getProfissionalDesejado());
                listaVip.putString("telefoneContato",pessoa.getTelefoneContato());

                listaVip.apply(); // estou salvando o contato

                controller.salvar(pessoa); // passando o objeto pessoa para o controller
            }
        });
        Log.i("POOAndroid", "Objeto pessoa :" + pessoa.toString());

    }
}