CREATE TABLE `product` (
  `barcode` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`barcode`)
);

CREATE TABLE `product_survey` (
  `id` varchar(50) NOT NULL,
  `product_barcode` varchar(50) NOT NULL,
  `price` decimal(12,5) DEFAULT NULL,
  `notes` varchar(50) DEFAULT NULL,
  `store` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_barcode` (`product_barcode`),
  CONSTRAINT `product_survey_ibfk_1` FOREIGN KEY (`product_barcode`) REFERENCES `product` (`barcode`)
);


insert into product (barcode,name,description) values("BC001","Samsung Mobile","Samsung mobile desc");
insert into product (barcode,name,description) values("BC002","Apple","iPhone");
insert into product (barcode,name,description) values("BC003","Samsung washing machine","WacMachine desc");
insert into product (barcode,name,description) values("BC004","Bag","AT bags");

insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",121,"Note2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",11,"Note3","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",121,"Note4","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",11,"Note5","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",12,"Note7","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",161,"Note8","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",181,"Note22","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",191,"Note22","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",11,"Note23","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",321,"Note12","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC001",161,"Note25","Prizy");



insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",13,"Samsung note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",32,"Samsung note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",33,"Samsung note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",43,"Samsung note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",34,"Samsung note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",35,"Samsung note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",73,"Samsung note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",93,"Samsung note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",30,"Samsung note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC003",31,"Samsung note 2","Prizy");

insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC002",311,"Apple","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC002",35,"Apple note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC002",73,"Apple note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC002",93,"Apple note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC002",30,"Apple note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC002",31,"Apple note 2","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC002",311,"Apple note 2","Prizy");

insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC004",12,"Note23","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC004",92,"Note22","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC004",121,"Note332","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC004",99,"Note22","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC004",121,"Note28","Prizy");
insert into product_survey (id, product_barcode, price, notes, store) values(uuid(),"BC004",82,"Note6","Prizy");
