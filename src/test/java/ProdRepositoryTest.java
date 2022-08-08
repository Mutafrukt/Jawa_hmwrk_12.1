import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;

public class ProdRepositoryTest {

    ProdRepository repo = new ProdRepository();

    Product product1 = new Product();
    Product product2 = new Product(36, "Random product", 12);
    Book book1 = new Book(1, "Book1", 130, "Author1");
    Smartphone smartphone1 = new Smartphone(2, "iPhoneX", 15000, "China");

    @Test

    /// УСТАНАВЛИВАЕМ ID, НАЗВАНИЕ, ЦЕНУ ПРОДУКТА ///

    public void shouldSetProductDatas() {

        repo.save(product1);
        product1.setId(56);
        product1.setName("SomeProdName");
        product1.setPrice(360);

        Product[] expected = {product1};
        Product[] actual = repo.getItems();
        System.out.println(product1.getName());
        System.out.println(product1.getId());
        System.out.println(product1.getPrice());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    /// ДОБАВЛЯЕМ ПРОДУКТ, ИЗМЕНЯЕМ ДАННЫЕ ДОБАВЛЕННЫХ ПРОДУКТОВ ///

    public void shouldAddProduct() {

        repo.save(book1);
        repo.save(smartphone1);
        repo.save(product2);
        smartphone1.getManufacturer();
        smartphone1.setManufacturer("Thailand");
        book1.setAuthor("Hemingway");
        book1.getAuthor();
        product2.getName();
        product2.getPrice();
        System.out.println(smartphone1.getManufacturer());
        System.out.println(book1.getAuthor());
        System.out.println(product2.getName());
        System.out.println(product2.getPrice());

        Product[] expected = {book1, smartphone1, product2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    /// УДАЛЯЕМ ПРОДУКТ ///

    public void shouldRemoveById() {

        repo.save(book1);
        repo.save(smartphone1);
        repo.save(product2);
        repo.removeById(2);


        Product[] expected = {book1, product2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
}
