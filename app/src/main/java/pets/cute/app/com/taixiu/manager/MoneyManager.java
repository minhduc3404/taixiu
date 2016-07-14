package pets.cute.app.com.taixiu.manager;

/**
 * Created by Forev on 6/28/2016.
 */
public class MoneyManager {
    public static MoneyManager getInstance() {
        if (sharedInstance == null) {
            sharedInstance = new MoneyManager();
        }
        return sharedInstance;
    }

    private static MoneyManager sharedInstance;

    //Tong so tien co
    long moneyTotal = 100;

    public long getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(int moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    //mat di
    public void subtract(long val) {
        moneyTotal -= val;
        if (moneyTotal < 0)
            moneyTotal = 0;

        if (moneyChangedListener != null)
            moneyChangedListener.onChanged(moneyTotal);
    }

    //nhan vao
    public void plusMoney(int val) {
        moneyTotal += val;
        if (moneyChangedListener != null)
            moneyChangedListener.onChanged(moneyTotal);
    }

    public void setMoneyChangedListener(MoneyChangedListener moneyChangedListener) {
        this.moneyChangedListener = moneyChangedListener;
    }

    MoneyChangedListener moneyChangedListener;

   public interface MoneyChangedListener {
        void onChanged(long money);
    }
}
