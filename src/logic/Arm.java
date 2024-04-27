/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author joaquiceno
 */
public class Arm {
    // Attributes
    private double length;
    private double angleAlpha;
    private double anglePhi;
    // Constructor
    public Arm(double angleAlpha) {
        this.length = 150;
        this.angleAlpha = Math.toRadians(angleAlpha);
    }
    // Getters and Setters
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getAngleAlpha() {
        return angleAlpha;
    }

    public void setAngleAlpha(double angleAlpha) {
        this.angleAlpha = Math.toRadians(angleAlpha);
    }

    public double getAnglePhi() {
        return anglePhi;
    }

    public void setAnglePhi(double anglePhi) {
        this.anglePhi = anglePhi;
    }
}
