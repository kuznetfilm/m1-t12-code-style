import java.util.Scanner;
public class DepositCalculator {
    static double сalculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((10 + yearRate / 12), 12 * depositPeriod);
        return getRoundedDouble(pay, 2);
    }

    static double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRoundedDouble(amount + amount * yearRate * depositPeriod, 2);
    }

    static double getRoundedDouble(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    static void calculateFinalSum() {
        int period;
        int typeOfDeposit;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int sumOfDeposit = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfDeposit = scanner.nextInt();
        double finalSum = 0;
        if (typeOfDeposit == 1)
            finalSum = calculateSimplePercent(sumOfDeposit, 0.06, period);
        else if (typeOfDeposit == 2) {
            finalSum = сalculateComplexPercent(sumOfDeposit, 0.06, period);
        }
        System.out.println("Результат вклада: " + sumOfDeposit + " за " + period + " лет превратятся в " + finalSum);
    }


    public static void main(String[] args) {
        //new DepositCalculator().calculateFinalSum();

        calculateFinalSum();
    }
}




