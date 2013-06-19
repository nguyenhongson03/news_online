package son.app.adapter;

import java.util.ArrayList;

import son.app.model.Category;
import son.app.newsonline.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListCategoryAdapter extends ArrayAdapter<Category> {
	private Context context;
	private ArrayList<Category> category;
	
	public ListCategoryAdapter(Context context, ArrayList<Category> category) {
		super(context, R.layout.row_listview_catagory, category);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.category = category;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = new View(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflater.inflate(R.layout.row_listview_catagory, null);
		
		Category item = category.get(position);
		
		TextView nameCategory = (TextView) v.findViewById(R.id.catagory_name);
		TextView descriptionCategory = (TextView) v.findViewById(R.id.catagory_description);
		
		nameCategory.setText(item.getName());
		descriptionCategory.setText(item.getDescription());
				
		return v;
	}
	
}
