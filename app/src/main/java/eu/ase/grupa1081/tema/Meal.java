package eu.ase.grupa1081.tema;

public class Meal {

    private String name;
    private float calories;
    private float proteinvalues;
    private float fatvalues;
    private float carbohydratesvalues;

    public Meal(String name, float calories, float proteinvalues, float fatvalues, float carbohydratesvalues) {
        this.name = name;
        this.calories = calories;
        this.proteinvalues = proteinvalues;
        this.fatvalues = fatvalues;
        this.carbohydratesvalues = carbohydratesvalues;
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
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", proteinvalues=" + proteinvalues +
                ", fatvalues=" + fatvalues +
                ", carbohydratesvalues=" + carbohydratesvalues +
                '}';
    }
}
