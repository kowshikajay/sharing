#Author: your.email@your.domain.com

@Demo

Feature: DemoPage

Background: user is in home page

Scenario: check title
When user is in the demo page
Then get home page  title

Scenario: check name 
When user enter invalid name and click submit
Then display error message

Scenario: check mobile number 
When user enter invalid mobile number and  click submit
|3525242|
|4534534565|
|987456321|
|sfsa|
|9874563210|
Then display phone error message

Scenario: check email
When user enter invalid email and click submit
|msh@ga|
|mshg|
|2365894|
|523567566267|
Then display email error message

Scenario: check address
When user click submit with out entering address
Then display address error message
