import Base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ExcelUtil;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddProvider extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, dataProvider = "data-set", dataProviderClass = ExcelUtil.class)
    public void login(String Email, String Password) {
        loginPage.EnterEmail(Email).EnterPassword(Password).ClickSignIn();
        Assert.assertTrue(loginPage.CheckSuccessfulLogin());
        Assert.assertTrue(loginPage.CheckTittle());
        addProviderPage.ClickAddProvider();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void AddProviderDetails() {
        addProviderPage.FirstName().LastName();
        Assert.assertFalse(addProviderPage.HisAlisIsPreselected());
        addProviderPage.CheckHasAlias();
        Assert.assertTrue(addProviderPage.CheckAliasFistName());
        Assert.assertTrue(addProviderPage.CheckAliasLastName());
        addProviderPage.AlisFirstName().AlisLastName();
        addProviderPage.EmailAddress().PhoneNumber();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void AddProvideAddress() throws IOException, InterruptedException {
        addProviderPage.AddressLine1().City().State().ZipCode();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void DOB_SSN() throws IOException, InterruptedException {
        addProviderPage.DOB().SSN();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void Languages() {
        addProviderPage.AddLanguage();
        addProviderPage.Language();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void CredentialedDate() throws IOException, InterruptedException {
        addProviderPage.CredentialedDate();
        addProviderPage.Submit();
    }

}
