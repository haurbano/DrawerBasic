package movil.salt.draweexample;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import movil.salt.draweexample.fragments.HamburguesaFragment;
import movil.salt.draweexample.fragments.PerroFragment;
import movil.salt.draweexample.fragments.PizzaFragment;
import movil.salt.draweexample.fragments.SandwichFragment;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.list_drawer);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close);

        drawerLayout.setDrawerListener(this);

        //Mostrar el boton
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        PizzaFragment pizzaFragment = new PizzaFragment();
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.frame_drawer, pizzaFragment);
        transaction1.commit();
    }


    //region eventos toggle
    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Sync drawer con toggle
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }

    //endregion

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.pizza:
                PizzaFragment pizzaFragment = new PizzaFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.frame_drawer,pizzaFragment);
                transaction1.commit();
                break;

            case R.id.hamburguesa:
                HamburguesaFragment hamburguesaFragment = new HamburguesaFragment();
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.frame_drawer,hamburguesaFragment);
                transaction2.commit();
                break;

            case R.id.perro:
                PerroFragment perroFragment = new PerroFragment();
                FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.frame_drawer,perroFragment);
                transaction3.commit();
                break;

            case R.id.sandwich:
                SandwichFragment sandwichFragment = new SandwichFragment();
                FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                transaction4.replace(R.id.frame_drawer,sandwichFragment);
                transaction4.commit();
                break;
        }
        drawerLayout.closeDrawers();
        return false;
    }




}
