package son.app.newsonline;

import java.util.ArrayList;

import son.app.database.NewspaperHelper;
import son.app.model.Newspaper;
import son.app.util.Variables;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class ListNewspaperPage extends SherlockActivity {
	private NewspaperHelper db = null;
	
	private SparseArray<ArrayList<Newspaper>> listNewspaper = new SparseArray<ArrayList<Newspaper>>();  
	private ArrayList<Integer> listCategory = new ArrayList<Integer>();
	
	private LinearLayout list;
	
	private int row = 3;
	private int column = 3;
	@Override
	public void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_list_newspaper);
		
		if (findViewById(R.id.list10) != null) {
			list = (LinearLayout) findViewById(R.id.list10);
			row = 7;
			column = 4;
		} else if (findViewById(R.id.list7) != null) {
			list = (LinearLayout) findViewById(R.id.list7);
			row = 5;
			column = 4;
		} else {
			row = 3;
			column = 3;
			list = (LinearLayout) findViewById(R.id.list);
		}
		
		getSupportActionBar().setCustomView(R.layout.custom_actionbar);
		//getSupportActionBar().setCustomView(, new ActionBar.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		
		getSupportActionBar().getCustomView().findViewById(R.id.addNewspaper).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), AddNewspaper.class);
				startActivity(i);
			}
		});
		
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		int countRow = 0;
		list.removeAllViews();
		initListNewspaper();
		
		for (int i = 0; i < listCategory.size();i++) {
			int category = listCategory.get(i);
			for (int j = 0;j < listNewspaper.get(category).size();j = j + column){
				if (j == 0) { 
					if (listNewspaper.get(category).size() >= column) {
						list.addView(renderRow(listCategory.get(i), 0, column, true));
						countRow++;
					} else {
						list.addView(renderRow(category, 0, listNewspaper.get(category).size(), true));
						countRow++;
					}
				} else {
					if (j + column <= listNewspaper.get(category).size()) {
						list.addView(renderRow(category, j, j + column, false));
						countRow++;
					} else {
						list.addView(renderRow(category, j, listNewspaper.get(category).size(), false));
						countRow++;
					}
				}
			}
		}
		
		for (int i = countRow; i < row;i++) {
			RelativeLayout layout = new RelativeLayout(getApplicationContext());
			layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			layout.setBackgroundResource(R.drawable.bg);
			
			
			LinearLayout row_newspaper = new LinearLayout(getApplicationContext());
			row_newspaper.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			row_newspaper.setOrientation(LinearLayout.VERTICAL);
			
			ImageView dock = new ImageView(getApplicationContext());
			dock.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			dock.setBackgroundResource(R.drawable.dock);
			
			row_newspaper.addView(layout);
			row_newspaper.addView(dock);
			list.addView(row_newspaper);
		}
	}
	
	private LinearLayout renderRow (final int category, int start, int end, boolean isStart) {
		RelativeLayout layout = new RelativeLayout(getApplicationContext());
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		layout.setBackgroundResource(R.drawable.bg);
		
		LinearLayout row = new LinearLayout(getApplicationContext());
		//row.setWeightSum(1);
		RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		row.setPadding(20, 0, 20, 0);
		for (int i = start;i < end;i++ ) {
			DisplayMetrics metrics = getResources().getDisplayMetrics();
			float dp = 120f;
			float fpixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
			int pixels = (int) (metrics.density * dp + 0.5f);
			
			FrameLayout newspaper = new FrameLayout(getApplicationContext());
			newspaper.setPadding(5, 0, 5, 0);
			TableLayout.LayoutParams p = new TableLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1);
			
			ImageView image = new ImageView(getApplicationContext());
			image.setLayoutParams(new FrameLayout.LayoutParams((int)fpixels, (int)fpixels, Gravity.CENTER_HORIZONTAL));
			image.setImageBitmap(getBitmap(listNewspaper.get(category).get(i).getThumbnail()));
			
			final int position = i;
			image.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i = new Intent(getApplicationContext(), ListNews.class);
					i.putExtra("newspaper", listNewspaper.get(category).get(position).getName());
					startActivity(i);
				}
			});
			newspaper.addView(image);
			
			TextView title = new TextView(getApplicationContext());
			FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int)fpixels, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
			
			title.setPadding(5, 5, 5, 5);
			title.setBackgroundColor(Color.parseColor("#90000000"));
			title.setTextColor(Color.WHITE);
			title.setText(listNewspaper.get(category).get(position).getTitle());
			newspaper.addView(title, params);
			
			row.addView(newspaper, p);
		}
		
		if (end - start < column) {
			for (int i = 0;i < column - (end - start);i++) {
				ImageView image = new ImageView(getApplicationContext());
				image.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
				row.addView(image);
			}
		}
		
		layout.addView(row, param);
		if (!isStart) {
			//layout.setOrientation(LinearLayout.HORIZONTAL);
		} else {
			//layout.setOrientation(LinearLayout.VERTICAL);
			ImageView iconCategory = new ImageView(getApplicationContext());
			iconCategory.setImageResource(getIconCategory(category));
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			
			layout.addView(iconCategory, params);
		}
		
		LinearLayout row_newspaper = new LinearLayout(getApplicationContext());
		row_newspaper.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		row_newspaper.setOrientation(LinearLayout.VERTICAL);
		
		ImageView dock = new ImageView(getApplicationContext());
		dock.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		dock.setBackgroundResource(R.drawable.dock);
		
		row_newspaper.addView(layout);
		row_newspaper.addView(dock);
		return row_newspaper;
	}
	
	private Bitmap getBitmap(int id) {
		return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), id), 120, 120, false);
	}
	
	private int getIconCategory (int category) {
		switch (category) {
		case 0:
			return R.drawable.zero;
		case 1:
			return R.drawable.one;
		case 2:
			return R.drawable.two;
		case 3:
			return R.drawable.three;
		case 4:
			return R.drawable.four;
		case 5:
			return R.drawable.five;
		case 6:
			return R.drawable.six;
		case 7:
			return R.drawable.seven;
		case 8:
			return R.drawable.eight;
		case 9:
			return R.drawable.nine;

		default:
			return R.drawable.zero;
		}
	}
	
	private void initListNewspaper () {
		listCategory.clear();
		listNewspaper.clear();
		
		if (db == null)
			db = new NewspaperHelper(getApplicationContext());
		else
			db.openDataBase();
		
		Cursor c = db.getAllCategory(Variables.TABLE_NEWSPAPER_CHOSE);
		if (c.getCount() == 0)
			return;
		Log.i("category", c.getCount() + "");
		c.moveToFirst();
		do {
			int category = c.getInt(c.getColumnIndex("category"));
			listCategory.add(category);
			listNewspaper.put(category, new ArrayList<Newspaper>());
			
			Cursor newspaperInCategory = db.getAllNewspaperByCategory(category, Variables.TABLE_NEWSPAPER_CHOSE);
			if (newspaperInCategory.getCount() > 0) {
				Log.i("size newspaper", newspaperInCategory.getCount() + "");
				newspaperInCategory.moveToFirst();
				
				do {
					String name = newspaperInCategory.getString(newspaperInCategory.getColumnIndex("newspaper"));
					String title = Variables.newspaperTitle.get(name);
					Log.i("newspaper", name);
					int icon = Variables.ICONS_SQUARE.get(name);
					
					listNewspaper.get(category).add(new Newspaper(name, title, category, icon));
				} while (newspaperInCategory.moveToNext());
			}
			
			newspaperInCategory.close();
		} while (c.moveToNext());
		
		c.close();
		db.close();
	}
}