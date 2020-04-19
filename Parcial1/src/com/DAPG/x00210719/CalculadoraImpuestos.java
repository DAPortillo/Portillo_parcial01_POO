package com.DAPG.x00210719;

public class CalculadoraImpuestos {
    static private double totalRenta;
    static private double totalISSS;
    static private double totalAFP;

    private CalculadoraImpuestos(){}

    static public double calcularPago(Empleado X){
        double devuelve = 0;
        if(X instanceof ServicioProfesional){
            devuelve = (X.salario) - (X.salario)*0.1;
            totalRenta+=(X.salario)*0.1;
        }
        else {
            if(X instanceof PlazaFija){
                double restante;
                double renta = 0;
                totalAFP+=(X.salario)*0.0625;
                totalISSS+=(X.salario)*0.03;
                restante = (X.salario)-(X.salario)*0.0625-(X.salario)*0.03;
                if(restante>=0.01 && restante<=472.00){
                    renta = 0;
                    totalRenta+=0;
                }
                if(restante>472.00 && restante<=895.25){
                    renta = 0.1*(restante-472)+17.67;
                    totalRenta+=renta;
                }
                if(restante>895.25 && restante<=2038.11){
                    renta = 0.2*(restante-895.24)+60;
                    totalRenta+=renta;
                }
                if(restante>2038.11){
                    renta = 0.3*(restante-2038.10)+288.57;
                    totalRenta+=renta;
                }
                devuelve = restante-renta;
            }
        }
        return devuelve;
    }
    static public String mostrarTotales(){
        return "Total descuento en renta: "+ totalRenta +".\nTotal descuento en ISSS: "+ totalISSS+ ".\nTotal descuento en AFP: "+ totalAFP;
    }
    static public double getISSS(Empleado X) {
        return (X.salario)*0.03;
    }
    static public double getAFP(Empleado X) {
        return (X.salario)*0.0625;
    }
    static public double getRentaSP(Empleado X) {
        return (X.salario)*0.1;
    }
    static public double getRentaPF(Empleado X) {
        double restante1;
        double renta1 = 0;
        restante1 = (X.salario)-(X.salario)*0.0625-(X.salario)*0.03;
        if(restante1>=0.01 && restante1<=472.00){
            renta1 = 0;
        }
        if(restante1>472.00 && restante1<=895.25){
            renta1 = 0.1*(restante1-472)+17.67;
        }
        if(restante1>895.25 && restante1<=2038.11){
            renta1 = 0.2*(restante1-895.24)+60;
        }
        if(restante1>2038.11){
            renta1 = 0.3*(restante1-2038.10)+288.57;
        }
        return renta1;
    }
}
