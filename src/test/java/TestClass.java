import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import org.example.Main;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass {
  @Test(description = "Проверка на неотрицательность.")
  void testFactorialPositive() {
    IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> Main.calculateFactorial(-1));
    assertEquals(exception.getMessage(), "Введите целое неотрицательное число.");
  }

  @DataProvider
  public Object[][] data() {
    return new Object[][] {
        {0, 1},
        {1, 1},
        {5, 120}
    };
  }

  @Test(description = "Вычисление значения факториала числа.", dependsOnMethods = {"testFactorialPositive"}, dataProvider = "data")
  public void testFactorialCalculations(Integer a, Integer b) {
    Assert.assertEquals(Main.calculateFactorial(a), b, "Факториал вычеслен неверно");
  }
}
