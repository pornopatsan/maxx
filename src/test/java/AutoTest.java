import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class AutoTest {

    private WebDriver driver = new SafariDriver();

    private void waitTimeout(WebDriver driver, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.linkText("На Главную"))));
        } catch (TimeoutException ignored) { }
    }

    private void fillAutoForm(WebDriver driver, String gb, String stock) {
        driver.findElement(By.id("supplier")).sendKeys("Audi");
        driver.findElement(By.id("mark")).sendKeys("Q7");
        driver.findElement(By.id("serialNumber")).sendKeys("QQ1234PSX-2A");
        driver.findElement(By.id("engineCapacity")).sendKeys("3.0");
        driver.findElement(By.id("enginePower")).sendKeys("333");
        driver.findElement(By.id("fuelCapacity")).sendKeys("100");
        driver.findElement(By.id("mass")).sendKeys("2000");
        driver.findElement(By.id("color")).sendKeys("Черн.");
        driver.findElement(By.id("seats")).sendKeys("7");
        driver.findElement(By.id("cost")).sendKeys("60000");
        driver.findElement(By.id("lastService")).sendKeys("2019-09-10");
        driver.findElement(By.id("mileageKm")).sendKeys("0");

        Select select1 = new Select(driver.findElement(By.id("autoGearBox")));
        select1.selectByValue(gb);
        Select select2 = new Select(driver.findElement(By.id("inStock")));
        select2.selectByValue(stock);
    }

    public void AddUpdateDeleteAutoTest() {
        driver.get("http://localhost:8080/maxx_war_exploded/main");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Assert.assertEquals(driver.getTitle(), "Главная Страница");
        driver.findElement(By.linkText("Новый автомобиль")).click();
        wait.until(ExpectedConditions.titleIs("Новый Автомобиль"));

        fillAutoForm(driver, "false", "true");
        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.titleIs("Audi Q7 QQ1234PSX-2A"));

        assert driver.findElements(By.tagName("td")).get(3).getText().contains("Audi");
        assert driver.findElements(By.tagName("td")).get(5).getText().contains("Q7");
        assert driver.findElements(By.tagName("td")).get(7).getText().contains("QQ1234PSX-2A");
        assert driver.findElements(By.tagName("td")).get(9).getText().contains("Черн.");
        assert driver.findElements(By.tagName("td")).get(11).getText().contains("3.0");
        assert driver.findElements(By.tagName("td")).get(13).getText().contains("333.0");
        assert driver.findElements(By.tagName("td")).get(15).getText().contains("100.0");

        driver.findElement(By.linkText("Изменить")).click();
        wait.until(ExpectedConditions.titleIs("Изменение Данных"));

        driver.findElement(By.id("serialNumber")).sendKeys("QQ2345PSX-2A");

        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.titleIs("Audi Q7 QQ2345PSX-2A"));

        assert driver.findElements(By.tagName("td")).get(3).getText().contains("Audi");
        assert driver.findElements(By.tagName("td")).get(5).getText().contains("Q7");
        assert driver.findElements(By.tagName("td")).get(7).getText().contains("QQ2345PSX-2A");

        driver.findElement(By.linkText("Удалить машину")).click();
        wait.until(ExpectedConditions.titleIs("Главная Страница"));
    }

    public void AddCustomerToAutoTest() {
        driver.get("http://localhost:8080/maxx_war_exploded/main");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Assert.assertEquals(driver.getTitle(), "Главная Страница");
        driver.findElement(By.linkText("Новый автомобиль")).click();
        wait.until(ExpectedConditions.titleIs("Новый Автомобиль"));

        fillAutoForm(driver, "true", "false");
        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.titleIs("Audi Q7 QQ1234PSX-2A"));
        assert driver.findElements(By.tagName("td")).get(28).getText().contains("Отсутствует");

        driver.findElement(By.linkText("Заброниовать машину")).click();
        wait.until(ExpectedConditions.titleIs("Заказчик"));

        driver.findElement(By.id("firstName")).sendKeys("TestName");
        driver.findElement(By.id("lastName")).sendKeys("TestSurname");
        driver.findElement(By.id("phone")).sendKeys("89999999999");
        driver.findElement(By.id("email")).sendKeys("test@test.test");
        driver.findElement(By.id("address")).sendKeys("Address N.A. Dress Dr. Ass.");

        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.titleContains("Заказ -"));
        String savedUrl = driver.getCurrentUrl(); // Saving Url to return later

        assert driver.findElements(By.tagName("td")).get(3).getText().contains("TestName");
        assert driver.findElements(By.tagName("td")).get(5).getText().contains("TestSurname");
        assert driver.findElements(By.tagName("td")).get(7).getText().contains("89999999999");
        assert driver.findElements(By.tagName("td")).get(9).getText().contains("test@test.test");
        assert driver.findElements(By.tagName("td")).get(11).getText().contains("Address N.A. Dress Dr. Ass.");

        assert driver.findElements(By.tagName("td")).get(25).getText().contains("Reserved");
        driver.findElement(By.linkText("Подробнее")).click();
        wait.until(ExpectedConditions.titleIs("Audi Q7 QQ1234PSX-2A"));
        driver.findElement(By.linkText("(Появилась на складе?)")).click();
        waitTimeout(driver,1);
        assert driver.findElements(By.tagName("td")).get(28).getText().contains("Есть в наличии !");

        driver.get(savedUrl); // Returning to Order Page
        wait.until(ExpectedConditions.titleContains("Заказ -"));

        assert driver.findElements(By.tagName("td")).get(25).getText().contains("Arrived");
        driver.findElement(By.linkText("Заказ подтвержден")).click();
        waitTimeout(driver,1);
        assert driver.findElements(By.tagName("td")).get(25).getText().contains("Finished");
    }
}
