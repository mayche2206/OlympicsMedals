package local9.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics2016 {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        driver.manage().window().fullscreen();
    }
    @Test
    public void test1() throws InterruptedException {
        List<String> expected = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<String> actual = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            WebElement element = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (i + 1) + "]/td"));
            actual.add(element.getText());
        }
        assertEquals(actual, expected);
    }
    @Test
    public void test2() {
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]/thead/tr/th[2]")).click();
        List<String> l1 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (i + 1) + "]/th/a")).getText();
            l1.add(s);
        }
        List<String> l2 = new ArrayList<String>(l1);
        Collections.sort(l2);
        assertEquals(l1, l2, "not equal");
    }
    @Test
    public void test3() {
        List<String> expected = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<String> actual = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            WebElement element = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (i + 1) + "]/td"));
            actual.add(element.getText());
        }
        assertNotEquals(actual, expected);
    }
    public String test41() {
        String expected = "United States";
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[3]")).click();
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[3]")).click();
        String star1 = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/a")).getText();
        assertEquals(star1, expected);
        return star1;
        }
    public String test42() {
        String expected = "United States";
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[4]")).click();
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[4]")).click();
        String star2 = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/a")).getText();
        assertEquals(star2, expected);
        return star2;
        }       
    public String test43() {
        String expected = "United States";
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[5]")).click();
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[5]")).click();
        String star3 = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/a")).getText();
        assertEquals(star3, expected);
        return star3;
        }
    public String test44() {
        String expected = "United States";
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[6]")).click();
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[6]")).click();
        String star4 = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/a")).getText();
        assertEquals(star4, expected);
        return star4;
    }
    @Test
    public void test4() {
        String expected = "United States";
        String gold = test41();
        String silver = test42();
        String bronze = test43();
        String total = test44();
        assertEquals(gold, expected);
        assertEquals(silver, expected);
        assertEquals(bronze, expected);
        assertEquals(total, expected);
    }
    public List<String> test51() {
        List<String> actual = new ArrayList<String>();
        for (int j = 0; j < 10; j++) {
            String star = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (j + 1) + "]/td[3]")).getText();
            if (star.equals("18")) {
                String counrtryName = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (j + 1) + "]/th/a")).getText();
                actual.add(counrtryName);
            }
        }
        return actual;
    }
    @Test
    public void test5() {
        List<String> expected = new ArrayList<String>();
        expected.add("China");
        expected.add("France");
        List<String> silver18 = test51();
        assertEquals(silver18, expected);
    }
    public String test61(String countryName) {
        String rowCol = "";
        for (int i = 0; i < 10; i++) {
            String country = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (i + 1) + "]/th/a")).getText();
            if (country.equals(countryName)) {
                rowCol = "Row: " + (i + 1) + ", Column: 2";
            }
        }
        return rowCol;
    }
    @Test
    public void test6(){
        String expected = "Row: 7, Column: 2";
        String country = "Japan";
        String actual = test61(country);
        assertEquals(actual, expected);
    }
    public List<String> test71() {
        List<String> twoCountries = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String first = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (i + 1) + "]/td[4]")).getText();
            int firstInt = Integer.parseInt(first);
            for (int j = 0; j < 10; j++) {
                if(i==j)
                    continue;
                String second = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (j + 1) + "]/td[4]")).getText();
                second = second.trim();
                int secondInt = Integer.parseInt(second);
                if((firstInt + secondInt) == 18) {
                    String a = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (i + 1) + "]/th/a")).getText();
                    String b = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[" + (j + 1) + "]/th/a")).getText();
                    if(!twoCountries.contains(a))
                    twoCountries.add(a);
                    if(!twoCountries.contains(b))
                    twoCountries.add(b);
                }
            }
        }
        return twoCountries;    
    }
    @Test
    public void test7() {
        List<String> expected = new ArrayList<String>();
        expected.add("Australia");
        expected.add("Italy");
        List<String> actual = test71();
        assertEquals(actual, expected);
    }


}
