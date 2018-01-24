CREATE TABLE Wplywy(
 Etykiety_wierszy Bigint NOT NULL,
 Suma_skladek Double precision NOT NULL,
 Suma_czynszu Double precision NOT NULL,
 Suma_AWRSP Double precision NOT NULL,
 Suma_Wpisowe Double precision NOT NULL,
 Suma_ene1 Double precision NOT NULL,
 suma_ene2 Double precision NOT NULL,
 Rok Bigint NOT NULL,
 Suma_rok Double precision NOT NULL,
 Suma_zadluzenie Double precision NOT NULL,
 Suma_licznik Double precision NOT NULL,
 Suma_kwota Double precision NOT NULL,
 Nr_Rachunku Bigint NOT NULL
)
;

-- Create indexes for table Wplywy

CREATE INDEX IX_Relationship23 ON Wplywy (Nr_Rachunku)
;

-- Add keys for table Wplywy

ALTER TABLE Wplywy ADD CONSTRAINT Key1 PRIMARY KEY (Etykiety_wierszy)
;

ALTER TABLE Wplywy ADD CONSTRAINT Etykiety_wierszy UNIQUE (Etykiety_wierszy)
;

-- Table Odczyty_licznika

CREATE TABLE Odczyty_licznika(
 Data Date NOT NULL,
 Stan_po_odczycie Double precision NOT NULL,
 Odczyt Double precision NOT NULL,
 Nr_Naleznosci Bigint NOT NULL,
 Naleznosc Double precision NOT NULL,
 Nr_Odczytu Bigint NOT NULL,
 Nr_dzialki Bigint NOT NULL
)
;

-- Create indexes for table Odczyty_licznika

CREATE INDEX IX_Relationship20 ON Odczyty_licznika (Nr_dzialki)
;

-- Add keys for table Odczyty_licznika

ALTER TABLE Odczyty_licznika ADD CONSTRAINT Key2 PRIMARY KEY (Nr_Odczytu)
;

-- Table Numer_rachunku

CREATE TABLE Numer_rachunku(
 IBAN_Kraj Text NOT NULL,
 IBAN Bigint NOT NULL,
 Nr_Rachunku Bigint NOT NULL
)
;

-- Add keys for table Numer_rachunku

ALTER TABLE Numer_rachunku ADD CONSTRAINT Key3 PRIMARY KEY (Nr_Rachunku)
;

-- Table Wyciagi

CREATE TABLE Wyciagi(
 Nr_wyciagu Bigint NOT NULL,
 Kwota Double precision NOT NULL,
 Data Date NOT NULL,
 Opis Text,
 Skladka Double precision NOT NULL,
 AWRSP Double precision NOT NULL,
 Wpisowe Double precision NOT NULL,
 ene1 Double precision NOT NULL,
 ene2 Bigint NOT NULL,
 Zadluzenie Double precision NOT NULL,
 Licznik Double precision NOT NULL,
 Kontrola Double precision NOT NULL,
 Nr_dzialki Bigint NOT NULL
)
;

-- Create indexes for table Wyciagi

CREATE INDEX IX_Relationship19 ON Wyciagi (Nr_dzialki)
;

-- Add keys for table Wyciagi

ALTER TABLE Wyciagi ADD CONSTRAINT Key4 PRIMARY KEY (Nr_wyciagu)
;

ALTER TABLE Wyciagi ADD CONSTRAINT Nr_wyciagu UNIQUE (Nr_wyciagu)
;

-- Table Dzialki

CREATE TABLE Dzialki(
 Nr_dzialki Bigint NOT NULL,
 Powierzchnia Bigint NOT NULL,
 Nr_Dzialkowicza Bigint
)
;

-- Create indexes for table Dzialki

CREATE INDEX IX_Relationship5 ON Dzialki (Nr_Dzialkowicza)
;

-- Add keys for table Dzialki

ALTER TABLE Dzialki ADD CONSTRAINT Key5 PRIMARY KEY (Nr_dzialki)
;

ALTER TABLE Dzialki ADD CONSTRAINT Nr_dzialki UNIQUE (Nr_dzialki)
;

-- Table Wlasciciel

CREATE TABLE Wlasciciel(
 Nr_Dzialkowicza Bigint NOT NULL,
 Imie Text,
 Nazwisko Text,
 Ulica Text,
 Dom Bigint,
 Lokal Bigint,
 Kod Text,
 Korespondencja Text,
 Telefon Bigint,
 Email Text,
 Nr_Rachunku Bigint NOT NULL
)
;

-- Create indexes for table Wlasciciel

CREATE INDEX IX_Relationship17 ON Wlasciciel (Nr_Rachunku)
;

-- Add keys for table Wlasciciel

ALTER TABLE Wlasciciel ADD CONSTRAINT Key6 PRIMARY KEY (Nr_Dzialkowicza)
;

-- Table Konto_Uzytkownika

CREATE TABLE Konto_Uzytkownika(
 Login Text NOT NULL,
 Password Text NOT NULL,
 Role Text NOT NULL,
 Enabled Boolean NOT NULL,
 Nr_Dzialkowicza Bigint NOT NULL
)
;

-- Create indexes for table Konto_Uzytkownika

CREATE INDEX IX_Relationship18 ON Konto_Uzytkownika (Nr_Dzialkowicza)
;

-- Add keys for table Konto_Uzytkownika

ALTER TABLE Konto_Uzytkownika ADD CONSTRAINT Key7 PRIMARY KEY (Nr_Dzialkowicza)
;

-- Table Naleznosc

CREATE TABLE Naleznosc(
 Nr_Naleznosci Bigint NOT NULL,
 Rok_Rozliczenia Bigint NOT NULL,
 Bilans_Otwarcia Double precision NOT NULL,
 Skladka Double precision NOT NULL,
 Czynsz Double precision NOT NULL,
 ANR Double precision NOT NULL,
 Wpisowe Double precision NOT NULL,
 Ene1 Double precision NOT NULL,
 Ene2 Double precision NOT NULL,
 Dyzur_Poprzedni_Rok Double precision NOT NULL,
 Dyzur_Aktualny_Rok Double precision NOT NULL,
 Zadluzenie Double precision NOT NULL,
 Zobowiazania_z_BO Double precision NOT NULL,
 Suma_Wplat Double precision NOT NULL,
 Saldo Double precision NOT NULL,
 Nr_dzialki Bigint NOT NULL
)
;

-- Create indexes for table Naleznosc

CREATE INDEX IX_Relationship22 ON Naleznosc (Nr_dzialki)
;

-- Add keys for table Naleznosc

ALTER TABLE Naleznosc ADD CONSTRAINT Key8 PRIMARY KEY (Nr_Naleznosci)
;

-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE Dzialki ADD CONSTRAINT Relationship5 FOREIGN KEY (Nr_Dzialkowicza) REFERENCES Wlasciciel (Nr_Dzialkowicza) ON DELETE NO ACTION ON UPDATE NO ACTION
;


ALTER TABLE Wlasciciel ADD CONSTRAINT Relationship17 FOREIGN KEY (Nr_Rachunku) REFERENCES Numer_rachunku (Nr_Rachunku) ON DELETE NO ACTION ON UPDATE NO ACTION
;


ALTER TABLE Konto_Uzytkownika ADD CONSTRAINT Relationship18 FOREIGN KEY (Nr_Dzialkowicza) REFERENCES Wlasciciel (Nr_Dzialkowicza) ON DELETE NO ACTION ON UPDATE NO ACTION
;


ALTER TABLE Wyciagi ADD CONSTRAINT Relationship19 FOREIGN KEY (Nr_dzialki) REFERENCES Dzialki (Nr_dzialki) ON DELETE NO ACTION ON UPDATE NO ACTION
;


ALTER TABLE Odczyty_licznika ADD CONSTRAINT Relationship20 FOREIGN KEY (Nr_dzialki) REFERENCES Dzialki (Nr_dzialki) ON DELETE NO ACTION ON UPDATE NO ACTION
;


ALTER TABLE Naleznosc ADD CONSTRAINT Relationship22 FOREIGN KEY (Nr_dzialki) REFERENCES Dzialki (Nr_dzialki) ON DELETE NO ACTION ON UPDATE NO ACTION
;


ALTER TABLE Wplywy ADD CONSTRAINT Relationship23 FOREIGN KEY (Nr_Rachunku) REFERENCES Numer_rachunku (Nr_Rachunku) ON DELETE NO ACTION ON UPDATE NO ACTION
;





