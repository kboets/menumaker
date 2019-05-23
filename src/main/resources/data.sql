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


insert into FISH(fish_id, name, fish_type) values(3001, 'Tonijn','HALF_FAT');
insert into FISH(fish_id, name, fish_type) values(3002, 'Zalm', 'FAT');
insert into FISH(fish_id, name, fish_type) values(3003, 'Mossselen','SEAFOOD');
insert into FISH(fish_id, name, fish_type) values(3004, 'Haring', 'FAT');
insert into FISH(fish_id, name, fish_type) values(3005, 'Kabeljauw', 'LEAN');

insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4002, 'Witloof', 'LEAFY');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4003, 'Spinazie','LEAFY');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4004, 'Bloemkool','CABBAGE');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4005, 'Brocoli','CABBAGE');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4006, 'Spruiten','CABBAGE');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4007, 'Sperzie bonen','LEGUME');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4008, 'Snijbonen','LEGUME');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4009, 'Erwten','LEGUME');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4010, 'Wortelen','FRUIT');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4011, 'Schorseneren','FRUIT');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4012, 'Asperges','STEM');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4013, 'Ajuin','STEM');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4014, 'Prei','STEM');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4015, 'Tomaat','FRUIT');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4016, 'Komkommers','FRUIT');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4017, 'Aubergines','FRUIT');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4018, 'Paprika','FRUIT');
insert into VEGETABLE (vegetable_id, name, vegetable_type) values(4019, 'Courgettes','FRUIT');
