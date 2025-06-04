package tests.day21_pageObjectModel_testNgAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_TestDataKullanimi {

    // POM'in temel hedefi
    // locate test datasi veya test calistirma tercihlerinde ehrhangi
    // bir degisiklik olursa
    // test methoduna gelmeden belirlenmis yerlerdeki duzeltmeleri
    // 1 kere yapip , tum test methodlarinin update edilmesini saglamaktir

    @Test
    public void pozitifLogintesti() {
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
       // Driver.getDriver().get("https://www.testotomasyonu.com/"); //dinamik degil
        Driver.getDriver().get(ConfigReader.getProperty("toUrl")); // Dinamik


        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage(); //dinamik
        ReusableMethods.tumSayfaResimCekTarihli(Driver.getDriver());
        ReusableMethods.bekle(2);
        testotomasyonuPage.accountLinki.click();


        // 3- Kullanici email'i olarak gecerli email girin
       // testotomasyonuPage.emailKutusu.sendKeys("wise@gmail.com"); //dinamik degil
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));


        // 4- Kullanici sifresi olarak gecerli password girin
       // testotomasyonuPage.passwordKutusu.sendKeys("123456"); // dinamik degil
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword")); // dinamik

        // 5- Login butonuna basarak login olun


        testotomasyonuPage.loginButonu.click();  //dinamik
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        // 7- logout olun
        testotomasyonuPage.logoutButonu.click(); //dinamik

        // 8- sayfayi kapatin
        Driver.quitDriver();

    }
}
