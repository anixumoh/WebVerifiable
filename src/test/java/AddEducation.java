import Base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ExcelUtil;
import utility.ScreenShot;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utility.ScreenShot.screenShot;

public class AddEducation extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, dataProvider = "data-set", dataProviderClass = ExcelUtil.class)
    public void login(String Email, String Password) throws IOException, InterruptedException {
        loginPage.EnterEmail(Email).EnterPassword(Password).ClickSignIn();
        Assert.assertTrue(loginPage.CheckSuccessfulLogin());
        screenShot();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void AddEducation1() throws InterruptedException {
        addEducationPage.SearchProviderJD();
        addEducationPage.Add().Education();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void EducationDetails(){
        addEducationPage.SchoolName().SchoolCode().GraduateType();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void Dates() throws InterruptedException, IOException {
        addEducationPage.StartDate().EndDate();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void DegreeAwarded(){
        addEducationPage.AwardedDegree().Completed().EcfmgNumber();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void Save() throws InterruptedException, IOException {
        addEducationPage.EdfmgNo().EcfmgDate();
        addEducationPage.Save();
    }
}
