create table reviews(
review_id int NOT NULL auto_increment,
facility_id int,
user_id int,
timing varchar(50),
content varchar(50),

PRIMARY KEY (review_id),
FOREIGN KEY (facility_id) REFERENCES facilities(facility_id),
FOREIGN KEY (user_id) REFERENCES users(user_id)
);