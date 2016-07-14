package pets.cute.app.com.taixiu.modules.D;

import pets.cute.app.com.taixiu.modules.Co;

/**
 * Created by Forev on 6/28/2016.
 */
public abstract class D extends Co {

    @Override
    public int getMoneyCuoc() {
        return super.getMoneyCuoc();
    }

    @Override
    public void setCuoc(boolean cuoc) {
        super.setCuoc(cuoc);
    }

    @Override
    public boolean isCuoc() {
        return super.isCuoc();
    }

    @Override
    public void setMoneyCuoc(int moneyCuoc) {
        super.setMoneyCuoc(moneyCuoc);
    }


    public abstract int getTile();

    @Override
    public boolean equals(Object val) {
        if(!(val instanceof D))
            return false;
        D d = (D) val;
        return d.getClass() == this.getClass();
    }

    public static class Builder
    {
        public static D Builder(int val)
        {
            switch (val)
            {
                case 4:
                return new D4();
                case 5:
                    return new D5();
                case 6:
                    return new D6();
                case 7:
                    return new D7();
                case 8:
                    return new D8();
                case 9:
                    return new D9();
                case 10:
                    return new D10();
                case 11:
                    return new D11();
                case 12:
                    return new D12();
                case 13:
                    return new D13();
                case 14:
                    return new D14();
                case 15:
                    return new D15();
                case 16:
                    return new D16();
                case 17:
                    return new D17();
                default:
                    return new D17();
            }
        }
    }
}
