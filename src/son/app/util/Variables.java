package son.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import son.app.model.Category;
import son.app.model.News;
import son.app.newsonline.R;

public class Variables {
	public static Map<String, Integer> icons = new HashMap<String, Integer>();
	
	static {
		icons.put("vnexpress", R.drawable.vnexpress);
		icons.put("dantri", R.drawable.dantri);
		icons.put("vietnamnet", R.drawable.vietnamnet);
		icons.put("24h", R.drawable.haitugio);
		icons.put("tuoitre", R.drawable.tuoitre);
		icons.put("nguoiduatin", R.drawable.nguoiduatin);
		icons.put("vtc", R.drawable.vtc);
		icons.put("vietbao", R.drawable.vietbao);
		icons.put("laodong", R.drawable.laodong);
		icons.put("nguoilaodong", R.drawable.nguoilaodong);
		icons.put("xahoi", R.drawable.xahoi);
		icons.put("giaoduc", R.drawable.giaoduc);
		icons.put("giaoducthoidai", R.drawable.giaoducthoidai);
		icons.put("anninhthudo", R.drawable.anninhthudo);
		icons.put("anninhthegioi", R.drawable.anninhthegioi);
		icons.put("congannhandan", R.drawable.congannhandan);
		icons.put("phapluattp", R.drawable.phapluattp);
		icons.put("khoahoc", R.drawable.khoahoc);
		icons.put("thongtincongnghe", R.drawable.thongtincongnghe);
		icons.put("ictnews", R.drawable.ictnews);
		icons.put("tinhte", R.drawable.tinhte);
		icons.put("cafeauto", R.drawable.cafeauto);
		icons.put("autopro", R.drawable.autopro);
		icons.put("batdongsan", R.drawable.batdongsan);
		icons.put("landtoday", R.drawable.landtoday);
		icons.put("cafef", R.drawable.cafef);
		icons.put("vneconomy", R.drawable.vneconomy);
		icons.put("stockbiz", R.drawable.stockbiz);
		icons.put("vietstock", R.drawable.vietstock);
		icons.put("thesaigontimes", R.drawable.thesaigontimes);
		icons.put("bongda24h", R.drawable.bongda24h);
		icons.put("bongdaplus", R.drawable.bongdaplus);
		icons.put("dulichvietnam", R.drawable.newspaper);
		icons.put("afamily", R.drawable.afamily);
		icons.put("giadinh", R.drawable.giadinh);
		icons.put("zing", R.drawable.zing);
		icons.put("tiin", R.drawable.tiin);
		icons.put("eva", R.drawable.eva);
		icons.put("anninhthegioi_ct", R.drawable.congannhandan);
		icons.put("canhsattoancau", R.drawable.congannhandan);
		icons.put("vannghecongan", R.drawable.congannhandan);
	}
	
	public static String TABLE_NEWSPAPER_CHOSE = "newspaper_chose";
	
	public static String[] dulich = {"dulichvietnam"};
	public static String[] congnghe = {"tinhte", "ictnews", "thongtincongnghe", "khoahoc"};
	public static String[] giaitri = {"zing","tiin"};
	public static String[] phunu_giadinh = {"eva", "afamily", "giadinh"};
	public static String[] taichinh_kinhdoanh = {"cafef", "vneconomy", "stockbiz", "vietstock", "thesaigontimes"};
	public static String[] batdongsan = {"landtoday", "batdongsan"};
	public static String[] oto_xemay = {"autopro", "cafeauto"};
	public static String[] anninh = {"anninhthudo", "anninhthegioi", "anninhthegioi_ct","canhsattoancau","vannghecongan","congannhandan", "phapluattp"};
	public static String[] giaoduc = {"giaoduc", "giaoducthoidai"};
	public static String[] tonghop = {"vnexpress", "dantri", "vietnamnet", "24h", "vtc", "xahoi", "vietbao", "laodong", "nguoilaodong", "nguoiduatin", "tuoitre"};
	public static String[] bongda = {"bongdaplus", "bongda24h"};
	
	public static ArrayList<Category> ListCategory = new ArrayList<Category>();
	static {
		ListCategory.add(new Category("Tổng hợp", "Tin tức trên nhiều lĩnh vực", tonghop));
		ListCategory.add(new Category("Du lịch", "Tổng hợp tin tức du lịch, danh thắng",dulich));
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
		CategoryLocation.put("dulich", 1);
		CategoryLocation.put("congnghe", 2);
		CategoryLocation.put("giaitri", 3);
		CategoryLocation.put("phunu_giadinh", 4);
		CategoryLocation.put("taichinh_kinhdoanh", 5);
		CategoryLocation.put("batdongsan", 6);
		CategoryLocation.put("oto_xemay", 7);
		CategoryLocation.put("anninh", 9);
		CategoryLocation.put("giaoduc", 10);
		CategoryLocation.put("bongda", 11);
	}
	
	//vnexpress 
	public static String[] VNEXPRESS_CATEGORY = {"Trang chủ", "Tin mới nhất", "Xã hội", "Thế giới", 
												"Thể thao", "Pháp luật", "Khoa học",
												"Ô tô - Xe máy", "Bạn đọc viết", "Tâm sự", "Cười"};
	public static String[] VNEXPRESS_RSS = {"http://vnexpress.net/rss/gl/trang-chu.rss",
											"http://giadinh.vnexpress.net/rss/tin-moi-nhat.rss",
											"http://vnexpress.net/rss/gl/xa-hoi.rss",
											"http://vnexpress.net/rss/gl/the-gioi.rss",
											"http://vnexpress.net/rss/gl/kinh-doanh.rss",
											"http://vnexpress.net/rss/gl/phap-luat.rss",
											"http://vnexpress.net/rss/gl/khoa-hoc.rss",
											"http://vnexpress.net/rss/gl/oto-xe-may.rss",
											"http://vnexpress.net/rss/gl/ban-doc-viet.rss",
											"http://vnexpress.net/rss/gl/ban-doc-viet-tam-su.rss",
											"http://vnexpress.net/rss/gl/cuoi.rss"};
	
	//dantri 
	public static String[] DANTRI_CATEGORY = {"Trang chủ", "Xã hội", "Thế giới", "Thể thao", "Giáo dục - Khuyến học",
											"Tấm lòng nhân ái", "Kinh doanh", "Văn hóa", "Giải trí", "Pháp luật",
											"Nhịp sống trẻ", "Tình yêu - giới tính", "Sức khỏe", "Sức mạnh số", "Ô tô - Xe máy",
											"Bạn đọc", "Diễn đàn", "Chuyện lạ", "Tuyển sinh", "Du học", "Blog", "Nghề nghiệp", "Games"};
	public static String[] DANTRI_RSS  = {"http://www.dantri.com.vn/trangchu.rss",
										  "http://www.dantri.com.vn/xa-hoi.rss",
										  "http://www.dantri.com.vn/Thegioi.rss",
										  "http://www.dantri.com.vn/The-Thao.rss",
										  "http://www.dantri.com.vn/giaoduc-khuyenhoc.rss",
										  "http://www.dantri.com.vn/tamlongnhanai.rss",
										  "http://www.dantri.com.vn/kinhdoanh.rss",
										  "http://www.dantri.com.vn/van-hoa.rss",
										  "http://www.dantri.com.vn/giaitri.rss",
										  "http://www.dantri.com.vn/skphapluat.rss",
										  "http://www.dantri.com.vn/nhipsongtre.rss",
										  "http://www.dantri.com.vn/tinhyeu-gioitinh.rss",
										  "http://www.dantri.com.vn/suckhoe.rss",
										  "http://www.dantri.com.vn/cong-nghe.rss",
										  "http://www.dantri.com.vn/otoxemay.rss",
										  "http://www.dantri.com.vn/diendan-bandoc.rss",
										  "http://www.dantri.com.vn/dien-dan.rss",
										  "http://www.dantri.com.vn/chuyen-la.rss",
										  "http://www.dantri.com.vn/tuyen-sinh.rss",
										  "http://www.dantri.com.vn/du-hoc.rss",
										  "http://www.dantri.com.vn/blog.rss",
										  "http://www.dantri.com.vn/nghe-nghiep.rss",
										  "http://www.dantri.com.vn/games_asp_.rss" };
	
	//vietnamnet
	public static String[] VIETNAMNET_CATEGORY = {"Trang chủ", "Tin mới nóng", "Xã hội", "Giáo dục", "Chính trị",
													"Đời sống", "Kinh tế", "Quốc tế", "Văn hóa", "Khoa học",
													"CNTT - Viễn thông", "Bạn đọc"};
	public static String[] VIETNAMNET_RSS = {"http://vietnamnet.vn/rss/home.rss",
											"http://vietnamnet.vn/rss/moi-nong.rss",
											"http://vietnamnet.vn/rss/xa-hoi.rss",
											"http://vietnamnet.vn/rss/giao-duc.rss",
											"http://vietnamnet.vn/rss/chinh-tri.rss",
											"http://vietnamnet.vn/rss/doi-song.rss",
											"http://vietnamnet.vn/rss/kinh-te.rss",
											"http://vietnamnet.vn/rss/quoc-te.rss",
											"http://vietnamnet.vn/rss/van-hoa.rss",
											"http://vietnamnet.vn/rss/khoa-hoc.rss",
											"http://vietnamnet.vn/rss/cong-nghe-thong-tin-vien-thong.rss",
											"http://vietnamnet.vn/rss/ban-doc-phap-luat.rss"};
	
	//24h
	public static String[] HAITUGIO_CATEGORY = {"Tin tức trong ngày", "Bóng đá", "An ninh - Hình sự", "Thời trang",
												"Thời trang Hitech", "Tài chính - Bất động sản", "Ẩm thực", "Làm đẹp",
												"Phim", "Giáo dục - du học", "Bạn trẻ - cuộc sống", "Ca nhac - MTV",
												"Thể thao", "Phi thường - kỳ quặc", "Công nghệ thông tin", "Ô tô - xe máy",
												"Thị trường - tiêu dùng", "Du lịch", "Sức khỏe đời sống", "Cười 24h"};
	public static String[] HAITUGIO_RSS = {"http://www.24h.com.vn/upload/rss/tintuctrongngay.rss",
											"http://www.24h.com.vn/upload/rss/bongda.rss",
											"http://www.24h.com.vn/upload/rss/anninhhinhsu.rss",
											"http://www.24h.com.vn/upload/rss/thoitrang.rss",
											"http://www.24h.com.vn/upload/rss/thoitranghitech.rss",
											"http://www.24h.com.vn/upload/rss/taichinhbatdongsan.rss",
											"http://www.24h.com.vn/upload/rss/amthuc.rss",
											"http://www.24h.com.vn/upload/rss/lamdep.rss",
											"http://www.24h.com.vn/upload/rss/phim.rss",
											"http://www.24h.com.vn/upload/rss/giaoducduhoc.rss",
											"http://www.24h.com.vn/upload/rss/bantrecuocsong.rss",
											"http://www.24h.com.vn/upload/rss/canhacmtv.rss",
											"http://www.24h.com.vn/upload/rss/thethao.rss",
											"http://www.24h.com.vn/upload/rss/phithuongkyquac.rss",
											"http://www.24h.com.vn/upload/rss/congnghethongtin.rss",
											"http://www.24h.com.vn/upload/rss/otoxemay.rss",
											"http://www.24h.com.vn/upload/rss/thitruongtieudung.rss",
											"http://www.24h.com.vn/upload/rss/dulich.rss",
											"http://www.24h.com.vn/upload/rss/suckhoedoisong.rss",
											"http://www.24h.com.vn/upload/rss/cuoi24h.rss"};
	
	//tuoitre.vn
	public static String[] TUOITRE_CATEGORY = {"Chính trị - Xã hội", "Thế giới", "Nhịp sống trẻ", "Giáo dục",
												"Thể thao", "Văn hóa - Giải trí", "Nhịp sống số", "Bạn đọc"};
	public static String[] TUOITRE_RSS = {"http://tuoitre.vn/Pages/RssFeeds.aspx?ChannelID=3",
											"ja",
											"http://tuoitre.vn/Pages/RssFeeds.aspx?ChannelID=7",
											"http://tuoitre.vn/Pages/RssFeeds.aspx?ChannelID=13",
											"http://tuoitre.vn/Pages/RssFeeds.aspx?ChannelID=14",
											"http://tuoitre.vn/Pages/RssFeeds.aspx?ChannelID=10",
											"http://tuoitre.vn/Pages/RssFeeds.aspx?ChannelID=16",
											"http://tuoitre.vn/Pages/RssFeeds.aspx?ChannelID=118"};
	
	//nguoiduatin.vn
	public static String[] NGUOIDUATIN_CATEGORY = {"Pháp luật", "Nhịp sống", "Hậu trường", "Kinh doanh",
													"Thế giới", "Người trẻ", "Giải trí", "Công nghệ", "Địa phương"};
	public static String[] NGUOIDUATIN_RSS = {"http://www.nguoiduatin.vn/rss/phap-luat.rss",
											" http://www.nguoiduatin.vn/rss/nhip-song.rss",
											"http://www.nguoiduatin.vn/rss/hau-truong.rss",
											" http://www.nguoiduatin.vn/rss/kinh-doanh.rss",
											"http://www.nguoiduatin.vn/rss/the-gioi.rss",
											"http://www.nguoiduatin.vn/rss/nguoi-tre.rss",
											"http://www.nguoiduatin.vn/rss/giai-tri.rss",
											"http://www.nguoiduatin.vn/rss/cong-nghe.rss",
											"http://www.nguoiduatin.vn/rss/dia-phuong.rss"};
	
	//vtc.vn
	public static String[] VTC_CATEGORY = {"Trang chủ","Truyền hình", "Xã hội", "Kinh tế", "Quốc tế", "Giải trí", "Phụ nữ",
											"Giáo dục", "Khoa học - công nghệ", "Pháp luật", "Phóng sự - Khám phá",
											"Sức khỏe", "Ô tô - Xe máy", "Bạn đọc", "Tạp chí"};
	public static String[] VTC_RSS = {"http://vtc.vn/RssCate.aspx",
									"http://vtc.vn/RssCate.aspx?Group=0",
									"http://vtc.vn/RssCate.aspx?Group=2",
									"http://vtc.vn/RssCate.aspx?Group=1",
									"http://vtc.vn/RssCate.aspx?Group=311",
									"http://vtc.vn/RssCate.aspx?Group=13",
									"http://vtc.vn/RssCate.aspx?Group=630",
									"http://vtc.vn/RssCate.aspx?Group=538",
									"http://vtc.vn/RssCate.aspx?Group=557",
									"http://vtc.vn/RssCate.aspx?Group=7",
									"http://vtc.vn/RssCate.aspx?Group=394",
									"http://vtc.vn/RssCate.aspx?Group=321",
									"http://vtc.vn/RssCate.aspx?Group=31",
									"http://vtc.vn/RssCate.aspx?Group=457",
									"http://vtc.vn/RssCate.aspx?Group=383"};
	
	//vietbao.vn
	public static String[] VIETBAO_CATEGORY = {"Trang chủ", "Tin mới", "An ninh - pháp luật", "Blog hay", "Bóng đá",
												"Chiêm tinh", "Công nghệ", "Du lịch", "Đời sống - Gia đình", "Game",
												"Giải trí", "Giáo dục", "Khám phá Việt Nam", "Khoa học", "Kinh tế",
												"Người Việt bốn phương", "Nhà đất", "Ô tô - Xe máy", "Phóng sự",
												"Sống đẹp", "Sức khỏe", "Tết", "Thế giới", "Thế giới giải trí", "Thế giới trẻ",
												"Thể thao", "Trang bạn đọc", "Tuyển sinh", "Văn hóa", "Việc làm",
												"Vui cười", "Xã hội"};
	public static String[] VIETBAO_RSS = {"http://vietbao.vn/rss2/trang-nhat.rss",
										"http://vietbao.vn/rss2/tinmoi.rss",
										"http://vietbao.vn/live/An-ninh-Phap-luat/rss.xml",
										"http://vietbao.vn/live/Blog/rss.xml",
										"http://vietbao.vn/live/Bong-da/rss.xml",
										"http://vietbao.vn/live/Chiem-tinh/rss.xml",
										"http://vietbao.vn/live/Cong-nghe/rss.xml",
										"http://vietbao.vn/live/Du-lich/rss.xml",
										"http://vietbao.vn/live/Doi-song-Gia-dinh/rss.xml",
										"http://vietbao.vn/live/Game/rss.xml",
										"http://vietbao.vn/live/The-gioi-giai-tri/rss.xml",
										"http://vietbao.vn/live/Giao-duc/rss.xml",
										"http://vietbao.vn/live/Kham-pha-Viet-Nam/rss.xml",
										"http://vietbao.vn/live/Khoa-hoc/rss.xml",
										"http://vietbao.vn/live/Kinh-te/rss.xml",
										"http://vietbao.vn/live/Nguoi-Viet-bon-phuong/rss.xml",
										"http://vietbao.vn/live/Nha-dat/rss.xml",
										"http://vietbao.vn/live/O-to-xe-may/rss.xml",
										"http://vietbao.vn/live/Phong-su/rss.xml",
										"http://vietbao.vn/live/Dep/rss.xml",
										"http://vietbao.vn/live/Suc-khoe/rss.xml",
										"http://vietbao.vn/live/Tet/rss.xml",
										"http://vietbao.vn/live/The-gioi/rss.xml",
										"http://vietbao.vn/live/The-gioi-giai-tri/rss.xml",
										"http://vietbao.vn/live/The-gioi-tre/rss.xml",
										"http://vietbao.vn/live/The-thao/rss.xml",
										"http://vietbao.vn/live/Trang-ban-doc/rss.xml",
										"http://vietbao.vn/live/Tuyen-sinh/rss.xml",
										"http://vietbao.vn/live/Van-hoa/rss.xml",
										"http://vietbao.vn/live/Viec-lam/rss.xml",
										"http://vietbao.vn/live/Cuoi/rss.xml",
										"http://vietbao.vn/live/Xa-hoi/rss.xml"};
	
	//laodong.com.vn
	public static String[] LAODONG_CATEGORY = {"Trang chủ", "Lao động & đời sống", "Chính trị", "Tấm lòng vàng",
												"Công đoàn", "Thế giới", "Xã hội", "Kinh doanh", "Pháp luật",
												"Thể thao", "Văn hóa", "Sci - Tech", "Bạn đọc"};
	public static String[] LAODONG_RSS = {"http://laodong.com.vn/RSS/Event/Tin-noi-bat-trang-chu/9.rss",
										"http://laodong.com.vn/RSS/Lao-Dong-Doi-song/158.rss",
										"http://laodong.com.vn/RSS/Chinh-tri/57.rss",
										"http://laodong.com.vn/RSS/Tam-long-vang/83.rss",
										"http://laodong.com.vn/RSS/Cong-doan/58.rss",
										"http://laodong.com.vn/RSS/The-gioi/62.rss",
										"http://laodong.com.vn/RSS/Xa-hoi/59.rss",
										"http://laodong.com.vn/RSS/Kinh-doanh/63.rss",
										"http://laodong.com.vn/RSS/Phap-luat/65.rss",
										"http://laodong.com.vn/RSS/The-thao/60.rss",
										"http://laodong.com.vn/RSS/Van-hoa/61.rss",
										"http://laodong.com.vn/RSS/Sci-Tech/66.rss",
										"http://laodong.com.vn/RSS/Ban-doc/75.rss"};
	
	//nld.com.vn
	public static String[] NGUOILAODONG_CATEGORY = {"Trang chủ", "Thời sự trong nước", "Thời sự quốc tế", "Kinh tế",
													"Công đoàn", "Giáo dục", "Pháp luật", "Văn hóa - Giải trí",
													"Thể thao", "Sức khỏe", "Tình yêu - Hôn nhân", "Bạn đọc", "Sức khỏe & dinh dưỡng",
													"Khoa học", "Địa phương", "Mai vàng", "VNMoney"};
	public static String[] NGUOILAODONG_RSS = {"http://nld.com.vn/rss/tin-moi-nhat",
												"http://nld.com.vn/rss/thoi-su-trong-nuoc",
												"http://nld.com.vn/rss/thoi-su-quoc-te",
												"http://nld.com.vn/rss/kinh-te",
												"http://nld.com.vn/rss/cong-doan",
												"http://nld.com.vn/rss/giao-duc",
												"http://nld.com.vn/rss/phap-luat",
												"http://nld.com.vn/rss/van-hoa-giai-tri",
												"http://nld.com.vn/rss/the-thao",
												"http://nld.com.vn/rss/suc-khoe",
												"http://nld.com.vn/rss/tinh-yeu-hon-nhan",
												"http://nld.com.vn/rss/ban-doc",
												"http://nld.com.vn/rss/suc-khoe-dinh-duong",
												"http://nld.com.vn/rss/khoa-hoc",
												"http://nld.com.vn/rss/dia-phuong",
												"http://nld.com.vn/rss/mai-vang",
												"http://nld.com.vn/rss/vnmoney"};
	
	//xahoi.com.vn
	public static String[] XAHOI_CATEGORY = {"An ninh hình sự", "Tin tức xã hội", "Quốc tế", "Kinh doanh", "Thời trang - làm đẹp",
											"Giải trí", "Bóng đá", "Thể thao", "Yêu và sống", "Sức khỏe","Giáo dục - du học",
											"Kết nối", "Du lịch - ẩm thực", "Công nghệ", "Thư giãn"};
	public static String[] XAHOI_RSS = {"http://xahoi.com.vn/an-ninh-hinh-su.rss",
										"http://xahoi.com.vn/xa-hoi.rss",
										"http://xahoi.com.vn/quoc-te.rss",
										"http://xahoi.com.vn/kinh-doanh.rss",
										"http://xahoi.com.vn/thoi-trang.rss",
										"http://xahoi.com.vn/giai-tri.rss",
										"http://xahoi.com.vn/bong-da.rss",
										"http://xahoi.com.vn/the-thao.rss",
										"http://xahoi.com.vn/ban-tre-doi-song.rss",
										"http://xahoi.com.vn/suc-khoe.rss",
										"http://xahoi.com.vn/giao-duc-du-hoc.rss",
										"http://xahoi.com.vn/tuong-tac-ban-doc.rss",
										"http://xahoi.com.vn/du-lich-am-thuc.rss",
										"http://xahoi.com.vn/cong-nghe.rss",
										"http://xahoi.com.vn/thu-gian.rss"};
	
	//giaoduc.net.vn
	public static String[] GIAODUC_CATEGORY = {"Trang chủ", "Giáo dục 24h", "Xã hội", "Quốc tế", "Vì khát vọng Việt",
												"Bạn đọc", "Kinh tế", "Du học", "Thể thao", "Văn hóa", "Sức khỏe", "Giáo dục quốc phòng"};
	public static String[] GIAODUC_RSS = {"http://giaoduc.net.vn/RSS/Feed.aspx",
										"http://giaoduc.net.vn/RSS/Giao-duc-24h/5.rss",
										"http://giaoduc.net.vn/RSS/Xa-hoi/15.rss",
										"http://giaoduc.net.vn/RSS/Quoc-te/16.rss",
										"http://giaoduc.net.vn/RSS/Vi-khat-vong-Viet/440.rss",
										"http://giaoduc.net.vn/RSS/Ban-doc/24.rss",
										"http://giaoduc.net.vn/RSS/Kinh-te/13.rss",
										"http://giaoduc.net.vn/RSS/Du-hoc/272.rss",
										"http://giaoduc.net.vn/RSS/The-thao/18.rss",
										"http://giaoduc.net.vn/RSS/Van-hoa/20.rss",
										"http://giaoduc.net.vn/RSS/Suc-khoe/11.rss",
										"http://giaoduc.net.vn/RSS/Giao-duc-Quoc-phong/32.rss"};
	
	//gdtd.vn
	public static String[] GIAODUCTHOIDAI_CATEGORY = {"Trang chủ", "Chính trị", "Giáo dục", "Kinh tế", "Văn hóa",
													"Xã hội", "Thế giới", "Thể thao", "Khoa học - Công nghệ", "Giải trí",
													"Chính sách giáo dục", "Bạn đọc viết"};
	public static String[] GIAODUCTHOIDAI_RSS = {"http://www.gdtd.vn/rss/index.rss",
												"http://www.gdtd.vn/channel/3002/index.rss",
												"http://www.gdtd.vn/channel/2741/index.rss",
												"http://www.gdtd.vn/channel/2780/index.rss",
												"http://www.gdtd.vn/channel/2776/index.rss",
												"http://www.gdtd.vn/channel/2773/index.rss",
												"http://www.gdtd.vn/channel/2767/index.rss",
												"http://www.gdtd.vn/channel/2770/index.rss",
												"http://www.gdtd.vn/channel/2779/index.rss",
												"http://www.gdtd.vn/channel/2788/index.rss",
												"http://www.gdtd.vn/channel/3101/index.rss",
												"http://www.gdtd.vn/channel/3062/index.rss"};
	
	//anninhthudo.vn
	public static String[] ANNINHTHUDO_CATEGORY = {"Trang chủ", "Thời sự", "An ninh đời sống", "Xã hội", "Phóng sự",
												"Quốc phòng", "Quốc tế", "Kỳ lạ", "Thể thao", "Giải trí", "Kinh doanh",
												"Lối sống", "Ô tô - Xe máy", "Khỏe & đẹp", "Vấn đề và dư luận", "Bạn đọc"};
	public static String[] ANNINHTHUDO_RSS = {"http://www.anninhthudo.vn/Modules/Rss/Feed.aspx",
											"http://www.anninhthudo.vn/_RSS_/3.rss",
											"http://www.anninhthudo.vn/_RSS_/80.rss",
											"http://www.anninhthudo.vn/_RSS_/5.rss",
											"http://www.anninhthudo.vn/_RSS_/92.rss",
											"http://www.anninhthudo.vn/_RSS_/163.rss",
											"http://www.anninhthudo.vn/_RSS_/7.rss",
											"http://www.anninhthudo.vn/_RSS_/33.rss",
											"http://www.anninhthudo.vn/_RSS_/9.rss",
											"http://www.anninhthudo.vn/_RSS_/8.rss",
											"http://www.anninhthudo.vn/_RSS_/6.rss",
											"http://www.anninhthudo.vn/_RSS_/69.rss",
											"http://www.anninhthudo.vn/_RSS_/136.rss",
											"http://www.anninhthudo.vn/_RSS_/57.rss",
											"http://www.anninhthudo.vn/_RSS_/116.rss",
											"http://www.anninhthudo.vn/_RSS_/13.rss"};
	
	//antg.cand.com.vn
	public static String[] ANNINHTHEGIOI_CATEGORY = {"Sự kiện & bình luận", "Hậu trường", "Kinh tế - Văn hóa - Khoa học", 
													"Hồ sơ mật", "Phóng sự", "Hồ sơ intepol", "Vụ án nổi tiếng", "Tư liệu"};
	public static String[] ANNINHTHEGIOI_RSS = {"http://antg.cand.com.vn/vi-VN/sukien.rss",
												"http://antg.cand.com.vn/vi-VN/hautruong.rss",
												"http://antg.cand.com.vn/vi-VN/ktvhkh.rss",
												"http://antg.cand.com.vn/vi-VN/hosomat.rss",
												"http://antg.cand.com.vn/vi-VN/phongsu.rss",
												"http://antg.cand.com.vn/vi-VN/hosointepol.rss",
												"http://antg.cand.com.vn/vi-VN/vuan.rss",
												"http://antg.cand.com.vn/vi-VN/tulieu.rss"};
	
	//cand.com.vn
	public static String[] CONGANNHANDAN_CATEGORY = {"Thời sự", "Xã hội", "Quốc tế", "Kinh tế", "Văn hóa", "Pháp luật",
													"Thể thao", "KH-CN", "Người nổi tiếng", "Nhịp cầu nhân ái", 
													"Tội phạm từ A-Z", "Công an trong lòng nhân dân", "Sự kiện - Bình luận",
													"Thế giới phương tiện", "Phóng sự - Tư liệu", "Sự kiện - Bình luận", "Ý kiến bạn đọc",
													"Giao lưu trực tuyến"};
	public static String[] CONGANNHANDAN_RSS = {"http://www.cand.com.vn/vi-VN/thoisu.rss",
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
	
	//phapluattp.vn
	public static String[] PHAPLUATTP_CATEGORY = {"Chính trị", "Kinh tế", "Xã hội", "Thế giới", "Nhịp sống đô thị",
												"Giáo dục", "Văn bản mới", "Văn hóa giải trí", "Tư vấn pháp luật", "Trang bạn đọc",
												"Thông tin và thị trường", "Hỏi & đáp pháp luật", "Thể thao", "Tạp chí kỷ nguyên số",
												"Tạp chí sức khỏe và gia đình", "Tạp chí pháp luật", "Đô thị", "Lịch tư vấn pháp luật",
												"Văn bản pháp luật", "Tin ảnh", "Giải trí cuối tuần", "Nguyệt san pháp luật", "Bạn đọc viết"};
	public static String[] PHAPLUATTP_RSS = {"http://phapluattp.vn/chinh-tri.rss",
											"http://phapluattp.vn/kinh-te.rss",
											"http://phapluattp.vn/xa-hoi.rss",
											"http://phapluattp.vn/the-gioi.rss",
											"http://phapluattp.vn/nhip-song-do-thi.rss",
											"http://phapluattp.vn/giao-duc.rss",
											"http://phapluattp.vn/van-ban-moi.rss",
											"http://phapluattp.vn/van-hoa-giai-tri.rss",
											"http://phapluattp.vn/tu-van-phap-luat.rss",
											"http://phapluattp.vn/trang-ban-doc.rss",
											"http://phapluattp.vn/thong-tin-va-thi-truong.rss",
											"http://phapluattp.vn/hoi--dap-phap-luat.rss",
											"http://phapluattp.vn/the-thao.rss",
											"http://phapluattp.vn/tap-chi-ky-nguyen-so.rss",
											"http://phapluattp.vn/tap-chi-suc-khoe-gia-dinh.rss",
											"http://phapluattp.vn/tap-chi-phap-luat.rss",
											"http://phapluattp.vn/do-thi.rss",
											"http://phapluattp.vn/lich-tu-van-phap-luat.rss",
											"http://phapluattp.vn/van-ban-phap-luat.rss",
											"http://phapluattp.vn/tin-anh.rss",
											"http://phapluattp.vn/giai-tri-cuoi-tuan.rss",
											"http://phapluattp.vn/nguyet-san-phap-luat.rss",
											"http://phapluattp.vn/ban-doc-viet.rss"};
	
	
	//khoahoc.com.vn
	public static String[] KHOAHOC_CATEGORY = {"Trang chủ", "Công nghệ mới", "Khoa học vũ trụ", "Khoa học máy tính",
											"Phát minh khoa học", "Sinh vật học", "Khảo cổ học", "Y học - cuộc sống",
											"Môi trường", "Đại dương học", "Thế giới động vật", "Ứng dụng", "Khám phá",
											"1001 bí ẩn", "Câu chuyện khoa học", "Công trình khoa học", "Sự kiện khoa học",
											"Thư viện ảnh", "Góc hài hước", "Khoa học & bạn đọc"};
	public static String[] KHOAHOC_RSS = {"http://www.khoahoc.com.vn/rss/index.aspx",
										"http://www.khoahoc.com.vn/congnghemoi/cong-nghe-moi/rss.aspx",
										"http://www.khoahoc.com.vn/khampha/vu-tru/rss.aspx",
										"http://www.khoahoc.com.vn/congnghemoi/may-tinh/rss.aspx",
										"http://www.khoahoc.com.vn/congnghemoi/phat-minh/rss.aspx",
										"http://www.khoahoc.com.vn/khampha/sinh-vat-hoc/rss.aspx",
										"http://www.khoahoc.com.vn/khampha/khao-co-hoc/rss.aspx",
										"http://www.khoahoc.com.vn/doisong/yhoc/rss.aspx",
										"http://www.khoahoc.com.vn/doisong/moi-truong/rss.aspx",
										"http://www.khoahoc.com.vn/khampha/dai-duong-hoc/rss.aspx",
										"http://www.khoahoc.com.vn/khampha/the-gioi-dong-vat/rss.aspx",
										"http://www.khoahoc.com.vn/doisong/ung-dung/rss.aspx",
										"http://www.khoahoc.com.vn/khampha/kham-pha/rss.aspx",
										"http://www.khoahoc.com.vn/khampha/1001-bi-an/rss.aspx",
										"http://www.khoahoc.com.vn/sukien/cau-chuyen/rss.aspx",
										"http://www.khoahoc.com.vn/sukien/cong-trinh/rss.aspx",
										"http://www.khoahoc.com.vn/sukien/su-kien/rss.aspx",
										"http://www.khoahoc.com.vn/giaitri/thu-vien-anh/rss.aspx",
										"http://www.khoahoc.com.vn/giaitri/hai-huoc/rss.aspx",
										"http://www.khoahoc.com.vn/bandoc/ban-doc/rss.aspx"};
	
	//thongtincongnghe.com.vn
	public static String[] THONGTINCONGNGHE_CATEGORY = {"Tin mới", "Chuyên mục viễn thông", "Chuyên mục CNTT", "Chuyên mục điện tử",
													"Chuyên mục máy tính", "Chuyên mục phần mềm", "Chuyên mục điện thoại","Chuyên mục thiết bị số",
													"Thủ thuật phần mềm"};
	public static String[] THONGTINCONGNGHE_RSS = {"http://feeds.thongtincongnghe.com/ttcn",
													"http://feeds.thongtincongnghe.com/ttcn/vienthong",
													"http://feeds.thongtincongnghe.com/ttcn/cntt",
													"http://feeds.thongtincongnghe.com/ttcn/dientu",
													"http://feeds.thongtincongnghe.com/ttcn/maytinh",
													"http://feeds.thongtincongnghe.com/ttcn/phanmem",
													"http://feeds.thongtincongnghe.com/ttcn/dienthoai",
													"http://feeds.thongtincongnghe.com/ttcn/thietbiso"};
	
	//ictnews.vn
	public static String[] ICTNEWS_CATEGORY = {"Siêu thị số","Internet",
												"CNTT", "Doanh nghiệp", "Game", "Giải trí"};
	public static String[] ICTNEWS_RSS = {
										"http://ictnews.vn/home/Handlers/RssHandler.ashx?ChannelID=42",
										"http://ictnews.vn/home/Handlers/RssHandler.ashx?ChannelID=77",
										"http://ictnews.vn/home/Handlers/RssHandler.ashx?ChannelID=4",
										"http://ictnews.vn/home/Handlers/RssHandler.ashx?ChannelID=94",
										"http://ictnews.vn/home/Handlers/RssHandler.ashx?ChannelID=21",
										"http://ictnews.vn/home/Handlers/RssHandler.ashx?ChannelID=109"};
	
	
	//tinhte.vn
	public static String[] TINHTE_CATEGORY = {"Trang chủ"};
	public static String[] TINHTE_RSS = {"http://feeds.feedburner.com/tinhte?format=xml"};
	
	//cafeauto.vn
	public static String[] CAFEAUTO_CATEGORY = {"Thị trường", "Ô tô", "Xe máy", "Đánh giá", "Khám phá", "Tiện ích",
												"Đường đua"};
	public static String[] CAFEAUTO_RSS = {"http://cafeauto.vn/thi-truong.rss",
											"http://cafeauto.vn/o-to.rss",
											"http://cafeauto.vn/xe-may.rss",
											"http://cafeauto.vn/danh-gia.rss",
											"http://cafeauto.vn/kham-pha.rss",
											"http://cafeauto.vn/tien-ich.rss",
											"http://cafeauto.vn/duong-dua.rss"};
	
	//autopro.com.vn
	public static String[] AUTOPRO_CATEGORY = {"Trang chủ", "Tin tức", "Tin trong nước", "Tin quốc tế", "Đánh giá xe", 
											"Đánh giá Ô tô", "Đánh giá xe máy", "Văn hóa xe", "Xem chơi", "Kỹ thuật & tư vấn",
											"Kỹ thuật", "Tư vấn", "Xe máy", "Xe đua - đua xe", "Đua xe", "Xe đua", "Me - Pro"};
	public static String[] AUTOPRO_RSS = {"http://autopro.com.vn/home.rss",
										"http://autopro.com.vn/tin-tuc.rss",
										"http://autopro.com.vn/tin-tuc/trong-nuoc.rss",
										"http://autopro.com.vn/tin-tuc/quoc-te.rss",
										"http://autopro.com.vn/danh-gia-xe.rss",
										"http://autopro.com.vn/danh-gia-xe/oto.rss",
										"http://autopro.com.vn/danh-gia-xe/xe-may.rss",
										"http://autopro.com.vn/van-hoa-xe.rss",
										"http://autopro.com.vn/van-hoa-xe/xem-choi.rss",
										"http://autopro.com.vn/ky-thuat-tu-van.rss",
										"http://autopro.com.vn/ky-thuat-tu-van/ky-thuat.rss",
										"http://autopro.com.vn/ky-thuat-tu-van/tu-van.rss",
										"http://autopro.com.vn/xe-may.rss",
										"http://autopro.com.vn/xe-dua-dua-xe.rss",
										"http://autopro.com.vn/xe-dua-dua-xe/dua-xe.rss",
										"http://autopro.com.vn/xe-dua-dua-xe/xe-dua.rss",
										"http://autopro.com.vn/autopro-ban-be.rss"};
	
	//batdongsan.com.vn
	public static String[] BATDONGSAN_CATEGORY = {"Xây dựng", "Kiến trúc", "Phong thủy", "Tin tức bất động sản",
												"Nội ngoại thất", "Các chủ đề bất động sản"};
	public static String[] BATDONGSAN_RSS = {"http://batdongsan.com.vn/Modules/RSS/RssDetail.aspx?catid=30&typeid=2",
											"http://batdongsan.com.vn/Modules/RSS/RssDetail.aspx?catid=114&typeid=2",
											"http://batdongsan.com.vn/Modules/RSS/RssDetail.aspx?catid=21&typeid=2",
											"http://batdongsan.com.vn/Modules/RSS/RssDetail.aspx?catid=87&typeid=2",
											"http://batdongsan.com.vn/Modules/RSS/RssDetail.aspx?catid=112&typeid=2",
											"http://batdongsan.com.vn/Modules/RSS/RssDetail.aspx?catid=0&typeid=8"};
	
	//landtoday.net
	public static String[] LANDTODAY_CATEGORY = {"Nổi bật", "Tin tức, sự kiện", "Thời sự", "Chính sách", "Đầu tư, xây dựng",
												"Nhìn ra thế giới", "Doanh nghiệp", "Doanh nhân", "Hoạt động doanh nghiệp",
												"Nghiên cứu thị trường", "Bất động sản và các chỉ số", "Hỗ trợ", "Thông tin quy hoạch",
												"Khám phá", "Không gian sống", "Trắc nghiệm", "Phong thủy", "Thế giới kiến trúc",
												"Dự án mới"};
	public static String[] LANDTODAY_RSS = {"http://landtoday.net/rss/chuyenmucphu/moinong/index.aspx",
											"http://landtoday.net/rss/tintuc/index.aspx",
											"http://landtoday.net/rss/tintuc/thoisu/index.aspx",
											"http://landtoday.net/rss/tintuc/chinhsach/index.aspx",
											"http://landtoday.net/rss/tintuc/xaydung/index.aspx",
											"http://landtoday.net/rss/nhin-ra-the-gioi/index.aspx",
											"http://landtoday.net/rss/doanhnghiep/index.aspx",
											"http://landtoday.net/rss/doanhnghiep/doanh-nhan/index.aspx",
											"http://landtoday.net/rss/doanhnghiep/hoatdongdoanhnghiep/index.aspx",
											"http://landtoday.net/rss/nghiencuutt/index.aspx",
											"http://landtoday.net/rss/nghiencuutt/bdsvaulpi/index.aspx",
											"http://landtoday.net/rss/hotro/index.aspx",
											"http://landtoday.net/rss/hotro/thongtinquyhoach/index.aspx",
											"http://landtoday.net/rss/khampha/index.aspx",
											"http://landtoday.net/rss/khampha/khonggiansong/index.aspx",
											"http://landtoday.net/rss/khampha/trac-nghiem/index.aspx",
											"http://landtoday.net/rss/khampha/phongthuy/index.aspx",
											"http://landtoday.net/rss/khampha/kientructhegioi/index.aspx",
											"http://landtoday.net/rss/thongtinduan/index.aspx"};
	
	//cafeland.vn
	public static String[] CAFELAND_CATEGORY = {"Kinh tế vĩ mô", "Thị trường", "Dự án mới", "Phân tích - nhận định",
												"Xu hướng - cẩm nang", "Doanh nhân", "Bạn đọc viết"};
	public static String[] CAFELAND_RSS = {"http://cafeland.vn/thoi-su.rss",
											"http://cafeland.vn/tin-tuc.rss",
											"http://cafeland.vn/du-an.rss",
											"http://cafeland.vn/phan-tich.rss",
											"http://cafeland.vn/xu-huong.rss",
											"http://doanhnhan.cafeland.vn/doanh-nhan.rss",
											"http://cafeland.vn/bandoc/forums/-/index.rss"};
	
	//cafeF.vn
	public static String[] CAFEF_CATEGORY = {"Trang chủ", "Tin mới", "Thị trường chứng khoán", "Bất động sản",
											"Doanh nghiệp", "Tài chính - ngân hàng", "Tài chính quốc tế", "Kinh tế vĩ mô",
											"Hàng hóa - Nguyên liệu", "Doanh nhân", "Hội nghỉ hội thảo", "Doanh nghiệp giới thiệu",
											"Lịch sự kiện thị trường", "Tin tức doanh nghiệp niêm yết"};
	public static String[] CAFEF_RSS = {"http://cafef.vn/Trang-chu.rss",
										"http://cafef.vn/Tin-moi.rss",
										"http://cafef.vn/Thi-truong-chung-khoan.rss",
										"http://cafef.vn/Bat-dong-san.rss",
										"http://cafef.vn/Doanh-nghiep.rss",
										"http://cafef.vn/Tai-chinh-ngan-hang.rss",
										"http://cafef.vn/Tai-chinh-quoc-te.rss",
										"http://cafef.vn/Kinh-te-vi-mo.rss",
										"http://cafef.vn/Hang-hoa-nguyen-lieu.rss",
										"http://cafef.vn/Doanh-nhan.rss",
										"http://cafef.vn/Hoi-nghi-hoi-thao.rss",
										"http://cafef.vn/Doanh-nghiep-gioi-thieu.rss",
										"http://cafef.vn/Lich-su-kien.rss",
										"http://cafef.vn/Tin-doanh-nghiep.rss"};
	
	//vneconomy.vn
	public static String[] VNECONOMY_CATEGORY = {"Trang chủ", "Thời sự", "Doanh nhân", "Tài chính", "Chứng khoán",
												"Thị trường", "Bất động sản", "Thế giới", "Cuộc sống số", "Xe 360"};
	public static String[] VNECONOMY_RSS = {"http://vneconomy.vn/rss/trang-chu",
											"http://vneconomy.vn/rss/thoi-su",
											"http://vneconomy.vn/rss/doanh-nhan",
											"http://vneconomy.vn/rss/tai-chinh",
											"http://vneconomy.vn/rss/chung-khoan",
											"http://vneconomy.vn/rss/thi-truong",
											"http://vneconomy.vn/rss/bat-dong-san",
											"http://vneconomy.vn/rss/the-gioi",
											"http://vneconomy.vn/rss/cuoc-song-so",
											"http://vneconomy.vn/rss/xe-360"};
	
	//stockbiz.vn
	public static String[] STOCKBIZ_CATEGORY = {"Tin tức", "Tin tức quan trọng", "Thị trường", "Tài chính - Ngân hàng",
												"Doanh nghiệp", "Kinh tế đầu tư", "Chứng khoán thế giới", "Thị trường bất động sản"};
	public static String[] STOCKBIZ_RSS = {"http://www.stockbiz.vn/RSS/News/All.ashx",
											"http://www.stockbiz.vn/RSS/News/TopStories.ashx",
											"http://www.stockbiz.vn/RSS/News/Market.ashx",
											"http://www.stockbiz.vn/RSS/News/Financial.ashx",
											"http://www.stockbiz.vn/RSS/News/Company.ashx",
											"http://www.stockbiz.vn/RSS/News/Economy.ashx",
											"http://www.stockbiz.vn/RSS/News/International.ashx",
											"http://www.stockbiz.vn/RSS/News/RealEstate.ashx"};
	
	//vietstock.vn
	public static String[] VIETSTOCK_CATEGORY = {"Chứng khoán", "Doanh nghiệp", "Bất động sản", "Hàng hóa",
												"Tài chính", "Vĩ mô", "Kinh tế ngành", "Thế giới", "Đông dương",
												"Vietstock Blog", "Thời sự", "Nhận định thị trường", "Báo cáo phân tích"};
	public static String[] VIETSTOCK_RSS = {"http://vietstock.vn/144/chung-khoan.rss",
											"http://vietstock.vn/733/doanh-nghiep.rss",
											"http://vietstock.vn/763/bat-dong-san.rss",
											"http://vietstock.vn/2/hang-hoa.rss",
											"http://vietstock.vn/734/tai-chinh.rss",
											"http://vietstock.vn/761/vi-mo-dau-tu.rss",
											"http://vietstock.vn/768/kinh-te-nganh.rss",
											"http://vietstock.vn/736/the-gioi.rss",
											"http://vietstock.vn/1317/dong-duong.rss",
											"http://vietstock.vn/3355/vietstock-blog.rss",
											"http://vietstock.vn/1351/thoi-su.rss",
											"http://vietstock.vn/3111/nhan-dinh-thi-truong.rss",
											"http://vietstock.vn/3112/bao-cao-phan-tich.rss"};
	
	//thesaigontimes.vn
	public static String[] THESAIGONTIMES_CATEGORY = {"Tin nổi bật", "Tin đọc nhiều", "Tin ảnh", "Ô tô", "Nông sản",
													"Giải trí", "Xã hội", "Diễn đàn", "Doanh nghiệp", "Tài chính - ngân hàng",
													"Kinh doanh", "Đô thị", "Công nghệ", "Du lịch", "Thế giới"};
	public static String[] THESAIGONTIMES_RSS = {"http://www.thesaigontimes.vn/rss/tinnoibat/",
												"http://www.thesaigontimes.vn/rss/tindocnhieunhat/",
												"http://www.thesaigontimes.vn/rss/tinanh/",
												"http://www.thesaigontimes.vn/rss/oto/",
												"http://www.thesaigontimes.vn/rss/nongsan/",
												"http://www.thesaigontimes.vn/rss/giaitri/",
												"http://www.thesaigontimes.vn/rss/xahoi/",
												"http://www.thesaigontimes.vn/rss/diendan/",
												"http://www.thesaigontimes.vn/rss/doanhnghiep/",
												"http://www.thesaigontimes.vn/rss/taichinh/",
												"http://www.thesaigontimes.vn/rss/kinhdoanh/",
												"http://www.thesaigontimes.vn/rss/dothi/",
												"http://www.thesaigontimes.vn/rss/congnghe/",
												"http://www.thesaigontimes.vn/rss/dulich/",
												"http://www.thesaigontimes.vn/rss/thegioi/"};
	
	//bongdaplus.vn
	public static String[] BONGDAPLUS_CATEGORY = {"Tin nổi bật", "Việt Nam", "Bóng đá phong trào", "Anh", "Tây Ban Nha",
													"Italia", "Đức", "Pháp", "Thế giới", "Bạn đọc viết", "Champions League",
													"Chuyển nhượng", "Tennis", "Thể thao", "Ngôi sao", "TIP", "Ảnh chế", "Game bóng đá",
													"Điểm tin", "CAN 2013", "Tin vắn", "Bóng đá và cuộc sống", "Cúp đua xe đạp 2013", 
													"Camera sân cỏ", "Theo dòng sự kiện", "Chuyện cuối tuần", "NewsLetter", "Công nghệ",
													"Fan Zone", "Top 10 sự kiện trong ngày"};
	public static String[] BONGDAPLUS_RSS = {"http://bongdaplus.vn/Modules/Rss/Feed.aspx",
											"http://bongdaplus.vn/_RSS_/1.rss",
											"http://bongdaplus.vn/_RSS_/329.rss",
											"http://bongdaplus.vn/_RSS_/44.rss",
											"http://bongdaplus.vn/_RSS_/26.rss",
											"http://bongdaplus.vn/_RSS_/13.rss",
											"http://bongdaplus.vn/_RSS_/27.rss",
											"http://bongdaplus.vn/_RSS_/29.rss",
											"http://bongdaplus.vn/_RSS_/5.rss",
											"http://bongdaplus.vn/_RSS_/33.rss",
											"http://bongdaplus.vn/_RSS_/292.rss",
											"http://bongdaplus.vn/_RSS_/175.rss",
											"http://bongdaplus.vn/_RSS_/67.rss",
											"http://bongdaplus.vn/_RSS_/73.rss",
											"http://bongdaplus.vn/_RSS_/31.rss",
											"http://bongdaplus.vn/_RSS_/210.rss",
											"http://bongdaplus.vn/_RSS_/328.rss",
											"http://bongdaplus.vn/_RSS_/42.rss",
											"http://bongdaplus.vn/_RSS_/165.rss",
											"http://bongdaplus.vn/_RSS_/240.rss",
											"http://bongdaplus.vn/_RSS_/66.rss",
											"http://bongdaplus.vn/_RSS_/159.rss",
											"http://bongdaplus.vn/_RSS_/327.rss",
											"http://bongdaplus.vn/_RSS_/262.rss",
											"http://bongdaplus.vn/_RSS_/241.rss",
											"http://bongdaplus.vn/_RSS_/263.rss",
											"http://bongdaplus.vn/_RSS_/302.rss",
											"http://bongdaplus.vn/_RSS_/336.rss",
											"http://bongdaplus.vn/_RSS_/158.rss",
											"http://bongdaplus.vn/_RSS_/264.rss"};
	
	//bongda24h.vn
	public static String[] BONGDA24H_CATEGORY = {"Tin nóng", "Bóng đá Anh", "Bóng đá Tây Ban Nha", "Bóng đá Châu Âu",
												"Bóng đá Việt Nam", "Bóng đá Italia", "Bóng đá Đức", "Bóng đá Pháp", 
												"Sự kiện - bình luận", "Tin chuyển nhượng", "Bạn đọc viết", "Thử làm chuyên gia",
												"Hậu trường", "Người đẹp"};
	public static String[] BONGDA24H_RSS = {"http://bongda24h.vn/RSS/279.rss",
											"http://bongda24h.vn/RSS/172.rss",
											"http://bongda24h.vn/RSS/180.rss",
											"http://bongda24h.vn/RSS/184.rss",
											"http://bongda24h.vn/RSS/168.rss",
											"http://bongda24h.vn/RSS/176.rss",
											"http://bongda24h.vn/RSS/193.rss",
											"http://bongda24h.vn/RSS/197.rss",
											"http://bongda24h.vn/RSS/278.rss",
											"http://bongda24h.vn/RSS/187.rss",
											"http://bongda24h.vn/RSS/206.rss",
											"http://bongda24h.vn/RSS/204.rss",
											"http://bongda24h.vn/RSS/188.rss",
											"http://bongda24h.vn/RSS/288.rss"};
	
	//dulichvietnam.com.vn
	public static String[] DULICHVIETNAM_CATEGORY = {"Trang chủ", "Tin du lịch", "Danh thắng", "Văn hóa", "Lễ hội",
													"Ẩm thực", "Cẩm nang du lịch", "Du lịch 365", "Chuyến đi của tôi", 
													"Thế giới với Việt Nam", "Du lịch như sao", "Hoạt động ngành", "Khuyến mãi"};
	public static String[] DULICHVIETNAM_RSS = {"http://www.dulichvietnam.com.vn/rss/",
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
	public static String[] AFAMILY_CATEGORY = {"Trang chủ", "Đẹp", "Đời sống", "Ăn ngon - Khéo tay", "Tình yêu - Hôn nhân", "Sức khỏe",
												"Tâm sự", "Mẹ & Bé", "Nhà hay", "Hậu trường", "Giải trí", "Chuyện lạ"};
	public static String[] AFAMILY_RSS = {"http://afamily.vn/trang-chu.rss",
											"http://afamily.vn/dep.rss",
											"http://afamily.vn/doi-song.rss",
											"http://afamily.vn/an-ngon.rss",
											"http://afamily.vn/tinh-yeu-hon-nhan.rss",
											"http://afamily.vn/suc-khoe.rss",
											"http://afamily.vn/me-va-be.rss",
											"http://afamily.vn/nha-hay.rss",
											"http://afamily.vn/hau-truong.rss",
											"http://afamily.vn/giai-tri.rss",
											"http://afamily.vn/chuyen-la.rss"};
	
	//giadinh.net.vn
	public static String[] GIADINH_CATEGORY = {"Xã hội", "Gia đình", "Văn hóa", "Pháp luật", "Thế giới", "Sức khỏe",
												"Đời sống", "Nuôi dạy con", "Mua sắm", "Làm đẹp", "Blog", "Dân số",
												"Y tế", "Dữ liệu dân số", "Chia sẻ"};
	public static String[] GIADINH_RSS = {"http://giadinh.net.vn/rss/xa-hoi",
										"http://giadinh.net.vn/rss/gia-dinh",
										"http://giadinh.net.vn/rss/van-hoa",
										"http://giadinh.net.vn/rss/phap-luat",
										"http://giadinh.net.vn/rss/the-gioi",
										"http://giadinh.net.vn/rss/suc-khoe",
										"http://giadinh.net.vn/rss/doi-song",
										"http://giadinh.net.vn/rss/nuoi-day-con",
										"http://giadinh.net.vn/rss/mua-sam",
										"http://giadinh.net.vn/rss/lam-dep",
										"http://giadinh.net.vn/rss/blog",
										"http://giadinh.net.vn/rss/dan-so",
										"http://giadinh.net.vn/rss/y-te",
										"http://giadinh.net.vn/rss/du-lieu-dan-so",
										"http://giadinh.net.vn/rss/chia-se"};
	
	//tiin.vn
	public static String[] TIIN_CATEGORY = {"Trang chủ", "Sao", "Nhạc", "Phim", "Sành", "Đẹp", "Thể", "24H",
											"Sống", "Học", "Yêu", "Vui", "Thiện", "Khéo", "Chơi", "Quà"};
	public static String[] TIIN_RSS = {"http://www.tiin.vn/rss/home",
										"http://www.tiin.vn/rss/sao",
										"http://www.tiin.vn/rss/nhac",
										"http://www.tiin.vn/rss/phim",
										"http://www.tiin.vn/rss/sanh",
										"http://www.tiin.vn/rss/dep",
										"http://www.tiin.vn/rss/the",
										"http://www.tiin.vn/rss/24h",
										"http://www.tiin.vn/rss/song",
										"http://www.tiin.vn/rss/hoc",
										"http://www.tiin.vn/rss/yeu",
										"http://www.tiin.vn/rss/vui",
										"http://www.tiin.vn/rss/thien",
										"http://www.tiin.vn/rss/kheo",
										"http://www.tiin.vn/rss/choi",
										"http://www.tiin.vn/rss/qua"};
	
	//zing.vn
	public static String[] ZING_CATEGORY = {"Trang chủ", "Tin mới", "Đời sống", "Thế giới", "Thị trường", "Thể thao",
											"Sống trẻ", "Sành điệu", "Xe 360", "Âm nhạc", "Công nghệ", "Phim ảnh",
											"Blog", "Đẹp"};
	public static String[] ZING_RSS = {"http://news.zing.vn/rss/new.html",
										"http://news.zing.vn/rss/home.html",
										"http://news.zing.vn/rss/doi-song.html",
										"http://news.zing.vn/rss/the-gioi.html",
										"http://news.zing.vn/rss/kinh-doanh.html",
										"http://news.zing.vn/rss/the-thao.html",
										"http://news.zing.vn/rss/nhip-song-tre.html",
										"http://news.zing.vn/rss/sanh-dieu.html",
										"http://news.zing.vn/rss/oto-xe-may.html",
										"http://news.zing.vn/rss/am-nhac.html",
										"http://news.zing.vn/rss/cong-nghe.html",
										"http://news.zing.vn/rss/phim-anh.html",
										"http://news.zing.vn/rss/blog.html",
										"http://news.zing.vn/rss/dep.html"};
	
	//eva.vn
	public static String[] EVA_CATEGORY = {"Trang chủ", "Thời trang", "Làm đẹp", "Làng sao", "Eva tám", "Bà bầu", "Làm mẹ",
											"Nhà đẹp", "Bếp Eva", "Mua sắm - Giá cả", "Đi đâu - Xem gì", "Tình yêu - Giới tính",
											"Eva sành điệu"};
	public static String[] EVA_RSS = {"http://www.eva.vn/rss/rss.php",
										"http://www.eva.vn/rss/rss.php/36",
										"http://www.eva.vn/rss/rss.php/58",
										"http://www.eva.vn/rss/rss.php/20",
										"http://www.eva.vn/rss/rss.php/66",
										"http://www.eva.vn/rss/rss.php/85",
										"http://www.eva.vn/rss/rss.php/10",
										"http://www.eva.vn/rss/rss.php/169",
										"http://www.eva.vn/rss/rss.php/162",
										"http://www.eva.vn/rss/rss.php/2",
										"http://www.eva.vn/rss/rss.php/40",
										"http://www.eva.vn/rss/rss.php/3",
										"http://www.eva.vn/rss/rss.php/173"};
	
	//http://antgct.cand.com.vn
	public static String[] ANNINHTHEGIOI_CUOITHANG_CATEGORY = {"Chuyên đề", "Sổ tay", "Khoa học & Văn minh", "Người trong cuộc", "Nhàn đàm", "Nhân vật","Chuyện khó tin có thật"};
	public static String[] ANNINHTHEGIOI_CUOITHANG_RSS = {"http://antgct.cand.com.vn/vi-VN/chuyende.rss",
														"http://antgct.cand.com.vn/vi-VN/sotay.rss",
														"http://antgct.cand.com.vn/vi-VN/khoahoc-vanminh.rss",
														"http://antgct.cand.com.vn/vi-VN/nguoitrongcuoc.rss",
														"http://antgct.cand.com.vn/vi-VN/nhandam.rss",
														"http://antgct.cand.com.vn/vi-VN/nhanvat.rss",
														"http://antgct.cand.com.vn/vi-VN/chuyenkhotin.rss"};
	
	//http://cstc.cand.com.vn
	public static String[] CANHSATTOANCAU_CATEGORY = {"Phóng sự - Ghi chép", "Nhân vật - Sự kiện nổi bật", "Giải trí - Thể thao", "Hôn nhân - Cuộc sống",
													"Hồ sơ", "Ngược sáng", "Tội phạm", "Cuộc sống"};
	public static String[] CANHSATTOANCAU_RSS = {"http://cstc.cand.com.vn/vi-VN/phongsu-ghichep.rss",
												"http://cstc.cand.com.vn/vi-VN/nhanvat-sukien.rss",
												"http://cstc.cand.com.vn/vi-VN/giaitri-thethao.rss",
												"http://cstc.cand.com.vn/vi-VN/honnhan-csong.rss",
												"http://cstc.cand.com.vn/vi-VN/hoso.rss",
												"http://cstc.cand.com.vn/vi-VN/nguocsang.rss",
												"http://cstc.cand.com.vn/vi-VN/toipham.rss",
												"http://cstc.cand.com.vn/vi-VN/cuocsong.rss"};
	
	//http://vnca.cand.com.vn
	public static String[] VANNGHECONGAN_CATEGORY = {"Đời sống văn hóa", "Tư liệu văn hóa", "Lý luận", "Thơ", "Truyền thống", "Truyện", "Diễn đàn"};
	public static String[] VANNGHECONGAN_RSS = {"http://vnca.cand.com.vn/vi-VN/doisongvanhoa.rss",
												"http://vnca.cand.com.vn/vi-VN/tulieuvanhoa.rss",
												"http://vnca.cand.com.vn/vi-VN/lyluan.rss",
												"http://vnca.cand.com.vn/vi-VN/tho.rss",
												"http://vnca.cand.com.vn/vi-VN/truyenthong.rss",
												"http://vnca.cand.com.vn/vi-VN/truyen.rss",
												"http://vnca.cand.com.vn/vi-VN/diendan.rss"};
	
	public static String[][] NEWSPAPER_CATEGORY = {VNEXPRESS_CATEGORY, DANTRI_CATEGORY, VIETNAMNET_CATEGORY, 
										HAITUGIO_CATEGORY, TUOITRE_CATEGORY, NGUOIDUATIN_CATEGORY, VTC_CATEGORY,
										VIETBAO_CATEGORY, LAODONG_CATEGORY, NGUOILAODONG_CATEGORY, XAHOI_CATEGORY,
										GIAODUC_CATEGORY, GIAODUCTHOIDAI_CATEGORY, ANNINHTHUDO_CATEGORY, ANNINHTHEGIOI_CATEGORY,
										CONGANNHANDAN_CATEGORY, PHAPLUATTP_CATEGORY, 
										KHOAHOC_CATEGORY, THONGTINCONGNGHE_CATEGORY, ICTNEWS_CATEGORY,
										TINHTE_CATEGORY, CAFEAUTO_CATEGORY, AUTOPRO_CATEGORY, BATDONGSAN_CATEGORY,
										LANDTODAY_CATEGORY, CAFEF_CATEGORY, VNECONOMY_CATEGORY, STOCKBIZ_CATEGORY,
										VIETSTOCK_CATEGORY, THESAIGONTIMES_CATEGORY, BONGDAPLUS_CATEGORY, BONGDA24H_CATEGORY,
										DULICHVIETNAM_CATEGORY, AFAMILY_CATEGORY, 
										GIADINH_CATEGORY, TIIN_CATEGORY, ZING_CATEGORY,
										EVA_CATEGORY, ANNINHTHEGIOI_CUOITHANG_CATEGORY, CANHSATTOANCAU_CATEGORY, VANNGHECONGAN_CATEGORY};
	public static String[][] NEWSPAPER_RSS = {VNEXPRESS_RSS, DANTRI_RSS, VIETNAMNET_RSS, HAITUGIO_RSS, TUOITRE_RSS,
									NGUOIDUATIN_RSS, VTC_RSS, VIETBAO_RSS, LAODONG_RSS, NGUOILAODONG_RSS, XAHOI_RSS,
									GIAODUC_RSS, GIAODUCTHOIDAI_RSS, ANNINHTHUDO_RSS, ANNINHTHEGIOI_RSS, CONGANNHANDAN_RSS,
									PHAPLUATTP_RSS, KHOAHOC_RSS, 
									THONGTINCONGNGHE_RSS, ICTNEWS_RSS,  TINHTE_RSS,CAFEAUTO_RSS, AUTOPRO_RSS, BATDONGSAN_RSS,
									LANDTODAY_RSS, CAFEF_RSS, VNECONOMY_RSS, STOCKBIZ_RSS, VIETSTOCK_RSS, THESAIGONTIMES_RSS,
									BONGDAPLUS_RSS, BONGDA24H_RSS, DULICHVIETNAM_RSS,
									AFAMILY_RSS, GIADINH_RSS, TIIN_RSS, ZING_RSS, EVA_RSS, ANNINHTHEGIOI_CUOITHANG_RSS, CANHSATTOANCAU_RSS,
									VANNGHECONGAN_RSS};
	
	public static HashMap<String, Integer> newspaperLocation = new HashMap<String, Integer>();
	
	static {
		newspaperLocation.put("vnexpress", 0);
		newspaperLocation.put("dantri", 1);
		newspaperLocation.put("vietnamnet", 2);
		newspaperLocation.put("24h", 3);
		newspaperLocation.put("tuoitre", 4);
		newspaperLocation.put("nguoiduatin", 5);
		newspaperLocation.put("vtc", 6);
		newspaperLocation.put("vietbao", 7);
		newspaperLocation.put("laodong", 8);
		newspaperLocation.put("nguoilaodong", 9);
		newspaperLocation.put("xahoi", 10);
		newspaperLocation.put("giaoduc", 11);
		newspaperLocation.put("giaoducthoidai", 12);
		newspaperLocation.put("anninhthudo", 13);
		newspaperLocation.put("anninhthegioi", 14);
		newspaperLocation.put("congannhandan", 15);
		newspaperLocation.put("phapluattp", 16);
		newspaperLocation.put("khoahoc", 17);
		newspaperLocation.put("thongtincongnghe", 18);
		newspaperLocation.put("ictnews", 19);
		newspaperLocation.put("tinhte", 20);
		newspaperLocation.put("cafeauto", 21);
		newspaperLocation.put("autopro", 22);
		newspaperLocation.put("batdongsan", 23);
		newspaperLocation.put("landtoday", 24);
		newspaperLocation.put("cafef", 25);
		newspaperLocation.put("vneconomy", 26);
		newspaperLocation.put("stockbiz", 27);
		newspaperLocation.put("vietstock", 28);
		newspaperLocation.put("thesaigontimes", 29);
		newspaperLocation.put("bongdaplus", 30);
		newspaperLocation.put("bongda24h", 31);
		newspaperLocation.put("dulichvietnam", 32);
		newspaperLocation.put("afamily", 33);
		newspaperLocation.put("giadinh", 34);
		newspaperLocation.put("tiin", 35);
		newspaperLocation.put("zing", 36);
		newspaperLocation.put("eva", 37);
		newspaperLocation.put("anninhthegioi_ct", 38);
		newspaperLocation.put("canhsattoancau", 39);
		newspaperLocation.put("vannghecongan", 40);
	}
	
	public static HashMap<String, String> linkNewspaper = new HashMap<String, String>();
	static {
		linkNewspaper.put("dulichvietnam", "http://www.dulichvietnam.com.vn");
		linkNewspaper.put("thesaigontimes", "http://www.thesaigontimes.vn");
		linkNewspaper.put("anninhthudo", "http://www.anninhthudo.vn");
		linkNewspaper.put("giaoducthoidai", "http://www.gdtd.vn");
	}
	
	public static HashMap<String, String> NewspaperTitle = new HashMap<String, String>();
	static {
		NewspaperTitle.put("vnexpress", "Vnexpress");
		NewspaperTitle.put("dantri", "Dân trí");
		NewspaperTitle.put("vietnamnet", "Vietnamnet");
		NewspaperTitle.put("24h", "24H");
		NewspaperTitle.put("tuoitre", "Tuổi trẻ");
		NewspaperTitle.put("nguoiduatin", "Người đưa tin");
		NewspaperTitle.put("vtc", "VTC");
		NewspaperTitle.put("vietbao", "Việt báo");
		NewspaperTitle.put("laodong", "Lao động");
		NewspaperTitle.put("nguoilaodong", "Người lao động");
		NewspaperTitle.put("xahoi", "Xã hội");
		NewspaperTitle.put("giaoduc", "Giáo dục");
		NewspaperTitle.put("giaoducthoidai", "Giáo dục thời đại");
		NewspaperTitle.put("anninhthudo", "An ninh thủ đô");
		NewspaperTitle.put("anninhthegioi", "An ninh thế giới");
		NewspaperTitle.put("congannhandan", "Công an nhân dân");
		NewspaperTitle.put("phapluattp", "Pháp luật TP HCM");
		NewspaperTitle.put("khoahoc", "Khoa học");
		NewspaperTitle.put("thongtincongnghe", "Thông tin công nghệ");
		NewspaperTitle.put("ictnews", "ICTNews");
		NewspaperTitle.put("tinhte", "Tinh tế");
		NewspaperTitle.put("cafeauto", "Cafeauto");
		NewspaperTitle.put("autopro", "Autopro");
		NewspaperTitle.put("batdongsan", "Bất động sản");
		NewspaperTitle.put("landtoday", "Landtoday");
		NewspaperTitle.put("cafef", "CafeF");
		NewspaperTitle.put("vneconomy", "VnEconomy");
		NewspaperTitle.put("stockbiz", "StockBiz");
		NewspaperTitle.put("vietstock", "VietStock");
		NewspaperTitle.put("thesaigontimes", "Thời báo kinh tế Sài Gòn");
		NewspaperTitle.put("bongdaplus", "Bóng đá Plus");
		NewspaperTitle.put("bongda24h", "Bóng đá 24H");
		NewspaperTitle.put("dulichvietnam", "Du lịch Việt Nam");
		NewspaperTitle.put("afamily", "Afamily");
		NewspaperTitle.put("giadinh", "Gia đình");
		NewspaperTitle.put("tiin", "Tiin");
		NewspaperTitle.put("zing", "Zing News");
		NewspaperTitle.put("eva", "Eva");
		NewspaperTitle.put("anninhthegioi_ct", "ANTG Cuối tháng");
		NewspaperTitle.put("canhsattoancau", "Cảnh sát toàn cầu");
		NewspaperTitle.put("vannghecongan", "Văn nghệ công an");
	}
	
	public static String[] newspaper = {"vnexpress", "dantri", "vietnamnet", "24h", "tuoitre", "nguoiduatin",
										"vtc", "vietbao", "laodong", "nguoilaodong", "xahoi", "giaoduc", "giaoducthoidai",
										"anninhthudo", "anninhthegioi", "congannhandan", "phapluattp", "khoahoc", "thongtincongnghe", "ictnews",
										"tinhte", "cafeauto", "autopro", "batdongsan", "landtoday", "cafef", "vneconomy",
										"stockbiz", "vietstock", "thesaigontimes", "bongdaplus", "bongda24h",
										"dulichvietnam", "afamily", "giadinh",
										"tiin", "zing", "eva", "anninhthegioi_ct", "canhsattoancau", "vannghecongan"};
	
	public static HashMap<Integer, ArrayList<News>> listNews = new HashMap<Integer, ArrayList<News>>();
}
