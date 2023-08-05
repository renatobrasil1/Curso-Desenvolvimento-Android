package renato.brasil.com.br.applistamotociclista.controller;

import java.util.ArrayList;
import java.util.List;

import renato.brasil.com.br.applistamotociclista.model.Profissional;

public class ProfissionalController {

    private List listProfissionais;

    public List getListaDeProfissionais() {

        listProfissionais = new ArrayList<Profissional>();

        listProfissionais.add(new Profissional("Brasil"));
        listProfissionais.add(new Profissional("Lima"));
        listProfissionais.add(new Profissional("Valdir"));
        listProfissionais.add(new Profissional("Daril"));
        listProfissionais.add(new Profissional("Tico"));
        listProfissionais.add(new Profissional("Marcio"));
        listProfissionais.add(new Profissional("Enéias"));
        listProfissionais.add(new Profissional("Fernando"));
        listProfissionais.add(new Profissional("Devair"));

        return listProfissionais;
    }
    public ArrayList<String> dadosParaSpinner(){

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaDeProfissionais().size() ; i++) {
            Profissional objeto = (Profissional) getListaDeProfissionais().get(i);
            dados.add(objeto.getNomeDoprofissionalDesejado());
        }

        return  dados;
    }
}
