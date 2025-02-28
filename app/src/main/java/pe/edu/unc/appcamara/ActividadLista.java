package pe.edu.unc.appcamara;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActividadLista extends ListActivity {
    String[] ejercicios = {"TomarFoto","Juego","Sonidos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //(Actividad donde se va a ver la lista, tipo de items, items en la lista)
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ejercicios));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int index, long id) { //La position lo cambiamos por Index
        super.onListItemClick(l, v, index, id);
        Toast.makeText(this,"Opción "+(index+1),Toast.LENGTH_LONG).show();
        Intent oIntento = null;
        try {
            //Declarar un objeto de una clase genérica
            Class<?> ActividadDestino = Class.forName("pe.edu.unc.appcamara.Actividad"+ejercicios[index]);
            oIntento = new Intent(this, ActividadDestino);
            startActivity(oIntento);
        }catch (Exception ex){
            Log.d("Error",ex.getMessage());
        }
    }
}