package com.android.api;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
/**
 *	测试在什么情况下getView会被重复调用 (layout_height=wrapcontnet的时候会重复inflate view 即convertView=null 资源浪费，
 *	layout_height=fill_parent或指定值的时候正常调用)
 *	参考资料：http://stackoverflow.com/questions/2618272/custom-listview-adapter-getview-method-being-called-multiple-times-and-in-no-co
 * 	@author Administrator
 *
 */
public class ManyGetView extends Activity{
	private ListView listView;
	private LayoutInflater inflater;
	private MyAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);
		inflater = getLayoutInflater();
		listView = (ListView)findViewById(R.id.list_view);
		adapter = new MyAdapter(this, R.layout.list_view_sample_item, getData());
		listView.setAdapter(adapter);
	}
	
	private List<String> getData(){
		List<String> list = new ArrayList<String>();
		for(int i=0;i<15;i++){
			list.add("list_view_item_"+i);
		}
		return list;
	}
	
	class MyAdapter extends ArrayAdapter<String>{
		private int id ;
		private List<String> data;
		public MyAdapter(Context context, int textViewResourceId,
				List<String> objects) {
			super(context, textViewResourceId, objects);
			// TODO Auto-generated constructor stub
			id = textViewResourceId;
			data = objects;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
//			Log.i("tag", "getView"+","+position);
			if(convertView==null){
				Log.i("tag", "convertView id is null,position="+position);
				convertView = inflater.inflate(id, null);
			}else{
				Log.i("tag", "convertView id isn't null,position="+position);
			}
			((TextView)convertView).setText(data.get(position));
			return convertView;
		}
		
	}
}


