
INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price,cancel_condition)
VALUES (5,'#petfriendly','Zlatibor, Zlatiborska 112a','Small cottage in the woods.','Cottage1','No smoking',3,3,43.7262501,19.6938721,50,'all price payback');


INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude)
VALUES (5,'#petfriendly','Zlatibor, Zlatiborska 112a','Small cottage in the woods.','Cottage1','No smoking',3,3,43.7262501,19.6938721);


INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price,cancel_condition)
VALUES (6,'#pool #spacenter','Kopaonik, Kopaonička 16b','Luxary cottage in the city center.','Cottage2','Pets not allowed.',3,5,43.7262501,19.6938721,100,'no payback');

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price,cancel_condition)
VALUES (7,'#freeparking #WIFI','Jahorina, Jahorinska 55','Small cottage by the lake.','Cottage3','Check-in before 12am.',3,2,43.7262501,19.6938721,75, 'no payback');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (72,'1997-02-05','bg','@2','sdfa','bla','111',234,4,'srb','qwe','123');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (73,'1997-02-05','bg','@2','sdfa','bla','13',234,4,'srb','qwe','10');

INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power,max_speed,latitude,longitude,price,cancel_condition)
VALUES (8,'Fishing rods, water vests','Harbor C5',10,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Blue Moon','Pets are not allowed.','Fishing boat',
        'WKC4B','100 horsepower',100,43.7262501,19.6938721, 100,'payback 3 days before');


INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (74,'1997-02-05','bg','@2','sdfa','bla','111',234,1,'srb','qwe','123');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (76,'1997-02-05','bg','@2','sdfa','bla','1',234,4,'srb','qwe','1');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (77,'1997-02-05','bg','@2','sdfa','bla','11',234,3,'srb','qwe','11');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (78,'1997-02-05','bg','@2','sdfa','bla','71',234,0,'srb','qwe','41');

INSERT INTO fishing_instructor(id) values (72);
INSERT INTO fishing_instructor(id) values (73);
INSERT INTO admin(id) VALUES(74);

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (108,'1995-02-05','bg','@nekiregkor','sdfa','Pavle','pb',0564215,5,'srb','Bugarski','pavleb');


INSERT INTO reg_korisnik(id) VALUES (108);

INSERT INTO adventure(id,adventure_additional_services,adventure_address,adventure_capacity,adventure_name,adventure_rules,aventure_equipment,instructor_biography,promo_description,fishing_instructor_id)
VALUES (1,'#lunchIncluded #transportIncluded','Kopaonička 10',7,'Fishing on Vrela river','Pets are not allowed.','Fishing rods','Instructor is a professional fisherman with a longterm experience.','This is a once in a lifetime opportunity to learn fishing from the best.',72);

INSERT INTO adventure(id,adventure_additional_services,adventure_address,adventure_capacity,adventure_name,adventure_rules,aventure_equipment,instructor_biography,promo_description,fishing_instructor_id)
VALUES (2,'#lunchBreakIncluded #transportIncluded','Tarinska 25b',20,'Tara rafting','Bring swimsuits.','Boats, inflatable vests','Instructor is a professional fisherman with a longterm experience.','This is a once in a lifetime opportunity to experience rafting while fishing.',73);

insert into adventure(id, adventure_additional_services, adventure_address, adventure_capacity, adventure_name, adventure_rules, aventure_equipment, instructor_biography, promo_description,fishing_instructor_id)
values(3,'#lunchBreakIncluded #transportIncluded','Vršačka 12b',20,'Tara rafting','Bring swimsuits.','Boats, inflatable vests','Instructor is a professional fisherman with a longterm experience.','This is a once in a lifetime opportunity to experience rafting while fishing.',72);

insert into appointment( dtype,id, additional_services, date_from, duration, num_people, place, price) VALUES
    ('1',1,'bhd','1999-02-05','1999-02-05 20-25-14',4,'dsd','sdd');

insert into appointment( dtype,id, additional_services, date_from, duration, num_people, place, price) VALUES
    ('1',2,'bhd','1999-02-05','1999-02-05 20-25-14',4,'dsd','sdd');

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms)
VALUES (9,'#petfriendly','Zlatibor, Zlatiborska 112a','Small cottage in the woods.','Cottage1','No smoking',3,3);

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms)
VALUES (12,'#pool #spacenter','Kopaonik, Kopaonička 16b','Luxary cottage in the city center.','Cottage2','Pets not allowed.',3,5);

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms)
VALUES (10,'#freeparking #WIFI','Jahorina, Jahorinska 55','Small cottage by the lake.','Cottage3','Check-in before 12am.',3,2);

INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power,max_speed)
VALUES (8,'Fishing rods, water vests','Harbor C5',10,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Blue Moon','Pets are not allowed.','Fishing boat',
        'WKC4B','100 horsepower',100);

INSERT INTO boat_owner(id) VALUES (76);


INSERT INTO cottage_owner(id) VALUES  (77);

insert into zahtev_za_reg(id, birth_date, city, email_address, home_address, name, password, phone_number, razlog, reg_type, state, surname, username) VALUES
(1,'2022-02-02','hg','hg','hg','hg','hg',15,'hg','BOATOWNER','hg','hg','hg');

insert into ocena(id,ocena,boat_id,cottage_id)
values (898,5,8,6);
insert into ocena(id,ocena,boat_id,cottage_id)
values (899,3,8,6);
insert into ocena(id,ocena,boat_id,cottage_id)
values (897,4,8,6);

insert into boat_reservation(id,end_date,res_name,start_date,boat_id,reg_korisnik_id,duration)
values(1023,'2022-12-12', 'Boat reservation for two','2022-12-10',8,108,5);

insert into cottage_reservation(id,end_date,res_name,start_date,cottage_id,reg_korisnik_id,duration)
 values(1024,'2022-12-12', 'Cottage reservation for two','2022-12-10',6,108,4);

