INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (72,'1997-02-05','bg','@2','sdfa','bla','1',234,4,'srb','qwe','1');

INSERT INTO korisnik(id, birth_date,city,email_address, home_address, ime, password, phone_number, role,state, surname, username)
VALUES (73,'1997-02-05','bg','@2','sdfa','bla','11',234,4,'srb','qwe','11');

INSERT INTO fishing_instructor(id) values (72);
INSERT INTO fishing_instructor(id) values (73);


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
