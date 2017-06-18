package texas.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.texas.bookmanage.R;

/**
 * Created by Texas on 2017/6/18.
 */

public class ShowBookInformation extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showresult);
    }
}
