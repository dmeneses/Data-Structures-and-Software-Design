import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	private List<Book> books;

	public DataTier(String inputSource) throws IOException {
		fileName = inputSource;
		books = getBooksFromFile();
	}
	
	List<Book> getBooksFromFile() throws IOException {
		List<Book> books = null;
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
	        books = stream.map((book) ->  book.split("\t"))
	        	.map((bookInfo) -> new Book(bookInfo[0], bookInfo[1], Integer.parseInt(bookInfo[2])))
	        	.collect(Collectors.toList());
		}
		return books;
	}
	
	List<Book> getAllBooks() {
		return books;
	}

}
