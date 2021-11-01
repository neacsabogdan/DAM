package eu.ase.grupa1081.tema;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MealAdapter extends BaseAdapter {

    private List<Meal> lista;

    public MealAdapter(List<Meal> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infl = LayoutInflater.from(parent.getContext());
        View itemView = infl.inflate(R.layout.item_meals,parent,false);
        TextView t_name = itemView.findViewById(R.id.MealName);
        TextView t_calories = itemView.findViewById(R.id.MealCalories);
        TextView t_proteins = itemView.findViewById(R.id.MealProteins);
        TextView t_fats = itemView.findViewById(R.id.MealFats);
        TextView t_carbohydrates = itemView.findViewById(R.id.MealCarbohydrates);
        Meal m = lista.get(position);
        t_name.setText(m.getName());
        t_calories.setText(String.valueOf(m.getCalories()));
        t_proteins.setText(String.valueOf(m.getProteinvalues()));
        t_fats.setText(String.valueOf(m.getFatvalues()));
        t_carbohydrates.setText(String.valueOf(m.getCarbohydratesvalues()));
        return itemView;
    }
    public void updateList(List<Meal> lista){
        this.lista.clear();
        this.lista.addAll(lista);
        notifyDataSetChanged();
    }
}
