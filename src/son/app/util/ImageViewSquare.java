package son.app.util;

import android.content.Context;
import android.widget.ImageView;

public class ImageViewSquare extends ImageView{

	public ImageViewSquare(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(heightMeasureSpec, heightMeasureSpec);
	}
	
}
