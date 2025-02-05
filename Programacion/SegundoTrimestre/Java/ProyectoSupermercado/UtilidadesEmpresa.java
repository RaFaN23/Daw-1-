package utilidades;

import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoContrato;

import java.util.List;
import java.util.stream.Collectors;

public class UtilidadesEmpresa {

    // Método que devuelve la lista de empleados con un tipo de contrato específico
    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato) {
        return empresa.getEmpleados().stream()
                .filter(empleado -> empleado.getContrato().getTipoContrato() == tipoContrato)
                .collect(Collectors.toList());
    }

    // Método que devuelve la lista de mileuristas ordenados por salario de mayor a menor
    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa) {
        return empresa.getEmpleados().stream()
                .filter(empleado -> empleado.getContrato().getSalarioBase() >= 1000)
                .sorted((e1, e2) -> Double.compare(e2.getContrato().getSalarioBase(), e1.getContrato().getSalarioBase()))
                .collect(Collectors.toList());
    }

    // Método que calcula el fondo salarial de la empresa
    public double fondoSalarialEmpresa(Empresa empresa) {
        return empresa.getEmpleados().stream()
                .mapToDouble(empleado -> empleado.getContrato().getSalarioBase())
                .sum();
    }

    // Método que devuelve el empleado mejor pagado entre una lista de empresas
    public Empleado getMejorPagado(List<Empresa> empresas) {
        return empresas.stream()
                .flatMap(empresa -> empresa.getEmpleados().stream())
                .max((e1, e2) -> Double.compare(e1.getContrato().getSalarioBase(), e2.getContrato().getSalarioBase()))
                .orElse(null);
    }
}
