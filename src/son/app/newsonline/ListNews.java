package son.app.newsonline;

import son.app.fragment.NewsFragment;
import son.app.util.Variables;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class ListNews extends Activity {
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private String[] listCategories;
	private ListView mDrawerList;
	private static int locationNewspaper;
	private static String newspaper;
	private static String title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_news_page);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		newspaper = getIntent().getStringExtra("newspaper");
		locationNewspaper = Variables.newspaperLocation.get(newspaper);
		listCategories = Variables.NEWSPAPER_CATEGORY[locationNewspaper];
		
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.row_listcategory_in_drawerlayout, listCategories));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		mDrawerToggle = new ActionBarDrawerToggle(this, 
			mDrawerLayout, 
			R.drawable.ic_drawer, 
			R.string.open_drawer, 
			R.string.close_drawer){

				@Override
				public void onDrawerClosed(
						View drawerView) {
					// TODO Auto-generated method stub
					super.onDrawerClosed(drawerView);
					getActionBar().setTitle(title);
				}

				@Override
				public void onDrawerOpened(
						View drawerView) {
					// TODO Auto-generated method stub
					super.onDrawerOpened(drawerView);
					getActionBar().setTitle("Danh sách tin");
				}
			
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
        Fragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt(NewsFragment.CATEGORY_NUMBER, position);
        args.putString(NewsFragment.NEWSPAPER, newspaper);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(Variables.NEWSPAPER_CATEGORY[locationNewspaper][position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }
	
	@Override
    public void setTitle(CharSequence title) {
		this.title = Variables.NewspaperTitle.get(newspaper) + "-" +title;
        getActionBar().setTitle(this.title);
    }
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (mDrawerToggle.onOptionsItemSelected(item)){
			return true;
		} else
			return super.onOptionsItemSelected(item);
	}
}
