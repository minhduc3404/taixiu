package pets.cute.app.com.taixiu.manager;

/**
 * Created by Forev on 6/28/2016.
 */
public class CuocManager {
    private CuocManager instance;

    public CuocManager getInstance() {
        if (instance != null)
            instance = new CuocManager();
        return instance;
    }
}
