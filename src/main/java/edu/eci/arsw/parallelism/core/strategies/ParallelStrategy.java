package edu.eci.arsw.parallelism.core.strategies;

public interface ParallelStrategy {

    String calculate(int start, int count, int threads);

    String name();
}
