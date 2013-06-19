package son.app.model;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomImageView extends ImageView{
	public float widthImage;
	
	public CustomImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		widthImage = context.getResources().getDisplayMetrics().widthPixels;
	}
	
	public CustomImageView(Context context, AttributeSet attrs){
		super(context, attrs);
		widthImage = context.getResources().getDisplayMetrics().widthPixels;
	}
	
	public CustomImageView(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		widthImage = context.getResources().getDisplayMetrics().widthPixels;
	}
}
