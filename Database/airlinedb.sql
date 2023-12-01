-- Create the admin table
CREATE TABLE admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create the places table
CREATE TABLE places (
    place_id INT PRIMARY KEY AUTO_INCREMENT,
    place_name VARCHAR(255) NOT NULL
);

-- Insert South African places
INSERT INTO places (place_name) VALUES
    ('Cape Town'),
    ('Johannesburg'),
    ('Durban'),
    ('Port Elizabeth');

-- Create the airlines table
CREATE TABLE airlines (
    airline_id INT PRIMARY KEY AUTO_INCREMENT,
    airline_name VARCHAR(255) NOT NULL
);

-- Insert airlines
INSERT INTO airlines (airline_name) VALUES
    ('Delta Airlines'),
    ('American Airlines'),
    ('British Airways'),
    ('Air France');

-- Create the flights table
CREATE TABLE flights (
    flight_id INT PRIMARY KEY AUTO_INCREMENT,
    source_id INT,
    destination_id INT,
    airline_id INT,
    ticket_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (source_id) REFERENCES places (place_id),
    FOREIGN KEY (destination_id) REFERENCES places (place_id),
    FOREIGN KEY (airline_id) REFERENCES airlines (airline_id)
);

-- Insert sample flights
INSERT INTO flights (source_id, destination_id, airline_id, ticket_price) VALUES
    (1, 2, 1, 500.00),
    (2, 3, 2, 600.00),
    (3, 1, 3, 550.00);

-- Create the users table
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL
);
-- Insert sample users
INSERT INTO users (username, email, phone_number) VALUES
    ('Kholofelo_kgatla', 'kgtla@example.com', '+2745789420'),
    ('John_Kgatla', 'John.Kgatlah@example.com', '+2775647897');