package son.app.adapter;

import java.util.ArrayList;

import son.app.model.Newspaper;
import son.app.newsonline.R;
import son.app.util.Variables;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewspaperAdapter extends ArrayAdapter<Newspaper>{
	private Context context;
	private ArrayList<Newspaper> listNewspaper;
	
	public NewspaperAdapter(Context context, ArrayList<Newspaper> listNewspaper) {
		super(context, R.layout.gridview_item, listNewspaper);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.listNewspaper = listNewspaper;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View gridView;
		
		
		gridView = new View(context);
		gridView = inflate.inflate(R.layout.gridview_item, null);
		
		Newspaper newspaper = listNewspaper.get(position);
		String nameNewspaper = newspaper.getName();
		boolean isSelected = newspaper.isSelect();
		
		View v = (View)gridView.findViewById(R.id.view);
		ImageView image = (ImageView) gridView.findViewById(R.id.image);
		TextView label = (TextView) gridView.findViewById(R.id.label);
		
		image.setBackgroundResource(Variables.icons.get(nameNewspaper));
		label.setText(Variables.NewspaperTitle.get(nameNewspaper));
		
		if (isSelected)
			v.setVisibility(View.VISIBLE);
		return gridView;
	}
	
	
	
}
