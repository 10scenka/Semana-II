package pe.edu.unc.appcamara;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActividadValidacion extends AppCompatActivity {

    EditText tbNombre;
    RadioButton rbMasculino,rbFemenino;
    CheckBox cbTerminos;
    Button btnValidar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_validacion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tbNombre = findViewById(R.id.tbNombre);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        rbFemenino.setChecked(true);
        cbTerminos = findViewById(R.id.cbTerminos);
        btnValidar = findViewById(R.id.btnValidar);
    }
    public void validarDatos(View Boton) {
        String nombre = tbNombre.getText().toString().trim();
        boolean genero = rbMasculino.isChecked() || rbFemenino.isChecked();
        boolean terminos = cbTerminos.isChecked();
        if (nombre.isEmpty()) {
            mensaje("Por favor, ingrese un nombre.");
            return;
        }
        if (!genero) {
            mensaje("Debe seleccionar un Género.");
            return;
        }
        if (!terminos) {
            mensaje("Debe aceptar los términos y condiciones.");
            return;
        }
        mensaje("Validación exitosa.");
    }
    private void mensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        rbMasculino.setChecked(true);
        tbNombre.setText("");
        cbTerminos.setChecked(false);
    }
}