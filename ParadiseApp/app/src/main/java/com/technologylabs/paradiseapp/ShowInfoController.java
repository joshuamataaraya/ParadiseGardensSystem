package com.technologylabs.paradiseapp;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import java.util.List;


public class ShowInfoController extends Activity {

    private String toSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        Bundle b = getIntent().getExtras();
        int selection = b.getInt("Selection");
        toSearch=b.getString("ToSearch");
        fillInformation(selection, b.getString("Id"));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_info, menu);
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
            Intent intent = new Intent(this, SearchController.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void fillInformation(int typeOfData, String id){
        RecyclerView recycler = (RecyclerView) findViewById(R.id.rv);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        LinearLayoutManager lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        RVAdapter adapter;
        List<Installation> installation;
        switch (typeOfData){
            case 1: //show attractions
                this.setTitle("Monta\u00f1as Rusa");
                WebServiceConnection.getInstance().getAttractions(recycler);
                break;
            case 2: //show simulators
                this.setTitle("Simuladores");
                WebServiceConnection.getInstance().getSimulators(recycler);
                break;

            case 3: //show restaurant
                this.setTitle("Restaurantes");
                WebServiceConnection.getInstance().getRestaurants(recycler);
                break;
            case 4: //show food
                this.setTitle("Comidas");
                WebServiceConnection.getInstance().getFoods(recycler,id);
                break;
            case 5: //show shows
                this.setTitle("Shows");
                WebServiceConnection.getInstance().getShows(recycler);
                break;
            case 6: //show stores
                this.setTitle("Tiendas");
                WebServiceConnection.getInstance().getStores(recycler);
                break;
            case 7: //show items
                this.setTitle("Art\u00edculos");
                WebServiceConnection.getInstance().getItems(recycler,id);
                break;
            case 8: //show contactanos
                this.setTitle("Cont\u00e1ctanos");
                WebServiceConnection.getInstance().getContacts(recycler);
                break;
            case 9:
                WebServiceConnection.getInstance().search(recycler,toSearch);
                break;
        }
    }
}
