package edu.eci.arsw.parallelism.core.strategies;

import edu.eci.arsw.parallelism.core.PiDigits;
import org.springframework.stereotype.Component;

@Component
public class SequentialStrategy implements ParallelStrategy {

    @Override
    public String calculate(int start, int count, int threads) {
        return PiDigits.getDigitsHex(start, count);
    }

    @Override
    public String name() {
        return "sequential";
    }
}
