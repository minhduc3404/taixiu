package pets.cute.app.com.taixiu.modules.Cash;

import android.util.Log;

/**
 * Created by Forev on 7/1/2016.
 */
public abstract class Cash {
    private static final String TAG = "Cash money";
    protected int sodu = 0;
    protected int count = 0;

    public int getCount() {
        return count;
    }

    public int getSodu() {
        return sodu;
    }

    public abstract int getValue();

    public abstract int getImage();

    public int getMoney() {
        Log.d(TAG, "Cash money: " + count + ":" + sodu);
        return getValue() * count + sodu;
    }

    public void calc(int m) {
        count = m / getValue();
        sodu = m % getValue();
        Log.d(TAG, "sodu: " + sodu);
        Log.d(TAG, "count: " + count);
    }

    public static class Builder {
        public static Cash builder(int val) {
            Cash cash = null;
            if (val == 1) cash = new OneCash();
            else if (val == 2) cash = new TwoCash();
            else if (val == 5) cash = new FiveCash();
            else if (val == 10) cash = new TenCash();
            else if (val == 20) cash = new TwentyCash();
            else if (val == 50) cash = new FiftyCash();
            else if (val == 100) cash = new OneHundredCash();
            else if (val == 200) cash = new TwoHundredCash();
            else if (val == 500) cash = new FiveHundredCash();
            return cash;
        }
    }

    public static class Converter {
        Cash[] moneyType = {new FiveHundredCash(), new TwoHundredCash(), new OneHundredCash(), new FiftyCash(), new TwentyCash(), new TenCash(), new FiveCash(), new TwoCash(), new OneCash()};

        public Converter(int m) {
            int moneyRest = m;
            for (int i = 0; i < moneyType.length; i++) {
                moneyType[i].calc(moneyRest);
                if(moneyType[i].sodu == 0)
                    return;
                if (moneyRest != moneyType[i].sodu) {
                    moneyRest = moneyType[i].sodu;
                    if (moneyRest == 0)
                        return;
                    if(!(moneyType[i] instanceof OneCash))
                    {
                        moneyType[i].sodu = 0;
                    }
                } else {
                    moneyType[i].sodu = 0;
                }
            }
        }

        public Cash[] getMoneys() {
            return moneyType;
        }
    }
}
