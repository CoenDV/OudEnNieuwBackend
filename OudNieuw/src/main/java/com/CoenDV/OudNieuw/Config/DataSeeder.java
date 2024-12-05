package com.CoenDV.OudNieuw.Config;

import com.CoenDV.OudNieuw.Models.*;
import com.CoenDV.OudNieuw.Models.Enums.ObjectType;
import com.CoenDV.OudNieuw.Models.Enums.Role;
import com.CoenDV.OudNieuw.Repositories.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class DataSeeder implements ApplicationRunner {

    UserRepository userRepository;
    QuizRepository quizRepository;
    QuestionRepository questionRepository;
    ShopRepository shopRepository;
    ChallengeRepository challengeRepository;

    public DataSeeder(UserRepository userRepository, QuizRepository quizRepository, QuestionRepository questionRepository, ShopRepository shopRepository, ChallengeRepository challengeRepository) {
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.shopRepository = shopRepository;
        this.challengeRepository = challengeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // USERS
        List<User> users = List.of(
                new User(1, "Melvin", "80085", Role.ROLE_USER, 1000, null, 0, 0, 0),
                new User(2, "Jeffrey", "roxyro", Role.ROLE_USER, 0, null, 0, 0, 0),
                new User(3, "Daniel", "69420", Role.ROLE_USER, 0, null, 0, 0, 0),
                new User(4, "Bjorn", "borg", Role.ROLE_USER, 0, null, 0, 0, 0),
                new User(5, "Quinty", "LN4", Role.ROLE_USER, 0, null, 0, 0, 0),
                new User(6, "Femke", "tequila", Role.ROLE_USER, 0, null, 0, 0, 0)
        );

        userRepository.saveAll(users);

        // SHOP ITEMS
        List<ShopItem> shopItems = List.of(
                new ShopItem(1, "Slokken", "Deel 3 slokken uit, verdeeld of niet", 50, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(2, "Shotje 20", "Deel 1 shotje van min 20% uit", 80, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(3, "Shot Roulette", "Kies een speler uit om aan het rad te draaien", 100, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(4, "Steen Papier Schaar", "Best of 3, verliezer neemt 3 slokken", 40, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(5, "Rondje Shotjes", "Iedereen neemt een shotje van min 20%, ja ook jij", 180, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(6, "Snake Eyes", "Activeer snake eyes voor jezelf, als iemand je aan kijkt neemt dat persoon een slok, 15min", 75, ObjectType.SHOPITEM, LocalTime.of(0, 15)),
                new ShopItem(7, "Bussen", "Kom op dat weet je wel", 300, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(8, "Atje", "Laat iemand een atje zetten", 150, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(9, "Spicy", "Laat iemand een theelepel pittige saus eten", 50, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(10, "Krokodil", "Speel het krokodillen spel totdat er iemand moet drinken", 75, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(11, "Double Or Nothing", "Kies een speler om een munt op te gooien. Als het kop is, moet hij/zij dubbel drinken voor 5 minuten; als het munt is, hoeft hij/zij niet te drinken.", 100, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(12, "Pauze", "Neem een pauze van 30 minuten waarin jij niet hoeft te drinken, maar iemand anders wel voor jou moet drinken wanneer jij normaal zou moeten drinken", 300, ObjectType.SHOPITEM, LocalTime.of(0, 5)),
                new ShopItem(13, "BDSM", "boei 2 mensen samen voor 10 minuten", 30, ObjectType.SHOPITEM, LocalTime.of(0, 10)),
                new ShopItem(14, "Cupido", "Kies 2 mensen die plotseling diep verliefd worden en graag alles samen willen drinken", 100, ObjectType.SHOPITEM, LocalTime.of(0, 15)),
                new ShopItem(15, "Midget Bierpong", "Speel een potje bierpong met 3 cups, verliezer drinkt 3 extra slokken", 75, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(16, "Zwakke hand", "Iedereen moet de komende 15 minuten met hun niet dominante hand drinken, doe je dit niet moet je een extra slok nemen", 75, ObjectType.SHOPITEM, LocalTime.of(0, 15)),
                new ShopItem(17, "No Brainer", "Voor de volgende quiz moet de gekozen speler een slok nemen per fout antwoord", 150, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(18, "Oome Geert", "Verzin een regel die de komende 15 minuten geldt", 100, ObjectType.SHOPITEM, LocalTime.of(0, 15)),
                new ShopItem(19, "English or Spanish", "Iedereen moet stil blijven zitten, de eerste die beweegt moet drinken", 100, ObjectType.SHOPITEM, LocalTime.of(0, 0)),
                new ShopItem(100, "Mystery Box", "Wie weet wat er allemaal in kan zitten", 250, ObjectType.SHOPITEM, LocalTime.of(0, 0)) // Must always be last index so it cant be selected by random roll
        );

                shopRepository.saveAll(shopItems);

        // CHALLENGES
        List<Challenge> challenges = List.of(
                new Challenge(1, "ONKN", "Teddy bear", "Geef 1 persson 5x een knuffel, binnen 1 uur", LocalTime.of(1, 0), 100, false),
                new Challenge(2, "ONWRM", "Waarom pakt hij dit aan?", "Geef iemand een random object aan zonder dat de ander er bewust van is dat ze het aanpakken, bijvoorbeeld tijdens het bellen. Bonus punten voor vreemde objecten.", LocalTime.of(2, 0), 200, false),
                new Challenge(3, "ONMV", "Melvin houdt van eten", "Melvin houdt van eten, het is jou doel om minimaal 1 goede hap van hem te stelen ZONDER dat hij het doorheeft", LocalTime.of(2, 0), 300, false),
                new Challenge(4, "ONDR", "Drogeer challenge", "Gebruik het zout uit het zakje om iemands drankje te spiken, je wint wanneer je doelwit een slok neemt", LocalTime.of(1, 0), 200, false),
                new Challenge(5, "ONUNO", "Uno Reverse Card", "Zet deze in wanneer er een shop item tegen je gebruikt wordt, dat persoon mag nu zijn eigen opdracht uitvoeren.", LocalTime.of(1, 0), 0, false),
                new Challenge(6, "ONMT", "Moppentapper", "vertel tussen gesprekken door 3 moppen, als 3 of meer mensen in totaal lachen heb je gewonnen.", LocalTime.of(1, 0), 75, false),
                new Challenge(7, "ONGL", "Glimlachen", "glimlach 5 minuten lang zonder dat iemand het opvalt, als iemand je er op aanspreekt heb je verloren.", LocalTime.of(0, 30), 100, false),
                new Challenge(8, "ONAT", "Atleet", "Overtuig een paar mensen dat je een handstand kan doen, wanneer 3 mensen kijken heb je gewonnen.", LocalTime.of(1, 0), 100, false),
                new Challenge(9, "ONWL", "Wat lief", "Geef 1 iemand 5 complimenten in 30 minuten, als je er op aangesproken wordt ", LocalTime.of(0, 30), 150, false),
                new Challenge(10, "ONSN", "Sticky notes", "Schrijf iets raars of grappigs op de sticky note en plak het op iemands rug zonder dat dat persoon het door heeft.", LocalTime.of(0, 30), 150, false),
                new Challenge(11, "ONDN", "Deez nuts", "Je hebt een uur om iemand in je deez nuts, of vergelijkbaar, grapje te laten trappen.", LocalTime.of(1, 0), 100, false),
                new Challenge(12, "ONKK", "Karaoke koning(in)", "Zing een liedje luidop en probeer anderen mee te laten zingen. Als minstens één persoon meezingt, heb je gewonnen. Je mag natuurlijk muziek gebruiken, zonder is bonus punten", LocalTime.of(1, 0), 150, false),
                new Challenge(13, "ONVP", "Vies peuk", "Overtuig iemand een kledingstuk uit te laten doen.", LocalTime.of(1, 0), 100, false),
                new Challenge(14, "ONBI", "Bad Influence", "Overtuig 3 mensen om samen een shotje te nemen.", LocalTime.of(1, 0), 100, false),
                new Challenge(15, "ONTE", "Too Eazy", "Zeg tijdens een quiz of ander spel 5x dit is te makkelijk", LocalTime.of(1, 0), 50, false)
                );

        challengeRepository.saveAll(challenges);

        // QUESTIONS
        List<Question> questionsQuizOne = List.of(
                new Question(1, "Hoeveel hamburgers verkoopt McDonalds wereldwijd per seconde?", "75",
                        List.of("75", "100", "50", "25"), "McDonalds verkoopt wereldwijd ongeveer 75 hamburgers per seconde.", ObjectType.QUESTION),
                new Question(2, "Hoeveel liter bier wordt er door Heineken in een jaar gemaakt?", "1,35 miljard liter",
                        List.of("1 miljard liter", "1,35 miljard liter", "2 miljard liter", "3 miljard liter"),
                        "Heineken produceert jaarlijks 1,35 miljard liter bier.", ObjectType.QUESTION),
                new Question(3, "Waar staat de afkorting BOB voor als we het hebben over iemand die niet drinkt?", "Bewust Onbeschonken Bestuurder",
                        List.of("Bewust Onbeschonken Bestuurder", "Beter Ondersteunend Beleid", "Bestuurder Onder Controle", "Bezorgde Openbare Burger"),
                        "De afkorting BOB staat voor Bewust Onbeschonken Bestuurder.", ObjectType.QUESTION),
                new Question(4, "Als je niest, hoeveel km/uur gaat zo'n nies dan je lichaam uit?", "150 km/h",
                        List.of("100 km/h", "120 km/h", "150 km/h", "180 km/h"),
                        "Een nies kan een snelheid van 150 km/uur bereiken.", ObjectType.QUESTION),
                new Question(5, "Welke cocktail is gemaakt van rum, limoensap, rietsuiker, spuitwater en munt met veel ijs?", "Mojito",
                        List.of("Margarita", "Mojito", "Caipirinha", "Cuba Libre"),
                        "De Mojito is een bekende cocktail op basis van rum.", ObjectType.QUESTION),
                new Question(6, "In welke Europese hoofdstad ontstond de cappuccino?", "Wenen",
                        List.of("Rome", "Parijs", "Wenen", "Madrid"),
                        "De cappuccino vindt zijn oorsprong in Wenen.", ObjectType.QUESTION),
                new Question(7, "Hoeveel suikerklontjes bevat een blikje cola van 0,33 liter ongeveer?", "Ongeveer 7 suikerklontjes",
                        List.of("6 suikerklontjes", "7 suikerklontjes", "8 suikerklontjes", "9 suikerklontjes"),
                        "Een blikje cola van 0,33 liter bevat ongeveer 7 suikerklontjes.", ObjectType.QUESTION),
                new Question(8, "Waar vinden de Olympische spelen van 2024 plaats?", "Parijs",
                        List.of("Parijs", "Los Angeles", "Tokyo", "Brisbane"),
                        "De Olympische Spelen van 2024 worden in Parijs gehouden.", ObjectType.QUESTION),
                new Question(9, "In welk jaar was de eerste aflevering van Het Klokhuis?", "1988",
                        List.of("1988", "1985", "1990", "1992"),
                        "Het Klokhuis ging voor het eerst in 1988 op televisie.", ObjectType.QUESTION),
                new Question(10, "Welke achternaam komt in Nederland het meest voor?", "De Jong",
                        List.of("De Jong", "Jansen", "Van den Berg", "Bakker"),
                        "De achternaam 'De Jong' komt het vaakst voor in Nederland.", ObjectType.QUESTION),
                new Question(11, "Wat is de beste combinatie van vijf kaarten in een spel poker?", "De Royal Flush",
                        List.of("De Royal Flush", "Four of a Kind", "Full House", "Straight Flush"),
                        "De Royal Flush is de beste combinatie in poker.", ObjectType.QUESTION),
                new Question(12, "Een raketwerper wordt in het Engels aangeduid als 'RPG Launcher'. Waar staat RPG voor?", "Rocket Proppelled Grenade",
                        List.of("Rocket Proppelled Grenade", "Rapid Projectile Gun", "Rocket Powered Gun", "Remote Projectile Grenade"),
                        "RPG staat voor Rocket Proppelled Grenade.", ObjectType.QUESTION),
                new Question(13, "Hoeveel seizoenen heeft de tv-serie 'Friends'?", "10",
                        List.of("10", "8", "12", "9"),
                        "De serie 'Friends' heeft in totaal 10 seizoenen.", ObjectType.QUESTION),
                new Question(14, "Wat is de hoofdstad van Canada?", "Ottawa",
                        List.of("Ottawa", "Toronto", "Vancouver", "Montreal"),
                        "De hoofdstad van Canada is Ottawa.", ObjectType.QUESTION),
                new Question(15, "Door welke brouwerij wordt Amstel bier gebrouwen?", "Heineken brouwerij in 's-Hertogenbosch",
                        List.of("Heineken brouwerij in 's-Hertogenbosch", "Amstel brouwerij in Amsterdam", "Grolsch brouwerij in Enschede", "Hertog Jan brouwerij in Arcen"),
                        "Amstel bier wordt gebrouwen door de Heineken brouwerij in 's-Hertogenbosch.", ObjectType.QUESTION),
                new Question(16, "Hoeveel minuten zijn er in een week?", "10.080",
                        List.of("10.080", "8.640", "9.600", "11.520"),
                        "Een week bestaat uit 10.080 minuten.", ObjectType.QUESTION),
                new Question(17, "Hoeveel Michelinsterren kan een sterrenrestaurant krijgen?", "3",
                        List.of("3", "5", "4", "2"),
                        "Een restaurant kan maximaal 3 Michelinsterren krijgen.", ObjectType.QUESTION),
                new Question(18, "Welk drankje krijg je als je dropshot en pisang ambon mixt?", "Apenshot",
                        List.of("Apenshot", "Groene banaan", "Zwarte banaan", "Sambon"),
                        "Een mix van dropshot en pisang ambon heet een Apenshot.", ObjectType.QUESTION),
                new Question(19, "Wat is de verste ejaculatie?", "6 meter",
                        List.of("6 meter", "4 meter", "5 meter", "3 meter"),
                        "", ObjectType.QUESTION),
                new Question(20, "Welke Russische Tennisster won in 2014 Roland Garros?", "Maria Sjarapova",
                        List.of("Maria Sjarapova", "Anna Kournikova", "Svetlana Kuznetsova", "Dinara Safina"),
                        "Maria Sjarapova won Roland Garros in 2014.", ObjectType.QUESTION)
        );

        List<Question> questionsQuizTwo = List.of(
                new Question(21, "Uit welk land komt de drank ouzo?", "Griekenland",
                        List.of("Griekenland", "Italië", "Turkije", "Spanje"),
                        "Ouzo is een traditionele drank uit Griekenland.", ObjectType.QUESTION),
                new Question(22, "Wat is de volledige naam van de pop Barbie?", "Barbara Millicent Roberts",
                        List.of("Barbara Millicent Roberts", "Barbie Ann Parker", "Barbara Roberta Smith", "Barbara Marie Johnson"),
                        "Barbie's volledige naam is Barbara Millicent Roberts.", ObjectType.QUESTION),
                new Question(23, "In welke Belgische stad loopt er een ondergrondse bierpijplijn van ruim 3km?", "Brugge",
                        List.of("Brugge", "Antwerpen", "Gent", "Leuven"),
                        "De bierpijplijn bevindt zich in Brugge.", ObjectType.QUESTION),
                new Question(24, "Wat is de snelheid van sperma als een man klaar komt?", "45 km/h",
                        List.of("45 km/h", "50 km/h", "35 km/h", "30 km/h"),
                        "De snelheid van sperma kan oplopen tot 45 km/h.", ObjectType.QUESTION),
                new Question(25, "Wat is het minimum alcoholgehalte bij likeur?", "15%",
                        List.of("15%", "10%", "20%", "25%"),
                        "Likeur moet minimaal 15% alcohol bevatten.", ObjectType.QUESTION),
                new Question(26, "Wat is het kleinste land ter wereld?", "Vaticaanstad",
                        List.of("Vaticaanstad", "Monaco", "San Marino", "Liechtenstein"),
                        "Vaticaanstad is het kleinste land ter wereld.", ObjectType.QUESTION),
                new Question(27, "Hoeveel pootjes heeft een garnaal?", "10",
                        List.of("10", "8", "12", "6"),
                        "Een garnaal heeft 10 pootjes.", ObjectType.QUESTION),
                new Question(28, "Uit hoeveel procent goud bestaat een gouden medaille op de Olympische Spelen?", "1,34%",
                        List.of("1,34%", "5%", "10%", "50%"),
                        "Een gouden medaille bevat slechts 1,34% goud.", ObjectType.QUESTION),
                new Question(29, "Wat is de hoofdstad van Australië?", "Canberra",
                        List.of("Canberra", "Sydney", "Melbourne", "Brisbane"),
                        "De hoofdstad van Australië is Canberra.", ObjectType.QUESTION),
                new Question(30, "Wat is de heetste peper ter wereld?", "Carolina Reaper",
                        List.of("Carolina Reaper", "Ghost Pepper", "Habanero", "Jalapeño"),
                        "De Carolina Reaper is officieel de heetste peper ter wereld.", ObjectType.QUESTION),
                new Question(31, "Wat is het hoofdingrediënt van bier?", "water",
                        List.of("water", "mout", "hop", "gist"),
                        "Water is het belangrijkste ingrediënt van bier.", ObjectType.QUESTION),
                new Question(32, "Waarom droegen piraten vaak een ooglapje?", "om in het licht en in het donker te kunnen zien",
                        List.of("om in het licht en in het donker te kunnen zien", "om ooginfecties te voorkomen", "voor intimidatie", "als mode"),
                        "Piraten droegen een ooglapje om snel te kunnen schakelen tussen licht en donker.", ObjectType.QUESTION),
                new Question(33, "Van welk fruit zijn Chardonnay, Malbec en Pinot bekende soorten?", "druiven",
                        List.of("druiven", "appels", "perziken", "pruimen"),
                        "Chardonnay, Malbec en Pinot zijn soorten druiven.", ObjectType.QUESTION),
                new Question(34, "Wat is de meest verkochte auto ter wereld in 2023?", "Tesla Model Y",
                        List.of("Tesla Model Y", "Toyota Corolla", "Ford F-150", "Volkswagen Golf"),
                        "De Tesla Model Y is de meest verkochte auto ter wereld in 2023.", ObjectType.QUESTION),
                new Question(35, "Welke kleuren heeft de Engelse vlag?", "Rood, wit",
                        List.of("Rood, wit", "Rood, wit, blauw", "Rood, blauw", "Wit, blauw"),
                        "De Engelse vlag heeft de kleuren rood en wit.", ObjectType.QUESTION),
                new Question(36, "Als je naar de boeg van een schip kijkt, hoe noem je dan de linkerzijde van het schip?", "Bakboord",
                        List.of("Bakboord", "Stuurboord", "Boegzijde", "Achterzijde"),
                        "De linkerzijde van een schip wordt bakboord genoemd.", ObjectType.QUESTION),
                new Question(37, "Sinds wanneer drinken we bier?", "4500 BC",
                        List.of("4500 BC", "2000 BC", "1000 AD", "1500 AD"),
                        "Bierconsumptie gaat terug tot 4500 BC.", ObjectType.QUESTION),
                new Question(38, "Waar staat de afkorting cc voor in emails?", "Carbon Copy (of ook wel Copie Conforme)",
                        List.of("Carbon Copy (of ook wel Copie Conforme)", "Central Copy", "Copy Communication", "Copy Correspondence"),
                        "CC staat voor Carbon Copy of Copie Conforme.", ObjectType.QUESTION),
                new Question(39, "Welke kleur heeft de teletubbie Laa-Laa?", "geel",
                        List.of("geel", "rood", "paars", "groen"),
                        "Laa-Laa is de gele teletubbie.", ObjectType.QUESTION),
                new Question(40, "Hoeveel van de top 50 meest bezochte websites in 2023 zijn pornosites?", "5",
                        List.of("5", "3", "7", "10"),
                        "In 2023 zijn 5 van de top 50 meest bezochte websites pornosites.", ObjectType.QUESTION)
        );

        List<Question> questionsQuizThree = List.of(
                new Question(41, "Volgens Melvin welk liedje moet het Nederlandse volkslied worden?", "Unox",
                        List.of("Unox", "Het Wilhelmus", "Bicycle Chain", "Tulpen uit Amsterdam"),
                        "Melvin vindt dat Unox het volkslied moet worden.", ObjectType.QUESTION),
                new Question(42, "Wat is het record voor de langste erectie bij een man (tijd)?", "12 uur",
                        List.of("12 uur", "10 uur", "8 uur", "15 uur"),
                        "Het record voor de langste erectie is 12 uur.", ObjectType.QUESTION),
                new Question(43, "Hoeveel calorieën verbrand je gemiddeld tijdens seks?", "Gemiddeld 85",
                        List.of("Gemiddeld 85", "50", "100", "200"),
                        "Gemiddeld verbrand je 85 calorieën, met een verschil tussen mannen en vrouwen.", ObjectType.QUESTION),
                new Question(44, "Wat is de gemiddelde duur van seks?", "3 – 7 min",
                        List.of("3 – 7 min", "1 – 3 min", "7 – 10 min", "10 – 15 min"),
                        "De gemiddelde duur van seks is tussen de 3 en 7 minuten.", ObjectType.QUESTION),
                new Question(45, "Hoeveel satellieten bevinden zich rond de aarde?", "9.780",
                        List.of("9.780", "8.500", "10.200", "7.900"),
                        "Er bevinden zich ongeveer 9.780 satellieten rond de aarde.", ObjectType.QUESTION),
                new Question(46, "Hoeveel tanden heeft een volwassen mens normaal (inclusief verstandskiezen)?", "32",
                        List.of("32", "28", "30", "34"),
                        "Een volwassen mens heeft normaal gesproken 32 tanden.", ObjectType.QUESTION),
                new Question(47, "Hoeveel vakjes telt een schaakspel?", "64",
                        List.of("64", "72", "48", "56"),
                        "Een schaakspel bestaat uit 64 vakjes.", ObjectType.QUESTION),
                new Question(48, "Hoeveel dagen duurt het voordat de aarde om de zon draait?", "365",
                        List.of("365", "366", "364", "367"),
                        "Het duurt 365 dagen voordat de aarde om de zon draait.", ObjectType.QUESTION),
                new Question(49, "Wat is de meest gesproken taal ter wereld?", "Mandarijn Chinees",
                        List.of("Mandarijn Chinees", "Engels", "Spaans", "Hindi"),
                        "Mandarijn Chinees is de meest gesproken taal ter wereld.", ObjectType.QUESTION),
                new Question(50, "Wat betekent tiramisu letterlijk in het Italiaans?", "trek mij omhoog",
                        List.of("trek mij omhoog", "zoete droom", "lekker dessert", "hemelse laagjes"),
                        "Tiramisu betekent letterlijk 'trek mij omhoog' in het Italiaans.", ObjectType.QUESTION),
                new Question(51, "Wat betekent het gerecht 'Chili con carne' in het Nederlands?", "chilipepers met vlees",
                        List.of("chilipepers met vlees", "chilipepers en bonen", "hete saus met vlees", "gekruide chili"),
                        "Chili con carne betekent 'chilipepers met vlees' in het Nederlands.", ObjectType.QUESTION),
                new Question(52, "In welk land vonden allereerste Olympische spelen plaats?", "Griekenland",
                        List.of("Griekenland", "Italië", "Frankrijk", "Spanje"),
                        "De allereerste Olympische Spelen vonden plaats in Griekenland.", ObjectType.QUESTION),
                new Question(53, "Welke vandaag nog levende diersoort staat genetisch gezien het dichtst bij de Tyrannosaurus rex?", "kip",
                        List.of("kip", "krokodil", "arend", "hagedis"),
                        "De kip staat genetisch het dichtst bij de Tyrannosaurus rex.", ObjectType.QUESTION),
                new Question(54, "Wat zijn de enige vogels die achteruit kunnen vliegen?", "Kolibrie",
                        List.of("Kolibrie", "Papegaai", "Arend", "Zwaluw"),
                        "De kolibrie is de enige vogel die achteruit kan vliegen.", ObjectType.QUESTION),
                new Question(55, "Hoeveel procent van de wereldbevolking is op dit moment dronken?", "1%",
                        List.of("1%", "2%", "5%", "0.5%"),
                        "Op dit moment is ongeveer 1% van de wereldbevolking dronken.", ObjectType.QUESTION),
                new Question(56, "Waar wordt het meeste alcohol gedronken?", "platteland",
                        List.of("platteland", "stad", "dorp/voorstad", "kustgebieden"),
                        "Het meeste alcohol wordt gedronken op het platteland.", ObjectType.QUESTION),
                new Question(57, "Mag je volgens de wet, als je gedronken hebt, nog fietsen?", "Nee",
                        List.of("Nee", "Ja", "Ja, mits onder de limiet", "Ja, maar niet 's nachts"),
                        "Het is wettelijk verboden om te fietsen als je gedronken hebt.", ObjectType.QUESTION),
                new Question(58, "Wat is het nationale dier van Schotland?", "De eenhoorn",
                        List.of("De eenhoorn", "Het hert", "De adelaar", "De draak"),
                        "De eenhoorn is het nationale dier van Schotland.", ObjectType.QUESTION),
                new Question(59, "Welk Mexicaans eten heeft een naam die 'kleine ezel' betekent?", "Burrito",
                        List.of("Burrito", "Taco", "Quesadilla", "Nacho"),
                        "Burrito betekent letterlijk 'kleine ezel' in het Spaans.", ObjectType.QUESTION),
                new Question(60, "Wat bedoelt een Zuid-Afrikaan als hij het over een 'amperbroekkie' heeft?", "Een g-string of tangaslipje",
                        List.of("Een g-string of tangaslipje", "Een korte broek", "Een zwembroek", "Een kinderbroekje"),
                        "Een 'amperbroekkie' verwijst naar een g-string of tangaslipje.", ObjectType.QUESTION)
        );

        List<Question> questionsQuizBirthday = List.of(
                new Question(61, "Volgens Melvin welk liedje moet het Nederlandse volkslied worden?",
                        "Unox",
                        List.of("Unox", "Bicycle Chain", "Pokemon Song"), "Waarom eigenlijk?", ObjectType.QUESTION),
                new Question(62, "Hoeveel shotjes apenshot heeft Jeffrey gedaan op Koningsdag?",
                        "15",
                        List.of("15", "12", "18", "16"), "En zelfs toen had ie nog niet genoeg", ObjectType.QUESTION),
                new Question(63, "Als je Femke blackout drunk wilt hebben, wat kan je het beste halen?",
                        "Bruine vodka",
                        List.of("Bruine vodka", "Tequila", "Gin", "Jonge Jenever"), "Vertel Femke...", ObjectType.QUESTION),
                new Question(64, "Wat is één van de eerste dingen die Melvin deed nadat hij zijn grootste kater had?",
                        "Bench PR zetten",
                        List.of("Bench PR zetten", "Water drinken", "Weer kater zuipen", "Effe hard poepen"), "Hoeveel was het ook alweer?", ObjectType.QUESTION),
                new Question(65, "Hoeveel peuken passen er in ieder geval in Daniels gezicht? (Er is foto bewijs)",
                        "7",
                        List.of("7", "10", "8", "5"), "New record zetten vandaag?", ObjectType.QUESTION),
                new Question(66, "Wat wilden Melvin en Femke liever doen dan leren voor hun wiskunde examen?",
                        "Water gevecht",
                        List.of("Water gevecht", "Naar strand", "Zuipen", "Gwn leren"), "...", ObjectType.QUESTION),
                new Question(67, "Tijdens pubgolf, welk team had er gewonnen?",
                        "Team Coltrui (Melvin Jeffrey)",
                        List.of("Team Coltrui (Melvin Jeffrey)", "Team Hardcore Batsklappers (Daniel Bjorn)", "Team Losers Queue (Femke Coen)"),
                        "Sorry Daniel en Bjorn, het is echt zo", ObjectType.QUESTION),
                new Question(68, "Volgens Melvin, welke drank is lekker naar binnen en naar buiten?",
                        "Peachtree",
                        List.of("Peachtree", "Blue Curacao", "Tequila", "Malibu"), "Vertel maar Melvin", ObjectType.QUESTION),
                new Question(69, "Als je op Utrecht Centraal bent, waar kom je terecht als je naar de tramhalte loopt?",
                        "Fietsenstalling",
                        List.of("De tramhalte duh", "Bushalte", "Fietsenstalling"), "Gelukkig kan ie normaal gwn maps gebruiken", ObjectType.QUESTION),
                new Question(70, "Hoe beschrijft Bjorn Melvins muziek smaak van de jaren 2010?",
                        "Natte krant",
                        List.of("Natte krant", "Vogel poep", "Gay", "Saus"), "Jammer weer, is gwn leuke muziek", ObjectType.QUESTION),
                new Question(71, "Als je naar het strand gaat, wat is het meest belangrijke om mee te nemen?",
                        "Schep",
                        List.of("Schep", "Zonnebrand", "Zwembroek", "Bier"), "gat graven duhh, op de 2de plek staat emmer voor kasteel bouwen of beesten vangen", ObjectType.QUESTION),
                new Question(72, "Wat is het vroegste moment op vakantie dat we beerpong gespeeld hebben?",
                        "11:29",
                        List.of("11:29", "10:51", "12:07", "11:04"), "We hebben geen probleem", ObjectType.QUESTION),
                new Question(73, "Wat zijn Belgen?",
                        "", List.of("kkr dom", "redelijk slim", "goed in wegen bouwen", "onze noorder buren"), "...", ObjectType.QUESTION),
                new Question(74, "Op basis van welke TV show had Femke een game night georganiseerd op vakantie?",
                        "Expeditie Robinson",
                        List.of("Expeditie Robinson", "Wie is de mol?", "Goede Tijden Slechte Tijden", "Lang Leve de Liefde"), "Was leuk gemaakt", ObjectType.QUESTION),
                new Question(75, "Wat is het grootste aantal vissen dat we in 1 dag gevangen hebben?",
                        "24",
                        List.of("24", "22", "25", "23"), "En nog steeds geen snoek", ObjectType.QUESTION),
                new Question(76, "Jeffrey had het de hele vakantie over een maaltijd, en heeft dit kunnen eten in een restaurant, hoe heet dit?",
                        "Foie gras",
                        List.of("Foie gras", "Kikkerbilletjes", "Head Cheese", "Stargazy Pie"), "Kikkerbilletjes: delicatesse in sommige landen, vooral in Frankrijk, Head Cheese: vleesgerecht dat eigenlijk geen kaas is, maar een terrine van gekookt varkenshoofd, Stargazy Pie: vissentaart waarbij de vissenkoppen naar boven uit de taart steken", ObjectType.QUESTION),
                new Question(77, "Wat was de eerste naam bijnaam die Quinty kreeg?",
                        "Quinticy",
                        List.of("Quintosaurus-Rex", "Quintilinie", "Quinticy", "Quinderella"), "gegeven door Belinda, combinatie van Quinty en Quincy", ObjectType.QUESTION),
                new Question(78, "Wat is het thema van de oud en nieuw website?",
                        "",
                        List.of("Youtube", "Mario", "Gala", "TikTok"),
                        "Het juiste antwoord zit er niet tussen", ObjectType.QUESTION)
        );

        questionRepository.saveAll(questionsQuizOne);
        questionRepository.saveAll(questionsQuizTwo);
        questionRepository.saveAll(questionsQuizThree);
        questionRepository.saveAll(questionsQuizBirthday);

        // QUIZ
        Quiz quizOne = new Quiz(1, questionsQuizOne, 0);
        Quiz quizTwo = new Quiz(2, questionsQuizTwo, 0);
        Quiz quizThree = new Quiz(3, questionsQuizThree, 0);
        Quiz quizBirthday = new Quiz(4, questionsQuizBirthday, 0);

        quizRepository.save(quizOne);
        quizRepository.save(quizTwo);
        quizRepository.save(quizThree);
        quizRepository.save(quizBirthday);
    }
}
