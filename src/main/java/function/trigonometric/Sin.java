package function.trigonometric;

import function.Function;
import function.utils.FunctionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sin implements Function<Double, Double> {

    @Override
    public Double apply(Double x, Double eps) {
        if (x.isInfinite() || x.isNaN()) {
            return Double.NaN;
        }

        x = FunctionUtils.normalize(x);

        int cnt = 0;
        double result = 0;
        double term;
        do {
            term = nextTerm(cnt, x);
            result += term;
            cnt++;

        } while (Double.compare(Math.abs(term), eps) >= 0);

        return result;
    }

    private Double nextTerm(int n, double v) {
        int factorial = FunctionUtils.factorial(n * 2 + 1);
        double pow = Math.pow(v, 2 * n + 1);

        if (n % 2 != 0) {
            factorial = -factorial;
        }

        return pow / factorial;
    }

}
