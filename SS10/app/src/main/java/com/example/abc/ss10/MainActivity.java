package com.example.abc.ss10;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Menu menu;
    private boolean menuSendVisible = false;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMenuBar(true);
        setTitle("HOME");
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean rt = super.onPrepareOptionsMenu(menu);
        MenuItem sendMenuItem = menu.findItem(R.id.action_send);
        sendMenuItem.setVisible(menuSendVisible);
        return rt;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
//        getSupportActionBar().show();
        showActionBar(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id== R.id.action_send){
            changeFragment(new PayEndFragment(), true);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        int id = item.getItemId();

        if (id == R.id.nav_article) {
           changeFragment(new ArticleFragment(), true);
        } else if (id == R.id.nav_pay) {
//            menu.getItem(0).setIcon(R.drawable.ic_send_black_24px);
            changeFragment(new PayFragment(), true);
            setMenuBar(false);
        } else if (id == R.id.nav_setting) {
//            menu.getItem(0).setIcon(R.drawable.ic_more_vert_black_24px);
            changeFragment(new SettingFragment(), true);
            setMenuBar(false);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void changeFragment(Fragment fragment, boolean addToBackstck){

        FragmentTransaction fragmentTransaction =getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_home, fragment);
        if (addToBackstck){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    public void showActionBar(boolean visible){
        if (visible){
            getSupportActionBar().show();
        }
        else getSupportActionBar().hide();
    }
    public void showSendMenu(boolean visible){
        this.menuSendVisible = visible;
        this.invalidateOptionsMenu();
    }
    public void setMenuBar(boolean visible) {
        if (visible) {
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        }
        else {
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            toggle.setDrawerIndicatorEnabled(false);
            toggle.setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_black_24px);
            toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSupportFragmentManager().popBackStack();
                    setMenuBar(true);
                    showSendMenu(false);

                }
            });

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        }
    }

}
