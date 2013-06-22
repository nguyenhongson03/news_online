package son.app.adapter;

import java.io.File;
import java.util.ArrayList;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import son.app.database.NewspaperHelper;
import son.app.gridviewheader.StickyGridHeadersSimpleAdapter;
import son.app.model.Newspaper;
import son.app.newsonline.R;
import son.app.util.Variables;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridviewHeaderAdapter extends BaseAdapter implements StickyGridHeadersSimpleAdapter{
	private Context context;
	private ArrayList<Newspaper> newspapers;
	private ImageLoader imageLoader;
	private DisplayImageOptions options;
	
	public GridviewHeaderAdapter(Context context, ArrayList<Newspaper> newspapers) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.newspapers = newspapers;
		imageLoader = ImageLoader.getInstance();
		options = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.ic_stub)
			.showImageForEmptyUri(R.drawable.ic_stub)
			.showImageOnFail(R.drawable.ic_stub)
			.cacheInMemory()
			.cacheOnDisc()
			.bitmapConfig(Bitmap.Config.RGB_565)
			.build();
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return newspapers.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return newspapers.get(position).getCategory();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		
		if (convertView == null){
			LayoutInflater inflater = LayoutInflater.from(context);
			
			convertView = inflater.inflate(R.layout.gridview_item, parent, false);
			holder = new ViewHolder();
			holder.textView = (TextView) convertView.findViewById(R.id.label);
			holder.imageView = (ImageView) convertView.findViewById(R.id.image);
			holder.view = (View) convertView.findViewById(R.id.view);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		Newspaper item = newspapers.get(position);
		
		String nameNewspaper = Variables.NewspaperTitle.get(item.getName());
		
		holder.textView.setText(nameNewspaper);
		
		String imageLink;
		NewspaperHelper db = new NewspaperHelper(context);
		Cursor c = db.getNewspaperByName(newspapers.get(position).getName(), Variables.TABLE_NEWSPAPER_THUMBNAIL);
		c.moveToFirst();
		if (c.getCount() > 0)
			imageLink = db.getThumbnail(c);
		else 
			imageLink = null;
		imageLoader.displayImage(imageLink, holder.imageView, options);
		/*String imagePath = getImageThumnail(item.getName());
		
		if ( imagePath != null) {
			Bitmap mBitmap = BitmapFactory.decodeFile(imagePath);
			//holder.imageView.setBackgroundResource(android.R.color.transparent);
			holder.imageView.setImageBitmap(mBitmap);
		} else
			holder.imageView.setImageResource(Variables.icons.get(newspapers.get(position).getName()));*/
		
		if (item.isSelect())
			holder.view.setVisibility(View.VISIBLE);
		else 
			holder.view.setVisibility(View.GONE);
		c.close();
		db.close();
		return convertView;
	}

	@Override
	public long getHeaderId(int position) {
		// TODO Auto-generated method stub
		
		
		return newspapers.get(position).getCategory();
	}

	@Override
	public View getHeaderView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		HeaderViewHolder holder;
		
		if (convertView == null){
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.header, parent, false);
			
			holder = new HeaderViewHolder();
			holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
			convertView.setTag(holder);
		} else {
			holder = (HeaderViewHolder) convertView.getTag();
		}
		
		String item = Variables.ListCategory.get(newspapers.get(position).getCategory()).getName();
		holder.textView.setText(item);
		
		return convertView;
	}
	
	protected class HeaderViewHolder {
		public TextView textView;
	}
	
	protected class ViewHolder {
		public TextView textView;
		public ImageView imageView;
		public View view;
	}
}
