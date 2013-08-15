package son.app.parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
	private String link;
	
	
	public ParseContentHTML(String link, Context context, int key) {
		// TODO Auto-generated constructor stub
		this.newspaper = Variables.newspaper[key/20];
		this.context = context;
		this.link = link;
	}
	
	public String getContent () throws Exception {
		Document doc = Jsoup.parse(getInputStream(), "UTF-8", "");
		
		String content = removeSomeAttr(parserContent(doc));
		
		return "<html><head>" + readCSS() + "</head><body>" + content + "</body></html>";
	}
	
	private String parserContent(Document doc) {
		checkLink(doc);
		
		if (newspaper.equals("vnexpress"))
			return vnexpress(doc);
		else if (newspaper.equals("dantri"))
			return dantri(doc);
		else if (newspaper.equals("vietnamnet"))
			return vietnamnet(doc);
		else if (newspaper.equals("24h"))
			return haitugio(doc);
		else if (newspaper.equals("laodong"))
			return laodong(doc);
		else if (newspaper.equals("nld"))
			return nld(doc);
		else if (newspaper.equals("xahoi"))
			return xahoi(doc);
		else if (newspaper.equals("giaoduc"))
			return giaoduc(doc);
		else if (newspaper.equals("soha"))
			return soha(doc);
		else if (newspaper.equals("infonet"))
			return infonet(doc);
		else if (newspaper.equals("kenh14"))
			return kenh14(doc);
		else if (newspaper.equals("tiin"))
			return tiin(doc);
		else if (newspaper.equals("2sao"))
			return tosao(doc);
		else if (newspaper.equals("xzone"))
			return xzone(doc);
		else if (newspaper.equals("congly"))
			return congly(doc);
		else if (newspaper.equals("khoahoc"))
			return khoahoc(doc);
		else if (newspaper.equals("thiennhien"))
			return thiennhien(doc);
		else if (newspaper.equals("genk"))
			return genk(doc);
		else if (newspaper.equals("cafeauto"))
			return cafeauto(doc);
		else if (newspaper.equals("autopro"))
			return autopro(doc);
		else if (newspaper.equals("autodaily"))
			return autodaily(doc);
		else if (newspaper.equals("cafeland"))
			return cafeland(doc);
		else if (newspaper.equals("cafebiz"))
			return cafebiz(doc);
		else if (newspaper.equals("cafef"))
			return cafef(doc);
		else if (newspaper.equals("vneconomy"))
			return vneconomy(doc);
		else if (newspaper.equals("stockbiz"))
			return stockbiz(doc);
		else if (newspaper.equals("vietstock"))
			return vietstock(doc);
		else if (newspaper.equals("dddn"))
			return dddn(doc);
		else if (newspaper.equals("bongda24h"))
			return bongda24h(doc);
		else if (newspaper.equals("anninhthudo"))
			return anninhthudo(doc);
		else if (newspaper.equals("afamily"))
			return afamily(doc);
		else if (newspaper.equals("eva"))
			return eva(doc);
		else if (newspaper.equals("nguoiduatin"))
			return nguoiduatin(doc);
		else if (newspaper.equals("danviet"))
			return danviet(doc);
		else if (newspaper.equals("thanhnien"))
			return thanhnien(doc);
		else if (newspaper.equals("ictnews"))
			return ictnews(doc);
		else if (newspaper.equals("tuoitre"))
			return tuoitre(doc);
		else if (newspaper.equals("gamek"))
			return gamek(doc);
		else if (newspaper.equals("kienthuc"))
			return kienthuc(doc);
		else 
			return ngoisao(doc);
	}
	
	private InputStream getInputStream() throws Exception {
		URL url = new URL(link);
		HttpURLConnection connect = (HttpURLConnection) url.openConnection();
		
		connect.setReadTimeout(30*1000);
		connect.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_2 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8H7 Safari/6533.18.5");
		
		return connect.getInputStream();
	}
	
	private String vnexpress(Document doc) {
		Element content = doc.select("div.content_block_tin").first();
		Log.i("content", content.toString());
		
		if (content.select("div.title_news").size() > 0)
			content.select("div.title_news").remove();
		if (content.select("div.overflow_hidden").size() > 0)
			content.select("div.overflow_hidden").remove();
		
		return content.toString();
	}
	
	private String dantri(Document doc) {
		Element content = doc.select("div.news_details").first();
		
		return content.toString();
	}
	
	private String vietnamnet(Document doc) {
		Element content = doc.select("div.content").first();
		
		if (content.select("a").size() > 0)
			content.select("a").remove();
		
		return content.toString();
	}
	
	private String haitugio(Document doc) {
		Element content = doc.select("div.tin-anh").first();
		
		if (content.select("img.img-thumb").size() > 0)
			content.select("img.img-thumb").remove();
		if (content.select("span.bv-tieude").size() > 0)
			content.select("span.bv-tieude").remove();
		
		return content.toString();
	}
	
	private String laodong(Document doc) {
		Element header = doc.select("div.story-header").first();
		Element body = doc.select("div.story-body").first();
		
		if (header.select("p.date").size() > 0)
			header.select("p.date").remove();
		
		return header.toString() + body.toString();
	}
	
	private String nld(Document doc) {
		Element content = doc.select("div.detail").first();
		
		if (content.select("div.return").size() > 0)
			content.select("div.return").remove();
		
		return content.toString();
	}
	
	private String xahoi(Document doc) {
		Element content = doc.select("div.nav-deatailcontent").first();
		
		return content.toString();
	}
	
	private String giaoduc(Document doc) {
		Element content = doc.select("div#contents").first();
		
		if (content.select("div.bot5").size() > 0)
			content.select("div.bot5").remove();
		
		if (content.select("ul.related").size() > 0)
			content.select("ul.related").remove();
		
		if (content.select("div.notebox").size() > 0)
			content.select("div.notebox").remove();
		
		return content.toString();
	}
	
	private String soha(Document doc){
		Element content = doc.select("div.detail").first();
		
		if (content.select("ul.rela_news").size() > 0)
			content.select("ul.rela_news").remove();
		
		if (content.select("div.tags-box").size() > 0)
			content.select("div.tags-box").remove();
		
		if (content.select("div.return").size() > 0)
			content.select("div.return").remove();
		
		return content.toString();
	}
	
	private String infonet(Document doc) {
		Element content = doc.select("div.story").first();
		
		if (content.select("div.otherList").size() > 0)
			content.select("div.otherList").remove();
		
		return content.toString();
	}
	
	private String kenh14(Document doc) {
		return doc.select("div.news-detail").toString();
	}
	
	private String tiin(Document doc) {
		Element detail = doc.select("div.news-detail").first();
		Element content = doc.select("div.news-content").first();
		
		return detail.toString() + content.toString();
	}
	
	private String tosao(Document doc) {
		Element title = doc.select("span#Main_NewsDetails1_lblNews_Title").first();
		Element detail = doc.select("span#Main_NewsDetails1_lblNews_InitCont").first();
		Element content = doc.select("span#Main_NewsDetails1_lblNews_Content").first();
		
		StringBuilder contentStr = new StringBuilder();
		
		if (title != null)
			contentStr.append(title.toString());
		if (detail != null)
			contentStr.append(detail.toString());
		if (content != null)
			contentStr.append(content.toString());
		
		return contentStr.toString();
	}
	
	private String xzone(Document doc) {
		Element content = doc.select("span.content-detail-full").first();
		Element title = doc.select("span.short-des").first();
		
		if (content.select("span > strong").size() > 0)
			content.select("span > strong").remove();
		return title.toString() + content.toString();
	}
	
	private String congly(Document doc) {
		return doc.select("div.detail").toString();
	}
	
	private String khoahoc(Document doc) {
		Element content = doc.select("div#maincontent").first();
		
		Elements moreArticle = content.select("p");
		for (Element p : moreArticle)
			if (p.select("a").size() > 0)
				p.remove();
		
		return content.toString();
	}
	
	private String thiennhien(Document doc) {
		Element content = doc.select("div#content").first();
		
		if (content.select("div.sharing-options").size() > 0)
			content.select("div.sharing-options").remove();
		
		return content.toString();
	}
	
	private String genk(Document doc) {
		return doc.select("div.detail").toString();
	}
	
	private String cafeauto(Document doc) {
		return doc.select("div#detail-entry-mobile").toString();
	}
	
	private String autopro(Document doc) {
		Element content = doc.select("div.detail").first();
		
		if (content.select("div.tags-box").size() > 0)
			content.select("div.tags-box").remove();
		
		return content.toString();
	}
	
	private String autodaily(Document doc) {
		Element content = doc.select("article.detail-content").first();
		
		Elements as = content.select("a");
		for (Element a : as) 
			if (a.select("span").size() > 0)
				a.remove();
		
		return content.toString();
	}
	
	private String cafeland(Document doc) {
		return doc.select("div.hienthinoidungchitiet").toString();
	}
	
	private String cafebiz(Document doc) {
		return doc.select("div.newsContent").toString();
	}
	
	private String cafef(Document doc) {
		Element content = doc.select("div.divContentNews").first();
		
		if (content.select("div.share").size() > 0)
			content.select("div.share").remove();
		
		return content.toString();
	}
	
	private String vneconomy(Document doc) {
		return doc.select("div#ctl00_ContentPlaceHolder1_TinChiTiet1_divBodyTinChiTiet").toString();
	}
	
	private String stockbiz(Document doc) {
		Element content = doc.select("div.news_content_container").first();
		
		if (content.select("div[align=right]").size() > 0)
			content.select("div[align=right]").remove();
		return content.toString();
	}
	
	private String vietstock(Document doc) {
		Element content = doc.select("div.detail_content").first();
		
		if (content.select("form").size() > 0)
			content.select("form").remove();
		
		if (content.select("ul.comment").size() > 0)
			content.select("ul.comment").remove();
		
		if (content.select("div.same_news").size() > 0)
			content.select("div.same_news").remove();
		
		return content.toString();
	}
	
	private String dddn(Document doc){
		Element content = doc.select("div.detail").first();
		
		if (content.select("div.share").size() > 0)
			content.select("div.share").remove();
		
		if (content.select("div.return").size() > 0)
			content.select("div.return").remove();
		
		return content.toString();
	}
	
	private String bongda24h(Document doc) {
		Element content = doc.select("div.content").first();
		
		if (content.select("div.weblinks").size() > 0)
			content.select("div.weblinks").remove();
		
		if (content.select("div.article_title").size() > 0)
			content.select("div.article_title").remove();
		
		if (content.select("a").size() > 0)
			content.select("a").remove();
		
		return content.toString();
	}
	
	private String afamily(Document doc) {
		Element content = doc.select("div.news-detail").first();
		
		return content.toString();
	}
	
	private String eva(Document doc) {
		return doc.select("div.tin-anh").first().toString();
	}
	
	private String nguoiduatin(Document doc) {
		Element content = doc.select("div.dtl-content").first();
		
		if (content.select("div#div-gpt-ad-1367940434047-2").size() > 0)
			content.select("div#div-gpt-ad-1367940434047-2").remove();
		if (content.select("div#div-gpt-ad-1367940434047-0").size() > 0)
			content.select("div#div-gpt-ad-1367940434047-0").remove();
		
		if (content.select("ul.small-list").size() > 0)
			content.select("ul.small-list").remove();
		return content.toString();
	}
	
	private String anninhthudo(Document doc) {
		return doc.select("div.story").toString();
	}
	
	private String danviet(Document doc) {
		Element detail = doc.select("span#NewsDetails1_lblNews_InitCont").first();
		Element content = doc.select("span#NewsDetails1_lblNews_Content").first();
		
		return detail.toString() + content.toString();
	}
	
	private String thanhnien(Document doc) {
		return doc.select("div.story-content").toString();
	}
	
	private String ictnews(Document doc) {
		return doc.select("div.mt10").first().toString();
	}
	
	private String tuoitre(Document doc) {
		return doc.select("div#news-body").toString();
	}
	
	private String gamek(Document doc) {
		return doc.select("div.detail-game").toString();
	}
	
	private String kienthuc(Document doc) {
		Element content = doc.select("div.entry-content").first();
		
		if (content.select("ul.content_ref").size() > 0)
			content.select("ul.content_ref").remove();
		
		return content.toString();
	}
	
	private String ngoisao(Document doc) {
		Element content = doc.select("div.nav-deatailcontent").first();
		
		if (content.select("p.more-re").size() > 0)
			content.select("p.more-re").remove();
		if (content.select("a.more-re").size() > 0)
			content.select("a.more-re").remove();
		
		return content.toString();
	}
	
	private String removeSomeAttr(String str){
		return removeSize(removeAttrHeight(removeAttrStyle(removeMaxWidthImage(removeAttrWidth(str)))));
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
}
