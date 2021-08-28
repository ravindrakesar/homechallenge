## Explore Monefy Income adding functionality
## with different category of income such as Deposits, Salary, Savings
## to discover Balance sheet

**Charter**: Exploring the *adding income* feature in the monefy app, to check whether balance sheet gets updated or not
**Areas**: Add income for different catagories one by one and check if the balance updates or not. 
Add new catogory will lead to the paid version of the app
**Start**: 28-08-2021 1300 IST
**Tester**: *Ravindra Kesarabhavi*
# Task Breakdown:
**Duration**: 30 minutes
**Data files**: Screenshots are captured for adding income feature
**Test Notes**: Add income by following below steps
* Click on the green circle with a + symbol inside it to add a income
* Enter the amount in US dollors
* Add a note which is optional
* Choose the category one among Deposits, Salary, Savings
* Verify that the income is added and the balance sheet gets updated
**Opportunity**: Verify both adding income using Cash or payment card, this feature is avaiable while entering the amount. Make sure income is getting added for both the options and balance sheet is getting updated
**Bugs** : Income categories not displayed in the pie chart circle - Deposits, Salary, Savings. Only the expenses are shown in the circle based on catogories
*Steps to reproduce*:
* Add all catogories of income - Deposits, Salary, Savings
* Observe the pie chart
**Expected result** : Income category should be displayed as part of pie chart
**Actual result**: Income catogory is not displayed as part of circle, only expenses are displayed

## Explore Monefy Expense adding functionality
## with different category of expense such as Bills, Car, Clothes, Communications, Eating out, Entertainment,   Food, Gifts, Health,House, Pets, Sports, Taxi, Toiletry, Transport
## to discover Balance sheet

**Charter**: Exploring the adding expense feature in the monefy app, to check whether balance sheet gets updated or not
**Areas**: Add expense for different catagories one by one and check if the balance updates or not. 
Add new catogory will lead to the paid version of the app
**Start**: 28-08-2021 1330 IST
**Tester**: *Ravindra Kesarabhavi*
**Task Breakdown**:
**Duration**: 30 minutes
**Data files**: Screenshots are captured for adding expense feature
**Test Notes**: Add expense by following below steps
* Click on the red circle with a - symbol inside it to add an expense
* Enter the amount in US dollors
* Add a note which is optional
* Choose anyone of the catagories avaiable
* Verify that the expense is added and the balance sheet gets updated
**Opportunity**: Verify both adding income using Cash or payment card, this feature is avaiable while entering the amount. Make sure income is getting added for both the options and balance sheet is getting updated

## Explore Monefy balance sheet circle graph/pie chart
## with different category of expense such as Bills, Car, Clothes, Communications, Eating out, Entertainment, Food, Gifts, Health,House, Pets, Sports, Taxi, Toiletry, Transport
## to discover Balance sheet displaying % of expenses based on catagories

**Charter**: Exploring the balance sheet circle graph/pie chart
**Areas**: Add different category of income and different category of expenses to see the pie chart
**Start**: 28-08-2021 1400 IST
**Tester**: *Ravindra Kesarabhavi*
**Task Breakdown**:
**Duration**: 30 minutes
**Data files**: Screenshots are captured for pie chart after adding each income and expense
**Test Notes**: Add income and expense based on different category and verify the pie chanrt is displaying % of expenses
**Opportunity**: Verify both adding income using Cash or payment card, this feature is avaiable while entering the amount. Make sure income is getting added for both the options and balance sheet is getting updated

## Explore Monefy menu options -- right top 3 dots (...) 
## with different options in the menu such as Categories, Accounts, Currencies, Settings
## to discover each menu option to verify its functionality

**Charter**: Exploring the Monefy menu options -- right top 3 dots
**Areas**:Categories, Accounts, Currencies, Settings
**Start**: 28-08-2021 1430 IST
**Tester**: *Ravindra Kesarabhavi*
**Task Breakdown**:
**Duration**: 20 minutes
**Data files**: Screenshots are captured for each of the menu options testing 
**Test Notes**:
* Verify Categories menu option by adding an income or expense
* Verify that Currencies menu options lead to paid app
* Verify Accounts menu option
* Verify Settings menu option

## Explore Monefy menu options -- left top menu
## with different options in the menu such as the drop down which has 3 options-All accounts, Cash and Payment card and options to chose from Day, Week, Month, Year, All, Interval, Choose date
## to discover each menu option to verify its functionality

**Charter**: Exploring the Monefy menu options -- left top menu
**Areas**: Day, Week, Month, Year, All, Interval, Choose date
**Start**: 28-08-2021 1445 IST
**Tester**: *Ravindra Kesarabhavi*
**Task Breakdown**:
**Duration**: 20 minutes
**Data files**: Screenshots are captured for each of the menu options testing 
**Test Notes**:
* Verify drop down with 3 options - All accounts, Cash and Payment card
* Verify all menu options - Day, Week, Month, Year, All, Interval, Choose date

## Explore Monefy menu options -- top center menu
## with different options in the menu such as Search and Transfer
# to discover each menu option to verify its functionality

**Charter**: Exploring the Monefy menu options -- top center menu
**Areas**: Search and Transfer
**Start**: 28-08-2021 1455 IST
**Tester**: *Ravindra Kesarabhavi*
**Task Breakdown**:
**Duration**: 20 minutes
**Data files**: Screenshots are captured for each of the menu options testing 
**Test Notes**:
* Verify the search option, by entering a text for examples\, Clothes
* If any expense added with the category Clothes, it will be displayed
* Also test the voice search functionality 
* Verify the transfer functionality

## Explore Monefy fresh installation on Android
## with different tool top options displayed for various functionality
# to discover tool tip functionality for each option

**Charter**: Exploring the Monefy fresh installation on Android
**Areas**: Tool tips
**Start**: 28-08-2021 1515 IST
**Tester**: *Ravindra Kesarabhavi*
**Task Breakdown**:
**Duration**: 10 minutes
**Data files**: Screenshots are captured for each of the menu options testing 
**Test Notes**:
* Observe the tool tips being disaplayed for each option
**Bugs**: When a tool tip is displayed and we tap the left top menu button, the tool tip is still displayed overlapping the menu options
*Steps to reproduce*:
* When the app is displaying tool tips
* Tap the left top menu button
**Expected result** : Tool tip should disappear
**Actual result**: Tool tip is displayed which overlap the menu options 

## Findings from your charters. Did everything work as expected? What bugs were discovered?
* Most the functionality such as adding income, adding expenses, graph updation, filtering based on Day/Week/Month works fine
* A bug was observed when tool tip was displayed after the fresh installation of the app, where in, it overlaps the menu options if user taps
* Another possible bug would be the graph circle displays only the expense added and not the income catagories
## Prioritisation of those charters - which area of the app or testing would you explore first and why?
* I would first prefer adding expnse and income functionality because this the main feature which will be used by the end users
## How much time you have planned for each charter?
* maxmium of 30 min for each section is enough for this exploratory testing 
## What kind of risks you need to mitigate for this type of application?
* The app did not have a login functionality 
* If the app is not passwrod protected, anyone who uses the app can see all the data on the app which user added
* It would be a good feature to enable login/logout functionality for this app for security purpose
* Also there is a risk of malaicious user erasing all the app data making the real user loose all his data
* One more functionality which could be added to this app is the Statements
* If user is given an option to export the balance sheet to his email which opens in a PDF reader, this would be a great feature for end user purpose
