package operator;

public class Operator {
	public static void main(String[] args){
		Operator op = new Operator();
		op.runExperiments("./operator/operator/runExperiments.sh");
	}
	
	private void runExperiments(String file){
		Process p;
		
		try{
			p = Runtime.getRuntime().exec(file);
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
