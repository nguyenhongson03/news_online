package son.app.parse;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import son.app.model.News;
import son.app.util.Variables;

public class ParseNewsHTML {
	private String newspaper;
	private int category;
	
	private int indexNewspaper;
	private int key;
	
	public ParseNewsHTML(String newspaper, int category) {
		// TODO Auto-generated constructor stub
		this.newspaper = newspaper;
		this.category = category;
		
		indexNewspaper = Variables.newspaperLocation.get(newspaper);
		key = indexNewspaper*20 + category;
	}
	
	public void getData () throws Exception {
		Document doc = Jsoup.parse(getInputStream(), "UTF-8", "");
		getListNews(doc);

	}
	
	private InputStream getInputStream () throws Exception {
		URL url = new URL(getURL());
		HttpURLConnection connect = (HttpURLConnection) url.openConnection();
		
		connect.setReadTimeout(30*1000);
		connect.setRequestProperty("User-Agent", "Mozilla/5.0 (Android; Mobile; rv:21.0) Gecko/21.0 Firefox/21.0");
		Log.i("link", connect.getURL().toString());
		return connect.getInputStream();
	}
	
	private void getListNews (Document doc) {
		switch (indexNewspaper) {
		case 0:
			vnexpress(doc);
			break;
		case 1:
			dantri(doc);
			break;
		case 2:
			vietnamnet(doc);
			break;
		case 3: 
			haitugio(doc);
			break;
		case 4:
			laodong(doc);
			break;
		case 5:
			nld(doc);
			break;
		case 6:
			xahoi(doc);
			break;
		case 7:
			giaoduc(doc);
			break;
		case 8:
			soha(doc);
			break;
		case 9: 
			infonet(doc);
			break;
		case 10:
			kenh14(doc);
			break;
		case 11:
			tiin(doc);
			break;
		case 12:
			tosao(doc);
			break;
		case 13:
			xzone(doc);
			break;
		case 14:
			congly(doc);
			break;
		case 15:
			khoahoc(doc);
			break;
		case 16:
			thiennhien(doc);
			break;
		case 17:
			genk(doc);
			break;
		case 18:
			cafeauto(doc);
			break;
		case 19:
			autopro(doc);
			break;
		case 20:
			autodaily(doc);
			break;
		case 21:
			cafeland(doc);
			break;
		case 22:
			cafebiz(doc);
			break;
		case 23:
			cafef(doc);
			break;
		case 24:
			vneconomy(doc);
			break;
		case 25:
			stockbiz(doc);
			break;
		case 26:
			vietstock(doc);
			break;
		case 27:
			dddn(doc);
			break;
		case 28:
			bongda24h(doc);
			break;
		case 29:
			afamily(doc);
			break;
		case 30:
			eva(doc);
			break;
		case 31:
			nguoiduatin(doc);
			break;
		case 32:
			anninhthudo(doc);
			break;
		case 33:
			danviet(doc);
			break;
		case 34:
			ictnews(doc);
			break;
		case 35:
			tuoitre(doc);
			break;
		case 36:
			gamek(doc);
			break;
		case 37:
			kienthuc(doc);
			break;
		case 38:
			ngoisao(doc);
			break;
		default:
			break;
		}
	}
	
	private void genk(Document doc){
		Elements articles = doc.select("a");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String title = article.attr("title");
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void vnexpress(Document doc) {
		Elements articles = doc.select("a.block_image_relative");
		
		for (Element article : articles) {
			Element img = article.select("img").first();
			
			String thumbnail = img.attr("src");
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String title = article.text();
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void dantri(Document doc) {
		Elements articles = doc.select("div.lstItem");
		
		for (Element article : articles) {
			Element img = article.select("img").first();
			Element a = article.select("div.lstitem > a").first();
			
			String thumbnail = img.attr("src");
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String title = a.text();
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void vietnamnet(Document doc) {
		Elements articles = doc.select("div.cateArticleItem");
		
		for (Element article : articles) {
			Element img = article.select("img").first();
			Element a = article.select("p.title > a").first();
			
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String thumbnail = img.attr("src");
			String title = a.attr("title");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void haitugio(Document doc) {
		Elements articles = doc.select("div.tin-anh");
		
		for (int i = 0; i < Variables.ARTICLE_PER_PAGE.get(newspaper);i++) {
			Element a = articles.get(i).select("b > a").first();
			Element img = articles.get(i).select("img").first();
			
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String thumbnail = img.attr("src");
			String title = a.text();
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void laodong(Document doc) {
		Elements articles = doc.select("div.news_item");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.select("a").first().attr("href");
			String thumbnail = article.select("img").first().attr("src");
			String title = article.select("span.title").first().text();
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void nld(Document doc) {
		Elements articles = doc.select("a");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String img = article.select("img").first().attr("src");
			String title = article.select("img").first().attr("alt");
			
			Variables.listNews.get(key).add(new News(title, link, img));
		}
	}
	
	private void xahoi(Document doc) {
		Elements articles = doc.select("a.aitem-boxnew");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String img = article.select("img").first().attr("src");
			String title = article.select("img").first().attr("alt");
			
			Variables.listNews.get(key).add(new News(title, link, img));
		}
	}
	
	private void giaoduc(Document doc) {
		Elements articles = doc.select("li.story");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.select("a").first().attr("href");
			String img = article.select("img").first().attr("src");
			String title = article.select("span.title").first().text();
			
			Variables.listNews.get(key).add(new News(title, link, img));
		}
	}
	
	private void soha(Document doc) {
		Elements articles = doc.select("a");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String title = article.attr("title");
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void infonet (Document doc) {
		Elements articles = doc.select("li");
		
		for (Element article : articles) {
			if (article.select("img").size() == 0)
				article.remove();
		}
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.select("a").first().attr("href");
			String title = article.select("a").text();
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void kenh14(Document doc) {
		Elements articles = doc.select("a");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String title = article.attr("title");
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void tiin (Document doc) {
		Elements articles = doc.select("div.row-sub");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.select("a").first().attr("href");
			String title = article.select("a").first().text();
			String thumbnail = article.select("img").attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void tosao (Document doc) {
		Elements articles = doc.select("table");
		
		for (int i = 2;i < 22;i++) {
			String link = Variables.linkNewspaper.get(newspaper) + articles.get(i).select("a").first().attr("href");
			String title = articles.get(i).select("a").first().attr("alt");
			String thumbnail = articles.get(i).select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void xzone (Document doc) {
		Elements articles = doc.select("a.topic-page-list-item-first");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			Element img = article.select("img").first();
			
			String title = img.attr("title");
			String thumbnail = img.attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void congly (Document doc) {
		Elements articles = doc.select("div.row-1");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.select("a").first().attr("href");
			String title = article.select("a").first().attr("title");
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void khoahoc(Document doc) {
		Elements articles = doc.select("div.list-view > a");
		
		for (Element article :articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String title = article.select("b").first().text();
			String thumbnail = Variables.linkNewspaper.get(newspaper) + article.select("p > img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void thiennhien(Document doc) {
		Elements articles = doc.select("div#content > div");
		
		for (Element article : articles) {
			String img = article.select("img").first().attr("src");
			String link = article.select("a").first().attr("href");
			String title = article.select("h2.post-title").first().text();
			
			Variables.listNews.get(key).add(new News(title, link, img));
		}
	}
	
	private void cafeauto(Document doc) {
		Elements articles = doc.select("div.box-cat-body");
		
		for (Element article : articles) {
			Element a = article.select("a.title-fn").first();
			String link = Variables.linkNewspaper.get(newspaper)  + a.attr("href");
			String thumbnail = article.select("img").first().attr("src");
			String title = a.text();
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void autopro (Document doc) {
		Elements articles = doc.select("li");
		
		for (Element article : articles) {
			Element a = article.select("a").first();
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String title = a.attr("title");
			String thumbnail = a.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void autodaily (Document doc) {
		Elements articles = doc.select("div.item");
		
		for (Element article : articles) {
			Element a = article.select("a").first();
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String title = a.attr("title");
			
			String thumbnail = article.select("img").first().attr("src");
			int start = thumbnail.indexOf("http");
			thumbnail = thumbnail.substring(start);
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void cafeland(Document doc) {
		Elements articles = doc.select("div.item-content");
		
		for (Element article : articles) {
			Element img = article.select("img").first();
			Element a = article.select("a").first();
			
			String thumbnail = img.attr("src");
			String title = a.text();
			String link = a.attr("href");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void cafebiz(Document doc) {
		Elements articles = doc.select("div.newshome").last().select("li");
		
		for (Element article : articles) {
			Element a = article.select("a").first();
			
			String link = a.attr("href");
			String title = a.attr("title");
			
			String thumbnail = null;
			if (article.select("img").size() > 0)
				thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void cafef(Document doc) {
		Elements articles = doc.select("div.item");
		
		for (Element article : articles) {
			Element a = article.select("a").first();
			
			String link = a.attr("href");
			String title = a.attr("title");
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void vneconomy(Document doc) {
		Elements articles = doc.select("li");
		
		for (Element article : articles) {
			Element a = article.select("a").first();
			
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String title = a.select("h2").first().text();
			String thumbnail = a.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void stockbiz(Document doc) {
		Elements articles = doc.select("div.article-item");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.select("a").first().attr("href");
			String title = article.select("span.article-title").first().text();
			String thumbnail = "http://m.stockbiz.vn" + article.select("img").first().attr("src");
			
			int end = thumbnail.lastIndexOf("&");
			thumbnail = thumbnail.substring(0, end);
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void vietstock(Document doc) {
		Elements articles = doc.select("li.acticle_news");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.select("a").first().attr("href");
			String thumbnail = article.select("img").first().attr("src");
			String title = article.select("div.info > h2").first().text();
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void dddn(Document doc) {
		Elements articles = doc.select("a");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String title = article.attr("title");
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void bongda24h(Document doc) {
		Elements articles1 = doc.select("div.articles_form").first().select("div.articles");
		Elements articles2 = doc.select("div.articles_form").first().select("div.articles_alt");
		Log.i("size articles", articles1.size() + " " +articles2.size());
		for (int i = 0; i < 5; i++) {
			String link = Variables.linkNewspaper.get(newspaper) + articles1.get(i).select("a").first().attr("href");
			String img = articles1.get(i).select("img").first().attr("src");
			String title = articles1.get(i).text();
			
			int start = img.indexOf("http");
			img = img.substring(start);
			Variables.listNews.get(key).add(new News(title, link, img));
			
			link = Variables.linkNewspaper.get(newspaper) + articles2.get(i).select("a").first().attr("href");
			img = articles2.get(i).select("img").first().attr("src");
			title = articles2.get(i).text();
			
			start = img.indexOf("http");
			img = img.substring(start);
			Variables.listNews.get(key).add(new News(title, link, img));
		}
	}
	
	private void afamily(Document doc) {
		Elements articles = doc.select("li");
		
		for (Element article : articles) {
			String link = Variables.linkNewspaper.get(newspaper) +  article.select("a").first().attr("href");
			String title = article.select("a").first().attr("title");
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void eva(Document doc) {
		Elements articles = doc.select("div.tin-anh");
		
		for (int i = 0;i < Variables.ARTICLE_PER_PAGE.get(newspaper);i++){
			String link = Variables.linkNewspaper.get(newspaper) + articles.get(i).select("a").first().attr("href");
			String title = articles.get(i).select("img").first().attr("alt");
			String thumbnail = articles.get(i).select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void nguoiduatin(Document doc) {
		Elements articles = doc.select("ul.list-news > li");
		
		for (Element article : articles) {
			if (article.select("a.pkg").size() > 0) {
				String link = article.select("a").first().attr("href");
				String thumbnail = article.select("img").first().attr("src");
				String title = article.select("img").first().attr("alt");
				
				Variables.listNews.get(key).add(new News(title, link, thumbnail));
			}
		}
	}
	
	private void anninhthudo(Document doc) {
		Elements articles = doc.select("div.contentlist > ul").first().select("li");
		
		for (Element article : articles) {
			String title = null;
			String thumbnail = null;
			String link = null;
			
			Element a = article.select("a.headline").first();
			title = a.text();
			link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			
			if (article.select("img").size() > 0)
				thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
			
		}
	}
	
	private void danviet(Document doc) {
		Elements articles = doc.select("table");
		
		for (int i = 1; i < 21;i++) {
			Element a = articles.get(i).select("a").first();
			Element img = a.select("img").first();
			
			String title = a.attr("title");
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String thumbnail = null;
			if (img != null)
				thumbnail = img.attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	/*private void thanhnien(Document doc) {
		Elements articles = doc.select("a.boxlink");
		Log.i("thanhnien size", articles.size() + "");
		for (Element article : articles) {
			String title = article.select("h1").first().toString();
			String link = article.attr("href");
			String thumbnail = article.select("img").first().attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}*/
	
	private void ictnews(Document doc) {
		Elements articles = doc.select("div.top-news");
		
		for (Element article : articles) {
			Element a = article.select("a").first();
			Element img = a.select("img").first();
			
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String thumbnail = img.attr("src");
			String title = img.attr("title");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void tuoitre(Document doc) {
		Elements articles = doc.select("div.item");
		
		for (Element article : articles) {
			Element a = article.select("a.title").first();
			
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String title = a.text();
			
			if (article.select("img").size() > 0) {
				String thumbnail = article.select("img").first().attr("src");
				Variables.listNews.get(key).add(new News(title, link, thumbnail));
			} else
				Variables.listNews.get(key).add(new News(title, link, null));
		}
	}
	
	private void gamek(Document doc) {
		Elements articles = doc.select("a");
		
		for (Element article : articles) {
			Element img = article.select("img").first();
			
			String title = article.attr("title");
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String thumbnail = img.attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void kienthuc(Document doc) {
		Elements articles = doc.select("ul.list-news > li");
		
		for (Element article : articles) {
			Element a = article.select("a").first();
			Element img = article.select("img").first();
			
			String title = a.attr("title");
			String link = Variables.linkNewspaper.get(newspaper) + a.attr("href");
			String thumbnail = img.attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	private void ngoisao(Document doc) {
		Elements articles = doc.select("a.aitem-boxnew");
		
		for (Element article : articles) {
			Element img = article.select("img").first();
			
			String link = Variables.linkNewspaper.get(newspaper) + article.attr("href");
			String title = img.attr("alt");
			String thumbnail = img.attr("src");
			
			Variables.listNews.get(key).add(new News(title, link, thumbnail));
		}
	}
	
	
	private String getURL () {
		String baseLink = Variables.NEWSPAPER_LINK[indexNewspaper][category];
		int page = Variables.listNews.get(key).size()/Variables.ARTICLE_PER_PAGE.get(newspaper) + 1;
		switch (indexNewspaper) {
		case 0: //vnexpress
			//create link 
			int start = baseLink.lastIndexOf("p");
			baseLink = baseLink.substring(0, start + 1) + Integer.toString(page) + baseLink.substring(start + 2, baseLink.length());
			return baseLink;
		case 1: //dantri
			return baseLink + page + ".htm";
		case 2: // vietnamnet
			return baseLink + "trang" + page + "/";
		case 3: //24h
			return baseLink + Variables.listNews.get(key).size();
		case 4: //laodong
			return baseLink + page;
		case 5: //nld
			return baseLink + page;
		case 6: //xahoi
			return baseLink + page;
		case 7: //giaoduc
			return baseLink + page;
		case 8: //soha
			return baseLink + page;
		case 9: //infonet
			return baseLink + page;
		case 10: //kenh14
			return baseLink + page;
		case 11: //tiin
			return baseLink + page;
		case 12: //2sao
			return baseLink + "trang-" + page + ".vnn";
		case 13: //xzone
			return baseLink + page + "/";
		case 14: //congly
			return baseLink + page;
		case 15: //khoahoc
			return baseLink + page;
		case 16: //thiennhien
			return baseLink + page + "/";
		case 17: //genk
			return baseLink + page;
		case 18: //cafeauto
			return baseLink + page + "/";
		case 19: //autopro
			return baseLink + page;
		case 20: //autodaily
			return baseLink + page + ".html";
		case 21: //cafeland
			return baseLink + (page - 1);
		case 22: //cafebiz
			return baseLink + page + ".chn";
		case 23: //cafef
			return baseLink + page;
		case 24: //vneconomy
			return baseLink + page;
		case 25: //stockbiz
			return baseLink + page;
		case 26: //vietstock
			return baseLink + page;
		case 27: //dddn
			return baseLink + page;
		case 28: //bongda24h
			return baseLink + page;
		case 29: //afamily
			return baseLink + page;
		case 30: //eva
			return baseLink + page;
		case 31: //nguoiduatin
			return baseLink + page;
		case 32: //anninhthudo
			return baseLink + page;
		case 33: //danviet
			return baseLink + page + ".htm";
		case 34: //ictnews
			return baseLink + page;
		case 35: //tuoitre
			return baseLink + page;
		case 36: //gamek
			return baseLink + page;
		case 37: //kienthuc
			return baseLink + page;
		case 38: //ngoisao
			return baseLink + page;
		default:
			return null;
		}
	}
}
