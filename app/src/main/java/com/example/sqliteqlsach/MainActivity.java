package com.example.sqliteqlsach;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sqliteqlsach.adapter.SachAdapter;
import com.example.sqliteqlsach.dao.DBHelper;
import com.example.sqliteqlsach.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ma,ten,tacgia,namsinh;
    Button btn_them;
    ListView lv;

    DBHelper helper;
    SachAdapter adapter;
    List<Sach> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControls();
        addEvent();
    }

    private void addControls() {
        ma = findViewById(R.id.txtma);
        ten = findViewById(R.id.txtten);
        tacgia = findViewById(R.id.txttacgia);
        namsinh = findViewById(R.id.txtnamsinh);
        btn_them = findViewById(R.id.btn_them);
        lv = findViewById(R.id.lv);

        helper = new DBHelper(MainActivity.this);


        helper.QueryData(DBHelper.CREATE_TABLE);

        arrayList = new ArrayList<>();
        arrayList = helper.getAllSach();

        adapter = new SachAdapter(MainActivity.this, R.layout.item_sach, arrayList);
        lv.setAdapter(adapter);


    }

    public void hienthi()
    {
        arrayList = new ArrayList<>();
        arrayList = helper.getAllSach();

        adapter = new SachAdapter(MainActivity.this, R.layout.item_sach, arrayList);
        lv.setAdapter(adapter);
    }





    private void addEvent() {
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sach sach = new Sach();
                sach.setMa(Integer.parseInt(ma.getText().toString()));
                sach.setTen(ten.getText().toString());
                sach.setTacgia(tacgia.getText().toString());
                sach.setNamXB(Integer.parseInt(namsinh.getText().toString()));

                helper.insert(sach);
                hienthi();

            }
        });



        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Sach sach = arrayList.get(i);
                helper.remove(sach);
                hienthi();

                return false;
            }
        });
    }
}