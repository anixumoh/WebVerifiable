import Base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.ExcelUtil;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddWorkHistory extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, dataProvider = "data-set", dataProviderClass = ExcelUtil.class)
    public void login(String Email, String Password) {
        loginPage.EnterEmail(Email).EnterPassword(Password).ClickSignIn();
        Assert.assertTrue(loginPage.CheckSuccessfulLogin());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void AddWorkHistory() throws InterruptedException {
        addEducationPage.SearchProviderJD();
        addEducationPage.Add();
        addWorkHistoryPage.WorkHistory();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void EducationDetails() {
        addWorkHistoryPage.EmployeeName().Tittle();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void PhoneNumber() {
        addWorkHistoryPage.PhoneNumber();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void Location() {
        addWorkHistoryPage.Address().City().State().ZipCode();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void Date() throws IOException, InterruptedException {
        addWorkHistoryPage.StartDate().EndDate();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void Final() throws InterruptedException {
        Assert.assertFalse(addWorkHistoryPage.CheckCheckBoxSelected());
        addWorkHistoryPage.CurrentEmployer().Save();
        TimeUnit.SECONDS.sleep(4);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void AddWorkHis() {
        addEducationPage.Add();
        addWorkHistoryPage.WorkHistory();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void WorkGap() {
        addWorkHistoryPage.ChooseWorkHistory().Gap();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void Save() throws InterruptedException, IOException {
        addWorkHistoryPage.GapStartDate().GapEndDate();
        TimeUnit.SECONDS.sleep(4);
        addWorkHistoryPage.SaveGap();
    }
}
