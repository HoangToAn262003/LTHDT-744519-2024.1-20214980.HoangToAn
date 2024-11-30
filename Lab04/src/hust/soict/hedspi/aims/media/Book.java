package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public void addAuthor(String authorName) {
		for (String name : authors) {
			if (name.equalsIgnoreCase(authorName)) {
				System.out.println("Cannot add " + authorName + " to the list of authors.");
				return;
			}
		}
		authors.add(authorName);
		return;
	}
	
	public void removeAuthor(String authorName) {
		int cnt = 0;
		for (String name : authors) {
			if (name.equalsIgnoreCase(authorName)) {
				authors.remove(name);
			}
		}
		System.out.println("Removed " + cnt + " authors from the list.");
		return;
	}

}
