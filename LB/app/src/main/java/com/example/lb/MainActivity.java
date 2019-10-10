package com.example.lb;

import android.os.Bundle;

import com.example.lb.ui.gallery.GalleryFragment;
import com.example.lb.ui.home.HomeFragment;
import com.example.lb.ui.send.SendFragment;
import com.example.lb.ui.share.ShareFragment;
import com.example.lb.ui.slideshow.SlideshowFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView =findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_equipo, R.id.nav_salir)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Log.e("PRUEBA","Esto es una prueba");
                switch (menuItem.getItemId())
                {
                     case R.id.nav_home:
                         Toast.makeText(MainActivity.this,"Se presiono",Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        //int id=item.getItemId();

        switch (item.getItemId()) {
            case R.id.nav_home:
                Log.e("Algo pasa","H" + item.getTitle());
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction =getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,homeFragment);
                fragmentTransaction.commit();
                break;
            case R.id.nav_equipo:
                Log.e("Algo pasa","E" + item.getTitle());
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                GalleryFragment galleryFragment = new GalleryFragment();
                fragmentTransaction.replace(R.id.nav_host_fragment, galleryFragment);
                fragmentTransaction.commit();
                break;
            case R.id.nav_salir:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                SlideshowFragment slideshowFragment = new SlideshowFragment();
                fragmentTransaction.replace(R.id.nav_host_fragment, slideshowFragment);
                fragmentTransaction.commit();
                break;
            case R.id.action_settings:
                Log.e("Algo pasa","ASFDSGSGFDHDHDGHFGJGFJFJFHJFGJGFJGFJGFJ " + item.getTitle());
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                GalleryFragment galleryFragment2 = new GalleryFragment();
                fragmentTransaction.replace(R.id.nav_host_fragment, galleryFragment2);
                fragmentTransaction.commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
