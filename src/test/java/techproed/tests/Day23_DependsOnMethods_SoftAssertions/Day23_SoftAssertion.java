package techproed.tests.Day23_DependsOnMethods_SoftAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;


public class Day23_SoftAssertion {

    @Test
    public void softAssertTest() {
        assertEquals(0,1);
        assertEquals(1,2);
        assertEquals(0,1);
        assertEquals(0,1);
        assertEquals(0,1);
        assertEquals(0,1);

        //SoftAssertion yapabilmek için 3 adım izliyoruz

        //1.Adım : SofAssert objesi oluştur.
        SoftAssert softAssert = new SoftAssert();


        //2.Adım : Assertion Yap.
        //1.Assertion
        softAssert.assertTrue("Selenium".contains("a")); //Soft Assertion kullanıldığı için test fail olsa bile Java çalışmayı durdurmaz
        System.out.println("Assertion 1 çalıştı");
        //2.Assertion
        softAssert.assertEquals(1,2); //Üsste ki assertion fail oldu fakat bu Assertion da çalıştı.Çünkü sof assertion
        System.out.println("Assertion 2 çalıştı");



        //3.Adım : assertAll() method'unu çalıştır.
        softAssert.assertAll();
        System.out.println("hello"); //Bu kod çalışmayacak. Çünkü assertAll() method'u fail durumunda çalışmayı(assertionlar sonrası) durdurur.
    }
}
