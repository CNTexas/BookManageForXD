package texas.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.texas.bookmanage.R;

import texas.activity.MainActivity;
import texas.activity.ShowBookInformation;
import texas.constant.Constant;

public class NewsFragment extends BaseFragment {

	 EditText editText = null;
	Button searchButton = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//editText=(EditText)findViewById(R.id.editText1);
		View newsLayout = inflater.inflate(R.layout.news_layout, container,
				false);

		return newsLayout;
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		MainActivity.currFragTag = Constant.FRAGMENT_FLAG_NEWS;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		 editText = (EditText) getActivity().findViewById(R.id.inputBookName);
		searchButton=(Button)getActivity().findViewById(R.id.search);
		searchButton.setOnClickListener(new Button.OnClickListener(){//创建监听
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(getActivity(),ShowBookInformation.class);
				intent.putExtra("bookName", editText.getText());
				startActivity(intent);
			}

		});
	}

}
