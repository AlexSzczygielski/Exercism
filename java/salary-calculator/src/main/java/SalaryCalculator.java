public class SalaryCalculator {
  private static final double ABSENCE_PENALTY = 0.85;
  private static final int ABSENCE_DAYS_THRESHOLD = 5;
  private static final double BASE_SALARY_COEFF = 1.0;
  private static final int MONETARY_UNITS_BASE_PRODUCT_SOLD = 10;
  private static final int MONETARY_UNITS_BONUS_PRODUCT_SOLD = 13;
  private static final int QUANTITY_PRODUCTS_SOLD_FOR_BONUS = 20;
  private static final double BASE_SALARY = 1000.00;
  private static final double SALARY_CAP = 2000.00;

  public double salaryMultiplier(int daysSkipped) {
    return (daysSkipped >= ABSENCE_DAYS_THRESHOLD) ? ABSENCE_PENALTY : BASE_SALARY_COEFF;
  }

  public int bonusMultiplier(int productsSold) {
    return (productsSold >= QUANTITY_PRODUCTS_SOLD_FOR_BONUS) ? MONETARY_UNITS_BONUS_PRODUCT_SOLD
        : MONETARY_UNITS_BASE_PRODUCT_SOLD;
  }

  public double bonusForProductsSold(int productsSold) {
    return bonusMultiplier(productsSold) * productsSold;
  }

  public double finalSalary(int daysSkipped, int productsSold) {
    double calculatedSalary = BASE_SALARY * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);
    return Math.min(calculatedSalary, SALARY_CAP);
  }
}
