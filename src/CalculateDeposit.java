import java.util.Scanner;

public class CalculateDeposit {

    double calculateComplexPercentFunction(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) {
        double value = amount + (amount * yearRate * depositPeriod);
        return round(value, 2);
    }

    double round(double value, int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }

    void doImportantJob() {
        int period;
        int action;

        var scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double resultPercent = 0;

        switch (action) {
            case 1 -> resultPercent = calculateSimplePercentFunction(amount, 0.06, period);
            case 2 -> resultPercent = calculateComplexPercentFunction(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultPercent);
    }

    public static void main(String[] args) {
        new CalculateDeposit().doImportantJob();
    }
}
