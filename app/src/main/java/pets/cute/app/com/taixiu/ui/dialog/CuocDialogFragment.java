package pets.cute.app.com.taixiu.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import pets.cute.app.com.taixiu.R;
import pets.cute.app.com.taixiu.manager.MoneyManager;

/**
 * Created by Forev on 6/25/2016.
 */
public class CuocDialogFragment extends DialogFragment implements View.OnClickListener {
    private static final String TAG = "CuocDialogFragment";
    @InjectView(R.id.text)
    TextView text;

    @InjectView(R.id.btn00)
    Button btn00;
    @InjectView(R.id.btn0)
    Button btn0;
    @InjectView(R.id.btn1)
    Button btn1;
    @InjectView(R.id.btn2)
    Button btn2;
    @InjectView(R.id.btn3)
    Button btn3;
    @InjectView(R.id.btn4)
    Button btn4;
    @InjectView(R.id.btn5)
    Button btn5;
    @InjectView(R.id.btn6)
    Button btn6;
    @InjectView(R.id.btn7)
    Button btn7;
    @InjectView(R.id.btn8)
    Button btn8;
    @InjectView(R.id.btn9)
    Button btn9;

    @InjectView(R.id.ivPhoto1)
    ImageView imagePhoto1;
    @InjectView(R.id.ivPhoto2)
    ImageView imagePhoto2;


    String kq = "0";

    public void setKq(String kq) {
        this.kq = kq;
        text.setText(kq);
    }

    public static final String ARG_IMAGEID = "ARG_IMAGEID";

    public static CuocDialogFragment newInstance(int imageId) {

        Bundle args = new Bundle();
        args.putInt(ARG_IMAGEID, imageId);
        CuocDialogFragment fragment = new CuocDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cuoc_dialog_fragment2, container, false);
        ButterKnife.inject(this, root);
        Bundle bundle = getArguments();
        imagePhoto1.setImageResource(bundle.getInt(ARG_IMAGEID));
        imagePhoto2.setImageResource(bundle.getInt(ARG_IMAGEID));
        setButtonListenner();
        return root;
    }

    private void setButtonListenner() {
        btn00.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    @OnClick(R.id.btnDel)
    public void delClick(View sender) {
        this.setKq("0");
    }

    @OnClick(R.id.btnMax)
    public void maxClick(View sender) {
        this.setKq(MoneyManager.getInstance().getMoneyTotal() + "");
    }

    public void onClick(View view) {
        String value = (String) ((Button) view).getText();
        inputValues(value);
    }

    private void inputValues(String value) {
        if (kq.equals("0")) {
            if (Integer.parseInt(value) > MoneyManager.getInstance().getMoneyTotal()) {
                setKq(MoneyManager.getInstance().getMoneyTotal() + "");
            }else{
                if (!value.equals("0") && !value.equals("00")) {
                    Log.d(TAG, value);
                    setKq(value);
                }
            }
        } else {

            String tmp = String.copyValueOf(kq.toCharArray());
            tmp += value;
            if (Integer.parseInt(tmp) <= MoneyManager.getInstance().getMoneyTotal())
                setKq(tmp);
            else
                setKq(MoneyManager.getInstance().getMoneyTotal() + "");


        }
    }

    @OnClick(R.id.cancel)
    public void cancelClick(View view) {
        dismiss();
    }

    @OnClick(R.id.confirm)
    public void confirmClick(View view) {
        if (this.event != null) {
            event.onConfirm(text.getText().toString());
        }
        dismiss();
    }

    CuocEventListener event;

    public void setEventListener(CuocEventListener event) {
        this.event = event;
    }

    public interface CuocEventListener {
        void onConfirm(String money);
    }
}
