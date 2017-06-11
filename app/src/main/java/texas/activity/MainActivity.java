package texas.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.example.texas.bookmanage.R;

import texas.constant.Constant;
import texas.fragment.BaseFragment;
import texas.ui.BottomControlPanel;
import texas.ui.BottomControlPanel.BottomPanelCallback;
import texas.ui.HeadControlPanel;

public class MainActivity extends Activity implements BottomPanelCallback {
	BottomControlPanel bottomPanel = null;
	HeadControlPanel headPanel = null;
	
	private FragmentManager fragmentManager = null;
	private FragmentTransaction fragmentTransaction = null;
	
/*	private MessageFragment messageFragment;
	private ContactsFragment contactsFragment;
	private NewsFragment newsFragment;
	private SettingFragment settingFragment;*/
	
	public static String currFragTag = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
		fragmentManager = getFragmentManager();
		setDefaultFirstFragment(Constant.FRAGMENT_FLAG_MESSAGE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void initUI(){
		bottomPanel = (BottomControlPanel)findViewById(R.id.bottom_layout);
		if(bottomPanel != null){
			bottomPanel.initBottomPanel();
			bottomPanel.setBottomCallback(this);
		}
		headPanel = (HeadControlPanel)findViewById(R.id.head_layout);
		if(headPanel != null){
			headPanel.initHeadPanel();
		}
	}

	/* ����BottomControlPanel�Ļص�
	 * @see org.com.example.texas.ui.BottomControlPanel.BottomPanelCallback#onBottomPanelClick(int)
	 */
	@Override
	public void onBottomPanelClick(int itemId) {
		// TODO Auto-generated method stub
		String tag = "";
		if((itemId & Constant.BTN_FLAG_MESSAGE) != 0){
			tag = Constant.FRAGMENT_FLAG_MESSAGE;
		}else if((itemId & Constant.BTN_FLAG_CONTACTS) != 0){
			tag = Constant.FRAGMENT_FLAG_CONTACTS;
		}else if((itemId & Constant.BTN_FLAG_NEWS) != 0){
			tag = Constant.FRAGMENT_FLAG_NEWS;
		}else if((itemId & Constant.BTN_FLAG_SETTING) != 0){
			tag = Constant.FRAGMENT_FLAG_SETTING;
		}
		setTabSelection(tag); //�л�Fragment
		headPanel.setMiddleTitle(tag);//�л����� 
	}
	
	private void setDefaultFirstFragment(String tag){
		Log.i("yan", "setDefaultFirstFragment enter... currFragTag = " + currFragTag);
		setTabSelection(tag);
		bottomPanel.defaultBtnChecked();
		Log.i("yan", "setDefaultFirstFragment exit...");
	}
	
	private void commitTransactions(String tag){
		if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
			fragmentTransaction.commit();
			currFragTag = tag;
			fragmentTransaction = null;
		}
	}
	
	private FragmentTransaction ensureTransaction( ){
		if(fragmentTransaction == null){
			fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction
			.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			
		}
		return fragmentTransaction;
		
	}
	
	private void attachFragment(int layout, Fragment f, String tag){
		if(f != null){
			if(f.isDetached()){
				ensureTransaction();
				fragmentTransaction.attach(f);
				
			}else if(!f.isAdded()){
				ensureTransaction();
				fragmentTransaction.add(layout, f, tag);
			}
		}
	}
	
	private Fragment getFragment(String tag){
		
		Fragment f = fragmentManager.findFragmentByTag(tag);
		
		if(f == null){
			Toast.makeText(getApplicationContext(), "fragment = null tag = " + tag, Toast.LENGTH_SHORT).show();
			f = BaseFragment.newInstance(getApplicationContext(), tag);
		}
		return f;
		
	}
	private void detachFragment(Fragment f){
		
		if(f != null && !f.isDetached()){
			ensureTransaction();
			fragmentTransaction.detach(f);
		}
	}
	/**�л�fragment 
	 * @param tag
	 */
	private  void switchFragment(String tag){
		if(TextUtils.equals(tag, currFragTag)){
			return;
		}
		//����һ��fragment detach�� 
		if(currFragTag != null && !currFragTag.equals("")){
			detachFragment(getFragment(currFragTag));
		}
		attachFragment(R.id.fragment_content, getFragment(tag), tag);
		commitTransactions( tag);
	} 
	
	/**����ѡ�е�Tag
	 * @param tag
	 */
	public  void setTabSelection(String tag) {
		// ����һ��Fragment����
		fragmentTransaction = fragmentManager.beginTransaction();
/*		 if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_MESSAGE)){
		   if (messageFragment == null) {
				messageFragment = new MessageFragment();
			} 
			
		}else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_CONTACTS)){
			if (contactsFragment == null) {
				contactsFragment = new ContactsFragment();
			} 
			
		}else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_NEWS)){
			if (newsFragment == null) {
				newsFragment = new NewsFragment();
			}
			
		}else if(TextUtils.equals(tag,Constant.FRAGMENT_FLAG_SETTING)){
			if (settingFragment == null) {
				settingFragment = new SettingFragment();
			}
		}else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_SIMPLE)){
			if (simpleFragment == null) {
				simpleFragment = new SimpleFragment();
			} 
			
		}*/
		 switchFragment(tag);
		 
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		currFragTag = "";
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
	}

}
