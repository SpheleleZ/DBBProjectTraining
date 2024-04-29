@searchHotel
Feature: Search Hotel

#  Registered user should be able to search for a certain Hotel
#  Based on location ,type of hotels,room type, and select number of rooms
#  be able to specify the check in Date and check out date
#  specify how many adults per room and children

  Background:
    Given User is on Adactin Hotel login page build two
    And Verify login page build two is open
    And User is successfully logged in with username "SpheleleZ" and password "Nok2lasphe"
    Then User is on search Hotel page

  Scenario: Search Hotel with valid and with all details
    When user enters Hotel details
      | location | hotel          | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sydney   | Hotel Sunshine | Double   | 2             | 30/04/2024  | 07/05/2024   | 1             | 2               |

    And Chick on search button
    Then Hotel with a name "Hotel Sunshine" should display in the list of hotels