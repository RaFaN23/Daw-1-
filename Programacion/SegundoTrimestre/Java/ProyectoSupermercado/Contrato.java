package modelos;

import java.util.Objects;

public class Contrato {
    private int identificador;
    private double salarioBase;
    private TipoContrato tipoContrato;

    public enum TipoContrato {
        PRACTICAS, TEMPORAL, OBRAYSERVICIO, INDEFINIDO
    }

    // Constructor vacío
    public Contrato() {
    }

    // Constructor completo
    public Contrato(int identificador, double salarioBase, TipoContrato tipoContrato) {
        this.identificador = identificador;
        this.salarioBase = salarioBase;
        this.tipoContrato = tipoContrato;
    }

    // Constructor de copia
    public Contrato(Contrato contrato) {
        this.identificador = contrato.identificador;
        this.salarioBase = contrato.salarioBase;
        this.tipoContrato = contrato.tipoContrato;
    }

    // Getters y Setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    // Método toString
    @Override
    public String toString() {
        return "Contrato{" +
                "identificador=" + identificador +
                ", salarioBase=" + salarioBase +
                ", tipoContrato=" + tipoContrato +
                '}';
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return identificador == contrato.identificador && Double.compare(contrato.salarioBase, salarioBase) == 0 && tipoContrato == contrato.tipoContrato;
    }

    // Método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(identificador, salarioBase, tipoContrato);
    }
}
