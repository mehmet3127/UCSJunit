package Tests;


import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.windows.WindowsDriver;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class C01_Test {


    @Test
    public void Test_01() throws IOException, InterruptedException {

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new File ("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Ucms\\Ucs.Ucms26.Designer 2.6.144.3\\Ucs.Ucms26.Designer.exe");

        Thread.sleep(1000);
        WindowsDriver driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElementByAccessibilityId("txtUserName").clear();
        driver.findElementByAccessibilityId("txtUserName").sendKeys("can");
        driver.findElementByAccessibilityId("txtPassword").clear();
        driver.findElementByAccessibilityId("txtPassword").sendKeys("x");
        driver.findElementByAccessibilityId("cmdLogin").click();
        Thread.sleep(10000);


        /*
        // Example: Native or Webview
        Set<String> contexts = driver.getContextHandles();

        // made sure we have web view content
        // assertThat(contexts.size(), greaterThan(1));
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

        driver.findElementById("cmdCallDialog").click();
        driver.context("NATIVE_APP");
        */


        /*
        // WebView kontrolünü bulun
        WebElement webView = driver.findElement(By.className("Browser"));
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles().size());

         */

    }
}
