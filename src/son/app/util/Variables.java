package son.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.util.SparseArray;

import son.app.model.Category;
import son.app.model.News;
import son.app.newsonline.R;

public class Variables {
	public static final String FACEBOOK_COMMENT = "https://m.facebook.com/plugins/comments.php?channel_url=http%3A%2F%2Fstatic.ak.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D18%23cb%3Dfdaebffac%26relation%3Dparent.parent&colorscheme=light&numposts=10&href=";
	
	public static Map<String, Integer> icons = new HashMap<String, Integer>();
	
	static {
		icons.put("vnexpress", R.drawable.vnexpress);
		icons.put("dantri", R.drawable.dantri);
		icons.put("vietnamnet", R.drawable.vietnamnet);
		icons.put("24h", R.drawable.haitugio);
		icons.put("laodong", R.drawable.laodong);
		icons.put("nld", R.drawable.nguoilaodong);
		icons.put("xahoi", R.drawable.xahoi);
		icons.put("giaoduc", R.drawable.giaoduc);
		icons.put("soha", R.drawable.soha);
		icons.put("infonet", R.drawable.infonet);
		icons.put("kenh14", R.drawable.kenh14);
		icons.put("tiin", R.drawable.tiin);
		icons.put("2sao", R.drawable.tosao);
		icons.put("xzone", R.drawable.xzone);
		icons.put("congly", R.drawable.congly);
		icons.put("khoahoc", R.drawable.khoahoc);
		icons.put("thiennhien", R.drawable.thiennhien);
		icons.put("genk", R.drawable.genk);
		icons.put("cafeauto", R.drawable.cafeauto);
		icons.put("autopro", R.drawable.autopro);
		icons.put("autodaily", R.drawable.autodaily);
		icons.put("cafeland", R.drawable.cafeland);
		icons.put("cafebiz", R.drawable.cafebiz);
		icons.put("cafef", R.drawable.cafef);
		icons.put("vneconomy", R.drawable.vneconomy);
		icons.put("stockbiz", R.drawable.stockbiz);
		icons.put("vietstock", R.drawable.vietstock);
		icons.put("dddn", R.drawable.dddn);
		icons.put("bongda24h", R.drawable.bongda24h);
		icons.put("anninhthudo", R.drawable.anninhthudo);
		icons.put("afamily", R.drawable.afamily);
		icons.put("eva", R.drawable.eva);
		icons.put("nguoiduatin", R.drawable.nguoiduatin);
		icons.put("danviet", R.drawable.danviet);
		icons.put("ictnews", R.drawable.ictnews);
		icons.put("tuoitre", R.drawable.tuoitre);
		icons.put("gamek", R.drawable.gamek);
		icons.put("kienthuc", R.drawable.kienthuc);
		icons.put("hanoimoi", R.drawable.hanoimoi);
		icons.put("tienphong", R.drawable.tienphong);
		icons.put("tinhte", R.drawable.tinhte);
		icons.put("ngoisao", R.drawable.ngoisao);
		icons.put("nguoilaodong", R.drawable.nguoilaodong);
	}
	
	public static HashMap<String, Integer> ICONS_SQUARE = new HashMap<String, Integer>();
	static {
		ICONS_SQUARE.put("vnexpress", R.drawable.s_vnexpress);
		ICONS_SQUARE.put("dantri", R.drawable.s_dantri);
		ICONS_SQUARE.put("vietnamnet", R.drawable.s_vietnamnet);
		ICONS_SQUARE.put("24h", R.drawable.s_24h);
		ICONS_SQUARE.put("laodong", R.drawable.s_laodong);
		ICONS_SQUARE.put("nld", R.drawable.nguoilaodong);
		ICONS_SQUARE.put("xahoi", R.drawable.s_xahoi);
		ICONS_SQUARE.put("giaoduc", R.drawable.s_giaoduc);
		ICONS_SQUARE.put("soha", R.drawable.s_soha);
		ICONS_SQUARE.put("infonet", R.drawable.s_infonet);
		ICONS_SQUARE.put("kenh14", R.drawable.s_kenh14);
		ICONS_SQUARE.put("tiin", R.drawable.s_tiin);
		ICONS_SQUARE.put("2sao", R.drawable.s_2sao);
		ICONS_SQUARE.put("xzone", R.drawable.s_xzone);
		ICONS_SQUARE.put("congly", R.drawable.s_congly);
		ICONS_SQUARE.put("khoahoc", R.drawable.s_khoahoc);
		ICONS_SQUARE.put("thiennhien", R.drawable.s_thiennhien);
		ICONS_SQUARE.put("genk", R.drawable.s_genk);
		ICONS_SQUARE.put("cafeauto", R.drawable.s_cafeauto);
		ICONS_SQUARE.put("autopro", R.drawable.s_autopro);
		ICONS_SQUARE.put("autodaily", R.drawable.s_autodaily);
		ICONS_SQUARE.put("cafeland", R.drawable.s_cafeland);
		ICONS_SQUARE.put("cafebiz", R.drawable.s_cafebiz);
		ICONS_SQUARE.put("cafef", R.drawable.s_cafef);
		ICONS_SQUARE.put("vneconomy", R.drawable.s_vneconomy);
		ICONS_SQUARE.put("stockbiz", R.drawable.s_stockbiz);
		ICONS_SQUARE.put("vietstock", R.drawable.s_vietstock);
		ICONS_SQUARE.put("dddn", R.drawable.s_dddn);
		ICONS_SQUARE.put("bongda24h", R.drawable.s_bongda24h);
		ICONS_SQUARE.put("anninhthudo", R.drawable.s_anninhthudo);
		ICONS_SQUARE.put("afamily", R.drawable.s_afamily);
		ICONS_SQUARE.put("eva", R.drawable.s_eva);
		ICONS_SQUARE.put("nguoiduatin", R.drawable.s_nguoiduatin);
		ICONS_SQUARE.put("danviet", R.drawable.s_danviet);
		ICONS_SQUARE.put("ictnews", R.drawable.s_ictnews);
		ICONS_SQUARE.put("tuoitre", R.drawable.s_tuoitre);
		ICONS_SQUARE.put("gamek", R.drawable.s_gamek);
		ICONS_SQUARE.put("kienthuc", R.drawable.s_kienthuc);
		ICONS_SQUARE.put("hanoimoi", R.drawable.s_hanoimoi);
		ICONS_SQUARE.put("tienphong", R.drawable.s_tienphong);
		ICONS_SQUARE.put("ngoisao", R.drawable.s_ngoisao);

	}
	
	public static HashMap<String, Integer> ARTICLE_PER_PAGE = new HashMap<String, Integer>();
	static {
		ARTICLE_PER_PAGE.put("vnexpress", 10);
		ARTICLE_PER_PAGE.put("dantri", 13);
		ARTICLE_PER_PAGE.put("vietnamnet", 9);
		ARTICLE_PER_PAGE.put("24h", 15);
		ARTICLE_PER_PAGE.put("laodong", 10);
		ARTICLE_PER_PAGE.put("nld", 40);
		ARTICLE_PER_PAGE.put("xahoi", 15);
		ARTICLE_PER_PAGE.put("giaoduc", 20);
		ARTICLE_PER_PAGE.put("soha", 20);
		ARTICLE_PER_PAGE.put("infonet", 6);
		ARTICLE_PER_PAGE.put("kenh14", 20);
		ARTICLE_PER_PAGE.put("tiin", 15);
		ARTICLE_PER_PAGE.put("2sao", 20);
		ARTICLE_PER_PAGE.put("xzone", 10);
		ARTICLE_PER_PAGE.put("congly", 14);
		ARTICLE_PER_PAGE.put("khoahoc", 10);
		ARTICLE_PER_PAGE.put("thiennhien", 10);
		ARTICLE_PER_PAGE.put("genk", 20);
		ARTICLE_PER_PAGE.put("cafeauto", 11);
		ARTICLE_PER_PAGE.put("autopro", 20);
		ARTICLE_PER_PAGE.put("autodaily", 5);
		ARTICLE_PER_PAGE.put("cafeland", 5);
		ARTICLE_PER_PAGE.put("cafebiz", 15);
		ARTICLE_PER_PAGE.put("cafef", 20);
		ARTICLE_PER_PAGE.put("vneconomy", 10);
		ARTICLE_PER_PAGE.put("stockbiz", 10);
		ARTICLE_PER_PAGE.put("vietstock", 13);
		ARTICLE_PER_PAGE.put("dddn", 41);
		ARTICLE_PER_PAGE.put("bongda24h", 10);
		ARTICLE_PER_PAGE.put("afamily", 20);
		ARTICLE_PER_PAGE.put("eva", 15);
		ARTICLE_PER_PAGE.put("nguoiduatin", 20);
		ARTICLE_PER_PAGE.put("anninhthudo", 6);
		ARTICLE_PER_PAGE.put("danviet", 20);
		ARTICLE_PER_PAGE.put("ictnews", 10);
		ARTICLE_PER_PAGE.put("tuoitre", 19);
		ARTICLE_PER_PAGE.put("gamek", 20);
		ARTICLE_PER_PAGE.put("kienthuc", 10);
		ARTICLE_PER_PAGE.put("ngoisao", 20);
	}
	
	public static String TABLE_NEWSPAPER_CHOSE = "newspaper_chose";
	public static String TABLE_NEWSPAPER_OFFLINE = "newspaper_offline";
	public static String TABLE_NEWSPAPER_THUMBNAIL = "newspaper_thumbnail";
	public static String TABLE_NEWS_READ = "news_read";
	
	//public static String[] dulich = {"dulichvietnam"};
	public static String[] congnghe = {"genk", "khoahoc", "thiennhien", "ictnews", "gamek"};
	public static String[] giaitri = {"kenh14", "tiin", "2sao", "xzone", "ngoisao"};
	public static String[] phunu_giadinh = {"eva", "afamily"};
	public static String[] taichinh_kinhdoanh = {"cafef", "cafebiz", "vneconomy", "stockbiz", "vietstock", "dddn"};
	public static String[] batdongsan = {"cafeland"};
	public static String[] oto_xemay = {"autopro", "cafeauto", "autodaily"};
	public static String[] anninh = {"congly", "anninhthudo"};
	public static String[] giaoduc = {"giaoduc"};
	public static String[] tonghop = {"vnexpress", "dantri", "vietnamnet", "24h", "xahoi", "laodong", "infonet", "soha", "nguoiduatin", "tuoitre", "kienthuc", "danviet"};
	public static String[] bongda = {"bongda24h"};
	
	public static ArrayList<Category> ListCategory = new ArrayList<Category>();
	static {
		ListCategory.add(new Category("Tổng hợp", "Tin tức trên nhiều lĩnh vực", tonghop));
		ListCategory.add(new Category("Công nghệ", "Máy tính, Mobile, Khoa học, Game...", congnghe));
		ListCategory.add(new Category("Giải trí", "Showbiz, âm nhạc, phim ảnh",giaitri));
		ListCategory.add(new Category("Phụ nữ - Gia đinh", "Làm đẹp, trẻ em, gia đình...", phunu_giadinh));
		ListCategory.add(new Category("Tài chính - Kinh doanh", "Ngân hàng, chứng khoán, thị trường..",taichinh_kinhdoanh));
		ListCategory.add(new Category("Bất động sản", "Xây dựng, nhà đất, kiến trúc...",batdongsan));
		ListCategory.add(new Category("Ô tô - xe máy", "Chơi xe, động cơ, máy móc...",oto_xemay));
		ListCategory.add(new Category("An ninh", "Vụ an, pháp luật, hình sự",anninh));
		ListCategory.add(new Category("Giáo dục", "Đào tạo, thi cử, học bổng", giaoduc));
		ListCategory.add(new Category("Bóng đá", "Tin tức, trận đấu...",bongda));
	}
	
	public static HashMap<String, Integer> CategoryLocation = new HashMap<String, Integer>();
	static {
		CategoryLocation.put("tonghop", 0);
		CategoryLocation.put("congnghe", 1);
		CategoryLocation.put("giaitri", 2);
		CategoryLocation.put("phunu_giadinh", 3);
		CategoryLocation.put("taichinh_kinhdoanh", 4);
		CategoryLocation.put("batdongsan", 5);
		CategoryLocation.put("oto_xemay", 6);
		CategoryLocation.put("anninh", 7);
		CategoryLocation.put("giaoduc", 8);
		CategoryLocation.put("bongda", 9);
	}
	
	//vnexpress 
	public static final String[] VNEXPRESS_CATEGORY = {"Thế giới", "Pháp luật", "Du lịch", "Số hóa", "Xã hội",
												"Kinh doanh", "Thể thao", "Gia đình", "Khoa học", "Ô tô - Xe máy", "Cười"};
	public static final String[] VNEXPRESS_LINK = {
											"http://m.vnexpress.net/thegioi/the-gioi/1001002/p1/2860104/1",
											"http://m.vnexpress.net/phapluat/phap-luat/1001007/p1/2859891/1",
											"http://m.vnexpress.net/dulich/viet-nam/1003254/p1/2855436/1",
											"http://m.vnexpress.net/sohoa/doi-song-so/1002661/p1/2859618/1",
											"http://m.vnexpress.net/xahoi/xa-hoi/1001005/p1/2860035/1",
											"http://m.vnexpress.net/kinhdoanh/thi-truong/1003165/p1/2859225/1",
											"http://m.vnexpress.net/thethao/trong-nuoc/1002568/p1/2859893/1",
											"http://m.vnexpress.net/giadinh/nhip-song/1003075/p1/2859483/1",
											"http://m.vnexpress.net/khoahoc/khoa-hoc/1001009/p1/2859888/1",
											"http://m.vnexpress.net/oto-xemay/oto-xe-may/1001006/p1/2859644/1",
											"http://m.vnexpress.net/cuoi/cuoi/1001011/p1/2858165/1"};
	
	//dantri 
	public static final String[] DANTRI_CATEGORY = {"Xã hội", "Thế giới", "Thể thao", "Giáo dục - Khuyến học",
											"Tấm lòng nhân ái", "Kinh doanh", "Văn hóa", "Giải trí", "Pháp luật",
											"Nhịp sống trẻ", "Tình yêu - giới tính", "Sức khỏe", "Sức mạnh số", "Ô tô - Xe máy", "Chuyện lạ"};
	public static final String[] DANTRI_LINK  = {
										  "http://m.dantri.com.vn/xa-hoi/trang-",
										  "http://m.dantri.com.vn/the-gioi/trang-",
										  "http://m.dantri.com.vn/the-thao/trang-",
										  "http://m.dantri.com.vn/giao-duc-khuyen-hoc/trang-",
										  "http://m.dantri.com.vn/tam-long-nhan-ai/trang-",
										  "http://m.dantri.com.vn/kinh-doanh/trang-",
										  "http://m.dantri.com.vn/van-hoa/trang-",
										  "http://m.dantri.com.vn/giai-tri/trang-",
										  "http://m.dantri.com.vn/phap-luat/trang-",
										  "http://m.dantri.com.vn/nhip-song-tre/trang-",
										  "http://m.dantri.com.vn/tinh-yeu-gioi-tinh/trang-",
										  "http://m.dantri.com.vn/suc-khoe/trang-",
										  "http://m.dantri.com.vn/suc-manh-so/trang-",
										  "http://m.dantri.com.vn/o-to-xe-may/trang-",
										  "http://m.dantri.com.vn/chuyen-la/trang-",
										  };
	
	//vietnamnet
	public static final String[] VIETNAMNET_CATEGORY = {"Xã hội", "Giáo dục", "Chính trị",
													"Đời sống", "Kinh tế", "Quốc tế", "Văn hóa", "Khoa học",
													"CNTT - Viễn thông", "Bạn đọc"};
	public static final String[] VIETNAMNET_LINK = {
											"http://m.vietnamnet.vn/vn/xa-hoi/",
											"http://m.vietnamnet.vn/vn/giao-duc/",
											"http://m.vietnamnet.vn/vn/chinh-tri/",
											"http://m.vietnamnet.vn/vn/doi-song/",
											"http://m.vietnamnet.vn/vn/kinh-te/",
											"http://m.vietnamnet.vn/vn/quoc-te/",
											"http://m.vietnamnet.vn/vn/van-hoa/",
											"http://m.vietnamnet.vn/vn/khoa-hoc/",
											"http://m.vietnamnet.vn/vn/cong-nghe-thong-tin-vien-thong/",
											"http://m.vietnamnet.vn/vn/cong-nghe-thong-tin-vien-thong/"};
	
	//24h
	public static final String[] HAITUGIO_CATEGORY = {"Thời trang",
												"Thời trang Hitech", "Tài chính - Bất động sản", "Ẩm thực", "Làm đẹp",
												"Phim", "Giáo dục - du học", "Bạn trẻ - cuộc sống", "Ca nhac - MTV",
												"Thể thao", "Phi thường - kỳ quặc", "Công nghệ thông tin", "Ô tô - xe máy",
												"Thị trường - tiêu dùng", "Du lịch", "Sức khỏe đời sống"};
	public static final String[] HAITUGIO_LINK = {
											"http://m.24h.com.vn/thoi-trang-c78.html?start=",
											"http://m.24h.com.vn/thoi-trang-hi-tech-c407.html?start=",
											"http://hn.m.24h.com.vn/tai-chinh-bat-dong-san-c161.html?start=",
											"http://m.24h.com.vn/am-thuc-c460.html?start=",
											"http://m.24h.com.vn/lam-dep-c145.html?start=",
											"http://m.24h.com.vn/phim-c74.html?start=",
											"http://m.24h.com.vn/giao-duc-du-hoc-c216.html?start=",
											"http://m.24h.com.vn/ban-tre-cuoc-song-c64.html?start=",
											"http://m.24h.com.vn/ca-nhac-mtv-c73.html?start=",
											"http://m.24h.com.vn/the-thao-c101.html?start=",
											"http://m.24h.com.vn/phi-thuong-ky-quac-c159.html?start=",
											"http://m.24h.com.vn/cong-nghe-thong-tin-c55.html?start=",
											"http://m.24h.com.vn/o-to-xe-may-c77.html?start=",
											"http://m.24h.com.vn/thi-truong-tieu-dung-c52.html?start=",
											"http://m.24h.com.vn/du-lich-c76.html?start=",
											"http://m.24h.com.vn/suc-khoe-doi-song-c62.html?start=",
											};

	//laodong.com.vn
	public static final String[] LAODONG_CATEGORY = {"Chính trị", "Tấm lòng vàng",
												"Công đoàn", "Thế giới", "Xã hội", "Kinh doanh", "Pháp luật",
												"Thể thao", "Văn hóa", "Sci - Tech", "Bạn đọc"};
	public static final String[] LAODONG_LINK = {
										"http://m.laodong.com.vn/Zone.aspx?z=57&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=83&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=58&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=62&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=59&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=63&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=65&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=60&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=61&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=66&p=",
										"http://m.laodong.com.vn/Zone.aspx?z=75&p="};
	
	//nld.com.vn
	public static final String[] NLD_CATEGORY = {"Trang chủ", "Thời sự trong nước", "Thời sự quốc tế", "Kinh tế",
													"Công đoàn", "Giáo dục", "Pháp luật", "Văn hóa - Giải trí",
													"Thể thao", "Sức khỏe", "Tình yêu - Hôn nhân", "Bạn đọc", "Sức khỏe & dinh dưỡng",
													"Khoa học", "Địa phương"};
	public static final String[] NLD_LINK = {"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?type=1&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1002&newsid=2013080504056739&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1006&newsid=20130805034329750&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1014&newsid=20130805094110187&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1010&newsid=20130804104025267&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1017&newsid=20130804104627312&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1019&newsid=20130805030826424&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1020&newsid=20130805103613236&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1026&newsid=20130805105057401&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1050&newsid=2013080505205687&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1030&newsid=20130805110335171&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1042&newsid=20130805095357677&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1050&newsid=20130805062151349&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1038&newsid=20130803095939169&type=3&page=",
												"http://m.nld.com.vn/Ajax/AjaxListNews.aspx?catid=1201&newsid=2013080504542314&type=3&page="};
	
	//xahoi.com.vn
	public static final String[] XAHOI_CATEGORY = {"An ninh hình sự", "Tin 141", "Tin tức xã hội", "Quốc tế", "Thời trang - làm đẹp",
											"Giải trí", "Bóng đá", "Thể thao", "Giáo dục - du học",
											"Công nghệ", "Thư giãn"};
	public static final String[] XAHOI_LINK = {"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=277&title=an-ninh-hinh-su&cached=1&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=345&title=tin-141&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=80&title=xa-hoi&cached=1&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=5&title=quoc-te&cached=1&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=15&title=thoi-trang&cached=1&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=52&title=giai-tri&cached=1&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=145&title=bong-da&cached=1&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=25&title=the-thao&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=299&title=giao-duc-du-hoc&cached=1&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=166&title=cong-nghe&cached=1&page_no=",
										"http://m.xahoi.com.vn/?app=mobile&page=m_cate&cate_id=60&title=thu-gian&cached=1&page_no="};
	
	//giaoduc.net.vn
	public static final String[] GIAODUC_CATEGORY = {"Trang chủ", "Giáo dục 24h", "Xã hội", "Quốc tế", "Vì khát vọng Việt",
												"Bạn đọc", "Kinh tế", "Du học", "Thể thao", "Văn hóa", "Sức khỏe", "Giáo dục quốc phòng"};
	public static final String[] GIAODUC_LINK = {"http://m.giaoduc.net.vn/?p=",
										"http://m.giaoduc.net.vn/Giao-duc-24h/5.gd?p=",
										"http://m.giaoduc.net.vn/Xa-hoi/15.gd?p=",
										"http://m.giaoduc.net.vn/Quoc-te/16.gd?p=",
										"http://m.giaoduc.net.vn/Vi-khat-vong-Viet/440.gd?p=",
										"http://m.giaoduc.net.vn/Ban-doc/24.gd?p=",
										"http://m.giaoduc.net.vn/Kinh-te/13.gd?p=",
										"http://m.giaoduc.net.vn/Du-hoc/272.gd?p=",
										"http://m.giaoduc.net.vn/The-thao/18.gd?p=",
										"http://m.giaoduc.net.vn/Van-hoa/20.gd?p=",
										"http://m.giaoduc.net.vn/Suc-khoe/11.gd?p=",
										"http://m.giaoduc.net.vn/Giao-duc-Quoc-phong/32.gd?p="};
	
	//soha.vn
	public static final String[] SOHA_CATEGORY = {"Tin mới", "Xã hội", "Quốc tế", "Quân sự", "Pháp luật", "Kinh doanh", "Công nghệ", "Thể thao", "Giải trí",
											"Giới tính", "Đàn ông 360", "Thế giới đó đây", "Cư dân mạng"};
	public static final String[] SOHA_LINK = {"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=0&threadid=0&newsid=0&type=1&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10009&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10030&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10058&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10015&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10019&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10020&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10002&threadid=0&newsid=0&type=6&page=", 
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10001&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10040&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10017&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10078&threadid=0&newsid=0&type=6&page=",
										"http://m.soha.vn/Ajax/AjaxListNews.aspx?catid=10066&threadid=0&newsid=0&type=6&page="};
	
	//infonet
	public static final String[] INFONET_CATEGORY = {"Thời sự", "Xã hội", "Thế giới", "Kinh doanh", "Pháp luật", "Văn hóa", "Giải trí", "Thể thao", "Gia đình",
												"Công nghệ", "Ô tô - Xe máy"};
	public static final String[] INFONET_LINK = {"http://m.infonet.vn/Default.aspx?z=2&p=",
											"http://m.infonet.vn/Default.aspx?z=3&p=",
											"http://m.infonet.vn/Default.aspx?z=5&p=",
											"http://m.infonet.vn/Default.aspx?z=4&p=",
											"http://m.infonet.vn/Default.aspx?z=13&p=",
											"http://m.infonet.vn/Default.aspx?z=1064&p=",
											"http://m.infonet.vn/Default.aspx?z=6&p=",
											"http://m.infonet.vn/Default.aspx?z=7&p=",
											"http://m.infonet.vn/Default.aspx?z=8&p=",
											"http://m.infonet.vn/Default.aspx?z=9&p=",
											"http://m.infonet.vn/Default.aspx?z=1068&p=",
											"http://m.infonet.vn/Default.aspx?z=58&p="};
	
	//kenh14
	public static final String[] KENH14_CATEGORY = {"Tin mới", "Start", "Fashion","Muzik", "Đời sống", "Ciné", "Xã hội", "Sport", "Make by me", "Lạ", "Giới tính",
											"2-Tech", "Khám phá", "Góc trái tim", "Học đường"};
	public static final String[] KENH14_LINK = {"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=0&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=1&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=5&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=3&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=4&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=2&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=142&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=118&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=33&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=44&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=79&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=31&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=114&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=136&page=",
											"http://m.kenh14.vn/Services/AjaxListNew.aspx?catid=47&page="};
	
	//tiin
	public static final String[] TIIN_CATEGORY = {"Phim", "Đẹp", "24H", "Khéo", "Sành", "Sao", "Sống", "Học", "Yêu", "Vui", "Thể", "Chơi", "Ảnh", "Nhạc", "Thiện", "Quà"};
	public static final String[] TIIN_LINK = {"http://tiin.vn/index.php/phim.html?page=",
											 "http://tiin.vn/index.php/dep.html?page=",
											 "http://tiin.vn/index.php/24h.html?page=",
											 "http://tiin.vn/index.php/kheo.html?page=",
											 "http://tiin.vn/index.php/sanh.html?page=",
											 "http://tiin.vn/index.php/sao.html?page=",
											 "http://tiin.vn/index.php/song.html?page=",
											 "http://tiin.vn/index.php/hoc.html?page=",
											 "http://tiin.vn/index.php/yeu.html?page=",
											 "http://tiin.vn/index.php/vui.html?page=",
											 "http://tiin.vn/index.php/the.html?page=",
											 "http://tiin.vn/index.php/choi.html?page=",
											 "http://tiin.vn/index.php/anh.html?page=",
											 "http://tiin.vn/index.php/nhac.html?page=",
											 "http://tiin.vn/index.php/thien.html?page=",
											 "http://tiin.vn/index.php/qua.html?page="};
	
	//2sao
	public static final String[] TOSAO_CATEGORY = {"Sao", "Sự kiện xã hội", "Âm nhạc", "Thời trang", "Điện ảnh", "Đời sống giới trẻ", "Thể thao", "Thể thao", "Chuyện lạ"};
	public static final String[] TOSAO_LINK = {"http://m.2sao.vn/p0c1000/Sao/",
											"http://m.2sao.vn/p0c1048/su-kien-xa-hoi/",
											"http://m.2sao.vn/p0c1001/Am-nhac/",
											"http://m.2sao.vn/p0c1004/thoi-trang/",
											"http://m.2sao.vn/p0c1002/phim/",
											"http://m.2sao.vn/p0c1049/doi-song-gioi-tre/",
											"http://m.2sao.vn/p0c1051/the-thao/",
											"http://m.2sao.vn/p0c1050/cong-nghe/",
											"http://m.2sao.vn/p0c1052/chuyen-la/"};
	
	//xzone
	public static final String[] XZONE_CATEGORY = {"ShowBiz", "Xã hội", "Đời sống", "Sốc và độc", "Hưởng thụ", "Phong thủy", "Đẹp 24/7", "Thế giới teen"};
	public static final String[] XZONE_LINK = {"http://x.xzone.vn/showbiz/",
												"http://x.xzone.vn/xa-hoi/",
												"http://x.xzone.vn/doi-song/",
												"http://x.xzone.vn/soc-doc/",
												"http://x.xzone.vn/huong-thu/", 
												"http://x.xzone.vn/phong-thuy/",
												"http://x.xzone.vn/dep-247/",
												"http://x.xzone.vn/the-gioi-teen/"};
	
	//congly.com.vn
	public static final String[] CONGLY_CATEGORY = {"Thời sự", "Pháp đình", "Phóng sự", "Xã hội", "Văn hóa", "Kinh tế", "Quốc tế", "Công nghệ"};
	public static final String[] CONGLY_LINK = {"http://m.congly.com.vn/?app=news&page=m_cate&cate_id=269&title=thoi-su%2F&page_no=",
												"http://m.congly.com.vn/?app=news&page=m_cate&cate_id=273&title=phap-dinh%2F&page_no=",
												"http://m.congly.com.vn/?app=news&page=m_cate&cate_id=279&title=phong-su%2F&page_no=",
												"http://m.congly.com.vn/?app=news&page=m_cate&cate_id=283&title=xa-hoi%2F&page_no=",
												"http://m.congly.com.vn/?app=news&page=m_cate&cate_id=293&title=van-hoa%2F&page_no=",
												"http://m.congly.com.vn/?app=news&page=m_cate&cate_id=298&title=kinh-te%2F&page_no=",
												"http://m.congly.com.vn/?app=news&page=m_cate&cate_id=303&title=quoc-te%2F&page_no=",
												"http://m.congly.com.vn/?app=news&page=m_cate&cate_id=307&title=cong-nghe%2F&page_no="};
	
	//anninhthudo.vn
	public static final String[] ANNINHTHUDO_CATEGORY = {"Thời sự", "An ninh đời sống", "Xã hội", 
												"Quốc phòng", "Quốc tế", "Kỳ lạ", "Thể thao", "Giải trí", "Kinh doanh",
												"Lối sống", "Ô tô - Xe máy", "Khỏe & đẹp", "Bạn đọc"};
	public static final String[] ANNINHTHUDO_LINK = {"http://m.anninhthudo.vn/Default.aspx?z=3&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=80&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=5&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=163&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=7&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=33&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=9&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=8&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=6&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=69&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=136&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=57&p=",
											"http://m.anninhthudo.vn/Default.aspx?z=13&p="};
	
	//antg.cand.com.vn
	public static final String[] ANNINHTHEGIOI_CATEGORY = {"Sự kiện & bình luận", "Hậu trường", "Kinh tế - Văn hóa - Khoa học", 
													"Hồ sơ mật", "Phóng sự", "Hồ sơ intepol", "Vụ án nổi tiếng", "Tư liệu"};
	public static final String[] ANNINHTHEGIOI_LINK = {"http://antg.cand.com.vn/vi-VN/sukien.rss",
												"http://antg.cand.com.vn/vi-VN/hautruong.rss",
												"http://antg.cand.com.vn/vi-VN/ktvhkh.rss",
												"http://antg.cand.com.vn/vi-VN/hosomat.rss",
												"http://antg.cand.com.vn/vi-VN/phongsu.rss",
												"http://antg.cand.com.vn/vi-VN/hosointepol.rss",
												"http://antg.cand.com.vn/vi-VN/vuan.rss",
												"http://antg.cand.com.vn/vi-VN/tulieu.rss"};
	
	//cand.com.vn
	public static final String[] CONGANNHANDAN_CATEGORY = {"Thời sự", "Xã hội", "Quốc tế", "Kinh tế", "Văn hóa", "Pháp luật",
													"Thể thao", "KH-CN", "Người nổi tiếng", "Nhịp cầu nhân ái", 
													"Tội phạm từ A-Z", "Công an trong lòng nhân dân", "Sự kiện - Bình luận",
													"Thế giới phương tiện", "Phóng sự - Tư liệu", "Sự kiện - Bình luận", "Ý kiến bạn đọc",
													"Giao lưu trực tuyến"};
	public static final String[] CONGANNHANDAN_LINK = {"http://www.cand.com.vn/vi-VN/thoisu.rss",
												"http://www.cand.com.vn/vi-VN/xahoi.rss",
												"http://www.cand.com.vn/vi-VN/quocte.rss",
												"http://www.cand.com.vn/vi-VN/kinhte.rss",
												"http://www.cand.com.vn/vi-VN/vanhoa.rss",
												"http://www.cand.com.vn/vi-VN/phapluat.rss",
												"http://www.cand.com.vn/vi-VN/thethao.rss",
												"http://www.cand.com.vn/vi-VN/khcn.rss",
												"http://www.cand.com.vn/vi-VN/nguoinoitieng.rss",
												"http://www.cand.com.vn/vi-VN/nhanai.rss",
												"http://www.cand.com.vn/vi-VN/toiphama-z.rss",
												"http://www.cand.com.vn/vi-VN/trongmatdan.rss",
												"http://www.cand.com.vn/vi-VN/binhluan.rss",
												"http://www.cand.com.vn/vi-VN/tgptien.rss",
												"http://www.cand.com.vn/vi-VN/phongsu.rss",
												"http://www.cand.com.vn/vi-VN/binhluan.rss",
												"http://www.cand.com.vn/vi-VN/ykienbandoc.rss",
												"http://www.cand.com.vn/vi-VN/giaoluutt.rss"};
	
	//khoahoc.com.vn
	public static final String[] KHOAHOC_CATEGORY = {"Trang chủ", "Công nghệ mới", "Khoa học vũ trụ", "Khoa học máy tính",
											"Phát minh khoa học", "Sinh vật học", "Khảo cổ học", "Y học - cuộc sống",
											"Môi trường", "Đại dương học", "Thế giới động vật", "Ứng dụng", "Khám phá",
											"1001 bí ẩn", "Câu chuyện khoa học", "Công trình khoa học", "Sự kiện khoa học",
											"Thư viện ảnh", "Góc hài hước", "Khoa học & bạn đọc"};
	public static final String[] KHOAHOC_LINK = {"http://www.khoahoc.com.vn/m/?pageid=",
										"http://www.khoahoc.com.vn/m/cong-nghe-moi/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/vu-tru/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/may-tinh/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/phat-minh/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/sinh-vat-hoc/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/khao-co-hoc/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/yhoc/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/moi-truong/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/dai-duong-hoc/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/the-gioi-dong-vat/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/ung-dung/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/kham-pha/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/1001-bi-an/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/cau-chuyen/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/cong-trinh/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/su-kien/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/thu-vien-anh/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/hai-huoc/index.aspx?pageid=",
										"http://www.khoahoc.com.vn/m/ban-doc/index.aspx?pageid="};
	
	//thiennhien.net
	public static final String[] THIENNHIEN_CATEGORY = {"Tin tức", "Tiêu điểm", "Tài nguyên", "Môi trường", "Khoa học công nghệ", "Kinh tế", "Chính sách",
													"Chuyện môi trường"};
	public static final String[] THIENNHIEN_LINK = {"http://www.thiennhien.net/page/",
													"http://www.thiennhien.net/tieu-diem/page/",
													"http://www.thiennhien.net/tai-nguyen/page/",
													"http://www.thiennhien.net/moi-truong/page/",
													"http://www.thiennhien.net/khoa-hoc-cong-nghe/page/", 
													"http://www.thiennhien.net/kinh-te/page/",
													"http://www.thiennhien.net/chinh-sach/page/",
													"http://www.thiennhien.net/chuyen-moi-truong/page/"};
	
	//genk
	public static final String[] GENK_CATEGORY = {"Tin mới", "Điện thoại", "Internet", "Tin ICT", "PC/Đồ chơi số", "Cafe Công nghệ"};
	public static final String[] GENK_LINK = {"http://m.genk.vn/Ajax/AjaxList.aspx?catid=0&type=-1&page=",
											"http://m.genk.vn/Ajax/AjaxList.aspx?catid=187&type=2&page=",
											"http://m.genk.vn/Ajax/AjaxList.aspx?catid=194&type=2&page=",
											"http://m.genk.vn/Ajax/AjaxList.aspx?catid=211&type=2&page=",
											"http://m.genk.vn/Ajax/AjaxList.aspx?catid=188&type=2&page=",
											"http://m.genk.vn/Ajax/AjaxList.aspx?catid=216&type=2&page="};
	//tinhte.vn
	public static final String[] TINHTE_CATEGORY = {"Trang chủ"};
	public static final String[] TINHTE_LINK = {"http://www.tinhte.vn/?page="};
	
	//cafeauto.vn
	public static final String[] CAFEAUTO_CATEGORY = {"Thị trường", "Ô tô", "Xe máy", "Đánh giá", "Khám phá",
												"Đường đua"};
	public static final String[] CAFEAUTO_LINK = {"http://m.cafeauto.vn/thi-truong/page-",
											"http://m.cafeauto.vn/o-to/page-",
											"http://m.cafeauto.vn/xe-may/page-",
											"http://m.cafeauto.vn/danh-gia/page-",
											"http://m.cafeauto.vn/kham-pha/page-",
											"http://m.cafeauto.vn/duong-dua/page-"};
	
	//autopro.com.vn
	public static final String[] AUTOPRO_CATEGORY = {"Trang chủ", "Tin tức", 
											"Đánh giá Ô tô", "Đánh giá xe máy", "Văn hóa xe", "Xem chơi", "Kỹ thuật & tư vấn",
											"Xe máy", "AutoGal"};
	public static final String[] AUTOPRO_LINK = {"http://m.autopro.com.vn/Services/AjaxListNew.aspx?page=",
										"http://m.autopro.com.vn/Services/AjaxList.aspx?catid=24&page=",
										"http://m.autopro.com.vn/Services/AjaxList.aspx?catid=32&page=",
										"http://m.autopro.com.vn/Services/AjaxList.aspx?catid=50&page=",
										"http://m.autopro.com.vn/Services/AjaxList.aspx?catid=22&page=",
										"http://m.autopro.com.vn/Services/AjaxList.aspx?catid=31&page=",
										"http://m.autopro.com.vn/Services/AjaxList.aspx?catid=49&page=",
										"http://m.autopro.com.vn/Services/AjaxList.aspx?catid=47&page=",
										"http://m.autopro.com.vn/Services/AjaxDSAutoGal.aspx?page="};
	
	//autodaily
	public static final String[] AUTODAILY_CATEGORY = {"Tin tức", "Đánh giá", "Tư vấn", "Xe mới", "Chuyên đề"};
	public static final String[] AUTODAILY_LINK = {"http://m.autodaily.vn/w/chu-de/tin-tuc-9-",
											"http://m.autodaily.vn/w/chu-de/danh-gia-6-",
											"http://m.autodaily.vn/w/chu-de/tu-van-15-",
											"http://m.autodaily.vn/w/chu-de/xe-moi-3-",
											"http://m.autodaily.vn/w/chu-de/chuyen-de-12-"};
	
	//cafeland
	public static final String[] CAFELAND_CATEGORY = {"Thị trường", "Dự án mới", "Sự kiện", "Phân tích - Nhận định", "Cẩm nang - Xu hướng"};
	public static final String[] CAFELAND_LINK = {"http://m.cafeland.vn/inc/tintuc-more.php?_=1375764066325&theloai_id=1&pagenow=",
												"http://m.cafeland.vn/inc/duan-more.php?_=1375764307666&pagenow=",
												"http://m.cafeland.vn/inc/tintuc-more.php?_=1375764403264&theloai_id=2&pagenow=",
												"http://m.cafeland.vn/inc/tintuc-more.php?_=1375764403264&theloai_id=3&pagenow=",
												"http://m.cafeland.vn/inc/tintuc-more.php?_=1375764403264&theloai_id=4&pagenow="};
	
	//cafebiz
	public static final String[] CAFEBIZ_CATEGORY = {"Tin mới", "Thị trường", "Xu hướng công nghệ", "Câu truyện kinh doanh", "Life Style", "Nhân vật", "Pháp luật"};
	public static final String[] CAFEBIZ_LINK = {"http://m.cafebiz.vn/latest-news/",                  //n.chn
												"http://m.cafebiz.vn/catlist/101/",
												"http://m.cafebiz.vn/catlist/49/",
												"http://m.cafebiz.vn/catlist/47/",
												"http://m.cafebiz.vn/catlist/50/",
												"http://m.cafebiz.vn/catlist/48/",
												"http://m.cafebiz.vn/catlist/60/"};
	
	//cafeF.vn
	public static final String[] CAFEF_CATEGORY = {"Tin mới", "Thị trường chứng khoán", "Bất động sản",
											"Doanh nghiệp", "Tài chính - ngân hàng", "Tài chính quốc tế", "Kinh tế vĩ mô",
											"Hàng hóa - Nguyên liệu"};
	public static final String[] CAFEF_LINK = {"http://m.cafef.vn/v2/ajax/tinmoi.aspx?cat_id=-101&isapi=False&pageindex=",
										"http://m.cafef.vn/v2/ajax/newslist.aspx?isapi=False&cat_id=31&pageindex=",
										"http://m.cafef.vn/v2/ajax/newslist.aspx?isapi=False&cat_id=35&pageindex=",
										"http://m.cafef.vn/v2/ajax/newslist.aspx?isapi=False&cat_id=36&pageindex=",
										"http://m.cafef.vn/v2/ajax/newslist.aspx?isapi=False&cat_id=34&pageindex=",
										"http://m.cafef.vn/v2/ajax/newslist.aspx?isapi=False&cat_id=32&pageindex=",
										"http://m.cafef.vn/v2/ajax/newslist.aspx?isapi=False&cat_id=33&pageindex=",
										"http://m.cafef.vn/v2/ajax/newslist.aspx?isapi=False&cat_id=39&pageindex=",
										};
	
	//vneconomy.vn
	public static final String[] VNECONOMY_CATEGORY = {"Thời sự", "Doanh nhân", "Tài chính", "Chứng khoán",
												"Thị trường", "Bất động sản", "Thế giới", "Cuộc sống số", "Xe 360"};
	public static final String[] VNECONOMY_LINK = {
											"http://m.vneconomy.vn/Ajax/Load_MoreNewest.aspx?Cat_ID=9920&Thread_ID=0&PageIndex=",
											"http://m.vneconomy.vn/Ajax/Load_MoreNewest.aspx?Cat_ID=5&Thread_ID=0&PageIndex=",
											"http://m.vneconomy.vn/Ajax/Load_MoreNewest.aspx?Cat_ID=6&Thread_ID=0&PageIndex=",
											"http://m.vneconomy.vn/Ajax/Load_MoreNewest.aspx?Cat_ID=7&Thread_ID=0&PageIndex=",
											"http://m.vneconomy.vn/Ajax/Load_MoreNewest.aspx?Cat_ID=19&Thread_ID=0&PageIndex=",
											"http://m.vneconomy.vn/Ajax/Load_MoreNewest.aspx?Cat_ID=17&Thread_ID=0&PageIndex=",
											"http://m.vneconomy.vn/Ajax/Load_MoreNewest.aspx?Cat_ID=99&Thread_ID=0&PageIndex=",
											"http://m.vneconomy.vn/Ajax/Load_MoreNewest.aspx?Cat_ID=16&Thread_ID=0&PageIndex=",
											"http://m.vneconomy.vn/Ajax/Load_MoreNewest.aspx?Cat_ID=23&Thread_ID=0&PageIndex="};
	
	//stockbiz.vn
	public static final String[] STOCKBIZ_CATEGORY = {"Tin tức", "Thị trường", "Tài chính - Ngân hàng",
												"Doanh nghiệp", "Kinh tế đầu tư", "Chứng khoán thế giới", "Thị trường bất động sản"};
	public static final String[] STOCKBIZ_LINK = {"http://m.stockbiz.vn/NewsList.aspx?GroupID=-1&Page=",
											"http://m.stockbiz.vn/NewsList.aspx?GroupID=1&Page=",
											"http://m.stockbiz.vn/NewsList.aspx?GroupID=2&Page=",
											"http://m.stockbiz.vn/NewsList.aspx?GroupID=3&Page=",
											"http://m.stockbiz.vn/NewsList.aspx?GroupID=4&Page=",
											"http://m.stockbiz.vn/NewsList.aspx?GroupID=5&Page=",
											"http://m.stockbiz.vn/NewsList.aspx?GroupID=6&Page="};
	
	//vietstock.vn
	public static final String[] VIETSTOCK_CATEGORY = {"Chứng khoán", "Doanh nghiệp", "Bất động sản", "Hàng hóa",
												"Tài chính", "Vĩ mô", "Kinh tế ngành", "Thế giới", "Đông dương",
												"Vietstock Blog", "Thời sự"};
	public static final String[] VIETSTOCK_LINK = {"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=144&notArticleID=308983&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=733&notArticleID=309083&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=763&notArticleID=309036&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=2&notArticleID=309121&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=734&notArticleID=309083&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=761&notArticleID=308811&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=768&notArticleID=309052&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=736&notArticleID=309086&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=1317&notArticleID=307542&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=3355&notArticleID=308598&page=",
											"http://touch.vietstock.vn/Ajax/GetMoreNews.ashx?type=1&ChannelID=1351&notArticleID=309056&page=",
											};
	
	//dddn.com.vn
	public static final String[] DIENDANDOANHNGHIEP_CATEGORY = {"Tin mới", "Thị trường", "Doanh nghiệp", "Tài chính", "Pháp luật", "Đầu tư", "Khởi nghiệp", "Bất động sản",
															"Quốc tế", "Công nghệ", "Chính trị xã hội"};
	public static final String[] DIENDANDOANHNGHIEP_LINK = {"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?type=1&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=117&newsid=2013080603533544&type=3&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=44&newsid=20130806034932446&type=3&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=54&newsid=20130806100939451&type=3&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=104&newsid=20130806050542635&type=3&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=7&newsid=20130806123122791&type=3&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=46&newsid=20130807090512512&type=3&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=172&newsid=2013080603133698&type=3&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=133&newsid=20130806040657934&type=3&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=181&newsid=20130806044454535&type=3&page=",
															"http://m.dddn.com.vn/Ajax/AjaxListNews.aspx?catid=183&newsid=2013071810267860&type=3&page="};
	
	//bongda24h.vn
	public static final String[] BONGDA24H_CATEGORY = {"Bóng đá Anh", "Bóng đá Tây Ban Nha", "Bóng đá Châu Âu",
												"Bóng đá Việt Nam", "Bóng đá Italia", "Bóng đá Đức", "Bóng đá Pháp", 
												"Tin chuyển nhượng"};
	public static final String[] BONGDA24H_LINK = {"http://m.bongda24h.vn/Cate.aspx?catId=172&page=",
											"http://m.bongda24h.vn/Cate.aspx?catId=180&page=",
											"http://m.bongda24h.vn/Cate.aspx?catId=184&page=",
											"http://m.bongda24h.vn/Cate.aspx?catId=168&page=",
											"http://m.bongda24h.vn/Cate.aspx?catId=176&page=",
											"http://m.bongda24h.vn/Cate.aspx?catId=193&page=",
											"http://m.bongda24h.vn/Cate.aspx?catId=197&page=s",
											"http://m.bongda24h.vn/Cate.aspx?catId=187&page="};
	
	//thethaoso
	public static final String[] THETHAOSO_CATEGORY = {"Chiến thắng nhà cái", "Điểm tin", "Bóng đá Anh", "Bóng đá Tây Ban Nha", "Bóng đá Italia",
													"Bóng đá Đức", "Bóng đá Pháp", "Bóng đá năm châu", "Bóng đá Việt Nam", "Thể thao Quốc Tế",
													"Chuyện sao", "Champions League", "Europa League"};
	public static final String[] THETHAOSO_LINK = {"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=321&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=375&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=336&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=344&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=340&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=348&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=352&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=356&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=272&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=97&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=138&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=357&cpage=",
												"http://wap.thethaoso.vn/TinTuc/Default.aspx?display=list&w=320&catid=358&cpage="};
	
	//dulichvietnam.com.vn
	public static final String[] DULICHVIETNAM_CATEGORY = {"Trang chủ", "Tin du lịch", "Danh thắng", "Văn hóa", "Lễ hội",
													"Ẩm thực", "Cẩm nang du lịch", "Du lịch 365", "Chuyến đi của tôi", 
													"Thế giới với Việt Nam", "Du lịch như sao", "Hoạt động ngành", "Khuyến mãi"};
	public static final String[] DULICHVIETNAM_RSS = {"http://www.dulichvietnam.com.vn/rss/",
												"http://www.dulichvietnam.com.vn/tin-du-lich/rss/",
												"http://www.dulichvietnam.com.vn/danh-thang/rss/",
												"http://www.dulichvietnam.com.vn/van-hoa/rss/",
												"http://www.dulichvietnam.com.vn/le-hoi/rss/",
												"http://www.dulichvietnam.com.vn/am-thuc/rss/",
												"http://www.dulichvietnam.com.vn/cam-nang-du-lich/rss/",
												"http://www.dulichvietnam.com.vn/du-lich-365/rss/",
												"http://www.dulichvietnam.com.vn/chuyen-di-cua-toi/rss/",
												"http://www.dulichvietnam.com.vn/the-gioi-voi-viet-nam/rss/",
												"http://www.dulichvietnam.com.vn/du-lich-nhu-sao/rss/",
												"http://www.dulichvietnam.com.vn/hoat-dong-nganh/rss/",
												"http://www.dulichvietnam.com.vn/khuyen-mai/rss/"};
	
	//afamily.vn
	public static final String[] AFAMILY_CATEGORY = {"Tin mới", "Đẹp", "Đời sống", "Ăn ngon - Khéo tay", "Tình yêu - Hôn nhân", "Sức khỏe",
												"Tâm sự", "Mẹ & Bé", "Nhà hay", "Hậu trường", "Giải trí", "Chuyện lạ"};
	public static final String[] AFAMILY_LINK = {"http://m.afamily.vn/Services/AjaxList.aspx?type=0&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=70&newsid=20130806111249755&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=97&newsid=2013080311598491&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=134&newsid=20130805074831228&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=31&newsid=20130805041644430&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=86&newsid=20130806115256302&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=32&newsid=20130806095423852&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=33&newsid=2013713141813181&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=122&newsid=20130806011417952&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=159&newsid=20130806012322264&page=",
											"http://m.afamily.vn/Services/AjaxList.aspx?catid=160&newsid=2013080610249777&page="};
	
	//eva.vn
	public static final String[] EVA_CATEGORY = {"Thời trang", "Làm đẹp", "Làng sao", "Eva tám", "Bà bầu", "Làm mẹ",
											"Nhà đẹp", "Bếp Eva", "Mua sắm - Giá cả", "Đi đâu - Xem gì", "Tình yêu - Giới tính",
											"Eva sành điệu"};
	public static final String[] EVA_LINK = {"http://m.eva.vn/thoi-trang-c36.html?page=",
										"http://m.eva.vn/lam-dep-c58.html?page=",
										"http://m.eva.vn/lang-sao-c20.html?page=",
										"http://m.eva.vn/eva-tam-c66.html?page=",
										"http://m.eva.vn/ba-bau-c85.html?page=",
										"http://m.eva.vn/lam-me-c10.html?page=",
										"http://m.eva.vn/nha-dep-c169.html?page=",
										"http://m.eva.vn/bep-eva-c162.html?page=",
										"http://m.eva.vn/mua-sam-gia-ca-c2.html?page=",
										"http://m.eva.vn/di-dau-xem-gi-c40.html?page=",
										"http://m.eva.vn/tinh-yeu-gioi-tinh-c3.html?page=",
										"http://m.eva.vn/eva-sanh-dieu-c173.html?page="};
	
	//http://antgct.cand.com.vn
	public static final String[] ANNINHTHEGIOI_CUOITHANG_CATEGORY = {"Chuyên đề", "Sổ tay", "Khoa học & Văn minh", "Người trong cuộc", "Nhàn đàm", "Nhân vật","Chuyện khó tin có thật"};
	public static final String[] ANNINHTHEGIOI_CUOITHANG_LINK = {"http://antgct.cand.com.vn/vi-VN/chuyende.rss",
														"http://antgct.cand.com.vn/vi-VN/sotay.rss",
														"http://antgct.cand.com.vn/vi-VN/khoahoc-vanminh.rss",
														"http://antgct.cand.com.vn/vi-VN/nguoitrongcuoc.rss",
														"http://antgct.cand.com.vn/vi-VN/nhandam.rss",
														"http://antgct.cand.com.vn/vi-VN/nhanvat.rss",
														"http://antgct.cand.com.vn/vi-VN/chuyenkhotin.rss"};
	
	//http://cstc.cand.com.vn
	public static final String[] CANHSATTOANCAU_CATEGORY = {"Phóng sự - Ghi chép", "Nhân vật - Sự kiện nổi bật", "Giải trí - Thể thao", "Hôn nhân - Cuộc sống",
													"Hồ sơ", "Ngược sáng", "Tội phạm", "Cuộc sống"};
	public static final String[] CANHSATTOANCAU_LINK = {"http://cstc.cand.com.vn/vi-VN/phongsu-ghichep.rss",
												"http://cstc.cand.com.vn/vi-VN/nhanvat-sukien.rss",
												"http://cstc.cand.com.vn/vi-VN/giaitri-thethao.rss",
												"http://cstc.cand.com.vn/vi-VN/honnhan-csong.rss",
												"http://cstc.cand.com.vn/vi-VN/hoso.rss",
												"http://cstc.cand.com.vn/vi-VN/nguocsang.rss",
												"http://cstc.cand.com.vn/vi-VN/toipham.rss",
												"http://cstc.cand.com.vn/vi-VN/cuocsong.rss"};
	
	//http://vnca.cand.com.vn
	public static final String[] VANNGHECONGAN_CATEGORY = {"Đời sống văn hóa", "Tư liệu văn hóa", "Lý luận", "Thơ", "Truyền thống", "Truyện", "Diễn đàn"};
	public static final String[] VANNGHECONGAN_LINK = {"http://vnca.cand.com.vn/vi-VN/doisongvanhoa.rss",
												"http://vnca.cand.com.vn/vi-VN/tulieuvanhoa.rss",
												"http://vnca.cand.com.vn/vi-VN/lyluan.rss",
												"http://vnca.cand.com.vn/vi-VN/tho.rss",
												"http://vnca.cand.com.vn/vi-VN/truyenthong.rss",
												"http://vnca.cand.com.vn/vi-VN/truyen.rss",
												"http://vnca.cand.com.vn/vi-VN/diendan.rss"};
	
	//nguoiduatin.vn
	public static final String[] NGUOIDUATIN_CATEGORY = {"Pháp luật", "Nhịp sống", "Hậu trường", "Kinh doanh", "Thế giới", "Người trẻ", "Giải trí",
														"Công nghệ", "Địa phương"};
	public static final String[] NGUOIDUATIN_LINK = {"http://m.nguoiduatin.vn/c/phap-luat/page/",
													"http://m.nguoiduatin.vn/c/nhip-song/page/",
													"http://m.nguoiduatin.vn/c/hau-truong/page/",
													"http://m.nguoiduatin.vn/c/kinh-doanh/page/",
													"http://m.nguoiduatin.vn/c/the-gioi/page/",
													"http://m.nguoiduatin.vn/c/nguoi-tre/page/",
													"http://m.nguoiduatin.vn/c/giai-tri/page/",
													"http://m.nguoiduatin.vn/c/cong-nghe/page/",
													"http://m.nguoiduatin.vn/c/dia-phuong/page/"};
	
	//danviet
	public static final String[] DANVIET_CATEGORY = {"Thời sự", "Thế giới", "Thể thao", "Khoa học công nghệ", "Giáo dục", "Nông thôn mới", 
													"Kinh tế", "Văn hóa", "Pháp luật", "Lối sống - Sức khỏe", "Quê nhà", "Tiếng dân"};
	public static final String[] DANVIET_LINK = {"http://m.danviet.vn/p0c24/thoi-su/trang-",
												"http://m.danviet.vn/p0c26/the-gioi/trang-",
												"http://m.danviet.vn/p0c27/the-thao/trang-",
												"http://m.danviet.vn/p0c32/cong-nghe/trang-",
												"http://m.danviet.vn/p0c28/giao-duc--du-hoc/trang-",
												"http://m.danviet.vn/p0c34/nong-thon-moi/trang-",
												"http://m.danviet.vn/p0c25/kinh-te/trang-",
												"http://m.danviet.vn/p0c30/van-hoa/trang-",
												"http://m.danviet.vn/p0c33/phap-luat/trang-",
												"http://m.danviet.vn/p0c31/loi-song--suc-khoe/trang-",
												"http://m.danviet.vn/p0c29/que-nha/trang-",
												"http://m.danviet.vn/p0c36/tieng-dan/trang-"};
	
	//thanhnien
	public static final String[] THANHNIEN_CATEGORY = {"Tin nóng", "Chính trị - Xã hội", "Kinh tế tài chính", "Thế giới", "Thể thao", "Công nghệ", "Showbiz",
														"Đời sống", "Quân sự", "Giới trẻ", "Tình yêu gia đình"};
	public static final String[] THANHNIEN_LINK = {"http://m.thanhnien.com.vn/home/index",
													"http://m.thanhnien.com.vn/section/chinh-tri-xa-hoi",
													"http://m.thanhnien.com.vn/section/kinh-te-tai-chinh",
													"http://m.thanhnien.com.vn/section/the-gioi",
													"http://m.thanhnien.com.vn/section/the-thao",
													"http://m.thanhnien.com.vn/section/cong-nghe",
													"http://m.thanhnien.com.vn/section/showbiz",
													"http://m.thanhnien.com.vn/section/doi-song",
													"http://m.thanhnien.com.vn/section/quan-su",
													"http://m.thanhnien.com.vn/section/gioi-tre",
													"http://m.thanhnien.com.vn/section/tinh-yeu-gia-dinh"};
	
	//ictnews
	public static final String[] ICTNEWS_CATEGORY = {"Siêu thị số", "Kinh doanh", "Viễn thông", "Internet", "CNTT", "Doanh nghiệp", "Nước mạnh CNTT",
													"Game", "Giải trí"};
	public static final String[] ICTNEWS_LINK = {"http://www.ictnews.vn/wap/Catalogy.aspx?ChannelID=13&PageIndex=",
												"http://www.ictnews.vn/wap/Catalogy.aspx?ChannelID=31&PageIndex=",
												"http://www.ictnews.vn/wap/Catalogy.aspx?ChannelID=5&PageIndex=",
												"http://www.ictnews.vn/wap/Catalogy.aspx?ChannelID=77&PageIndex=",
												"http://www.ictnews.vn/wap/Catalogy.aspx?ChannelID=4&PageIndex=",
												"http://www.ictnews.vn/wap/Catalogy.aspx?ChannelID=94&PageIndex=",
												"http://www.ictnews.vn/wap/Catalogy.aspx?ChannelID=19&PageIndex=",
												"http://www.ictnews.vn/wap/Catalogy.aspx?ChannelID=21&PageIndex=",
												"http://www.ictnews.vn/wap/Catalogy.aspx?ChannelID=109&PageIndex="};
	
	//tuoitre
	public static final String[] TUOITRE_CATEGORY = {"Phóng sự - Ký sự", "Chính trị - Xã hội", "Thế giới", "Nhịp sống trẻ", "Văn hóa - giải trí",
													"Kinh tế", "Giáo dục", ""};
	public static final String[] TUOITRE_LINK = {"http://m.tuoitre.vn/tin-tuc/Phong-su-Ky-su/page/",
												"http://m.tuoitre.vn/tin-tuc/Chinh-tri-Xa-hoi/page/",
												"http://m.tuoitre.vn/tin-tuc/The-gioi/page/",
												"http://m.tuoitre.vn/tin-tuc/Nhip-song-tre/page/",
												"http://m.tuoitre.vn/tin-tuc/Van-hoa-Giai-tri/page/",
												"http://m.tuoitre.vn/tin-tuc/Kinh-te/page/",
												"http://m.tuoitre.vn/tin-tuc/Giao-duc/page/"};
	
	//gamek
	public static final String[] GAMEK_CATEGORY = {"Mới nhất", "Trong nước", "Quốc tế"};
	public static final String[] GAMEK_LINK = {"http://m.gamek.vn/Ajax/AjaxList.aspx?catid=0&type=1&isTN_or_QT=0&page=",
												"http://m.gamek.vn/Ajax/AjaxList.aspx?catid=204&type=1&isTN_or_QT=1&page=",
												"http://m.gamek.vn/Ajax/AjaxList.aspx?catid=205&type=1&isTN_or_QT=1&page="};
	
	//kienthuc
	public static final String[] KIENTHUC_CATEGORY = {"Xã hội", "Thế giới", "Khoa học", "Quân sự", "Khỏe++", "Kinh doanh",
													"Kho tri thức", "Cộng đồng mạng", "Giải trí", "Tình yêu - hôn nhân", 
													"Thiền", "Cười"};
	public static final String[] KIENTHUC_LINK = {"http://m.kienthuc.net.vn/thoi-su/?page=",
												"http://m.kienthuc.net.vn/the-gioi/?page=",
												"http://m.kienthuc.net.vn/khoa-hoc/?page=",
												"http://m.kienthuc.net.vn/quan-su/?page=",
												"http://m.kienthuc.net.vn/khoe/?page=",
												"http://m.kienthuc.net.vn/kinh-doanh/?page=",
												"http://m.kienthuc.net.vn/kho-tri-thuc/?page=",
												"http://m.kienthuc.net.vn/cong-dong-mang/?page=",
												"http://m.kienthuc.net.vn/giai-tri/?page=",
												"http://m.kienthuc.net.vn/tinh-yeu-hon-nhan/?page=",
												"http://m.kienthuc.net.vn/thien/?page=",
												"http://m.kienthuc.net.vn/cuoi/?page="};
	
	//ngoisao.vn
	public static final String[] NGOISAO_CATEGORY = {"Hậu trường", "Đẹp", "Điện ảnh", "Âm nhạc", "Hoa hậu", "Kỳ quặc", "Thư giãn", "Chuyên đề nóng", "Ngắm", "Giới trẻ", "Kết nối"};
	public static final String[] NGOISAO_LINK = {"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=1&title=hau-truong&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=5&title=dep&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=7&title=dien-anh&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=8&title=am-nhac&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=10&title=hoa-hau&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=13&title=ky-quac&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=15&title=thu-gian&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=12&title=theo-dong-su-kien&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=14&title=ngam&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=11&title=gioi-tre&cached=1&page_no=",
												"http://m.ngoisao.vn/?app=news&page=m_cate&cate_id=16&title=ket-noi&cached=1&page_no="};
	
	public static final String[][] NEWSPAPER_CATEGORY = {VNEXPRESS_CATEGORY, DANTRI_CATEGORY, VIETNAMNET_CATEGORY, HAITUGIO_CATEGORY, LAODONG_CATEGORY, NLD_CATEGORY, XAHOI_CATEGORY, GIAODUC_CATEGORY, SOHA_CATEGORY,
														INFONET_CATEGORY, KENH14_CATEGORY, TIIN_CATEGORY, TOSAO_CATEGORY, XZONE_CATEGORY, CONGLY_CATEGORY, KHOAHOC_CATEGORY, THIENNHIEN_CATEGORY, GENK_CATEGORY,
														CAFEAUTO_CATEGORY, AUTOPRO_CATEGORY, AUTODAILY_CATEGORY, CAFELAND_CATEGORY, CAFEBIZ_CATEGORY, CAFEF_CATEGORY, VNECONOMY_CATEGORY, STOCKBIZ_CATEGORY,
														VIETSTOCK_CATEGORY, DIENDANDOANHNGHIEP_CATEGORY, BONGDA24H_CATEGORY, AFAMILY_CATEGORY, EVA_CATEGORY, NGUOIDUATIN_CATEGORY, ANNINHTHUDO_CATEGORY, DANVIET_CATEGORY,
														ICTNEWS_CATEGORY, TUOITRE_CATEGORY, GAMEK_CATEGORY, KIENTHUC_CATEGORY, NGOISAO_CATEGORY};
	public static final String[][] NEWSPAPER_LINK = {VNEXPRESS_LINK, DANTRI_LINK, VIETNAMNET_LINK, HAITUGIO_LINK, LAODONG_LINK, NLD_LINK, XAHOI_LINK, GIAODUC_LINK, SOHA_LINK, INFONET_LINK, KENH14_LINK, TIIN_LINK,
													TOSAO_LINK, XZONE_LINK, CONGLY_LINK, KHOAHOC_LINK, THIENNHIEN_LINK, GENK_LINK, CAFEAUTO_LINK, AUTOPRO_LINK, AUTODAILY_LINK, CAFELAND_LINK, CAFEBIZ_LINK, CAFEF_LINK,
													VNECONOMY_LINK, STOCKBIZ_LINK, VIETSTOCK_LINK, DIENDANDOANHNGHIEP_LINK, BONGDA24H_LINK, AFAMILY_LINK, EVA_LINK, NGUOIDUATIN_LINK, ANNINHTHUDO_LINK, DANVIET_LINK,
													ICTNEWS_LINK, TUOITRE_LINK, GAMEK_LINK, KIENTHUC_LINK, NGOISAO_LINK};
	
	public static HashMap<String, Integer> newspaperLocation = new HashMap<String, Integer>();
	
	static {
		newspaperLocation.put("vnexpress", 0);
		newspaperLocation.put("dantri", 1);
		newspaperLocation.put("vietnamnet", 2);
		newspaperLocation.put("24h", 3);
		newspaperLocation.put("laodong", 4);
		newspaperLocation.put("nld", 5);
		newspaperLocation.put("xahoi", 6);
		newspaperLocation.put("giaoduc", 7);
		newspaperLocation.put("soha", 8);
		newspaperLocation.put("infonet", 9);
		newspaperLocation.put("kenh14", 10);
		newspaperLocation.put("tiin", 11);
		newspaperLocation.put("2sao", 12);
		newspaperLocation.put("xzone", 13);
		newspaperLocation.put("congly", 14);
		newspaperLocation.put("khoahoc", 15);
		newspaperLocation.put("thiennhien", 16);
		newspaperLocation.put("genk", 17);
		newspaperLocation.put("cafeauto", 18);
		newspaperLocation.put("autopro", 19);
		newspaperLocation.put("autodaily", 20);
		newspaperLocation.put("cafeland", 21);
		newspaperLocation.put("cafebiz", 22);
		newspaperLocation.put("cafef", 23);
		newspaperLocation.put("vneconomy", 24);
		newspaperLocation.put("stockbiz", 25);
		newspaperLocation.put("vietstock", 26);
		newspaperLocation.put("dddn", 27);
		newspaperLocation.put("bongda24h", 28);
		newspaperLocation.put("afamily", 29);
		newspaperLocation.put("eva", 30);
		newspaperLocation.put("nguoiduatin", 31);
		newspaperLocation.put("anninhthudo", 32);
		newspaperLocation.put("danviet", 33);
		newspaperLocation.put("ictnews", 34);
		newspaperLocation.put("tuoitre", 35);
		newspaperLocation.put("gamek", 36);
		newspaperLocation.put("kienthuc", 37);
		newspaperLocation.put("ngoisao", 38);
	}
	
	public static HashMap<String, String> linkNewspaper = new HashMap<String, String>();
	static {
		linkNewspaper.put("vnexpress", "http://m.vnexpress.net");
		linkNewspaper.put("dantri", "http://m.dantri.com.vn");
		linkNewspaper.put("vietnamnet", "http://m.vietnamnet.vn");
		linkNewspaper.put("24h", "http://m.24h.com.vn");
		linkNewspaper.put("laodong", "http://m.laodong.com.vn");
		linkNewspaper.put("nld", "http://m.nld.com.vn");
		linkNewspaper.put("xahoi", "http://m.xahoi.com.vn");
		linkNewspaper.put("giaoduc", "http://m.giaoduc.net.vn");
		linkNewspaper.put("soha", "http://m.soha.vn");
		linkNewspaper.put("infonet", "http://m.infonet.vn");
		linkNewspaper.put("kenh14", "http://m.kenh14.vn");
		linkNewspaper.put("tiin", "http://tiin.vn");
		linkNewspaper.put("2sao", "http://m.2sao.vn");
		linkNewspaper.put("xzone", "http://x.xzone.vn");
		linkNewspaper.put("congly", "http://m.congly.com.vn");
		linkNewspaper.put("khoahoc", "http://www.khoahoc.com.vn");
		linkNewspaper.put("genk", "http://m.genk.vn");
		linkNewspaper.put("tinhte", "http://www.tinhte.vn");
		linkNewspaper.put("cafeauto", "http://m.cafeauto.vn/");
		linkNewspaper.put("autopro", "http://m.autopro.com.vn");
		linkNewspaper.put("autodaily", "http://m.autodaily.vn");
		linkNewspaper.put("vneconomy", "http://m.vneconomy.vn");
		linkNewspaper.put("stockbiz", "http://m.stockbiz.vn/");
		linkNewspaper.put("vietstock", "http://touch.vietstock.vn");
		linkNewspaper.put("dddn", "http://m.dddn.com.vn");
		linkNewspaper.put("bongda24h", "http://m.bongda24h.vn");
		linkNewspaper.put("afamily", "http://m.afamily.vn");
		linkNewspaper.put("eva", "http://m.eva.vn");
		linkNewspaper.put("anninhthudo", "http://m.anninhthudo.vn");
		linkNewspaper.put("danviet", "http://m.danviet.vn");
		linkNewspaper.put("ictnews", "http://www.ictnews.vn");
		linkNewspaper.put("tuoitre", "http://m.tuoitre.vn");
		linkNewspaper.put("gamek", "http://m.gamek.vn");
		linkNewspaper.put("kienthuc", "http://m.kienthuc.net.vn");
		linkNewspaper.put("ngoisao", "http://m.ngoisao.vn");
	}
	
	public static HashMap<String, String> newspaperTitle = new HashMap<String, String>();
	static {
		newspaperTitle.put("vnexpress", "Vnexpress");
		newspaperTitle.put("dantri", "Dân trí");
		newspaperTitle.put("vietnamnet", "Vietnamnet");
		newspaperTitle.put("24h", "24H");
		newspaperTitle.put("laodong", "Lao động");
		newspaperTitle.put("nld", "Người Lao Động");
		newspaperTitle.put("xahoi", "Xã hội");
		newspaperTitle.put("giaoduc", "Giáo dục");
		newspaperTitle.put("soha", "Soha News");
		newspaperTitle.put("infonet", "Infonet");
		newspaperTitle.put("kenh14", "Kênh 14");
		newspaperTitle.put("tiin", "Tiin");
		newspaperTitle.put("2sao", "2sao");
		newspaperTitle.put("xzone", "Xzone");
		newspaperTitle.put("congly", "Công lý");
		newspaperTitle.put("khoahoc", "Khoc học");
		newspaperTitle.put("thiennhien", "Thiên nhiên");
		newspaperTitle.put("genk", "Genk");
		newspaperTitle.put("cafeauto", "Cafeauto");
		newspaperTitle.put("autopro", "Autopro");
		newspaperTitle.put("autodaily", "Autodaily");
		newspaperTitle.put("cafeland", "Cafeland");
		newspaperTitle.put("cafebiz", "CafeBiz");
		newspaperTitle.put("cafef", "CafeF");
		newspaperTitle.put("vneconomy", "Vneconomy");
		newspaperTitle.put("stockbiz", "StockBiz");
		newspaperTitle.put("vietstock", "VietStock");
		newspaperTitle.put("dddn", "Diễn Đàn Doanh Nghiệp");
		newspaperTitle.put("bongda24h", "Bóng đá 24h");
		newspaperTitle.put("afamily", "Afamily");
		newspaperTitle.put("eva", "Eva");
		newspaperTitle.put("nguoiduatin", "Người đưa tin");
		newspaperTitle.put("anninhthudo", "An ninh thủ đô");
		newspaperTitle.put("danviet", "Dân việt");
		newspaperTitle.put("ictnews", "Ictnews");
		newspaperTitle.put("tuoitre", "Tuổi trẻ");
		newspaperTitle.put("gamek", "GameK");
		newspaperTitle.put("kienthuc", "Kiến thức");
		newspaperTitle.put("hanoimoi", "Hà Nội Mới");
		newspaperTitle.put("tienphong", "Tiền phong");
		newspaperTitle.put("tinhte", "Tinh tế");
		newspaperTitle.put("ngoisao", "Ngôi sao");
		newspaperTitle.put("nguoilaodong", "Người Lao Động");
	}
	
	public static final String[] newspaper = {"vnexpress", "dantri", "vietnamnet", "24h", "laodong", "nld", "xahoi", "giaoduc", 
											"soha", "infonet", "kenh14", "tiin", "2sao", "xzone", "congly", "khoahoc", "thiennhien",
											"genk", "cafeauto", "autopro", "autodaily", "cafeland", "cafebiz", "cafef", "vneconomy",
											"stockbiz", "vietstock", "dddn", "bongda24h", "afamily", "eva", "nguoiduatin", "anninhthudo", "danviet",
											"ictnews", "tuoitre", "gamek", "kienthuc", "ngoisao"};

	public static SparseArray<ArrayList<News>> listNews = new SparseArray<ArrayList<News>>();
}
