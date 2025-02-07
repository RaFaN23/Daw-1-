package utilidades;

import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoContrato;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UtilidadesEmpresa {
    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato){
        List<Empleado> empleados = new ArrayList<>();

        for (Empleado empleado : empresa.getEmpleados()){
            if(empleado.getContrato().getTipoContrato().equals(tipoContrato)){
                empleados.add(empleado);
            }
        }return empleados;
    }

    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa) {
        List<Empleado> mileuristas = new ArrayList<>();

        for (Empleado empleado : empresa.getEmpleados()) {
            if (empleado.getSalario() >= 1000) {
                mileuristas.add(empleado);
            }
        }

        mileuristas.sort(Comparator.comparingDouble(Empleado::getSalario).reversed());

        return mileuristas;
    }

    public double fondoSalarialEmpresa(Empresa empresa){
        double sumaSalario = 0.0;
        List<Empleado> empleados = empresa.getEmpleados();
                for (Empleado empleado : empleados){
                    sumaSalario += empleado.getSalario();

                }return sumaSalario;
    }
    public Empleado getMejorPagado(List<Empresa> empresas){
        Empleado empleado = null;
        for (Empresa empresa : empresas){
            for (Empleado empleado1 : empresa.getEmpleados()){
                if (empleado1.getSalario() >= empleado.getSalario()){
                    empleado = empleado1;
                }
            }
        }return empleado;
    }
}
