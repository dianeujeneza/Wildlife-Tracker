# Quotes Application
#### This is an application that will help users especially rangers to detect animals based on their types, 26/09/2019
#### By Diane Ujeneza
## Description
This project is an online application that will help users to enter their names and those of animals they are looking for and save them in database then retrieve them 
by displaying them on the screen.
## Development server

Run `gradle run` for a dev server. Navigate to `http://localhost:4567/`. The app will automatically reload if you change any of the source files.
## Setup/Installation Requirements
Clone the repository to your local machine from the **[online repository]**
https://github.com/dianeujeneza/Wildlife-Tracker.git

If you already have git and java prerequisites installed in your machine continue to the next step,

If you do not have java in your system you can visit the java dev site and get the installation process and you will find some commands you can use on your terminal.

If you are not conversant on the usage of git you can visit https://github.com and clear guidelines on how to use git are outlined.

#### PostgresSQL for Database
       * CREATE DATABASE wildlife_tracker;
       * \c wildlife_tracker;
       * CREATE TABLE animals (id SERIAL PRIMARY KEY, ranger_name VARCHAR, animal_name VARCHAR,health VARCHAR, age VARCHAR, location VARCHAR);
       * CREATE TABLE sightings (id SERIAL PRIMARY KEY, ranger_name VARCHAR, animal_name VARCHAR,health VARCHAR, age VARCHAR, location VARCHAR);
       * CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

## Behavior Driven Development(BDD)

*INPUTS: -ranger's name
         -animal's name
         -animal's type
         -sight's location
         -other animals details

*OUTPUTS:a table of retrieved data from database
## Known Bugs
Some informations can't be retrieved but this issue will be solved as soon as possible
## Technologies Used
JAVA,SPARK Framework,BOOTSTRAP,POSTGRES
## Support and contact details
If countered a problem please don't hesitate to email me on dianesis17@gmail.com.
### License
[UMD]
Copyright (c) {2019} Diane Ujeneza.
