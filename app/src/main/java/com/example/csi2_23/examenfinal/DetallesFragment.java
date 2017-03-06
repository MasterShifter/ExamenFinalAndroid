package com.example.csi2_23.examenfinal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetallesFragment extends DialogFragment {

    private String id, texto, fecha, hora, comentario;
    TextView txtFragId, txtFragTexto, txtFragFecha, txtFragHora, txtFragComentario;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.fragment_detalles, null);
        builder.setView(v);

        txtFragId = (TextView) v.findViewById(R.id.txtFragId);
        txtFragTexto = (TextView) v.findViewById(R.id.txtFragTexto);
        txtFragFecha = (TextView) v.findViewById(R.id.txtFragFecha);
        txtFragHora = (TextView) v.findViewById(R.id.txtFragHora);
        txtFragComentario = (TextView) v.findViewById(R.id.txtFragComentario);

        txtFragId.setText(id);
        txtFragTexto.setText(texto);
        txtFragFecha.setText(fecha);
        txtFragHora.setText(hora);
        txtFragComentario.setText(comentario);

        Button btnFragOk = (Button) v.findViewById(R.id.btnFragOk);
        btnFragOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return builder.create();
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        id = args.getString("id");
        texto = args.getString("texto");
        fecha = args.getString("fecha");
        hora = args.getString("hora");
        comentario = args.getString("comentario");
    }

}