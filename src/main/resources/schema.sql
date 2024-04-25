CREATE Table Billett
(
    id      INTEGER AUTO_INCREMENT NOT NULL,
    filmer    VARCHAR(255) NOT NULL,
    antall INTEGER NOT NULL,
    fornavn    VARCHAR(255) NOT NULL,
    etternavn VARCHAR(255) NOT NULL,
    nummer    VARCHAR(255) NOT NULL,
    epost VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);