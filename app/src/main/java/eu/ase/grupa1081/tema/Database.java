package eu.ase.grupa1081.tema;


import android.content.Context;

import androidx.room.Room;

public class Database {

    private static Database database;
    private DatabaseMeal databaseMeal;
    private Database(Context context){
        databaseMeal = Room.databaseBuilder(context,
                DatabaseMeal.class, "meal-database").build();
    }

    public static Database getInstance(Context context){
        if(database == null){
            database = new Database(context);
        }
        return database;
    }
    public DatabaseMeal getDataBase(){
        return databaseMeal;
    }

}
