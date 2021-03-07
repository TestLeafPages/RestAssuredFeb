Feature: Incident Management

Scenario: Create a new incident without body

Given Set the EndPoint
And  Set the Authorization
When Send the request as Post
Then Confirm the status code is 201 found
And print the response
