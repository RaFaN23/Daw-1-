package utilidades;

import modelos.Cliente;

public class UtilidadesCliente {
    public boolean esDniValido(Cliente cliente){
        String dni = cliente.getDni();
        if(dni==null || dni.length()!=9){
            return false;
        }
        String numeros=dni.substring(0,8);
        char letra=dni.charAt(9);
        return numeros.chars().allMatch(Character::isDigit) && Character.isLetter(letra);
    }
}
