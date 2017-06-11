package texas.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.texas.bookmanage.R;

import texas.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class BottomControlPanel extends RelativeLayout implements View.OnClickListener {
	private Context mContext;
	private ImageText mMsgBtn = null;
	private ImageText mContactsBtn = null;
	private ImageText mNewsBtn = null;
	private ImageText mSettingBtn = null;
	private int DEFALUT_BACKGROUND_COLOR = Color.rgb(243, 243, 243); //Color.rgb(192, 192, 192)
	private BottomPanelCallback mBottomCallback = null;
	private List<ImageText> viewList = new ArrayList<ImageText>();

	public interface BottomPanelCallback{
		public void onBottomPanelClick(int itemId);
	}
	public BottomControlPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		mMsgBtn = (ImageText)findViewById(R.id.btn_message);
		mContactsBtn = (ImageText)findViewById(R.id.btn_contacts);
		mNewsBtn = (ImageText)findViewById(R.id.btn_news);
		mSettingBtn = (ImageText)findViewById(R.id.btn_setting);
		setBackgroundColor(DEFALUT_BACKGROUND_COLOR);
		viewList.add(mMsgBtn);
		viewList.add(mContactsBtn);
		viewList.add(mNewsBtn);
		viewList.add(mSettingBtn);

	}
	public void initBottomPanel(){
		if(mMsgBtn != null){
			mMsgBtn.setImage(R.drawable.message_unselected);
			mMsgBtn.setText("第一项");
		}
		if(mContactsBtn != null){
			mContactsBtn.setImage(R.drawable.contacts_unselected);
			mContactsBtn.setText("第二项");
		}
		if(mNewsBtn != null){
			mNewsBtn.setImage(R.drawable.news_unselected);
			mNewsBtn.setText("第三项");
		}
		if(mSettingBtn != null){
			mSettingBtn.setImage(R.drawable.setting_unselected);
			mSettingBtn.setText("第四项");
		}
		setBtnListener();

	}
	private void setBtnListener(){
		int num = this.getChildCount();
		for(int i = 0; i < num; i++){
			View v = getChildAt(i);
			if(v != null){
				v.setOnClickListener(this);
			}
		}
	}
	public void setBottomCallback(BottomPanelCallback bottomCallback){
		mBottomCallback = bottomCallback;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		initBottomPanel();
		int index = -1;
		switch(v.getId()){
		case R.id.btn_message:
			index = Constant.BTN_FLAG_MESSAGE;
			mMsgBtn.setChecked(Constant.BTN_FLAG_MESSAGE);
			break;
		case R.id.btn_contacts:
			index = Constant.BTN_FLAG_CONTACTS;
			mContactsBtn.setChecked(Constant.BTN_FLAG_CONTACTS);
			break;
		case R.id.btn_news:
			index = Constant.BTN_FLAG_NEWS;
			mNewsBtn.setChecked(Constant.BTN_FLAG_NEWS);
			break;
		case R.id.btn_setting:
			index = Constant.BTN_FLAG_SETTING;
			mSettingBtn.setChecked(Constant.BTN_FLAG_SETTING);
			break;
		default:break;
		}
		if(mBottomCallback != null){
			mBottomCallback.onBottomPanelClick(index);
		}
	}
	public void defaultBtnChecked(){
		if(mMsgBtn != null){
			mMsgBtn.setChecked(Constant.BTN_FLAG_MESSAGE);
		}
	}
	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
		layoutItems(left, top, right, bottom);
	}
	/**����ߺ����ұߵ�view��ĸ���ֵ�padding���п���λ�á�������Ե�2��3��view��λ����������
	 * @param left
	 * @param top
	 * @param right
	 * @param bottom
	 */
	private void layoutItems(int left, int top, int right, int bottom){
		int n = getChildCount();
		if(n == 0){
			return;
		}
		int paddingLeft = getPaddingLeft();
		int paddingRight = getPaddingRight();
		Log.i("dzx", "paddingLeft = " + paddingLeft + " paddingRight = " + paddingRight);
		int width = right - left;
		int height = bottom - top;
		Log.i("dzx", "width = " + width + " height = " + height);
		int allViewWidth = 0;
		for(int i = 0; i< n; i++){
			View v = getChildAt(i);
			Log.i("dzx", "v.getWidth() = " + v.getWidth());
			allViewWidth += v.getWidth();
		}
		int blankWidth = (width - allViewWidth - paddingLeft - paddingRight) / (n - 1);
		Log.i("dzx", "blankV = " + blankWidth );

		LayoutParams params1 = (LayoutParams) viewList.get(1).getLayoutParams();
		params1.leftMargin = blankWidth;
		viewList.get(1).setLayoutParams(params1);

		LayoutParams params2 = (LayoutParams) viewList.get(2).getLayoutParams();
		params2.leftMargin = blankWidth;
		viewList.get(2).setLayoutParams(params2);
	}



}
