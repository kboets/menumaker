insert into MEAT_ORIGIN(meat_origin_id, animal) values(100,'VARKEN');
insert into MEAT_ORIGIN(meat_origin_id, animal) values(101, 'KIP');
insert into MEAT_ORIGIN(meat_origin_id, animal) values(102, 'RUND');

insert into MEAT (meat_id, name, type) values (201 ,'Gehakt', 'ROOD');
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(100,201);
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(102,201);
insert into MEAT (meat_id, name, type) values (202,'Kipfilet', 'WIT');
insert into MEAT (meat_id, name, type) values (203,'Hamburger', 'ROOD');

insert into POTATO (potato_id, name, potato_type) values (5001, 'Gebakken patatten', 'NORMAL' );
insert into POTATO (potato_id, name, potato_type) values (5002, 'Patatten', 'NORMAL' );
insert into POTATO (potato_id, name, potato_type) values (5003, 'Frieten', 'FRIES' );

insert into FISH(fish_id, name, fish_type) values(3001, 'Tonijn','HALF_VET');
insert into FISH(fish_id, name, fish_type) values(3002, 'Zalm', 'VET');
insert into FISH(fish_id, name, fish_type) values(3003, 'Mossselen','WEEKDIER');
insert into FISH(fish_id, name, fish_type) values(3004, 'Haring', 'VET');
insert into FISH(fish_id, name, fish_type) values(3005, 'Kabeljauw', 'WIT');

insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4002, 'Witloof', 'BLADGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4003, 'Spinazie','BLADGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4004, 'Bloemkool','KOOLGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4005, 'Brocoli','KOOLGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4006, 'Spruiten','KOOLGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4007, 'Sperziebonen','PEULVRUCHT');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4008, 'Snijbonen','PEULVRUCHT');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4009, 'Erwten','PEULVRUCHT');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4010, 'Wortelen','VRUCHTGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4011, 'Schorseneren','VRUCHTGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4012, 'Asperges','STENGELGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4013, 'Ajuin','STENGELGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4014, 'Prei','STENGELGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4015, 'Tomaat','VRUCHTGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4016, 'Komkommers','VRUCHTGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4017, 'Aubergines','VRUCHTGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4018, 'Paprika','VRUCHTGROENTEN');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4019, 'Courgettes','VRUCHTGROENTEN');

insert into MEAT_ORIGIN(meat_origin_id, animal) values(2000,'VARKEN');
insert into MEAT_ORIGIN(meat_origin_id, animal) values(2001, 'KIP');
insert into MEAT_ORIGIN(meat_origin_id, animal) values(2002, 'RUND');
insert into MEAT_ORIGIN(meat_origin_id, animal) values(2003, 'KALF');
insert into MEAT_ORIGIN(meat_origin_id, animal) values(2004, 'LAM');
insert into MEAT_ORIGIN(meat_origin_id, animal) values(2005, 'PAARD');
insert into MEAT_ORIGIN(meat_origin_id, animal) values(2006, 'SCHAAP');


insert into MEAT (meat_id, name, type) values (1001 ,'Gehakt', 'ROOD');
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(2000,1001);
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(2002,1001);
insert into MEAT (meat_id, name, type) values (1002,'Kipfilet', 'WIT');
insert into MEAT (meat_id, name, type) values (1003,'Hamburger', 'ROOD');


