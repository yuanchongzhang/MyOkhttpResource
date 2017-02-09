package com.zhangyu.myophttpopen.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.zhangyu.myophttpopen.R;
import com.zhangyu.myophttpopen.adapter.CityAdapter;
import com.zhangyu.myophttpopen.callback.StringDialogCallback;
import com.zhangyu.myophttpopen.model.CityModel;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/9.
 */
public class MySectionActivity extends Activity {

    private RecyclerView rv;

    CityAdapter mCityAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        rv = (RecyclerView) findViewById(R.id.rv);
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
                        CityModel myModel=gson.fromJson(s,CityModel.class);

                        mLayoutManager = new LinearLayoutManager(MySectionActivity.this);
                        mCityAdapter = new CityAdapter(myModel.getIshotlist());
                        /*Log.d(bannerResponse.getBannerlist().size() + "", "9999999999");
                        rv_01.setLayoutManager(mLayoutManager);
                        rv_01.setAdapter(largePicAdapter2);*/
                        rv.setLayoutManager(mLayoutManager);
                        rv.setAdapter(mCityAdapter);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });

    }


}
