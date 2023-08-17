import 'package:SkiTracker/database/DbHelper.dart';
import 'package:SkiTracker/dialogs.dart';
import 'package:SkiTracker/models/Comprensorio.dart';
import 'package:SkiTracker/utility/OsmXmlAnalyzer.dart';
import 'package:SkiTracker/utility/SkiAreaGetter.dart';
import 'package:xml/xml.dart' as xml;
import 'package:flutter/material.dart';
import 'models/Pista.dart';

class SceltaComprensorio extends StatefulWidget {
  const SceltaComprensorio({super.key, required this.title});
  final String title;
  @override
  State<SceltaComprensorio> createState() => _SceltaComprensorioState();
}

class _SceltaComprensorioState extends State<SceltaComprensorio> {
  final Color titleColor = Colors.white;

  // per la ricerca dei comprensori sulla lista
  TextEditingController _textEditingController = TextEditingController();
  // Lista che si aggiorna dopo la ricerca
  List<Comprensorio> comprensoriOnSearch = [];

  // Elenco dei comprensori
  List<Comprensorio> comprensori = [];

  // questa variabile indica se ci sono delle attività di ottenimento dati in corso.
  bool isLoading = false;

  void initState() {
    super.initState();
    setListaComprensori();
  }

  Future<void> setListaComprensori() async {
    List<Comprensorio> comprensoriFromDb =
        await DbHelper().getListaComprensori();
    setState(() {
      this.comprensori = comprensoriFromDb;
    });
  }

  Future<void> setComprensorioSelezionato(int idComprensorio) async {
    // imposto l'ID del comprensorio selezionato sul db
    DbHelper().setComprensorioSelezionato(idComprensorio);

    // ottengo i dettagli del comprensorio che ho selezionato
    final selectedSkiArea =
        await DbHelper().getDettagliComprensorio(idComprensorio);

    try {
      // ottengo l'elenco di piste del comprensorio e le inserisco sul DB
      xml.XmlDocument skiAreaXml = await SkiAreaGetter().getSkiAreaXML(
          selectedSkiArea!.latitudine,
          selectedSkiArea.longitudine,
          selectedSkiArea.zoom);
      List<Pista> listaPiste =
          OsmXmlAnalyzer().getPisteList(skiAreaXml, idComprensorio);
      selectedSkiArea.setPisteList(listaPiste);
      await DbHelper().insertPiste(idComprensorio, listaPiste);

      // chiudo questa vista e ritorno alla home
      Navigator.pop(context, selectedSkiArea);
    } on Exception catch (e) {
      AppDialogs().openDialog(context, "Errore",
          "Impossibile recuperare la lista di piste: ${e.toString()}");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromRGBO(203, 235, 236, 1.0),
      appBar: AppBar(
        iconTheme: IconThemeData(
          color: Colors.white,
        ),
        title: Container(
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(30),
          ),
          child: TextField(
            style: TextStyle(color: Colors.white),
            onChanged: (value) {
              setState(() {
                comprensoriOnSearch = comprensori
                    .where((element) => element.nome
                        .toLowerCase()
                        .contains(value.toLowerCase()))
                    .toList();
              });
            },
            controller: _textEditingController,
            decoration: InputDecoration(
                border: InputBorder.none,
                errorBorder: InputBorder.none,
                enabledBorder: InputBorder.none,
                focusedBorder: InputBorder.none,
                contentPadding: EdgeInsets.all(15),
                hintText: 'Cerca qui il comprensorio',
                hintStyle: TextStyle(color: Colors.white)),
          ),
        ),
        backgroundColor: Color.fromRGBO(44, 124, 163, 1.0),
      ),
      body: Column(children: [
        Visibility(
          visible: this.isLoading,
          child: LinearProgressIndicator(),
        ),
        Expanded(
          child: _textEditingController.text.isNotEmpty &&
                  comprensoriOnSearch.isEmpty
              ? Center(
                  child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(
                      Icons.search_off,
                      size: 60,
                      color: Colors.red,
                    ),
                    Text(
                      'Nessun comprensorio trovato',
                      style: TextStyle(
                        fontSize: 25,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ],
                ))
              : ListView.builder(
                  itemCount: _textEditingController.text.isNotEmpty
                      ? comprensoriOnSearch.length
                      : comprensori.length,
                  itemBuilder: (context, index) {
                    return GestureDetector(
                        onTap: () {
                          late int selectedId;

                          if (_textEditingController.text.isNotEmpty)
                            selectedId = comprensoriOnSearch[index].id;
                          else
                            selectedId = comprensori[index].id;

                          setState(() {
                            this.isLoading = true;
                          });

                          this.setComprensorioSelezionato(selectedId);
                        },
                        child: Row(
                          children: [
                            CircleAvatar(
                              child: Icon(Icons.downhill_skiing_outlined),
                            ),
                            SizedBox(
                              width: 10,
                            ),
                            Text(
                              _textEditingController.text.isNotEmpty
                                  ? comprensoriOnSearch[index].nome
                                  : comprensori[index].nome,
                              style: TextStyle(
                                fontSize: 20,
                                color: Colors.black,
                              ),
                            ),
                          ],
                        ));
                  }),
        )
      ]),
    );
  }
}
