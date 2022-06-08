import static org.junit.jupiter.api.Assertions.assertEquals;

import com.opencsv.exceptions.CsvException;
import function.logarithmic.Ln;
import function.logarithmic.Log2;
import function.logarithmic.Log3;
import function.logarithmic.Log5;
import function.system.FunctionSystem;
import function.trigonometric.Cos;
import function.trigonometric.Sin;
import function.trigonometric.Tan;
import java.io.IOException;
import logarithmic.LogarithmStubs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigonometric.TrigonometryStubs;

@DisplayName("Function system test")
public class FunctionSystemTest {

    private static final Double EPS = 0.01;

    @ParameterizedTest
    @CsvFileSource(resources = "/functionSystem.csv")
    public void testApplyAllMocks(Double x, Double expected) throws IOException, CsvException {
        LogarithmStubs.setUp();
        TrigonometryStubs.setUp();
        FunctionSystem functionSystem = new FunctionSystem(TrigonometryStubs.tan, LogarithmStubs.ln,
                LogarithmStubs.log2, LogarithmStubs.log3, LogarithmStubs.log5);

        Double result = functionSystem.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functionSystem.csv")
    public void testApplyTrigonometricMocks(Double x, Double expected) throws IOException, CsvException {
        TrigonometryStubs.setUp();
        FunctionSystem functionSystem = new FunctionSystem(TrigonometryStubs.tan, new Ln(),
                new Log2(new Ln()), new Log3(new Ln()), new Log5(new Ln()));

        Double result = functionSystem.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functionSystem.csv")
    public void testApplyLogarithmicMocks(Double x, Double expected) throws IOException, CsvException {
        LogarithmStubs.setUp();
        FunctionSystem functionSystem = new FunctionSystem(new Tan(new Sin(), new Cos()), LogarithmStubs.ln,
                LogarithmStubs.log2, LogarithmStubs.log3, LogarithmStubs.log5);

        Double result = functionSystem.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functionSystem.csv")
    public void testApplyNoneMocks(Double x, Double expected) {
        FunctionSystem functionSystem = new FunctionSystem(new Tan(new Sin(), new Cos()), new Ln(),
                new Log2(new Ln()), new Log3(new Ln()), new Log5(new Ln()));

        Double result = functionSystem.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }
}
