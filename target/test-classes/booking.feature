@Wip
Feature: Hotel Booking form
  As a tester
  I want to test booking and cancellation of an hotel accomidation.
  So that i verify and validate hotel booking.

  Background:
    Given I am on hotels Booking form

  Scenario: Add Booking
    When I enter hotel booking form:
      | firstName | lastName | price | deposit | checkIn | checkOut |
      | sandy     | test     | 10    | true    | today   | 5        |
    Then I should be able to see a new booking added

  Scenario: Delete Booking
    When I delete the created record
    Then I should be able to see created record deleted

