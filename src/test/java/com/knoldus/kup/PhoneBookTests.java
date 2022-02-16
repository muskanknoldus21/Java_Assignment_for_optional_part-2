package com.knoldus.kup;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
public class PhoneBookTests {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBook phoneBookTest = new PhoneBook();

    @Test
    public void findPhoneNumberByName_CorrectIfFound() {
        Optional<String> phoneNumber = phoneBookTest.findPhoneNumberByName("Muskan");
        assertThat(phoneNumber.get()).isEqualTo("9599371409");
    }

    @Test
    public void findPhoneNumberByName_CorrectIfNotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBookTest.findPhoneNumberByName("Utkarsh");
        phoneNumber.get();
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfFound(){
        Optional<String> name = phoneBookTest.findNameByPhoneNumber("9654321470");
        assertThat(name.get()).isEqualTo("Jain");
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfNotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBookTest.findNameByPhoneNumber("123456799");
        phoneNumber.get();
    }
}