package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String title, String artist) {
		super(title);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String artist, float cost) {
		super(title, cost);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public int searchTrackCountByTitle(String title) {
		int cnt = 0;
		for (Track t : tracks) {
			if (t.getTitle().equals(title)) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public void addTrack(String title) {
		if (searchTrackCountByTitle(title) > 0) {
			System.out.println("WARNING: Track \"" + title + "\" already exists on this disc.");
		}
		Track nt = new Track(title);
		tracks.add(nt);
	}
	
	public void addTrack(String title, int length) {
		if (searchTrackCountByTitle(title) > 0) {
			System.out.println("WARNING: Track \"" + title + "\" already exists on this disc.");
		}
		Track nt = new Track(title, length);
		tracks.add(nt);
	}
	
	public void removeTrack(String title) {
		int cnt = 0;
		for (Track t : tracks) {
			if (t.getTitle().equals(title)) {
				tracks.remove(t);
				System.out.println(t.getTitle() + " has been removed from the tracklist.");
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("No tracks were removed.");
		}
		return;
	}
	
	public int getLength() {
		int totalLen = 0;
		for (Track t : tracks) {
			totalLen += t.getLength();
		}
		return totalLen;
	}
	
	public void printTracklist() {
		for (Track t : tracks) {
			System.out.println(t.getTitle() + " - " + t.getLength());
		}
	}
	
	public void play() {
		printTracklist();
		for (Track t : tracks) {
			t.play();
		}
	}

}
