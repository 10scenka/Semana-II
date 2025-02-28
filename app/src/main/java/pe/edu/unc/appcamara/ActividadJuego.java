package pe.edu.unc.appcamara;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import Models.Jugada;
import Models.Papel;
import Models.Piedra;
import Models.Tijera;

public class ActividadJuego extends AppCompatActivity {

    RadioButton rbPiedra, rbTijera, rbPapel;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_juego);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbPiedra = findViewById(R.id.rbPiedra);
        rbPiedra.setChecked(true);
        rbPapel = findViewById(R.id.rbPapel);
        rbTijera = findViewById(R.id.rbTijera);
        tvResultado = findViewById(R.id.tvResultadoJuego);

    }

    public void jugar(View boton){
        // Convertir la selección del usuario a una instancia de clase "Jugada"
        Jugada usuario = null;
        if (rbPiedra.isChecked()){
            usuario = new Piedra();
        } else if (rbPapel.isChecked()) {
            usuario = new Papel();
        }else {
            usuario = new Tijera();
        }

        // Creamos una opción random para la simulación de la maquina
        Jugada maquina = null;
        Random aleatoria = new Random();
        int opcion = aleatoria.nextInt(3); // 0: Piedra, 1: Papel, 2: Tijera
        if (opcion == 0){
            maquina = new Piedra();
        } else if (opcion == 1) {
            maquina = new Papel();
        }else {
            maquina = new Tijera();
        }

        String resultado = usuario.comparar(maquina);
        tvResultado.setText(resultado);
    }
}