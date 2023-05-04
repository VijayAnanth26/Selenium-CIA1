package demo.CIA1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Question1 {
    public static void main( String[] args ) throws InterruptedException{
    	ChromeOptions co = new ChromeOptions();
    	co.addArguments("--remote-allow-origins=*");
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(co);
        
        driver.get("https://www.amazon.in/Samsung-Galaxy-Ultra-Phantom-Storage/dp/B0BT9FDZ8N/ref=sr_1_3?keywords=samsung%2Bs23%2Bultra%2B5g&qid=1683191609&sprefix=samsun%2Caps%2C2839&sr=8-3&th=1");
        
        driver.manage().window().maximize();
        
        String title = driver.getTitle();
        String etitle = "Samsung Galaxy S23 Ultra 5G (Phantom Black, 12GB, 256GB Storage) : Amazon.in: Electronics";
        System.out.println(title);
        
        if(title.equals(etitle)) {
        	System.out.println("Title is matching");
        }
        else {
        	System.out.println("Title Mismatch");
        }
        
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
//        Thread.sleep(1000); 
        
        driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
        
        Boolean present = driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).isDisplayed();
        System.out.println("Is item added to cart:" + present);
        
        driver.get("https://www.amazon.in/gp/cart/view.html/ref=dp_atch_dss_cart?");
//        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@value=\"Delete\"]")).click();
//        Thread.sleep(1000);
        
        String removeText = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div[1]/div/h1")).getText();
        String extext = "Your Amazon Cart is empty.";
        
        if(removeText.equals(extext)) {
        	System.out.println("Product is removed");
        }
        
        driver.get("https://www.amazon.in/ASUS-15-6-inch-GeForce-Windows-FA506IHRZ-HN111W/dp/B0B5DZTNZQ?ref_=Oct_DLandingS_D_6c1a28b8_61");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
//        Thread.sleep(1000);
        
        driver.get("https://www.amazon.in/gp/cart/view.html/ref=dp_atch_dss_cart?");
//        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"quantity_2\"]")).click();
//        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@name=\"proceedToRetailCheckout\"] "));
//        Thread.sleep(1000);
        
        String sign = driver.getTitle();
        System.out.println(sign);
        String esign = "Amazon Sign In";
        
        if(sign.equals(esign)) {
        	System.out.println("Success");
        }
        else {
        	System.out.println("Failure");
        }
        
        driver.quit();
    }
}