package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title) {
		super(title);
	}

	public Book(String title, float cost) {
		super(title, cost);
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public void addAuthor(String... newAuthors) {
		for (String newName : newAuthors) {
			int flag = 0;
			for (String name : authors) {
				if (name.equalsIgnoreCase(newName)) {
					System.out.println("Cannot add " + newName + " to the list of authors.");
					flag++;
					break;
				}
			}
			if (flag == 0) authors.add(newName);
		}
	}
	
	public void removeAuthor(String authorName) {
		int cnt = 0;
		for (String name : authors) {
			if (name.equalsIgnoreCase(authorName)) {
				authors.remove(name);
			}
		}
		System.out.println("Removed " + cnt + " authors from the list.");
	}
	
	public String toString() {
		return this.getId() + ". [Book] " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + "$";
	}

}
