Feature: Ryanair booking up testing

Scenario: Ryanair booking up - invalid card number

Given user opens ryanair booking page
When user makes a one way booking from krakow to gdansk
And user selects date: 15/12/2017 and passengers: 2 adults and 1 child
And user logs in to myryanair
And user select seats
Then user gets payment declined message using card 5555555555555557 expired on 10/18, ccv: 265
