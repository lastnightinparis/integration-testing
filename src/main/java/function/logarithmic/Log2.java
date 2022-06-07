package function.logarithmic;

import java.util.function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Log2 implements Function<Double, Double> {

    private Ln ln;

    @Override
    public Double apply(Double x) {

        if (x.isInfinite() || x.isNaN()) {
            return Double.NaN;
        }

        return ln.apply(x) / ln.apply(2D);
    }
}
