package pets.cute.app.com.taixiu.modules.XS;

import pets.cute.app.com.taixiu.modules.Co;

/**
 * Created by Forev on 6/28/2016.
 */
public abstract class XS extends Co {

    public abstract int getDiem();
    public abstract int getFlag();

    public static class Builder {
        public static XS Builder(int val) {
            switch (val) {
                case 1:
                    return new XS1();
                case 2:
                    return new XS2();
                case 3:
                    return new XS3();
                case 4:
                    return new XS4();
                case 5:
                    return new XS5();
                case 6:
                    return new XS6();
                default:
                    return null;
            }

        }
    }
}
