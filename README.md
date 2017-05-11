# SI2016_TIM2





* Instalirati Eclipse Neon.3

* Instalirati STS - Spring Tools Suite
    
*   Instalirati MySql (Korištena verzija 5.7.18, druge verzije bi trebale biti kompatibilne)

*   Izvršiti skriptu init.sql
    * mysql -u root -p < init.sql
    * prijaviti se na bazu kao root (mysql -u root -p)
    * kreirati novog korisnika i dodati privilegije
    * CREATE USER 'EtfSI2016'@'localhost' IDENTIFIED BY '2016SIEtf';
    * GRANT select, insert, delete, update on tim2.* to 'EtfSI2016'@'localhost';
    
* Instalirati node.js

* Instalirati npm

* Instalirati bower

* Instalirati Ember CLI
