CREATE TABLE Employee (
  id VARCHAR2(36) PRIMARY KEY,
  name VARCHAR2(255) NOT NULL,
  phone VARCHAR2(20) NOT NULL,
  email VARCHAR2(255) NOT NULL,
  role VARCHAR2(100) NOT NULL,
  cpf VARCHAR2(20) NOT NULL,
  mechanic_id RAW(16),
  CONSTRAINT fk_employee_mechanic FOREIGN KEY (mechanic_id) REFERENCES Mechanic(id)
);