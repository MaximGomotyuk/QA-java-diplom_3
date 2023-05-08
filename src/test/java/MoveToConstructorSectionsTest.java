import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class MoveToConstructorSectionsTest extends BaseTest {

    @Test
    @DisplayName("Перейти в Булочки в конструкторе по кнопке")
    public void moveBunsSectionButtonTest() {
            assertTrue(open(MainPage.URL_MAIN, MainPage.class)
                .clickFillingsButton()
                .clickBunsButton()
                .isBunsHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Перейти в Соусы в конструкторе по кнопке")
    public void moveSaucesSectionButtonTest() {
        assertTrue(open(MainPage.URL_MAIN, MainPage.class)
                .clickFillingsButton()
                .clickSaucesButton()
                .isSaucesHeaderDisplayed());
    }

    @Test
    @DisplayName("Перейти в Начинки в конструкторе по кнопке")
    public void moveFillingsSectionButtonTest() {

       assertTrue(open(MainPage.URL_MAIN, MainPage.class)
               .clickFillingsButton()
                .isFillingsHeaderDisplayed());
    }

    @Test
    @DisplayName("Скролл к Булочкам в конструкторе")
    public void moveBunsSectionScrollTest() {
        assertTrue(open(MainPage.URL_MAIN, MainPage.class)
                .scrollToSaucesHeader()
                .scrollToBunsHeader()
                .isBunsHeaderIsDisplayed());
    }


    @Test
    @DisplayName("Скролл к Соусам в конструкторе")
    public void moveSaucesSectionScrollTest() {
        assertTrue(open(MainPage.URL_MAIN, MainPage.class)
                .scrollToSaucesHeader()
                .isSaucesHeaderDisplayed());
    }


    @Test
    @DisplayName("Скролл к Начинкам в конструкторе")
    public void moveFillingsSectionScrollTest() {
        assertTrue(open(MainPage.URL_MAIN, MainPage.class)
                .scrollToFillingsHeader()
                .isFillingsHeaderDisplayed());
    }

}