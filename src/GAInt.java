import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GAInt {
	// change goal to any string you want to reach at the end 
	// the string should not contain any special characters, except space character 
	static String goal = "hello World".toLowerCase();
	
	public static void main(String[] args){
		// population per generation
		int population = 20;
		int genNumber = 1;
		Generation gen = new Generation(population);
		Generation nextGen = new Generation(population);
		gen.fillGeneration();
		gen.setAvgFitness();
		while(gen.getAvgFitness() < (double) (goal.length()-1)){
			for(int i=0;i<population;i=i+2){
				nextGen.crossover(gen.getSpecies(i).mutate(10), gen.getSpecies(i+1));
			}
			genNumber++;
			nextGen.setAvgFitness();
			//comment this out if you want to see each elements in each generation
			//System.out.println( "Generation " + genNumber + " has average fitness of " + nextGen.getAvgFitness());
			gen = nextGen;
			nextGen = new Generation(population);
		}
		
		gen.printSpecies();
	}
}
