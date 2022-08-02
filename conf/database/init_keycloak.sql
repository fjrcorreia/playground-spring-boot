-- role, default username and password
CREATE USER keycloak WITH PASSWORD 'password';

-- database
CREATE DATABASE "keycloak"
WITH OWNER "keycloak"
ENCODING 'UTF8';


