
import java.util.Random;

public class Particle {
	
	public double[] location;
	public double[] bestlocation;
	public double localbest_value;
	public double[] velocity;
	
	
	public Particle(int dimension,double[] min, double[] max) {
		location=new double[dimension];
		bestlocation=new double[dimension];
		velocity=new double[dimension];
		Random r = new Random();
		for(int i=0;i<dimension;i++) {
			location[i]=min[i] + (max[i] - min[i]) * r.nextDouble();
			velocity[i]=min[i] + (max[i] - min[i]) * r.nextDouble();
		}
		bestlocation=location.clone();
		double a=bestlocation[0];
		double b=bestlocation[1];
		localbest_value=Math.sin(a + b) + (a - b) * (a - b) + 1.0 + 2.5 * b - 1.5 * a;
		//Mccormick Function
		//Global minimum: -1.9133 at (-0.54719,-1.54719)
	}

}

