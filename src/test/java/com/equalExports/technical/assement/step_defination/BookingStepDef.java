package com.equalExports.technical.assement.step_defination;

import com.equalExports.technical.assement.page_objects.BookingPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class BookingStepDef {
    private BookingPage bookingpage = new BookingPage();
    String url = System.getProperty("url");

    @Given("^I am on hotels Booking form$")
    public void i_am_on_hotels_Booking_form() {

    }

    @When("^I enter hotel booking form:$")
    public void i_enter_hotel_booking_form(List<Map<String, String>> dataTable) {
        bookingpage.fillBookingForm(dataTable);
    }

    @Then("^I should be able to see a new booking added$")
    public void i_should_be_able_to_see_a_new_booking_added() {
        assertThat(bookingpage.isRecordExists().isEmpty(), is(false));
    }

    @When("^I delete the created record$")
    public void iDeleteTheCreatedRecor() {
        bookingpage.deleteRecord();
    }

    @Then("^I should be able to see created record deleted$")
    public void iShouldBeAbleToSeeCreatedRecordDelted() {
        assertThat(bookingpage.isRecordExists().isEmpty(), is(true));
    }
}
