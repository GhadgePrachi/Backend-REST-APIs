create table settings(
setting_id int NOT NULL auto_increment,
user_id int, 
payment_method varchar(50),
show_interest_on_profile varchar(25),
allow_being_searched_by_name varchar(25),

PRIMARY KEY (setting_id)
FOREIGN KEY (user_id) REFERENCES users(user_id)
);

describe users;









