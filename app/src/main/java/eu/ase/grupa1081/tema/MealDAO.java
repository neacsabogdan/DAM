package eu.ase.grupa1081.tema;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Meal... meal);

    @Delete
    void delete(Meal meal);

    @Query("SELECT * FROM meals")
    public List<Meal> getMeals();

    @Query("SELECT * FROM meals WHERE proteins > :proteins")
    List<Meal> getProteinsHigh(float proteins);
}
