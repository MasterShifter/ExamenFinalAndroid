package com.example.csi2_23.examenfinal;

/**
 * Created by CSI2-23 on 06/03/2017.
 */

public class Cita {

    private Integer id;
    private String texto;
    private String fecha;
    private String hora;
    private String comentario;

    public Cita(Integer id, String texto, String fecha, String hora, String comentario) {
        this.id = id;
        this.texto = texto;
        this.fecha = fecha;
        this.hora = hora;
        this.comentario = comentario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
