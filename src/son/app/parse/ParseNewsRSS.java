package son.app.parse;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.w3c.dom.NodeList;

import android.content.Context;
import android.util.Log;

import son.app.model.News;
import son.app.util.Variables;

public class ParseNewsRSS{
	private String linkRss;
	private int key;
	private String description;
	private String linkImage = null;
	private NodeList list;
	
	public ParseNewsRSS(String linkRss, int key) throws Exception{
		// TODO Auto-generated constructor stub
		this.linkRss = linkRss;
		this.key = key;
		init();
	}
	
	private void init() throws Exception{
		
		URL url = new URL(linkRss);
		HttpURLConnection connect = (HttpURLConnection) url.openConnection();
		connect.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:21.0) Gecko/20100101 Firefox/21.0");
		connect.setReadTimeout(1000*15);
		connect.connect();
		InputStream in = connect.getInputStream();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document doc = builder.parse(in);
		
		list = doc.getElementsByTagName("item");
	}
	
	public News getItemNews(int i){	
		linkImage = null;
		org.w3c.dom.Element element = (org.w3c.dom.Element)list.item(i);
		
		String title = element.getElementsByTagName("title").item(0).getTextContent();
		String link = element.getElementsByTagName("link").item(0).getTextContent();
		link = fixLinkNews(link);
		
		if (element.getElementsByTagName("description").item(0) != null )
			description = element.getElementsByTagName("description").item(0).getTextContent();
		String date;
		if (element.getElementsByTagName("pubdate").getLength() > 0)
			date = element.getElementsByTagName("pubdate").item(0).getTextContent();
		else 
			date = element.getElementsByTagName("pubDate").item(0).getTextContent();
		
		getImageAndDescription(Jsoup.parse(description));
		
		if (linkImage != null)
			Log.i("image", linkImage);
		
		String content = null;
		return new News(title, date, link, linkImage, description, content);
		
	}
	
	private String fixLinkNews(String link){
		//Log.i("newspaper", key/20 + "");
		String newspaper = Variables.newspaper[key/20];
		
		if (newspaper.equals("stockbiz"))
			return fixLinkStockbiz(link);
		else if (newspaper.equals("bongdaplus"))
			return fixLinkBongdaplus(link);
		else if (newspaper.equals("nguoilaodong"))
			return fixLinkNdl(link);
			return link;
	}
	
	private String fixLinkStockbiz(String link){
		int end = link.lastIndexOf("/");
		int start = link.lastIndexOf("/", end - 1);
		
		String id = link.substring(start + 1, end);
		
		return "http://m.stockbiz.vn/NewsDetail.aspx?NewsID=" + id;
		
	}
	
	private String fixLinkBongdaplus(String link){
		int end = link.lastIndexOf(".");
		int start = link.lastIndexOf("/", end);
		
		String id = link.substring(start + 1, end);
		
		return "http://m.bongdaplus.vn/Story.aspx?sid=" + id;
	}
	
	private String fixLinkNdl(String link){
		int start = link.indexOf("//");
		return link.substring(0, start + 2) + "m." + link.substring(start + 2, link.length());
	}
	
	public int getSizeList(){
		return list.getLength();
	}
	
	private void getImageAndDescription(Element element){
		Elements images = element.select("img");
		if (images != null)
			for (Element image : images)
				if (!image.attr("src").startsWith("http"))
					image.attr("src", Variables.linkNewspaper.get(Variables.newspaper[key/20]) + image.attr("src"));
		
		FormattingVisitor fomatter = new FormattingVisitor();
		NodeTraversor traversor = new NodeTraversor(fomatter);
		traversor.traverse(element);
		
		description = fomatter.toString();
		
	}
	
	private class FormattingVisitor implements NodeVisitor {
        private static final int maxWidth = 80;
        private int width = 0;
        private StringBuilder accum = new StringBuilder(); // holds the accumulated text

        // hit when the node is first seen
        public void head(Node node, int depth) {
            if (node instanceof TextNode) {
            	append(((TextNode) node).text()); // TextNodes carry all user-readable text in the DOM.
            } 
        }

        // hit when all of the node's children (if any) have been visited
        public void tail(Node node, int depth) {
            String name = node.nodeName();
            
            if (name.equals("br"))
                append("");
            else if (StringUtil.in(name, "p", "h1", "h2", "h3", "h4", "h5"))
                append("");
            else if (name.equals("img"))
                	if (linkImage == null ){
                		linkImage = node.absUrl("src");
                	}
        }

        // appends text to the string builder with a simple word wrap method
        private void append(String text) {
            if (text.startsWith("\n"))
                width = 0; // reset counter if starts with a newline. only from formats above, not in natural text
            if (text.equals(" ") &&
                    (accum.length() == 0 || StringUtil.in(accum.substring(accum.length() - 1), " ", "\n")))
                return; // don't accumulate long runs of empty spaces

            if (text.length() + width > maxWidth) { // won't fit, needs to wrap
                String words[] = text.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    boolean last = i == words.length - 1;
                    if (!last) // insert a space if not the last word
                        word = word + " ";
                    if (word.length() + width > maxWidth) { // wrap and reset counter
                        accum.append("\n").append(word);
                        width = word.length();
                    } else {
                        accum.append(word);
                        width += word.length();
                    }
                }
            } else { // fits as is, without need to wrap text
                accum.append(text);
                width += text.length();
            }
        }

        public String toString() {
            return accum.toString();
        }
    }
}