package hust.soict.hedspi.aims.media;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	private static int nbMedia = 0;
	
	public Media() {
		// TODO Auto-generated constructor stub
	}

	public Media(String title) {
		super();
		this.title = title;
		this.cost = 0;
		nbMedia++;
		this.id = nbMedia;
	}
	
	public Media(String title, float cost) {
		this.title = title;
		this.cost = cost;
		nbMedia++;
		this.id = nbMedia;
	}

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedia++;
		this.id = nbMedia;
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
	
	public boolean isMatch(String title) {
		return this.getTitle().toLowerCase().contains(title);
	}

}
