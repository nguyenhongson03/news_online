package son.app.adapter;

import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;

import son.app.lazylist.ImageLoader;
import son.app.model.News;
import son.app.newsonline.R;
import son.app.parse.ParseTime;

import android.content.Context;
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
	
	public ListNewsAdapter(Context context, ArrayList<News> list, String newspaper) {
		super(context, R.layout.row_listnew, list);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
		imageLoader = new ImageLoader(context, newspaper);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		// TODO Auto-generated method stub
		View v = new View(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflater.inflate(R.layout.row_listnew, null);
	
		News item = list.get(position);
		ImageView image = (ImageView) v.findViewById(R.id.image);
		TextView title = (TextView) v.findViewById(R.id.title);
		TextView date = (TextView) v.findViewById(R.id.date);
		TextView description = (TextView) v.findViewById(R.id.description);
		
		boolean isRead = item.isRead();
		Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoSlab-Bold.ttf");
		
		title.setTypeface(tf);
		
		title.setText(StringEscapeUtils.unescapeHtml3(item.getTitle()));
		
		
		try {
			ParseTime p = new ParseTime(item.getDate());
			date.setText(p.getTime());
		} catch (Exception e){
			
		}
		
		description.setText(StringEscapeUtils.unescapeHtml4(item.getDescription()));
		
		if (isRead){
			title.setTextColor(Color.GRAY);
			description.setTextColor(Color.GRAY);
		}
		if (item.getImageLink() != null )
			imageLoader.DisplayImage(item.getImageLink(), image);
		else 
			image.setVisibility(View.GONE);
		return v;
	}
	
	public ArrayList<News> getList(){
		return list;
	}
}
