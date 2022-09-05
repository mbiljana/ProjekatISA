INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username, blocked)
VALUES (72,'1997-02-05','bg','@2','sdfa','bla','111',234,4,'srb','qwe','123', false);

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username, blocked)
VALUES (73,'1997-02-05','bg','@2','sdfa','bla','11',234,4,'srb','qwe','121', false);

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username, blocked)
VALUES (74,'1997-02-05','bg','@2','sdfa','bla','111',234,1,'srb','qwe','123', false);

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username, blocked)
VALUES (76,'1997-02-05','bg','@2','sdfa','bla','1',234,2,'srb','qwe','1', false);

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username, blocked)
VALUES (77,'1997-02-05','bg','@2','sdfa','bla','11',234,3,'srb','qwe','11', false);

INSERT INTO fishing_instructor(id) values (72);
INSERT INTO fishing_instructor(id) values (73);
INSERT INTO admin(id) VALUES(74);


INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username, blocked)
VALUES (108,'1995-02-05','bg','@nekiregkor','sdfa','Pavle','pb',0564215,5,'srb','Bugarski','pavleb', false);


INSERT INTO reg_korisnik(id) VALUES (108);


insert into appointment( dtype,id, additional_services, date_from, duration, num_people, place, price) VALUES
    ('1',1,'bhd','1999-02-05','1999-02-05 20-25-14',4,'dsd','sdd');

insert into appointment( dtype,id, additional_services, date_from, duration, num_people, place, price) VALUES
    ('1',2,'bhd','1999-02-05','1999-02-05 20-25-14',4,'dsd','sdd');

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price,image_ent1, image_ent2,image_ext1,image_ext2)
VALUES (5,'#petfriendly','Zlatibor, Zlatiborska 112a','Small cottage in the woods.','Cottage1','No smoking',3,3,51.3,78.5,50,'cott.jpg','cott2.jpg','cott3.jpg','cott4.jpg');

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price,image_ent1, image_ent2,image_ext1,image_ext2)
VALUES (6,'#pool #spacenter','Kopaonik, Kopaonička 16b','Luxary cottage in the city center.','Cottage2','Pets not allowed.',3,5,51.3,78.5,40,'cott.jpg','cott2.jpg','cott3.jpg','cott4.jpg');

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price,image_ent1, image_ent2,image_ext1,image_ext2)
VALUES (7,'#freeparking #WIFI','Jahorina, Jahorinska 55','Small cottage by the lake.','Cottage3','Check-in before 12am.',3,2,51.3,78.5,70,'cott.jpg','cott2.jpg','cott3.jpg','cott4.jpg');

INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power,max_speed,cancel_condition,latitude,longitude,price,image_ent1, image_ent2,image_ext1,image_ext2)
VALUES (8,'Fishing rods, water vests','Harbor C5',10,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Blue Moon','Pets are not allowed.','Fishing boat',
        'WKC4B','100 horsepower',100,'no returns',45.5962,20.1345,500,'bi1.jpg', 'bi3.jpg','boat1.jpg','boat2.jpg');
INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power,max_speed,cancel_condition,latitude,longitude,price,image_ent1, image_ent2,image_ext1,image_ext2)
VALUES (9,'Fishing rods, water vests','Harbor C5',10,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Blue Moon','Pets are not allowed.','Fishing boat',
        'WKC4B','100 horsepower',100,'no returns',45.5962,20.1345,500,'bi1.jpg', 'bi3.jpg','boat1.jpg','boat2.jpg');



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

insert into cottage_reservation(id,end_date,res_name,start_date,cottage_id,reg_korisnik_id,duration,num_people,price)
 values(1024,'2022-12-12', 'Cottage reservation for two','2022-12-10',6,108,4,5,1000);
insert into cottage_reservation(id,end_date,res_name,start_date,cottage_id,reg_korisnik_id,duration,num_people,price)
values(1025,'2022-10-10', 'Cottage reservation for two','2022-12-10',6,108,5,4,500);

insert into income(id, income, boat_id)
values ( 4002, 500, 8 );
insert into income(id, income, boat_id)
values ( 4003, 300, 8 );
insert into income(id, income, boat_id)
values ( 4004, 700, 8 );

insert into cottage_income(id, income, cottage_id)
values ( 4005, 700, 5 );
insert into cottage_income(id, income, cottage_id)
values ( 4006, 800, 6 );
insert into cottage_income(id, income, cottage_id)
values ( 4007, 1000, 5 );


insert into fast_reservation(id,additional_services,capacity,duration,place,price,res_name,start_date, boat_id)
values ( 785, 'all',2,5,'Lagoon',500,'Boat action','2022-12-10',8 );

insert into fast_reservation_cott(id,additional_services,capacity,duration,price,res_name,start_date, cottage_id)
values ( 788, 'all',2,5,800,'Cottage action','2022-12-10',6 );


insert into boat_visits(id,end_date,number_of_visits,start_date,boat_id)
values ( 515, '2022-9-10' ,5,'2022-9-1',8);
insert into boat_visits(id,end_date,number_of_visits,start_date,boat_id)
values ( 516, '2022-9-10' ,4,'2022-9-1',8);
insert into boat_visits(id,end_date,number_of_visits,start_date,boat_id)
values ( 5126, '2022-9-3' ,4,'2022-9-1',8);

insert into boat_visits(id,end_date,number_of_visits,start_date,boat_id)
values ( 517, '2022-10-10' ,8,'2022-10-1',8);

insert into cottage_visits(id,end_date,number_of_visits,start_date,cottage_id)
values ( 616, '2022-10-10' ,8,'2022-10-1',6);

insert into cottage_visits(id,end_date,number_of_visits,start_date,cottage_id)
values ( 617, '2022-9-10' ,8,'2022-9-1',6);







