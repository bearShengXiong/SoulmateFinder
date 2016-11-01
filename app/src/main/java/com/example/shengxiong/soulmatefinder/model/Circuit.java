package com.example.shengxiong.soulmatefinder.model;

import java.util.ArrayList;

/**
 * Created by Shengxiong on 2016/10/6.
 */

public class Circuit {
    private ArrayList<Gate> CircuitGate;
    private ArrayList<Wire> CircuitInputWire;
    private Wire CircuitOutputWire;

    public Circuit(ArrayList<Gate> circuitGate, ArrayList<Wire> circuitInputWire, Wire circuitOutputWire) {

        CircuitGate = circuitGate;
        CircuitInputWire = circuitInputWire;
        CircuitOutputWire = circuitOutputWire;

    }

    public ArrayList<Gate> getCircuitGate() {
        return CircuitGate;
    }

    public void setCircuitGate(ArrayList<Gate> circuitGate) {
        CircuitGate = circuitGate;
    }

    public ArrayList<Wire> getCircuitInputWire() {
        return CircuitInputWire;
    }

    public void setCircuitInputWire(ArrayList<Wire> circuitInputWire) {
        CircuitInputWire = circuitInputWire;
    }

    public Wire getCircuitOutputWire() {
        return CircuitOutputWire;
    }

    public void setCircuitOutputWire(Wire circuitOutputWire) {
        CircuitOutputWire = circuitOutputWire;
    }

    public int evalCircuit(){
        for (Gate gate : CircuitGate) {
            gate.evalTheGate();
        }
        return CircuitOutputWire.getChoose();
    }
}
