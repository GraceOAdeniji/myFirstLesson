Feature: Valid details login

  Scenario: Successful login
    Given Valid details login Test: user is registered
    And Valid details login Test: user should be on automation website home page
    Then  Valid details login Test: Verify that home page is visible successfully
    Then  Valid details login Test: Click on consent button
    Then  Valid details login Test: Click on Signup / Login button
    Then  Valid details login Test: that Login to your account is visible
    Then  Valid details login Test: Enter correct email address and password
    Then  Valid details login Test: Click login button
    Then  Valid details login Test: Verify that Logged in as username is visible
    Then  Valid details login Test: Click Delete Account button
    Then  Valid details login Test: Verify that ACCOUNT DELETED! is visible

