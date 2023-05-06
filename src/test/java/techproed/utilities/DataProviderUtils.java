package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] sehirVerileri() {

        return new Object[][]{{"Istanbul","Marmara","34"},
                {"DiyarBakır","GüneyDoğu","12"},
                {"Ankara","İçAnadolu","06"}};
    }

    @DataProvider()
    public Object[][] kullaniciBilgileri() {

        return new Object[][]{{"Ali", "Ali.123"}, {"Ayşe", "Ayşe.123"}, {"Said", "said_987"}};
    }


    @DataProvider()
    public Object[][] customerData() {
        String path = "src/test/java/Resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";

        //Excel Utils objesi oluşturarak  getDataArray() methodu ile iki boyutlu String Array'i DataProvider olarak return ediyorum
        ExcelUtils excelUtils = new ExcelUtils(path, sheetName);
        return excelUtils.getDataArrayWithoutFirstRow();
    }
}
