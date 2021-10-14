package automacao.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;


public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;

    private static String getProperties() {
        Properties properties = new Properties();
        String value = null;
        try {
            properties.load(new FileInputStream("properties/browser"));
            value = properties.getProperty("browser");
        } catch (IOException e) {
            System.out.println("Não foi possível acessar o arquivo properties " + e.getMessage());
        }
        return value;
    }

    private static WebDriver getDriver(String browser) {
        if (driver == null) {
            if (browser.equals("chrome")) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setJavascriptEnabled(true);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                if (System.getProperty("os.name").contains("Win")) {
                    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                } else {
                    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                }
                driver = new ChromeDriver(options);
            } else if (browser.equals("firefox")) {
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setJavascriptEnabled(true);
                FirefoxOptions options = new FirefoxOptions();
                capabilities.setCapability("excludeSwitches", Collections.singletonList("enable-automation"));
                capabilities.setCapability("marionette", true);
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                if (System.getProperty("os.name").contains("Win")) {
                    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                } else {
                    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.29.1-linux64.tar");
                }
                driver = new FirefoxDriver(options);
            }
        }
        assert driver != null;
        driver.manage().window().maximize();
        return driver;
    }

    public static void iniciarDriver() {
        driver = null;
        try {
            driver = getDriver(getProperties());
            wait = new WebDriverWait(driver, 30);
        } catch (Exception e) {
            System.out.println("Não foi possível iniciar o driver " + e.getMessage());
        }
    }

    public static void fecharDriver() {
        driver.quit();
    }
}
