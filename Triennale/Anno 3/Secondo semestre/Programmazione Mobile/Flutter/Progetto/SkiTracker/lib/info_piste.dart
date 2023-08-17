import 'package:SkiTracker/models/Comprensorio.dart';
import 'package:SkiTracker/scelta_comprensorio.dart';
import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher_string.dart';
import 'database/DbHelper.dart';
import 'models/Pista.dart';

const double PADDING_VERTICAL = 3;
const double PADDING_HORIZONTAL = 20;
const double INDICATORS_SIZE = 18;

class InfoPiste extends StatefulWidget {
  const InfoPiste({super.key});
  @override
  State<InfoPiste> createState() => _InfoPisteState();
}

class _InfoPisteState extends State<InfoPiste> {
  // Comprensorio selezionato
  Comprensorio? mySkiArea = null;

  void initState() {
    super.initState();
    getSelectedSkiArea();
  }

  Future<void> getSelectedSkiArea() async {
    final id = await DbHelper.getComprensorioSelezionato();

    if (id != null) {
      final skiArea = await DbHelper().getDettagliComprensorio(id);
      List<Pista> listaPiste = await DbHelper().getComprensorioPiste(id);
      skiArea?.setPisteList(listaPiste);

      if (skiArea != null) {
        setState(() {
          this.mySkiArea = skiArea;
        });
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromRGBO(203, 235, 236, 1.0),
      body: Visibility(
        visible: this.mySkiArea != null,
        maintainState: false,
        replacement: Center(
          child: Column(mainAxisAlignment: MainAxisAlignment.center, children: [
            Image.asset(
              'assets/images/select_skiarea.png',
              width: 175,
            ),
            SizedBox(height: 10),
            Text(
              "Tocca il pulsante in basso a destra per selezionare il comprensorio.",
              style: TextStyle(
                fontSize: 17,
              ),
              textAlign: TextAlign.center,
            )
          ]),
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: <Widget>[
            SizedBox(height: 10),
            Padding(
              padding: EdgeInsets.symmetric(
                  vertical: PADDING_VERTICAL, horizontal: PADDING_HORIZONTAL),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Expanded(
                    child: Text(
                      this.mySkiArea?.nome ?? "N/A",
                      overflow: TextOverflow.ellipsis,
                      maxLines: 1,
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        color: Colors.black,
                        fontSize: 28,
                      ),
                    ),
                  ),
                  Text(
                    this.mySkiArea?.aperto == 1 ? "Aperto" : "Chiuso",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                      fontSize: 20,
                      backgroundColor: this.mySkiArea?.aperto == 1
                          ? Colors.green
                          : Colors.red,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 10),
            Padding(
              padding: EdgeInsets.symmetric(
                  vertical: PADDING_VERTICAL, horizontal: PADDING_HORIZONTAL),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    "🏂 Numero di piste: ",
                    style: TextStyle(
                      color: Colors.black,
                      fontSize: INDICATORS_SIZE,
                    ),
                  ),
                  Text(
                    this.mySkiArea?.numPiste.toString() ?? "N/A",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.black,
                      fontSize: INDICATORS_SIZE,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 10),
            Padding(
              padding: EdgeInsets.symmetric(
                  vertical: PADDING_VERTICAL, horizontal: PADDING_HORIZONTAL),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    "🚡 Impianti di risalita: ",
                    style: TextStyle(
                      color: Colors.black,
                      fontSize: INDICATORS_SIZE,
                    ),
                  ),
                  Text(
                    this.mySkiArea?.numImpianti.toString() ?? "N/A",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.black,
                      fontSize: INDICATORS_SIZE,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 10),
            Padding(
              padding: EdgeInsets.symmetric(
                  vertical: PADDING_VERTICAL, horizontal: PADDING_HORIZONTAL),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    "⛰ Altitudine minima: ",
                    style: TextStyle(
                      color: Colors.black,
                      fontSize: INDICATORS_SIZE,
                    ),
                  ),
                  Text(
                    "${this.mySkiArea?.minAltitudine.toString()} m s.l.m.",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.black,
                      fontSize: INDICATORS_SIZE,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 10),
            Padding(
              padding: EdgeInsets.symmetric(
                  vertical: PADDING_VERTICAL, horizontal: PADDING_HORIZONTAL),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    "🏔 Altitudine massima: ",
                    style: TextStyle(
                      color: Colors.black,
                      fontSize: INDICATORS_SIZE,
                    ),
                  ),
                  Text(
                    "${this.mySkiArea?.maxAltitudine.toString()} m s.l.m.",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.black,
                      fontSize: INDICATORS_SIZE,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 10),
            Padding(
              padding: EdgeInsets.symmetric(
                  vertical: PADDING_VERTICAL, horizontal: PADDING_HORIZONTAL),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    "Sito: ",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.black,
                      fontSize: INDICATORS_SIZE,
                    ),
                  ),
                  GestureDetector(
                    onTap: () => launchUrlString(this.mySkiArea!.website),
                    child: Text(
                      this.mySkiArea?.website ?? "N/A",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        color: Colors.blueAccent,
                        fontSize: INDICATORS_SIZE,
                        decoration: TextDecoration.underline,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 10),
            Padding(
              padding: EdgeInsets.symmetric(
                  vertical: PADDING_VERTICAL, horizontal: PADDING_HORIZONTAL),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Visibility(
                    visible: this.mySkiArea?.snowpark == 1,
                    maintainSize: false,
                    child: Text(
                      "✅ Snowpark",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 21,
                      ),
                    ),
                  ),
                  Visibility(
                    visible: this.mySkiArea?.pisteNotturne == 1,
                    maintainSize: false,
                    child: Text(
                      "✅ Piste notturne",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 21,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 10),
            Padding(
              padding: EdgeInsets.symmetric(
                  vertical: PADDING_VERTICAL, horizontal: PADDING_HORIZONTAL),
              child: Text(
                "Elenco piste",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  color: Colors.black,
                  fontSize: 28,
                ),
              ),
            ),
            Expanded(
              child: ListView.builder(
                  itemCount: this.mySkiArea?.listaPiste.length,
                  itemBuilder: (context, index) {
                    return Padding(
                        padding: EdgeInsets.symmetric(
                            vertical: PADDING_VERTICAL,
                            horizontal: PADDING_HORIZONTAL),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Expanded(
                              child: Text(
                                this.mySkiArea!.listaPiste[index].nome,
                                overflow: TextOverflow.ellipsis,
                                maxLines: 1,
                                style: TextStyle(fontSize: 20),
                              ),
                            ),
                            Text(
                              this
                                  .mySkiArea!
                                  .listaPiste[index]
                                  .getDifficultyWithIndicator(),
                              style: TextStyle(fontSize: 20),
                            )
                          ],
                        ));
                  }),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Color.fromRGBO(161, 149, 200, 1.0),
        tooltip: "Cambia comprensorio",
        onPressed: () async {
          final result = await Navigator.push(
            context,
            MaterialPageRoute(
                builder: (context) => SceltaComprensorio(
                      title: 'Scegli Comprensorio',
                    )),
          );

          // controllo se il widget scegliComprensorio ha chiesto di ricaricare questo
          // in seguito alla selezione di un comprensorio
          if (result != null) {
            setState(() {
              this.mySkiArea = result;
            });
          }
        },
        child: const Icon(Icons.change_circle, color: Colors.white),
      ),
    );
  }
}
