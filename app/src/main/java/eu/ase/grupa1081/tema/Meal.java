package eu.ase.grupa1081.tema;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "meals")
public class Meal {
    @PrimaryKey(autoGenerate = true)
    private int idMeal;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name="calories")
    private float calories;
    @ColumnInfo(name = "proteins")
    private float proteinvalues;
    @ColumnInfo(name = "fats")
    private float fatvalues;
    @ColumnInfo(name = "carbos")
    private float carbohydratesvalues;

    public Meal() {
        this.name = "";
        this.calories =0;
        this.proteinvalues=0;
        this.fatvalues=0;
        this.carbohydratesvalues=0;
    }

    public Meal(String name, float calories, float proteinvalues, float fatvalues, float carbohydratesvalues) {
        this.name = name;
        this.calories = calories;
        this.proteinvalues = proteinvalues;
        this.fatvalues = fatvalues;
        this.carbohydratesvalues = carbohydratesvalues;
    }

    public int getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(int idMeal) {
        this.idMeal = idMeal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getProteinvalues() {
        return proteinvalues;
    }

    public void setProteinvalues(float proteinvalues) {
        this.proteinvalues = proteinvalues;
    }

    public float getFatvalues() {
        return fatvalues;
    }

    public void setFatvalues(float fatvalues) {
        this.fatvalues = fatvalues;
    }

    public float getCarbohydratesvalues() {
        return carbohydratesvalues;
    }

    public void setCarbohydratesvalues(float carbohydratesvalues) {
        this.carbohydratesvalues = carbohydratesvalues;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "idMeal=" + idMeal +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", proteinvalues=" + proteinvalues +
                ", fatvalues=" + fatvalues +
                ", carbohydratesvalues=" + carbohydratesvalues +
                '}';
    }

    public String toString2() {
        return "Meal: " +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", proteinvalues=" + proteinvalues +
                ", fatvalues=" + fatvalues +
                ", carbohydratesvalues=" + carbohydratesvalues;
    }
}
