package son.app.newsonline;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import son.app.adapter.AddNewspaperAdapter;
import son.app.adapter.ListCategoryAdapter;
import son.app.util.Variables;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ViewSwitcher;

public class AddNewspaper extends SherlockActivity {
	private ActionBar mActionBar;
	private ListView lvCategory;
	private ListView lvNewpspaper;
	private ViewSwitcher switcher;
	private ListCategoryAdapter adapter;
	
	private int positionView = 0;
	private int category;
	
	private String table = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addnewspaper);
		
		table = getIntent().getStringExtra("table");
		
		mActionBar = getSupportActionBar();
		
		
		mActionBar.setCustomView(R.layout.actionbar_addnewspaer);
		mActionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_CUSTOM);
		mActionBar.setDisplayHomeAsUpEnabled(true);
		
		lvCategory = (ListView) findViewById(R.id.list_catagories);
		lvNewpspaper = (ListView) findViewById(R.id.list_newspapers);
		switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
		
		adapter = new ListCategoryAdapter(this, Variables.ListCategory);
		lvCategory.setAdapter(adapter);
		
		lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				category = arg2;
				String[] listNewspaper = Variables.ListCategory.get(arg2).getItems();
				AddNewspaperAdapter adapter;
				if (table == null)
					adapter = new AddNewspaperAdapter(getApplicationContext(), listNewspaper, arg2, Variables.TABLE_NEWSPAPER_CHOSE);
				else
					adapter = new AddNewspaperAdapter(getApplicationContext(), listNewspaper, arg2, Variables.TABLE_NEWSPAPER_OFFLINE);
				lvNewpspaper.setAdapter(adapter);
				nextView();
			}
		
		});
		
		lvNewpspaper.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), ListNews.class);
				i.putExtra("newspaper", Variables.ListCategory.get(category).getItems()[arg2]);
				startActivity(i);
			}
		});
	}
	
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK)
			if (positionView == 1)
				previousView();
			else {
				finish();
	            return true;
			}
		return false;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home)
			if (positionView == 1)
				previousView();
			else {
				finish();
	            return true;
			}

		return super.onOptionsItemSelected(item);
	}
	
	//Next, Previous Views
	private void previousView() {
		
		//Previous View
		positionView = 0;
		mActionBar.setTitle("Mục tin");
		switcher.setInAnimation(this, R.anim.in_animation1);
		switcher.setOutAnimation(this, R.anim.out_animation1);
		switcher.showPrevious();
			
		
	}
	private void nextView() {
		
		//Next View
		positionView = 1;
		mActionBar.setTitle("Danh sách báo");
		switcher.setInAnimation(this, R.anim.in_animation);
		switcher.setOutAnimation(this, R.anim.out_animation);
		switcher.showNext();
	}
}
