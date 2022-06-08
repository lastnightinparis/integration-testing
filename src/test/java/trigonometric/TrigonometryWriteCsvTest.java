package trigonometric;

import static org.junit.jupiter.api.Assertions.assertEquals;

import function.trigonometric.Cos;
import function.trigonometric.Sin;
import function.trigonometric.Tan;
import function.utils.CsvPrinter;
import java.io.IOException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TrigonometryWriteCsvTest {
    private final Double EPS = 0.1;
    private final Sin sin = new Sin();
    private final Cos cos = new Cos();
    private final Tan tan = new Tan(sin, cos);
    private final CsvPrinter csvPrinter = new CsvPrinter();

    @ParameterizedTest
    @CsvFileSource(resources = "/trigMocks/cos.csv")
    public void testCosApply(Double x, Double expected) throws IOException {
        Double result = cos.apply(x, EPS);
        csvPrinter.setFilepath("src/test/resources/out/cos.csv");
        csvPrinter.print(x, result);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigMocks/sin.csv")
    public void testSinApply(Double x, Double expected) throws IOException {
        Double result = sin.apply(x, EPS);
        csvPrinter.setFilepath("src/test/resources/out/sin.csv");
        csvPrinter.print(x, result);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigMocks/tan.csv")
    public void testTanApply(Double x, Double expected) throws IOException {
        Double result = tan.apply(x, EPS);
        csvPrinter.setFilepath("src/test/resources/out/tan.csv");
        csvPrinter.print(x, result);
        assertEquals(expected, result, EPS);
    }
}
