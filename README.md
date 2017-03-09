# Neil Fortney Individual Project
Repository for the Spring 2017 Enterprise Java class.

# Problem Statement
Often times it seems when I purchase or refill a brewed coffed at Starbucks,
 Panara, MATC, the urn I would like is empty.  It's left up to the staff to
 periodically check the urns and refil as needed.  This reactive approach
 to urn management leads to frustrated customers and waste when unused coffed
 is dumped at the end of the day

# Proposed Solution
Carson the Coffee Butler is a system concept to address two facets of coffee
 urn management:

**1 - Realtime monitoring of urn status**

Urn status is continuously monitored and status displayed on a mobile device
 such as an iPhone or Android tablet with coffee selectable alarm thresholds.

**2 - Site data collection of usage and ambient conditions**

Current rate of consumption used to anticipate depletion of an urn's contents.
Long-term data analysis to predict usage based on season, day of week, ambient
weather conditions, etc.

# Project Technologies/Techniques
* IntelliJ Development Environment
  * Maven
  * log4j
  * Hibernate DAO
  * Jersey
  * Jackson
* MySQL Database management
  * Product information
  * Equipment inventory & location
  * Usage data
* Web Server
  * AWS public
  * PC or Raspberry-Pi private server (as time permits)
* Security
  * Administrator level - system configuration and product editing
  * Employee level - product usage Records
  * Un-secure - current product availability status
* Web Services using REST
  * Provide retrieval of product usage Records
  * Provide create & update product information
  * Consume environmental conditions
  * Consume Local time synchronization
* Data collection
  * Bluetooth Low-energy (BLE) remote sensing
  * Java BLE API - TBD
# Design
* Website pages & application flow
* Database Entities and relationships
