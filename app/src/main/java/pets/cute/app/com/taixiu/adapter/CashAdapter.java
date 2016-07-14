package pets.cute.app.com.taixiu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import pets.cute.app.com.taixiu.R;
import pets.cute.app.com.taixiu.modules.Cash.Cash;

/**
 * Created by Forev on 7/1/2016.
 */
public class CashAdapter extends ArrayAdapter {
    private static final String TAG = "CashAdapter";
    private final ArrayList<Cash> mData;
    Context mContext;

    public CashAdapter(Context context, int resource, ArrayList<Cash> data) {
        super(context, resource);
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cash_item_view, parent, false);
        Cash c = mData.get(position);
        ImageView img = (ImageView) view.findViewById(R.id.ivChip);
        img.setImageResource(c.getImage());
        Log.d(TAG,"Cash: " + c.getValue());
        return view;
    }

    public int getMoney()
    {
        int sum = 0;
        for (Cash cash:mData)
        {
            sum += cash.getMoney();
        }
        return sum;
    }

    @Override
    public int getCount() {
        if (mData == null)
            return 0;
        else return mData.size();
    }
}
