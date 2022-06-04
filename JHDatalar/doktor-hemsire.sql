use hastahane;

create table Doktorlar(
id int auto_increment primary key,
ad varchar(30),
soyad varchar(30),
dT date,
brans varchar(40),
maas int
);

insert into Doktorlar values (100,'EnesFaruk','Sama','2001-01-01','Beyin Cerrahi',9000);
insert into Doktorlar values (0,'Hvicil','San','2002-02-02','Genel Cerrahi',10000);
insert into Doktorlar values (0,'Aykut','San','2003-03-03','Dahiliye Uzmani',12000);
insert into Doktorlar values (0,'YusupMyrat','Bey','2004-04-04','Kalp Ve Damar Hastaliklari',14000);
insert into Doktorlar values (0,'Suat','Sama','2005-05-05','Goz Hastaliklari',8500);
insert into Doktorlar values (0,'Halid','Sama','2006-06-06','Herbokolog',15000);
insert into Doktorlar values (0,'Ali','Sama','2007-07-07','Psikolog',12500);
insert into Doktorlar values (0,'Faruk','Duyar','2007-07-07','Ortopedist',12500);

create table Hemsire(
id int auto_increment primary key,
ad varchar(30),
soyad varchar(30),
dT date,
maas int
);


insert into Hemsire values (100,'Ozge','Sama','2001-01-01',7000);
insert into Hemsire values (0,'Selin','Yag','2002-02-02',7000);
insert into Hemsire values (0,'Zerrin','Dag','2003-03-03',7000);
insert into Hemsire values (0,'Merve','Gunes','2004-04-04',7500);
insert into Hemsire values (0,'Ferdi','Tayfur','2005-05-05',8500);
insert into Hemsire values (0,'Muslum','Gurses','2006-06-06',75000);
insert into Hemsire values (0,'Yildiz','Tilbe','2007-07-07',8000);
insert into Hemsire values (0,'Selda','Gun','2007-07-07',8000);
