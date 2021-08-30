package pages;

import Base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import static utility.ActionClassUtil.DoClickActionClass;
import static utility.JavaScriptUtil.DatePickerJE;
import static utility.JavaScriptUtil.DoClick;

public class AddEducationPage extends TestBase {

    public static final String StartDates = "05/01/1997";
    public static final String EndDates = "05/04/1991";
    public static final String EcfmDates = "05/04/2021";

    @FindBy(xpath = "//input[@name='ecfmgNumber']")
    @CacheLookup
    private WebElement ecfmgNo;


    @FindBy(xpath = "//input[@name='ecfmgIssueDate']")
    @CacheLookup
    private WebElement ecfmgDate;

    @FindBy(xpath = "//input[@placeholder='Search']")
    @CacheLookup
    private WebElement SearchProvider;

    @FindBy(xpath = "//div[@class='label s-keQqhs0UPOxA']")
    @CacheLookup
    private WebElement JD;

    @FindBy(xpath = "//button[contains(@class,'comp-button primary s-NAiGX2PK6Xhc')]")
    @CacheLookup
    private WebElement Add;

    @FindBy(xpath = "//div[@class='item-label s-MSsmEw1rR0Dg'][contains(.,'Education')]")
    @CacheLookup
    private WebElement Education;


    @FindBy(xpath = "//input[@name='schoolName']")
    @CacheLookup
    private WebElement SchoolName;

    @FindBy(xpath = "//input[@name='schoolCode']")
    @CacheLookup
    private WebElement SchoolCode;

    @FindBy(xpath = "//div[contains(text(),'Undergraduate')]")
    @CacheLookup
    private WebElement GraduateType;

    @FindBy(xpath = "//div[@class='item-label s-MSsmEw1rR0Dg'][normalize-space()='Professional']")
    @CacheLookup
    private WebElement Professional;

    @FindBy(xpath = "//input[@name='startDate']")
    @CacheLookup
    private WebElement StartDate;

    @FindBy(xpath = "//input[@name='endDate']")
    @CacheLookup
    private WebElement EndDate;

    @FindBy(xpath = "//input[@name='degreeAwarded']")
    @CacheLookup
    private WebElement DegreeAwarded;

    @FindBy(xpath = "//div[@data-cy='edu-completed']")
    @CacheLookup
    private WebElement Completed;

    @FindBy(xpath = "//div[@data-cy='has-ecfmg']")
    @CacheLookup
    private WebElement EcfmgNumber;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    @CacheLookup
    private WebElement Save;

    public AddEducationPage() {
        PageFactory.initElements(getdriver.get(), this);
    }

    public AddEducationPage SchoolName() {
        SchoolName.sendKeys("Harvard University");
        return this;
    }

    public AddEducationPage SchoolCode() {
        SchoolCode.sendKeys("E00468");
        return this;
    }

    public AddEducationPage GraduateType() {
        DoClickActionClass(GraduateType);
        DoClickActionClass(Professional);
        return this;
    }

    public AddEducationPage StartDate() throws IOException, InterruptedException {
        DatePickerJE(StartDate, StartDates);
        return this;
    }

    public AddEducationPage EndDate() throws IOException, InterruptedException {
        DatePickerJE(EndDate, EndDates);
        return this;
    }

    public AddEducationPage AwardedDegree(){
        DegreeAwarded.sendKeys("Bachelors of Science");
        return this;
    }

    public AddEducationPage Completed() {
        Assert.assertFalse(Completed.isSelected());
        DoClick(Completed);
        return this;
    }

    public AddEducationPage EcfmgNumber(){
        Assert.assertFalse(EcfmgNumber.isSelected());
        DoClick(EcfmgNumber);
        return this;
    }

    public AddEducationPage Save(){
        DoClick(Save);
        return this;
    }


    public AddEducationPage Add(){
        DoClick(Add);
        return this;
    }

    public AddEducationPage Education(){
        DoClick(Education);
        return this;
    }

    public AddEducationPage SearchProviderJD() throws InterruptedException {
        SearchProvider.sendKeys("John");
        Thread.sleep(2000);
        JD.click();
        return this;
    }

    public AddEducationPage EdfmgNo() throws InterruptedException {
        ecfmgNo.sendKeys("12345678");
        return this;
    }

    public AddEducationPage EcfmgDate() throws IOException, InterruptedException {
        DatePickerJE(ecfmgDate, EcfmDates);
        return this;
    }

}
