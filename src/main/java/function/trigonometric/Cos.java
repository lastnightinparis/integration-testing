package function.trigonometric;

import function.Function;
import function.utils.FunctionUtils;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Cos implements Function<Double, Double> {

    @Override
    public Double apply(Double x, Double eps) {
        if (x.isInfinite() || x.isNaN()) {
            return Double.NaN;
        }

        x = FunctionUtils.normalize(x);

        int cnt = 1;
        double result = 0;
        double term;
        do {
            term = nextTerm(cnt, x);
            result += term;
            cnt++;

        } while (Double.compare(Math.abs(term), eps) >= 0);

        return 1 - result;
    }

    private Double nextTerm(int n, double v) {
        int factorial = FunctionUtils.factorial(2 * n);
        double pow = Math.pow(v, 2 * n);

        if (n % 2 == 0) {
            factorial = -factorial;
        }

        return pow / factorial;
    }
}
