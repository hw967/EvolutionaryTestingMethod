package generator;

// Virtual Environment, help to check whether there is a clear path

import java.util.Stack;  

public class Environment {

	final static char C=' ', X='x', S='s', E='e', V='.';

	final static int START_I = 1, START_J = 1; 
	final static int END_I = 120, END_J = 120; 

	private char[][] environ = new char[122][122];

	public void wall(){
		for (int i=0; i<size(); i++) {
			for (int j=0; j<size(); j++) {
				if(i==0||j==0) environ[i][j] = X;
				else if (i==121||j==121) environ[i][j] = X;
				else environ[i][j] = C;
			}
		}
	}

	public void startEnd(){
		environ[START_I][START_J] = S;
		environ[END_I][END_J] = E;
	}

	private int size() {
		return environ.length;
	}

	private char mark(int i, int j, char value) {
		assert(inEnv(i,j)); 
		char tmp = environ[i][j];
		environ[i][j] = value;
		return tmp;
	}

	private char mark (Coordinate pos, char value) {
		return mark(pos.i(), pos.j(), value); 
	}



	private boolean isClear(int i, int j) {
		assert(inEnv(i,j)); 
		return (environ[i][j] != X && environ[i][j] != V);
	}

	private boolean isClear(Coordinate pos) {
		return isClear(pos.i(), pos.j());
	}


	private boolean inEnv(int i, int j) {
		if (i >= 0 && i<size() && j>= 0 && j<size()) return true; 
		else return false;
	}

	private boolean inEnv(Coordinate pos) {
		return inEnv(pos.i(), pos.j());
	}


	private boolean isFinal( int i, int j) {
		return (i== Environment.END_I && j == Environment.END_J);
	}

	private boolean isFinal(Coordinate pos) {
		return isFinal(pos.i(), pos.j());
	}


	public char[][] clone() {	
		char[][] environCopy = new char[size()][size()]; 
		for (int i=0; i< size(); i++) 
			for (int j=0; j<size(); j++)
				environCopy[i][j] = environ[i][j];
		return environCopy; 
	}

	public void restore(char[][] savedMaze) {
		for (int i=0; i< size(); i++) 
			for (int j=0; j<size(); j++)
				environ[i][j] = savedMaze[i][j];
	}

	public void obstacle(Obstacle ob){
		int x, y, w, l;
		x=ob.getX()*2+1;
		y=ob.getY()*2+1;
		l=ob.getL()*2;
		w=ob.getW()*2;
		double r = Math.toRadians(ob.getO());

		int[][] xlist = new int[l][w];
		int[][] ylist = new int[l][w];
		int a,b;
		for(int i=0;i<l;i++){
			for(int j=0;j<w;j++){

				a=x-l/2+1+i;
				b=y-w/2+1+j;

				float tempX = a - x;
				float tempY = b - y;


				float rotatedX = (float) (tempX*Math.cos(r) - tempY*Math.sin(r));
				float rotatedY = (float) (tempX*Math.sin(r) + tempY*Math.cos(r));

				float tempa,tempb;

				tempa = rotatedX + x;
				tempb = rotatedY + y;
				xlist[i][j]=Math.round(tempa);
				ylist[i][j]=Math.round(tempb);
			}
		}

		for(int n=0;n<l;n++){
			for(int m=0;m<w;m++){
				if((xlist[n][m]>0&&xlist[n][m]<121)&&(ylist[n][m]>0&&ylist[n][m]<121))
					environ[xlist[n][m]][ylist[n][m]] = X;
			}
		}
	}


	public boolean pathCheck(){
		boolean path;
		char[][] envBackup = clone(); 

		Stack<Coordinate> candidates = new Stack<Coordinate>(); 

		candidates.push(new Coordinate(START_I, START_J)); 

		Coordinate crt, next;
		while (!candidates.empty()) {

			crt = candidates.pop();

			if (isFinal(crt)) break;

			mark(crt, V);

			next = crt.north(); 
			if (inEnv(next) && isClear(next)) candidates.push(next);
			next = crt.east(); 
			if (inEnv(next) && isClear(next)) candidates.push(next);
			next = crt.west(); 
			if (inEnv(next) && isClear(next)) candidates.push(next);
			next = crt.south(); 
			if (inEnv(next) && isClear(next)) candidates.push(next);
		}

		if (!candidates.empty()) 
			path=true;
		else 
			path=false;

		restore(envBackup);
		return path;

	}
};







