import java.util.List;
import java.util.stream.Collectors;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	List<String> findBookTitlesByAuthor(String author) {
		List<Book> books = this.dataTier.getAllBooks();
		return books.stream()
			.filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
			.map(b -> b.getTitle())
			.collect(Collectors.toList());
	}
	
	int findNumberOfBooksInYear(int year) {
		List<Book> books = this.dataTier.getAllBooks();
		return books.stream()
			.filter(b -> b.getPublicationYear() == year)
			.collect(Collectors.toList())
			.size();
	}
	

}
