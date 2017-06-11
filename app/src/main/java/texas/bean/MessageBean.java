package texas.bean;

public class MessageBean {
	private int PhotoDrawableId;

	private String MessageTime;
	
	public MessageBean(){
		
	}
	
	public MessageBean(int photoDrawableId,String messageTime) {
		super();
		PhotoDrawableId = photoDrawableId;
		MessageTime = messageTime;
	}

	public int getPhotoDrawableId() {
		return PhotoDrawableId;
	}
	public void setPhotoDrawableId(int mPhotoDrawableId) {
		this.PhotoDrawableId = mPhotoDrawableId;
	}

	public String getMessageTime() {
		return MessageTime;
	}
	public void setMessageTime(String messageTime) {
		MessageTime = messageTime;
	}
	@Override
	public String toString() {
		return "MessageBean [mPhotoDrawableId=" + PhotoDrawableId
				+ ", MessageTime=" + MessageTime + "]";
	}
	
	
	
}
