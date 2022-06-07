package function.system;

import function.Function;
import function.logarithmic.Ln;
import function.logarithmic.Log2;
import function.logarithmic.Log3;
import function.logarithmic.Log5;
import function.trigonometric.Cos;
import function.trigonometric.Sin;
import function.trigonometric.Tan;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FunctionSystem implements Function<Double, Double> {

    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Ln ln;
    private Log5 log5;
    private Log3 log3;
    private Log2 log2;

    @Override
    public Double apply(Double x, Double eps) {
        if (x.isInfinite() || x.isNaN()) {
            return Double.NaN;
        }

        if (x.compareTo(0.) <= 0) {
            return tan.apply(x, eps);
        } else {
            return ((Math.pow((log5.apply(x, eps) / log5.apply(x, eps)) - log2.apply(x, eps), 2)) * (ln.apply(x, eps) / log5.apply(x, eps)))
                    + (ln.apply(x, eps) / (((log5.apply(x, eps) / log2.apply(x, eps)) + log3.apply(x, eps))));
        }
    }
}
