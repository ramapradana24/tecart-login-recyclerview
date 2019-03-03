package com.laksita.ramapradana.loginbasic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.ViewHolder> {
    private List<Teman> daftarTeman = new ArrayList<>();

    public TemanAdapter(List<Teman> daftarTeman) {
        this.daftarTeman = daftarTeman;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_daftar_teman, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(daftarTeman.get(i));
    }

    @Override
    public int getItemCount() {
        return daftarTeman.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTelp = itemView.findViewById(R.id.tv_telp);
        }

        public void bind(Teman teman){
            tvNama.setText(teman.getNama());
            tvTelp.setText(teman.getTelp());
        }
    }
}
