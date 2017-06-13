-- noinspection SqlResolveForFile

INSERT INTO person (first_name, second_name, height, weight) VALUES ('John', 'Zorro', 187, 79.4);

INSERT INTO person (first_name, second_name, height, weight) VALUES ('Ivan', 'Gor''kiy', 166, 100);
INSERT INTO person (first_name, second_name, height, weight) VALUES ('Bill', 'Ivanovich', 186, 98);
INSERT INTO person (first_name, second_name, height, weight) VALUES ('Boris', 'Johnson', 165, 66);
INSERT INTO person (first_name, second_name, height, weight) VALUES ('Freddy', 'Johanson', 172, 79);

INSERT INTO community (name, is_aggressive) VALUES ('Bikers', '1');
INSERT INTO community (name, is_aggressive) VALUES ('Football hooligans', '1');
INSERT INTO community (name, is_aggressive) VALUES ('Musicians', '0');

INSERT INTO person_community (fk_person, fk_community) VALUES (1, 1);
INSERT INTO person_community (fk_person, fk_community) VALUES (1, 3);
INSERT INTO person_community (fk_person, fk_community) VALUES (2, 2);
INSERT INTO person_community (fk_person, fk_community) VALUES (3, 3);
