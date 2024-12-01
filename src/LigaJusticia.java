import javax.swing.*;

public class LigaJusticia {
    private int codigo;
    private String nombre;
    private String superPoder;
    private String mision;
    private int nivelDificultad;
    private double pagoMensual;
    private double aporteFondo;
    private double impuesto;

    public LigaJusticia(int codigo, String nombre, String superPoder, String mision, int nivelDificultad, double PagoMensual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.superPoder = superPoder;
        this.mision = mision;
        this.nivelDificultad = nivelDificultad;
        this.pagoMensual = pagoMensual;
        this.aporteFondo = aporteFondo;
        this.impuesto = impuesto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSuperPoder() {
        return superPoder;
    }

    public void setSuperPoder(String superPoder) {
        this.superPoder = superPoder;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public double CalcularAporteFondo() {
        return pagoMensual * 0.10;
    }

    public double CalcularImpuesto() {
        double pagoAnual = pagoMensual;
        double impuesto;

        if(pagoAnual <= 60000) {
            impuesto = 0;
        } else if(pagoAnual > 60000 && pagoAnual <= 120000) {
            impuesto = pagoAnual * 0.12;
        } else if(pagoAnual > 120000 && pagoAnual <= 240000) {
            impuesto = pagoAnual* 0.25;
        } else {
            impuesto = pagoAnual * 0.35;
        }

        return impuesto;
    }

    public double CalcularPagoNeto(){
        double aporte = CalcularAporteFondo();
        double impuesto = CalcularImpuesto();
        return pagoMensual -aporte-impuesto;
    }
}