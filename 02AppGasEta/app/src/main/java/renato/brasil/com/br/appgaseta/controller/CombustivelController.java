package renato.brasil.com.br.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import renato.brasil.com.br.appgaseta.database.GasEtaDB;
import renato.brasil.com.br.appgaseta.model.Combustivel;
import renato.brasil.com.br.appgaseta.view.GasEtaActivity;

public class CombustivelController extends GasEtaDB {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

     // psfs
    public static final String NOME_PREFERENCES ="pref_gaseta";

    public  CombustivelController(GasEtaActivity activity){
        super(activity);
        preferences =
                activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = preferences.edit();
    }

    public void salvar(Combustivel combustivel){

        ContentValues dados = new ContentValues();

        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("melhorOpcao", combustivel.getMelhorOpcao());
        dadosPreferences.apply();

       // salvando no banco de dados
        dados.put("nomeDoCombustivel",combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel",combustivel.getPrecoDoCombustivel());
        dados.put("melhorOpcao",combustivel.getMelhorOpcao());

        salvarObjeto("Combustivel",dados);


    }

    public  List<Combustivel> getListaDeDados(){
        return  listarDados();
    }

    public  void limpar(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }
}
