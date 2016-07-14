package pets.cute.app.com.taixiu.modules.Cash;

import pets.cute.app.com.taixiu.R;

/**
 * Created by Forev on 7/1/2016.
 */
public class FiftyCash extends Cash {
    @Override
    public int getValue() {
        return 50;
    }

    @Override
    public int getImage() {
        return R.drawable.chip50;
    }
}
