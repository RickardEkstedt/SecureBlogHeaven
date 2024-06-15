INSERT INTO address (id, street, postal_code, city, country)
VALUES (1, 'Storgatan 1', '12345', 'Stockholm', 'Sverige'),
       (2, 'Lillgatan 2', '23456', 'Göteborg', 'Sverige'),
       (3, 'Västra Vägen 3', '34567', 'Malmö', 'Sverige'),
       (4, 'Norra Norrlandsgatan 4', '45678', 'Umeå', 'Sverige'),
       (5, 'Södra Sidan 5', '56789', 'Lund', 'Sverige');

INSERT INTO user (id, email, first_name, last_name, address_id, phone, member_type)
VALUES (1, 'anna.svensson@example.com', 'Anna', 'Svensson', 1, 701234567, 'standard'),
       (2, 'bjorn.johansson@example.com', 'Björn', 'Johansson', 2, 702345678, 'enhanced'),
       (3, 'carin.andersson@example.com', 'Carin', 'Andersson', 3, 703456789, 'premium'),
       (4, 'david.karlsson@example.com', 'David', 'Karlsson', 4, 704567890, 'standard'),
       (5, 'eva.eriksson@example.com', 'Eva', 'Eriksson', 5, 705678901, 'enhanced');

INSERT INTO post (id, content)
VALUES (1, 'Detta är blogg post 1'),
       (2, 'Detta är blogg post 2'),
       (3, 'Detta är blogg post 3'),
       (4, 'Detta är blogg post 4'),
       (5, 'Detta är blogg post 5');