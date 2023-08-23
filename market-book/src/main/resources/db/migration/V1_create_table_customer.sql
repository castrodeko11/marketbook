CREATE TABLE customer{
    id INT AUTO_INCREMENT primary key,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL unique,
};