package pungfaye.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	private List<Map<String, Object>> mData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mData = getData();
		MyAdapter adapter = new MyAdapter(this);
		setListAdapter(adapter);

	}
	
//填充数据, 返回数据列表
	private List<Map<String, Object>> getData() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("title","title_Value-1");
		map.put("info", "info_Value_1");
		map.put("img", R.drawable.test1);//插入资源图片
		list.add(map);
		
		map = new HashMap<String,Object>();
		map.put("title","title_Value-2");
		map.put("info", "info_Value_2");
		map.put("img", R.drawable.test2);//插入资源图片
		list.add(map);
		
		map = new HashMap<String,Object>();
		map.put("title","title_Value-3");
		map.put("info", "info_Value_3");
		map.put("img", R.drawable.test3);//插入资源图片
		list.add(map);
		
		return list;
	}
	
//	ListView被选中后的逻辑

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){

		Log.v("ListView Clickd", (String) mData.get(position).get("title"));
	
	}

	
	public void showInfo(){
        new AlertDialog.Builder(this)
        .setTitle("我的第一个Adapter")
        .setMessage("哈哈")
        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        })
        .show();
         
    }
	
	public final class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView info;
        public Button viewBtn;
    }
	
//	定义自己的Adapter
	public class MyAdapter extends BaseAdapter{
	
	private LayoutInflater mInflater;
	
	public MyAdapter(Context context){
		this.mInflater = LayoutInflater.from(context);
	}
//	返回list长度
	@Override
	public int getCount(){
		return mData.size();
	}
//返回list元素
	@Override
	public Object getItem(int arg0){
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		ViewHolder holder = null;
		if(convertView == null){
			
			holder = new ViewHolder();
			
			convertView = mInflater.inflate(R.layout.listview, null);
			holder.img = (ImageView)convertView.findViewById(R.id.img);
			holder.info = (TextView)convertView.findViewById(R.id.info);
			holder.title = (TextView)convertView.findViewById(R.id.title);
			holder.viewBtn = (Button)convertView.findViewById(R.id.view_btn);
            convertView.setTag(holder);
		}
		else 
		{
           holder = (ViewHolder)convertView.getTag();
        }
        
        
       holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
       holder.title.setText((String)mData.get(position).get("title"));
       holder.info.setText((String)mData.get(position).get("info"));
        
       holder.viewBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showInfo();                 
           }
       });
        
        
       return convertView;
    }
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	}


}