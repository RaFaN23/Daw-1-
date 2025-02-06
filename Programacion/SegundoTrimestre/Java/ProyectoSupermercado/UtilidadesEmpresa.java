package utilidades;

import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoContrato;

import java.util.ArrayList;
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

    public List<Empleado> getMileuristasOrdenadosPorSalario() {
        List<Empleado> mileuristas = new ArrayList<>();

        for (Empleado empleado : empleado) {
            if (empleado.getSalario() >= 1000) {
                mileuristas.add(empleado);
            }
        }

        mileuristas.sort(Comparator.comparingDouble(Empleado::getSalario).reversed());

        return mileuristas;
    }

}
