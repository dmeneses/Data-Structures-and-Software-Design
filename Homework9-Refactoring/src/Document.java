import java.util.Date;


public abstract class Document {

	private String title;
	private String author;
	private Date date;
	protected PublishingLocation location = new PublishingLocation();

	public Document(String title, String author, Date date) {
		this.title = title;
		this.author = author;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getDate() {
		return date;
	}
	
	
	public String getCity() {
		return location.getCity();
	}
	
	public String getState() {
		return location.getState();
	}
	
	public String getPostCode() {
		return location.getPostCode();
	}
	
	public int compareDates(Document article){
		return this.date.compareTo(article.date);
	}
	
	public int compareWithGeneralDate(Date date){
		return this.date.compareTo(date);
	}

	public boolean sameAuthor(Document article){
		return this.author.equals(article.author);
	}
}