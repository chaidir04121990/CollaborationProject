import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dava_TestNG_CH6 {

    public static WebDriver driver;
    String url = "https://kampusmerdeka.kemdikbud.go.id/";

    @BeforeMethod
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\Campus Lyfe\\Freedom Campus\\SYNERGY\\CollaborationProject\\src\\test\\java\\TestNG_RA\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(url);
    }

    //    @BeforeMethod
    public static List openFile() {

        BufferedReader reader;

        String email = "";
        String password = "";
        List<String> list = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader("D:\\Campus Lyfe\\Freedom Campus\\SYNERGY\\CollaborationProject\\src\\test\\java\\TestNG_RA\\credential"));
            String line = reader.readLine();
            int x = 0;

            while (line != null) {
//                System.out.println(line);
                if (x == 0) {
                    email = line;
                    list.add(email);
                } else {
                    password = line;
                    list.add(password);
                }
                // read next line
                line = reader.readLine();
                x++;
            }
//        System.out.println("Ini Email: " + email);
//        System.out.println("Ini Password: " + password);

            reader.close();
            return list;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Test
    public void testfunc(){
//        this function is used to open file named "credentials" with real email and password
//        "credentials" file is included into git.ignore so it will not be pushed to repo
        try {
            WebElement login_button = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/header/div/div/nav/div"));
            login_button.click();

            WebElement input_email = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[3]/div[1]/div[2]/input"));
            WebElement input_password = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[3]/div[2]/div[2]/input"));

            List<String> list_cred = openFile();
//            for (int i = 0; i < 2; i++){
//                System.out.println(i);
//                System.out.println(list_cred.get(i));
//            }

            input_email.isDisplayed();
            input_email.clear();
            input_password.isDisplayed();
            input_password.clear();

//            put email and password from "credentials" file
            input_email.sendKeys(list_cred.get(0));
            input_password.sendKeys(list_cred.get(1));

            WebElement login_submit_button = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[5]/div/p"));
            login_submit_button.click();

            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

//            String page_url = driver.getCurrentUrl();
            WebElement profile_name = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[1]/div[1]/div[2]/p[1]"));
            WebElement profile_status = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[1]/div[1]/div[2]/p[2]"));
            WebElement profile_university = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[1]/div[1]/div[2]/p[3]"));

            System.out.println(profile_name);
            System.out.println(profile_status);
            System.out.println(profile_university);

            Assert.assertEquals((String) profile_name.getText(), "DAVA ADITYA JAUHAR");
            Assert.assertEquals((String) profile_status.getText(), "Mahasiswa");
            Assert.assertEquals((String) profile_university.getText(), "Institut Teknologi Sepuluh Nopember");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("Login button not found");
        }
    }

    @AfterMethod
    public void teardown() {
//        driver.close();
        driver.quit();
    }

}
