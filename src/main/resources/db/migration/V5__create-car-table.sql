CREATE TABLE Car (
     id RAW(16) PRIMARY KEY,
     model VARCHAR2(255) NOT NULL,
     factory_year NUMBER(4) NOT NULL,
     customer_id RAW(16),
     CONSTRAINT fk_car_customer FOREIGN KEY (customer_id) REFERENCES Customer(id)
);