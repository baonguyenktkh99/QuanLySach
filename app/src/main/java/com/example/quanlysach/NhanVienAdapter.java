package com.example.quanlysach;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NhanVienAdapter extends BaseAdapter {
    private Activity_Nhan_Vien context;
    private int layout;
    private List<NhanVien> nhanViens;
    public NhanVienAdapter(Activity_Nhan_Vien context, int layout, List<NhanVien> listNhanvien) {
        this.context = context;
        this.layout = layout;
        this.nhanViens = listNhanvien;
    }

    @Override
    public int getCount() {
        return nhanViens.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView maNV, tvTenNV, tvDiaChiNV, tvDienThoaiNV;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.maNV =  (TextView) view.findViewById(R.id.tv_MaNV);
            holder.tvTenNV = (TextView) view.findViewById(R.id.tv_TenNV);
            holder.tvDiaChiNV = (TextView) view.findViewById(R.id.tv_DiaChiNV);
            holder.tvDienThoaiNV = (TextView) view.findViewById(R.id.tv_DienThoaiNV);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final NhanVien nhanVien = nhanViens.get(i);
        holder.maNV.setText(nhanVien.maNV);
        holder.tvTenNV.setText(nhanVien.tenNV);
        holder.tvDiaChiNV.setText(nhanVien.diaChi);
        holder.tvDienThoaiNV.setText(nhanVien.soDT);
        return view;
    }
}
