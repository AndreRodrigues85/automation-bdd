Meta:
@author Daniel Junior
@strategy regression

Narrative:
As a user
I want to deal with the login functionality of the application
So that I can see that all aspects of login are working as expected

Scenario: To test login functionality with invalid credentials
Given I am on the website home page
When I navigate to the login page
And I login as p:email.address with password p:invalid.password
Then I should see the validation message: p:authentication.message

Scenario: To test login functionality with password field required
When I navigate to the login page
And I try to login with email p:email.address and without password
Then I should see the validation message: p:password.required.message

Scenario: To test login functionality with email field required
When I navigate to the login page
And I try to login with password p:correct.password and without email
Then I should see the validation message: p:email.required.message

Scenario: To test login functionality with invalid email address format
When I navigate to the login page
And I login as <email> with password p:correct.password
Then I should see the validation message: p:invalid.email.message
Examples:
| email |
| a@    |
| a.a   |
| a@a   |
| a@a.  |
| @a.a  |
| a&a.a |

Scenario: To test login functionality with success
When I navigate to the login page
And I login as p:email.address with password p:correct.password
Then I check to see the title p:dashboard.title at the dashboard page

Scenario: To test logout functionality
When I log out from the application
Then I check to see the title p:login.title at the signin page