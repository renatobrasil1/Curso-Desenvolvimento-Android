package renato.brasil.com.br.applistamotociclista;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import renato.brasil.com.br.applistamotociclista.model.Pessoa;

public class MainActivity extends Activity {

    Pessoa pessoa; //declarando  um objeto pessoa
    Pessoa outraPessoa;
    // EditText é uma classe que faz parte  da classe android widget
    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editQualProfissional;
    EditText editTelefoneDeContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa(); // criando um objeto pessoa

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("luzia");
        outraPessoa.setSobreNome("silva");
        outraPessoa.setProfissionalDesejado("lima");
        outraPessoa.setTelefoneContato("18-981963216");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editQualProfissional = findViewById(R.id.editQualProfissional);
        editTelefoneDeContato = findViewById(R.id.editTelefoneDeContato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editQualProfissional.setText(pessoa.getProfissionalDesejado());
        editTelefoneDeContato.setText(pessoa.getTelefoneContato());

        // pegando o clik do botão
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editQualProfissional.setText("");
                editTelefoneDeContato.setText("");
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
            }
        });
        Log.i("POOAndroid", "Objeto pessoa :" + pessoa.toString());
        Log.i("POOAndroid", "Objeto outraPessoa :" + outraPessoa.toString());
    }
}