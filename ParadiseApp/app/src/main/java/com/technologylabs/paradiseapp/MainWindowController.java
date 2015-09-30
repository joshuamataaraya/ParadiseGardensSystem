package com.technologylabs.paradiseapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;


public class MainWindowController extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);

        final Button button = (Button) findViewById(R.id.atracciones);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainWindowController.this, SelectAttractionController.class);
                startActivity(intent);

            }
        });
        final Button button2 = (Button) findViewById(R.id.restaurantes);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainWindowController.this, ShowInfoController.class);
                Bundle b = new Bundle();
                b.putInt("Selection", 3); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }
        });
        final Button button3 = (Button) findViewById(R.id.shows);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainWindowController.this, ShowInfoController.class);
                Bundle b = new Bundle();
                b.putInt("Selection", 5); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }
        });
        final Button button4 = (Button) findViewById(R.id.tiendas);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainWindowController.this, ShowInfoController.class);
                Bundle b = new Bundle();
                b.putInt("Selection", 6); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }
        });
        final Button button5 = (Button) findViewById(R.id.Busqueda);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainWindowController.this, SearchController.class);
                Bundle b = new Bundle();
                b.putInt("Selection", 9); //Your id
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        final Button button6 = (Button) findViewById(R.id.contactanos);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainWindowController.this, ShowInfoController.class);
                Bundle b = new Bundle();
                b.putInt("Selection", 8); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_window, menu);
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

}
