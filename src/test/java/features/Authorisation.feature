Feature: Verify Authorization apis

  Background: set background data and steps
    Given

  Scenario: Verify Authorisation response for valid user
    Given get Authorisation for user "sally"
    Then Authorisation response status should be 201