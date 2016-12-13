-- daruj:Dar4uj

CREATE ROLE daruj LOGIN ENCRYPTED PASSWORD 'md54cfa30fff93ad7039bb33be47cc25808' VALID UNTIL 'infinity';

CREATE DATABASE daruj
  WITH ENCODING='UTF8'
       OWNER=daruj
       TEMPLATE=template0
       LC_COLLATE='Czech_Czech Republic.1250'
       LC_CTYPE='Czech_Czech Republic.1250'
       CONNECTION LIMIT=-1;

CREATE DATABASE daruj
  WITH ENCODING='UTF8'
       OWNER=daruj
       TEMPLATE=template0
       LC_COLLATE='cs_CZ.UTF8'
       LC_CTYPE='cs_CZ.UTF8'
       CONNECTION LIMIT=-1;
