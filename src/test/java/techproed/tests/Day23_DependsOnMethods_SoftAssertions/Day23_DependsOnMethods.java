package techproed.tests.Day23_DependsOnMethods_SoftAssertions;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Day23_DependsOnMethods {
    /*
    TestNG'de Tüm test methodları bağımsız çalışır.
    Method'ları bağımlı çalıştımak istiyorsak "dependsOnMethods" parametresi kullanılır.
    Aşağıda "searchTest()" method'u "homePageTest()" method'una bağlıdır.
    Eğer "homaPageTest()" fail olursa "searchTest()" çalışmaz, "Ignore" edilir.
    Eğer "homaPageTest()" passed olursa "searchTest()" da çalışır.
     */

    @Test
    public void homePageTest() {
        //Burada Hard assertion kullanıldığı için test fail olduğunda, java çalışmayı durdurur ve sonra ki kodlar çalşmayı durdurur.
        assertEquals(1,2);
        System.out.println("Anasayfa'ya gidildi");
    }

    @Test(dependsOnMethods = "homePageTest")
    public void searchTest() {
        System.out.println("Arama Yapıldı");
    }

    @Test(dependsOnMethods = "homePageTest")
    public void signInTest() {
        System.out.println("Giriş Yapıldı");
    }
}
