Feature: As a User I want to Login



  Scenario Outline: Failed Login
    Given Open the web site
    When Enter '<username>' and '<password>' and click login button
    Then Getting error as '<errorText>'
    Examples:
      | username        | password     | errorText                                                                 |
      | standard_userr  | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |



  Scenario Outline: Successful Login
    Given Open the web site
    When Enter '<username>' and '<password>' and click login button
    Then Login successfully


    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | visual_user   | secret_sauce |

