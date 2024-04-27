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
public class RoboticArm {

    private Stand stand;
    private Arm armOne, armTwo, armThree;
    private Gripper gripper;
    private Articulation artA, artB, artC, artD;
    //Articulation to stablish the grippers ending point
    //private Articulation gripperEndingPoint;
    // Array of Arms
    private Arm[] arms;
    // Array of Articulations
    private Articulation articulations[];
    // Constructor
    public RoboticArm() {
        // Initialization of the parts
        stand = new Stand();
        armOne = new Arm(90);
        armTwo = new Arm(135);
        armThree = new Arm(135);
        gripper = new Gripper(90);
        artA = new Articulation();
        artB = new Articulation();
        artC = new Articulation();
        artD = new Articulation();
        //gripperEndingPoint = new Articulation();
        // Array of Arms
        arms = new Arm[4];
        arms[0] = armOne;
        arms[1] = armTwo;
        arms[2] = armThree;
        arms[3] = gripper;
        // Array of Articulations
        articulations = new Articulation[4];
        articulations[0] = artA;
        articulations[1] = artB;
        articulations[2] = artC;
        articulations[3] = artD;
        //articulations[4] = gripperEndingPoint;
        
        // Set angle Phi for every arm
        updateAnglesPhi();
        updateCoordinates();
    }
    // Methods
    public void moveRobot(double posX, double posY) {
        // Moves the stand
        this.stand.setPosX(posX);
        this.stand.setPosY(posY);
        // Updates coordinates
        updateCoordinates();
    }

    public void rotateStand(int rotationAngle) {
        // Rotates the stand
        this.stand.setRotationAngle(rotationAngle);
        // Updates coordinates
        updateCoordinates();
    }

    public void moveArm(int armNumber, double angleAlpha) {
        int armPosition = armNumber - 1;
        // Modifies angle alpha of the selected arm
        arms[armPosition].setAngleAlpha(angleAlpha);
        // Updates angle phi for every arm
        updateAnglesPhi();
        // Updates coordinates
        updateCoordinates();
        //System.out.println("SUCCESS!! Values: "+armNumber+" Angle : "+angleAlpha );
    }

    public void updateCoordinates() {
        for (int i = 0; i < articulations.length; i++) {
            if (i == 0) {
                articulations[i].setPosX(this.stand.getPosX());
                articulations[i].setPosY(this.stand.getPosY());
                articulations[i].setPosZ(this.stand.getHeight());
            } else {
                articulations[i].setPosX(
                        articulations[i-1].getPosX() + arms[i-1].getLength() *
                                Math.sin(arms[i-1].getAnglePhi()) *
                                Math.cos(this.stand.getRotationAngle()));
                articulations[i].setPosY(
                        articulations[i-1].getPosY() + arms[i-1].getLength() *
                                Math.sin(arms[i-1].getAnglePhi()) *
                                Math.sin(this.stand.getRotationAngle()));
                articulations[i].setPosZ(
                        articulations[i-1].getPosZ() + arms[i-1].getLength() *
                                Math.cos(arms[i-1].getAnglePhi()));
            }
            if (i == articulations.length - 1) {
                gripper.setPosX(
                        articulations[i].getPosX() + arms[i].getLength() *
                                Math.sin(arms[i].getAnglePhi()) *
                                Math.cos(this.stand.getRotationAngle()));
                gripper.setPosY(
                        articulations[i].getPosY() + arms[i].getLength() *
                                Math.sin(arms[i].getAnglePhi()) *
                                Math.sin(this.stand.getRotationAngle()));
                gripper.setPosZ(
                        articulations[i].getPosZ() + arms[i].getLength() *
                                Math.cos(arms[i].getAnglePhi()));
            }
        }

    }
    // Method to update angle phi for every arm
    public void updateAnglesPhi() {
        for (int i = 0; i < arms.length ; i++) {
            if(i == 0) {
                arms[i].setAnglePhi((Math.PI / 2) - arms[i].getAngleAlpha());
            } else {
                arms[i].setAnglePhi(arms[i-1].getAnglePhi() + Math.PI - arms[i].getAngleAlpha());
            }
        }
    }

    /**
     * @return the artA
     */
    public Articulation getArtA() {
        return artA;
    }

    /**
     * @return the artB
     */
    public Articulation getArtB() {
        return artB;
    }

    /**
     * @return the artC
     */
    public Articulation getArtC() {
        return artC;
    }

    /**
     * @return the artD
     */
    public Articulation getArtD() {
        return artD;
    }

    //public Articulation getGripperEndingPoint() {
    //    return gripperEndingPoint;
    //}

    public Stand getStand() {
        return stand;
    }

    public Gripper getGripper() {
        return gripper;
    }
    
    
    
    
    
}

