Feature: As a User I want to Login
  This feature includes Login tests

#  @login
#  Scenario: Successful Login 2
#    Given Open the web site
#    When Enter user credentials from table
#      | username      | password     |
#      | standard_user | secret_sauce |
#      | visual_user   | secret_sauce |
#    Then Login successfully
#
  @login
  Scenario: Get data from file
    Given Open the web site
    When Get data on file and login and Getting error

  @login
  Scenario: Login with social media account
      When User click google account
      Then Social Media Login page open
      When User input credentials