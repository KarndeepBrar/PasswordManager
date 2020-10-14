# Password Manager

## Proposal

This password manager aims to **store username, password and website combinations** so that one can create complex passwords
without worrying about having to remember them. Anyone interested in creating complex passwords for their accounts may
use this to ensure they will not forget them. 

This project interests me as I am someone who has a hard time remembering passwords especially when they are at the 
level of complexity I would like them to be. It also helps me prevent being hacked due to data breaches as my accounts
will not have duplicate passwords.


## User Stories

- As a user, I want to be able to add a combination to the combination list
- As a user, I want to be able to edit a combination in the list
- As a user, I want to be able to search for a specific combination by providing a username
- As a user, I want to be able to search for a specific combination by providing a password
- As a user, I want to be able to search for a specific combination by providing a website
- As a user, I want to be able to see all the combinations entered
- As a user, I want to be able to save the list of combinations
- As a user, I want the program to load my previous list automatically

## Instructions for Grader

- You can generate the first required event by going to the Edit menu and pressing add to add a combination or 
pressing remove to remove the currently highlighted one
- You can generate the second required event by double clicking a field of a combination to edit that field
- You can trigger my audio component by loading an existing combination file (save a file and load the same one)
- You can save the state of my application by going to the File menu and pressing save and entering in the file name
- You can reload the state of my application by going to the File menu and pressing load and entering in the file name

## Phase 4: Task 2

- Changed Combination class so it is more robust: constructor now throws an exception if username or password length
is equal to zero. AddCombinationItem class handles these new exceptions.

## Phase 4: Task 3

- Improved cohesion: ReadWrite class has been split up into separate Read and Write classes
- Improved cohesion: Added two new classes, AddCombinationItem and RemoveCombinationItem, that deal with their respective
tasks when clicked on in the edit menu 