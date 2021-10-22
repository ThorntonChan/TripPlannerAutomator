package com.automator.handler;

import java.util.List;
import java.util.NoSuchElementException;

import com.automator.exception.TPElementNotClickable;
import com.automator.exception.TPElementNotFoundError;
import com.automator.exception.TPStaleReferenceError;
import com.automator.exception.TripPlannerException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.concurrent.TimeUnit;


public class DriverHandler {
    public static WebDriver driver = new ChromeDriver();
    public static WebDriverWait eWaitDriver = new WebDriverWait(driver, 5);
    public static FluentWait<WebDriver> fWaitDriver = new FluentWait<WebDriver>(driver);

    public static void visitUrl(String url){
        driver.get(url);
    }
    public static WebElement find(By by) throws TripPlannerException{
        try{
            return driver.findElement(by);
        } catch (NoSuchElementException e){
            throw new TPElementNotFoundError(by, e);
        }
    }
    public static WebElement find(WebElement element, By by) throws TripPlannerException{
        try{
            return element.findElement(by);
        } catch (NoSuchElementException e){
            throw new TPElementNotFoundError(by, e);
        }
    }
    public static List<WebElement> findMulti(By by) throws TripPlannerException{
        List<WebElement> results = driver.findElements(by);
        if (results.size() == 0) {
            throw new TPElementNotFoundError(by, new Exception("No elements were found"));
        }
        return results;
    }
    public static WebElement getParentElement(WebElement childElement) throws TripPlannerException{
        try {
            return childElement.findElement(By.xpath("./.."));
        } catch (NoSuchElementException e){
            throw new TPElementNotFoundError(childElement, new Exception("No parents were found"));
        } catch (StaleElementReferenceException e){
            throw new TPStaleReferenceError(childElement, e);
        }
    }
    public static Boolean hasChild(WebElement element, By by) throws TripPlannerException{
        try {
            element.findElement(by);
        } catch (StaleElementReferenceException e){
            return false;
        }
        return true;
    }
    public static void click(By by) throws TripPlannerException{
        try{
            driver.findElement(by).click();
        } catch (NoSuchElementException e){
            throw new TPElementNotFoundError(by, e);
        } catch (ElementNotInteractableException e){ //(WebDriverException)
            throw new TPElementNotClickable(by, e);
        }
    }
    public static void click(WebElement element) throws TripPlannerException{
        try{  
            element.click();
        } catch (ElementNotInteractableException e){ //(WebDriverException)
            throw new TPElementNotClickable(element, e);
        } catch (StaleElementReferenceException e){
            throw new TPStaleReferenceError(element, e);
        }
    }
    public static void input(By by, String input) throws TripPlannerException{
        try{  
            driver.findElement(by).sendKeys(input);
        } catch (ElementNotInteractableException e){ //(WebDriverException)
            throw new TPElementNotClickable(by, e);
        } catch (NoSuchElementException e){
            throw new TPElementNotFoundError(by, e);
        }
    }
    public static void clear(By by) throws TripPlannerException {
        try{  
            driver.findElement(by).clear();
        } catch (ElementNotInteractableException e){ //(WebDriverException)
            throw new TPElementNotClickable(by, e);
        } catch (NoSuchElementException e){
            throw new TPElementNotFoundError(by, e);
        }
    }
    public static void inputDropdown(By by, String input) throws TripPlannerException{
        try{  
            Select dropdown = new Select(driver.findElement(by));
            dropdown.selectByValue(input);
        } catch (NoSuchElementException e){
            throw new TPElementNotFoundError(by, e);
        }
    }
    public static String getText(WebElement element) throws TripPlannerException{
        try{
            return element.getText();
        } catch (NoSuchElementException e){
            throw new TPElementNotFoundError(element, e);
        } catch (StaleElementReferenceException e){
            throw new TPStaleReferenceError(element, e);
        }
    }
    public static String getAttributeValue(WebElement element, String attr) throws TripPlannerException{
        try{
            return element.getAttribute(attr);
        } catch(NoSuchElementException e) { //attributenotfoundexception?
            throw new TPElementNotFoundError(element, e);
        }
    }
    public static void wait(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
    public static WebElement eWaitForElement(By by, int waitTimeOut) throws TripPlannerException{
        try {
            return eWaitDriver.until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            throw new TPElementNotFoundError(by, e);
        }
    }
    public static WebElement fWaitForElement(By by, int poll, int timeout) throws TripPlannerException{
        try {
            fWaitDriver.withTimeout(Duration.ofSeconds(timeout));
            fWaitDriver.pollingEvery(Duration.ofSeconds(poll));
            return fWaitDriver.until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            throw new TPElementNotFoundError(by, e);
        }
    }
}


// alertIsPresent()
// elementSelectionStateToBe()
// elementToBeClickable()
// elementToBeSelected()
// frameToBeAvaliableAndSwitchToIt()
// invisibilityOfTheElementLocated()
// invisibilityOfElementWithText()
// presenceOfAllElementsLocatedBy()
// presenceOfElementLocated()
// textToBePresentInElement()
// textToBePresentInElementLocated()
// textToBePresentInElementValue()
// titleIs()
// titleContains()
// visibilityOf()
// visibilityOfAllElements()
// visibilityOfAllElementsLocatedBy()
// visibilityOfElementLocated()