package son.app.newsonline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;

import son.app.model.News;
import son.app.parse.ParseHTML;
import son.app.util.Variables;

import android.app.ActionBar;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class ReadNews extends FragmentActivity{
	private static ReadNewsAdapter adapter;
	private static ViewPager viewPager;
	private static int key;
	private static ArrayList<News> listNews;
	private static ActionBar mActionBar;
	private static Context context;
	/*private static Handler handler = new Handler();
	private static Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			AlertDialog.Builder buidler = new AlertDialog.Builder();
			buidler.setMessage("Báo hiện giờ không khả dụng, vui lòng thử lại sau!");
			buidler.setPositiveButton("Quay lại", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Intent i = new Intent(ReadNews.this, ListNews.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
				}
			});
			
			buidler.show();
		}
	};*/
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
		
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(position);
		
		mActionBar = getActionBar();
		
		Log.i("bao", Variables.newspaper[key/20]);
		Log.i("category", Variables.NEWSPAPER_CATEGORY[key/20][key%20]);
		Log.i("position", position+"");
	}
	
	private class ReadNewsAdapter extends FragmentStatePagerAdapter {
		
		
		public ReadNewsAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			Fragment fragment = new ReadNewsFragment();
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
	
	public static class ReadNewsFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";
		private WebView webView;
		private ProgressBar spinner;
		private LinearLayout headerPage;
		private int position;
		
		public ReadNewsFragment() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			try {
				mActionBar.setTitle((viewPager.getCurrentItem() + 1) + "/" + listNews.size());
				
				inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				position = getArguments().getInt(ARG_SECTION_NUMBER);
				View v = inflater.inflate(R.layout.fragment_readnews, null);
				
				final News item = listNews.get(position);
				
				headerPage = (LinearLayout) v.findViewById(R.id.header_page);
				spinner = (ProgressBar) v.findViewById(R.id.spinner);
				
				webView = (WebView) v.findViewById(R.id.webView);
				webView.getSettings().setSupportZoom(true);
				webView.getSettings().setBuiltInZoomControls(true);
				webView.getSettings().setDisplayZoomControls(false);
				webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
				webView.getSettings().setAppCachePath(Environment.getExternalStorageDirectory() + ".News_Online/" + Variables.newspaper[key/20] + "/cache");
				webView.setVisibility(View.GONE);
				
				TextView title = (TextView) v.findViewById(R.id.title);
				TextView date = (TextView) v.findViewById(R.id.date);
				
				Log.i("title", item.getTitle());
				Log.i("date", item.getDate());
				title.setText(StringEscapeUtils.unescapeHtml4(item.getTitle()));
				date.setText(item.getDate());
				
				
				
				(new ContentNews()).execute(item);
				
				return v;
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		private String addMetaForHtml(String html){
			String head = "<head>" + readCSS() + "</head>";
								
			return "<html>" + head + "<body>" + html + "</body>" + "</html>";
		}
		
		private String readCSS(){
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("css/webpage.css")));
				StringBuilder css = new StringBuilder();
				
				String temp = "";
				while((temp = reader.readLine()) != null)
					css.append(temp);
				
				reader.close();
				return css.toString();
			} catch (Exception e){
				Log.i("error", "error read file from asset");
			} 
			
			return "";
		}
		
		public class ContentNews extends AsyncTask<News, String, String> {
			@Override
			protected String doInBackground(News... params) {
				// TODO Auto-generated method stub
				try {
					News item = params[0];
					if (listNews.get(position).getContent() == null) {
						ParseHTML parse = new ParseHTML(Variables.newspaper[key/20], item.getLink());
						return parse.getContentView();
					} else {
						Log.i("content", "sdfsdfsdf");
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
				webView.loadData(addMetaForHtml(result), "text/html; charset=UTF-8", null);
				spinner.setVisibility(View.GONE);
				webView.setVisibility(View.VISIBLE);
				
				super.onPostExecute(result);
			}
			
		}
	}
}
