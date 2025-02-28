package pe.edu.unc.appcamara;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class ActividadTomarFoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void tomarFoto(View boton){
        //Vamos a declarar un "Intent" de tipo "Genérico"
        Intent oIntento = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Ejecutar el "Intent"
        startActivityIfNeeded(oIntento,100);
    }

    //Sobre escribir un método para capturar la imagen
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent oIntent) {
        super.onActivityResult(requestCode, resultCode, oIntent);
        if(requestCode == 100){ //Si el servicio está funcionando
            if(resultCode==RESULT_OK){//Quiere decir que si hicieron uso del servicio
                Bitmap oImagen = (Bitmap)oIntent.getExtras().get("data");
                ImageView foto = findViewById(R.id.imgFoto);
                foto.setImageBitmap(oImagen);
            }
        }
    }
}