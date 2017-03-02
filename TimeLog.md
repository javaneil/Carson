# Time Log

| Date | Task | Hours | Notes|
|------|------|-------|------|
| Sa 21-Jan-2017 |  |  |  |
| Su 22-Jan-2017 |  |  |  |
| Mo 23-Jan-2017 |  |  |  |
| Tu 24-Jan-2017 |  |  |  |
| We 25-Jan-2017 | AWS account setup | 2 |  |
| Th 26-Jan-2017 | Week2 Activty2 add log4j to Exercise1, with stack trace | 4 |  |
| Fr 27-Jan-2017 | AWS account setup, Week2 Exercise ListTest Junit tests | 4 |  |
| Sa 28-Jan-2017 | Week2 Exercise Santa in elevator Junit tests | 6 |  |
| Su 29-Jan-2017 | Finish & submit Week2 Exercise, Begin Week3 DAO reading| 5 |  |
| Mo 30-Jan-2017 | Preliminary storyboard, web page contents, classes & entities | 6 |  |
| Tu 31-Jan-2017 | Reading Database Tools in IntelliJ, begin Week3 Hibernate Exercise | 4 |  |
| We 01-Feb-2017 | Week3 Exercise to Step-6, unable to run | 3 | Look to in-class demo for clues |
|                | Download & debug in-class Hibernate Demo | 3 | MySQL password incorrect |
| Th 02-Feb-2017 | Search, select, install, uninstall, try another, markdown editor (Atom) | 1 | not all do tables! |
|                | Revise Carson Project's Entities & ERD | 1 |  |
|                | Study more in-class & on-line examples of Hibernate | 3 |  |
| Fr 03-Feb-2017 | More MySQL review & dive deeper into IntelliJ Database tool | 3 | Create new DB for week3exercise & implement |
| Sa 04-Feb-2017 | Cleanup week3exercise & push.  Clone Carson to ~/IdeaProject directory | 5 | Having trouble with deploy, not outputting a .war file?  |
| Su 05-Feb-2017 | Began creating Carson table using MySQL Workbench.  Had a lot of problems with Foreign Keys. | 4 | csv import would be useful, but having issues writing key values  |
| Mo 06-Feb-2017 | Created basic entities and tested simple Join in MySQL Workbench | 5 | Must use INDEX/KEY with MySQL Foreign keys |
| Tu 07-Feb-2017 | Reading, Replace example DAOs with actual & add Junit tests | 3 |  |
| We 08-Feb-2017 | Add entity with Join.  FINALLY got two tables to compile and associate.  Junit tests a real pain if the DB gets corrupted!  | 7 | Refactored Sessions entity to Records (Hibernate has a Session class & it was confusing) |
| Th 09-Feb-2017 | Peer Reviews for Joe & Keith | 1 |  |
|                | Install Ubuntu on Dell B130 | 2 | Format drive, install, apt-get OpenJDK8 |
|                | Install Raspian(Linux) on Raspberry Pi B+ | 1 | Download & flash SD-Card image |
| Fr 10-Feb-2017 | Watch AWS videos, review initial setup, PuTTY, TomEE & MySQL | 2 | Was prompted to restart AWS server... |
|                | Debug MySQL password change on local Ubuntu | 2 |  MySQL V5.7.x must use authentication_string=PASSWORD |
| Sa 11-Feb-2017 | Change AWS MySQL password, AWS setup part-3 | 2 | Recorded Windows screens |
| Su 12-Feb-2017 | AWS setup part-4, test MySQL Workbench on AWS DB.  Resolve issues with TomEE Manager App setup. | 2 | Needed to assign TomEE rolename="manager-gui" |
| Mo 13-Feb-2017 | Test deploy of week-1-exercise to AWS, week-5 security reading | 2 |  |
|                |  | 3 | Ride bike to Bellville |
| Tu 14-Feb-2017 | Prepare Carson project for deploy, unable to connect to AWS.  Had to edit AWS Security Group Inbound Source IP.  | 2 | Restarting home DSL re-assigned gateway IP address. |
|                | Sandi EC feedback.  Successfully deploy CarsonWebApp to AWS. | 2 | Not sure how to configure logging on AWS |
| We 15-Feb-2017 | Successfully deployed Carson project to AWS.  Began adding some JSPs and actions | 4 | Forgot everything I ever knew about JSP... |
| Th 16-Feb-2017 | Finally got a button on the home page to display the contents of the Coffee table | 3 | Had to re-learn how to add JSTL to Maven |
| Fr 17-Feb-2017 | Spent all day getting week5 demo to work.  Looks like the main problem was the MySQL GRANT wasn't taking effect.  Secondary problem was the demo was created using a DB with slightly different table values... | 6 | Always follow changes to MySQL with FLUSH PRIVILEGES? |
|                | Also implemented changes to week-5-exercise, but apparently had the same DB connection problem as the demo | 3 | |
| Sa 18-Feb-2017 | Added second constraint to week-5-exercise.  Throws 403 if logged-in as registeredUser and try to go to admin page. | 2 | Need to handle invalid page?  |
|                |  | 4 | Ride bike to Black Earth |
| Su 19-Feb-2017 | Review some of week-5 lectures, preview some of week-6 and install SoapUI | 2 | (prepare taxes, but that's off topic...) |
| Mo 20-Feb-2017 | Week-6 reading & videos.  Activities 1 & 2. | 4 |  |
| Tu 21-Feb-2017 | Week-6 reading & videos. Activity 3. | 3 |  |
| We 22-Feb-2017 | Create single MySQL script to Create DB & tables, also fill tables with simulated data from .csv files | 4 | I had been simply using MySQL Workbench's import wizard to fill tables with sample data.  The script now uses MySQL statements. |
|                | Adding authentication to Carson project & database | 2 | |
| Th 23-Feb-2017 | Got authentication working with Servlets on Carson.  Pushed Week-6 Activities 2 & 3 to new repos on my github. | 3 | Ran into issue git, could not pull from repos until current branch was manually set to master?  |
| Fr 24-Feb-2017 | Edit & push Leja feedback.  Installed Oracle Java8 on Dell PC.  Installed TomEE (from .tar.gs?).  Got it to where I can remote into the TomEE Manager App and deployed Example1 successfully. | 6 | Haven't been able to remote-in with MySQL Workbench yet... Going to need SSH keys? |
| Sa 25-Feb-2017 | Relocated Tomcat Realm .xml to IntelliJ as discussed on Slack.  Tested successfully on local with two projects (week5 & Carson) using different databases. | 2 | |
|                | Used MySQL terminal on Dell Ubuntu to create authentication DB & default tables.  Installed & copied mysql-connector-java-5.1.38.jar.  Able to deploy & execute week5 Example. | 3 | Didn't need to generate SSH keys to use MySQL Workbench remote on Dell, but must login each time... |
|                | Replicated above steps on ASW instance & successfully test week5 exercise.  Deploy & successfully (functional) test Carson project on AWS | 2 | Ended up using MySQL Workbench Import to initialize Carson DB table data on AWS. |
| Su 26-Feb-2017 | WiFi was not working on my Dell Ubuntu machine, so spent the morning installing additional drivers and somehow it began working | 2 |  |
|                | Spent the rest of the day installing the latest Raspbian(linux), Oracle Java-8 JDK and TomEE on a Raspberry Pi B+.  TomEE is accessible from a browser, but the Manager App throws a 403 without even prompting for login... | 6 | Need to review class setup steps, think I may have missed something |
| Mo 27-Feb-2017 | Week7 reading & video.  Hung-up on Activity-1, SoapUI Outline tab not visible. | 2 | Need to use SoapUI Pro? |
|                | Created Activity-2 IntelliJ project, test throws error (as expected), but error does contain retrieved JSON | 1 |  |
| Tu 28-Feb-2017 | Read/view week-7 materials.  Carson Project does not consistantly display Coffee page.  Had Hibernate using MySQL root loging, and TomEE was using tomee.  Have no idea if that had anything to do with anything, but fixed it anyhow.  Not able to reporduce... | 3 | Ran into some log4j issues, wasn't using catalina.home path.  Also discovered an actual logging event must occur before the output log file gets created! |
| We 01-Mar-2017 | Lucas & Brandon feedback.  Activity-3 & Activity-4 (as far as HelloWorld and single parameter). | 3 | Need to do xml & JSON. |
|                | Raspberry Pi TomEE was missing edit to context.xml blocking Manager App.  Installed MySQL, though Raspbian defaults to version 5.5.   Can deploy Carson project and display simple table, but Foreign Keys arn't working. | 3 | Had to install & copy mysql-connector-java to get authenticaton to work.  May try manually installing MySQL 5.7 to see if resolves Key issue. |
| Th 02-Mar-2017 |  |  |  |
| Fr 03-Mar-2017 |  |  |  |
| Sa 04-Mar-2017 |  |  |  |
| Su 05-Mar-2017 |  |  |  |
| Mo 06-Mar-2017 |  |  |  |
| Tu 07-Mar-2017 |  |  |  |
