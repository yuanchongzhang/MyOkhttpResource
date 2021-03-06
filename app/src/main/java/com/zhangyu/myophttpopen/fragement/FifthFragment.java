package com.zhangyu.myophttpopen.fragement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.BaseRequest;
import com.zhangyu.myophttpopen.R;
import com.zhangyu.myophttpopen.adapter.ZhaiquanAdapter;
import com.zhangyu.myophttpopen.base.MyBaseFragment;
import com.zhangyu.myophttpopen.callback.JsonCallback2;
import com.zhangyu.myophttpopen.response.AccessToken;
import com.zhangyu.myophttpopen.response.Zhaiquan;
import com.zhangyu.myophttpopen.util.MD5Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FifthFragment extends MyBaseFragment implements View.OnClickListener {

    ZhaiquanAdapter adapter;


    public String getAccessToken;
    String md5str;
    private String str;
    private List<Zhaiquan.ListBean> list = new ArrayList<>();

    private RecyclerView rv_01;
    private RecyclerView.LayoutManager mLayoutManager;
    AccessToken accessToken;
    Gson gson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fifth, null);
        gson = new Gson();
        rv_01 = (RecyclerView) view.findViewById(R.id.rv_01);


        str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        md5str = MD5Utils.encode("index/index" + "20160001" + str + "24SD%F4}S5").toUpperCase();
        getData2();
        return view;
    }


    @Override
    public void onClick(View view) {

    }


    public void getData2() {

        OkGo.get("http://vhost119.zihaistar.com/api/index/bond")//
                .tag(this)//
                .params("access_token", getAccessToken)
                .params("p", "0")
                .params("borrow_type", "0")
                .params("borrow_interest_rate", 0)
                .params("borrow_money", 0)
                .params("borrow_duration", 0)
                .execute(new JsonCallback2<Zhaiquan>() {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        showLoading();
                    }

                    @Override
                    public void onSuccess(Zhaiquan zhaiquan, Call call, Response response) {

                        list = zhaiquan.getList();
                        adapter = new ZhaiquanAdapter(getActivity(), list);
                        mLayoutManager = new LinearLayoutManager(getActivity());
                        rv_01.setLayoutManager(mLayoutManager);

                        rv_01.setAdapter(adapter);
                        dismissLoading();
                    }
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        dismissLoading();
                    }
                });
               /* .execute(new JsonCallback2<Zhaiquan>() {

                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        showLoading();
                    }

                    @Override
                    public void onSuccess(Zhaiquan zhaiquan, Call call, Response response) {

                        list = zhaiquan.getList();
                        adapter = new ZhaiquanAdapter(getActivity(), list);
                        mLayoutManager = new LinearLayoutManager(getActivity());
                        rv_01.setLayoutManager(mLayoutManager);

                        rv_01.setAdapter(adapter);
                        dismissLoading();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        dismissLoading();
                    }


                });*/
    }
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        // TODO Auto-generated method stub
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
    }

}
