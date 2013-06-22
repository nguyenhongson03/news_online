package son.app.parse;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ParseNewsHTML {
	private String link;
	private int key;
	private Context context;
	private Elements news = null;
	
	private WebView webView = null;
	private String html = null;
	
	Handler mHandler = new Handler();
	public ParseNewsHTML(String link, Context context, int key) {
		// TODO Auto-generated constructor stub
		this.link = link;
		this.key = key;
		this.context = context;
	}
	
	private void init() throws Exception{
		webView = new WebView(context);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new MyClient());
		//webView.addJavascriptInterface(object, name)
		webView.loadUrl(link);
	}
	
	/*public News getContentNews(Element element){
		
	}*/
	
	private void genk(Element element){
		
	}
	
	class MyClient extends WebViewClient {
		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
				String ht = "javascript:window.droid.print(document.getElementsByTagName('html')[0].innerHTML);";
				webView.loadUrl(ht);
		}
	}
	
    class JIFace {
		public void print(String data) {
			html ="<html>"+data+"</html>";
		}
	}
}
