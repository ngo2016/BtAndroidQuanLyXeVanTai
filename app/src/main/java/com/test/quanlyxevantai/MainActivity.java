package com.test.quanlyxevantai;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etSoPhieu, etNgay, etXuatPhat;
    Spinner spTuyen, spTinh, spXe;
    Button btnThem, btnXoa, btnSua, btnThoat;
    ListView lvXe;
    ArrayList tuyen = new ArrayList();
    ArrayList tinh = new ArrayList();
    ArrayList xe = new ArrayList();
    ArrayList<PhieuPhanCong> phieuPhanCongs = new ArrayList<>();
    XeVanTaiDB xeVanTaiDB;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetControl();
        SetEvent();
    }

    private void SetEvent() {
        xeVanTaiDB = new XeVanTaiDB(this);

        tuyen.add("Hồ Chí Minh - Bình Dương");
        tuyen.add("Hồ Chí Minh - Long An");
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, tuyen);
        spTuyen.setAdapter(adapter);

        tinh.add("Hồ Chí Minh");
        tinh.add("Long An");
        ArrayAdapter adapter1 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, tinh);
        spTinh.setAdapter(adapter1);

        xe.add("Lamboghini");
        xe.add("Ferrari");
        ArrayAdapter adapter2 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, xe);
        spXe.setAdapter(adapter2);

        final CustomAdapter adapter3 = new CustomAdapter(this,
                R.layout.listview_item, phieuPhanCongs);
        lvXe.setAdapter(adapter3);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etSoPhieu.getText().toString().equals("")) {
                    etSoPhieu.setError("Bạn phải nhập Số ");
                    etSoPhieu.requestFocus();
                    return;
                }
                if (etNgay.getText().toString().equals("")) {
                    etNgay.setError("Bạn phải nhập Ngày");
                    etNgay.requestFocus();
                    return;
                }
                if (etXuatPhat.getText().toString().equals("")) {
                    etXuatPhat.setError("Bạn phải nhập Xuất phát");
                    etXuatPhat.requestFocus();
                    return;
                }

                PhieuPhanCong phanCong = layDL();
                XeVanTaiDB.them(phanCong);

                Cursor cursor = XeVanTaiDB.layTatCaDuLieu();
                if (cursor != null) {
                    phieuPhanCongs.clear();
                    while (cursor.moveToNext()) {
                        PhieuPhanCong phieuPhanCong = new PhieuPhanCong();
                        phieuPhanCong.setId("" + cursor.getInt(0));
                        phieuPhanCong.setSoPhieu(cursor.getString(1));
                        phieuPhanCong.setNgay(cursor.getString(2));
                        phieuPhanCong.setXuatPhat(cursor.getString(3));
                        phieuPhanCong.setTuyen(cursor.getString(4));
                        phieuPhanCong.setTinh(cursor.getString(5));
                        phieuPhanCong.setXe(cursor.getString(6));
                        phieuPhanCongs.add(phieuPhanCong);
                    }
                    adapter3.notifyDataSetChanged();
                }
            }

            private PhieuPhanCong layDL() {
                PhieuPhanCong phieuPhanCong = new PhieuPhanCong();

                phieuPhanCong.setSoPhieu(etSoPhieu.getText().toString());
                phieuPhanCong.setNgay(etNgay.getText().toString());
                phieuPhanCong.setXuatPhat(etXuatPhat.getText().toString());
                phieuPhanCong.setTuyen(spTuyen.getSelectedItem().toString());
                phieuPhanCong.setTinh(spTinh.getSelectedItem().toString());
                phieuPhanCong.setXe(spXe.getSelectedItem().toString());

                return phieuPhanCong;
            }
        });

        lvXe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
                etSoPhieu.setText(phieuPhanCongs.get(position).getSoPhieu());
                etNgay.setText(phieuPhanCongs.get(position).getNgay());
                etXuatPhat.setText(phieuPhanCongs.get(position).getXuatPhat());
                spTuyen.setSelection(tuyen.indexOf(phieuPhanCongs.get(position).getTuyen()));
                spTinh.setSelection(tinh.indexOf(phieuPhanCongs.get(position).getTinh()));
                spXe.setSelection(xe.indexOf(phieuPhanCongs.get(position).getXe()));
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhieuPhanCong phieuPhanCong = new PhieuPhanCong();
                phieuPhanCong.setSoPhieu(etSoPhieu.getText().toString());
                XeVanTaiDB.xoa(phieuPhanCong);

                Cursor cursor = XeVanTaiDB.layTatCaDuLieu();
                if (cursor != null) {
                    phieuPhanCongs.clear();
                    while (cursor.moveToNext()) {
                        PhieuPhanCong phanCong = new PhieuPhanCong();
                        phanCong.setId("" + cursor.getInt(0));
                        phanCong.setSoPhieu(cursor.getString(1));
                        phanCong.setNgay(cursor.getString(2));
                        phanCong.setXuatPhat(cursor.getString(3));
                        phanCong.setTuyen(cursor.getString(4));
                        phanCong.setTinh(cursor.getString(5));
                        phanCong.setXe(cursor.getString(6));
                        phieuPhanCongs.add(phanCong);
                    }
                    adapter3.notifyDataSetChanged();
                }
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhieuPhanCong phieuPhanCong = new PhieuPhanCong();
                phieuPhanCong.setSoPhieu(etSoPhieu.getText().toString().trim());
                phieuPhanCong.setNgay(etNgay.getText().toString().trim());
                phieuPhanCong.setXuatPhat(etXuatPhat.getText().toString().trim());
                phieuPhanCong.setTuyen(spTuyen.getSelectedItem().toString());
                phieuPhanCong.setTinh(spTinh.getSelectedItem().toString());
                phieuPhanCong.setXe(spXe.getSelectedItem().toString());
                XeVanTaiDB.sua(phieuPhanCong);

                Cursor cursor = XeVanTaiDB.layTatCaDuLieu();
                if (cursor != null) {
                    phieuPhanCongs.clear();
                    while (cursor.moveToNext()) {
                        PhieuPhanCong phanCong = new PhieuPhanCong();
                        phanCong.setId("" + cursor.getInt(0));
                        phanCong.setSoPhieu(cursor.getString(1));
                        phanCong.setNgay(cursor.getString(2));
                        phanCong.setXuatPhat(cursor.getString(3));
                        phanCong.setTuyen(cursor.getString(4));
                        phanCong.setTinh(cursor.getString(5));
                        phanCong.setXe(cursor.getString(6));
                        phieuPhanCongs.add(phanCong);
                    }
                    adapter3.notifyDataSetChanged();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setTitle("Xác nhận thoát")
                        .setMessage("Bạn có chắc chắn muốn thoát?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setNegativeButton("No", null)
                        .show();
            }
        });
    }

    private void SetControl() {
        etSoPhieu = findViewById(R.id.etSoPhieu);
        etNgay = findViewById(R.id.etNgay);
        etXuatPhat = findViewById(R.id.etXuatPhat);
        spTuyen = findViewById(R.id.spTuyen);
        spTinh = findViewById(R.id.spTinh);
        spXe = findViewById(R.id.spXe);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        lvXe = findViewById(R.id.lvXe);
    }
}
