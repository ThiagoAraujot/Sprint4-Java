CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE mechanic (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    address VARCHAR(255) NOT NULL,
    cnpj VARCHAR(20) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL