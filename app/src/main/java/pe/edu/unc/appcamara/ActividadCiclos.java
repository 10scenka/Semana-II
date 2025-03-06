package pe.edu.unc.appcamara;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ActividadCiclos extends AppCompatActivity {

    TextView tvEstado;
    ListView lvListaEstados;
    List<String> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_ciclos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvEstado = findViewById(R.id.tvEstado);
        lvListaEstados = findViewById(R.id.lvListaEstados);
        mensaje("Creaciòn");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mensaje("Inicio");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mensaje("Ejecución");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mensaje("Pausado");
        //finish();
        //if(isFinishing())
            //mensaje("Finalizado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mensaje("Detenido");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mensaje("Finalizado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mensaje("Re-Inicio");
    }

    private void mensaje(String estado) {
        tvEstado.setText(estado);
        Log.d("Estado",estado);
        lista.add(estado);
        //La variable tipo lista se va presentar en el listView
        lvListaEstados.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
    }

}