package son.app.adapter;

import son.app.newsonline.R;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListDrawerAdapter extends ArrayAdapter<String>{
	private Context context;
	private String[] list;
	private Typeface robotoBold;
	
	public ListDrawerAdapter(Context context, String[] list) {
		// TODO Auto-generated constructor stub
		super(context, R.layout.row_listcategory_in_drawerlayout, list);
		
		this.context = context;
		this.list = list;
		
		robotoBold = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BoldCondensed.ttf");
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.row_listcategory_in_drawerlayout, null);
			
			holder = new ViewHolder();
			
			holder.text = (TextView) convertView.findViewById(R.id.category_drawer);
			holder.text.setTypeface(robotoBold);
			
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		
		holder.text.setText(list[position]);
		return convertView;
	}
	
	static class ViewHolder {
		TextView text;
	}

}
