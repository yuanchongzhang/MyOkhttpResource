package com.zhangyu.myophttpopen.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhangyu.myophttpopen.R;
import com.zhangyu.myophttpopen.model.CityModel;

import java.util.List;


/**
 * Created by Administrator on 2017/1/12.
 */
public class CityAdapter extends BaseQuickAdapter<CityModel.IshotlistBean, BaseViewHolder> {


    public CityAdapter(List<CityModel.IshotlistBean> data) {
        super(R.layout.item_city,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CityModel.IshotlistBean item) {
        helper.setText(R.id.tvCity, item.getName());

    }


/*

    public CityAdapter(Context context, List<CityModel> list) {
        this.context = context;
        this.list = list;
    }
*/


}
