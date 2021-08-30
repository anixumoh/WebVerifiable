import Base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ExcelUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddTraining extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, dataProvider = "data-set", dataProviderClass = ExcelUtil.class)
    public void login(String Email, String Password) {
        loginPage.EnterEmail(Email).EnterPassword(Password).ClickSignIn();
        Assert.assertTrue(loginPage.CheckSuccessfulLogin());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void AddDetails() throws InterruptedException {
        addEducationPage.SearchProviderJD();
        addEducationPage.Add();
        addTrainingPage.Training();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void SchoolDetails() throws InterruptedException {
        addTrainingPage.institueName().affiliatedSchool().affiliatedSchoolCode();
        addTrainingPage.TrainingType().Residence();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void Date() throws IOException, InterruptedException {
        addTrainingPage.StartDate().EndDate();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void Save() throws InterruptedException {
        addTrainingPage.Pc().Save();

        //TimeUnit.SECONDS.sleep(4000000);
    }
}
