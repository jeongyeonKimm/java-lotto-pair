package lotto;

public enum Winnings {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(6, 30000000),
    SIX(7, 2000000000);

    private int index;
    private int money;

    Winnings(int correctCount, int money) {
        this.index = correctCount;
        this.money = money;
    }

    public int getIndex() {
        return index;
    }

    public static int getMoney(int correctCount) {
        for (Winnings value : Winnings.values()) {
            if (value.getIndex() == correctCount) {
                return value.money;
            }
        }

        return 0;
    }
}
