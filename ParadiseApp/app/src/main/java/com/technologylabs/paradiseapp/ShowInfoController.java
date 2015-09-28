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
        switch (typeOfData){
            case 1:
                List<Attraction> atracctions= WebServiceConnection.getInstance().getAtracciones();
                RVAdapter adapter = new RVAdapter(atracctions);
                recycler.setAdapter(adapter);
                break;
        }
    }
}
