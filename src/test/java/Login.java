import Base.TestBase;
import Listeners.ExtentReport;
import groovy.beans.ListenerList;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ExcelUtil;

public class Login extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void HomePage(){
        Assert.assertTrue(loginPage.CheckVerifiableLogo());
        Assert.assertTrue(loginPage.CheckSignInWitGoogle());
        Assert.assertTrue(loginPage.CheckForgotPassword());
        Assert.assertTrue(loginPage.CheckTittle());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, dataProvider = "data-set", dataProviderClass = ExcelUtil.class)
    public void login(String Email, String Password){
        loginPage.EnterEmail(Email).EnterPassword(Password).ClickSignIn();
        Assert.assertTrue(loginPage.CheckSuccessfulLogin());
        Assert.assertTrue(loginPage.CheckTittle());
    }
}
