package texas.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.texas.bookmanage.R;

import texas.activity.MainActivity;
import texas.bean.MessageBean;
import texas.constant.Constant;
import texas.fragment.adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends BaseFragment {

	private static final String TAG = "MessageFragment";
	private MainActivity mMainActivity ;
	private ListView mListView;
	private MessageAdapter mMsgAdapter;
	private List<MessageBean> mMsgBean = new ArrayList<MessageBean>();
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View messageLayout = inflater.inflate(R.layout.message_layout,
				container, false);
		Log.d(TAG, "onCreateView---->");
		mMainActivity = (MainActivity) getActivity();
		mFragmentManager = getActivity().getFragmentManager();
		mListView = (ListView)messageLayout.findViewById(R.id.listview_message);
		mMsgAdapter = new MessageAdapter(mMsgBean, mMainActivity);
		mListView.setAdapter(mMsgAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(mMainActivity, mMsgBean.get(position).toString(),
						Toast.LENGTH_LONG).show();
			}

		});
		return messageLayout;
	}


	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Log.e(TAG, "onAttach-----");

	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.e(TAG, "onCreate------");
		mMsgBean.add(new MessageBean(R.drawable.ic_photo_1, "111"));
		mMsgBean.add(new MessageBean(R.drawable.ic_photo_2, "222"));
		mMsgBean.add(new MessageBean(R.drawable.ic_photo_3, "333"));
		mMsgBean.add(new MessageBean(R.drawable.ic_photo_4, "444"));
		mMsgBean.add(new MessageBean(R.drawable.ic_photo_5, "555"));
		mMsgBean.add(new MessageBean(R.drawable.ic_photo_6, "666"));
		mMsgBean.add(new MessageBean(R.drawable.ic_photo_7, "777"));
		mMsgBean.add(new MessageBean(R.drawable.ic_photo_8, "888"));
		mMsgBean.add(new MessageBean(R.drawable.ic_photo_9, "999"));
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.e(TAG, "onActivityCreated-------");
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		Log.e(TAG, "onStart----->");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e(TAG, "onresume---->");
		MainActivity.currFragTag = Constant.FRAGMENT_FLAG_MESSAGE;
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.e(TAG, "onpause");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.e(TAG, "onStop");
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.e(TAG, "ondestoryView");
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e(TAG, "ondestory");
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.d(TAG, "onDetach------");

	}



}
