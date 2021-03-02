package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public void click(WebElement element, int maxTimeout) {
        fluentWait(element, maxTimeout);
        element.click();
    }

    public void clickWithIndex(List<WebElement> elements, int index, int maxTimeout) {
        fluentWait(elements.get(index), maxTimeout);
        elements.get(index).click();
    }

    public void clickByText(String text, int timeOut) {
        implicitWait(timeOut);
        Driver.driver.findElement(By.xpath("//*[@text='" + text + "']")).click();
    }

    public void sendKeys(WebElement element, String stringValue, int maxTimeout) {
        fluentWait(element, maxTimeout);
        element.sendKeys(stringValue);
    }

    public void sendKeysWithIndex(List<WebElement> elements, String stringValue, int index, int maxTimeout) {
        fluentWait(elements.get(index), maxTimeout);
        elements.get(index).sendKeys(stringValue);
    }

    public void fluentWait(WebElement element, int maxTimeout) {
        Wait wait = new FluentWait(Driver.driver)
                .withTimeout(Duration.ofSeconds(maxTimeout))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getText(WebElement element, int maxTimeout) {
        fluentWait(element, maxTimeout);
        return element.getText();
    }

    public String getTextWithIndex(List<WebElement> elements, int index, int maxTimeout) {
        fluentWait(elements.get(index), maxTimeout);
        return elements.get(index).getText();
    }

    public static void implicitWait(int time) {
        Driver.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void waitABit(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void swipe(int startx, int starty, int endx, int endy, int duration) {
        System.out.println(
                "Swipe (" + startx + "," + starty + "," + endx + "," + endy + "," + duration + ")");
        new TouchAction(Driver.driver).press(new PointOption().withCoordinates(startx, starty))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
                .moveTo(new PointOption().withCoordinates(endx, endy)).release().perform();
    }

    public static void scrollUpTo() {
        Dimension size;
        // Get the size of screen.
        size = Driver.driver.manage().window().getSize();
        // System.out.println("Dimension value = "+dimensions);
        Double screenHeightStart = size.getHeight() * 0.65;
        // System.out.println("Screen Height start Value="+screenHeightStart);
        int scrollStart = screenHeightStart.intValue();
        // System.out.println("Scroll Start Value="+scrollStart);
        Double screenHeightEnd = size.getHeight() * 0.2;
        // System.out.println("Screen Height start End="+screenHeightEnd);
        int scrollEnd = screenHeightEnd.intValue();
        // System.out.println("Scroll end Value="+scrollEnd);
        swipe(0, scrollStart, 0, scrollEnd, 2000);
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickableForList(List<WebElement> elements, int index) {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(elements.get(index)));
    }

    public void scrollToElement(List<WebElement> elements, int count) {
        int i = 0;
        do {
            boolean isPresent = elements.size() > 0;
            if (isPresent) {
                scrollUpTo();
                break;
            } else {
                scrollUpTo();
            }
            i++;
        } while (i <= count);
    }

    public void scrollToElementWithText(String text, int count) {
        int i = 0;
        do {
            boolean isPresent = Driver.driver.findElements(By.xpath("//*[@text='" + text + "']")).size() > 0;
            if (isPresent) {
                break;
            } else {
                scrollUpTo();
            }
            i++;
        } while (i <= count);
    }

    public static void back() {
        Driver.driver.navigate().back();
    }

}

