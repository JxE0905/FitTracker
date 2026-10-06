package com.example.fittracker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {

    Spinner spinnerEntrenamiento;
    RadioGroup radioGroupIntensidad;
    CheckBox checkCalentamiento, checkHidratacion, checkEstiramiento;
    ProgressBar progressBar;
    RatingBar ratingBar;
    Button btnRegistrar;
    RecyclerView recyclerSesiones;

    SeekBar seekBarProgreso;
    TextView txtProgresoValor;

    ArrayList<Entrenamiento> listaEntrenamientos;
    EntrenamientoAdapter entrenamientoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        spinnerEntrenamiento = findViewById(R.id.spinnerEntrenamiento);
        radioGroupIntensidad = findViewById(R.id.radioGroupIntensidad);
        checkCalentamiento = findViewById(R.id.checkCalentamiento);
        checkHidratacion = findViewById(R.id.checkHidratacion);
        checkEstiramiento = findViewById(R.id.checkEstiramiento);
        progressBar = findViewById(R.id.progressBar);
        ratingBar = findViewById(R.id.ratingBar);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        recyclerSesiones = findViewById(R.id.recyclerSesiones);

        seekBarProgreso = findViewById(R.id.seekBarProgreso);
        txtProgresoValor = findViewById(R.id.txtProgresoValor);

        String[] entrenamientos = {
                "Fuerza",
                "Cardio",
                "Yoga",
                "Calistenia"
        };

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                entrenamientos
        );

        adapterSpinner.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerEntrenamiento.setAdapter(adapterSpinner);

        listaEntrenamientos = new ArrayList<>();

        entrenamientoAdapter =
                new EntrenamientoAdapter(listaEntrenamientos);

        recyclerSesiones.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerSesiones.setAdapter(entrenamientoAdapter);

        seekBarProgreso.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser
                    ) {
                        progressBar.setProgress(progress);
                        txtProgresoValor.setText(
                                "Progreso: " + progress + "%"
                        );
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        btnRegistrar.setOnClickListener(v -> registrarActividad());
    }

    private void registrarActividad() {

        String tipo = spinnerEntrenamiento
                .getSelectedItem()
                .toString();

        int idSeleccionado =
                radioGroupIntensidad.getCheckedRadioButtonId();

        if (idSeleccionado == -1) {

            Toast.makeText(
                    this,
                    "Selecciona una intensidad",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        RadioButton radioSeleccionado =
                findViewById(idSeleccionado);

        String intensidad =
                radioSeleccionado.getText().toString();

        String aspectos = "";

        if (checkCalentamiento.isChecked()) {
            aspectos += "Calentamiento ";
        }

        if (checkHidratacion.isChecked()) {
            aspectos += "Hidratación ";
        }

        if (checkEstiramiento.isChecked()) {
            aspectos += "Estiramiento ";
        }

        if (aspectos.isEmpty()) {
            aspectos = "Ninguno";
        }

        int progreso = progressBar.getProgress();

        float esfuerzo = ratingBar.getRating();

        Entrenamiento nuevoEntrenamiento =
                new Entrenamiento(
                        tipo,
                        intensidad,
                        aspectos,
                        progreso,
                        esfuerzo
                );

        listaEntrenamientos.add(nuevoEntrenamiento);

        entrenamientoAdapter.notifyItemInserted(
                listaEntrenamientos.size() - 1
        );

        Toast.makeText(
                this,
                "Actividad registrada correctamente",
                Toast.LENGTH_SHORT
        ).show();
    }
}