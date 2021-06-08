package softeng.aueb.restaurant.dao.daoInf;
import java.util.List;


import softeng.aueb.restaurant.domain.ProductItem;

/**
 * @author team23
 */

public interface ProductItemDAO {
    /**
     * Saves a ProductItem to memory
     * @param productItem the order of a customer
     */
    void save(ProductItem productItem);

    /**
     * Deletes a ProductItem from memory
     * @param productItem the order of a customer
     */
    void delete (ProductItem productItem);

    /**
     *  Finds a ProductItem by their name
     * @param name ProductItem's name
     * @return the ProductItem with that name or {@code null} if not found
     */
    ProductItem find (String name);

    /**
     *
     * @return All confirmed ProductItems
     */
    List<ProductItem> findAll();
}
