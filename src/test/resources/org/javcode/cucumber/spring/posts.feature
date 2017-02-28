Feature: Test a public JSON Api

    Scenario: Search for all fake posts
        When I query all fake posts
        Then the response status code is 200
        And there are 100 posts

#    Scenario: Search for a specific fake posts
#        When I query fake post "1"
#        Then the response status code is 200
#        And the returned post userId is "1"

