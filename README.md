# Workshop3

HEADER.JSPF

- Logo linksboven
- Winkelwagen button + totaalprijs rechtsboven -> naar pagina WINKELWAGEN.JSP
- Inlog/registratiefunctie middenboven -> naar pagina INLOGGEN.JSP of REGISTREREN.JSP
	- Na inloggen "welkom, [klant]" middenboven -> naar pagina ACCOUNT.JSP
	
FOOTER.JSPF

- Copyright Khufu & Dochters

INDEX.JSP

- Knop "SHOP NOW" rechtsmidden

SHOP.JSP

- Welkomsttekst linkerkolom
- Tabel met artikelen + knop "in winkelwagen" rechterkolom

WINKELWAGEN.JSP													//Singleton session (unieke URL)

- Tabel met bestelde artikelen + aantallen & totaalprijs
	- Mogelijkheid aanpassen in tabel zelf (?)
- Totaalprijs gehele bestelling
- Knop "bestellen" -> naar pagina BESTELLING.JSP
- Wanneer niet ingelogd errorpage [NIETINGELOGD.JSP] "U dient eerst in te loggen of een account aan te maken" -> links naar INLOGGEN.JSP of REGISTREREN.JSP

BESTELLING.JSP													//Singleton session (unieke URL)

- Tabel met overzicht bestelling
- Knop "terug" -> naar pagina WINKELWAGEN.JSP
- Knop "bevestigen & afrekenen" -> naar pagina BETALING.JSP

BETALING.JSP

- Betaalwijze kiezen ("lege" functionaliteit; doet nl. niets)
- Knop afrekenen -> naar pagina FACTUURBEVESTIGING.JSP

FACTUURBEVESTIGING.JSP 									//Singleton session (unieke URL)

- Display factuur met:
	* Factuur ID	
	* Bestelling ID
	* Klantnaam
	* Adres
	* Bestelling (aantallen + totaalprijs)
	* Betaalwijze + betaaldatum
- Knop "terug naar webwinkel" -> naar pagina SHOP.JSP

ACCOUNT.JSP 													  //Singleton session (unieke URL)

- Tabel met klant- en adresgegevens rechterkolom
- Knop "aanpassen" -> naar pagina GEGEVENSAANPASSEN.JSP
- Lijst met facturen en bestellingen linkerkolom
- Knop "bekijk factuur" -> naar pagina KLANTFACTUUR.JSP
- Knop "bekijk bestelling" -> naar pagina KLANTBESTELLING.JSP

KLANTFACTUUR.JSP											  //Singleton session (unieke URL op basis van factuur ID)

- Opent in nieuw venster
- Display de aangevraagde factuur met:
	* Factuur ID	
	* Bestelling ID
	* Klantnaam
	* Adres
	* Bestelling (aantallen + totaalprijs)
	* Betaalwijze + betaaldatum

KLANTBESTELLING.JSP										  //Singleton session (unieke URL op basis van bestelling ID)

- Opent in nieuw venster
- Display de aangevraagde bestelling met:
	* Bestelling ID
	* "Op Factuur [FactuurID]"
	* Klantnaam
	* Bestelling (aantallen + totaalprijs)
	* Betaalwijze + betaaldatum
	* Verzonden JA/NEE (altijd JA :P)
