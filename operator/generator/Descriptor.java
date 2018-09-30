package generator;

// cellular presentation of obstacles in ARGoS

import java.text.DecimalFormat;

public class Descriptor {
	protected double x, y, l, w;
	final static double xmin = -3, ymin = -3, xmax = 3, ymax = 3;
	final static double lmin = 0.4, wmin = 0.1, lmax = 4, wmax = 0.4;
	protected int o;
	DecimalFormat oneDecimal;
	public Descriptor(){
		oneDecimal = new DecimalFormat("#,##0.0");
		x = xmin + Math.random() * (xmax - xmin);
		y = ymin + Math.random() * (ymax - ymin);
		l = lmin + Math.random() * (lmax - lmin);
		w = wmin + Math.random() * (wmax - wmin);
		o = (int) Math.floor(Math.random() * 360);
	}
	public Descriptor(double x, double y, double l, double w, int o){
		this.x = x;
		this.y = y;
		this.l = l;
		this.w = w;
		this.o = o;
		oneDecimal = new DecimalFormat("#,##0.0");
	}
	
	String getX(){
		
		return oneDecimal.format(x);
	}
	
	String getY(){
		
		return oneDecimal.format(y);
	}
	
	String getL(){
		
		return oneDecimal.format(l);
	}
	
	String getW(){
		
		return oneDecimal.format(w);
	}
	String getO(){
		
		return Integer.toString(o);
	}
}
