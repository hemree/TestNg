package techproed.tests.Day25_ExcelUtils;

import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

public class C01_ExcelTest1 {

    @Test
    public void excelTest01() {

        // String path = "src/test/java/Resources/mysmoketestdata.xlsx";
        // String sayfa = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/Resources/mysmoketestdata.xlsx", "customer_info");
        System.out.println(excelUtils.getCellData(1, 0));
        String email = excelUtils.getCellData(1, 0);
        String password = excelUtils.getCellData(1, 1);
        System.out.println(email + " * " + password);

    }
}
