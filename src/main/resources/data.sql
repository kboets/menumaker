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
