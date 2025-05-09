CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE car (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    model VARCHAR(100) NOT NULL,
    factory_year INTEGER NOT NULL,
    customer_id UUID NOT NULL REFERENCES customer(id) ON DELETE CASCADE
);