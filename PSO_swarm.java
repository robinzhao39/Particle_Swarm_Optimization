import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PSO_swarm {
	
	static ArrayList<Particle> list=new ArrayList<Particle>();
	public double bestglobal;
	public double[] bestposition;
	static public int size;
	public double[] parameters;
	public int dimension;
	public double[] min;
	public double[] max;
	static Frame frame;
	

	public PSO_swarm(int swarm_size,int dimen, double[] mini, double[] maxi, double[] para, Frame f) {
		size=swarm_size;
		parameters=para;
		dimension=dimen;
		min=mini;
		max=maxi;
		frame=f;
		for(int i=0; i<size; i++) {
			Particle new_particle=new Particle(dimen,mini,maxi);
			list.add(new_particle);
		}
		draw();
	}
	
	public void findbest() {
		double tempbest=list.get(0).localbest_value;
		double[] templocation=list.get(0).bestlocation.clone();
		for(int i=1;i<size;i++) {
			if(list.get(i).localbest_value<tempbest) {
				tempbest=list.get(i).localbest_value;
				templocation=list.get(i).bestlocation;
			}
		}
		if(tempbest<bestglobal) {
			bestglobal=tempbest;
			bestposition=templocation;
		}
		
	}
	
	
	public void update() {
		this.findbest();
		Random r=new Random();
	//	boolean threshold=true;
		for(int i=0;i<size;i++) {
			for(int j=0;j<dimension;j++) {
				double r1=r.nextDouble();
				double r2=r.nextDouble();
				list.get(i).velocity[j]=list.get(i).velocity[j]*parameters[0]+
						parameters[1]*r1*(list.get(i).bestlocation[j]-list.get(i).location[j])+
						parameters[2]*r2*(bestposition[j]-list.get(i).location[j]);		
				list.get(i).location[j]=list.get(i).location[j]+list.get(i).velocity[j];
				//threshold= threshold && min[j] < list.get(i).location[j] && max[j] > list.get(i).location[j];
				draw();
			}
		}
		
		for(int i=0;i<size;i++) {
			double a=list.get(i).bestlocation[0];
			double b=list.get(i).bestlocation[1];
			double new_value=Math.sin(a + b) + (a - b) * (a - b) + 1.0 + 2.5 * b - 1.5 * a;
			if(new_value<list.get(i).localbest_value) {
				list.get(i).localbest_value=new_value;
				list.get(i).bestlocation=list.get(i).location.clone();
			}
		}
	}
	
	
	public void draw() {
		frame.removeAll();
		frame.add(new CustomPaintComponent());
	}
	
	static class CustomPaintComponent extends Component { 
		  public void paint(Graphics g) {
		   

		    Graphics2D g2d = (Graphics2D)g;
		   for(int i=0;i<size;i++) {
		    
		    double x=list.get(i).location[0]*10+400;
		    double y=list.get(i).location[1]*10+400;
		    
		    g2d.setPaint(Color.BLACK);
		    g2d.fill(new Ellipse2D.Double(x, y, 10, 10));
		   
	 
		    	
		    }
		 
		   
		  }
		   
		    }
	
	
	
}
	




