package com.technologylabs.paradiseapp;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebServiceConnection {
    public static WebServiceConnection getInstance() {
        return ourInstance;
    }

    private String jsonResult="";
    private String url;
    private String toSearch;
    private String ip="172.19.12.139";
    private String id;
    private RVAdapter adapter;
    private RecyclerView recycler;
    private boolean isSearch=false;
    private WebServiceConnection() {
    }

    private class JsonReadTask extends AsyncTask<String,Void,String> {
        private int selection;
        public JsonReadTask(int selection){
            this.selection=selection;
        }


        @Override
        protected String doInBackground(String... params) {
            DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(url);
            InputStream inputStream = null;
            try {
                HttpResponse response = httpclient.execute(get);
                HttpEntity entity = response.getEntity();

                inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
                jsonResult = sb.toString();
                Log.i("Json Responce", jsonResult);
            } catch (IOException e) {
                Log.e("Json Exception", e.toString());
                jsonResult= "No fue posible consultar esta informacion";
            }
            return null;
        }
        private StringBuilder inputStreamToString(InputStream is) {
            String rLine = "";
            StringBuilder answer = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {
                while ((rLine = rd.readLine()) != null) {
                    answer.append(rLine);
                }
            }

            catch (IOException e) {
                // e.printStackTrace();
                Log.e("Json Exception:", e.toString());
            }
            return answer;
        }
        @Override
        protected void onPostExecute(String result) {
            fillData();
        }
        private void fillData(){
            ArrayList<Installation> installations = new ArrayList<>();
            try {
                JSONObject jsonResponse = new JSONObject(jsonResult);
                JSONArray jsonMainNode = jsonResponse.getJSONArray("datos");

                switch (selection) {
                    case 1: //show attractions
                        for (int i = 0; i < jsonMainNode.length(); i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                            String name = jsonChildNode.getString("nombre");
                            String schedule = jsonChildNode.getString("horario");
                            String description = jsonChildNode.getString("descripcion");
                            String state = jsonChildNode.getString("estado");
                            String timeToWait = jsonChildNode.getString("tiempoEspera");

                            if((isSearch && name.equals(toSearch)) || !isSearch){
                                installations.add(new RollerCoaster(name, schedule, description, state, timeToWait));
                            }
                        }
                        break;
                    case 2: //show simulators
                        for (int i = 0; i < jsonMainNode.length(); i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                            String name = jsonChildNode.getString("nombre");
                            String schedule = jsonChildNode.getString("horario");
                            String description = jsonChildNode.getString("descripcion");
                            String state = jsonChildNode.getString("estado");
                            String timeToWait = jsonChildNode.getString("tiempoEspera");
                            String capacity = jsonChildNode.getString("capacidad");

                            if((isSearch && name.equals(toSearch)) || !isSearch){
                                installations.add(new Simulator(name, schedule, description, state, timeToWait, capacity));
                            }
                        }
                        break;

                    case 3: //show restaurant
                        for (int i = 0; i < jsonMainNode.length(); i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                            String name = jsonChildNode.getString("nombre");
                            String schedule = jsonChildNode.getString("horario");
                            String id = jsonChildNode.getString("id");
                            if((isSearch && name.equals(toSearch)) || !isSearch){
                                installations.add(new Restaurant(name, schedule, id));
                            }
                        }
                        break;
                    case 4: //show food
                        for (int i = 0; i < jsonMainNode.length(); i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                            if (jsonChildNode.getString("idRestaurante").equals(id)) {
                                String name = jsonChildNode.getString("nombre");
                                String description = jsonChildNode.getString("descripcion");

                                installations.add(new Food(name, description));
                            }
                        }
                        break;
                    case 5: //show shows
                        for (int i = 0; i < jsonMainNode.length(); i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                            String name = jsonChildNode.getString("nombre");
                            String schedule = jsonChildNode.getString("horario");
                            String place = jsonChildNode.getString("lugar");
                            String description = jsonChildNode.getString("descripcion");

                            if((isSearch && name.equals(toSearch)) || !isSearch){
                                installations.add(new Show(name, schedule, place, description));
                            }
                        }
                        break;
                    case 6: //show stores
                        for (int i = 0; i < jsonMainNode.length(); i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                            String name = jsonChildNode.getString("nombre");
                            String schedule = jsonChildNode.getString("horario");
                            String id = jsonChildNode.getString("id");
                            if((isSearch && name.equals(toSearch)) || !isSearch){
                                installations.add(new Store(name, schedule, id));
                            }
                        }

                        break;
                    case 7: //show items
                        for (int i = 0; i < jsonMainNode.length(); i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                            if (jsonChildNode.getString("idTienda").equals(id)) {
                                String name = jsonChildNode.getString("nombre");
                                String price = jsonChildNode.getString("precio");
                                String amount = jsonChildNode.getString("cantidad");
                                installations.add(new Item(name, price, amount));
                            }
                        }
                        break;
                    case 8: //show contacts
                        for (int i = 0; i < jsonMainNode.length(); i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                            String name = jsonChildNode.getString("nombre");
                            String employment = jsonChildNode.getString("cargo");
                            String num = jsonChildNode.getString("numero");

                            if((isSearch && name.equals(toSearch)) || !isSearch){
                                installations.add(new Contact(name, employment, num));
                            }
                        }
                        break;
                }
                if(isSearch){
                    adapter = new RVAdapter(installations, 9);
                }else{
                    adapter = new RVAdapter(installations, selection);
                }

                recycler.setAdapter(adapter);
            } catch (JSONException e) {
                Log.e("Json Exception", e.toString());
                jsonResult= "No fue posible consultar esta informacion";
            }
        }
    }

    public void getAttractions(RecyclerView recycler){
        this.recycler=recycler;
        url="http://"+ip+":12/atracciones.php";
        JsonReadTask task = new JsonReadTask(1);
        // passes values for the urls string array
        task.execute(new String[]{url});
    }
    public void getSimulators(RecyclerView recycler){
        this.recycler=recycler;
        url="http://"+ip+":12/simuladores.php";
        JsonReadTask task = new JsonReadTask(2);
        // passes values for the urls string array
        task.execute(new String[] { url });
    }

    public void getRestaurants(RecyclerView recycler){
        this.recycler=recycler;
        url="http://"+ip+":12/restaurantes.php";
        JsonReadTask task = new JsonReadTask(3);
        // passes values for the urls string array
        task.execute(new String[] { url });
    }

    public void getFoods(RecyclerView recycler, String id){
        this.id=id;
        this.recycler=recycler;
        url="http://"+ip+":12/platos.php";
        JsonReadTask task = new JsonReadTask(4);
        // passes values for the urls string array
        task.execute(new String[] { url });
    }

    public void getShows(RecyclerView recycler){
        this.recycler=recycler;
        url="http://"+ip+":12/shows.php";
        JsonReadTask task = new JsonReadTask(5);
        // passes values for the urls string array
        task.execute(new String[] { url });
    }

    public void getStores(RecyclerView recycler){
        this.recycler=recycler;
        url="http://"+ip+":12/tiendas.php";
        JsonReadTask task = new JsonReadTask(6);
        // passes values for the urls string array
        task.execute(new String[] { url });
    }

    public void getItems(RecyclerView recycler, String id){
        this.id=id;
        this.recycler=recycler;
        url="http://"+ip+":12/articulos.php";
        JsonReadTask task = new JsonReadTask(7);
        // passes values for the urls string array
        task.execute(new String[] { url });
    }
    public void getContacts(RecyclerView recycler){
        this.recycler=recycler;
        url="http://"+ip+":12/contactos.php";
        JsonReadTask task = new JsonReadTask(8);
        // passes values for the urls string array
        task.execute(new String[] { url });
    }
    public void search(RecyclerView recycler, String toSearch){
        isSearch=true;
        this.toSearch=toSearch;
        getContacts(recycler);
        getAttractions(recycler);
        getRestaurants(recycler);
        getStores(recycler);
        getSimulators(recycler);
        getShows(recycler);



    }
    private static WebServiceConnection ourInstance = new WebServiceConnection();
}
