package com.example.quanlysach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Activity_Nhan_Vien extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__nhan__vien);
        getData();
    }

    public void getData() {
        final ListView listNhanVien = (ListView) findViewById(R.id.lv_NV);
        OkHttpClient okHttpClient = new OkHttpClient();
        Moshi moshi = new Moshi.Builder().build();
        Type nhanVienType = Types.newParameterizedType(List.class, NhanVien.class);
        final JsonAdapter<List<NhanVien>> jsonAdapter = moshi.adapter(nhanVienType);
        Request request = new Request.Builder()
                .url("http://192.168.26.133:81/qls/listNhanVienAll.php")
                .method("GET", null)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Lỗi", "Không kết nối mạng");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                final List<NhanVien> nhanViens = jsonAdapter.fromJson(json);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listNhanVien.setAdapter(new NhanVienAdapter(Activity_Nhan_Vien.this, R.layout.list_item_nhanvien, nhanViens));
                    }
                });
            }
        });
    }
}
