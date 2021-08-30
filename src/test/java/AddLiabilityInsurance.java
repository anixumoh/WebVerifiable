import Base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ExcelUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddLiabilityInsurance extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, dataProvider = "data-set", dataProviderClass = ExcelUtil.class)
    public void login(String Email, String Password) {
        loginPage.EnterEmail(Email).EnterPassword(Password).ClickSignIn();
        Assert.assertTrue(loginPage.CheckSuccessfulLogin());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void addLiabilityInsurance() throws InterruptedException {
        addEducationPage.SearchProviderJD();
        addEducationPage.Add().Education();
        addLiabilityInsurancePage.AddLiabilityInsurance();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void LiabilityInsuranceDetails() throws InterruptedException {
        addLiabilityInsurancePage.IssuanceName().PolicyNumber();
        Assert.assertFalse(addLiabilityInsurancePage.CheckBoxIsSelected());
        addLiabilityInsurancePage.SelfInsured();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void Date() throws InterruptedException, IOException {
        addLiabilityInsurancePage.EffectiveDate().OriginalEffectiveDate().ExpirationDate();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void Coverage() throws InterruptedException {
        addLiabilityInsurancePage.Type();
        Assert.assertTrue(addLiabilityInsurancePage.Individual());
        Assert.assertTrue(addLiabilityInsurancePage.CheckShared());
        addLiabilityInsurancePage.Type();

        Assert.assertTrue(addLiabilityInsurancePage.tailcoverage());
        Assert.assertTrue(addLiabilityInsurancePage.unlimitedcoverage());
        addLiabilityInsurancePage.selectunlimitedcoverage().Selecttailcoverage();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void Aggregate() throws InterruptedException {
        addLiabilityInsurancePage.amtCoverageOccurenc();
        addLiabilityInsurancePage.amtCoverageAggregate();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void Save() {
        addLiabilityInsurancePage.Save();
    }
}
