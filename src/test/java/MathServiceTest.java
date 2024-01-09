import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.gb.MathService;
import ru.gb.NotFoundAnswerException;

import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest {
    private MathService mathService;

    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @Test
    public void discriminantLessThanZeroTest(){
        NotFoundAnswerException exept = assertThrows(NotFoundAnswerException.class, () ->
                mathService.getAnswer(2,6, 25));
        assertEquals("Корни не могут быть найдены", exept.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"2, 4, 2, -1, -1",
            "2, -7, 5, 2.5, 1.0",
            "3, 16, 5, -0.4, -6.0",
            "2, 7, 5, -1.0, -2.5"})
    public void squareRootTest(int a, int b, int c, double x1, double x2) throws NotFoundAnswerException {
        assertEquals("Answer{first="+x1+", second="+x2+"}", mathService.getAnswer(a,b,c).toString());

    }

    @ParameterizedTest
    @CsvSource({"3, 16, 5, 196",
            "2, 7, 5, 9",
            "2, -7, 5, 9"})
    public void discriminantTest(int a, int b, int c, int d){
        assertEquals(mathService.getD(a,b,c), d);

    }

    @Test
    public void divByZeroTest(){
        assertThrows(ArithmeticException.class, () -> mathService.getAnswer(0,0, 1));
    }
}
