package pets.cute.app.com.taixiu.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Random;

import pets.cute.app.com.taixiu.R;
import pets.cute.app.com.taixiu.adapter.CashAdapter;
import pets.cute.app.com.taixiu.device.InfoDevice;
import pets.cute.app.com.taixiu.manager.CosManager;
import pets.cute.app.com.taixiu.manager.MoneyManager;
import pets.cute.app.com.taixiu.manager.MusicManager;
import pets.cute.app.com.taixiu.modules.Cash.*;
import pets.cute.app.com.taixiu.modules.Co;
import pets.cute.app.com.taixiu.modules.D.D4;
import pets.cute.app.com.taixiu.modules.D.*;
import pets.cute.app.com.taixiu.modules.TX.Tai;
import pets.cute.app.com.taixiu.modules.TX.Xiu;
import pets.cute.app.com.taixiu.modules.XS.XS;
import pets.cute.app.com.taixiu.modules.XS.*;
import pets.cute.app.com.taixiu.network.ServiceAPI;
import pets.cute.app.com.taixiu.network.ServiceGenerator;
import pets.cute.app.com.taixiu.ui.control.CashControl;
import pets.cute.app.com.taixiu.ui.dialog.CuocDialogFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MoneyManager.MoneyChangedListener {
    private static final String TAG = "MainActivity";
    private static final String TAG_CASH_CONTROL = "TAG_CASH_CONTROL";

    ImageView ivXiu;
    ImageView ivTai;

    boolean isOpen = false;

    XS sx1, sx2, sx3;

    ImageView ivS4;
    ImageView ivS5;
    ImageView ivS6;
    ImageView ivS7;
    ImageView ivS8;
    ImageView ivS9;
    ImageView ivS10;
    ImageView ivS11;
    ImageView ivS12;
    ImageView ivS13;
    ImageView ivS14;
    ImageView ivS15;
    ImageView ivS16;
    ImageView ivS17;

    ImageView ivSS1;
    ImageView ivSS2;
    ImageView ivSS3;
    ImageView ivSS4;
    ImageView ivSS5;
    ImageView ivSS6;

    ImageView ivPlace;
    ImageView ivBowl;

    ImageView ivSx1;
    ImageView ivSx2;
    ImageView ivSx3;

    TextView tvScore;

    AdView adView;


    ArrayList<CashControl> cashControls = new ArrayList<>();

    //ServiceApi
    ServiceAPI serviceAPI = ServiceGenerator.createService(ServiceAPI.class, ServiceAPI.BASE_URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        configureScreen();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        setEventOnClick();

        //Soc xuc sac lan dau tien
        int result = randomDice();
        int total = sx1.getDiem() + sx2.getDiem() + sx3.getDiem();
        onPushData(result, total);

        setUpValues();

        setUpAds();
    }

    private void setUpView() {
        ivXiu = (ImageView) findViewById(R.id.ivXiu);
        ivTai = (ImageView) findViewById(R.id.ivTai);
        ivS4 = (ImageView) findViewById(R.id.ivS4);
        ivS5 = (ImageView) findViewById(R.id.ivS5);
        ivS6 = (ImageView) findViewById(R.id.ivS6);
        ivS7 = (ImageView) findViewById(R.id.ivS7);
        ivS8 = (ImageView) findViewById(R.id.ivS8);
        ivS9 = (ImageView) findViewById(R.id.ivS9);
        ivS10 = (ImageView) findViewById(R.id.ivS10);
        ivS11 = (ImageView) findViewById(R.id.ivS11);
        ivS12 = (ImageView) findViewById(R.id.ivS12);
        ivS13 = (ImageView) findViewById(R.id.ivS13);
        ivS14 = (ImageView) findViewById(R.id.ivS14);
        ivS15 = (ImageView) findViewById(R.id.ivS15);
        ivS16 = (ImageView) findViewById(R.id.ivS16);
        ivS17 = (ImageView) findViewById(R.id.ivS17);

        ivSS1 = (ImageView) findViewById(R.id.ivss1);
        ivSS2 = (ImageView) findViewById(R.id.ivss2);
        ivSS3 = (ImageView) findViewById(R.id.ivss3);
        ivSS4 = (ImageView) findViewById(R.id.ivss4);
        ivSS5 = (ImageView) findViewById(R.id.ivss5);
        ivSS6 = (ImageView) findViewById(R.id.ivss6);

        ivPlace = (ImageView) findViewById(R.id.place);
        ivBowl = (ImageView) findViewById(R.id.bowl);

        ivSx1 = (ImageView) findViewById(R.id.sx1);
        ivSx2 = (ImageView) findViewById(R.id.sx2);
        ivSx3 = (ImageView) findViewById(R.id.sx3);

        tvScore = (TextView) findViewById(R.id.tvScore);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null)
            adView.resume();

        MusicManager.getInstance(this).playMusic();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MusicManager.getInstance(this).stopMusic();
    }

    @Override
    protected void onDestroy() {
        if (adView != null)
            adView.destroy();
        super.onDestroy();
    }

    private void setUpAds() {

        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                //.addTestDevice("F9EC6EE47094EDFAB5EA1ABC76D1C902")
                .build();
        adView.loadAd(adRequest);
    }

    private void setUpValues() {
        tvScore.setText("$" + MoneyManager.getInstance().getMoneyTotal());
        MoneyManager.getInstance().setMoneyChangedListener(this);
    }

    //Event click cho cac nut
    private void setEventOnClick() {
        ivXiu.setOnClickListener(this);
        ivTai.setOnClickListener(this);
        ivS4.setOnClickListener(this);
        ivS5.setOnClickListener(this);
        ivS6.setOnClickListener(this);
        ivS7.setOnClickListener(this);
        ivS8.setOnClickListener(this);
        ivS9.setOnClickListener(this);
        ivS10.setOnClickListener(this);
        ivS11.setOnClickListener(this);
        ivS12.setOnClickListener(this);
        ivS13.setOnClickListener(this);
        ivS14.setOnClickListener(this);
        ivS15.setOnClickListener(this);
        ivS16.setOnClickListener(this);
        ivS17.setOnClickListener(this);

        ivSS1.setOnClickListener(this);
        ivSS2.setOnClickListener(this);
        ivSS3.setOnClickListener(this);
        ivSS4.setOnClickListener(this);
        ivSS5.setOnClickListener(this);
        ivSS6.setOnClickListener(this);
    }

    //Cau hinh man hinh ngang notitle
    private void configureScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE); //no using title
        // using fullscreen
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
    }

    CuocDialogFragment dlg;
    Co sxChoose;

    //Chon dat cuoc va dat so tien
    @Override
    public void onClick(final View v) {

        if (isOpen) {
            //Up dia roi dat cuoc
            Toast.makeText(MainActivity.this, "Vui long up dia truoc khi cuoc", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = v.getId();


        if (id == ivXiu.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_01);
            sxChoose = new Xiu();
        }

        if (id == ivTai.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_05);
            sxChoose = new Tai();
        }

        if (id == ivS4.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_10);
            sxChoose = new D4();
        }

        if (id == ivS5.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_11);
            sxChoose = new D5();
        }

        if (id == ivS6.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_12);
            sxChoose = new D6();
        }

        if (id == ivS7.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_13);
            sxChoose = new D7();
        }

        if (id == ivS8.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_14);
            sxChoose = new D8();
        }

        if (id == ivS9.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_15);
            sxChoose = new D9();
        }

        if (id == ivS10.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_16);
            sxChoose = new D10();
        }

        if (id == ivS11.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_23);
            sxChoose = new D11();
        }
        if (id == ivS12.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_22);
            sxChoose = new D12();
        }
        if (id == ivS13.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_21);
            sxChoose = new D13();
        }
        if (id == ivS14.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_20);
            sxChoose = new D14();
        }
        if (id == ivS15.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_19);
            sxChoose = new D15();
        }
        if (id == ivS16.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_18);
            sxChoose = new D16();
        }
        if (id == ivS17.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.bgrtaixiu_17);
            sxChoose = new D17();
        }

        ////
        if (id == ivSS1.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.dice1);
            sxChoose = new XS1();
        }

        if (id == ivSS2.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.dice2);
            sxChoose = new XS2();
        }

        if (id == ivSS3.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.dice3);
            sxChoose = new XS3();
        }

        if (id == ivSS4.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.dice4);
            sxChoose = new XS4();
        }

        if (id == ivSS5.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.dice5);
            sxChoose = new XS5();
        }

        if (id == ivSS6.getId()) {
            dlg = CuocDialogFragment.newInstance(R.drawable.dice6);
            sxChoose = new XS6();
        }

        dlg.setEventListener(new CuocDialogFragment.CuocEventListener() {
            @Override
            public void onConfirm(String money) {
                int moneyCuoc = Integer.parseInt(money);
                sxChoose.setMoneyCuoc(moneyCuoc);
                CosManager.getInstance().append(sxChoose);
                addMoneyView(v, moneyCuoc);
            }
        });


        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentByTag("fr_dialog_dat_cuoc");
        if (f != null) {
            fm.beginTransaction().remove(f);
        }
        if (dlg != null)
            dlg.show(fm, "fr_dialog_dat_cuoc");

    }

    private void addMoneyView(View v, int moneyCuoc) {
        ArrayList<Cash> dta = new ArrayList<>();

        //--- Change money to cash
        Cash[] mn = new Cash.Converter(moneyCuoc).getMoneys();
        for (int i = 0; i < mn.length; i++) {
            Cash cash = mn[i];
            for (int k = 0; k < cash.getCount(); k++) {
                dta.add(cash);
                Log.d(TAG, "Cash: " + cash.getValue());
            }
        }

        //---
        FrameLayout parent = ((FrameLayout) v.getParent());
        CashControl cashControl = null;

        for (int i = 0; i < parent.getChildCount(); i++) {
            if (parent.getChildAt(i).getTag() != null && parent.getChildAt(i).getTag().toString().equals(TAG_CASH_CONTROL)) {
                cashControl = (CashControl) parent.getChildAt(i);
                if (!cashControls.contains(cashControl))
                    cashControls.add(cashControl);
                break;
            }
        }


        CashAdapter adapter = new CashAdapter(this, R.layout.cash_item_view, dta);
        cashControl.setAdapter(adapter);

    }

    //Mo Dia
    public void openBowl(View view) {
        view.setVisibility(View.GONE);
        CosManager.getInstance().displayAll();
        //Xu li tien trong nay
        int money = CosManager.getInstance().tinhTien(sx1, sx2, sx3);
        if (money > 0) {
            MusicManager.playWin();
        } else {
            MusicManager.playLose();
        }
        MoneyManager.getInstance().plusMoney(money);
        //Reset All
        CosManager.getInstance().cleanAll();
        removeAllMoneyControll();
        isOpen = true;
    }

    private void removeAllMoneyControll() {
        for (CashControl cc :
                cashControls) {
            cc.setAdapter(null);
        }

    }


    //Xoc Dia
    public void SocDia(View view) {
        if (MoneyManager.getInstance().getMoneyTotal() == 0) {
            startActivity(new Intent(this, NewGameActivity.class));
            finish();
            return;
        }
        MusicManager.playDice();
        Log.d(TAG, "SocDia");
        int result = randomDice();
        int total = sx1.getDiem() + sx2.getDiem() + sx3.getDiem();
        //push result service
        onPushData(result, total);
        ivBowl.setVisibility(View.VISIBLE);
        isOpen = false;
    }

    private void onPushData(int result, int total) {
        InfoDevice info = InfoDevice.getInstance();
        Log.d(TAG, "DeviceId: " + info.getDeviceId());
        Log.d(TAG, "DeviceName: " + info.getDeviceName());
        Log.d(TAG, "Result: " + result);
        Log.d(TAG, "Result Total: " + total);

        serviceAPI.pushResult(info.getDeviceId(), info.getDeviceName(), result, total).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    //Lay random cho cac dia
    private int randomDice() {
        Random rd = new Random(SystemClock.currentThreadTimeMillis());
        int val1 = getRandomValue(rd);
        int val2 = getRandomValue(rd);
        int val3 = getRandomValue(rd);

        /*int val1 = 3;
        int val2 = 3;
        int val3 = 3;*/

        sx1 = XS.Builder.Builder(val1);
        sx2 = XS.Builder.Builder(val2);
        sx3 = XS.Builder.Builder(val3);

        ivSx1.setImageResource(sx1.getFlag());
        ivSx2.setImageResource(sx2.getFlag());
        ivSx3.setImageResource(sx3.getFlag());

        int total = val1 + val2 + val3;

        if (val1 == val2 && val2 == val3)
            return -1;
        if (total <= 10)
            return 0;
        else return 1;
    }


    //Lay random tu 1 den 6
    public int getRandomValue(Random rd) {
        return (rd.nextInt(6) + 1);
    }

    //Listen money change
    @Override
    public void onChanged(long money) {
        tvScore.setText("$" + money);
    }
}
