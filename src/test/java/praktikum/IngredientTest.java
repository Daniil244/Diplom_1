package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private static IngredientType type;
    private final String name;
    private final float price;
    private final static double DELTA = 0.0f;

    @Before
    public void beforeBenTest() {
        ingredient = new Ingredient(type, name, price);
    }

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getTypeNameAndPrice() {
        return new Object[][] {
                {type.SAUCE, "Sausage", (float) 60.00},
                {type.FILLING, "Ketchup", (float) 20.00}
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals("Значение стоимости ингредиентов не корректно", price, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getNameTest() {
        assertEquals("Наименование ингредиентов не корректно", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Тип ингредиентов не корректен", type, ingredient.getType());
    }
}
