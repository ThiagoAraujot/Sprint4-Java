CREATE TABLE Service (
     id VARCHAR2(36) PRIMARY KEY,
     price NUMBER(10, 2) NOT NULL,
     service_date DATE NOT NULL,
     customer_id RAW(16),
     car_id RAW(16),
     employee_id RAW(16),
     CONSTRAINT fk_service_customer FOREIGN KEY (customer_id) REFERENCES Customer(id),
     CONSTRAINT fk_service_car FOREIGN KEY (car_id) REFERENCES Car(id),
     CONSTRAINT fk_service_employee FOREIGN KEY (employee_id) REFERENCES Employee(id)
);