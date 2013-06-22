package son.app.parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import son.app.util.Variables;

import android.content.Context;
import android.util.Log;

public class ParseContentHTML {
	private String newspaper;
	private Context context;
	private int key;
	private String link;
	
	
	public ParseContentHTML(String link, Context context, int key) {
		// TODO Auto-generated constructor stub
		this.newspaper = Variables.newspaper[key/20];
		this.context = context;
		this.key = key;
		this.link = link;
	}
	
	public String getContentView() throws Exception{
		InputStream in = null;
		if (newspaper.equals("anninhthegioi") || 
				newspaper.equals("congannhandan") ||
				newspaper.equals("anninhthegioi_ct") ||
				newspaper.equals("canhsattoancau") ||
				newspaper.equals("vannghecongan")){
			HttpGet httpGet = new HttpGet(link);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(httpGet);
			in = response.getEntity().getContent();
		} else {
			URL url = new URL(link);
			Log.i("link", link);
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			
			connect.setReadTimeout(20*1000); //20s
			
			connect.setRequestProperty("User-Agent", "Mozilla/5.0 (Android; Mobile; rv:21.0) Gecko/21.0 Firefox/21.0");
			
			in = connect.getInputStream();
		}
		
		Document doc = Jsoup.parse(in, "UTF-8", "");
		
		Elements scriptHead = doc.select("head > script");
		Elements scriptBody = doc.select("body > script");
		
		String classContent = getNewspaperContentClass();
		Elements elements = null;
		String content = null;
		
		if (classContent != null )
			elements = doc.getElementsByClass(classContent);
		
		if (elements != null && elements.size() > 0 ){
			Log.i("element size", elements.size() + "");
			Element element = checkLink(elements.first());
			content = "<html><head>" + scriptHead.toString() + readCSS() + "</head><body>" + scriptBody + normalizeContent(element).toString() + "</body></html>";
		} else if (getNewspaperContentId() != null){
			Element element = doc.getElementById(getNewspaperContentId());
			Log.i("id", getNewspaperContentId());
			
			element = checkLink(element);
			content = "<html><head>" + scriptHead.toString() + readCSS() + "</head><body>"+ scriptBody + normalizeContent(element).toString() + "</body></html>";
			
		} else {
			content = "<html><head>" + scriptHead.toString() + readCSS() + "</head><body>"+ scriptBody + normalizeContent(doc).toString() + "</body></html>";
		}
		return removeSize(removeAttrHeight(removeAttrStyle(removeMaxWidthImage(removeAttrWidth(content)))));
	}
	
	private String readCSS(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("css/webpage.css")));
			StringBuilder css = new StringBuilder();
			
			String temp = "";
			while((temp = reader.readLine()) != null)
				css.append(temp);
			
			reader.close();
			return css.toString();
		} catch (Exception e){
			Log.i("error", "error read file from asset");
		} 
		
		return "";
	}
	
	
	private Element checkLink(Element element){
		if (Variables.linkNewspaper.get(newspaper) != null){
			
			Elements allImage = element.select("img");
			
			for (Element image : allImage)
				if (!image.attr("src").startsWith("http"))
					image.attr("src", Variables.linkNewspaper.get(newspaper) + image.attr("src"));
			
			Elements links = element.select("a");
			
			for (Element link : links)
				if (!link.attr("href").startsWith("http")){
					
					link.attr("href", Variables.linkNewspaper.get(newspaper) + link.attr("href"));
					
				}
		}
		
		return element;
	}
	
	private Element normalizeContent(Element element){
		
		if (newspaper.equals("vnexpress"))
			return vnexpress(element);
		else if (newspaper.equals("tuoitre"))
			return tuoitre(element);
		else if (newspaper.equals("24h"))
			return haitugio(element);
		else if (newspaper.equals("vtc"))
			return vtc(element);
		else if (newspaper.equals("vietnamnet"))
			return vietnamnet(element);
		else if (newspaper.equals("xahoi"))
			return xahoi(element);
		else if (newspaper.equals("dulichvietnam"))
			return dulichvietnam(element);
		else if (newspaper.equals("vietbao"))
			return vietbao(element);
		else if (newspaper.equals("thongtincongnghe"))
			return thongtincongnghe(element);
		else if (newspaper.equals("ictnews"))
			return ictnews(element);
		else if (newspaper.equals("zing"))
			return zing(element);
		else if (newspaper.equals("afamily"))
			return afamily(element);
		else if (newspaper.equals("giadinh"))
			return giadinh(element);
		else if (newspaper.equals("eva"))
			return eva(element);
		else if (newspaper.equals("cafef"))
			return cafef(element);
		else if (newspaper.equals("thesaigontimes"))
			return thesaigontimes(element);
		else if (newspaper.equals("autopro"))
			return autopro(element);
		else if (newspaper.equals("anninhthudo"))
			return anninhthudo(element);
		else if (newspaper.equals("phapluattp"))
			return phapluattp(element);
		else if (newspaper.equals("giaoduc"))
			return giaoduc(element);
		else if (newspaper.equals("giaoducthoidai"))
			return giaoducthoidai(element);
		else if (newspaper.equals("bongda24h"))
			return bongda24h(element);
		else if (newspaper.equals("bongdaplus"))
			return bongdaplus(element);
		else if (newspaper.equals("stockbiz"))
			return stockbiz(element);
		else if (newspaper.equals("cafeauto"))
			return cafeauto(element);
		else if (newspaper.equals("anninhthegioi"))
			return anninhthegioi(element);
		else if (newspaper.equals("congannhandan"))
			return congannhandan(element);
		else if (newspaper.equals("anninhthegioi_ct"))
			return anninhthegioi(element);
		else if (newspaper.equals("canhsattoancau"))
			return anninhthegioi(element);
		else if (newspaper.equals("vannghecongan"))
			return anninhthegioi(element);
		else if (newspaper.equals("nguoiduatin"))
			return nguoiduatin(element);
		else if (newspaper.equals("nguoilaodong"))
			return nguoilaodong(element);
			return element;
	}
	
	private Element vnexpress(Element element){
		if (element.select("div.title_news") != null)
			element.select("div.title_news").remove();
		if (element.select("div.overflow_hidden") != null)
			element.select("div.overflow_hidden").remove();
		Elements allLink = element.select("a");
		if (allLink != null){
			allLink.remove();
		}
		
		return element;
	}
	
	private Element tuoitre(Element element){
		if (element.select("div.colitemdetailNewsLeft") != null)
			element.select("div.colitemdetailNewsLeft").remove();
		if (element.select("div.fLeft") != null )
			element.select("div.fLeft").remove();
		if (element.select("div.boxComment") != null )
			element.select("div.boxComment").remove();
		if (element.select("div.bderBtom") != null )
			element.select("div.bderBtom").remove();
		for (Element item : element.select("div.pad10"))
			item.remove();
		for (Element item : element.select("div.clearfix"))
			item.remove();
		
		return element;
	}
	
	private Element nguoiduatin(Element element){
		if (element.select("a") != null)
			element.select("a").remove();
		
		return element;
	}
	
	private Element haitugio(Element element){
		if (element.select("div.bv-date") != null)
			element.select("div.bv-date").remove();
		if (element.select("span.bv-tieude") != null)
			element.select("span.bv-tieude").remove();
		if (element.select("img.img-thumb") != null)
			element.select("img.img-thumb").remove();
			return element;
	}
	
	private Element vietnamnet(Element element){
		Elements item = element.select("img[src$=.gif]");
		
		if (item != null)
			item.remove();
		
		return element;
	}
	
	private Element vietbao(Element element){
		if (element.select("div.tag") != null)
			element.select("div.tag").remove();
		if (element.select("h1") != null)
			element.select("h1").remove();
		
		return element;
	}
	
	private Element xahoi(Element element){
		for(Element item : element.select("a.more-re"))
			item.remove();
		return element;
	}
	
	
	private Element vtc(Element element){
		for (Element item : element.select("a.tinlienquan"))
			item.remove();
		return element;
	}
	
	private Element dulichvietnam(Element element){
		if (element.select("div.linklq") != null)
			element.select("div.linklq").remove();
		if (element.select("h1.title_news") != null)
			element.select("h1.title_news").remove();
		if (element.select("p.date") != null)
			element.select("p.date").remove();
		return element;
	}
	
	private Element thongtincongnghe(Element element){
		if (element.select("div#widget-node-48958") != null)
			element.select("div#widget-node-48958").remove();
		
		return element;
	}
	
	private Element ictnews(Element element){
		for (Element item : element.select("span > a"))
			item.remove();
		for (Element item : element.select("p > a"))
			item.remove();
		return element;
	}
	
	private Element zing(Element element){
		if (element.select("h1.pTitle") != null)
			element.select("h1.pTitle").remove();
		
		if (element.select("ul.share_buttons") != null)
			element.select("ul.share_buttons").remove();
		
		if (element.select("div.fb-like") != null)
			element.select("div.fb-like").remove();
		
		if (element.select("tags") != null)
			element.select("div.tags").remove();
		
		if (element.select("div.more_news") != null)
			element.select("div.more_news").remove();
		
		if (element.select("iframe") != null)
			element.select("iframe").remove();
		
		if (element.select("script") != null)
			element.select("script").remove();
		return element;
	}
	
	private Element giadinh(Element element){
		if (element.select("div > h1") != null)
			element.select("div > h1").remove();
		
		if (element.select("p.time") != null)
			element.select("p.time").remove();
		
		return element;
	}
	
	private Element afamily(Element element){
		if (element.select("span.chudett") != null)
			element.select("span.chudett").remove();
		
		if (element.select("div > h1") != null)
			element.select("div > h1").remove();
		
		if (element.select("span.date") != null)
			element.select("span.date").remove();
		
		return element;
	}
	
	private Element eva(Element element){
		if (element.select("div > h1") != null)
			element.select("div > h1").remove();
		
		if (element.select("div.sukien2") != null)
			element.select("div.sukien2").remove();
		
		if (element.select("div.bv-date") != null)
			element.select("div.bv-date").remove();
		
		if (element.select("div > a") != null)
			element.select("div > a").remove();
		
		if (element.select("p > a") != null)
			element.select("p > a").remove();
		return element;
	}
	
	private Element cafef(Element element){
		if (element.select("div.share") != null)
			element.select("div.share").remove();
		
		if (element.select("div#fb-root") != null)
			element.select("div#fb-root").remove();
		
		if (element.select("div.tags") != null)
			element.select("div.tags").remove();
		
		if (element.select("div > h1") != null)
			element.select("div > h1").remove();
		
		if (element.select("div > span") != null)
			element.select("div > span").remove();
		if (element.select("div > img") != null)
			element.select("div > img").remove();
		
		return element;
	}
	
	private Element thesaigontimes(Element element){
		if (element.select("p.SGTOTitle") != null)
			element.select("p.SGTOTitle").remove();
		if (element.select("p.SGTOAuthor") != null)
			element.select("p.SGTOAuthor").remove();
		if (element.select("p.SGTOContent") != null)
			element.select("p.SGTOContent").remove();
		
		if (element.select("td.sgtoimageleft") != null)
			element.select("td.sgtoimageleft").remove();
		return element;
	}
	
	private Element autopro(Element element){
		if (element.select("div > h1") != null)
			element.select("div > h1").remove();
		if (element.select("div.tags-box") != null)
			element.select("div.tags-box").remove();
		return element;
	}
	
	private Element anninhthudo(Element element){
		if (element.select("span.subtitle") != null)
			element.select("span.subtitle").remove();
		if (element.select("h1.title") != null)
			element.select("h1.title").remove();
		if (element.select("p.adate") != null)
			element.select("p.adate").remove();
		if (element.select("ul.article-link") != null)
			element.select("ul.article-link").remove();
		return element;
	}
	
	private Element phapluattp(Element element){
		if (element.select("div.return") != null)
			element.select("div.return").remove();
		
		if (element.select("div > h1") != null)
			element.select("div > h1").remove();
		
		if (element.select("div > span") != null)
			element.select("div > span").remove();
		
		return element;
	}
	
	private Element giaoduc(Element element){
		if (element.select("ul.related") != null)
			element.select("ul.related").remove();
		if (element.select("div.notebox") != null)
			element.select("div.notebox").remove();
		
		return element;
	}
	
	private Element giaoducthoidai(Element element){
		if (element.select("div.title") != null)
			element.select("div.title").remove();
		if (element.select("div.clear") != null)
			element.select("div.clear").remove();
		
		return element;
	}
	
	private Element bongda24h(Element element){
		if (element.select("div.boxcmt") != null)
			element.select("div.boxcmt").remove();
		if (element.select("td.orther_news") != null)
			element.select("td.orther_news").remove();
		
		if (element.select("div > a") != null)
			element.select("div > a").remove();
		
		if (element.select("td.cate_title") != null)
			element.select("td.cate_title").remove();
		
		if (element.select("h1.news_article_title") != null)
			element.select("h1.news_article_title").remove();
		
		if (element.select("td > font") != null)
			element.select("td > font").remove();
		
		if (element.select("p > b") != null)
			element.select("p > b").remove();
		
		if (element.select("p > a") != null)
			element.select("p > a").remove();
		
		return element;
	}
	
	private Element bongdaplus(Element element){
		if (element.select("span.cls") != null)
			element.select("span.cls").remove();
		if (element.select("div.listhdr") != null)
			element.select("div.listhdr").remove();
		if (element.select("p.date") != null)
			element.select("p.date").remove();
		if (element.select("p.title") != null)
			element.select("p.title").remove();
		if (element.select("div.listzone") != null)
			element.select("div.listzone").remove();
		if (element.select("div.listnews") != null)
			element.select("div.listnews").remove();
		if (element.select("div.keywords") != null)
			element.select("div.keywords").remove();
		if (element.select("div.facebook") != null)
			element.select("div.facebook").remove();
		if (element.select("div.banner") != null)
			element.select("div.banner").remove();
		if (element.select("div > strong") != null)
			element.select("div > strong").remove();
		if (element.select("br") != null)
			element.select("br").remove();
		if (element.select("a > strong") != null)
			element.select("a > strong").remove();
		return element;
	}
	
	private Element stockbiz(Element element){
		if (element.select("span > span") != null)
			element.select("span > span").remove();
		if (element.select("hr") != null)
			element.select("hr").remove();
		return element;
	}
	
	private Element cafeauto(Element element){
		if (element.select("h2.tieude") != null)
			element.select("h2.tieude").remove();
		
		return element;
	}
	
	private Element anninhthegioi(Element element){
		Elements elements =  element.select("body").first().select("p");
		Document doc = Jsoup.parse(elements.toString());
		
		/*if (doc.select("p[align=left]") != null)
			doc.select("p[align=left]").remove();
		if (doc.select("p[align=justify]") != null)
			doc.select("p[align=justify]").remove();*/
		
		return doc;
	}
	
	private Element congannhandan(Element element){
		Elements allSpan = element.select("body").first().select("div > span");
		
		StringBuilder builder = new StringBuilder();
		
		for (Element item : allSpan)
			//if (item.select("span") != null)
				builder.append(item.toString());
		
		Document doc2 = Jsoup.parse(builder.toString());
		
		if (doc2.select("span#lbHeadline") != null)
			doc2.select("span#lbHeadline").remove();
		if (doc2.select("span#lbDate") != null)
			doc2.select("span#lbDate").remove();
		if (doc2.select("span#lbAuthor1") != null)
			doc2.select("span#lbAuthor1").remove();
		if (doc2.select("span.main_abstract > strong") != null)
			doc2.select("span.main_abstract > strong").remove();
		if (doc2.select("span#Footer_lbFooter1") != null)
			doc2.select("span#Footer_lbFooter1").remove();
		if (doc2.select("span#Footer_lbFooter2") != null)
			doc2.select("span#Footer_lbFooter2").remove();
		if (doc2.select("span#Footer_lbFooter3") != null)
			doc2.select("span#Footer_lbFooter3").remove();
		
		return doc2;
	}
	
	private Element nguoilaodong(Element element){
		if (element.select("div > span") != null)
			element.select("div > span").remove();
		if (element.select("div > h1") != null)
			element.select("div > h1").remove();
		if (element.select("div.return") != null)
			element.select("div.return").remove();
		
		return element;
	}
	
	private String removeMaxWidthImage(String source){
		int start  = source.indexOf(".jpg");
		while (source.charAt(start + 4) != '\"'){
			int end = source.indexOf("\"", start);
			source = source.substring(0, start + 4) + source.substring(end, source.length());
			start = source.indexOf(".jpg");
		}
		return source;
	}
	
	private static String removeAttrHeight(String source){
		int start = source.indexOf("height=");
		
		while (start >= 0){
			int end = source.indexOf("\"", start + 8);
			source = source.substring(0, start) + source.substring(end + 1, source.length());
			start = source.indexOf("height=");
		}
		
		return source;
	}
	
	private String removeAttrWidth(String source){
		int start = source.indexOf("width=");
		while (start >= 0){
			int end = source.indexOf("\"", start + 7);
			source = source.substring(0, start) + source.substring(end + 1, source.length());
			start = source.indexOf("width=");
		}
		return source;
	}
	
	private String removeAttrStyle(String source){
		int start = source.indexOf("style=\"");
		while(start >= 0){
			int end = source.indexOf("\"", start + 7);
			source = source.substring(0, start) + source.substring(end + 1, source.length());
			
			start = source.indexOf("style=\"");
		}
		return source;
	}
	
	private String removeSize(String source){
		int start = source.indexOf("size=");
		
		while (start >= 0){
			int end = source.indexOf("\"", start + 6);
			source = source.substring(0, start) + source.substring(end + 1, source.length());
			
			start = source.indexOf("size=");
		}
		
		return source;
	}
	
	public String getNewspaperContentClass(){
		if (newspaper.equals("vnexpress"))
			return "content_block_tin";
		else if (newspaper.equals("dantri"))
			return "news_details";
		else if (newspaper.equals("24h"))
			return "tin-anh";
		else if (newspaper.equals("tinhte"))
			return "messageContent";
		else if (newspaper.equals("tuoitre"))
			return "padT0";
		else if (newspaper.equals("laodong"))
			return "story-body";
		else if (newspaper.equals("xahoi"))
			return "nav-deatailcontent";
		else if (newspaper.equals("nguoilaodong"))
			return "detail";
		else if (newspaper.equals("vietnamnet"))
			return "content";
		else if (newspaper.equals("vietbao"))
			return "textnd";
		else if (newspaper.equals("dulichvietnam"))
			return "detailnews";
		else if (newspaper.equals("tiin"))
			return "news-content";
		else if (newspaper.equals("eva"))
			return "tin-anh";
		else if (newspaper.equals("afamily"))
			return "news-detail";
		else if (newspaper.equals("giadinh"))
			return "detail";
		else if (newspaper.equals("thongtincongnghe"))
			return "node-content";
		else if (newspaper.equals("ictnews"))
			return "content-article";
		else if (newspaper.equals("zing"))
			return "newsdetail_wrapper";
		else if (newspaper.equals("vietstock"))
			return "news_detail";
		else if (newspaper.equals("bongda24h"))
			return "cate_left";
		else if (newspaper.equals("landtoday"))
			return "content";
		else if (newspaper.equals("batdongsan"))
			return "detail-article-content";
		else if (newspaper.equals("giaoduc"))
			return "article";
		else if (newspaper.equals("anninhthudo"))
			return "article";
		else if (newspaper.equals("phapluattp"))
			return "detail";
		else if (newspaper.equals("autopro"))
			return "detail";
		else if (newspaper.equals("bacsigiadinh"))
			return "detail";
		else if (newspaper.equals("stockbiz"))
			return "news_content_container";
		else if (newspaper.equals("nguoiduatin"))
			return "detail";
			return null;
	}
	
	public String getNewspaperContentId(){
		if (newspaper.equals("vtc"))
			return "pageContent";
		else if (newspaper.equals("khoahoc"))
			return "divContent";
		else if (newspaper.equals("nguoiduatin"))
			return "main-detail";
		else if (newspaper.equals("cafef"))
			return "ctl00_mainContent_divContent";
		else if (newspaper.equals("vneconomy"))
			return "ctl00_ContentPlaceHolder1_TinChiTiet1_divBodyTinChiTiet";
		else if (newspaper.equals("thesaigontimes"))
			return "ARTICLEVIEW";
		else if (newspaper.equals("giaoducthoidai"))
			return "detail";
		else if (newspaper.equals("tuoitre"))
			return "divContent";
		else if (newspaper.equals("tiin"))
			return "body-content";
		else if (newspaper.equals("bongdaplus"))
			return "content";
		else if (newspaper.equals("cafeauto"))
			return "entrya";
			return null;
	}
}
