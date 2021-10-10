package co.com.sofka.page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonActionOnPages {

    private final WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    //Funcion para limpiar campos
    protected void clear(By by){
        driver.findElement(by).clear();
    }

    //Funcion para llenar campos
    protected void type(By by, String... value){
        driver.findElement(by).sendKeys(value);
    }

    //Funcion para hacer click
    protected void clickOn(By by){
        driver.findElement(by).click();
    }

    //Funcion para hacer submit
    protected void doSubmit(By by){
        driver.findElement(by).submit();
    }

    //Funcion para realizar un gettext
    protected String getText(By by){
      return  driver.findElement(by).getText();
    }
}
