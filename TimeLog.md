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
| Th 02-Mar-2017 | Started on Activity-3, can pass parameter, but not sure how to generate JSON | 3 |  |
| Fr 03-Mar-2017 | Activity-3, faked HTML and have jackson converting POJO object list to string.  Can see it on browser, but SoapUI doesn't recongize it as JSON | 4 | Created repositories and pushed Activities 2, 3 & 4 |
| Sa 04-Mar-2017 | Raspberry Pi day...  It appears Raspbian(Debian) only supports MySQL 5.5 at this time.  I've been all over the internet and found numerous installations of 5.7 on Debian, but only for x86 platforms.  The install error I'm getting is looking for an ARM specific file that Oracle/MySQL is missing | 6 | I need to find a better hobby/passtime |
| Su 05-Mar-2017 | Tried installing MysQL 5.6 over 5.5 on Raspbian, same missing file issue.  After a failed MySQL install, don't know the state of things, so I usually flash a new Raspbian image and start over... | 1 | Getting really good at manually installing the LAMJ (J for java) environment |
| Mo 06-Mar-2017 | Finally (this time for sure?) I got Week7 Actvity-3 to work with SoapUI.  Had to add @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML}) above the Hello class to get the right Content-Type. | 6 |  |
| Tu 07-Mar-2017 | Went down Raspberry Pi rabbit-hole exploring backing-up/cloning of installed Raspbian image.  Also researching accessing GPIO from Java. | 3 | Mixing and resizing of SD-Cards has been an issue with RasPi for some time now requiring lots of potentially dangerous command-line "dd" operations |
| We 08-Mar-2017 | Week7 Exercise, DAO and basic junit test.  Basic web service, able to retrieve MySQL data, but need to convert raw data to JSON. | 5 | Unscheduled overnight visitor in form of 3-year-old Grandson - much distraction... |
| Th 09-Mar-2017 | Think I have the @GET responding with JSON correctly, began adding @PUT annotations to Week7 exercise.  | 2 | Still have Grandson around - how did I ever get anything done when I had my own children around 24/7 ??? |
| Fr 10-Mar-2017 | Got @PUT annotations sort-of working, still a little fuzzy on the data formatting.  Started adding @POSTs, see if that makes more sense.  Enable USB WiFi on RasPi with GUI. | 4 | Having some trouble with an SD-Card not being recoginized by Ubuntu, had to use GUI on RasPi to resize |
|                | Cloned group project from rep Shea created, the repository is missing a .gitignore, so it's kind of big.  I added .gitignore to my loco repo and removed /target/ from my cache as per the class video.  The .gitignore is in a different file locatation than the example and I'm not sure how it handles the filepaths. | 1 | I'm reluctant to push my revised repo because I don't want to clobber the group repo... |
| Sa 11-Mar-2017 | Presentations feedback. | 1 |  |
|                | Got @POSTs working with on Week7 exercise, including an attached JSON message |  | Need to review MySQL permissions, who has Write access? |
| Su 12-Mar-2017 |  |  |  |
| Mo 13-Mar-2017 | Added Junit DAO tests which initially failed because Hibernate only had MySQL SELECT permission.  Added Jersey & Jackson to Carson project and got simple @GETs retrieving DB data using DAOs.  | 6 | Had a lot of trouble getting the JSON parsing to work... Root Object Name was not being included on service end & I initially wasn't configuring RoboPojoGen corectly  |
| Tu 14-Mar-2017 | Spent all day getting @POST web services working on Carson project.  Using Junit test as Client to post new coffees to the Coffee entity.  DAO commits to MySQL do not appear to take effect immediately.  Even after inserting a supposed 5-second delay, Junit DAO accesses of the DB do not reflect the changes.  Need to run Client in its own instance? | 9 | Jersey developers, in their infinite-wisdom, decided to rename Response.getEntity() to Response.readEntity() in version 2.x.  Unfortunately, even fairly recent examples posted use v1.x getEntity - spent a couple hours on this alone... |
| We 15-Mar-2017 | Cloning review projects to local for analysis.  Begin Design reviews. | 2 | Maybe its just this POS Atom editor, but I'm finding editing .md files more frustrating then the line-editors of 30+ years ago... |
|                | Added a JSON response.entity to the Web Service @POST to return the Primary Key IDs of the rows added. | 6 | Still have was appears to be a thread issue between TomEE and Junit |
| Th 16-Mar-2017 | "Thread" issue appears to have been Hibernate caching issue between the TomEE and Junit instances.  Basically, must only use one instance for any givin test.  Tried using @DELETE, but cannot send a JSON Entity, so not really much use.   | 4 | Had to rewrite most of the junit tests.  Created several helper-methods that ended up reducing the size of many of the test methods |
|                | Tried using @DELETE, but it cannot contain a JSON Entity, so not really much use.  Using @POST for Web Service Create & Delete | 3 | Per Paula's suggestion, created junit tests for the helper methods called by the Web Server code, but don't need a separate TomEE instance to use |
| Fr 17-Mar-2017 | Deployed project to remote server, but was unable to access Web Service using SoapUI. Web page accessible from browser.  Local & remote endpoints have different pathnames beyond just the URL/IP-address... | 2 | The .war deploy's path gets named in the .pom, the localhost in the Run/Debug configuration |
|                | Unable to install updates when running Ubuntu on USB drive preventing installation of wifi driver | 3 | Able to install Ubuntu along side windows & dual-boot |
| Sa 18-Mar-2017 | Plugged-in USB BLE on Ubuntu PC, update BlueZ, added cmake & TinyB.  An example command-line java program discovered a Finder profile BLE device.  Was able to import TinyB library into IntelliJ | 4 | Lots of source code (much in plain C) and zero documentation |
| Su 19-Mar-2017 |  | 4 | Rode bike to New Glarus... |
| Mo 20-Mar-2017 | Could build TinyB java example in IntelliJ, but initially couldn't find a javatinyb library at run-time.  Needed to add libjavatinyb.os to the external references.  The code now appears to be connecting to my Cypress PSoC "Finder" | 4 | Somewhat confuse about the libjavatinyb.os library, and pretty much the whole Linux Cmake process...  Need to dig deeper |
| Tu 21-Mar-2017 | Week9 Tag Lib video and Activity 1.  IntelliJ seemed to have problems with the .jar dependency | 3 | Having some issues synchronizing the consumer with the tag lib.  |
| We 22-Mar-2017 | Added a feature to the Tag Lib to calculate days remaining in the semester.  Deleted the Tag Lib .jar thinking Maven would auto-refresh it... big mistake.  Had to Delete the dependency in the .pom, restart IntelliJ, then add the dependency to get it to reimport it. | 3 | Even Reimport All Maven Projects, does't automatically refresh dependencies. |
|                | Revisiting Cypress BLE tools (it's been over a year).  Able to modify a Find Me profile to control an RGB LED | 3 | Using Cypress USB fob & CySmart Windows tool to scan & communicate with BLE device.
| Th 23-Mar-2017 | Was able to communicate with BLE device from Dell computer and IntelliJ.  Attempting to replicate on HP-Mini | 3 | Installing BlueZ 5.4.3 on HP-Mini, which should leave bluetools in place |
| Fr 24-Mar-2017 | HP-Mini "Discovers" BLE device, but cannot write to it. | 4 |  |
| Sa 25-Mar-2017 | Tried numerous changes and re-installs, eventually hung-up the bluetoothd deamon... | 4 | Much of the on-line help use different tools across many different version of BlueZ - much conflicting suggestions... |
| Su 26-Mar-2017 | Re-installed Ubuntu on HP-Mini, kept default BlueZ 5.3.7.  The bluetoothd daemon logs errors starting-up (not seen on Dell), not sure what they all mean...  Research Linux Deamons and D-Bus. | 6 | Real blocker!  These are both x86 processors & the same USB-bluetooth adapter |
| Mo 27-Mar-2017 | Week-10 videos, begin conversion of barber shop to trick-or-treat house | 5 | Need to think of Junit tests... |
| Tu 28-Mar-2017 | Finish port to trick-or-treat | 1 |  |
| We 29-Mar-2017 | Test, debug & commit Week-10 exercise. | 4 |  |
| Th 30-Mar-2017 | Back to Ubuntu & BlueZ-5.44, if I don't try to fix System Settings, the BlueZ deamon seems OK.  I am able to get BLE working on the HP-Mini..  | 4 | Can scan for devices, connect & obtain characteristics. |
| Fr 31-Mar-2017 | At one point I was able to restore System settings by re-installing unity-control-center after I had a stable bluetoothd (daemon), but after a restart, bluetoothd was logging errors again. | 5 |  |
| Sa 01-Apr-2017 | Spent a great deal of time trying to figure-out how to fix System Settings without breaking BlueZ, but to no avail. | 4 | Tried to compare the working Dell with HP-Mini, but there's so many files... |
|                |  | 3 | Ride to Cross Plains - Springfield Corners... |
| Su 02-Apr-2017 | Install Tomcat on HP-Mini, still launching from command-line, though found severa examples of creating a Tomcat daemon at start-up.  Able to deploy a .war created with IntelliJ Community to Tomcat on HP-Mini | 3 |  |
| Mo 03-Apr-2017 | Creating new web app using a servlet in IntelliJ Community and verifying they deploy properly to Tomcat.  Made yet-another attempt to restore Ubuntu System Settings on the HP-Mini with some success - bluetoothd logs 1 warning/error, but otherwise seems to work! | 4 | Can't debug within IntelliJ Community, but as long as I can deploy, I should be able to debug using logging. |
| Tu 04-Apr-2017 | Compare creating an empty Maven vs Archetype WebApp on IntelliJ, not hugely different, WebApp wizard includes web specific folders & default index.jsp.  Successfuly demonstrate BLE connectivity on MATC campus. | 3 | Change in environment didn't appear to break anything so far. |
| We 05-Apr-2017 | Verifed new install of IntelliJ Community on a Windows computer also launches Tomcat when the Maven-Tomcat plugin is used | 5 | Minor remodling of basement workspace to provide space for additional computers... |
| Th 06-Apr-2017 | Employ a second GitHub account I had created for my non-school work to contain Linux/BLE development repositories. | 1 | TODO: can BLE be accessed from servlet? |
| Fr 07-Apr-2017 | Thought I had successfully integrated the BLE libraries into a Mavenized Tomcat IntelliJ project, but it broke again.  Attempted to upgrade IntelliJ to 17.1, now can't get it to build without error at all...  Time to uninstall IntelliJ & start over. | 4 | Seemed to work better if I import (Shft-Ctrl-Alt-S) the TinyB libs in Platform-Settings, not Project-Settings |
| Sa 08-Apr-2017 | Took several attempts to do a clean re-install of IntelliJ 17.1, this time in /opt/ instead of /home/neil/...   | 2 | Left for overnight bikeride to New Glarus Woods |
| Su 09-Apr-2017 | Started a new .jar library project.  Not sure where default IdeaProjects is... | 2 | Return from overnight ride. |
| Mo 10-Apr-2017 | Since I was starting over anyhow, I revisited adding log4j to IntelliJ + Maven. | 3 | This was somewhat a new thing in Ubuntu. |
| Tu 11-Apr-2017 |  |  |  |
| We 12-Apr-2017 | Made several attempts to create a .jar containing the libjavatinyb.so library, but no success. | 4 |  |
| Th 13-Apr-2017 |  |  |  |
| Fr 14-Apr-2017 | Looked into environment variables, observed the TinyB examples loaded LD_LIBRARY_PATH, but it was not persisted.  Adding it to /etc/environment persists it. | 6 | With the path set, it is unecessary to include libjavatinyb in the IntelliJ project. |
| Sa 15-Apr-2017 |  |  |  |
| Su 16-Apr-2017 | Getting back into BLE and the Discovery process.  How & where are discovered devices persisted??? | 2 |  |
| Mo 17-Apr-2017 |  | 6 | Bikeride Prairie du Sac, Mazomanie |
| Tu 18-Apr-2017 | Watch Week-13 video... | 1 |  |
| We 19-Apr-2017 | Integrating BLE TinyB into .jsp, could not get EL to work, included "@taglib", but that wasn't enough - had to change web.xml for "web-app version 2.5"?  Got crude BLE discover Device/Services/Characteristics working and a simple web app to change the Alert state. | 6 | Still need to retrieve data from BLE Device... |
| Th 20-Apr-2017 | Cloned week-13 exercise.  Made changes to send answer message back to TestMessageBean. | 4 | I have kind of a fuzzy understanding of message-driven-beans... |
| Fr 21-Apr-2017 | Do any standard BLE profiles work for this project?  Probably need to develop a custom profile. | 2 | Childcare day... |
| Sa 22-Apr-2017 | Liquid Crystal Display research.  What can I use for a cheap/quick demo.  Segment vs character vs dot-matrix, power consumption issues.  LCDs designed for (dumb) cellphones look very promising, low cost & power, are they still being made??? | 3 | Yardwork day... |
| Su 23-Apr-2017 |  | 6 | Bikeride to Barneveld |
| Mo 24-Apr-2017 | Interface 4-row by 20-character off-the-shelf LCD to Cypress BLE PSoc.  Review custom BLE profile development, UUID generation. | 4 | Need to define urn properties that need to be supported by the BLE profile |
| Tu 25-Apr-2017 | Got a custom BLE profile writing characters to the LCD | 4 | Who knew how complicated this could be... |
| We 26-Apr-2017 | Reviewed my long neglected individual project... I had forgotten much about it.  Cleaned-up some code and re-ran junit tests. | 6 | AWS instructed me to restart my instance, so I did, and it once again issued a new IP address ;^{  Had to update PuTTY, restart TomEE & the Student github link... |
| Th 27-Apr-2017 |  |  |  |
| Fr 28-Apr-2017 |  |  |  |
| Sa 29-Apr-2017 |  |  |  |
| Su 30-Apr-2017 |  |  |  |
