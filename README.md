# Genetic Algorithm

Genetic algorithm is an algorithm that imitates natural selection. Starting from a random population, the goal is to get to superior population by modifying species within its population.

## Project Description

This project is a Java implementation of genetic algorithm. This program will use a string to demonstrate genetic algorithm.

## Project Setup

### Goal String

You can modify goal string in GAInt.java file by changing static variable goal.
For an example, "hello World" is used as goal string. Note that the goal string have to contain a-zA-Z only and its length have to be greater or equal to 7.

```java
    static String goal = "hello World".toLowerCase();
```

### Population

You can modify number of species in population by changing variable population in GAInt class.

```java
    int population = 20;
```

## Project Detail

###Initialize random population
Once you set the goal string, the program will generate n species of random strings with same length as the goal string.

###Checking for fitness
These random species will mutate themselves to the goal string by checking how close they are to the goal string.

###Crossover
Within the population, species will create new species by doing what's known as crossover(please refer: https://en.wikipedia.org/wiki/Chromosomal_crossover).

###Mutation and new generation
There will be random mutation to the species. Once crossover and random mutation is over, it will create next generation.

###Completion
The program will repeat above steps untill species in a population are close enough to the goal string.
