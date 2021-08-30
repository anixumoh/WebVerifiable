package pages;

import Base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utility.ActionClassUtil.DoClickActionClass;
import static utility.JavaScriptUtil.*;


public class AddProviderPage extends TestBase {

    public static final String DateOfBirth = "05/01/1997";
    public static final String CredentialedDates = "05/04/1991";
    public static final String NewCredentialedDates = "05/05/2000";

    @FindBy(xpath = "//button[normalize-space()='Add Provider']")
    @CacheLookup
    private WebElement AddProvider;

    @FindBy(xpath = "//button[normalize-space()='Alabama (AL)']")
    @CacheLookup
    private WebElement Alabama;

    @FindBy(xpath = "//input[@name='firstName']")
    @CacheLookup
    private WebElement FirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    @CacheLookup
    private WebElement LastName;

    @FindBy(xpath = "//div[@class='fake-input s-JojsLWufS2uv']")
    @CacheLookup
    private WebElement HasAlias;

    @FindBy(xpath = "//input[@name='aliasFirstName']")
    @CacheLookup
    private WebElement AlisFirstName;

    @FindBy(xpath = "//input[@name='aliasLastName']")
    @CacheLookup
    private WebElement AlisLastName;

    @FindBy(xpath = "//input[@name='email']")
    @CacheLookup
    private WebElement EmailAddress;

    @FindBy(xpath = "//input[@name='phone']")
    @CacheLookup
    private WebElement Phone;

    @FindBy(xpath = "//input[@placeholder='Address Line 1']")
    @CacheLookup
    private WebElement AddressLine1;

    @FindBy(xpath = "//input[@placeholder='City']")
    @CacheLookup
    private WebElement City;

    @FindBy(xpath = "//input[@placeholder='State']")
    @CacheLookup
    private List<WebElement> State;

    @FindBy(xpath = "//input[@placeholder='Zip Code']")
    @CacheLookup
    private WebElement ZipCode;

    @FindBy(xpath = "//input[@name='dateOfBirth']")
    @CacheLookup
    private WebElement DOB;

    @FindBy(xpath = "//input[@name='ssn']")
    @CacheLookup
    private WebElement SSN;

    @FindBy(xpath = "//button[@data-cy='addLanguage']")
    @CacheLookup
    private WebElement AddLanguage;

    @FindBy(xpath = "//input[@name='languages']")
    @CacheLookup
    private WebElement Language;

    @FindBy(xpath = "//button[@class='comp-icon icon-trash s-r6iPZagp3xKw']")
    @CacheLookup
    private WebElement DeleteLanguage;

    @FindBy(xpath = "//input[@name='credentialedDate']")
    @CacheLookup
    private WebElement CredentialedDate;

    @FindBy(xpath = "//button[@data-cy='addReCredDate']")
    @CacheLookup
    private WebElement AddCredentialedDate;

    @FindBy(xpath = "//input[@name='recredentialedDates']")
    @CacheLookup
    private WebElement NewCredentialedDate;

    @FindBy(xpath = "//button[@data-cy='deleteReCredDate']")
    @CacheLookup
    private WebElement DeleteCredentialedDate;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    @CacheLookup
    private WebElement Submit;

    public AddProviderPage() {
        PageFactory.initElements(getdriver.get(), this);
    }

    public AddProviderPage ClickAddProvider() {
        CheckElementPresent(AddProvider);
        AddProvider.click();
        return this;
    }

    public AddProviderPage FirstName() {
        CheckElementPresent(FirstName);
        FirstName.sendKeys(new Faker().name().firstName());
        return this;
    }

    public AddProviderPage LastName() {
        CheckElementPresent(LastName);
        LastName.sendKeys(new Faker().name().lastName());
        return this;
    }

    public boolean HisAlisIsPreselected() {
        return HasAlias.isSelected();
    }

    public AddProviderPage CheckHasAlias() {
        HasAlias.click();
        return this;
    }

    public boolean CheckAliasFistName() {
        return CheckElementPresent(AlisFirstName);
    }

    public boolean CheckAliasLastName() {
        return CheckElementPresent(AlisLastName);
    }

    public AddProviderPage AlisFirstName() {
        AlisFirstName.sendKeys(new Faker().name().firstName());
        return this;
    }

    public AddProviderPage AlisLastName() {
        AlisLastName.sendKeys(new Faker().name().lastName());
        return this;
    }

    public AddProviderPage EmailAddress() {
        EmailAddress.sendKeys(new Faker().internet().safeEmailAddress());
        return this;
    }

    public AddProviderPage PhoneNumber() {
        Phone.sendKeys(new Faker().phoneNumber().subscriberNumber(10));
        return this;
    }

    public AddProviderPage AddressLine1() {
        AddressLine1.sendKeys(new Faker().address().country());
        return this;
    }

    public AddProviderPage City() {
        City.sendKeys(new Faker().address().city());
        return this;
    }

    public AddProviderPage State() {
        State.get(0).click();
        Alabama.click();
        return this;
    }

    public AddProviderPage ZipCode() {
        ZipCode.sendKeys(new Faker().address().zipCode());
        return this;
    }

    public AddProviderPage DOB() throws IOException, InterruptedException {
        DatePickerJE(DOB, DateOfBirth);
        return this;
    }

    public AddProviderPage SSN() {
        SSN.sendKeys("" + new Faker().idNumber().hashCode());
        return this;
    }

    public AddProviderPage AddLanguage() {
        DoClick(AddLanguage);
        return this;
    }

    public AddProviderPage RemoveLanguage() {
        DoClickActionClass(DeleteLanguage);
        return this;
    }

    public boolean SetLanguage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return CheckElementPresent(Language);
    }

    public boolean SetDeleteLanguage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return CheckElementPresent(DeleteLanguage);
    }

    public AddProviderPage Language() {
        Language.sendKeys(new Faker().country().name());
        return this;
    }

    public boolean e() throws InterruptedException {
        return CheckElementPresent(Language);
    }

    public AddProviderPage CredentialedDate() throws IOException, InterruptedException {
        DatePickerJE(CredentialedDate, CredentialedDates);
        return this;
    }

    public AddProviderPage AddCredentialedDate() {
        DoClickActionClass(AddCredentialedDate);
        return this;
    }

    public boolean CheckCredentialedNewDate() {
        return CheckElementPresent(NewCredentialedDate);
    }

    public AddProviderPage NewCredentialedDate() throws IOException, InterruptedException {
        DatePickerJE(NewCredentialedDate, "" + new Faker().date().birthday(20, 50));
        return this;
    }

    public AddProviderPage Submit() {
        DoScrollIntoView(Submit);
        DoClickActionClass(Submit);
        return this;
    }
}
