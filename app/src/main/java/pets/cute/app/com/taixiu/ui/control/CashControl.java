package pets.cute.app.com.taixiu.ui.control;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pets.cute.app.com.taixiu.R;
import pets.cute.app.com.taixiu.adapter.CashAdapter;

/**
 * Created by Forev on 6/29/2016.
 */
public class CashControl extends FrameLayout {
    private static final String TAG = "CashControl";
    View root;
    RelativeLayout ll_container;
    FrameLayout ll_money;
    TextView tv_money;
    CashAdapter adapter;

    public CashControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        root = LayoutInflater.from(context).inflate(R.layout.cash_layout, this, true);
        ll_container = (RelativeLayout) root.findViewById(R.id.ll_container);
        ll_money = (FrameLayout) root.findViewById(R.id.ll_money);
        tv_money = (TextView) root.findViewById(R.id.tv_money);
    }

    public CashControl(Context context) {
        super(context);
        root = LayoutInflater.from(context).inflate(R.layout.cash_layout, this, true);
        ll_container = (RelativeLayout) root.findViewById(R.id.ll_container);
    }

    public void setAdapter(CashAdapter adapter) {
        this.adapter = adapter;
        ll_container.removeAllViews();
        if (adapter != null)
            setUpView();
        else {
            ll_money.setVisibility(GONE);
        }
    }

    private void setUpView() {
        //before clean all view inside
        for (int i = 0; i < adapter.getCount(); i++) {
            final View child = adapter.getView(i, null, ll_container);
            RelativeLayout.MarginLayoutParams p = (MarginLayoutParams) child.getLayoutParams();
            p.setMargins(0, (adapter.getCount() - 1 - i) * 7, 0, 0);
            child.requestLayout();
            ll_container.addView(child);
            ll_container.requestLayout();
        }

        setUpMoney();
      /*  int height = adapter.getView(0,null,ll_container).getHeight() * adapter.getCount();
        int width = adapter.getView(0,null,ll_container).getWidth();
        ll_container.setMinimumHeight(height);
        ll_container.setMinimumWidth(width);

        ll_container.invalidate();
        root.invalidate();*/
    }

    private void setUpMoney() {
        int money = adapter.getMoney();
        Log.d(TAG, "money cash: " + money);
        if (money > 0) {
            tv_money.setText("$" + money);
            ll_money.setVisibility(VISIBLE);
        } else {
            ll_money.setVisibility(GONE);
        }
    }
}
