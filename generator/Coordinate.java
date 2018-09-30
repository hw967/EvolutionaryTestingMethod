package generator;

// Coordinates in the virtual environment

public class Coordinate {
	int i, j; 
	
    public Coordinate(int i, int j) {
    	this.i = i; 
    	this.j = j;
    };
    
    public int i() { 
    	return i;
    }

    public int j() { 
    	return j;
    }

    public void print() {
    	System.out.println("(" + i + "," + j + ")");
    }
    
    public Coordinate north() {
    	return new Coordinate(i-1, j);
    }
    
    public Coordinate south() {
    	return new Coordinate(i+1, j);
    }
    
    public Coordinate east() {
    	return new Coordinate(i, j+1);
    }
    
    public Coordinate west() {
    	return new Coordinate(i, j-1);
    }

}
