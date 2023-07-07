package utilities;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeClassAfterClass {

    protected static DesiredCapabilities cap;
    protected static WindowsDriver driver;
    protected static Process process;
    protected static String tarih;

    @BeforeClass
    public static void setUp() throws IOException {
        String winAppDriverServerPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
        ProcessBuilder builder = new ProcessBuilder(winAppDriverServerPath).inheritIO();
        process = builder.start();
        cap = new DesiredCapabilities();

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        tarih =date.format(formatter);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
        process.destroy();
    }
}
