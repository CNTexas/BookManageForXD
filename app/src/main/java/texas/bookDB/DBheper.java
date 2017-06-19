package texas.bookDB;

import android.widget.Toast;

import org.litepal.LitePalApplication;

/**
 * Created by Texas on 2017/6/19.
 */

public class DBheper extends LitePalApplication {
    public void DBInit(){
        BookInformation bookInformation = new BookInformation();
        bookInformation.setBookID(1);
        bookInformation.setBookNAME("数据结构");
        bookInformation.setPath("@drawable/"+"visit");
        bookInformation.setBookPrice(1000);
        if (bookInformation.save()){
            Toast.makeText(getApplicationContext(),"save successfully",Toast.LENGTH_LONG);
        }else {
            Toast.makeText(getApplicationContext(),"save failed",Toast.LENGTH_LONG);
        }
    }

}
