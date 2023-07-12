package renato.brasil.com.br.appgaseta.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import renato.brasil.com.br.appgaseta.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller","Controller iniciado");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller","Salvo :"+pessoa.toString());
    }
}
