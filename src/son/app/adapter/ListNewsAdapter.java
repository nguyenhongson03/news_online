package son.app.adapter;

import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import son.app.database.NewspaperHelper;
import son.app.model.News;
import son.app.newsonline.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListNewsAdapter extends ArrayAdapter<News>{
	private Context context;
	private ArrayList<News> list;
	private ImageLoader imageLoader;
	private DisplayImageOptions options;
	
	private NewspaperHelper db;
	
	private Typeface robotoBold;
	
	public ListNewsAdapter(Context context, ArrayList<News> list, String newspaper) {
		super(context, R.layout.row_listnew, list);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
		imageLoader = ImageLoader.getInstance();
		options = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.time)
			.showImageForEmptyUri(R.drawable.time)
			.showImageOnFail(R.drawable.time)
			.cacheInMemory()
			.cacheOnDisc()
			.bitmapConfig(Bitmap.Config.RGB_565)
			.build();
		
		db = new NewspaperHelper(context);
		
		robotoBold = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BoldCondensed.ttf");
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.row_listnew, null);
		
			holder = new ViewHolder();
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			
			holder.title.setTypeface(robotoBold);
			
			convertView.setTag(holder);
		} else 
			holder = (ViewHolder) convertView.getTag();
		
		News item = list.get(position);
		
		holder.title.setText(StringEscapeUtils.unescapeHtml3(item.getTitle()));
		
		
		if (db.linkIsRead(item.getLink())){
			holder.title.setTextColor(Color.GRAY);
		} else 
			holder.title.setTextColor(Color.BLACK);
		
		if (item.getImageLink() != null ) {
			imageLoader.displayImage(item.getImageLink(), holder.image, options);
		}
		
		return convertView;
	}
	
	public ArrayList<News> getList(){
		return list;
	}
	
	static class ViewHolder {
		ImageView image;
		TextView title;
	}
}
