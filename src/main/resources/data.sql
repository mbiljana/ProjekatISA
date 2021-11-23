INSERT INTO user(id,name,surname,emailAddress,phoneNumber,city,state,homeAddress,birthDate,username,password,role)
VALUES (1,'Biljana','Marinkov','bilja@gmail.com','061123548','Novi Sad','Serbia','Kralja Petra 23','1999-05-02','bilja123','ftn','BOATOWNER');

INSERT INTO user(id,name,surname,emailAddress,phoneNumber,city,state,homeAddress,birthDate,username,password,role)
VALUES (2,'Marija','Zarić','zaricm@gmail.com','061123527','Novi Sad','Serbia','Bulevar Oslobođenja 17','1998-12-01','marija123','ftn','REGUSER');

INSERT INTO user(id,name,surname,emailAddress,phoneNumber,city,state,homeAddress,birthDate,username,password,role)
VALUES (3,'Anamarija','Dolovac','ana123@gmail.com','061123522','Novi Sad','Serbia','Cara Dušana 22','1999-11-30','ana123','ftn','ADMIN');

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms)
VALUES (1,'#petfriendly','Zlatibor, Zlatiborska 112a','Small cottage in the woods.','Cottage1','No smoking',3,3);

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms)
VALUES (2,'#pool #spacenter','Kopaonik, Kopaonička 16b','Luxary cottage in the city center.','Cottage2','Pets not allowed.',3,5);

INSERT INTO cottage(id,cottage_additional_services,cottage_address,cottage_description,cottage_name,cottage_rules,num_beds,num_rooms)
VALUES (3,'#freeparking #WIFI','Jahorina, Jahorinska 55','Small cottage by the lake.','Cottage3','Check-in before 12am.',3,2);

INSERT INTO adventure(id,adventure_additional_services,adventure_address,adventure_capacity,adventure_name,adventure_rules,aventure_equipment,instructor_biography,promo_description)
VALUES (1,'#lunchIncluded #transportIncluded','Kopaonička 10',7,'Fishing on Vrela river','Pets are not allowed.','Fishing rods','Instructor is a professional fisherman with a longterm experience.','This is a once in a lifetime opportunity to learn fishing from the best.');

INSERT INTO adventure(id,adventure_additional_services,adventure_address,adventure_capacity,adventure_name,adventure_rules,aventure_equipment,instructor_biography,promo_description)
VALUES (2,'#lunchBreakIncluded #transportIncluded','Tarinska 25b',20,'Tara rafting','Bring swimsuits.','Boats, inflatable vests','Instructor is a professional fisherman with a longterm experience.','This is a once in a lifetime opportunity to experience rafting while fishing.');


INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power)
VALUES (1,'Fishing rods, water vests','Harbor 2A',15,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Maria','Pets are not allowed.','Fishing boat',
        'JKW2A','90 horsepower');

INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power)
VALUES (2,'Fishing rods, water vests','Harbor 1B',20,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Perla','Pets are not allowed.','Fishing boat',
        'JKA3W','120 horsepower');

INSERT INTO boat(id,additional_equipment,boat_address,boat_capacity,boat_description,boat_name,boat_rules,boat_type,engine_number,engine_power)
VALUES (3,'Fishing rods, water vests','Harbor C5',10,'Built exclusively for fishing,
include stability, strength and durability to survive fishing ventures across various kinds of waterways',
        'Blue Moon','Pets are not allowed.','Fishing boat',
        'WKC4B','100 horsepower');