package com.Tests;

import com.Pages.PageLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestCredencialesInvalidas {

        private WebDriver driver;
        PageLogin pageLogin;

        @BeforeEach
        public void setUp() throws Exception {
            pageLogin = new PageLogin(driver);
            driver =pageLogin.chromeDriverConnection();
            pageLogin.link("https://www.facebook.com/");
        }
        @AfterEach
        public void tearDown() throws Exception {
            driver.quit();
        }

        @Test
        public void test() throws InterruptedException {
            pageLogin.credencialesIvalidas();

        }
    }
