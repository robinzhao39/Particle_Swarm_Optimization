import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class pso_main {

    public static void main(String[] args) throws InterruptedException {
    	Frame frame = new Frame();
    	int frameWidth = 1000; 
    	int frameHeight = 1000; 
    	frame.setSize(frameWidth, frameHeight);
    	PSO_swarm swarm=new PSO_swarm(200,2, new double[]{-1.5, -3.0},new double[]{4.0, 4.0},new double[] {0.0, 0.1, 10},frame);
    	frame.setVisible(true);
   	
    	
    	int iteration=100;
    	for(int i=0;i<iteration;i++) {
    		swarm.update();
    	 	frame.setVisible(true);
    	 	Thread.sleep(500);

    	}
    	
    	System.out.println(swarm.bestglobal);
    	System.out.println(swarm.bestposition[0]);
    	System.out.println(swarm.bestposition[1]);
    	
    	 
    
   }
}
    	 



