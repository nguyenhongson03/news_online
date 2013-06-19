package son.app.fragment;

import java.util.ArrayList;

import son.app.adapter.ListNewsAdapter;
import son.app.model.News;
import son.app.newsonline.ListNewspaperPage;
import son.app.newsonline.R;
import son.app.newsonline.ReadNews;
import son.app.parse.ParseRSS;
import son.app.util.Variables;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.AbsListView.OnScrollListener;

public class NewsFragment extends Fragment{
	public static final String CATEGORY_NUMBER = "category_number";
	public static final String NEWSPAPER = "newspaper_name";
	
	private static ListNewsAdapter adapter;
	private static ListView listView;
	private static ProgressBar spinner;
	
	private ArrayList<News> listNews = new ArrayList<News>();
	private String newspaper;
	private int locationNewspaper;
	private int count = 0;
	private ParseRSS parseRss = null;
	private ListNewsAsync task;
	private boolean onLoad = false;
	private Handler mHandler = new Handler();
	private Runnable mRunnable = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			AlertDialog.Builder buidler = new AlertDialog.Builder(getActivity());
			buidler.setMessage("Báo hiện giờ không khả dụng, vui lòng thử lại sau!");
			buidler.setPositiveButton("Quay lại", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Intent i = new Intent(getActivity(), ListNewspaperPage.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
				}
			});
			
			buidler.show();
		}
	};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.listnews_fragment, container, false);
		
		spinner = (ProgressBar) rootView.findViewById(R.id.spinner);
		
		final int i = getArguments().getInt(CATEGORY_NUMBER);
		newspaper = getArguments().getString(NEWSPAPER);
		locationNewspaper = Variables.newspaperLocation.get(newspaper);
		
		listView = (ListView) rootView.findViewById(R.id.list);
		
		
		adapter = new ListNewsAdapter(getActivity(), listNews, newspaper+"/"+i);
		listView.setAdapter(adapter);
		task = new ListNewsAsync();
		if (Variables.listNews.get(locationNewspaper*20+i) == null) {
			listView.setVisibility(View.GONE);
			spinner.setVisibility(View.VISIBLE);
			task.execute(i);
		} else {
			spinner.setVisibility(View.GONE);
			listView.setVisibility(View.VISIBLE);
			copyToListNews(Variables.listNews.get(locationNewspaper*20+i));
			Log.i("listnews length", listNews.size()+"");
			count = listNews.size();
			adapter.notifyDataSetChanged();
		}
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				listNews.get(arg2).setRead(true);
				Variables.listNews.put(locationNewspaper*20+i, listNews);
				Intent intent = new Intent(getActivity(), ReadNews.class);
				intent.putExtra("key", Integer.toString(locationNewspaper*20 + i));
				intent.putExtra("position", Integer.toString(arg2));
				startActivity(intent);
			}
			
		});
		
		listView.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				if (task != null && (firstVisibleItem + visibleItemCount == totalItemCount) && !onLoad){
					Log.i("test", "test1");
					if (task.getStatus() == Status.FINISHED || task.getStatus() == Status.PENDING) {
						task = new ListNewsAsync();
						task.execute(i);
					}
				}
			}
		});
		return rootView;
	}
	
	private class ListNewsAsync extends AsyncTask<Integer, News, Integer> {

		@Override
		protected Integer doInBackground(Integer... params){
			// TODO Auto-generated method stub
			try {
				onLoad = false;
				if (parseRss == null)
					parseRss = new ParseRSS(Variables.NEWSPAPER_RSS[locationNewspaper][params[0]], locationNewspaper*20 + params[0]);
				Log.i("size", parseRss.getSizeList()+"");
				if (isCancelled()) 
					return null;
				else {
					int max = ( count + 15 ) < parseRss.getSizeList() ? (count + 15) : parseRss.getSizeList();
					Log.i("max", max+"");
					for (; count < max; count++){
						publishProgress(parseRss.getItemNews(count));
						if (isCancelled())
							break;
					}
				}
			} catch (Exception e){
				mHandler.post(mRunnable);
				e.printStackTrace();
			}
			return params[0];
		}
		
		@Override
		protected void onProgressUpdate(News... item) {
			// TODO Auto-generated method stub
			
			listView.setVisibility(View.VISIBLE);
			spinner.setVisibility(View.GONE);
			listNews.add(item[0]);
			adapter.notifyDataSetChanged();
		}
		
		@Override
		protected void onPostExecute(Integer result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			onLoad = false;
			Variables.listNews.put(locationNewspaper*20 + result, listNews);
		}
	}
	
	private void copyToListNews(ArrayList<News> list){
		int size = list.size();
		for (int i = 0;i < size;i++){
			News item = list.get(i);
			listNews.add(item);
		}
	}
}