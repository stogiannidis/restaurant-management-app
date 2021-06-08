package softeng.aueb.restaurant.dao.memorydao;

import java.util.ArrayList;
import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.domain.ProductItem;

public class ProductItemDAOMemory implements ProductItemDAO {
    protected static ArrayList<ProductItem> productItems = new ArrayList<>();
    /**
     * Saves a ProductItem to memory
     *
     * @param productItem the order of a customer
     */
    @Override
    public void save(ProductItem productItem) {
        productItems.add(productItem);
    }

    /**
     * Deletes a ProductItem from memory
     *
     * @param productItem the order of a customer
     */
    @Override
    public void delete(ProductItem productItem) {
        productItems.remove(productItem);
    }

    /**
     * Finds a ProductItem by their name
     *
     * @param name ProductItem's name
     * @return the ProductItem with that name or {@code null} if not found
     */
    @Override
    public ProductItem find(String name) {
        for (ProductItem productItem: productItems) {
            if(productItem.getName().equals(name))
                return productItem;
        }
        return null;
    }

    /**
     * @return All confirmed ProductItems
     */
    @Override
    public List<ProductItem> findAll() {
        return new ArrayList<>(productItems);
    }
}
