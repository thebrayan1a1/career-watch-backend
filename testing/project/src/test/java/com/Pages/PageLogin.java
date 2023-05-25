package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Base.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageLogin extends BasePage{
    By mailInput = By.name("email");  //cambiar
    By passwordInput = By.name("pass"); //cambiar
    By btnLogin = By.name("login"); //cambiar

    //By resultado = By.className("xbh8q5q x1pwv2dq xvlca1e");
    //By resultadoFail = By.className("form-feedback");

    public PageLogin(WebDriver driver) {
    }
    public void LoginExitoso() throws InterruptedException {
        teclear("dolo_aleman@hotmail.com",mailInput);
        teclear("123456",passwordInput);
        oprimir(btnLogin);
        Thread.sleep(5000);
        //String res = driver.findElement(resultado).getText();
        //assertTrue(res.contains("edisson esteban gomez pinzon"));
        //Thread.sleep(2000);
        driver.quit();
    }
    public void LoginSinNombre() throws InterruptedException {
        teclear("",mailInput);
        teclear("123456",passwordInput);
        oprimir(btnLogin);
        Thread.sleep(5000);
       // String res = driver.findElement(resultadoFail).getText();
       // assertTrue(res.contains("Sus credenciales son inválidas. Por favor, vuelva a intentarlo"));
        driver.quit();
    }
    public void LoginSinPass() throws InterruptedException {
        teclear("dolo_aleman@hotmail.com",mailInput);
        teclear("",passwordInput);
        oprimir(btnLogin);
        Thread.sleep(5000);
        // String res = driver.findElement(resultadoFail).getText();
        // assertTrue(res.contains("Sus credenciales son inválidas. Por favor, vuelva a intentarlo"));
        driver.quit();
    }
    public void credencialesIvalidas() throws InterruptedException {
        teclear("dolo_aleman",mailInput);
        teclear("123456",passwordInput);
        oprimir(btnLogin);
        Thread.sleep(5000);
        // String res = driver.findElement(resultadoFail).getText();
        // assertTrue(res.contains("Sus credenciales son inválidas. Por favor, vuelva a intentarlo"));
        driver.quit();
    }
}