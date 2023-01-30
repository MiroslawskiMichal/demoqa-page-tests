package driver;

import base.BaseElement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import elements.TextBox;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    @JsonIgnore
    private WebDriverWait wait;
    @JsonProperty(value = "timeOutInSeconds")
    private int timeOutInSeconds;
    @JsonProperty(value = "pollingIntervalInSeconds")
    private int pollingIntervalInSeconds;

    public Waits(int timeOutInSeconds, int pollingIntervalInSeconds) {
        this.timeOutInSeconds = timeOutInSeconds;
        this.pollingIntervalInSeconds = pollingIntervalInSeconds;
        wait = new WebDriverWait(Singleton.getDriver(), Duration.ofSeconds(timeOutInSeconds));
        wait.pollingEvery(Duration.ofSeconds(pollingIntervalInSeconds));
    }

    public Waits(int timeOutInSeconds) {
        this.timeOutInSeconds = timeOutInSeconds;
        wait = new WebDriverWait(Singleton.getDriver(), Duration.ofSeconds(timeOutInSeconds));
    }

    public Waits() {
        wait = new WebDriverWait(Singleton.getDriver(), Duration.ofSeconds(10));
    }

    public BaseElement waitForDisplayed(BaseElement e) {
        wait.until(ExpectedConditions.visibilityOf(e.findElement()));
        return e;
    }

    public BaseElement waitForToBeClickable(BaseElement e) {
        wait.until(ExpectedConditions.elementToBeClickable(e.findElement()));
        return e;
    }

    public TextBox waitForAbleToSendKeys(TextBox tb) {
        wait.until(ExpectedConditions.elementToBeClickable(tb.findElement()));
        return tb;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    @Override
    public String toString() {
        return "Waits{" +
                ", timeOutInSeconds=" + timeOutInSeconds +
                ", pollingIntervalInSeconds=" + pollingIntervalInSeconds +
                '}';
    }
}
