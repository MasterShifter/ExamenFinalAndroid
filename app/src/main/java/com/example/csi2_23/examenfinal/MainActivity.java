package com.example.csi2_23.examenfinal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Cita> citas = new ArrayList<Cita>();
    private RecyclerView recLista;
    private Toolbar toolbar;
    private AdaptadorCitas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recLista = (RecyclerView) findViewById(R.id.recLista);
        recLista.setHasFixedSize(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        rellenarCitas();
        procesarCitas();
    }

    private void rellenarCitas() {
        citas.add(new Cita(1, "Cita 1", "07/08/2017", "7:10", "Este es el contenido de la cita 1, tomar precauciones con el paciente"));
        citas.add(new Cita(2, "Cita 2", "07/09/2017", "8:20", "Este es el contenido de la cita 2, el paciente tiene los ojos irritados de tanto estudiar"));
        citas.add(new Cita(3, "Cita 3", "07/10/2017", "9:30", "Este es el contenido de la cita 3, se lesionó una uña en el partido de futbol"));
        citas.add(new Cita(4, "Cita 4", "07/11/2017", "10:40", "Este es el contenido de la cita 4, va a llegar a tercera hora para hacer el examen"));
        citas.add(new Cita(5, "Cita 5", "07/12/2017", "11:50", "Este es el contenido de la cita 5, tomar precauciones con el paciente"));
        citas.add(new Cita(6, "Cita 6", "07/13/2017", "12:00", "Este es el contenido de la cita 6, abrió un tarro de aceitunas sin permiso"));
        citas.add(new Cita(7, "Cita 7", "07/14/2017", "13:10", "Este es el contenido de la cita 7, el paciente no sabe que más poner"));
    }

    private void procesarCitas() {
        adaptador = new AdaptadorCitas();
        recLista.setAdapter(adaptador);
        recLista.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class AdaptadorCitas extends RecyclerView.Adapter<AdaptadorCitas.CitasViewHolder> {


        @Override
        public CitasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_citas, parent, false);

            CitasViewHolder cvh = new CitasViewHolder(item);

            return cvh;
        }

        @Override
        public void onBindViewHolder(CitasViewHolder holder, int position) {
            Cita c = citas.get(position);

            holder.bindCita(c);
        }

        @Override
        public int getItemCount() {
            return citas.size();
        }

        class CitasViewHolder extends RecyclerView.ViewHolder {
            private TextView txtCitaId;
            private TextView txtCitaTexto;
            private TextView txtCitaFecha;
            private TextView txtCitaHora;
            private TextView txtCitaComentario;

            public CitasViewHolder(final View itemView) {
                super(itemView);

                txtCitaId = (TextView) itemView.findViewById(R.id.txtCitaId);
                txtCitaTexto = (TextView) itemView.findViewById(R.id.txtCitaTexto);
                txtCitaFecha = (TextView) itemView.findViewById(R.id.txtCitaFecha);
                txtCitaHora = (TextView) itemView.findViewById(R.id.txtCitaHora);
                txtCitaComentario = (TextView) itemView.findViewById(R.id.txtCitaComentario);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Pulsado el numero " + txtCitaId.getText(), Toast.LENGTH_SHORT).show();

                        DialogFragment detalles = new DetallesFragment();

                        Bundle b = new Bundle();
                        b.putString("id", txtCitaId.getText().toString());
                        b.putString("texto", txtCitaTexto.getText().toString());
                        b.putString("fecha", txtCitaFecha.getText().toString());
                        b.putString("hora", txtCitaHora.getText().toString());
                        b.putString("comentario", txtCitaComentario.getText().toString());
                        detalles.setArguments(b);
                        detalles.show(getFragmentManager(), "Detalles");
                    }
                });
            }

            public void bindCita(Cita c) {
                txtCitaId.setText(c.getId().toString());
                txtCitaTexto.setText(c.getTexto());
                txtCitaFecha.setText(c.getFecha());
                txtCitaHora.setText(c.getHora());
                txtCitaComentario.setText(c.getComentario());
            }

        }
    }
}