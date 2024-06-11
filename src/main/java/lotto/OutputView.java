package lotto;

public class OutputView {

    private static final String STATISTIC_MESSAGE = "당첨 통계";
    private static final String LINE_MESSAGE = "----------";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(int count, String message) {
        System.out.println(count + message);
    }

    public static void printStatistics(int[] arrCount, int purchasePrice) {
        System.out.println(STATISTIC_MESSAGE);
        System.out.println(LINE_MESSAGE);

        double winnings = 0;
        for (int i = 3; i <= 7; i++) {
            winnings = checkMoney(arrCount, winnings, i);

            if (checkGreaterThanSix(arrCount, i))
                continue;

            System.out.println(i + "개 일치 - " + arrCount[i]);
        }

        double profit = calculateProfit(purchasePrice, winnings);
        System.out.printf("총 수익률은 %.2f 입니다.", profit);
    }

    private static double calculateProfit(int purchasePrice, double winnings) {
        return winnings / purchasePrice;
    }

    private static double checkMoney(int[] arrCount, double winnings, int i) {
        if (arrCount[i] > 0) {
            winnings += Winnings.getMoney(i);
        }
        return winnings;
    }

    private static boolean checkGreaterThanSix(int[] arrCount, int index) {
        if (index == 6) {
            System.out.println((index - 1) + "개 일치, 보너스 볼 일치 - " + arrCount[index]);
            return true;
        }

        if (index == 7) {
            System.out.println((index - 1) + "개 일치 - " + arrCount[index]);
            return true;
        }

        return false;
    }
}
