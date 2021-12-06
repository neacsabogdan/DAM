package eu.ase.grupa1081.tema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    private ListView lv;
    private MealAdapter mealAdapter;
    private Button btnJSON;
    private MealDAO mealDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mealAdapter = new MealAdapter(getMeals());
        lv = findViewById(R.id.listview);
        lv.setAdapter(mealAdapter);

        btnJSON = findViewById(R.id.btnParsareJson);

        btnJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONReader reader = new JSONReader();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        reader.read("https://jsonkeeper.com/b/PUTW", new IResponse() {
                            @Override
                            public void onSuccess(List<Meal> lista) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mealAdapter.updateList(lista);
                                    }
                                });
                            }

                            @Override
                            public void onError(String errMessage) {
                                Toast.makeText(MainActivity5.this, errMessage, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                thread.start();
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mealDAO = Database.getInstance(MainActivity5.this).getDataBase().mealDAO();
                for (int i=0;i<getMeals().size();i++){
                    mealDAO.insert(getMeals().get(i));
                }
            }
        });
        thread1.start();
    }
    private List<Meal> getMeals(){
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Ciorba de vacuta",53.8f,2.7f,3.3f,3.3f));
        meals.add(new Meal("Cartofi prajiti",319,4,17,38));
        meals.add(new Meal("Lasagna cu carne de vita",127,8.3f,4.7f,12.9f));
        return meals;
    }
}

