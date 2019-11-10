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