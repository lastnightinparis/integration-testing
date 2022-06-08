package function.logarithmic;

import function.Function;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Log2 implements Function<Double, Double> {

    private Ln ln;

    @Override
    public Double apply(Double x, Double eps) {
        if (x.isInfinite() || x.isNaN() || Double.compare(x, 0.) < 0) {
            return Double.NaN;
        }

        return ln.apply(x, eps) / ln.apply(2D, eps);
    }
}
