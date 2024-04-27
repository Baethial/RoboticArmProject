/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author joaquicenos
 */
public class Gripper extends Arm{
    // Attributes
    private boolean isGripClosed;
    private double posX, posY, posZ;
    // Constructor
    public Gripper(double inclinationAngle) {
        super(inclinationAngle);
        this.isGripClosed = false;
        setLength(20);
    }
    // Method for the Grip

    public void setGripClosed() {
        if (isGripClosed) {
            isGripClosed = false;
        } else {
            isGripClosed = true;
        }
    }

    public boolean isIsGripClosed() {
        return isGripClosed;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getPosZ() {
        return posZ;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }
    
    
    
}
