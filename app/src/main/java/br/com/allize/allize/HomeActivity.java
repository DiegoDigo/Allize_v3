package br.com.allize.allize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import br.com.allize.allize.adapters.RecycleViewAdapter;
import br.com.allize.allize.models.Comanda;


public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.listaComanda);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this, listar());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycleViewAdapter);
    }


    private List<Comanda> listar(){
        List<Comanda> comandas = new ArrayList<>();
        Comanda c = new Comanda();
        c.setData("11");
        c.setHora("08:00");
        c.setNome("Diego Domingos Delmiro");
        c.setNumComanda("201801110001");
        c.setServico("Corte");
        c.setTelefone("11958044062");
        Comanda c2 = new Comanda();
        c2.setData("12");
        c2.setHora("08:30");
        c2.setNome("Jose Wilson Delmiro de Almeida");
        c2.setNumComanda("201801120002");
        c2.setServico("Corte");
        c2.setTelefone("11958044062");
        Comanda c3 = new Comanda();
        c3.setData("13");
        c3.setHora("08:40");
        c3.setNome("Maria Gilda Domingos das Neves");
        c3.setNumComanda("201801130002");
        c3.setServico("Corte");
        c3.setTelefone("11958044062");
        comandas.add(c);
        comandas.add(c2);
        comandas.add(c3);
        return comandas;
    }
}
