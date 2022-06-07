package function.trigonometric;

import function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Tan implements Function<Double, Double> {

    private Sin sin;
    private Cos cos;

    @Override
    public Double apply(Double x, Double eps) {

        if (x.isInfinite() || x.isNaN()) {
            return Double.NaN;
        }

        return sin.apply(x, eps) / cos.apply(x, eps);
    }
}
