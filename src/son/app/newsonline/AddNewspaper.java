package son.app.newsonline;

import son.app.adapter.AddNewspaperAdapter;
import son.app.adapter.ListCategoryAdapter;
import son.app.util.Variables;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ViewSwitcher;

public class AddNewspaper extends Activity {
	private ActionBar mActionBar;
	private ListView lvCategory;
	private ListView lvNewpspaper;
	private ViewSwitcher switcher;
	private ListCategoryAdapter adapter;
	
	private int positionView = 0;
	private int category;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addnewspaper);
		
		mActionBar = getActionBar();
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
				AddNewspaperAdapter adapter = new AddNewspaperAdapter(getApplicationContext(), listNewspaper, arg2);
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
				Intent upIntent = new Intent(this, ListNewspaperPage.class);
	            if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
	                TaskStackBuilder.from(this)
	                        .addNextIntent(upIntent)
	                        .startActivities();
	                finish();
	            } else {
	                NavUtils.navigateUpTo(this, upIntent);
	            }
	            return true;
			}
		return false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.actionbar_activity_addnewspaper, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home)
			if (positionView == 1)
				previousView();
			else {
				Intent upIntent = new Intent(this, ListNewspaperPage.class);
	            if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
	                TaskStackBuilder.from(this)
	                        .addNextIntent(upIntent)
	                        .startActivities();
	                finish();
	            } else {
	                NavUtils.navigateUpTo(this, upIntent);
	            }
	            return true;
			}
		else if (item.getItemId() == R.id.menu_search){
			EditText inputSearch = (EditText) findViewById(R.id.menu_search);
			String search = inputSearch.getText().toString();
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
