import java.util.*;

public class LibrarySystem {
    private List<Book> bookList = new ArrayList<>();
    private Set<String> genreSet = new HashSet<>();
    private Map<Integer, Book> bookMap = new HashMap<>();
    public void addBook(Book book) {
        bookList.add(book);
        genreSet.add(book.getGenre());
        bookMap.put(book.getId(), book);
    }
    public void removeBooksByKeyword(String keyword) {
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().contains(keyword)) {
                iterator.remove();
                bookMap.remove(book.getId());
            }
        }
    }

    public String getBookListAsString() {
        return bookList.toString();
    }
    public String getGenreSetAsString() {
        return genreSet.toString();
    }

    public String getBookMapAsString() {
        return bookMap.toString();
    }
    public void displayStatus() {
        System.out.println("===== 图书列表 =====");
        System.out.println(getBookListAsString());

        System.out.println("\n===== 图书类型 =====");
        System.out.println(getGenreSetAsString());

        System.out.println("\n===== 图书ID映射 =====");
        System.out.println(getBookMapAsString());
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook(new Book(101, "善良的阳锐", "猎奇"));
        library.addBook(new Book(102, "阳锐的救赎", "励志"));
        library.addBook(new Book(103, "阳锐的时代之2018", "科幻"));
        library.addBook(new Book(104, "三体人阳锐", "科幻"));

        library.displayStatus();

        // 你可以直接拿到 String
        String listStr = library.getBookListAsString();
        String setStr = library.getGenreSetAsString();
        String mapStr = library.getBookMapAsString();

        System.out.println("\n=== 直接使用字符串 ===");
        System.out.println("list: " + listStr);
        System.out.println("set: " + setStr);
        System.out.println("map: " + mapStr);
    }
}