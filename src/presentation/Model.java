/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.RoboticArm;

/**
 *
 * @author joaquicenos
 */
public class Model implements Runnable{
    
    private RoboticArm roboticArmSystem;
    //private MainView mainView;
    private View view;
    private Thread thread;                      //Delcaracion hilo
    private BufferedImage doubleBuffer1;        //Doble buffer para el canvas #1
    private BufferedImage doubleBuffer2;        //Doble buffer para el canvas #2
    private boolean drawing;                    //Booleano para controlar el hilo
    private int widthCanvas;                    //Variable aux que contendra el ancho del canvas
    private int heightCanvas;                   //Variable aux que contendra el ancho del canvas

    public Model() {
        getView(); // .reset(true);                     
        System.out.println(this.view.toString());
        getView().setVisible(true);                     

        if(thread == null){                                  //Se crea el hilo
            thread = new Thread(this);
            drawing = true;
            thread.start();                                 //Se inicia el hilo
        }
        
    }
    /*public View getView(){
        if
    }*/
    /*
    public void Clean(){
        Canvas lateralView = this.getView().getLateralView();
        Canvas topView = this.getView().getTopView();
        int width = lateralView.getWidth();
        int height = lateralView.getHeight();
        //System.out.println(arm.getWidth()+" ; "+arm.getHeight());
        //System.out.println(body.getWidth()+" ; "+body.getHeight());
        doubleBuffer1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        doubleBuffer2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics spray = doubleBuffer1.getGraphics();
        Graphics can = doubleBuffer2.getGraphics();
        Graphics wall1 = lateralView.getGraphics();
        Graphics wall2 = topView.getGraphics();
        drawArm(spray);
        drawBody(can);
        wall1.drawImage(doubleBuffer1, 0, 0, lateralView);
        wall2.drawImage(doubleBuffer2, 0, 0, topView);
        //System.out.println(this.widthCanvas+" --- "+this.heightCanvas);
    }*/                      //Metodo no usado
    
    public void drawArm (Graphics g){
        g.setColor(Color.white);                //Se establece el color blanco
        g.fillRect(0, 0, 800, 800);             //Se establece el fondo blanco para el canvas
        g.setColor(Color.black);                //Se establece el color blanco
        g.drawRect((int) getRoboticArmSystem().getArtA().getPosX()/2 - (int) getRoboticArmSystem().getStand().getLength()/4, 
                this.heightCanvas - (int) getRoboticArmSystem().getArtA().getPosZ()/2,
                (int) getRoboticArmSystem().getStand().getLength()/2, 
                (int) getRoboticArmSystem().getStand().getHeight()/2);
        //g.fillRect((int) getRoboticArmSystem().getArtA().getPosY(), this.heightCanvas - 3 , 20, 3);
        g.drawLine((int) getRoboticArmSystem().getArtA().getPosX()/2, 
                this.heightCanvas - (int) getRoboticArmSystem().getArtA().getPosZ()/2,
                (int) getRoboticArmSystem().getArtB().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtB().getPosZ()/2);
        //System.out.println(""+(int)getRoboticArmSystem().getArtB().getPosY());
        g.drawLine((int) getRoboticArmSystem().getArtB().getPosX()/2, 
                this.heightCanvas - (int) getRoboticArmSystem().getArtB().getPosZ()/2, 
                (int) getRoboticArmSystem().getArtC().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtC().getPosZ()/2);
        g.drawLine((int) getRoboticArmSystem().getArtC().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtC().getPosZ()/2, 
                (int) getRoboticArmSystem().getArtD().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtD().getPosZ()/2);
        //Draw gripper
        g.drawLine((int) getRoboticArmSystem().getArtD().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtD().getPosZ()/2, 
                (int) getRoboticArmSystem().getGripper().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getGripper().getPosZ()/2);
    }
    
    public void drawBody(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.black);
        g.drawRect((int) getRoboticArmSystem().getArtA().getPosX()/2 - (int) getRoboticArmSystem().getStand().getLength()/4, 
                this.heightCanvas - (int) getRoboticArmSystem().getArtA().getPosY()/2 - (int) getRoboticArmSystem().getStand().getLength()/4,
                (int) getRoboticArmSystem().getStand().getLength()/2, 
                (int) getRoboticArmSystem().getStand().getLength()/2);
        //g.fillRect((int)getRoboticArmSystem().getArtA().getPosX(), heightCanvas - (int)getRoboticArmSystem().getArtA().getPosY(), 50, 50);
        //System.out.println((int)getRoboticArmSystem().getArtA().getPosY());
        g.drawLine((int) getRoboticArmSystem().getArtA().getPosX()/2, 
                this.heightCanvas - (int) getRoboticArmSystem().getArtA().getPosY()/2,
                (int) getRoboticArmSystem().getArtB().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtB().getPosY()/2);
        //System.out.println(""+(int)getRoboticArmSystem().getArtB().getPosX());
        g.drawLine((int) getRoboticArmSystem().getArtB().getPosX()/2, 
                this.heightCanvas - (int) getRoboticArmSystem().getArtB().getPosY()/2, 
                (int) getRoboticArmSystem().getArtC().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtC().getPosY()/2);
        g.drawLine((int) getRoboticArmSystem().getArtC().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtC().getPosY()/2, 
                (int) getRoboticArmSystem().getArtD().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtD().getPosY()/2);
        //Draw gripper
        g.drawLine((int) getRoboticArmSystem().getArtD().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getArtD().getPosY()/2, 
                (int) getRoboticArmSystem().getGripper().getPosX()/2, 
                heightCanvas - (int) getRoboticArmSystem().getGripper().getPosY()/2);
    }
    public RoboticArm getRoboticArmSystem() {
        if (roboticArmSystem == null) {
            roboticArmSystem = new RoboticArm();
        }
        return roboticArmSystem;
    }

    public View getView() {
        if (view == null) {
            view = new View(this);
            
        }
        return view;
    }
    
    public void initialize() {
        getView().setVisible(true);
    }
    
    public void exit() {
        System.exit(0);
    }
   
    public void updateGUI() {
        
        //getMainView().
        
        
    }
    /*
    @Override
    public void run() {
        // Algoritmo del hilo
        //Canvas lienzo = getView().getLienzo();
        int w = lienzo.getWidth();
        int h = lienzo.getHeight();                        
        
        doubleBuffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics lapiz = doubleBuffer.getGraphics();  // Obtener el conexto gráfico
        Graphics lapizLienzo = lienzo.getGraphics();        
        System.out.println("Hilo ejectando");
        while(drawing){                         
            //dibujar(lapiz);
            lapizLienzo.drawImage(doubleBuffer, 0, 0, lienzo);
        }
    }
    */

    @Override
    public void run() {
        
        Canvas lateralCanvas = this.getView().getLateralView();                                       //Se crea una referencia al canvas 1
        Canvas topCanvas = this.getView().getTopView();                                               //Se crea una referencia al canvas 2
        this.widthCanvas = lateralCanvas.getWidth();                                                  //Se asigna el ancho del canvas a una variable aux
        this.heightCanvas = lateralCanvas.getHeight();                                                //Se asigna el alto del canvas a una variable aux
        
        this.doubleBuffer1 = new BufferedImage(this.widthCanvas, this.heightCanvas, BufferedImage.TYPE_INT_ARGB);      //Se instancia el doble buffer 1
        this.doubleBuffer2 = new BufferedImage(this.widthCanvas, this.heightCanvas, BufferedImage.TYPE_INT_ARGB);      //Se instancia el doble buffer 2
        Graphics gContextDB1 = doubleBuffer1.getGraphics();                                           //Se crea el contexto grafico para el canvas falso 1
        Graphics gContextDB2 = doubleBuffer2.getGraphics();                                           //Se crea el contexto grafico para el canvas falso 2
        Graphics gContextCanvas1 = lateralCanvas.getGraphics();                                       //Se crea el contexto grafico para el canvas 1
        Graphics gContextCanvas2 = topCanvas.getGraphics();                                           //Se crea el contexto grafico para el canvas 2
        
        while(drawing){                                                                               //Se dibija hasta que el usuario cierre el programa
            drawArm(gContextDB1);                                                                 
            drawBody(gContextDB2);
            gContextCanvas1.drawImage(doubleBuffer1, 0, 0, lateralCanvas);
            gContextCanvas2.drawImage(doubleBuffer2, 0, 0, topCanvas);
            
        }
    }
    
}
