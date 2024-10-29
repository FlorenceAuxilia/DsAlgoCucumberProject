package com.dsalgo.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoRegister_SD {

@Given("The user is on the new user registration page")
public void the_user_is_on_the_new_user_registration_page() {
   
    
}

@When("The user clicks Register button after entering  with valid username, password and password confirmation in related textbox")
public void the_user_clicks_register_button_after_entering_with_valid_username_password_and_password_confirmation_in_related_textbox() {
   
    
}

@Then("The user should be redirected to Home Page of DS Algo and can see  successful message {string} and you are logged in as {string} on the DS Algo Home Page")
public void the_user_should_be_redirected_to_home_page_of_ds_algo_and_can_see_successful_message_and_you_are_logged_in_as_on_the_ds_algo_home_page(String string, String string2) {
   
    
}

@When("The user clicks Register button with all fields empty")
public void the_user_clicks_register_button_with_all_fields_empty() {
   
    
}

@Then("The error {string} appears below Username textbox")
public void the_error_appears_below_username_textbox(String string) {
   
    
}

@When("The user clicks Register button after entering Username with other fields empty")
public void the_user_clicks_register_button_after_entering_username_with_other_fields_empty() {
   
    
}

@Then("The error message {string} appears below Password textbox")
public void the_error_message_appears_below_password_textbox(String string) {
   
    
}

@When("The user clicks Register button after entering Username and password with Password Confirmation field empty")
public void the_user_clicks_register_button_after_entering_username_and_password_with_password_confirmation_field_empty() {
   
    
}

@Then("Then The error message {string} appears below  Password Confirmation textbox")
public void then_the_error_message_appears_below_password_confirmation_textbox(String string) {
   
    
}

@When("The user clicks Register button after entering a username other than letters,digits and spacebar characters @\\/.\\/+\\/-\\/_")
public void the_user_clicks_register_button_after_entering_a_username_other_than_letters_digits_and_spacebar_characters() {
   
    
}

@Then("The user is not able to see error msg after entering invalid data and user redirected to empty password textbox")
public void the_user_is_not_able_to_see_error_msg_after_entering_invalid_data_and_user_redirected_to_empty_password_textbox() {
   
    
}

@When("The user clicks Register button after entering a password with only numeric data")
public void the_user_clicks_register_button_after_entering_a_password_with_only_numeric_data() {
   
    
}

@Then("The user is not able to see error msg after entering invalid data but can see an password warning message {string} with redirected to empty password confirmation textbox {string}")
public void the_user_is_not_able_to_see_error_msg_after_entering_invalid_data_but_can_see_an_password_warning_message_with_redirected_to_empty_password_confirmation_textbox(String string, String string2) {
   
    
}

@When("The user clicks Register buttonafter entering a Password with characters less than {int}")
public void the_user_clicks_register_buttonafter_entering_a_password_with_characters_less_than(Integer int1) {
   
    
}

@Then("The user is not able to see error msg after entering invalid data but can see an password warning message {string} with redirecting to register button enable")
public void the_user_is_not_able_to_see_error_msg_after_entering_invalid_data_but_can_see_an_password_warning_message_with_redirecting_to_register_button_enable(String string) {
   
    
}

@When("The user clicks Register button after entering different passwords in Password and Password Confirmation textbox")
public void the_user_clicks_register_button_after_entering_different_passwords_in_password_and_password_confirmation_textbox() {
   
    
}

@Then("The user should able to see an pwd warning message {string}")
public void the_user_should_able_to_see_an_pwd_warning_message(String string) {
   
    
}


}
