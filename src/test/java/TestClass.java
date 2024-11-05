import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestClass {

  @Test
  @DisplayName("Проверка на неотрицательность.")
  void testFactorialPositive() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> Main.calculateFactorial(-1));
    assertEquals("Введите целое неотрицательное число.", exception.getMessage());
  }

  @Test
  @DisplayName("Вычисление значения факторила числа.")
  void testFactorialCalculations() {
    assertAll("Factorial calculations",
        () -> assertEquals(1, Main.calculateFactorial(0), "Факторил 0 равен 1."),
        () -> assertEquals(1, Main.calculateFactorial(1), "Факторил 1 равен 1."),
        () -> assertEquals(120, Main.calculateFactorial(5), "Факторил 1 равен 120.")
    );
  }
}
