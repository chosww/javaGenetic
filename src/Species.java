import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Species {
	static char[] alphabets = new char[]{'a','b','c','d','e','f','g','h','i','j',
			'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
	private int fitness;
	private int high;
	private int low;
	private int crossOverChance;
	private String value;
	
	Species(String goal){
		Random r = new Random();
		low = 0;
		high = alphabets.length;
		fitness = 0;
		value = "";
		for(int i=0;i<goal.length();i++){
			value += alphabets[r.nextInt(high-low)+low];
		}
		for(int i=0;i<goal.length();i++){
			if(value.charAt(i) == goal.charAt(i)){
				fitness++;
			}
		}
		crossOverChance = goal.length()-fitness;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public void setFitness(){
		fitness = 0;
		for(int i=0;i<value.length();i++){
			if(value.charAt(i) == GAInt.goal.charAt(i)){
				fitness++;
			}
		}
	}
	
	public int getCrossOverChance(){
		return crossOverChance;
	}
	
	public int getFitness(){
		return fitness;
	}
	
	public String getValue(){
		return value;
	}
	
	public Species mutate(int chance){
		StringBuilder value = new StringBuilder(this.getValue());
		for(int i=0;i<value.length();i++){
			if(value.charAt(i)!=GAInt.goal.charAt(i)){
				if(ThreadLocalRandom.current().nextInt(chance)==0){
					value.setCharAt(i, Species.alphabets[ThreadLocalRandom.current().nextInt(27)]);
				}
			}
		}
		this.setValue(value.toString());
		this.setFitness();
		return this;
	}
	
}
