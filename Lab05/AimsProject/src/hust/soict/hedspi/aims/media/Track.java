package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
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
	@Override
	public boolean equals(Object o) {		
		Track t = (Track) o;
		return this.title == t.title && this.length == t.length;
	}
	public String toString() {
		return this.title + " - " + this.length;
	}
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: Track length is not positive.");
		}
	}
}
