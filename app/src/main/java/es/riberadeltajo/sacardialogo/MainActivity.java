package es.riberadeltajo.sacardialogo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoSexo.OnRespuestaSexo {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.btnSacarDialogo);
        b.setOnClickListener(v -> {
            DialogoSexo miDialogo = new DialogoSexo();
            miDialogo.show(getSupportFragmentManager(), "Dialogo sexo");
        });
    }

    @Override
    public void onRespuesta(boolean respuesta) {
            Toast.makeText(this, "La respuesta es "+respuesta, Toast.LENGTH_LONG).show();

    }
}