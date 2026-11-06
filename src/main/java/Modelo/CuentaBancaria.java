/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Excepciones.*;

/**
 *
 * @author hectormurillo
 */
public class CuentaBancaria {
    private double saldo;
    
    public CuentaBancaria (double saldoInicial) {
        this.saldo = saldoInicial;
    }
    
    public synchronized void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            double montoFaltante = monto - saldo;
            throw new SaldoInsuficienteException("Sobregiro de saldo", montoFaltante);
        }
        saldo -= monto;
    }
    
    public double getSaldo () {
        return saldo;
    }
    
}

class ProcesoRetiroHilo implements Runnable {
    private CuentaBancaria cuenta;
    private double monto;
    private ProcesoListener listener;
    
    public interface ProcesoListener {
        void onInicio();
        void onExito(double nuevoSaldo);
        void onError(String error);
        
    }
    
    public ProcesoRetiroHilo(CuentaBancaria cuenta, double monto, ProcesoListener listener) {
        this.cuenta = cuenta;
        this.monto = monto;
        this.listener = listener;
    }
    
    @Override
    public void run() {
        listener.onInicio();
        try {
            Thread.sleep(2000);
            cuenta.retirar(monto);
            listener.onExito(cuenta.getSaldo());
        } catch (SaldoInsuficienteException error) {
            listener.onError(error.getMessage() + "Falta: $"+ error.getMontoFaltante());
        } catch (InterruptedException error) {
            listener.onError("El Proceso Concurrente fue interrumpido");
        }
    }
    
}
