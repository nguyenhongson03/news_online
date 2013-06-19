package son.app.adapter;

import son.app.fragment.NewspaperFragment;
import son.app.fragment.OfflineFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AppSectionPagerAdapter extends FragmentPagerAdapter{

	public AppSectionPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		if (arg0 == 0)
			return new NewspaperFragment();
		else 
			return new OfflineFragment();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		if (position == 0)
			return "Newspaper";
		else
			return "Offline";
	}
}
