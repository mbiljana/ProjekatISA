INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (72,'1997-02-05','bg','@2','sdfa','bla','111',234,4,'srb','qwe','123');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (73,'1997-02-05','bg','@2','sdfa','bla','11',234,4,'srb','qwe','11');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (74,'1997-02-05','bg','@2','sdfa','bla','111',234,1,'srb','qwe','123');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (76,'1997-02-05','bg','@2','sdfa','bla','1',234,2,'srb','qwe','1');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (77,'1997-02-05','bg','@2','sdfa','bla','11',234,3,'srb','qwe','11');

INSERT INTO fishing_instructor(id) values (72);
INSERT INTO fishing_instructor(id) values (73);
INSERT INTO admin(id) VALUES(74);


INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (108,'1995-02-05','bg','@nekiregkor','sdfa','Pavle','pb',0564215,5,'srb','Bugarski','pavleb');


INSERT INTO reg_korisnik(id) VALUES (108);


insert into appointment( dtype,id, additional_services, date_from, duration, num_people, place, price) VALUES
    ('1',1,'bhd','1999-02-05','1999-02-05 20-25-14',4,'dsd','sdd');

insert into appointment( dtype,id, additional_services, date_from, duration, num_people, place, price) VALUES
    ('1',2,'bhd','1999-02-05','1999-02-05 20-25-14',4,'dsd','sdd');

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price)
VALUES (5,'#petfriendly','Zlatibor, Zlatiborska 112a','Small cottage in the woods.','Cottage1','No smoking',3,3,51.3,78.5,50);

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price)
VALUES (6,'#pool #spacenter','Kopaonik, Kopaonička 16b','Luxary cottage in the city center.','Cottage2','Pets not allowed.',3,5,51.3,78.5,40);

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price)
VALUES (7,'#freeparking #WIFI','Jahorina, Jahorinska 55','Small cottage by the lake.','Cottage3','Check-in before 12am.',3,2,51.3,78.5,70);

INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power,max_speed,cancel_condition,latitude,longitude,price,image)
VALUES (8,'Fishing rods, water vests','Harbor C5',10,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Blue Moon','Pets are not allowed.','Fishing boat',
        'WKC4B','100 horsepower',100,'no returns',45.5962,20.1345,500,'bi1.jpg');

INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power,max_speed,cancel_condition,latitude,longitude,price,image)
VALUES (9,'Water vests','Blue lagoon 15',20,'Made for relaxation',
        'Beauty','No smoking','Sailing boat',
        'WKC4B','100 horsepower',100,'no returns',43.31,43.51,400,'bi3.jpg');

INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power,max_speed,cancel_condition,latitude,longitude,price,image)
VALUES (10,'Fishing rods','Blue lagoon 185',20,'Fishing boat which is great for relaxation if you love fishing and being on ater!',
        'Fishing adventure','No smoking, no pets, no food','Fishing boat',
        'WKC4B','100 horsepower',100,'no returns',43.31,43.51,400,'boat1.jpg');

INSERT INTO boat_owner(id) VALUES (76);

insert into ocena(id,ocena,boat_id,cottage_id)
values (898,5,8,6);
insert into ocena(id,ocena,boat_id,cottage_id)
values (899,3,8,6);
insert into ocena(id,ocena,boat_id,cottage_id)
values (897,4,8,6);
INSERT INTO cottage_owner(id) VALUES  (77);

insert into boat_reservation(id,end_date,res_name,start_date,boat_id,reg_korisnik_id,duration,num_people,price)
values(1023,'2022-12-12', 'Boat reservation for two','2022-12-10',8,108,5,10,100);

insert into cottage_reservation(id,end_date,res_name,start_date,cottage_id,reg_korisnik_id,duration,num_people)
 values(1024,'2022-12-12', 'Cottage reservation for two','2022-12-10',6,108,4,5);
insert into cottage_reservation(id,end_date,res_name,start_date,cottage_id,reg_korisnik_id,duration,num_people)
values(1025,'2022-10-10', 'Cottage reservation for two','2022-12-10',6,108,5,4);






