# tech-gadgets

Names: Fahim Ramez, Vardges Gasparyan, Mercedes Tamayo, Gabriel Jose Lopez

Project: E-Commerce website for tech and gadgets

## Organisation:
Frontend: (Gabriel, Vardges) Java FX
Backend: (Fahim, Mercedes) Java

Data storage: text files
Project management : Jira
IDE: VS code
Communication: Slack
Software version control: GitHub


## Installation:
1. Open a folder where you want to clone the repository
- you can create a file such as comp380, and then another one called tech&gadgets

2. Clone the repository
- click on the green **<> Code** button, select **SSH**, and copy the link
- use the command **git clone** and paste the link
- should look like git clone https://github.com/username/project-name.git

3. Contributing
- when working on a task create a new branch and work independently on your task
- create branch: **git checkout -b branchname**, use a branchname that describes what you are doing so it is organised and easy to follow
- then you start working on your code
- once you want to save your progress, you need to add the files with the command **git add** followed by the file name. You can also add all edited files by using **git add .**
- commit your changes with **git commit -m "message"**, you need to add a descriptive message based on what you did. For example if you fixed a bug, be specific and say what bug you fixed, it helps with the organisation of the project and if we need to go back we will find the relevant part much faster.
- pull the latest changes from the main branch with **git pull origin main**
- push your changes with **git push origin branchname**
- later on, once you are done with the branch you can do a pull request to merge your branch with the main branch

## common git commands:
I will list some of the most important commands, there are more but these are the ones we will be using most.
- **git clone** "repository-url" -> clone repo to your computer
- **git status** -> checks the status of your files, modified means you need to add, commit, pull, push
- **git add "filename"** or **git add .**
- **git commit -m "commit message"** to commit the file and give it a description
- **git checkout -b "branch-name"** -> creates a new branch and changes to it, important to create a smooth working environment to be able to work on the code together
- **git checkout "branch-name"** -> changes to an existing branch
- **git branch** -> lists all branches in the repository
- **git merge "branch-name"** -> merges the specified branch into your current branch
- **git push origin "branch-name"** -> Pushes your local commits to the remote repository for the specified branch
- **git log** -> shows commit history for the current banch

## Components of the project
- User Stories
- UCD
- Class Diagram
- Test Cases (unit testing, )
- Use Case Template 
- User Manual
- Data Flow Diagram ?

## Software Life Cycle
1. Requirement Analaysis
2. Specification
3. Preliminary Design
4. Detailed Design
5. Implementation
6. Testing (Validation)
7. Operation
8. Maintenance
9. Retire (Kill it)

Requirements -> Specification -> Design -> Implementation -> Deliver