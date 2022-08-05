CREATE TABLE documents (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    date DATE
);

CREATE TABLE dictionaries (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE carts (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    document_id INTEGER REFERENCES documents(id) ON DELETE SET NULL, 
    dictionary_id INTEGER REFERENCES dictionaries(id) ON DELETE SET NULL 
);

INSERT INTO documents (date) VALUES ('2022-07-10'), ('2022-07-15'), ('2022-07-20'), ('2022-07-25');
INSERT INTO dictionaries (name) VALUES ('French'), ('English'), ('China'), ('Germany');
INSERT INTO carts (document_id, dictionary_id) VALUES (1, 4), (2, 3), (3, 2), (4, 1);