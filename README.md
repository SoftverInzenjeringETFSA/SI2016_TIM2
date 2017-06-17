# SI2016_TIM2

### Našu aplikaciju možete pregledati na: <a href="https://posao-ba.herokuapp.com/">ETF Posao.ba</a>
> <strong>Napomena:</strong> Zbog nedostatka aktivnosti na stranici, moguće je da dođe do zaustavljanja servera te je potrebno neko vrijeme da se ponovno pokrenu. Ukoliko se oglasi ne prikažu odmah po pristupanju aplikaciji, molimo da sačekate cca. 30 sekundi, te pokušate osvježiti stranicu.

## Konfiguracija i pokretanje

* Instalirati Eclipse Neon.3
    *   Instalirati Spring IDE -> Help->Eclipse Marketplace
    *   Po potrebi instalirati maven i spring boot cli https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html
    
*   Instalirati MySql (Korištena verzija 5.7.18, druge verzije bi trebale biti kompatibilne)

*   Izvršiti skriptu tim2.sql (Može se koristiti i mysql workbench za ove korake)
    * mysql -u root -p < tim2.sql
    * prijaviti se na bazu kao root (mysql -u root -p)
    * kreirati novog korisnika i dodati privilegije
    * CREATE USER 'EtfSI2016'@'localhost' IDENTIFIED BY '2016SIEtf';
    * GRANT select, insert, delete, update on tim2.* to 'EtfSI2016'@'localhost';
    
* Instalirati node.js

* Instalirati npm

* Instalirati bower

* Instalirati Ember CLI

* izvršiti npm install u Projekat/Posao_FE

Nakon pokretanja backenda i servera baze podataka, aplikacija se pokreće unošenjem "ember s" u Posao_FE. 

## Urađeno

__Napomena__: svi trenutni korisnici u bazi podataka imaju password "test". Početni korisnici u bazi su "admin", "korisnik1", "firma1" sa ulogama admin, nezaposleni i poslodavac respektivno. Sve uloge osim admina se mogu dodavati kroz UI.

Unutar projekta Posao.ba implementirano je sljedeće, za naznačene vrste korisnika:
   * **Registracija** (kao poslodavac ili nezaposleni)
   * **Profil korisnika** - uređivanje, brisanje (za sve registrovane). **Napomena**: do ovog se dolazi klikom na username nakon logina
   * **Oglasi** - pregled aktivnih oglasa, pretraga i filtriranje (za sve korisnike i goste); prijava (za nezaposlenog); kreiranje sa ili bez templatea, obnova, zatvaranje, pregled sopstvenih oglasa (za poslodavca); brisanje oglasa (za admina)
   * **Kategorije** - dodavanje, uređivanje, brisanje (za admina)
   * **Templatei** - dodavanje (za admina)
   * **Prikaz nezaposlenih korisnika poslodavcu**
   * **Poruke** - čitanje (nezaposleni); slanje i čitanje poslanih (poslodavac). **Napomena: Korisnik ulogovan kao poslodavac do polja za slanje poruke dolazi pregledom svih nezaposlenih, klikom na dugme "pošalji poruku"
   * **Notifikacije** - generisanje poslodavcu kada se neko prijavi na njegov oglas, ispis poslodavcu
   
   
## Folderi


* Pomocna dokumentacija - Unutar iste se nalaze .docx dokumenti, .vpp dijagrami, paleta, te screenshot svih route.
* Dokumentacija - SRS, Ponuda, Intervju i Dokument dizajna sistema
* Reference - Dokumenti povezani s dokumentacijom
* Projekat:
   * Posao.ba-BE - backend projekat
   * Posao.ba-DB - dump baze podataka - trenutno u bazi postoje tri korisnika, tri oglasa od kojih su dva aktivna, četiri templatea, tri kategorije, nijedna prijava, nijedna poruka i notifikacija.
   * Posao_FE - frontend projekat
