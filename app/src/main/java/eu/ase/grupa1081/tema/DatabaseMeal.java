package eu.ase.grupa1081.tema;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Meal.class},version = 1,exportSchema = false)
public abstract class DatabaseMeal extends RoomDatabase {
    public abstract MealDAO mealDAO();
}
