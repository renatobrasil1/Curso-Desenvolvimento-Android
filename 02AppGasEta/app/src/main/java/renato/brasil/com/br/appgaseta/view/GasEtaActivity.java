package renato.brasil.com.br.appgaseta.view;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import renato.brasil.com.br.apoio.UtilGasEta;
import renato.brasil.com.br.appgaseta.R;
import renato.brasil.com.br.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {


    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editGasolina;
    EditText editEtanol;

    TextView textResultado;
    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String melhorOpcao;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        textResultado = findViewById(R.id.textResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editGasolina.setText("");
                editEtanol.setText("");
                btnSalvar.setEnabled(false);
            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                boolean isDadosOK = true; // estou assumindo que esta tudo ok

                if(TextUtils.isEmpty(editGasolina.getText() )){
                    editGasolina.setError("* Obrigatório");
                    editGasolina.requestFocus();
                    isDadosOK = false;
                }

                if(TextUtils.isEmpty(editEtanol.getText() )){
                    editEtanol.setError("* Obrigatório");
                    editEtanol.requestFocus();
                    isDadosOK = false;
                }
                if(isDadosOK){

                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());

                      melhorOpcao = UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol);

                      textResultado.setText(melhorOpcao);

                      btnSalvar.setEnabled(true);


                }else{
                    Toast.makeText(GasEtaActivity.this,
                            "Por favor, digite os dados obrigatórios...",
                            Toast.LENGTH_LONG).show();
                    btnSalvar.setEnabled(false);
                }

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  // desabilitar o botão salvar

                  combustivelGasolina = new Combustivel();
                  combustivelEtanol = new Combustivel();

                  combustivelGasolina.setNomeDoCombustivel("Gasolina");
                  combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                  combustivelEtanol.setNomeDoCombustivel("Etanol");
                  combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                  combustivelGasolina.setMelhorOpcao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));
                  combustivelEtanol.setMelhorOpcao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));
                  int parada = 0;


            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GasEtaActivity.this, "Volte Sempre...", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        //   utilGasEta.metodoEstatico();
        UtilGasEta.metodoNaoEstatico();

        Toast.makeText(GasEtaActivity.this,
                UtilGasEta.calcularMelhorOpcao(5.12, 3.39),
                Toast.LENGTH_LONG).show();
    }
}
