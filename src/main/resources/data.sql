/*lozinke za korisnika su hešovane: 123
  Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator

#problem je kada hoćemo u nekoj tabeli da imamo referencu na id od korisnika, ne rade zahtevi sa tokenima
#npr. adventure -> fishing_instructor_id, pa sam uklonila sve reference
#moramo drugačije da rešimo ukoliko je neophodno!!!*/
INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price,cancel_condition)
VALUES (3,'#petfriendly','Zlatibor, Zlatiborska 112a','Small cottage in the woods.','Cottage1','No smoking',3,3,43.7262501,19.6938721,50,'all price payback');

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price,cancel_condition)
VALUES (2,'#pool #spacenter','Kopaonik, Kopaonička 16b','Luxary cottage in the city center.','Cottage2','Pets not allowed.',3,5,43.7262501,19.6938721,100,'no payback');

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms,latitude,longitude,price,cancel_condition)
VALUES (1,'#freeparking #WIFI','Jahorina, Jahorinska 55','Small cottage by the lake.','Cottage3','Check-in before 12am.',3,2,43.7262501,19.6938721,75, 'no payback');

#INSERT INTO korisnik(id, birth_date,enabled,city,email_address, home_address, name, password, phone_number, role,state, surname, username,last_password_reset_date)
#VALUES (72,'1997-02-05',true,'bg','@2','sdfa','bla','111',234,4,'srb','qwe','123',now());

#INSERT INTO korisnik(id, birth_date,enabled,city,email_address, home_address, name, password, phone_number, role,state, surname, username,last_password_reset_date)
#VALUES (73,'1997-02-05',true,'bg','@2','sdfa','bla','13',234,4,'srb','qwe','10',now());



#INSERT INTO korisnik(id, birth_date,enabled,city,email_address, home_address, name, password, phone_number, role,state, surname, username, last_password_reset_date)
#VALUES (74,'1997-02-05',true,'bg','@2','sdfa','bla','111',234,1,'srb','qwe','123',now());

#INSERT INTO korisnik(id, birth_date,enabled,city,email_address, home_address, name, password, phone_number, role,state, surname, username,last_password_reset_date)
#VALUES (76,'1997-02-05',true,'bg','@2','sdfa','bla','1',234,4,'srb','qwe','1',now());

#INSERT INTO korisnik(id, birth_date,enabled,city,email_address, home_address, name, password, phone_number, role,state, surname, username,last_password_reset_date)
#VALUES (77,'1997-02-05',true,'bg','@2','sdfa','bla','11',234,3,'srb','qwe','11',now());

#INSERT INTO korisnik(id, birth_date,enabled,city,email_address, home_address, name, password, phone_number, role,state, surname, username,last_password_reset_date)
#VALUES (78,'1997-02-05',true,'bg','@2','sdfa','bla','71',234,0,'srb','qwe','41',now());

#mislim da nećemo ovako da radimo, nego samo tabelu sa korisnicima
#INSERT INTO fishing_instructor(id) values (72);
#INSERT INTO fishing_instructor(id) values (73);
#INSERT INTO admin(id) VALUES(74);

#INSERT INTO korisnik(id, birth_date,enabled,city,email_address, home_address, name, password, phone_number, role,state, surname, username,last_password_reset_date)
#values  (108,'1995-02-05',true,'bg','@nekiregkor','sdfa','Pavle','pb','0564215',5,'srb','Bugarski','pavleb',now());

#mislim da nećemo ovako da radimo

#INSERT INTO reg_korisnik(id) VALUES (108);



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


#INSERT INTO boat_owner(id) VALUES (76);


#INSERT INTO cottage_owner(id) VALUES  (77);

insert into zahtev_za_reg(id, birth_date, city, email_address, home_address, name, password, phone_number, razlog, reg_type, state, surname, username) VALUES
    (1,'2022-02-02','hg','hg','hg','hg','hg',15,'hg','BOATOWNER','hg','hg','hg');

#insert into ocena(id,ocena,boat_id,cottage_id)
#values (898,5,8,6);
#insert into ocena(id,ocena,boat_id,cottage_id)
#values (899,3,8,6);
#insert into ocena(id,ocena,boat_id,cottage_id)
#values (897,4,8,6);

#insert into boat_reservation(id,end_date,res_name,start_date,boat_id,duration)
#values(1023,'2022-12-12', 'Boat reservation for two','2022-12-10',8,5);

insert into korisnik(id,username, password, name, surname,birth_date,city,email_address,enabled,home_address,phone_number,role,state,last_password_reset_date)
values (2,'user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Pera', 'Peric','2022-12-12', 'Vrsac', 'user@gmail.com',true, 'Cara Dusana 37', '123456789',1, 'Srbija', now());

insert into korisnik(id,username, password, name, surname,birth_date,city,email_address,enabled,home_address,phone_number,role,state, last_password_reset_date)
values (3,'admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Maric','2022-12-12', 'Novi Sad', 'user@gmail.com',true, 'Cara Dusana 37', '123456789',4, 'Srbija', now());

insert into korisnik(id,username, password, name, surname,birth_date,city,email_address,enabled,home_address,phone_number,role,state, last_password_reset_date)
values (4,'instructor', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Maric','2022-12-12', 'Novi Sad', 'user@gmail.com',true, 'Cara Dusana 37', '123456789',4, 'Srbija', now());

#insert into fishing_instructor(short_biography, id) values ('bla', 4);



insert into uloga (name) values ('ROLE_CLIENT');
insert into uloga (name) values ('ROLE_ADMIN');
insert into uloga(name) values ('ROLE_INSTRUCTOR');



insert into user_uloge(user_id, role_id) VALUES (2,1);
insert into user_uloge(user_id, role_id) VALUES (3,1);
insert into user_uloge(user_id, role_id) VALUES (3,2);
insert into user_uloge(user_id, role_id) VALUES (4,3);

#insert into cottage_reservation(id,end_date,res_name,start_date,cottage_id,duration)
#values(1024,'2022-12-12', 'Cottage reservation for two','2022-12-10',6,4);


insert into address(address_id, city, country, latitude, longitude, postal_code, street_name, street_number)
values (1,'Vrsac','Srbija','30.045','27.045','26300','Studenicka','16b');

insert into address(address_id, city, country, latitude, longitude, postal_code, street_name, street_number)
values (2,'Vrsac','Srbija','30.045','27.045','26300','Studenicka','16b');

insert into address(address_id, city, country, latitude, longitude, postal_code, street_name, street_number)
values (3,'Vrsac','Srbija','30.045','27.045','26300','Studenicka','16b');


insert into registration_request(id, name, surname, email_address, biography, explanation, role_id, address_id,password)
values(1,'bla','bla','bla','bla','bla',1,1,'bla');

insert into registration_request(id, name, surname, email_address, biography, explanation, role_id, address_id,password)
values(2,'bla','bla','bla','bla','bla',2,2,'bla');

insert into delete_request(delete_request_id,content,reg_user_id) values (1,'Illegal usage of images',2);

#insert into client(cancellation_number, client_type, points, id)
#VALUES (1,1,34,1);

#insert into rent_entity(client_id, entity_id) values (1,1);
insert into renting_entity(entity_id, average_grade, cancellation_percentage, description, name, version, address_id)
values(1,2,33,'ble','ble',3,1);

INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power,max_speed,latitude,longitude,price,cancel_condition)
VALUES (8,'Fishing rods, water vests','Harbor C5',10,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Blue Moon','Pets are not allowed.','Fishing boat',
        'WKC4B','100 horsepower',100,43.7262501,19.6938721, 100,'payback 3 days before');

#insert into adventure(max_persons, entity_id, reg_user_id) values (4,1,4);

#insert into fast_reservation(id, additional_services, capacity, duration, is_canceled, place, price, start_date, adventure_entity_id, boat_id, entity_id)
#values(1,'nsto',4,44,0,'ceds',33,now(),1,8,1);


insert into report(report_id, content, is_bad_review, not_appeared, reg_user_id, entity_id)
values (1,'bla',0,0,2,1);

#insert into revision(revision_id, content, is_approved, mark, reservation_id)
#values (1,'bl',0,1,1);



insert into sale(sale_id, additional_services, date_time_from, duration_in_hours, expire_date_time, maximum_persons, price, entity_id)
values (1, 'ney', now(),2,'2022-08-13 15:22:22',4,25,1);

