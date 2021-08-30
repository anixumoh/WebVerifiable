package pages;

import Base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static utility.JavaScriptUtil.DatePickerJE;
import static utility.JavaScriptUtil.DoScrollIntoView;

public class AddWorkHistoryPage extends TestBase {

    public static final String StartDates = "05/01/1997";
    public static final String EndDates = "05/04/1991";

    @FindBy(xpath = "//input[@data-cy='startDate']")
    @CacheLookup
    private WebElement GapStartDate;

    @FindBy(xpath = "//input[@name='endDate']")
    @CacheLookup
    private WebElement GapEndDate;

    @FindBy(xpath = "//div[normalize-space()='Gap']")
    @CacheLookup
    private WebElement Gap;

    @FindBy(xpath = "//div[@class='text s-y2lUwalIJEkN'][normalize-space()='Employment']")
    @CacheLookup
    private WebElement WI;


    @FindBy(xpath = "//div[@class='item-label s-MSsmEw1rR0Dg'][normalize-space()='Work History']")
    @CacheLookup
    private WebElement WorkHistory;

    @FindBy(xpath = "//input[@placeholder='Zip Code']")
    @CacheLookup
    private WebElement ZipCode;

    @FindBy(xpath = "//button[normalize-space()='Alabama (AL)']")
    @CacheLookup
    private WebElement Alabama;

    @FindBy(xpath = "//input[@name='employeeName']")
    @CacheLookup
    private WebElement EmployeeName;

    @FindBy(xpath = "//input[@name='title']")
    @CacheLookup
    private WebElement tittle;

    @FindBy(xpath = "//input[@name='phone']")
    @CacheLookup
    private WebElement phone;

    @FindBy(xpath = "//input[@placeholder='Address Line 1']")
    @CacheLookup
    private WebElement Address;

    @FindBy(xpath = "//input[@placeholder='City']")
    @CacheLookup
    private WebElement City;

    @FindBy(xpath = "//input[@placeholder='State']")
    @CacheLookup
    private List<WebElement> State;

    @FindBy(xpath = "//input[@name='startDate']")
    @CacheLookup
    private WebElement StartDate;

    @FindBy(xpath = "//input[@name='endDate']")
    @CacheLookup
    private WebElement EndDate;

    @FindBy(xpath = "//div[@class='fake-input s-JojsLWufS2uv']")
    @CacheLookup
    private WebElement CurrentEmployer;

    @FindBy(xpath = "//textarea[@name='depatureReason']")
    @CacheLookup
    private WebElement ReasonDeparture;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    @CacheLookup
    private WebElement Save;

    @FindBy(xpath = "//body/div[@id='app']/main[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/button[1]")
    @CacheLookup
    private WebElement GapSave;

    public AddWorkHistoryPage() {
        PageFactory.initElements(getdriver.get(), this);
    }

    public AddWorkHistoryPage EmployeeName() {
        EmployeeName.sendKeys(new Faker().name().firstName());
        return this;
    }

    public AddWorkHistoryPage Tittle() {
        tittle.sendKeys("Automation Test Engineer");
        return this;
    }

    public AddWorkHistoryPage PhoneNumber() {
        phone.sendKeys(new Faker().phoneNumber().subscriberNumber(10));
        return this;
    }

    public AddWorkHistoryPage Address() {
        Address.sendKeys(new Faker().internet().safeEmailAddress());
        return this;
    }

    public AddWorkHistoryPage City() {
        City.sendKeys(new Faker().address().city());
        return this;
    }

    public AddWorkHistoryPage State() {
        State.get(0).click();
        Alabama.click();
        return this;
    }

    public AddWorkHistoryPage ZipCode() {
        ZipCode.sendKeys(new Faker().address().zipCode());
        return this;
    }

    public AddWorkHistoryPage StartDate() throws IOException, InterruptedException {
        DatePickerJE(StartDate, StartDates);
        return this;
    }

    public AddWorkHistoryPage EndDate() throws IOException, InterruptedException {
        DatePickerJE(EndDate, EndDates);
        return this;
    }

    public AddWorkHistoryPage GapStartDate() throws IOException, InterruptedException {
        DatePickerJE(GapStartDate, StartDates);
        return this;
    }

    public AddWorkHistoryPage GapEndDate() throws IOException, InterruptedException {
        DatePickerJE(GapEndDate, EndDates);
        return this;
    }

    public boolean CheckCheckBoxSelected() {
        return CurrentEmployer.isSelected();
    }

    public AddWorkHistoryPage CurrentEmployer() {
        CurrentEmployer.click();
        return this;
    }

    public AddWorkHistoryPage ReasonForDeparture() {
        ReasonDeparture.sendKeys("Reason Best Known to Merchant");
        return this;
    }

    public AddWorkHistoryPage Save() {
        Save.click();
        return this;
    }

    public AddWorkHistoryPage WorkHistory() {
        WorkHistory.click();
        return this;
    }

    public AddWorkHistoryPage ChooseWorkHistory() {
        WI.click();
        return this;
    }

    public AddWorkHistoryPage Gap() {
        Gap.click();
        return this;
    }

    public AddWorkHistoryPage SaveGap() {
        GapSave.click();
        return this;
    }
}
