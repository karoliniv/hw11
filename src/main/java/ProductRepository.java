public class ProductRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        Product foundProduct = findById(product.id);
        if (foundProduct != null) {
            throw new AlreadyExistsException(product.id);
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeById(int id) {
        Product foundProduct = findById(id);
        if (foundProduct == null) {
            throw new NotFoundException(id);
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
