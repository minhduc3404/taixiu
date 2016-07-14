package pets.cute.app.com.taixiu.modules;

/**
 * Created by Forev on 6/28/2016.
 */
public class Co {
    int moneyCuoc = 0;
    boolean isCuoc = false;

    public int getMoneyCuoc() {
        return moneyCuoc;
    }

    public boolean isCuoc() {
        return isCuoc;
    }

    public void setCuoc(boolean cuoc) {
        isCuoc = cuoc;
    }

    public void setMoneyCuoc(int moneyCuoc) {
        this.moneyCuoc = moneyCuoc;
    }

    @Override
    public boolean equals(Object val) {
        if (val.getClass() == this.getClass()) return true;
        return false;
    }
}
