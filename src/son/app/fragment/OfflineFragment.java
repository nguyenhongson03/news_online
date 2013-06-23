package son.app.fragment;

import son.app.newsonline.AddNewspaper;
import son.app.newsonline.R;
import son.app.util.Variables;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

public class OfflineFragment extends Fragment{
	private GridView gridView;
	private Button addNewspaper;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.offline_fragment, container, false);
		
		gridView = (GridView) rootView.findViewById(R.id.gridView);
		addNewspaper = (Button) rootView.findViewById(R.id.add_newspaper);
		
		addNewspaper.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), AddNewspaper.class);
				i.putExtra("table", Variables.TABLE_NEWSPAPER_OFFLINE);
				startActivity(i);
			}
		});
		return rootView;
	}
}
