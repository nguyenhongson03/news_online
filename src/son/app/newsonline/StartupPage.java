package son.app.newsonline;

import java.io.IOException;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

import son.app.database.NewspaperHelper;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class StartupPage extends SherlockActivity{
	private ProgressDialog progressDialog;
	private NewspaperHelper db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		openDB();
		ActionBar actionBar = getSupportActionBar();
		
		actionBar.setHomeButtonEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.hide();
		
		progressDialog = ProgressDialog.show(this, "", "Checking network");
		new CheckNetwork().execute("");
		/*Intent i = new Intent(StartupPage.this, ListNewspaperPage.class);
		startActivity(i);*/
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		progressDialog = ProgressDialog.show(this, "", "Checking network");
		new CheckNetwork().execute("");
		super.onResume();
	}
	
	private void openDB(){
    	db = new NewspaperHelper(this);
        try {
        	db.createDataBase();
	 	} catch (IOException ioe) {
	 		throw new Error("Unable to create database");
	 	}
 
        try {
        	db.openDataBase();
        }catch(SQLException sqle){
        	throw sqle;
        }
 
    }
	
	private class CheckNetwork extends AsyncTask<String, Void, Boolean> {

		@Override
		protected Boolean doInBackground(String... params) {
			// TODO Auto-generated method stub
			
		    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		    return cm.getActiveNetworkInfo() != null && 
		       cm.getActiveNetworkInfo().isConnectedOrConnecting();
			
		}

		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			progressDialog.dismiss();
			if (result){
				Intent i = new Intent(StartupPage.this, ListNewspaperPage.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.putExtra("newspaper", "vnexpress");
				startActivity(i);
				finish();
			} else {
				final Dialog dialog = new Dialog(StartupPage.this);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.dialog_network_state);
				
				Button cancel = (Button) dialog.findViewById(R.id.cancel);
				cancel.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						finish();
					}
				});
				dialog.show();
			}
			super.onPostExecute(result);
		}
		
	}
}
