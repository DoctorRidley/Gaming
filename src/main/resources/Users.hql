CREATE TABLE IF NOT EXISTS Users (
     id           INT        NOT NULL,
     username     STRING     NOT NULL,
     password     STRING     NOT NULL,
     temp         STRING     NOT NULL,

     PRIMARY KEY(id) DISABLE NOVALIDATE
)
PARTITIONED BY (type STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',';
