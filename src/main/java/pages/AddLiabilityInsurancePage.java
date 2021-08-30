package pages;

import Base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static utility.ActionClassUtil.DoClickActionClass;
import static utility.JavaScriptUtil.*;

public class AddLiabilityInsurancePage extends TestBase {

    public static final String StartDates = "05/01/1997";
    public static final String EndDates = "05/04/1991";
    public static final String EcfmDates = "05/04/2021";

    @FindBy(xpath = "//input[@name='insuranceName']")
    @CacheLookup
    private WebElement insuranceName;

    @FindBy(xpath = "//input[@name='policyNumber']")
    @CacheLookup
    private WebElement policyNumber;

    @FindBy(xpath = "//div[@data-cy='self-insured']")
    @CacheLookup
    private WebElement selfinsured;

    @FindBy(xpath = "//input[@name='effectiveDate']")
    @CacheLookup
    private WebElement effectiveDate;

    @FindBy(xpath = "//input[@name='expirationDate']")
    @CacheLookup
    private WebElement expirationDate;

    @FindBy(xpath = "//input[@name='originalEffecDate']")
    @CacheLookup
    private WebElement originalEffecDate;

    @FindBy(xpath = "//div[contains(text(),'Individual')]")
    @CacheLookup
    private WebElement Type;

    @FindBy(xpath = "//div[@class='item-label s-MSsmEw1rR0Dg'][normalize-space()='Individual']")
    @CacheLookup
    private WebElement Individual;

    @FindBy(xpath = "//div[normalize-space()='Shared']")
    @CacheLookup
    private WebElement Shared;

    @FindBy(xpath = "//div[@data-cy='unlimited-coverage']")
    @CacheLookup
    private WebElement unlimitedcoverage;

    @FindBy(xpath = "//div[@data-cy='tail-coverage']")
    @CacheLookup
    private WebElement tailcoverage;

    @FindBy(xpath = "//input[@name='amtCoverageOccurence']")
    @CacheLookup
    private WebElement amtCoverageOccurence;

    @FindBy(xpath = "//input[contains(@data-cy,'amtCoverageAggregate')]")
    @CacheLookup
    private WebElement amtCoverageAggregate;

    @FindBy(xpath = "//button[contains(@data-cy,'Save')]")
    @CacheLookup
    private WebElement Save;

    @FindBy(xpath = "//div[@class='item-label s-MSsmEw1rR0Dg'][normalize-space()='Liability Insurance']")
    @CacheLookup
    private WebElement AddLiabilityInsurance;

    public AddLiabilityInsurancePage() {
        PageFactory.initElements(getdriver.get(), this);
    }

    public AddLiabilityInsurancePage IssuanceName() {
        insuranceName.sendKeys("Harvard University");
        return this;
    }

    public AddLiabilityInsurancePage PolicyNumber() {
        policyNumber.sendKeys(new Faker().number().digits(10));
        return this;
    }

    public AddLiabilityInsurancePage EffectiveDate() throws IOException, InterruptedException {
        DatePickerJE(effectiveDate, StartDates);
        return this;
    }

    public AddLiabilityInsurancePage ExpirationDate() throws IOException, InterruptedException {
        DatePickerJE(expirationDate, EndDates);
        return this;
    }

    public AddLiabilityInsurancePage OriginalEffectiveDate() throws IOException, InterruptedException {
        DatePickerJE(originalEffecDate, EndDates);
        return this;
    }

    public AddLiabilityInsurancePage AwardedDegree() {
        unlimitedcoverage.click();
        return this;
    }

    public AddLiabilityInsurancePage Completed() {
        DoClick(tailcoverage);
        return this;
    }

    public AddLiabilityInsurancePage amtCoverageAggregate() throws InterruptedException {
        amtCoverageAggregate.sendKeys(new Faker().number().digits(4));
        TimeUnit.SECONDS.sleep(2);
        return this;
    }

    public AddLiabilityInsurancePage amtCoverageOccurenc() throws InterruptedException {
        amtCoverageOccurence.sendKeys(new Faker().number().digits(4));
        TimeUnit.SECONDS.sleep(2);
        return this;
    }

    public AddLiabilityInsurancePage AddLiabilityInsurance() {
        DoClick(AddLiabilityInsurance);
        return this;
    }

    public AddLiabilityInsurancePage SelfInsured() {
        DoClick(selfinsured);
        return this;
    }

    public boolean CheckBoxIsSelected() {
        return selfinsured.isSelected();
    }

    public boolean CheckShared() {
        return CheckElementPresent(Shared);
    }

    public boolean Individual() {
        return CheckElementPresent(Individual);
    }

    public AddLiabilityInsurancePage ChooseShared() {
        DoClick(Shared);
        return this;
    }

    public AddLiabilityInsurancePage Type() throws InterruptedException {
        DoClick(Type);
        TimeUnit.SECONDS.sleep(2);
        return this;
    }

    public boolean unlimitedcoverage() {
        return CheckElementPresent(unlimitedcoverage);
    }

    public boolean tailcoverage() {
        return CheckElementPresent(tailcoverage);
    }

    public AddLiabilityInsurancePage selectunlimitedcoverage() {
        DoClick(unlimitedcoverage);
        return this;
    }

    public AddLiabilityInsurancePage Selecttailcoverage() {
        DoClick(tailcoverage);
        return this;
    }

    public AddLiabilityInsurancePage Save() {
        DoScrollIntoView(Save);
        DoClickActionClass(Save);
        return this;
    }
}
