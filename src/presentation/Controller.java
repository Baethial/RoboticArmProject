/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author joaquicenos
 */
public class Controller implements ActionListener, ItemListener, ChangeListener {
    
    private View view;
    private Model model;

    public Controller(View mainView) {
        this.view = mainView;
        this.model = mainView.getModel();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Action : "+ ae.getActionCommand());
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        System.out.println("Item : "+ ie.toString());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //System.out.println(e.getClass().toString());
        //System.out.println(e.getClass().toString());
        if(e.getSource() instanceof JSlider){
            JSlider slider = (JSlider) e.getSource();
            //System.out.println("Name; "+slider.getName() + " : Value ; "+slider.getValue());
            //Sliders de angulos
            if (slider == this.view.getSldAlfa1() || slider == view.getSldAlfa2() || slider == view.getSldAlfa3() || slider == view.getSldAlfa4()) {
                int armnumber = Integer.valueOf(slider.getName().substring(4));
                System.out.println(slider.getName());
                this.model.getRoboticArmSystem().moveArm(armnumber, slider.getValue());
                //miApp.cambiarValorCoordenada(slider.getName(), slider.getValue());
            //sliders robot
            } else if (slider == this.view.getSldDespX() || slider == this.view.getSldDespY()) {
                this.model.getRoboticArmSystem().moveRobot(this.view.getSldDespX().getValue(), this.view.getSldDespY().getValue());
            //rotate robot    
            } else {
                this.model.getRoboticArmSystem().rotateStand(slider.getValue());
            }
            updateLabels();
        }
    }
    public void updateLabels() {
        
        this.view.getLblArtAPosX().setText("" + (int) this.model.getRoboticArmSystem().getArtA().getPosX());
        this.view.getLblArtAPosY().setText("" + (int) this.model.getRoboticArmSystem().getArtA().getPosY());
        this.view.getLblArtAPosZ().setText("" + (int) this.model.getRoboticArmSystem().getArtA().getPosZ());
        
        this.view.getLblArtBPosX().setText("" + (int) this.model.getRoboticArmSystem().getArtB().getPosX());
        this.view.getLblArtBPosY().setText("" + (int) this.model.getRoboticArmSystem().getArtB().getPosY());
        this.view.getLblArtBPosZ().setText("" + (int) this.model.getRoboticArmSystem().getArtB().getPosZ());
        
        this.view.getLblArtCPosX().setText("" + (int) this.model.getRoboticArmSystem().getArtC().getPosX());
        this.view.getLblArtCPosY().setText("" + (int) this.model.getRoboticArmSystem().getArtC().getPosY());
        this.view.getLblArtCPosZ().setText("" + (int) this.model.getRoboticArmSystem().getArtC().getPosZ());
        
        this.view.getLblArtDPosX().setText("" + (int) this.model.getRoboticArmSystem().getArtD().getPosX());
        this.view.getLblArtDPosY().setText("" + (int) this.model.getRoboticArmSystem().getArtD().getPosY());
        this.view.getLblArtDPosZ().setText("" + (int) this.model.getRoboticArmSystem().getArtD().getPosZ());
        
    }
}
