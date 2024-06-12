
Feature: Search Hotel Excel format

#  Registered user should be able to search for a certain Hotel
#  Based on location ,type of hotels,room type, and select number of rooms
#  be able to specify the check in Date and check out date
#  specify how many adults per room and children

  Background:
    Given User is on Adactin Hotel login page build two
    And User is successfully logged in with username "SpheleleZ" and password "ODJ38S"
    Then User is on search Hotel page

  Scenario Outline: Search Hotel with valid and with all details
    When user fills Hotel form from given sheetName "<SheetName>" and rowNumber <RowNumber>
    And Chick on search button
    Then Hotel with a name "Hotel Hervey" should display in the list of hotels
    Examples:
      | SheetName       | RowNumber |
      | SearchHotelPage | 0         |