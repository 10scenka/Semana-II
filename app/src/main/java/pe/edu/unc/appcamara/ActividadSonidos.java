package pe.edu.unc.appcamara;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class ActividadSonidos extends AppCompatActivity {
    private EditText tvResultado;
    private static final int REQUEST_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_sonidos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvResultado = findViewById(R.id.tvResultadoSonido);

        /**btnHablar.setOnClickListener(v -> {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Habla ahora");

            try {
                startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
            } catch (Exception e) {
                Toast.makeText(this, "El reconocimiento de voz no es soportado en este dispositivo", Toast.LENGTH_SHORT).show();
            }
        });**/

    }

    public void hablar(View boton){
        //Ejmeplo de objeto intento Genérico
        Intent oIntento = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //Enviar Parámetros
        oIntento.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        oIntento.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        oIntento.putExtra(RecognizerIntent.EXTRA_PROMPT, "Habla ahora");
        startActivityIfNeeded(oIntento,200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent oIntent) {
        super.onActivityResult(requestCode, resultCode, oIntent);
        if (requestCode == 200) {
            ArrayList<String> resultado = oIntent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (resultado != null && !resultado.isEmpty()) {
                // Mostrar el primer resultado en el EditText
                tvResultado.setText(resultado.get(0));
            }
        }
    }
}