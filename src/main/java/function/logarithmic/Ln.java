package function.logarithmic;

import java.util.function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Ln implements Function<Double, Double> {

    private int iterations;

    @Override
    public Double apply(Double x) {
        if (x.isInfinite() || x.isNaN() || Double.compare(x, 0.) < 0) {
            return Double.NaN;
        }


        return null;
    }
}
