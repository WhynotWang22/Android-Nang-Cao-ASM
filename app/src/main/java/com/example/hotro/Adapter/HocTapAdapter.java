package com.example.hotro.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotro.EntityClass.HocTap;
import com.example.hotro.GetData3;
import com.example.hotro.R;
import com.example.hotro.UpdateData;

import java.util.List;

public class HocTapAdapter extends RecyclerView.Adapter<HocTapAdapter.ViewHoler>{
  Context context;
  List<HocTap> list;
    DeleteItemClicklistner deleteItemClicklistner;
    public HocTapAdapter(Context context, List<HocTap> list,DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.list = list;
        this.deleteItemClicklistner = deleteItemClicklistner;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHoler(LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, @SuppressLint("RecyclerView") final int position) {
       holder.Mamon.setText(list.get(position).getMamon());
        holder.Lop.setText(list.get(position).getLop());
        holder.Ngaythi.setText(list.get(position).getNgaythi());
        holder.Kyhoc.setText(list.get(position).getKyhoc());
        holder.Lichhoc.setText(list.get(position).getLichhoc());
         holder.update.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(context, UpdateData.class);
                 intent.putExtra("id",String.valueOf(list.get(position).getKey()));
                 intent.putExtra("mamon",String.valueOf(list.get(position).getMamon()));
                 intent.putExtra("lop",String.valueOf(list.get(position).getLop()));
                 intent.putExtra("ngaythi",String.valueOf(list.get(position).getNgaythi()));
                 intent.putExtra("kyhoc",String.valueOf(list.get(position).getKyhoc()));
                 intent.putExtra("lichhoc",String.valueOf(list.get(position).getLichhoc()));
                 context.startActivity(intent);
             }
         });
        holder.detele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 deleteItemClicklistner.onItemDelete(position,list.get(position).getKey());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHoler extends RecyclerView.ViewHolder
    {
        TextView Mamon,Lop,Ngaythi,Kyhoc,Lichhoc;
        Button update,detele;
        public ViewHoler(@NonNull View itemView){
            super(itemView);

            Mamon = itemView.findViewById(R.id.Mamon);
            Lop = itemView.findViewById(R.id.Lop);
            Ngaythi = itemView.findViewById(R.id.Ngaythi);
            Kyhoc = itemView.findViewById(R.id.Kyhoc);
            Lichhoc = itemView.findViewById(R.id.Lichhoc);

            update = itemView.findViewById(R.id.updateID);
            detele = itemView.findViewById(R.id.detele);
        }
    }
    public interface DeleteItemClicklistner
    {
        void onItemDelete(int position,int id);
    }
}
