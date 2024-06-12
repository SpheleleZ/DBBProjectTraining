@SearchHotel
Feature: Search Hotel

#  Registered user should be able to search for a certain Hotel
#  Based on location ,type of hotels,room type, and select number of rooms
#  be able to specify the check in Date and check out date
#  specify how many adults per room and children

  Background:
    Given User is on Adactin Hotel login page build two
    And User is successfully logged in with username "SpheleleZ" and password "ODJ38S"
    Then User is on search Hotel page

  Scenario: Search Hotel with valid and with all details
    When user enters Hotel details
      | location | hotel          | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sydney   | Hotel Sunshine | Double   | 2             | 15/06/2024  | 20/06/2024   | 1             | 2               |

    And Chick on search button
    Then Hotel with a name "Hotel Sunshine" should display in the list of hotels

  Scenario: Search Hotel without entering mandatory location field
    When user enters Hotel details
      | location | hotel          | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      |          | Hotel Sunshine | Double   | 2             | 15/06/2024  | 20/06/2024   | 1             | 2               |

    And Chick on search button
    Then Message saying Please select a location should display

  Scenario: Search Hotel without entering Hotel type field
    When user enters Hotel details
      | location | hotel | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sydney   |       | Double   | 2             | 15/06/2024  | 20/06/2024   | 1             | 2               |

    And Chick on search button
    Then Hotels with all Hotel types names "Hotel Cornice" and "Hotel Creek" and "Hotel Hervey" and "Hotel Sunshine" should display in the list of hotels

  Scenario: Search Hotel without entering Room type field
    When user enters Hotel details
      | location | hotel         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sydney   | Hotel Cornice |          | 2             | 15/06/2024  | 20/06/2024   | 1             | 2               |

    And Chick on search button
    Then Hotels with all room types "Standard" and "Double" and "Deluxe" and "Super Deluxe" should display in the list of hotels

  Scenario: Search Hotel without entering Check-In-Date field
    When user enters Hotel details
      | location | hotel         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sydney   | Hotel Cornice | Double   | 2             |             | 20/06/2024   | 1             | 2               |

    And Chick on search button
    Then Message saying Please Select Check-In-Date should display

  Scenario: Search Hotel with passed Check-In-Date field
    When user enters Hotel details
      | location | hotel         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sydney   | Hotel Cornice | Double   | 2             | 01/01/2020  | 20/06/2024   | 1             | 2               |

    And Chick on search button
    Then Message saying Check-In-Date should be either Today or later Date should display

  Scenario: Search Hotel with format date (dd-mm-yyyy) for Check-In-Date field
    When user enters Hotel details
      | location | hotel         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sydney   | Hotel Cornice | Double   | 2             | 15-01-2020  | 20/06/2024   | 1             | 2               |

    And Chick on search button
    Then Message saying Check-In Date shall be before than Check-Out Date should display

  Scenario: Search Hotel with before Check-Out-Date and after Check-In-Date field
    When user enters Hotel details
      | location | hotel         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sydney   | Hotel Cornice | Double   | 2             | 15-01-2020  | 03/06/2024   | 1             | 2               |

    And Chick on search button
    Then Message saying Check-Out-Date shall be after than Check-In-Date should display

  Scenario: Search Hotel without entering Check-Out-Date
    When user enters Hotel details
      | location | hotel         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sydney   | Hotel Cornice | Double   | 2             | 15-01-2020  |              | 1             | 2               |

    And Chick on search button
    Then Message saying Please Select Check-Out Date should display