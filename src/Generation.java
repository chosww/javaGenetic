import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generation {
	private int population;
	private double averageFitness;
	private Species[] generation;
	private int numSpecies;
	Generation(int population){
		this.population = population;
		generation = new Species[population];
		numSpecies = 0;
	}
	
	public void addChild(Species child){
		int index = numSpecies;
		if(index < population){
			generation[index] = child;
			numSpecies++;
		}
	}
	
	public void fillGeneration(){
		for(int i=0;i<population;i++){
			generation[i] = new Species(GAInt.goal);
			numSpecies++;
		}
	}
	
	public void setAvgFitness(){
		double sum = 0;
		for(int i=0;i<population;i++){
			sum += generation[i].getFitness();
		}
		averageFitness = sum/generation.length;
	}
	
	public double getAvgFitness(){
		return averageFitness;
	}
	
	public Species getSpecies(int n){
		return generation[n];
	}
	
	public void crossover(Species s1, Species s2){
		String spec1 = s1.getValue();
		String spec2 = s2.getValue();
		String spec1Sub = "";
		String spec2Sub = "";
		String newS1 = "";
		String newS2 = "";
		Random r = new Random();
		int randPoint1 = r.nextInt(spec1.length());
		int randPoint2 = r.nextInt(spec2.length());
		
		randPoint1 = (randPoint1 - 4 >= 0) ? randPoint1 - 4 : randPoint1;
		randPoint2 = (randPoint2 - 4 >= 0) ? randPoint2 - 4 : randPoint2;
		
		spec1Sub = spec1.substring(randPoint1, randPoint1 + 4);
		spec2Sub = spec2.substring(randPoint2, randPoint2 + 4);
		
		for(int i=0;i<randPoint2;i++){
			newS1 += spec1.charAt(i);
		}
		
		newS1 += spec2Sub;
		
		for(int i=randPoint2+4;i<spec1.length();i++){
			newS1 += spec1.charAt(i);
		}
		
		for(int i=0;i<randPoint1;i++){
			newS2 += spec2.charAt(i);
		}
		
		newS2 += spec1Sub;
		
		for(int i=randPoint1+4;i<spec2.length();i++){
			newS2 += spec2.charAt(i);
		}
		
		Species nextGen1 = new Species(GAInt.goal);
		Species nextGen2 = new Species(GAInt.goal);
		
		nextGen1.setValue(newS1);
		nextGen2.setValue(newS2);
		
		nextGen1.setFitness();
		nextGen2.setFitness();
		
		this.addChild(nextGen1);
		this.addChild(nextGen2);
	}
	
	
	public void printSpecies(){
		System.out.println("Generation ----------------------");
		for(int i=0;i<generation.length;i++){
			System.out.println(generation[i].getValue() + " has fitness of " + generation[i].getFitness());
		}
		System.out.println("This generation's average fitness is :" + averageFitness);
	}
}
