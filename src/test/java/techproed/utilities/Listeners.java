package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static techproed.utilities.ReusableMethods.tumSayfaResmi;

public class Listeners implements ITestListener {

    public void onStart(ITestContext context) {
        System.out.println("onStart() ==> Tüm testlerden önce bir kez çalışır.(Class'dan önce)");
    }

    public void onFinish(ITestContext context){
        System.out.println("onFinish() ==> Tüm testlerden sonra bir kez çalışır.(Class'dan sonra)");
    }

    public void onTestStart(ITestResult result){
        System.out.println("onTestStart() ==> Hert Testten önce bir kez çalışır.");
    }

    public void onTestSuccess(ITestResult result){
        System.out.println("onTestSuccess() ==> Sadece PASS olan testlerden sonra çalışır.");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure() ==> Sadece FAIL olan testlerden sonra çalışır.");
        tumSayfaResmi();
    }

    public void onTestSkipped(ITestResult result){
        System.out.println("onTestSkipped() ==> Sadece SKIP olan testerden sonra çalışır.");
    }

}
