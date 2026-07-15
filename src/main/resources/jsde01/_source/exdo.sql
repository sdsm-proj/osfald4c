
CREATE TABLE jsde_exdo
(
    id VARCHAR(36) primary key,
    nazwa VARCHAR(400) not null,
    institution_id VARCHAR(36) not null,
    jakas_data  DATE not null,
    jakas_liczba INTEGER not null DEFAULT 0
);
