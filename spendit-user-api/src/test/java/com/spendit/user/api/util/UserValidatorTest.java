package com.spendit.user.api.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserValidatorTest {

    @Test
    public void shallReturnTrueIfEmailIsValid() {
        assertThat(UserValidator.isValidEmail("abc@abc.com")).isTrue();
    }

    @Test
    public void shallReturnFalseIfEmailIsInvalid() {
        assertThat(UserValidator.isValidEmail("abcabc.com")).isFalse();
    }

    @Test
    public void shallReturnTrueIfUsernameIsValid() {
        assertThat(UserValidator.isValidUsername("zohaib01")).isTrue();
        assertThat(UserValidator.isValidUsername("1234")).isTrue();
        assertThat(UserValidator.isValidUsername("1234567890")).isTrue();
    }

    @Test
    public void shallReturnFalseIfUsernameIsInvalid() {
        assertThat(UserValidator.isValidUsername("zohaib01_")).isFalse();
        assertThat(UserValidator.isValidUsername("123")).isFalse();
        assertThat(UserValidator.isValidUsername("12345678900")).isFalse();
    }

    @Test
    public void shallReturnTrueIfPasswordIsValid() {
        assertThat(UserValidator.isValidPassword("1234567")).isTrue();
    }

    @Test
    public void shallReturnFalseIfPasswordIsInvalid() {
        assertThat(UserValidator.isValidPassword("123")).isFalse();
    }
}
