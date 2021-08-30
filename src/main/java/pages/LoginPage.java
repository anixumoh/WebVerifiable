package pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utility.ActionClassUtil.DoClickActionClass;
import static utility.JavaScriptUtil.CheckElementPresent;

public class LoginPage extends TestBase {

    private final String HomePageTittle ="Verifiable";

    @FindBy(xpath = "//input[@placeholder='Email']")
    @CacheLookup
    private WebElement Email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    @CacheLookup
    private WebElement Password;

    @FindBy(xpath = "//button[normalize-space()='Forgot password?']")
    @CacheLookup
    private WebElement ForgotPassword;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    @CacheLookup
    private WebElement SignInButton;

    @FindBy(xpath = "//div[@class='label s-zz55rpQ_CQqs']")
    @CacheLookup
    private WebElement SignInWithGoogle;

    @FindBy(xpath = "//img[@alt='Verifiable logo']")
    @CacheLookup
    private WebElement VerifiableLogo;

    @FindBy(xpath = "//input[@placeholder='Search']")
    @CacheLookup
    private WebElement CheckSuccessfulLogin;

    public LoginPage() {
        PageFactory.initElements(getdriver.get(),this);
    }

    public LoginPage EnterEmail(String MerchantEmail) {
        Email.clear();
        Email.sendKeys(MerchantEmail);
        return this;
    }

    public LoginPage EnterPassword(String MerchantPassword) {
        Password.clear();
        Password.sendKeys(MerchantPassword);
        return this;
    }

    public void ClickSignIn() {
        DoClickActionClass(SignInButton);
    }

    public boolean CheckVerifiableLogo() {
        return CheckElementPresent(VerifiableLogo);
    }

    public boolean CheckSignInWitGoogle() {
        return CheckElementPresent(SignInWithGoogle);
    }

    public boolean CheckSuccessfulLogin() {
        return CheckElementPresent(CheckSuccessfulLogin);
    }

    public boolean CheckForgotPassword() {
        return CheckElementPresent(ForgotPassword);
    }

    public boolean CheckTittle() {
        return getdriver.get().getTitle().contains(HomePageTittle);
    }
}
