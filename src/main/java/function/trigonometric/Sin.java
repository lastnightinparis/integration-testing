package function.trigonometric;

import function.utils.FunctionUtils;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sin implements Function<Double, Double> {

    private int iterations;

    @Override
    public Double apply(Double x) {
        if (x.isInfinite() || x.isNaN()) {
            return Double.NaN;
        }

        x = FunctionUtils.normalize(x);

        double result = 0;

        for (int i = 1; i <= iterations; i++) {
            result += Math.pow(-1, (double) i - 1) * (Math.pow(x, (2 * i - 1))) / FunctionUtils.factorial(2 * i - 1);
        }

        return result;
    }
}
