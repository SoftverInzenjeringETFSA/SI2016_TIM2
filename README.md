# SI2016_TIM2




## Konfiguracija


* Instalirati Eclipse Neon.3
    *   Instalirati Spring IDE -> Help->Eclipse Marketplace
    *   Po potrebi instalirati maven i spring boot cli https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html
    
*   Instalirati MySql (Korištena verzija 5.7.18, druge verzije bi trebale biti kompatibilne)

*   Izvršiti skriptu init.sql (Može se koristiti i mysql workbench za ove korake)
    * mysql -u root -p < init.sql
    * prijaviti se na bazu kao root (mysql -u root -p)
    * kreirati novog korisnika i dodati privilegije
    * CREATE USER 'EtfSI2016'@'localhost' IDENTIFIED BY '2016SIEtf';
    * GRANT select, insert, delete, update on tim2.* to 'EtfSI2016'@'localhost';
    
* Instalirati node.js

* Instalirati npm

* Instalirati bower

* Instalirati Ember CLI


## Urađeno


Unutar projekta Posao.ba implementirano je sljedeće:
* Frontend:
   * Welcome page
   * Login page
   * Registracija (Poslodavac i nezaposleni)
   * Profil korisnika
   * Oglas
   * Lista oglasa
   * Pretraga oglasa
   * Unos oglasa

* Backend:
   * Baza podataka
   * REST servisi za: 
      * Korisnike
         * Pretraga korisnika po email-u i username-u
         * Pretraga svih korisnika
         * Dodavanje korisnika
         * Brisanje korisnika
         * Update korisnika
         * Utvrđivanje vrste korisnika (Admin, poslodavac ili nezaposleni)
         * Login korisnika
         * Započeta registracija korisnika
         * Notifikacije
      * Oglase
         * Oglasi jednog poslodavca /oglasi/poslodavac/{id}
         * Oglasi po kategorijama oglasi/kategorija?kategorija=NazivKategorije
         * Pretraga po vrijednostima /oglasi/pretraga?vrijednost=ABC
         * Pretraga po lokaciji /oglasi/pretraga/lokacija?lokacija=Sarajevo
         * Pretraga oglasa po ID-u /oglasi/{id}
   
   
   
## TO DO:


Potrebno je osposobiti povezivanje frontend-a i backend-a, vršenjem odgovarajuće serijalizacije podataka u ember-data i obratno.
http://nortpoint.io/2016/10/13/lets-make-friends-with-spring-and-emberjs/
Implementirati preostale funkcionalnosti.



## Folderi


* Pomocna dokumentacija - Unutar iste se nalaze .docx dokumenti, .vpp dijagrami, paleta, te screenshot svih route.
* Dokumentacija - SRS, Ponuda, Intervju i Dokument dizajna sistema
* Reference - Dokumenti povezani s dokumentacijom
* Projekat:
   * Posao.ba-BE - backend projekat
   * Posao_FE - frontend projekat


