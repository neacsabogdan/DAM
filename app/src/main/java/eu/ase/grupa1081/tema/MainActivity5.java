package eu.ase.grupa1081.tema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    private ListView lv;
    private MealAdapter mealAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mealAdapter = new MealAdapter(getMeals());
        lv = findViewById(R.id.listview);
        lv.setAdapter(mealAdapter);
    }
    private List<Meal> getMeals(){
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Ciorba de vacuta",53.8f,2.7f,3.3f,3.3f));
        meals.add(new Meal("Cartofi prajiti",319,4,17,38));
        meals.add(new Meal("Lasagna cu carne de vita",127,8.3f,4.7f,12.9f));
        return meals;
    }
}

