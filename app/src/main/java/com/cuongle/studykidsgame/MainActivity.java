package com.cuongle.studykidsgame;

import android.os.Bundle;

import com.cuongle.studykidsgame.ui.competition.CompetitionFragment;
import com.cuongle.studykidsgame.ui.congratulations.CongrationsFragment;
import com.cuongle.studykidsgame.ui.pratice.PraticeFragment;
import com.cuongle.studykidsgame.ui.videos.VideosFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    List<Fragment> activeCenterFragments = new ArrayList<Fragment>();
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        /*getSupportFragmentManager()
                .beginTransaction().
                remove(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).commit();*/


        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.hide()*/;
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        removeActiveCenterFragments();


        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_pratice, R.id.nav_competition,
                R.id.nav_lesson, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {






                removeActiveCenterFragments();


                /*FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.remove(new CongrationsFragment());
                trans.commit();
                manager.popBackStack();*/

                /*if(destination.getId() == R.id.full_screen_destination) {
                    toolbar.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(View.GONE);
                } else {
                    toolbar.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.VISIBLE);
                }*/
                //Toast.makeText(getApplicationContext(),"AAAA: " + controller,Toast.LENGTH_SHORT).show();
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

    private void removeActiveCenterFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (activeCenterFragments.size() > 0) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            for (Fragment activeFragment : activeCenterFragments) {
                fragmentTransaction.remove(activeFragment);
            }
            activeCenterFragments.clear();
            fragmentTransaction.commit();
        }
    }


}
