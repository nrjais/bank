package com.step.bank;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
    account = new Account(new AccountNumber("1234-1234"), 2000);
  }

  @Test
  public void checkBalance(){
    assertThat(account.getBalance(), is( Money.of(CurrencyUnit.of("INR"),2000.0)));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    new Account(new AccountNumber("1234-1234"),200);
  }

  @Test
  public void withdraw() throws MinimumBalanceException {
    assertThat(account.withdraw(200.0,"Account"), is(Money.of(CurrencyUnit.of("INR"),1800.0)));
    assertThat(account.getBalance(), is(Money.of(CurrencyUnit.of("INR"),1800.0)));
  }

  @Test
  public void credit() {
    assertThat(account.credit(200.0,"Account"), is(Money.of(CurrencyUnit.of("INR"),2200.0)));
    assertThat(account.getBalance(), is(Money.of(CurrencyUnit.of("INR"),2200.0)));
  }

  @Test(expected = MinimumBalanceException.class)
  public void withdrawMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    new Account(new AccountNumber("1234-1234"), 1000).withdraw(200.0, "Account");
  }
}
