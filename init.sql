CREATE DATABASE IF NOT EXISTS datadog;

USE datadog;

CREATE TABLE IF NOT EXISTS book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    pages INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    publication DATE NOT NULL
);

INSERT INTO book (author, category, name, pages, price, publication) VALUES
('Author 1', 'Category 1', 'Book 1', 300, 29.99, '2023-01-01'),
('Author 2', 'Category 2', 'Book 2', 250, 19.99, '2022-05-01'),
('Author 3', 'Category 1', 'Book 3', 400, 39.99, '2024-03-15');
