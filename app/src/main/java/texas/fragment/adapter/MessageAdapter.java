package texas.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.texas.bookmanage.R;

import texas.bean.MessageBean;

import java.util.List;

public class MessageAdapter extends BaseAdapter {
	private List<MessageBean> mListMsgBean = null;
	private Context mContext;
	private LayoutInflater mInflater;
	public MessageAdapter(List<MessageBean> listMsgBean, Context context){
		mListMsgBean = listMsgBean;
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListMsgBean.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mListMsgBean.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = mInflater.inflate(R.layout.message_item_layout, null);
		
		ImageView imageView = (ImageView) v.findViewById(R.id.img_msg_item);
		imageView.setImageResource(mListMsgBean.get(position).getPhotoDrawableId());
		

		
		TextView timeMsg = (TextView)v.findViewById(R.id.time_msg_item);
		timeMsg.setText(mListMsgBean.get(position).getMessageTime());

		return v;
	}

}
