Feature: Marvel Characters Endpoint

  Scenario: Get Characters
    When A GET Request is Made to Get the Characters
    Then The Response contains all of the expected Fields

  Scenario: Get Characters without a Timestamp
    When A GET Request is Made to Get the Characters without a Timestamp
    Then The Response has a Status Code of 409

  Scenario: Get Characters without an API Key
    When A GET Request is Made to Get the Characters without an API Key
    Then The Response has a Status Code of 409

  Scenario: Get Characters without a Hash
    When A GET Request is Made to Get the Characters without a Hash
    Then The Response has a Status Code of 409