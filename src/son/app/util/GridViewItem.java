package son.app.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class GridViewItem extends FrameLayout{
	
	public GridViewItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, widthMeasureSpec);
	}
}
