package son.app.newsonline;

import java.io.File;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

public class NewsOnline extends Application
{
	// NOTE: the content of this path will be deleted
	//       when the application is uninstalled (Android 2.2 and higher)
	protected File extStorageAppBasePath;
	
	protected File extStorageAppCachePath;

	@Override
	public void onCreate()
	{
		/*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDialog().build());
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyDeath().build());
		}*/

		super.onCreate();

		initImageLoader(getApplicationContext());

		// Check if the external storage is writeable
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
		{
			// Retrieve the base path for the application in the external storage
			File externalStorageDir = Environment.getExternalStorageDirectory();
				
			if (externalStorageDir != null)
			{
				// {SD_PATH}/Android/data/son.app.newsonline
				extStorageAppBasePath = new File(externalStorageDir.getAbsolutePath() +
					File.separator + "Android" + File.separator + "data" +
					File.separator + getPackageName());
			}
	
			if (extStorageAppBasePath != null)
			{
				// {SD_PATH}/Android/data/son.app.newsonline/cache
				extStorageAppCachePath = new File(extStorageAppBasePath.getAbsolutePath() +
					File.separator + "cache");
	
				boolean isCachePathAvailable = true;
				
				if (!extStorageAppCachePath.exists())
				{
					// Create the cache path on the external storage
					isCachePathAvailable = extStorageAppCachePath.mkdirs();
				}
				
				if (!isCachePathAvailable)
				{
					// Unable to create the cache path
					extStorageAppCachePath = null;
				}
			}
		}
	}
	
	@Override
	public File getCacheDir()
	{
		// NOTE: this method is used in Android 2.2 and higher
		
		if (extStorageAppCachePath != null)
		{
			// Use the external storage for the cache
			return extStorageAppCachePath;
		}
		else
		{
			// /data/data/son.app.newsonline/cache
			return super.getCacheDir();
		}
	}
	
	public static void initImageLoader(Context context) {
		// This configuration tuning is custom. You can tune every option, you may tune some of them, 
		// or you can create default configuration by
		//  ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
	}
}
