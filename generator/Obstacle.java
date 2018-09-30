package generator;

public class Obstacle {
	private int x, y, l, w, o;
	public Obstacle(Descriptor des){
		this.x=30-(int)(Float.parseFloat(des.getX())*10);
		this.y=30-(int)(Float.parseFloat(des.getY())*10);
		this.l=(int)(Float.parseFloat(des.getL())*10);
		this.w=(int)(Float.parseFloat(des.getW())*10);
		this.o=(int)(Float.parseFloat(des.getO()));
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getL(){
		return l;
	}
	
	public int getW(){
		return w;
	}
	
	public int getO(){
		return o;
	}
}
