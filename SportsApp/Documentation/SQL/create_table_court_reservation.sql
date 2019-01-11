create table court_reservation(
reservation_id int NOT NULL auto_increment,
court_id int,
user_id int,
timings varchar(50),

PRIMARY KEY (reservation_id),
FOREIGN KEY (court_id) REFERENCES courts(court_id),
FOREIGN KEY (user_id) REFERENCES users(user_id)
);

Alter table court_reservation add column description varchar(50) after reservation_id;
Alter table court_reservation add column price varchar(50);

Alter table court_reservation drop column timings;
Alter table court_reservation add column start_time int after user_id;
Alter table court_reservation add column end_time int after start_time;

describe court_reservation;
