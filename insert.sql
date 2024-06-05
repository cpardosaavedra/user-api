CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL,
                       dni VARCHAR(20) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       nick VARCHAR(50) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       enabled TINYINT(1) NOT NULL
);

INSERT INTO users (name, last_name, dni, email, nick, password)
VALUES
    ('John', 'Doe', '123456789', 'john.doe@example.com', 'johndoe', 'mypassword', 0),
    ('Jane', 'Smith', '987654321', 'jane.smith@example.com', 'janesmith', 'anotherpassword', 0);