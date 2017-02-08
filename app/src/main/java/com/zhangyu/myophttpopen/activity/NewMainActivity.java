package com.zhangyu.myophttpopen.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zhangyu.myophttpopen.R;
import com.zhangyu.myophttpopen.event.NewMessageEvent;
import com.zhangyu.myophttpopen.fragement.FirstFragment;
import com.zhangyu.myophttpopen.fragement.FourthFragment;
import com.zhangyu.myophttpopen.fragement.SecondFragment;
import com.zhangyu.myophttpopen.fragement.ThirdFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * Created by Administrator on 2016/11/10.
 */
public class NewMainActivity extends FragmentActivity {

    private Boolean FLAG = false;

    RadioGroup radioGroup;

    RadioButton city_tugou;


    FrameLayout layout_frame;

    public RadioButton rb_travel;

    public RadioButton rb_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EventBus.getDefault().register(this);
        bindView();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int index = 0;
                switch (i) {
                    case R.id.rb_home:
                        index = 10;
                        break;
                    case R.id.rb_travel:
                        index = 20;
                        break;
                    case R.id.rb_service:
                        index = 30;
                        break;
                    case R.id.rb_my:
                        index = 40;
                        break;

                }
                Fragment fragment = (Fragment) fragmentAdapter.instantiateItem(layout_frame, index);
                fragmentAdapter.setPrimaryItem(layout_frame, 0, fragment);
                fragmentAdapter.finishUpdate(layout_frame);
            }
        });
    }

    public void bindView() {
        radioGroup = (RadioGroup) findViewById(R.id.rg_bottomm);
        city_tugou = (RadioButton) findViewById(R.id.rb_home);
        layout_frame = (FrameLayout) findViewById(R.id.fl_content);
        rb_travel = (RadioButton) findViewById(R.id.rb_travel);
        rb_service = (RadioButton) findViewById(R.id.rb_service);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        if (!FLAG) {
            city_tugou.setChecked(true);
            FLAG = true;
        }
    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

    }

    FragmentStatePagerAdapter fragmentAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            switch (arg0) {
                case 10:
                    return new FirstFragment();
                case 20:
                    return new SecondFragment();
                case 30:
                    return new ThirdFragment();
                case 40:
                    return new FourthFragment();

                default:
                    return new FirstFragment();
            }

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 4;
        }

    };

    /* @Subscribe(threadMode = ThreadMode.MAIN)
     public void onMessageEvent(NewMessageEvent event) {

         if (event.message.equals("1")) {
             rb_travel.setChecked(true);
             Toast.makeText(this, "事件传递成功", Toast.LENGTH_SHORT).show();
         } else if (event.message.equals("2")) {
             rb_service.setChecked(true);
         }

     }*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(NewMessageEvent event) {
       /* String msg = "onEventMainThread收到了消息：" + event.message;
        Log.d("harvic", msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();*/
        if (event.message.equals("1")) {
            rb_travel.setChecked(true);
            Toast.makeText(this, "事件传递成功", Toast.LENGTH_SHORT).show();
        } else if (event.message.equals("2")) {
            rb_service.setChecked(true);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }
}
