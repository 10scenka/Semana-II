package pe.edu.unc.appcamara;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActividadContador extends AppCompatActivity {
    EditText tbContador;
    Button btnIncrementar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_contador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tbContador = findViewById(R.id.tbContador);
        btnIncrementar = findViewById(R.id.btnIncrementar);
        tbContador.setText("0");
        btnIncrementar.setOnClickListener(v -> {
            int valorActual = Integer.parseInt(tbContador.getText().toString());
            tbContador.setText(String.valueOf(valorActual + 1));
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        int valorActual = Integer.parseInt(tbContador.getText().toString());
        if (valorActual > 0) {
            tbContador.setText(String.valueOf(valorActual - 1));
        }
    }
}