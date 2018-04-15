package br.com.allize.allize.adapters;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
    Dialog dialog;
    Intent intetCall;
    Intent intetEmail;
    Intent intetWhat;


    public RecycleViewAdapter(Context context, List<Comanda> comandas){
        this.context= context;
        this.data = comandas;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comanda, parent,
                false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        intetCall = new Intent(Intent.ACTION_DIAL);
        intetWhat = new Intent(Intent.ACTION_SENDTO);
        intetEmail = new Intent(Intent.ACTION_SENDTO);

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.poup_item_comanda);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        viewHolder.item_comanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView name = dialog.findViewById(R.id.popup_name);
                final TextView hora = dialog.findViewById(R.id.popup_hora);
                TextView servico = dialog.findViewById(R.id.popup_servico);
                LinearLayout ligar = dialog.findViewById(R.id.popup_ligar);
                LinearLayout msg = dialog.findViewById(R.id.popup_msg);
                LinearLayout email = dialog.findViewById(R.id.popup_email);

                name.setText(data.get(viewHolder.getAdapterPosition()).getNome());
                hora.setText(data.get(viewHolder.getAdapterPosition()).getHora());
                servico.setText(data.get(viewHolder.getAdapterPosition()).getServico());
                dialog.show();
                ligar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intetCall.setData(Uri.parse("tel:" + data.get(viewHolder.getAdapterPosition()).getTelefone()));
                        context.startActivity(intetCall);
                        dialog.dismiss();
                    }
                });
                msg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){

                        String msg =
                                String.format("Olá, %s está confirmado o agendamento para as %s ?" ,
                                name.getText().toString(), hora.getText().toString());

                        intetWhat.setAction(Intent.ACTION_VIEW);
                        String url = "https://api.whatsapp.com/send?phone=55"
                                + data.get(viewHolder.getAdapterPosition()).getTelefone().trim()
                                + "&text=" + msg ;
                        intetWhat.setData(Uri.parse(url));
                        context.startActivity(intetWhat);
                        dialog.dismiss();
                    }
                });
                email.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String msg =
                                String.format("Olá, %s está confirmado o agendamento para as %s ?" ,
                                        name.getText().toString(), hora.getText().toString());

                        intetEmail.setData(Uri.parse("mailto:" +
                                data.get(viewHolder.getAdapterPosition()).getEmail().trim()));
                        intetEmail.putExtra(Intent.EXTRA_SUBJECT,"Agendamento");
                        intetEmail.putExtra(Intent.EXTRA_TEXT, msg);
                        context.startActivity(Intent.createChooser(intetEmail,""));

                        dialog.dismiss();
                    }
                });

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
