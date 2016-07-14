package pets.cute.app.com.taixiu.money;

import pets.cute.app.com.taixiu.R;

/**
 * Created by Forev on 6/29/2016.
 */
public class FiveM extends Money {
    @Override
    public int getPrice() {
        return 5;
    }

    @Override
    public int idChip() {
        return R.drawable.chip5;
    }
}
