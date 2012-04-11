package cs2340.LetMeCheckMyApp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.CheckBox;

public class DatabaseHelper extends SQLiteOpenHelper {

	static final String dbName="DB";
	/*static final String employeeTable="Employees";
	static final String colID="EmployeeID";
	static final String colName="EmployeeName";
	static final String colAge="Age";
	static final String colDept="Dept";
	
	static final String deptTable="Dept";
	static final String colDeptID="DeptID";
	static final String colDeptName="DeptName";
	
	static final String viewEmps="ViewEmps";*/
	static final String taskTable="Tasks";
	static final String colVisible="visible";
	static final String colComp="isComplete";
	static final String colName="name";
	static final String colDesc="description";
	static final String colCateg="category";
	static final String colDate = "date";
	static final String colID="id";
	static final String colOwner = "owner";

	
	public DatabaseHelper(Context context) {
		super(context, dbName, null,1);
		
	}
	
	public void onCreate(SQLiteDatabase db) {
		  
		  db.execSQL("CREATE TABLE "+taskTable+" ("+
				  		colVisible+" boolean, "+
				  		colComp+" boolean, "+
				  		colName+" TEXT, "+
				  		colDesc+" TEXT, "+
				  		colCateg+" TEXT, "+
				  		colDate+" long, "+
				  		colID+ " INTEGER PRIMARY KEY , "+
				  		colOwner+ " TEXT)");
		  
		  Log.d("DatabaseHelper", "created database");
			
		  /*dont know if we need this
		    db.execSQL("CREATE TRIGGER fk_empdept_deptid " +
		    " BEFORE INSERT "+
		    " ON "+taskTable+
		    
		    " FOR EACH ROW BEGIN"+
		    " SELECT CASE WHEN ((SELECT "+colDeptID+" FROM "+deptTable+" WHERE "+colDeptID+"=new."+colDept+" ) IS NULL)"+
		    " THEN RAISE (ABORT,'Foreign Key Violation') END;"+
		    "  END;");*/
		  
		  /*or this
		    db.execSQL("CREATE VIEW "+viewTasks+
		    " AS SELECT "+taskTable+"."+colID+" AS _id,"+
		    " "+taskTable+"."+colName+","+
		    " "+taskTable+"."+colCateg+","+
		    " "+deptTable+"."+colDeptName+""+
		    " FROM "+employeeTable+" JOIN "+deptTable+
		    " ON "+employeeTable+"."+colDept+" ="+deptTable+"."+colDeptID
		    );*/
		  //Inserts pre-defined departments
		  //InsertDepts(db);  
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		  db.execSQL("DROP TABLE IF EXISTS "+taskTable);
		  onCreate(db);
	}
	
	/*public void insertTask(Task t){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		   
		   cv.put(colVisible, t.isVisible());
		   cv.put(colComp, t.isComplete());
		   cv.put(colName, t.getName());
		   cv.put(colDesc, t.getDescription());
		   cv.put(colCateg, t.getCategory());
		   cv.put(colDate, t.getCompleteDate().getTimeInMillis());
		   cv.put(colID, t.getID());
		   cv.put(colOwner, t.getUser());
		   
		   
		   db.insert(taskTable, null, cv);
		   db.close();
		   Log.d("DatabaseHelper", "inserted task: "+cv.toString());
			
	}*/
	
	//untested
	/*public int updateTask(Task t)
	  {
	   SQLiteDatabase db=this.getWritableDatabase();
	   ContentValues cv=new ContentValues();
	   cv.put(colName, t.getName());
	   cv.put(colCateg, t.getCategory());
	   cv.put(colComp, t.isComplete());
	   return db.update(taskTable, cv, colID+"=?", new String []{String.valueOf(t.getID())});
	  }
	//untested
	public void deleteTask(Task t)
	  {
	   SQLiteDatabase db=this.getWritableDatabase();
	   db.delete(taskTable,colID+"=?", new String [] {String.valueOf(t.getID())});
	   db.close();
	  }
	*/
	public Cursor getAllTasks()
	  {
	   SQLiteDatabase db=this.getReadableDatabase();
	   //Cursor cur=db.rawQuery("SELECT "+colID+" as _id,	"+colName+" from "+taskTable,new String [] {});
	   Cursor cur = db.query(taskTable, null, null, null, null, null, null);
	   Log.d("DatabaseHelper", "getAllTasks, numcols="+cur.getColumnCount());
	   return cur;
	  }
	
	public int nextID(){
		Cursor c = getAllTasks();
		if(c.moveToLast()){
			int lastID = c.getInt(6);
			return lastID+1;
		}else
			return 0;
	}
	
	/*public ArrayList<Task> getUsersTasks(String user){
		ArrayList<Task> list = new ArrayList<Task>();
		Cursor c = getAllTasks();
		while(!c.isAfterLast()){
			Log.d("DatabaseHelper", "getUSersTasks, numcols="+c.getColumnCount());
			Log.d("DatabaseHelper", "getUSersTasks, 0="+c.getString(0));
			String tu = c.getString(7);
			if(user.equals(tu)){
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date(c.getLong(5)));
				Task t = new Task(c.getString(2), c.getString(3), c.getString(4), cal, c.getInt(6), c.getString(7));
				Log.d("DatabaseHelper", "Adding task: "+t.toString());
				
				list.add(t);
			}
			c.moveToNext();
		}
		return list;
	}*/
}
