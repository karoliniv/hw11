import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    @Test
    public void shouldRemoveProduct() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "It", 1800, "Stephen King");
        Book book2 = new Book(2, "Pride and Prejudice", 1000, "Jane Austen");
        Book book3 = new Book(3, "1984", 560, "George Orwell");
        Smartphone smartphone4 = new Smartphone(4, "iPhone SE 2022", 37000, "Apple");
        Smartphone smartphone5 = new Smartphone(5, "Galaxy A03 Core", 7800, "Samsung");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone4);
        repository.add(smartphone5);

        repository.removeById(4);
        repository.removeById(2);

        Product[] expected = {book1, book3, smartphone5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveProduct() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "It", 1800, "Stephen King");
        Book book2 = new Book(2, "Pride and Prejudice", 1000, "Jane Austen");
        Book book3 = new Book(3, "1984", 560, "George Orwell");
        Smartphone smartphone4 = new Smartphone(4, "iPhone SE 2022", 37000, "Apple");
        Smartphone smartphone5 = new Smartphone(5, "Galaxy A03 Core", 7800, "Samsung");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone4);
        repository.add(smartphone5);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.removeById(10)
        );
    }

    @Test
    public void shouldNotAddProduct() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "It", 1800, "Stephen King");
        Book book2 = new Book(2, "Pride and Prejudice", 1000, "Jane Austen");
        Book book3 = new Book(3, "1984", 560, "George Orwell");
        Smartphone smartphone4 = new Smartphone(4, "iPhone SE 2022", 37000, "Apple");
        Smartphone smartphone5 = new Smartphone(4, "Galaxy A03 Core", 7800, "Samsung");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone4);

        Assertions.assertThrows(AlreadyExistsException.class,
                () -> repository.add(smartphone5)
        );
    }

    @Test
    public void shouldAddProduct() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "It", 1800, "Stephen King");
        Book book2 = new Book(2, "Pride and Prejudice", 1000, "Jane Austen");
        Book book3 = new Book(3, "1984", 560, "George Orwell");
        Smartphone smartphone4 = new Smartphone(4, "iPhone SE 2022", 37000, "Apple");
        Smartphone smartphone5 = new Smartphone(5, "Galaxy A03 Core", 7800, "Samsung");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone4);
        repository.add(smartphone5);

        Product[] expected = {book1, book2, book3, smartphone4, smartphone5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}
