package function.logarithmic;

import function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Ln implements Function<Double, Double> {

    @Override
    public Double apply(Double x, Double eps) {
        if (x.isInfinite() || x.isNaN() || Double.compare(x, 0.) < 0) {
            return Double.NaN;
        }

        double result = 0;
        int cnt = 1;
        double term;

        do {
            term = nextTerm(cnt, x);
            result += term;
            cnt++;
        } while (Double.compare(Math.abs(term), eps) >= 0);
        return 2 * result;
    }

    private double nextTerm(int n, double v) {
        double divisor = 2L * n - 1;
        double dividend = Math.pow((v - 1) / (v + 1), 2 * n - 1);
        return dividend / divisor;
    }
}
