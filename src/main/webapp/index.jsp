<%@include file="head.jsp"%>

<!--
NOTE: For a deployed web application .WAR to connect to the AWS MySQL server
      the connector .jar must be copied to the Tomcat /lib directory.
      SSH into your ASW instance and install libmysql-java to get the
      mysql-connector-java-5.1.38.jar (or newer version).
      $ sudo apt-get install libmysql-java
      $ cd /usr/share/java
      $ sudo cp mysql-connector-java-5.1.38.jar /opt/tomee/lib
      $ sudo /opt/tomee/bin/shutdown.sh
      $ sudo /opt/tomee/bin/startup.sh
-->

<html>
<body>
<div class="container-fluid" align="center">

    <h2>*** Under Construction ***</h2>
    <p>
        - 2017 March 16 -
    </p>
    <br />
    <form action="admin" method="get">
        <button type="submit" name="submit" value="setup1">Administrator</button>
    </form>
    <br />
    <form action="emp" method="get">
        <button type="submit" name="submit" value="setup2">Employees</button>
    </form>
    <br />
    <form action="home" method="get">
<!--        <button type="submit" name="submit" value="setup1">Administrator</button> -->
<!--        <button type="submit" name="submit" value="setup2">Employee</button> -->
        <button type="submit" name="submit" value="coffees"> Coffees </button>
        <br />
        <br />
        <input type="text" name="findString" value="Kona">
        <input type="submit" name="submit" value="Find">
    </form>

</div>
</body>
</html>
