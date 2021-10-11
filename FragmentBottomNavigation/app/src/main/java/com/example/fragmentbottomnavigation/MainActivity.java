package com.example.fragmentbottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    // membuat referensi tampilan navigasi bawah
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_container , new HomeFragment()).commit();

        //mengatur item yang dipilih ke tampilan navigasi bawah
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        //menambahkan list item yang dipilih ke navigasi bawah
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //membuat satu fragment kosong sehingga fragment-fragment sama dengan nol
                Fragment fragment = null;

                //mengidentifikasi icon mana yang telah dipilih
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_fav:
                        fragment = new FavFragment();
                        break;
                    case R.id.nav_search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.nav_shop:
                        fragment = new ShopFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();

                return true;
            }
        });
    }
}