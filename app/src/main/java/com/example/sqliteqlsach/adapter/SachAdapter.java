package com.example.sqliteqlsach.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sqliteqlsach.R;
import com.example.sqliteqlsach.model.Sach;

import java.util.List;

public class SachAdapter extends ArrayAdapter<Sach> {

    Activity cont;
    int res;
    List<Sach> obs;

    public SachAdapter(Activity cont, int res, List<Sach> obs)
    {
        super(cont, res, obs);
        this.cont = cont;
        this.res = res;
        this.obs = obs;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = this.cont.getLayoutInflater();
        View item = inflater.inflate(res, null);
        TextView ma = item.findViewById(R.id.txtMa);
        TextView ten = item.findViewById(R.id.txtTen);
        TextView tacgia = item.findViewById(R.id.txttg);
        TextView namxb = item.findViewById(R.id.txtnamXB);


        Sach sach = this.obs.get(position);

        ma.setText(sach.getMa()+"");
        ten.setText(sach.getTen().toString());
        tacgia.setText(sach.getTacgia().toString());
        namxb.setText(sach.getNamXB()+"");




        return item;
    }
}
