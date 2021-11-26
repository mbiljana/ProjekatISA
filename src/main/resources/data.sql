INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms)
VALUES (5,'#petfriendly','Zlatibor, Zlatiborska 112a','Small cottage in the woods.','Cottage1','No smoking',3,3);

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms)
VALUES (6,'#pool #spacenter','Kopaonik, Kopaonička 16b','Luxary cottage in the city center.','Cottage2','Pets not allowed.',3,5);

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms)
VALUES (7,'#freeparking #WIFI','Jahorina, Jahorinska 55','Small cottage by the lake.','Cottage3','Check-in before 12am.',3,2);

INSERT INTO adventure(id,adventure_additional_services,adventure_address,adventure_capacity,adventure_name,adventure_rules,aventure_equipment,instructor_biography,promo_description)
VALUES (3,'#lunchIncluded #transportIncluded','Kopaonička 10',7,'Fishing on Vrela river','Pets are not allowed.','Fishing rods','Instructor is a professional fisherman with a longterm experience.','This is a once in a lifetime opportunity to learn fishing from the best.');

INSERT INTO adventure(id,adventure_additional_services,adventure_address,adventure_capacity,adventure_name,adventure_rules,aventure_equipment,instructor_biography,promo_description)
VALUES (4,'#lunchBreakIncluded #transportIncluded','Tarinska 25b',20,'Tara rafting','Bring swimsuits.','Boats, inflatable vests','Instructor is a professional fisherman with a longterm experience.','This is a once in a lifetime opportunity to experience rafting while fishing.');




INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power,max_speed)
VALUES (8,'Fishing rods, water vests','Harbor C5',10,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Blue Moon','Pets are not allowed.','Fishing boat',
        'WKC4B','100 horsepower',100);

insert into isa_proj_schema.korisnik(dtype, id, birth_date, city, email_address, home_address, ime, password, phone_number, role, state, surname, username)
VALUES('a',2,'1999-12-12','fdhigdf','kdgoudg','iudggiod','dfgdu','hfhi','hghg',1,'yyi','hghg','hghg');



