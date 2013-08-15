package son.app.fragment;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockFragment;

import son.app.adapter.ListNewsAdapter;
import son.app.database.NewspaperHelper;
import son.app.model.News;
import son.app.newsonline.ListNewspaperPage;
import son.app.newsonline.R;
import son.app.newsonline.ReadNews;
import son.app.parse.ParseNewsHTML;
import son.app.util.Variables;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;

public class NewsFragment extends SherlockFragment{
	public static final String CATEGORY_NUMBER = "category_number";
	public static final String NEWSPAPER = "newspaper_name";
	
	private static ListNewsAdapter adapter;
	
	private ListView list;
	private static ProgressBar spinner;
	private View footer;
	
	private String newspaper;
	private int category;
	private int locationNewspaper;
	private int sizeList = 0;
	private ListNewsAsync task;
	
	private boolean onLoad = false;
	private boolean isFinished = false;
	
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
		
		category = getArguments().getInt(CATEGORY_NUMBER);
		newspaper = getArguments().getString(NEWSPAPER);
		locationNewspaper = Variables.newspaperLocation.get(newspaper);
		
		if (Variables.listNews.get(locationNewspaper*20 + category) == null)
			Variables.listNews.put(locationNewspaper*20 + category, new ArrayList<News>());
		list = (ListView) rootView.findViewById(R.id.list);
		footer = inflater.inflate(R.layout.footer, list, false);
		list.addFooterView(footer);
		adapter = new ListNewsAdapter(getActivity(), Variables.listNews.get(locationNewspaper*20 + category), newspaper);
		list.setAdapter(adapter);
		task = new ListNewsAsync();
		if (Variables.listNews.get(locationNewspaper*20+category).size() == 0) {
			list.setVisibility(View.GONE);
			spinner.setVisibility(View.VISIBLE);
			task.execute();
		} else {
			spinner.setVisibility(View.GONE);
			list.setVisibility(View.VISIBLE);
			adapter.notifyDataSetChanged();
		}
		
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (!onLoad) {
					NewspaperHelper db = new NewspaperHelper(getSherlockActivity());
					db.insertLinkRead(Variables.listNews.get(locationNewspaper*20 + category).get(arg2).getLink());
					db.close();
					Intent intent = new Intent(getActivity(), ReadNews.class);
					intent.putExtra("key", Integer.toString(locationNewspaper*20 + category));
					intent.putExtra("position", Integer.toString(arg2));
					startActivity(intent);
				} else 
					Toast.makeText(getSherlockActivity(), "Loading", Toast.LENGTH_SHORT).show();
			}
			
		});
		
		list.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				if ((task != null && task.getStatus() == Status.FINISHED ) || (task == null && Variables.listNews.get(locationNewspaper*20 + category).size() > 0)){
					if (  (firstVisibleItem + visibleItemCount == totalItemCount) && !onLoad && !isFinished) {
						task = new ListNewsAsync();
						task.execute();
					}
				}
			}
		});
		return rootView;
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		adapter.notifyDataSetChanged();
	}
	
	private class ListNewsAsync extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params){
			// TODO Auto-generated method stub
			try {
				onLoad = true;
				ParseNewsHTML parser = new ParseNewsHTML(newspaper, category);
				parser.getData();
			} catch (UnknownHostException e){
				mHandler.post(mRunnable);
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (sizeList == Variables.listNews.get(locationNewspaper*20 + category).size()) {
				isFinished = true;
				list.removeFooterView(footer);
			} else 
				sizeList = Variables.listNews.get(locationNewspaper*20 + category).size();
			onLoad = false;
			spinner.setVisibility(View.GONE);
			list.setVisibility(View.VISIBLE);
			adapter.notifyDataSetChanged();
		}
	}
}