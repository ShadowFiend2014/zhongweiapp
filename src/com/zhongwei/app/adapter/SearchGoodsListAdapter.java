package com.zhongwei.app.adapter;

import java.util.List;

import com.zhongwei.app.asynctask.DownloadImgBase;
import com.zhongwei.app.handler.DownloadImgHandler;
import com.zhongwei.app.http.HttpUtils;
import com.zhongwei.app.info.GoodsBaseInfo;
import com.zhongwei.app.main.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchGoodsListAdapter extends BaseAdapter {
	private List<GoodsBaseInfo> list;
	private Context context;

	public SearchGoodsListAdapter(Context context, List<GoodsBaseInfo> list) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		if (list.size() < position +1)
			return null;
		// TODO 自动生成的方法存根
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_list_app, null);
			new ViewHolder(convertView);
		}
		final ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.iv_icon.setImageResource(R.drawable.ic_launcher);
		if (list.get(position).getGoodsTumbDrawable() != null) {
			holder.iv_icon.setImageDrawable(list.get(position)
					.getGoodsTumbDrawable());
		} else {
			String thumbImgUrl = HttpUtils.MAIN_URL
					+ list.get(position).getGoods_thumb();
			new DownloadImgBase(thumbImgUrl, new DownloadImgHandler() {

				@Override
				public void downloadImgHandler(Drawable drawable) {
					holder.iv_icon.setImageDrawable(drawable);
					list.get(position).setGoodsTumbDrawable(drawable);
				}
			}).execute("");
		}

		holder.tv_name.setText(list.get(position).getGoods_Name());
		holder.goodsPiceTextView.setText(list.get(position).getShop_Price());
		return convertView;
	}

	class ViewHolder {
		ImageView iv_icon;
		TextView tv_name;
        TextView goodsPiceTextView;
		public ViewHolder(View view) {
			iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
			tv_name = (TextView) view.findViewById(R.id.tv_name);
			goodsPiceTextView = (TextView) view.findViewById(R.id.price_search_item);
			view.setTag(this);
		}
	}
}
