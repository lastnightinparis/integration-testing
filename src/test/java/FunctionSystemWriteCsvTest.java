import static org.junit.jupiter.api.Assertions.assertEquals;

import function.logarithmic.Ln;
import function.logarithmic.Log2;
import function.logarithmic.Log3;
import function.logarithmic.Log5;
import function.system.FunctionSystem;
import function.trigonometric.Cos;
import function.trigonometric.Sin;
import function.trigonometric.Tan;
import function.utils.CsvPrinter;
import java.io.IOException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class FunctionSystemWriteCsvTest {
    private final Double EPS = 0.01;
    private final Sin sin = new Sin();
    private final Cos cos = new Cos();
    private final Tan tan = new Tan(sin, cos);
    private final Ln ln = new Ln();
    private final Log2 log2 = new Log2(ln);
    private final Log3 log3 = new Log3(ln);
    private final Log5 log5 = new Log5(ln);
    private final FunctionSystem functionSystem = new FunctionSystem(tan, ln, log2, log3, log5);
    private final CsvPrinter csvPrinter = new CsvPrinter();

    @ParameterizedTest
    @CsvFileSource(resources = "/functionSystem.csv")
    public void testApplyFunctionSystem(Double x, Double expected) throws IOException {
        Double result = functionSystem.apply(x, EPS);
        csvPrinter.setFilepath("src/test/resources/out/functionSystem.csv");
        csvPrinter.print(x, result);
        assertEquals(expected, result, EPS);
    }
}
