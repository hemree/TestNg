package techproed.tests.Day26_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class C02_DataProviderTest02 {

    /*
    Burada DataProvider methodlarımızı DataProviderUtils Class'ından alacağız.
    Başka bir Class'dan DataProvider alacağımız zaman @Test notasyonunun yanında belirmemiz gerkir.
    ====>>> @Test(dataProvider = "sehirVerileri", dataProviderClass = DataProviderUtils.class)
     */


    @Test(dataProvider = "sehirVerileri", dataProviderClass = DataProviderUtils.class)
    public void test01(String ad, String bolge, String plaka) {

        System.out.println(ad + " || " + bolge + " || " + plaka);

    }


    @Test(dataProvider = "kullaniciBilgileri", dataProviderClass = DataProviderUtils.class)
    public void test02(String username, String password) {

        System.out.println("Kullanıcı adı: " + username + " || Şifre: " + password);
    }


    @Test(dataProvider = "customerData", dataProviderClass = DataProviderUtils.class,groups = "RegressionGroup1")
    public void test03(String email, String password) {

        System.out.println("email: " + email + " || password " + password);

    }
}
