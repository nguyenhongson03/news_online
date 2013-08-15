package son.app.newsonline;

import java.util.ArrayList;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import son.app.database.NewspaperHelper;
import son.app.model.News;
import son.app.parse.ParseContentHTML;
import son.app.util.Variables;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class ReadNews extends SherlockFragmentActivity{
	private static ReadNewsAdapter adapter;
	private static ViewPager viewPager;
	private static int key;
	private static ArrayList<News> listNews;
	private static ActionBar mActionBar;
	private static Context context;
	
	private static boolean loadContentNew = false;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_readnews);
		context = getApplicationContext();
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		adapter = new ReadNewsAdapter(getSupportFragmentManager());
		
		key = Integer.parseInt(getIntent().getStringExtra("key"));
		int position = Integer.parseInt(getIntent().getStringExtra("position"));
		
		listNews = Variables.listNews.get(key);
		
		viewPager.setPageMargin(20);
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(position);
		getSupportActionBar().setTitle(Variables.listNews.get(key).get(position).getTitle());
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				getSupportActionBar().setTitle(Variables.listNews.get(key).get(arg0).getTitle());
				NewspaperHelper db = new NewspaperHelper(getApplicationContext());
				db.insertLinkRead(Variables.listNews.get(key).get(arg0).getLink());
				db.close();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.share_article, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == R.id.share) {
			Intent i = new Intent(Intent.ACTION_SEND);
			i.setType("text/plain");
			i.putExtra(Intent.EXTRA_TEXT, Variables.listNews.get(key).get(viewPager.getCurrentItem()).getLink());
			Log.i("link", Variables.listNews.get(key).get(viewPager.getCurrentItem()).getLink());
			startActivity(Intent.createChooser(i, "Share with"));
		}
		return super.onOptionsItemSelected(item);
	}
	/*private void thanhnien(Document doc) {
		Elements articles = doc.select("a.boxlink");
		Log.i("thanhnien size", articles.size() + "");
		for (Element article : articles) {
			String title = article.select("h1").first().toString();
			String link = article.attr("href");
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}*/
	private class ReadNewsAdapter extends FragmentStatePagerAdapter {
		
		
		public ReadNewsAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			ReadNewsFragment fragment = new ReadNewsFragment();
			Bundle args = new Bundle();
			args.putInt(ReadNewsFragment.ARG_SECTION_NUMBER, arg0);
			fragment.setArguments(args);
			return fragment;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listNews.size();
		}
		
	}
	
	public static class ReadNewsFragment extends SherlockFragment {
		public static final String ARG_SECTION_NUMBER = "section_number";
		private WebView webView;
		private WebView comment;
		private ProgressBar spinner;
		private int position;
		
		public ReadNewsFragment() {
			// TODO Auto-generated constructor stub
		}
		
		@SuppressLint({ "NewApi", "SetJavaScriptEnabled" })
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			try {
				position = getArguments().getInt(ARG_SECTION_NUMBER);
				mActionBar = getSherlockActivity().getSupportActionBar();
				mActionBar.setDisplayHomeAsUpEnabled(true);
				mActionBar.setDisplayShowHomeEnabled(false);
				mActionBar.setDisplayShowTitleEnabled(true);
				
				//mActionBar.setTitle(Variables.listNews.get(key).get(position).getTitle());
				
				inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
				View v = inflater.inflate(R.layout.fragment_readnews, null);
				
				final News item = listNews.get(position);
				
				spinner = (ProgressBar) v.findViewById(R.id.spinner);
				
				comment = (WebView) v.findViewById(R.id.comment);
				comment.getSettings().setJavaScriptEnabled(true);
				comment.setVisibility(View.GONE);
				comment.setWebViewClient(new AppWebViewClient());
				
				webView = (WebView) v.findViewById(R.id.webView);
				webView.setWebChromeClient(new WebChromeClient());
				webView.setWebViewClient(new WebViewClientContent());
				webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
				webView.getSettings().setJavaScriptEnabled(true);
				webView.setVisibility(View.GONE);
				
				(new ContentNews()).execute(item.getLink());
				
				return v;
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		public class ContentNews extends AsyncTask<String, String, String> {
			@Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				try {
					if (listNews.get(position).getContent() == null || loadContentNew) {
						ParseContentHTML parse = new ParseContentHTML(params[0], context, key);
						return parse.getContent();
					} else {
						return listNews.get(position).getContent();
					}
				} catch (Exception e){
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				if (listNews.get(position).getContent() == null ) {
					listNews.get(position).setContent(result);
					Variables.listNews.put(key, listNews);
				}
				webView.loadDataWithBaseURL("file:///android_asset/fonts/", result, "text/html", "UTF-8", null);
				spinner.setVisibility(View.GONE);
				webView.setVisibility(View.VISIBLE);
				comment.setVisibility(View.VISIBLE);
				comment.loadUrl(Variables.FACEBOOK_COMMENT + listNews.get(position).getLink());
				super.onPostExecute(result);
			}
			
		}
		
		private class AppWebViewClient extends WebViewClient {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
		}
		
		private class WebViewClientContent extends WebViewClient {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				loadContentNew = true;
				(new ContentNews()).execute(url);
				return true;
			}
		}
	}
}
