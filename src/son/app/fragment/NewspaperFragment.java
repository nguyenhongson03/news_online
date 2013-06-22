package son.app.fragment;

import java.util.ArrayList;
import java.util.Collections;

import son.app.adapter.GridviewHeaderAdapter;
import son.app.database.NewspaperHelper;
import son.app.util.Variables;
import son.app.model.Newspaper;
import son.app.newsonline.AddNewspaper;
import son.app.newsonline.ListNews;
import son.app.newsonline.R;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.GridView;

public class NewspaperFragment extends Fragment{
	private NewspaperHelper db;
	private ArrayList<Newspaper> listNewspaper = new ArrayList<Newspaper>();
	private ArrayList<Integer> categories = new ArrayList<Integer>();
	private GridviewHeaderAdapter adapter;
	private Cursor c;
	private GridView gridView;
	private ImageButton add;
	
	private int numItemSelected = 0;
	private boolean enableSelected = false;
	private ActionModeBar mActionModeBar = new ActionModeBar();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.newspaper_fragment, container, false);
		db = new NewspaperHelper(getActivity().getApplicationContext());
		gridView = (GridView) rootView.findViewById(R.id.gridView);
		add = (ImageButton) rootView.findViewById(R.id.add_newspaper);
		inputNewspaper();
		
		adapter = new GridviewHeaderAdapter(rootView.getContext(), listNewspaper);
		gridView.setAdapter(adapter);
		
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if (enableSelected){
				
					if (listNewspaper.get(arg2).isSelect()){
						listNewspaper.get(arg2).setIsSelect(false);
						numItemSelected--;
						mActionModeBar.updateActionBar();
					} else {
						listNewspaper.get(arg2).setIsSelect(true);
						numItemSelected++;
						mActionModeBar.updateActionBar();
					}
					adapter.notifyDataSetChanged();
				} else {
					Intent i = new Intent(getActivity(), ListNews.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra("newspaper", listNewspaper.get(arg2).getName());
					startActivity(i);
				}
			}
			
		});
		gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (!enableSelected){
					numItemSelected = 0;
					getActivity().startActionMode(mActionModeBar);
					enableSelected = true;
					adapter.notifyDataSetChanged();
					
				} else {
					if (listNewspaper.get(arg2).isSelect()){
						listNewspaper.get(arg2).setIsSelect(false);
						numItemSelected--;
						mActionModeBar.updateActionBar();
					} else {
						listNewspaper.get(arg2).setIsSelect(true);
						numItemSelected++;
						mActionModeBar.updateActionBar();
					}
					adapter.notifyDataSetChanged();
				}
				return false;
			}
			
		});
		Bitmap res = BitmapFactory.decodeResource(getResources(), R.drawable.btn3_menu);
		Bitmap resized;
		resized = Bitmap.createScaledBitmap(res, (int)(res.getHeight() * 0.5), (int)(res.getWidth()*0.5), true);
		add.setImageBitmap(resized);
		
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), AddNewspaper.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
			}
		});
		
		return rootView;
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		db = new NewspaperHelper(getActivity().getApplicationContext());
		listNewspaper.clear();
		inputNewspaper();
		adapter.notifyDataSetChanged();
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		db.close();
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		db.close();
	}
	private void inputNewspaper(){
		c = db.getAll(Variables.TABLE_NEWSPAPER_CHOSE);
		if (c.getCount() > 0) {
			c.moveToFirst();
			
			do {
				String nameNewspaper = db.getNewspaper(c);
				int categoryNewspaper = db.getCategory(c);
				Cursor c_thumbnail = db.getNewspaperByName(nameNewspaper, Variables.TABLE_NEWSPAPER_THUMBNAIL);
				if (c_thumbnail.getCount() > 0) {
					c_thumbnail.moveToFirst();
					//Log.i("newpspaper thumbnail", nameNewspaper + " " c_t)
					listNewspaper.add(new Newspaper(nameNewspaper, categoryNewspaper, db.getThumbnail(c_thumbnail)));
					c_thumbnail.close();
				} else
					listNewspaper.add(new Newspaper(nameNewspaper, categoryNewspaper, null));
				categories.add(categoryNewspaper);
			} while (c.moveToNext());
			
		}
		Collections.sort(categories);
		c.close();
	}
	
	public class ActionModeBar implements ActionMode.Callback {
		private TextView numSelected = null;
		
		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void onDestroyActionMode(ActionMode mode) {
			// TODO Auto-generated method stub
			enableSelected = false;
			for (int i = 0;i < listNewspaper.size();i++)
				listNewspaper.get(i).setIsSelect(false);
			adapter.notifyDataSetChanged();
		}
		
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			MenuInflater inflater = mode.getMenuInflater();
			inflater.inflate(R.menu.actionbar, menu);
			MenuItem item = menu.findItem(R.id.numberOfSelected);
			View v = item.getActionView();
			if (v instanceof TextView){
				numSelected = ((TextView)v);
				numSelected.setText("1 Selected");
			}
			return true;
		}
		
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			// TODO Auto-generated method stub
			if (item.getItemId() == R.id.delete){
				int i = 0;
				while (i < listNewspaper.size()){
					Newspaper newspaper = listNewspaper.get(i);
					if (newspaper.isSelect()){
						db.delete(listNewspaper.get(i).getName(), Variables.TABLE_NEWSPAPER_CHOSE);
						listNewspaper.remove(i);
					} else 
						i++;
				}
				enableSelected = false;
				for (i = 0;i < listNewspaper.size();i++)
					listNewspaper.get(i).setIsSelect(false);
				adapter.notifyDataSetChanged();
				
			}
			
			
			
			
			mode.finish();
			return false;
		}
		
		public void updateActionBar(){
			if (numItemSelected > 0) 
				numSelected.setText(numItemSelected + " Selected");
			else
				numSelected.setText("");
		}
	}
}