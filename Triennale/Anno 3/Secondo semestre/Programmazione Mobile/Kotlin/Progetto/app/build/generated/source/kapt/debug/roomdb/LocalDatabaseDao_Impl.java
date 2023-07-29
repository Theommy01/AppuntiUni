package roomdb;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LocalDatabaseDao_Impl implements LocalDatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Utente> __insertionAdapterOfUtente;

  private final EntityInsertionAdapter<Comprensorio> __insertionAdapterOfComprensorio;

  private final EntityInsertionAdapter<Pista> __insertionAdapterOfPista;

  private final EntityInsertionAdapter<Tracciamento> __insertionAdapterOfTracciamento;

  private final EntityInsertionAdapter<PuntoMappa> __insertionAdapterOfPuntoMappa;

  private final EntityInsertionAdapter<PuntiMappaTracciamenti> __insertionAdapterOfPuntiMappaTracciamenti;

  private final SharedSQLiteStatement __preparedStmtOfModificaComprensorioSelezionato;

  private final SharedSQLiteStatement __preparedStmtOfUpdateZoomLevel;

  public LocalDatabaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUtente = new EntityInsertionAdapter<Utente>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Utente` (`id`,`tutorialCompletato`,`idComprensorio`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Utente value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        final int _tmp = value.getTutorialCompletato() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        if (value.getIdComprensorio() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getIdComprensorio());
        }
      }
    };
    this.__insertionAdapterOfComprensorio = new EntityInsertionAdapter<Comprensorio>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Comprensorio` (`id`,`nome`,`aperto`,`numPiste`,`numImpianti`,`website`,`snowpark`,`pisteNotturne`,`lat`,`long`,`maxAltitudine`,`minAltitudine`,`zoom`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Comprensorio value) {
        stmt.bindLong(1, value.getId());
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        final int _tmp = value.getAperto() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        stmt.bindLong(4, value.getNumPiste());
        stmt.bindLong(5, value.getNumImpianti());
        if (value.getWebsite() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWebsite());
        }
        final int _tmp_1 = value.getSnowpark() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        final int _tmp_2 = value.getPisteNotturne() ? 1 : 0;
        stmt.bindLong(8, _tmp_2);
        stmt.bindDouble(9, value.getLat());
        stmt.bindDouble(10, value.getLong());
        stmt.bindLong(11, value.getMaxAltitudine());
        stmt.bindLong(12, value.getMinAltitudine());
        stmt.bindLong(13, value.getZoom());
      }
    };
    this.__insertionAdapterOfPista = new EntityInsertionAdapter<Pista>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Pista` (`id`,`nome`,`difficolta`,`idComprensorio`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pista value) {
        stmt.bindLong(1, value.getId());
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getDifficolta() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDifficolta());
        }
        stmt.bindLong(4, value.getIdComprensorio());
      }
    };
    this.__insertionAdapterOfTracciamento = new EntityInsertionAdapter<Tracciamento>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Tracciamento` (`id`,`distanza`,`velocita`,`dislivello`,`dataOraInizio`,`dataOraFine`,`idUtente`,`idPista`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tracciamento value) {
        stmt.bindLong(1, value.getId());
        stmt.bindDouble(2, value.getDistanza());
        stmt.bindDouble(3, value.getVelocita());
        stmt.bindLong(4, value.getDislivello());
        stmt.bindLong(5, value.getDataOraInizio());
        stmt.bindLong(6, value.getDataOraFine());
        if (value.getIdUtente() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getIdUtente());
        }
        stmt.bindLong(8, value.getIdPista());
      }
    };
    this.__insertionAdapterOfPuntoMappa = new EntityInsertionAdapter<PuntoMappa>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `PuntoMappa` (`id`,`latitudine`,`longitudine`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PuntoMappa value) {
        stmt.bindLong(1, value.getId());
        stmt.bindDouble(2, value.getLatitudine());
        stmt.bindDouble(3, value.getLongitudine());
      }
    };
    this.__insertionAdapterOfPuntiMappaTracciamenti = new EntityInsertionAdapter<PuntiMappaTracciamenti>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `PuntiMappaTracciamenti` (`idTracciamento`,`idPuntoMappa`,`timestamp`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PuntiMappaTracciamenti value) {
        stmt.bindLong(1, value.getIdTracciamento());
        stmt.bindLong(2, value.getIdPuntoMappa());
        stmt.bindLong(3, value.getTimestamp());
      }
    };
    this.__preparedStmtOfModificaComprensorioSelezionato = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Utente SET idComprensorio = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateZoomLevel = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Comprensorio SET zoom = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertNewLocalUserInfo(final Utente user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUtente.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertNewComprensorio(final Comprensorio comp) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfComprensorio.insert(comp);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void inserisciPiste(final List<Pista> order) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPista.insert(order);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertNewTracciamento(final Tracciamento track) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfTracciamento.insertAndReturnId(track);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Long> insertPuntiMappa(final List<PuntoMappa> points) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      List<Long> _result = __insertionAdapterOfPuntoMappa.insertAndReturnIdsList(points);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertPuntoMappaForTrack(final PuntiMappaTracciamenti point) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPuntiMappaTracciamenti.insert(point);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void modificaComprensorioSelezionato(final int newSkiAreaId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfModificaComprensorioSelezionato.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, newSkiAreaId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfModificaComprensorioSelezionato.release(_stmt);
    }
  }

  @Override
  public void updateZoomLevel(final int zoom, final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateZoomLevel.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, zoom);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateZoomLevel.release(_stmt);
    }
  }

  @Override
  public int isTutorialCompletato() {
    final String _sql = "SELECT tutorialCompletato FROM Utente";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Integer getIdComprensorio() {
    final String _sql = "SELECT idComprensorio FROM Utente";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Integer _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getInt(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Comprensorio getDettagliComprensorio(final int skiAreaId) {
    final String _sql = "SELECT * FROM Comprensorio WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, skiAreaId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfAperto = CursorUtil.getColumnIndexOrThrow(_cursor, "aperto");
      final int _cursorIndexOfNumPiste = CursorUtil.getColumnIndexOrThrow(_cursor, "numPiste");
      final int _cursorIndexOfNumImpianti = CursorUtil.getColumnIndexOrThrow(_cursor, "numImpianti");
      final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
      final int _cursorIndexOfSnowpark = CursorUtil.getColumnIndexOrThrow(_cursor, "snowpark");
      final int _cursorIndexOfPisteNotturne = CursorUtil.getColumnIndexOrThrow(_cursor, "pisteNotturne");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLong = CursorUtil.getColumnIndexOrThrow(_cursor, "long");
      final int _cursorIndexOfMaxAltitudine = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAltitudine");
      final int _cursorIndexOfMinAltitudine = CursorUtil.getColumnIndexOrThrow(_cursor, "minAltitudine");
      final int _cursorIndexOfZoom = CursorUtil.getColumnIndexOrThrow(_cursor, "zoom");
      final Comprensorio _result;
      if(_cursor.moveToFirst()) {
        _result = new Comprensorio();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpNome;
        if (_cursor.isNull(_cursorIndexOfNome)) {
          _tmpNome = null;
        } else {
          _tmpNome = _cursor.getString(_cursorIndexOfNome);
        }
        _result.setNome(_tmpNome);
        final boolean _tmpAperto;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAperto);
        _tmpAperto = _tmp != 0;
        _result.setAperto(_tmpAperto);
        final int _tmpNumPiste;
        _tmpNumPiste = _cursor.getInt(_cursorIndexOfNumPiste);
        _result.setNumPiste(_tmpNumPiste);
        final int _tmpNumImpianti;
        _tmpNumImpianti = _cursor.getInt(_cursorIndexOfNumImpianti);
        _result.setNumImpianti(_tmpNumImpianti);
        final String _tmpWebsite;
        if (_cursor.isNull(_cursorIndexOfWebsite)) {
          _tmpWebsite = null;
        } else {
          _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
        }
        _result.setWebsite(_tmpWebsite);
        final boolean _tmpSnowpark;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfSnowpark);
        _tmpSnowpark = _tmp_1 != 0;
        _result.setSnowpark(_tmpSnowpark);
        final boolean _tmpPisteNotturne;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfPisteNotturne);
        _tmpPisteNotturne = _tmp_2 != 0;
        _result.setPisteNotturne(_tmpPisteNotturne);
        final double _tmpLat;
        _tmpLat = _cursor.getDouble(_cursorIndexOfLat);
        _result.setLat(_tmpLat);
        final double _tmpLong;
        _tmpLong = _cursor.getDouble(_cursorIndexOfLong);
        _result.setLong(_tmpLong);
        final int _tmpMaxAltitudine;
        _tmpMaxAltitudine = _cursor.getInt(_cursorIndexOfMaxAltitudine);
        _result.setMaxAltitudine(_tmpMaxAltitudine);
        final int _tmpMinAltitudine;
        _tmpMinAltitudine = _cursor.getInt(_cursorIndexOfMinAltitudine);
        _result.setMinAltitudine(_tmpMinAltitudine);
        final int _tmpZoom;
        _tmpZoom = _cursor.getInt(_cursorIndexOfZoom);
        _result.setZoom(_tmpZoom);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Comprensorio> getSkiAreasList() {
    final String _sql = "SELECT * FROM Comprensorio";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfAperto = CursorUtil.getColumnIndexOrThrow(_cursor, "aperto");
      final int _cursorIndexOfNumPiste = CursorUtil.getColumnIndexOrThrow(_cursor, "numPiste");
      final int _cursorIndexOfNumImpianti = CursorUtil.getColumnIndexOrThrow(_cursor, "numImpianti");
      final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
      final int _cursorIndexOfSnowpark = CursorUtil.getColumnIndexOrThrow(_cursor, "snowpark");
      final int _cursorIndexOfPisteNotturne = CursorUtil.getColumnIndexOrThrow(_cursor, "pisteNotturne");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLong = CursorUtil.getColumnIndexOrThrow(_cursor, "long");
      final int _cursorIndexOfMaxAltitudine = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAltitudine");
      final int _cursorIndexOfMinAltitudine = CursorUtil.getColumnIndexOrThrow(_cursor, "minAltitudine");
      final int _cursorIndexOfZoom = CursorUtil.getColumnIndexOrThrow(_cursor, "zoom");
      final List<Comprensorio> _result = new ArrayList<Comprensorio>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Comprensorio _item;
        _item = new Comprensorio();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNome;
        if (_cursor.isNull(_cursorIndexOfNome)) {
          _tmpNome = null;
        } else {
          _tmpNome = _cursor.getString(_cursorIndexOfNome);
        }
        _item.setNome(_tmpNome);
        final boolean _tmpAperto;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAperto);
        _tmpAperto = _tmp != 0;
        _item.setAperto(_tmpAperto);
        final int _tmpNumPiste;
        _tmpNumPiste = _cursor.getInt(_cursorIndexOfNumPiste);
        _item.setNumPiste(_tmpNumPiste);
        final int _tmpNumImpianti;
        _tmpNumImpianti = _cursor.getInt(_cursorIndexOfNumImpianti);
        _item.setNumImpianti(_tmpNumImpianti);
        final String _tmpWebsite;
        if (_cursor.isNull(_cursorIndexOfWebsite)) {
          _tmpWebsite = null;
        } else {
          _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
        }
        _item.setWebsite(_tmpWebsite);
        final boolean _tmpSnowpark;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfSnowpark);
        _tmpSnowpark = _tmp_1 != 0;
        _item.setSnowpark(_tmpSnowpark);
        final boolean _tmpPisteNotturne;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfPisteNotturne);
        _tmpPisteNotturne = _tmp_2 != 0;
        _item.setPisteNotturne(_tmpPisteNotturne);
        final double _tmpLat;
        _tmpLat = _cursor.getDouble(_cursorIndexOfLat);
        _item.setLat(_tmpLat);
        final double _tmpLong;
        _tmpLong = _cursor.getDouble(_cursorIndexOfLong);
        _item.setLong(_tmpLong);
        final int _tmpMaxAltitudine;
        _tmpMaxAltitudine = _cursor.getInt(_cursorIndexOfMaxAltitudine);
        _item.setMaxAltitudine(_tmpMaxAltitudine);
        final int _tmpMinAltitudine;
        _tmpMinAltitudine = _cursor.getInt(_cursorIndexOfMinAltitudine);
        _item.setMinAltitudine(_tmpMinAltitudine);
        final int _tmpZoom;
        _tmpZoom = _cursor.getInt(_cursorIndexOfZoom);
        _item.setZoom(_tmpZoom);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Pista> getSkiAreaPiste(final int id) {
    final String _sql = "SELECT * FROM Pista WHERE idComprensorio = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfDifficolta = CursorUtil.getColumnIndexOrThrow(_cursor, "difficolta");
      final int _cursorIndexOfIdComprensorio = CursorUtil.getColumnIndexOrThrow(_cursor, "idComprensorio");
      final List<Pista> _result = new ArrayList<Pista>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Pista _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNome;
        if (_cursor.isNull(_cursorIndexOfNome)) {
          _tmpNome = null;
        } else {
          _tmpNome = _cursor.getString(_cursorIndexOfNome);
        }
        final String _tmpDifficolta;
        if (_cursor.isNull(_cursorIndexOfDifficolta)) {
          _tmpDifficolta = null;
        } else {
          _tmpDifficolta = _cursor.getString(_cursorIndexOfDifficolta);
        }
        final int _tmpIdComprensorio;
        _tmpIdComprensorio = _cursor.getInt(_cursorIndexOfIdComprensorio);
        _item = new Pista(_tmpId,_tmpNome,_tmpDifficolta,_tmpIdComprensorio);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Comprensorio> getComprensoriConTracciamenti() {
    final String _sql = "SELECT DISTINCT Comprensorio.* FROM Comprensorio JOIN Pista ON Pista.idComprensorio = Comprensorio.id JOIN Tracciamento ON Tracciamento.idPista = Pista.id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfAperto = CursorUtil.getColumnIndexOrThrow(_cursor, "aperto");
      final int _cursorIndexOfNumPiste = CursorUtil.getColumnIndexOrThrow(_cursor, "numPiste");
      final int _cursorIndexOfNumImpianti = CursorUtil.getColumnIndexOrThrow(_cursor, "numImpianti");
      final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
      final int _cursorIndexOfSnowpark = CursorUtil.getColumnIndexOrThrow(_cursor, "snowpark");
      final int _cursorIndexOfPisteNotturne = CursorUtil.getColumnIndexOrThrow(_cursor, "pisteNotturne");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLong = CursorUtil.getColumnIndexOrThrow(_cursor, "long");
      final int _cursorIndexOfMaxAltitudine = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAltitudine");
      final int _cursorIndexOfMinAltitudine = CursorUtil.getColumnIndexOrThrow(_cursor, "minAltitudine");
      final int _cursorIndexOfZoom = CursorUtil.getColumnIndexOrThrow(_cursor, "zoom");
      final List<Comprensorio> _result = new ArrayList<Comprensorio>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Comprensorio _item;
        _item = new Comprensorio();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNome;
        if (_cursor.isNull(_cursorIndexOfNome)) {
          _tmpNome = null;
        } else {
          _tmpNome = _cursor.getString(_cursorIndexOfNome);
        }
        _item.setNome(_tmpNome);
        final boolean _tmpAperto;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAperto);
        _tmpAperto = _tmp != 0;
        _item.setAperto(_tmpAperto);
        final int _tmpNumPiste;
        _tmpNumPiste = _cursor.getInt(_cursorIndexOfNumPiste);
        _item.setNumPiste(_tmpNumPiste);
        final int _tmpNumImpianti;
        _tmpNumImpianti = _cursor.getInt(_cursorIndexOfNumImpianti);
        _item.setNumImpianti(_tmpNumImpianti);
        final String _tmpWebsite;
        if (_cursor.isNull(_cursorIndexOfWebsite)) {
          _tmpWebsite = null;
        } else {
          _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
        }
        _item.setWebsite(_tmpWebsite);
        final boolean _tmpSnowpark;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfSnowpark);
        _tmpSnowpark = _tmp_1 != 0;
        _item.setSnowpark(_tmpSnowpark);
        final boolean _tmpPisteNotturne;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfPisteNotturne);
        _tmpPisteNotturne = _tmp_2 != 0;
        _item.setPisteNotturne(_tmpPisteNotturne);
        final double _tmpLat;
        _tmpLat = _cursor.getDouble(_cursorIndexOfLat);
        _item.setLat(_tmpLat);
        final double _tmpLong;
        _tmpLong = _cursor.getDouble(_cursorIndexOfLong);
        _item.setLong(_tmpLong);
        final int _tmpMaxAltitudine;
        _tmpMaxAltitudine = _cursor.getInt(_cursorIndexOfMaxAltitudine);
        _item.setMaxAltitudine(_tmpMaxAltitudine);
        final int _tmpMinAltitudine;
        _tmpMinAltitudine = _cursor.getInt(_cursorIndexOfMinAltitudine);
        _item.setMinAltitudine(_tmpMinAltitudine);
        final int _tmpZoom;
        _tmpZoom = _cursor.getInt(_cursorIndexOfZoom);
        _item.setZoom(_tmpZoom);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<model.Tracciamento> getTracciamentiByComprensorio(final int id) {
    final String _sql = "SELECT tracciamento.id AS id, tracciamento.distanza AS distanza, tracciamento.velocita AS velocita, tracciamento.dislivello AS dislivello, tracciamento.dataOraInizio AS dataOraInizio, tracciamento.dataOraFine AS dataOraFine, pista.nome AS pistaNome, pista.difficolta AS pistaDifficolta FROM tracciamento JOIN pista ON tracciamento.idPista = pista.id JOIN comprensorio ON pista.idComprensorio = comprensorio.id WHERE comprensorio.id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfDistanza = 1;
      final int _cursorIndexOfVelocita = 2;
      final int _cursorIndexOfDislivello = 3;
      final int _cursorIndexOfDataOraInizio = 4;
      final int _cursorIndexOfDataOraFine = 5;
      final int _cursorIndexOfPistaNome = 6;
      final int _cursorIndexOfPistaDifficolta = 7;
      final List<model.Tracciamento> _result = new ArrayList<model.Tracciamento>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final model.Tracciamento _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final float _tmpDistanza;
        _tmpDistanza = _cursor.getFloat(_cursorIndexOfDistanza);
        final float _tmpVelocita;
        _tmpVelocita = _cursor.getFloat(_cursorIndexOfVelocita);
        final int _tmpDislivello;
        _tmpDislivello = _cursor.getInt(_cursorIndexOfDislivello);
        final long _tmpDataOraInizio;
        _tmpDataOraInizio = _cursor.getLong(_cursorIndexOfDataOraInizio);
        final long _tmpDataOraFine;
        _tmpDataOraFine = _cursor.getLong(_cursorIndexOfDataOraFine);
        final String _tmpPistaNome;
        if (_cursor.isNull(_cursorIndexOfPistaNome)) {
          _tmpPistaNome = null;
        } else {
          _tmpPistaNome = _cursor.getString(_cursorIndexOfPistaNome);
        }
        final String _tmpPistaDifficolta;
        if (_cursor.isNull(_cursorIndexOfPistaDifficolta)) {
          _tmpPistaDifficolta = null;
        } else {
          _tmpPistaDifficolta = _cursor.getString(_cursorIndexOfPistaDifficolta);
        }
        _item = new model.Tracciamento(_tmpId,_tmpDistanza,_tmpVelocita,_tmpDislivello,_tmpDataOraInizio,_tmpDataOraFine,_tmpPistaNome,_tmpPistaDifficolta);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
