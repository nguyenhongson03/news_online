package son.app.adapter;

import son.app.database.NewspaperHelper;
import son.app.newsonline.R;
import son.app.util.Variables;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AddNewspaperAdapter extends ArrayAdapter<String>{
	private Context context;
	private String[] ListNewspaper;
	private int category;
	private String tableName;
	
	public AddNewspaperAdapter(Context context, String[] ListNewspaper, int category, String tableName) {
		super(context, R.layout.row_listview_newspaper, ListNewspaper);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.ListNewspaper = ListNewspaper;
		this.category = category;
		this.tableName = tableName;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = new View(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflater.inflate(R.layout.row_listview_newspaper, null);
		
		TextView newspaper = (TextView) v.findViewById(R.id.newspaper);
		ImageView addNewspaper = (ImageView) v.findViewById(R.id.add_newspaper);
		ImageView icon = (ImageView) v.findViewById(R.id.icon);
		
		final String item = ListNewspaper[position];
		newspaper.setText(Variables.newspaperTitle.get(item));
		Log.i("name", item );
		icon.setImageResource(Variables.icons.get(item));
		
		final NewspaperHelper db = new NewspaperHelper(context);
		addNewspaper.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (db.getNewspaperByName(item, tableName).getCount() != 0) {
					db.delete(item, tableName);
				} else {
					db.insert(item, category, tableName);
					
				}
				notifyDataSetChanged();
			}
		});
		
		
		if (db.getNewspaperByName(item, tableName).getCount() != 0)
			addNewspaper.setImageResource(R.drawable.deleted);
		else {
			addNewspaper.setImageResource(R.drawable.add);
		}
		return v;
	}
	

}
