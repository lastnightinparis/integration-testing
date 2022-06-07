package function.utils;

import java.util.stream.IntStream;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FunctionUtils {
    public static int factorial(int x) {
        return IntStream.rangeClosed(2, x).reduce(1, (z, y) -> z * y);
    }

    public static Double normalize(Double x) {
        while (Double.compare(x, -2 * Math.PI) < 0)
            x += 2 * Math.PI;

        while (Double.compare(x, 2 * Math.PI) > 0)
            x -= 2 * Math.PI;

        return x;
    }
}
