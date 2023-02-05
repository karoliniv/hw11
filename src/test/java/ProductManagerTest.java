import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    @Test
    public void shouldAddProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "It", 1800, "Stephen King");
        Book book2 = new Book(2, "Pride and Prejudice", 1000, "Jane Austen");
        Book book3 = new Book(3, "1984", 560, "George Orwell");
        Smartphone smartphone4 = new Smartphone(4, "iPhone SE 2022", 37000, "Apple");
        Smartphone smartphone5 = new Smartphone(5, "Galaxy A03 Core", 7800, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone4);
        manager.add(smartphone5);

        Product[] expected = {book1, book2, book3, smartphone4, smartphone5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "War and Peace", 1800, "Tolstoy");
        Book book2 = new Book(2, "Pride and Prejudice", 1000, "Jane Austen");
        Book book3 = new Book(3, "1984", 560, "George Orwell");
        Smartphone smartphone4 = new Smartphone(4, "iPhone SE 2022", 37000, "Apple");
        Smartphone smartphone5 = new Smartphone(5, "Galaxy A03 Core", 7800, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone4);
        manager.add(smartphone5);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("and");
        Assertions.assertArrayEquals(expected, actual);
    }
}
