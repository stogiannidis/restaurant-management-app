package softeng.aueb.restaurant.view.Owner.OwnerDetails;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.dao.memorydao.ProductItemDAOMemory;

import static org.junit.jupiter.api.Assertions.*;

class AddMenuPresenterTest {

    ProductItemDAO productItemDAO;
    @Mock
    AddMenuActivity addMenuActivity;
    AddMenuPresenter presenter;

    @Test
    void onAddition() {
        productItemDAO = new ProductItemDAOMemory();

        addMenuActivity = Mockito.mock(AddMenuActivity.class);
        presenter = new AddMenuPresenter(productItemDAO,addMenuActivity);
        Mockito.when(addMenuActivity.getName()).thenReturn("pizza");
        Mockito.when(addMenuActivity.getPrice()).thenReturn("5");
        Mockito.when(addMenuActivity.getQuantity()).thenReturn("66");
        presenter.onAddition();
        assertFalse(productItemDAO.findAll().isEmpty());
    }
}