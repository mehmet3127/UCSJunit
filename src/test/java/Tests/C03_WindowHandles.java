package Tests;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C03_WindowHandles {

    DesiredCapabilities cap;
    WindowsDriver driver;
    Process process;

    @Before
    public void setUp() throws IOException {
        String winAppDriverServerPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
        ProcessBuilder builder = new ProcessBuilder(winAppDriverServerPath).inheritIO();
        process = builder.start();
        cap = new DesiredCapabilities();

    }


    @Test
    public void Test01() throws MalformedURLException, InterruptedException {
        cap.setCapability("app", "C:\\Ucms\\Ucs.Ucms26.Designer 2.6.144.3\\Ucs.Ucms26.Designer.exe");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);

        driver.findElementByAccessibilityId("txtUserName").clear();
        driver.findElementByAccessibilityId("txtUserName").sendKeys("can");
        driver.findElementByAccessibilityId("txtPassword").clear();
        driver.findElementByAccessibilityId("txtPassword").sendKeys("x");

        driver.findElementByAccessibilityId("cmdLogin").click();


        /*String UcsWindowHandles = driver.findElementByAccessibilityId("TitleBa")
        System.out.println("UcsWindowHandles = " + UcsWindowHandles);
        driver.switchTo().window(UcsWindowHandles);*/


        //Set<String> windowHandles = driver.getWindowHandles();
        //driver.switchTo().window(windowHandles.iterator().next());


        Thread.sleep(5000);
        String windows = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(windows).getTitle();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        


    }

    @After
    public void tearDown() {
        driver.quit();
        process.destroy();
    }

}
