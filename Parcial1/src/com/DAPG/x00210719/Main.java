package com.DAPG.x00210719;
import javax.swing.JOptionPane;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        int op;
        try{
        do{
            op =Integer.parseInt(JOptionPane.showInputDialog(null, ShowMenu()));
            switch (op){
                case 1:
                    int aux = 0;
                    aux = Integer.parseInt(JOptionPane.showInputDialog(null, ShowMenuEmpleado()));
                    if(aux == 1){
                        String nombre1 = JOptionPane.showInputDialog(null, "Nombre: ");
                        String puesto1 = JOptionPane.showInputDialog(null, "Puesto: ");
                        double salario1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario base:"));
                        int mesescontrato = Integer.parseInt(JOptionPane.showInputDialog(null, "Meses del contrato: "));
                        ServicioProfesional nuevoSP = new ServicioProfesional(nombre1, puesto1, salario1, mesescontrato);
                        double salarioFinal = CalculadoraImpuestos.calcularPago(nuevoSP);
                        JOptionPane.showMessageDialog(null, "El empleado "+ nuevoSP.getNombre()+" tendra un sueldo liquido de: "+ salarioFinal+
                                "\nSe le ha descontado de renta: "+ CalculadoraImpuestos.getRentaSP(nuevoSP));
                    }
                    else {
                        String nombre2 = JOptionPane.showInputDialog(null, "Nombre: ");
                        String puesto2 = JOptionPane.showInputDialog(null, "Puesto: ");
                        double salario2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario base:"));
                        int extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Extension: "));
                        PlazaFija nuevoPF = new PlazaFija(nombre2, puesto2, salario2, extension);
                        double salarioFinal = CalculadoraImpuestos.calcularPago(nuevoPF);
                        JOptionPane.showMessageDialog(null, "El empleado "+ nuevoPF.getNombre()+" tendra un sueldo liquido de: "+ salarioFinal+
                                "\nSe le ha descontado de renta: "+ CalculadoraImpuestos.getRentaPF(nuevoPF)+
                                "\nSe le ha descontado de AFP: "+ CalculadoraImpuestos.getAFP(nuevoPF)+
                                "\nSe le ha descontado de ISSS: "+ CalculadoraImpuestos.getISSS(nuevoPF));
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales());
                    break;
                case 3:
                    break;
            }
        }while (op != 3);
        }
        catch (InputMismatchException exc){
            JOptionPane.showMessageDialog(null, "Error en el Scanner.");
        }
        catch (IndexOutOfBoundsException exc){
            JOptionPane.showMessageDialog(null, "No ha ingresado nada.");
        }
        catch (NumberFormatException exc){
            JOptionPane.showMessageDialog(null, "Ingreso una dato erroneo...");
        }
    }
    public static String ShowMenu() {
        return "1. Calcular sueldo\n2. Mostrar totales de descuentos\n3. Salir";
    }
    public static String ShowMenuEmpleado() {
        return "1. Servicio Profesional\n2. Plaza fija";
    }
}
