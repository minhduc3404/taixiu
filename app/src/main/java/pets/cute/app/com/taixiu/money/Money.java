package pets.cute.app.com.taixiu.money;

/**
 * Created by Forev on 6/29/2016.
 */
public abstract class Money {
    protected int sodu = 0;
    protected int count = 0;

    public abstract int idChip();

    public void calc(int m) {
        count = m / getPrice();
        sodu = m % getPrice();
    }

    public int getCount() {
        return count;
    }

    public int getSodu() {
        return sodu;
    }

    public abstract int getPrice();
}
