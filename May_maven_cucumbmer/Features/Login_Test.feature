@FunctionalTesting
Feature: Login Action on HMS Portal

@sanity
Scenario Outline: Successful Login with Valid Credentials
	Given User is on HMS Portal Login Page
	When User enters "<username>" and "<password>"
	And User selects "<ChooseAcc>" as choose account
	And User click on "Login button"
	Then Message displayed Login Successfully
Examples:
| username           | password | ChooseAcc |
| admin@gmail.com    | admin123 | Admin     |
| pharmacy@gmail.com | pharmacy123 | Pharmacy |
| pathology@gmail.com | pathology123 | Pathology |
| receptionist@gmail.com | receptionist123 | Receptionist |
| nursing@gmail.com | nursing123 | Nursing |

Scenario Outline: Successful Login with Invalid Credentials
	Given User is on HMS Portal Login Page
	When User enters "<Iusername>" and "<Ipassword>"
	And User selects "<IChooseAcc>" as choose account
	And User click on "Login button"
	Then Message displayed Login unsuccessfully
Examples:
| Iusername           | Ipassword | IChooseAcc |
| admin1@gmail.com    | admin@123 | Admin     |

@regression
Scenario: Successful LogOut
	When User click on User Profile
	And User click on LogOut button from the Application
	Then Message displayed LogOut Successfully