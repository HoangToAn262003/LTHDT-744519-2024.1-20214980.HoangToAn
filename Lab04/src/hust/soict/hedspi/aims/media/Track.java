package hust.soict.hedspi.aims.media;

public class Track {
	private String title;
	private int length;
	public Track() {
		super();
	}
	public Track(String title) {
		super();
		this.title = title;
		this.length = 0;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
}
