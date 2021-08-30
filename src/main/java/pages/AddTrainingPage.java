package pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utility.ActionClassUtil.DoClickActionClass;
import static utility.JavaScriptUtil.DatePickerJE;
import static utility.JavaScriptUtil.DoClick;

public class AddTrainingPage extends TestBase {

    public static final String StartDates = "05/01/1997";
    public static final String EndDates = "05/04/1991";
    public static final String EcfmDates = "05/04/2021";

    @FindBy(xpath = "//div[@class='item-label s-MSsmEw1rR0Dg'][normalize-space()='Training']")
    @CacheLookup
    private WebElement Training;

    @FindBy(xpath = "//input[@name='institueName']")
    @CacheLookup
    private WebElement institueName;

    @FindBy(xpath = "//input[@name='affiliatedSchool']")
    @CacheLookup
    private WebElement affiliatedSchool;

    @FindBy(xpath = "//input[@name='affiliatedSchoolCode']")
    @CacheLookup
    private WebElement affiliatedSchoolCode;


    @FindBy(xpath = "//div[contains(text(),'Fellowship')]")
    @CacheLookup
    private WebElement Fellowship;

    @FindBy(xpath = "//div[contains(text(),'Fellowship')]")
    @CacheLookup
    private WebElement Residency;

    @FindBy(xpath = "//input[@name='startDate']")
    @CacheLookup
    private WebElement StartDate;

    @FindBy(xpath = "//input[@name='endDate']")
    @CacheLookup
    private WebElement EndDate;

    @FindBy(xpath = "//div[@class='fake-input s-JojsLWufS2uv']")
    @CacheLookup
    private WebElement PC;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    @CacheLookup
    private WebElement Save;

    public AddTrainingPage() {
        PageFactory.initElements(getdriver.get(), this);
    }

    public AddTrainingPage institueName() {
        institueName.sendKeys("Harvard University");
        return this;
    }

    public AddTrainingPage affiliatedSchool() {
        affiliatedSchool.sendKeys("Harvard University");
        return this;
    }

    public AddTrainingPage affiliatedSchoolCode() {
        affiliatedSchoolCode.sendKeys("Harvard University");
        return this;
    }

    public AddTrainingPage TrainingType() throws InterruptedException {
        DoClickActionClass(Fellowship);
        return this;
    }

    public AddTrainingPage Residence() throws InterruptedException {
        DoClick(Residency);
        return this;
    }

    public AddTrainingPage StartDate() throws IOException, InterruptedException {
        DatePickerJE(StartDate, StartDates);
        return this;
    }

    public AddTrainingPage EndDate() throws IOException, InterruptedException {
        DatePickerJE(EndDate, EndDates);
        return this;
    }

    public AddTrainingPage Pc() {
        DoClickActionClass(PC);
        return this;
    }

    public AddTrainingPage Training() {
        DoClickActionClass(Training);
        return this;
    }

    public AddTrainingPage Save() {
        DoClickActionClass(Save);
        return this;
    }
}
