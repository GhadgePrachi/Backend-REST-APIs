create table facilities(
facility_id int NOT NULL auto_increment,
facility_name varchar(50),
category varchar(50),
address varchar(50),
telephone varchar(50),
ratings varchar(50),
timings varchar(50),
summary varchar(50),
image_url varchar(50),

PRIMARY KEY (facility_id)
);

describe facilities;
