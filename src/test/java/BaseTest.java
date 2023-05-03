import api.Generator;
import api.User;
import api.UserClient;
import api.UserCredentials;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {

    protected static final User user = Generator.getRandomUser();

    UserClient userClient;
   /*
   private void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\max\\Documents\\YandexDriver\\yandexdriver.exe");
        System.setProperty("selenide.browser", "Chrome");
       }
   */
    @Before
    public void init() {
        //setUp();
        userClient = new UserClient();
        userClient.createUser(user);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();  // Я добавил, но Selenide автоматически закрывает браузер после тестов

        UserCredentials userCredentials = new UserCredentials(user.getEmail(), user.getPassword());
        Response response = userClient.login(userCredentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }
    }
}
