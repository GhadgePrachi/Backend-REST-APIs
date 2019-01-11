create table courts(
court_id int NOT NULL auto_increment,
court_name varchar(50),
facility_id int,
category varchar(50),
image_url varchar(50),

PRIMARY KEY (court_id),
FOREIGN KEY (facility_id) REFERENCES facilities(facility_id)
);

Alter table courts add column hourly_price int after court_name;

describe courts;