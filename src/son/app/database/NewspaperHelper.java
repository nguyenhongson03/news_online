package son.app.database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import son.app.util.Variables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class NewspaperHelper extends SQLiteOpenHelper{
	private final static  String DB_NAME = "news.db";
	private final static int DB_VERSION = 1;
	private final static String DB_PATH = "/data/data/son.app.newsonline/databases/";
	
	private Context context;
	private SQLiteDatabase myDataBase;
	
	public NewspaperHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	
	public void createDataBase() throws IOException{
		 
    	boolean dbExist = checkDataBase();
 
    	if(dbExist){
    		//do nothing - database already exist
    	}else{
 
    		//By calling this method and empty database will be created into the default system path
               //of your application so we are gonna be able to overwrite that database with our database.
        	this.getReadableDatabase();
 
        	try {
 
    			copyDataBase();
 
    		} catch (IOException e) {
 
        		throw new Error("Error copying database");
 
        	}
    	}
 
    }
	
	private boolean checkDataBase(){
		 
    	SQLiteDatabase checkDB = null;
 
    	try{
    		String myPath = DB_PATH + DB_NAME;
    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
    	}catch(SQLiteException e){
 
    		//database does't exist yet.
 
    	}
 
    	if(checkDB != null){
 
    		checkDB.close();
 
    	}
 
    	return checkDB != null ? true : false;
    }
	
	private void copyDataBase() throws IOException{
		 
    	//Open your local db as the input stream
    	InputStream myInput = context.getAssets().open(DB_NAME);
 
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DB_NAME;
 
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
 
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    }
 
    public void openDataBase() throws SQLException{
 
    	//Open the database
        String myPath = DB_PATH + DB_NAME;
    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
    }
 
    @Override
	public synchronized void close() {
 
    	    if(myDataBase != null)
    		    myDataBase.close();
 
    	    super.close();
 
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		/*db.execSQL("CREATE TABLE " + TABLE_NEWSPAPER_CHOOSED + " (id INTEGER PRIMARY KEY AUTOINCREMENT, newspaper TEXT);");
		db.execSQL("CREATE TABLE " + TABLE_NEWSPAPER_NOT_CHOOSE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, newspaper TEXT);");*/
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void insert(String newspaper, int category, String tableName){
		ContentValues cv = new ContentValues();
		cv.put("newspaper", newspaper);
		cv.put("category", category);
		getWritableDatabase().insert(tableName, "newspaper", cv);
	}
	
	public void insert(String newspaper, String thumbnail, String tableName){
		ContentValues cv = new ContentValues();
		cv.put("newspaper", newspaper);
		cv.put("thumbnail", thumbnail);
		getWritableDatabase().insert(tableName, "newspaper", cv);
	}
	
	public void updateThumbnail(String newspaper, String thumbnail){
		String[] whereArgs = {newspaper};
		ContentValues cv = new ContentValues();
		cv.put("newspaper", newspaper);
		cv.put("thumbnail", thumbnail);
		getWritableDatabase().update(Variables.TABLE_NEWSPAPER_THUMBNAIL, cv, "newspaper=?", whereArgs);
	}
	
	public void delete(String newspaper, String tableName){
		String[] whereArgs = {newspaper};
		getWritableDatabase().delete(tableName, "newspaper=?", whereArgs);
	}
	
	public Cursor getNewspaperByName(String name, String tableName){
		return getReadableDatabase().rawQuery("SELECT * FROM " + tableName + " WHERE newspaper=\"" + name + "\"", null);
	}
	
	public Cursor getAll(String tableName){
		return getReadableDatabase().rawQuery("SELECT * FROM " + tableName + " ORDER BY category ASC", null);
	}
	
	public Cursor getAllCategory(String tableName){
		return getReadableDatabase().rawQuery("SELECT category FROM " + tableName + " ORDER BY category ASC", null);
	}
	
	public String getNewspaper(Cursor c){
		return c.getString(1);
	}
	
	public int getCategory(Cursor c){
		return Integer.parseInt(c.getString(2));
	}
	
	public String getThumbnail(Cursor c) {
		return c.getString(c.getColumnIndex("thumbnail"));
	}
}
