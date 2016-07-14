package pets.cute.app.com.taixiu.manager;

import android.util.Log;

import java.util.ArrayList;

import pets.cute.app.com.taixiu.modules.Co;
import pets.cute.app.com.taixiu.modules.D.D;
import pets.cute.app.com.taixiu.modules.TX.TX;
import pets.cute.app.com.taixiu.modules.TX.Tai;
import pets.cute.app.com.taixiu.modules.TX.Xiu;
import pets.cute.app.com.taixiu.modules.XS.XS;

/**
 * Created by Forev on 6/28/2016.
 */
public class CosManager {
    private static final String TAG = "CosManager";
    static CosManager instance;

    public static CosManager getInstance() {
        if (instance == null)
            instance = new CosManager();
        return instance;
    }

    ArrayList<Co> cos = new ArrayList<>();

    public void append(Co c) {
        if (cos.contains(c)) {
            int index = cos.indexOf(c);
            int diff = c.getMoneyCuoc() - cos.get(index).getMoneyCuoc();
            cos.get(index).setMoneyCuoc(c.getMoneyCuoc());
            MoneyManager.getInstance().subtract(diff);
        } else {
            cos.add(c);
            MoneyManager.getInstance().subtract(c.getMoneyCuoc());
        }
    }

    public void displayAll() {
        for (Co c : cos) {
        }
    }

    public void cleanAll() {
        cos.clear();
    }

    public int tinhTien(XS xs1, XS xs2, XS xs3) {
        int tong = 0;
        for (int i = 0; i < cos.size(); i++) {
            if (cos.get(i) instanceof TX && taiXiu(xs1, xs2, xs3) != -1) {
                if (taiXiu(xs1, xs2, xs3) == 1 && cos.get(0) instanceof Tai) {
                    int money = cos.get(i).getMoneyCuoc() * 2;
                    tong += money;
                }

                if (taiXiu(xs1, xs2, xs3) == 0 && cos.get(0) instanceof Xiu) {
                    int money = cos.get(i).getMoneyCuoc() * 2;
                    tong += money;
                }
            }

            if (cos.get(i) instanceof XS) {
                boolean isChoose = false;
                XS xs = (XS) cos.get(i);
                if (xs.getDiem() == xs1.getDiem()) {
                    isChoose = true;
                } else if (xs.getDiem() == xs2.getDiem()) {
                    isChoose = true;
                } else if (xs.getDiem() == xs3.getDiem()) {
                    isChoose = true;
                }

                if (isChoose) {
                    int money = cos.get(i).getMoneyCuoc() * 2;
                    tong += money;
                }
            }

            if (cos.get(i) instanceof D) {
                int total = xs1.getDiem() + xs2.getDiem() + xs3.getDiem();
                D d = (D) cos.get(i);
                Log.d(TAG, "Total: " + total);
                Log.d(TAG, "Title: " + d.getTile());
                if (d.getTile() == total) {
                    int money = cos.get(i).getMoneyCuoc() * d.getTile();
                    tong += money;
                    Log.d(TAG, "Trung: " + money);
                }
            }


        }
        return tong;
    }


    //Kiem tra tai xiu
    public int taiXiu(XS xs1, XS xs2, XS xs3) {
        if (xs1.getDiem() == xs2.getDiem() && xs2.getDiem() == xs3.getDiem())
            return -1;

        int sumPoint = xs1.getDiem() + xs2.getDiem() + xs3.getDiem();

        if (sumPoint > 10)
            return 1;
        else
            return 0;
    }
}
