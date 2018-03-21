import com.step.bank.AccountNumber;
import com.step.bank.InvalidAccountNumberException;
import org.junit.Test;

public class AccountNumberTest {

  @Test(expected = InvalidAccountNumberException.class)
  public void checkAccountNumberValidityWhenOnlyNumbers() throws InvalidAccountNumberException {
    new AccountNumber("12343456");
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void checkAccountNumberValidityWhenExtraNumbers() throws InvalidAccountNumberException {
    new AccountNumber("12345-1234"); //not working test
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void checkAccountNumberValidityWhenNumbersAreLessThanFourDigits() throws InvalidAccountNumberException {
    new AccountNumber("12-12"); //not working test
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void checkAccountNumberValidityWhenLetters() throws InvalidAccountNumberException {
    new AccountNumber("abcd-abcd");
  }
}
