package son.app.newsonline;

import son.app.adapter.AppSectionPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;

public class ListNewspaperPage extends FragmentActivity implements ActionBar.TabListener{
	private AppSectionPagerAdapter mAppSectionPagerAdapter;
	private ViewPager mViewPager;
	
	@Override
	public void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.list_newspaper_page);
		
		mAppSectionPagerAdapter = new AppSectionPagerAdapter(getSupportFragmentManager());
		
		final ActionBar mActionBar = getActionBar();
		mActionBar.setDisplayShowTitleEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		mViewPager = (ViewPager) findViewById(R.id.list_newspaper);
		mViewPager.setAdapter(mAppSectionPagerAdapter);
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				mActionBar.setSelectedNavigationItem(position);
			}
			
		});
		
		for (int i = 0;i < mAppSectionPagerAdapter.getCount();i++){
			mActionBar.addTab(mActionBar.newTab()
					.setText(mAppSectionPagerAdapter.getPageTitle(i))
					.setTabListener(this));
			
		}
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
}
