package com.test.quanlyxevantai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int layoutId;
    ArrayList<PhieuPhanCong> phieuPhanCongs = new ArrayList<>();

    public CustomAdapter(@NonNull Context context, int layoutId,
                         ArrayList<PhieuPhanCong> phieuPhanCongs) {
        super(context, layoutId);
        this.context = context;
        this.layoutId = layoutId;
        this.phieuPhanCongs = phieuPhanCongs;
    }

    @Override
    public int getCount() {
        return phieuPhanCongs.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutId, null);
        TextView tvNgay = convertView.findViewById(R.id.tvNgay);
        TextView tvTuyen = convertView.findViewById(R.id.tvTuyen);
        TextView tvTinh = convertView.findViewById(R.id.tvTinh);
        TextView tvXe = convertView.findViewById(R.id.tvXe);
        tvNgay.setText(phieuPhanCongs.get(position).getNgay());
        tvTuyen.setText(phieuPhanCongs.get(position).getTuyen());
        tvTinh.setText(phieuPhanCongs.get(position).getTinh());
        tvXe.setText(phieuPhanCongs.get(position).getXe());
        return convertView;
    }
}
