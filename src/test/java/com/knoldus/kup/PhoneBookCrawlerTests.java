package com.knoldus.kup;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookCrawlerTests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound()  {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("phone number not found");
        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Jain");
    }

    @Test
    public void findPhoneNumberByName_CorrectIfFind(){
        String phoneNumberActual = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Muskan");
        assertThat(phoneNumberActual).isEqualTo("9599371409");
    }

    @Test
    public void findPhoneNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
        String phoneBookActual = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("John");
        assertThat(phoneBookActual).isEqualTo("PhoneBook{ PhoneBook = {Muskan=9599371409, Jain=9899259337}}");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_CorrectIfFoundByName() {
        String phoneNumberActual = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Muskan", "9876543210");
        assertThat(phoneNumberActual).isEqualTo("9599371409");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_CorrectIfFoundByPhoneNumber() {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Umang", "965327410");
        assertThat(name).isEqualTo("Jain");
    }
}
