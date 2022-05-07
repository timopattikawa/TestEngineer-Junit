package pajak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;



class SistemPajakTest {

    static  SistemPajak sistemPajak;

    @BeforeAll
    static void init() {
        System.out.println("Start Test");
        sistemPajak = new SistemPajak();
    }

    private static Stream<Arguments> provideSalary() {
        return Stream.of(
                Arguments.of(0, 3500000),
                Arguments.of(10, 5500000),
                Arguments.of(22, 31500000),
                Arguments.of(40f, 71800000),
                Arguments.of(-1, -3500000)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSalary")
    public void parameterizedTestPajakBYSalary(double expected, double salary) {
        Assertions.assertEquals(expected, sistemPajak.getPajak(salary));
    }

    private static Stream<Arguments> provideBVASalary() {
        return Stream.of(
                Arguments.of(true, 39999999),
                Arguments.of(true, 40000000),
                Arguments.of(false, 40000001)
        );
    }

    @ParameterizedTest
    @MethodSource("provideBVASalary")
    public void parameterizedTestBVAPajakBYSalary(boolean expected, double salary) {
        Assertions.assertNotNull(sistemPajak);
        Assertions.assertEquals(expected, sistemPajak.getPajak(salary) == 22);
    }

}