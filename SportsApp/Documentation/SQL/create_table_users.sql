create table users(
user_id int NOT NULL auto_increment,
user_name varchar(50),
email varchar(50),
password varchar(50),
gender varchar(50),
date_of_birth varchar(50),
member_since varchar(50),
twitter_link varchar(50),
facebook_link varchar(50),
bio varchar(500),
image_url varchar(50),
status int(1),

PRIMARY KEY (user_id)
);

describe users;

alter table users add column location varchar(50) after password; 

select * from users;









