package com.technologylabs.paradiseapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;


public class ShowInfoController extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        Bundle b = getIntent().getExtras();
        int selection = b.getInt("Selection");
        fillInformation(selection);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void fillInformation(int typeOfData){
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
                installation= WebServiceConnection.getInstance().getAttractions();
                adapter = new RVAdapter(installation,1);
                recycler.setAdapter(adapter);
                break;
            case 2: //show simulators
                installation= WebServiceConnection.getInstance().getSimulators();
                adapter = new RVAdapter(installation,2);
                recycler.setAdapter(adapter);
                break;

            case 3: //show restaurant
                installation= WebServiceConnection.getInstance().getRestaurants();
                adapter = new RVAdapter(installation,3);
                recycler.setAdapter(adapter);
                break;
            case 4: //show food
                installation= WebServiceConnection.getInstance().getFoods();
                adapter = new RVAdapter(installation,4);
                recycler.setAdapter(adapter);
                break;
            case 5: //show shows
                installation= WebServiceConnection.getInstance().getShows();
                adapter = new RVAdapter(installation,5);
                recycler.setAdapter(adapter);
                break;
            case 6: //show stores
                installation= WebServiceConnection.getInstance().getStores();
                adapter = new RVAdapter(installation,6);
                recycler.setAdapter(adapter);
                break;
            case 7: //show items
                installation= WebServiceConnection.getInstance().getItems();
                adapter = new RVAdapter(installation,7);
                recycler.setAdapter(adapter);
                break;
        }
    }
}
