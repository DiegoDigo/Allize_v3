package br.com.allize.allize.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.allize.allize.R;
import br.com.allize.allize.models.Comanda;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context context;
    List<Comanda> data;


    public RecycleViewAdapter(Context context, List<Comanda> comandas){
        this.context= context;
        this.data = comandas;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comanda, parent,
                false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.item_comanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "teste", Toast.LENGTH_LONG).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.tv_data.setText(data.get(position).getData());
            holder.tv_nComanda.setText(data.get(position).getNumComanda());
            holder.tv_servico.setText(data.get(position).getServico());
            holder.tv_hora.setText(data.get(position).getHora());
            holder.tv_nome.setText(data.get(position).getNome());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_nome;
        private TextView tv_hora;
        private TextView tv_servico;
        private TextView tv_nComanda;
        private TextView tv_data;
        private CardView item_comanda;
        public MyViewHolder(View itemView) {
            super(itemView);
            item_comanda = itemView.findViewById(R.id.list_item);
            tv_nome = itemView.findViewById(R.id.nome);
            tv_hora = itemView.findViewById(R.id.horario);
            tv_servico = itemView.findViewById(R.id.servico);
            tv_nComanda = itemView.findViewById(R.id.num_comanda);
            tv_data = itemView.findViewById(R.id.data);


        }
    }
}
