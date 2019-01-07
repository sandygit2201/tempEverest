Feature: YOUnivers Shifts API tests

  Background: background

  Scenario: get Shifts Details

    Given get shifts for user "sally" from "2019-01-06T00:00:00" to "2019-01-30T23:59:59"
    Then shifts response status should be 200
    Then print shifts details




