package com.morax.homelibrary;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        setupDrawerContent(navigationView);
        Fragment fragment= null;
        try {
            fragment = (Fragment) HomeFragment.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.CotentFragment, fragment).commit();
        setTitle("Bibloteka domowa");


    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_add_book:
                fragmentClass = DetailsFragment.class;
                break;
            case R.id.nav_browse:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_search:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_help:
                fragmentClass = HomeFragment.class;
                break;
            default:
                fragmentClass = HomeFragment.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.CotentFragment, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        //setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawer.closeDrawers();
    }
    private void setupDrawerContent(NavigationView navigationView) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            selectDrawerItem(menuItem);
                            return true;
                        }
                    });
        }
}
