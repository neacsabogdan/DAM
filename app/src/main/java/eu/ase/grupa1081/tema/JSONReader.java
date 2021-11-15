package eu.ase.grupa1081.tema;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public void read(String urlpath,IResponse response){

        try {
            URL url = new URL(urlpath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder result = new StringBuilder();
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                result.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            List<Meal> lista = parsare(result.toString());

            response.onSuccess(lista);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }
    }

    private List<Meal> parsare(String JSONString){
        List<Meal> meals = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(JSONString);
            JSONArray jsonArray = jsonObject.getJSONArray("meals");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject currentobject=jsonArray.getJSONObject(i);
                String name = currentobject.getString("name");
                float calories = (float)currentobject.getInt("calories");
                float proteins = (float)currentobject.getInt("proteins");
                float fats = (float)currentobject.getInt("fats");
                float carbohydrates = (float)currentobject.getInt("carbohydrates");

                Meal m = new Meal(name,calories,proteins,fats,carbohydrates);
                meals.add(m);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return meals;
    }
}
