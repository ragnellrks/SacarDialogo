package es.riberadeltajo.sacardialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoSexo extends DialogFragment {

    //Un fragmento tiene dos métodos importantes
    //onCreateDialog -> primero de ciclo de vida del fragmento

    OnRespuestaSexo miRespuesta;
    //Escribe una interfaz que se implementa desde una actividad.
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        miRespuesta=(OnRespuestaSexo) getActivity();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());
        myBuilder.setTitle("Pregunta para el usuario");
        myBuilder.setMessage("¿Eres una chica?");
        myBuilder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO: Mandar la respuesta positiva al activity que ha creado


                miRespuesta.onRespuesta(true);
            }
        });
        myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO: mandar respuesta negativa al activity que ha creado
                OnRespuestaSexo miRespuesta=(OnRespuestaSexo) getActivity();
                miRespuesta.onRespuesta(false);
            }
        });
        return myBuilder.create();
    }

    public interface OnRespuestaSexo{
        public void onRespuesta(boolean respuesta);
    }
}
