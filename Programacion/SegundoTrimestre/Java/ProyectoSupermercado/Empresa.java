package modelos;

import java.util.List;
import java.util.Objects;

public class Empresa {
    private int identificador;
    private String codigoEmpresa;
    private List<Empleado> empleados;
    private TipoEmpresa tipoEmpresa;

    // Constructor vacío
    public Empresa() {}

    // Constructor copia
    public Empresa(Empresa e) {
        this.identificador = e.identificador;
        this.codigoEmpresa = e.codigoEmpresa;
        this.empleados = e.empleados;
        this.tipoEmpresa = e.tipoEmpresa;
    }

    // Constructor completo
    public Empresa(int identificador, String codigoEmpresa, List<Empleado> empleados, TipoEmpresa tipoEmpresa) {
        this.identificador = identificador;
        this.codigoEmpresa = codigoEmpresa;
        this.empleados = empleados;
        this.tipoEmpresa = tipoEmpresa;
    }

    // Getters y Setters
    public int getIdentificador() { return identificador; }
    public void setIdentificador(int identificador) { this.identificador = identificador; }
    public String getCodigoEmpresa() { return codigoEmpresa; }
    public void setCodigoEmpresa(String codigoEmpresa) { this.codigoEmpresa = codigoEmpresa; }
    public List<Empleado> getEmpleados() { return empleados; }
    public void setEmpleados(List<Empleado> empleados) { this.empleados = empleados; }
    public TipoEmpresa getTipoEmpresa() { return tipoEmpresa; }
    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) { this.tipoEmpresa = tipoEmpresa; }

    // Métodos toString, equals y hashcode
    @Override
    public String toString() {
        return "Empresa{" +
                "identificador=" + identificador +ºº
        return ", codigoEmpresa='" + codigoEmpresa + '\'' +
                ", empleados=" + empleados +
                ", tipoEmpresa=" + tipoEmpresa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return identificador == empresa.identificador && codigoEmpresa.equals(empresa.codigoEmpresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, codigoEmpresa);
    }
}
