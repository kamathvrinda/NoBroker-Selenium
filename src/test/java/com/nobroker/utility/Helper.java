package com.nobroker.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    public static void CaptureScreenshot(WebDriver driver) {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(src,new File("./Screenshots/noBroker"+getCurrentDateTime()+".png"));

            System.out.println("Screenshot captured");
        } catch (IOException e) {
            System.out.println("Unale to capture screenshot"+e.getMessage());
        }

    }

    public static String getCurrentDateTime() {
        DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

        Date currentDate = new Date();
        return format.format(currentDate);
    }

}
