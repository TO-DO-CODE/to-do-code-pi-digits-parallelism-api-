package edu.eci.arsw.parallelism.core;

import edu.eci.arsw.parallelism.core.strategies.ParallelStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PiDigitsService {

    private final Map<String, ParallelStrategy> strategies;

    public PiDigitsService(List<ParallelStrategy> strategyList) {
        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(ParallelStrategy::name, Function.identity()));
    }

    public String calculate(int start, int count, int threads, String strategyName) {
        ParallelStrategy strategy = strategies.get(strategyName);
        
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown strategy: " + strategyName);
        }

        return strategy.calculate(start, count, threads);
    }
}
