Feature: YOUnivers API tests

  Background: background

#    Scenario:  Validate Authentication for valid user
#      Given Get Authorization response for "sally"
#      And response should be 201

  Scenario: get Shifts Details

    Given get shifts for user "sally" from "2019-01-06T00:00:00" to "2019-01-30T23:59:59"




