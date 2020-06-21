package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {

    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product[] findById(int id) {
        Product[] findItem = new Product[0];
        int index = 0;
        for (Product item : items) {
            if (item.getId() == id) {
                findItem = new Product[1];
                findItem[index] = item;
                index++;
            }
        }
        return findItem;
    }

    public void removeById(int id) {
        if (findById(id) == new Product[0]) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        if (findById(id) != new Product[0]) {
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }
}
