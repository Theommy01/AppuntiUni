import 'package:SkiTracker/models/Comprensorio.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart' as path;
import 'dart:io';
import 'package:flutter/services.dart';

import '../models/Pista.dart';

const String USER_ID = "flutteruser";

class DbHelper {
  // Metodo di apertura della connessione al Database.
  static Future<Database> openDB() async {
    final dbPath = await getDatabasesPath();
    final pathToDatabase = path.join(dbPath, 'app.db');

    // Copia il file del database dalla cartella assets alla directory di lavoro
    if (!await File(pathToDatabase).exists()) {
      ByteData data = await rootBundle.load('assets/app.db');
      List<int> bytes = data.buffer.asUint8List(
        data.offsetInBytes,
        data.lengthInBytes,
      );
      await File(pathToDatabase).writeAsBytes(bytes);
    }

    // ottengo l'oggetto database aprendo il file .db copiato in precedenza
    final database = await openDatabase(
      pathToDatabase,
      version: 1
    );

    return database;
  }

  // Ottengo l'ID del comprensorio selezionato dall'utente.
  static Future<int?> getComprensorioSelezionato() async {
    final database = await openDB();
    final results = await database.query("Utente", columns: ["idComprensorio"]);

    if (results.isNotEmpty) {
      return results.firstOrNull?["idComprensorio"] as int?;
    } else {
      return null;
    }
  }

  // Ottengo la lista dei comprensori
  Future<List<Comprensorio>> getListaComprensori() async {
    // apro il db
    Database database = await openDB();
    // eseguo la query
    List<Map<String, dynamic>> results = await database.query("Comprensorio");
    // chiudo il db
    await database.close();
    // mapping risultati da lista sgorbio a classe Comprensorio
    List<Comprensorio> comprensori = results.map((e) =>
      Comprensorio(e['id'], e['nome'], e['aperto'], e['numPiste'], e['numImpianti'], e['website'],
        e['snowpark'], e['pisteNotturne'], e['lat'], e['long'], e['maxAltitudine'], e['minAltitudine'], e['zoom'])
    ).toList();

    return comprensori;
  }

  // Imposto l'ID del comprensorio selezionato per l'utente
  Future<void> setComprensorioSelezionato(int idComprensorio) async {
    // apro il db
    Database database = await openDB();

    // aggiorno il valore idComprensorio per l'utente
    await database.update('Utente', {'idComprensorio': idComprensorio}, where: 'id = "$USER_ID"');

    // chiudo il db
    await database.close();
  }

  // Ottiene i dettagli di un comprensorio dato il suo ID.
  Future<Comprensorio?> getDettagliComprensorio(int id) async {
    // apro il db
    Database database = await openDB();

    // ottengo i dettagli del comprensorio
    final results = await database.query('Comprensorio', where: 'id = $id', limit: 1);
    if (results.isNotEmpty) {
      final comprensorioRow = results.first;
      return Comprensorio.fromMap(comprensorioRow);
    }

    // se non è stato trovato alcun comprensorio...
    return null;
  }

  // Inserisce una lista di piste nel database.
  Future<void> insertPiste(int idComprensorio, List<Pista> listaPiste) async {
    // apro il db
    Database database = await openDB();
    // Inserisco le piste
    for (var pista in listaPiste) {
      await database.insert("Pista", pista.toMap(), conflictAlgorithm: ConflictAlgorithm.ignore);
    }
    // chiudo il db
    database.close();
  }

  // Ottengo la lista delle piste di un certo comprensorio
  Future<List<Pista>> getComprensorioPiste(int idComprensorio) async {
    // apro il db
    Database database = await openDB();

    // Ottengo la lista di piste
    final List<Map<String, dynamic>> result = await database.query('Pista', where: 'idComprensorio = ?', whereArgs: [idComprensorio]);
    final List<Pista> pistaList = result.map((map) =>
        Pista(map['nome'], map['difficolta'], map['id'], map['idComprensorio'])
    ).toList();

    // chiudo il db e ritorno la lista
    database.close();
    return pistaList;
  }

  // Aggiorna il valore dello zoom per un Comprensorio
  Future<void> updateComprensorioZoom(int idComprensorio, int zoom) async {
    // apro il db
    Database database = await openDB();

    // Aggiorno il valore dello zoom
    await database.update('Comprensorio', {'zoom': zoom}, where: 'id = ?', whereArgs: [idComprensorio]);

    // chiudo il db
    database.close();
  }
}