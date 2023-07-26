<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

// Seeder per la tabella Aziende.
class FactoriesSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // Per caricare le immagini varie, ho bisogno di caricarle dal progetto.
        // Verranno poi trasformate in BLOB binari successivamente all'inserimento nel database.
        $huaweiLogo = file_get_contents(base_path("database/data/huawei.png"));
        $justEatLogo = file_get_contents(base_path("database/data/justeat.png"));
        $adidasLogo = file_get_contents(base_path("database/data/adidas.png"));
        $appleLogo = file_get_contents(base_path("database/data/apple.png"));
        $microsoftLogo = file_get_contents(base_path("database/data/microsoft.png"));
        $samsungLogo = file_get_contents(base_path("database/data/samsung.png"));
        $dysonLogo = file_get_contents(base_path("database/data/dyson.png"));
        $dwLogo = file_get_contents(base_path("database/data/dw.jpg"));
        $epicGamesLogo = file_get_contents(base_path("database/data/epicgames.png"));
        $nikonLogo = file_get_contents(base_path("database/data/nikon.png"));
        $myProteinLogo = file_get_contents(base_path("database/data/myprotein.png"));
        $nikeLogo = file_get_contents(base_path("database/data/nike.png"));
        $oppoLogo = file_get_contents(base_path("database/data/oppo.png"));

        // Creazione tabella Aziende.
        DB::table('aziende') -> insert([
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => 'Servizio online di food delivery, supportato da più di 2500 ristoranti in tutta Italia',
                'nome' => 'Just Eat',
                'ragioneSociale' => 'Just Eat',
                'logo' => $justEatLogo,
                'tipologia' => 'Cibo e Ristorazione',
                'localizzazione' => 'Just Eat Italia: Via Gaetano de Castillia, 23, 20124 Milano MI'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "É una società cinese impegnata nello sviluppo, produzione e commercializzazione di
                                 prodotti, di sistemi e di soluzioni di rete e telecomunicazioni, smartphones ed
                                 elettronica di consumo generale.",
                'nome' => 'Huawei',
                'ragioneSociale' => 'Huawei Tecnologies Corporation, Limited',
                'logo' => $huaweiLogo,
                'tipologia' => 'Informatica',
                'localizzazione' => 'Shenzhen, Cina'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Adidas AG è una multinazionale, fondata e con sede a Herzogenaurach, in Germania, che progetta e produce scarpe, abbigliamento e
                                accessori. È il più grande produttore di abbigliamento sportivo in Europa e il secondo più grande al mondo",
                'nome' => 'Adidas',
                'ragioneSociale' => 'Adidas AG',
                'logo' => $adidasLogo,
                'tipologia' => 'Abbigliamento e Calzature',
                'localizzazione' => 'Herzogenaurach, Germania'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Apple Inc. è un'azienda multinazionale statunitense che produce sistemi operativi, smartphone, computer e dispositivi
                                  multimediali, con sede a Cupertino, in California. È considerata una delle società tecnologiche Big Tech, assieme ad Amazon,
                                  Google e Meta.",
                'nome' => 'Apple',
                'ragioneSociale' => 'Apple Inc.',
                'logo' => $appleLogo,
                'tipologia' => 'Informatica',
                'localizzazione' => 'Cupertino, California, Stati Uniti'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Microsoft sviluppa, produce, supporta e vende o concede in licenza computer software, elettronica di consumo, personal computer
                                 e servizi. I suoi prodotti software più noti sono la linea di sistemi operativi Microsoft Windows, la suite di produttività
                                 personale Microsoft Office e i browser Internet Explorer e Edge; in ambito hardware invece i suoi prodotti più conosciuti sono
                                 la famiglia di console Xbox e i prodotti Microsoft Surface.",
                'nome' => 'Microsoft',
                'ragioneSociale' => 'Microsoft Corporation',
                'logo' => $microsoftLogo,
                'tipologia' => 'Informatica',
                'localizzazione' => 'Redmond, Washington, Stati Uniti'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Samsung produce una vasta gamma di prodotti tra cui smartphone, tablet, computer portatili e fissi, televisori, elettrodomestici e semiconduttori",
                'nome' => 'Samsung',
                'ragioneSociale' => 'Samsung Electronics',
                'logo' => $samsungLogo,
                'tipologia' => 'Informatica',
                'localizzazione' => 'Suwon-si, Corea del Sud'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Dyson è un’azienda britannica che produce elettrodomestici come aspirapolvere, ventilatori, purificatori d’aria e asciugacapelli.",
                'nome' => 'Dyson',
                'ragioneSociale' => 'Dyson Limited',
                'logo' => $dysonLogo,
                'tipologia' => 'Casalingo',
                'localizzazione' => 'PIAZZA GAE AULENTI 4 - 20154 - MILANO (MI)'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "DANIEL WELLINGTON è un marchio svedese di orologi e gioielli che progetta e produce orologi di design con cinturini
                                  intercambiabili e raffinati gioielli dal gusto minimalista ed essenziale.",
                'nome' => 'Daniel Wellington',
                'ragioneSociale' => 'Daniel Wellington',
                'logo' => $dwLogo,
                'tipologia' => 'Orologeria',
                'localizzazione' => 'Stoccolma, Svezia'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Epic Games è un’azienda statunitense che sviluppa videogiochi e motori grafici per videogiochi. È nota soprattutto per il gioco Fortnite
                                  e per il motore grafico Unreal Engine.",
                'nome' => 'Epic Games',
                'ragioneSociale' => 'Epic Games',
                'logo' => $epicGamesLogo,
                'tipologia' => 'Videogiochi',
                'localizzazione' => 'Cary, Carolina del Nord, Stati Uniti'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Nikon è una multinazionale giapponese con sede a Tokyo, specializzata nel settore della fotografia e dell'ottica di
                                  precisione. Fondata il 25 luglio 1917, produce fotocamere, obiettivi fotografici, binocoli, microscopi, lenti correttive,
                                  strumenti di misura, mirini telescopici e semiconduttori.",
                'nome' => 'Nikon',
                'ragioneSociale' => 'Nikon Corporation',
                'logo' => $nikonLogo,
                'tipologia' => 'Fotografia',
                'localizzazione' => 'Minato, Tokyo, Giappone'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Myprotein è un marchio britannico di integratori per bodybuilding che si è sviluppato in una famiglia di marchi,
                                  tra cui Myvitamins, Myvegan, MyPRO e MP Activewear. È stata fondata nel 2004 da Oliver Cookson e acquistata da The Hut Group
                                  nel 2011.",
                'nome' => 'MyProtein',
                'ragioneSociale' => 'MyProtein',
                'logo' => $myProteinLogo,
                'tipologia' => 'Casalingo, Cibo e Ristorazione',
                'localizzazione' => 'Meridian House, Gadbrook Park, Gadbrook Way, Rudheath, Northwich, Cheshire CW9 7RA, UK'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Nike è un’azienda statunitense che produce abbigliamento, scarpe e accessori sportivi.",
                'nome' => 'Nike',
                'ragioneSociale' => 'Nike, Incorporated',
                'logo' => $nikeLogo,
                'tipologia' => 'Abbigliamento e Calzature',
                'localizzazione' => 'Beaverton, Oregon, Stati Uniti'
            ],
            [
                'id' => NULL,
                'managerUsername' => 'adminadmin',
                'descrizione' => "Oppo è un'azienda cinese di elettronica di consumo con sede a Dongguan che produce smartphone, dispositivi audio,
                                  power bank, lettori multimediali e altri prodotti elettronici. È un importante produttore di smartphone in Cina.",
                'nome' => 'Oppo',
                'ragioneSociale' => 'Oppo',
                'logo' => $oppoLogo,
                'tipologia' => 'Informatica',
                'localizzazione' => 'Dongguan, Cina'
            ]
        ]);
    }
}
