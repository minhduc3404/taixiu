package pets.cute.app.com.taixiu.money;

import java.util.ArrayList;

/**
 * Created by Forev on 6/29/2016.
 */
public class MoneyDevice {
    Money[] moneyType = {new FiveHundredM(), new TwoHundredM(), new OneHundredM(), new FiftyM(), new TwentyM(), new TenM(), new FiveM(), new TwoM(), new OneM()};

    public MoneyDevice(int m) {
        int moneyRest = m;
        for (int i = 0; i < moneyType.length; i++) {
            moneyType[i].calc(moneyRest);
            moneyRest = moneyType[i].getSodu();
            if (moneyRest == 0)
                return;
        }
    }

    public Money[] getMoneys() {
        return moneyType;
    }
}
