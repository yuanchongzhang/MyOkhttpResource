package com.zhangyu.myophttpopen.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhangyu.myophttpopen.R;
import com.zhangyu.myophttpopen.response.BannerResponse;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */

public class LargePicAdapter extends BaseQuickAdapter<BannerResponse.BannerlistBean, BaseViewHolder> {

    public LargePicAdapter(List<BannerResponse.BannerlistBean> data) {
        super(R.layout.chakandatu, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BannerResponse.BannerlistBean item) {


    }

}
