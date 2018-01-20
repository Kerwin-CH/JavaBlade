
-- Table: t_users
CREATE TABLE t_users ( 
    uid      INTEGER     PRIMARY KEY
                         NOT NULL
                         UNIQUE,
    username CHAR( 20 )  NOT NULL
                         UNIQUE,
    password CHAR( 16 )  NOT NULL,
    email    CHAR        NOT NULL 
);


-- Table: t_notes
CREATE TABLE t_notes ( 
    uid     INTEGER NOT NULL
                    REFERENCES t_users ( uid ),
    noteid  INTEGER PRIMARY KEY
                    NOT NULL
                    UNIQUE,
    content CHAR 
);

