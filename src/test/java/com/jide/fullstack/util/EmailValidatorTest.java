package com.jide.fullstack.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EmailValidatorTest {

    private final EmailValidator emailValidator = new EmailValidator();

    @Test
    public void itShouldValidateCorrectEmail(){

        assertThat(emailValidator.test("hello@gmail.com")).isTrue();
    }

    @Test
    public void itShouldValidateAnInCorrectEmail(){

        assertThat(emailValidator.test("hellogmail.com")).isFalse();
    }

    @Test
    public void itShouldValidateAnInCorrectEmailWithoutDotAtTheEnd(){
        assertThat(emailValidator.test("hello@gmail")).isFalse();
    }

}