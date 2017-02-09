package com.zhangyu.myophttpopen.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.zhangyu.myophttpopen.R;
import com.zhangyu.myophttpopen.base.BaseDetailActivity;
import com.zhangyu.myophttpopen.callback.StringDialogCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/9.
 */
public class MySectionActivity extends BaseDetailActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        getData2();
    }


    public void getData2() {

        OkGo.get("http://121.42.26.208:83/interface/json_area.php")//
                .tag(this)//
                .execute(new StringDialogCallback(this) {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //   Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
                        Log.d(s, "dasklffffffffffff");
                        Gson gson = new Gson();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });

    }

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

    }
}
