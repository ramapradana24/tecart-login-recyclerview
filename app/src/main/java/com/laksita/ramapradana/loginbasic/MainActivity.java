package com.laksita.ramapradana.loginbasic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences profile;
    private Button btnLogout;
    List<Teman> daftarTeman;
    private RecyclerView rvDaftarTeman;
    private TemanAdapter temanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        get shared pref named profile, and if there is username key exist then continue else intent back to login
        profile = getSharedPreferences("profile", Context.MODE_PRIVATE);
        final Intent toLogin = new Intent(MainActivity.this, LoginActivity.class);
        if(!profile.contains("username")){
            startActivity(toLogin);
            finish();
        }

//        initialize recycler view
        rvDaftarTeman = findViewById(R.id.rv_daftar_teman);

//        generate list
        generateTeman();

//        make new recyclerview adapter instansce
        temanAdapter = new TemanAdapter(this.daftarTeman);

//        use vertical layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

//        tell the recycler view to set the layout and adapter
        rvDaftarTeman.setNestedScrollingEnabled(false);
        rvDaftarTeman.setLayoutManager(linearLayoutManager);
        rvDaftarTeman.setAdapter(temanAdapter);

//        btnLogout = findViewById(R.id.btn_logout);
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences.Editor profileEditor = profile.edit();
//                profileEditor.clear().apply();
//
//                startActivity(toLogin);
//                finish();
//            }
//        });
    }

//    generate 10 list
    public void generateTeman(){
        daftarTeman = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            Teman teman = new Teman("Teman " + (i+1), "Alamat teman " + (i+1), "08223625523" + (i+1));
            daftarTeman.add(teman);
        }
    }
}
