package Tests;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class C02_BeforeAfter {


    DesiredCapabilities cap;
    WindowsDriver driver;
    Process process;
    @Before
    public void setUp() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cap = new DesiredCapabilities();

    }

    @Test
    public void Test01() throws MalformedURLException {
        cap.setCapability("app", "C:\\Ucms\\Ucs.Ucms26.Designer 2.6.144.3\\Ucs.Ucms26.Designer.exe");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);

        driver.findElementByAccessibilityId("txtUserName").clear();
        driver.findElementByAccessibilityId("txtUserName").sendKeys("can");
        driver.findElementByAccessibilityId("txtPassword").clear();
        driver.findElementByAccessibilityId("txtPassword").sendKeys("x");
        driver.findElementByAccessibilityId("cmdLogin").click();


    }

    @After
    public void tearDown(){
        //driver.quit();

    }
}
