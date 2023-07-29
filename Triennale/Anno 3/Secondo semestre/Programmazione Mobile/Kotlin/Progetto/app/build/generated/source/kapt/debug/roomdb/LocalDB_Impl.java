package roomdb;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LocalDB_Impl extends LocalDB {
  private volatile LocalDatabaseDao _localDatabaseDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(8) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Utente` (`id` TEXT NOT NULL, `tutorialCompletato` INTEGER NOT NULL, `idComprensorio` INTEGER, PRIMARY KEY(`id`), FOREIGN KEY(`idComprensorio`) REFERENCES `Comprensorio`(`id`) ON UPDATE CASCADE ON DELETE SET NULL )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Tracciamento` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `distanza` REAL NOT NULL, `velocita` REAL NOT NULL, `dislivello` INTEGER NOT NULL, `dataOraInizio` INTEGER NOT NULL, `dataOraFine` INTEGER NOT NULL, `idUtente` TEXT NOT NULL, `idPista` INTEGER NOT NULL, FOREIGN KEY(`idUtente`) REFERENCES `Utente`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`idPista`) REFERENCES `Pista`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Pista` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `difficolta` TEXT NOT NULL, `idComprensorio` INTEGER NOT NULL, FOREIGN KEY(`idComprensorio`) REFERENCES `Comprensorio`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Pista_nome` ON `Pista` (`nome`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Comprensorio` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `aperto` INTEGER NOT NULL DEFAULT 0, `numPiste` INTEGER NOT NULL, `numImpianti` INTEGER NOT NULL, `website` TEXT NOT NULL, `snowpark` INTEGER NOT NULL DEFAULT 0, `pisteNotturne` INTEGER NOT NULL DEFAULT 0, `lat` REAL NOT NULL, `long` REAL NOT NULL, `maxAltitudine` INTEGER NOT NULL, `minAltitudine` INTEGER NOT NULL, `zoom` INTEGER NOT NULL DEFAULT 16)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PuntoMappa` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `latitudine` REAL NOT NULL, `longitudine` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PuntiMappaTracciamenti` (`idTracciamento` INTEGER NOT NULL, `idPuntoMappa` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`idTracciamento`, `idPuntoMappa`), FOREIGN KEY(`idTracciamento`) REFERENCES `Tracciamento`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`idPuntoMappa`) REFERENCES `PuntoMappa`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b31b765ac9e5340ffeb8030b0dcba2a2')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Utente`");
        _db.execSQL("DROP TABLE IF EXISTS `Tracciamento`");
        _db.execSQL("DROP TABLE IF EXISTS `Pista`");
        _db.execSQL("DROP TABLE IF EXISTS `Comprensorio`");
        _db.execSQL("DROP TABLE IF EXISTS `PuntoMappa`");
        _db.execSQL("DROP TABLE IF EXISTS `PuntiMappaTracciamenti`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUtente = new HashMap<String, TableInfo.Column>(3);
        _columnsUtente.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtente.put("tutorialCompletato", new TableInfo.Column("tutorialCompletato", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtente.put("idComprensorio", new TableInfo.Column("idComprensorio", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUtente = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysUtente.add(new TableInfo.ForeignKey("Comprensorio", "SET NULL", "CASCADE",Arrays.asList("idComprensorio"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUtente = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUtente = new TableInfo("Utente", _columnsUtente, _foreignKeysUtente, _indicesUtente);
        final TableInfo _existingUtente = TableInfo.read(_db, "Utente");
        if (! _infoUtente.equals(_existingUtente)) {
          return new RoomOpenHelper.ValidationResult(false, "Utente(roomdb.Utente).\n"
                  + " Expected:\n" + _infoUtente + "\n"
                  + " Found:\n" + _existingUtente);
        }
        final HashMap<String, TableInfo.Column> _columnsTracciamento = new HashMap<String, TableInfo.Column>(8);
        _columnsTracciamento.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracciamento.put("distanza", new TableInfo.Column("distanza", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracciamento.put("velocita", new TableInfo.Column("velocita", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracciamento.put("dislivello", new TableInfo.Column("dislivello", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracciamento.put("dataOraInizio", new TableInfo.Column("dataOraInizio", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracciamento.put("dataOraFine", new TableInfo.Column("dataOraFine", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracciamento.put("idUtente", new TableInfo.Column("idUtente", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracciamento.put("idPista", new TableInfo.Column("idPista", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTracciamento = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysTracciamento.add(new TableInfo.ForeignKey("Utente", "CASCADE", "CASCADE",Arrays.asList("idUtente"), Arrays.asList("id")));
        _foreignKeysTracciamento.add(new TableInfo.ForeignKey("Pista", "CASCADE", "CASCADE",Arrays.asList("idPista"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTracciamento = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTracciamento = new TableInfo("Tracciamento", _columnsTracciamento, _foreignKeysTracciamento, _indicesTracciamento);
        final TableInfo _existingTracciamento = TableInfo.read(_db, "Tracciamento");
        if (! _infoTracciamento.equals(_existingTracciamento)) {
          return new RoomOpenHelper.ValidationResult(false, "Tracciamento(roomdb.Tracciamento).\n"
                  + " Expected:\n" + _infoTracciamento + "\n"
                  + " Found:\n" + _existingTracciamento);
        }
        final HashMap<String, TableInfo.Column> _columnsPista = new HashMap<String, TableInfo.Column>(4);
        _columnsPista.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPista.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPista.put("difficolta", new TableInfo.Column("difficolta", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPista.put("idComprensorio", new TableInfo.Column("idComprensorio", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPista = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPista.add(new TableInfo.ForeignKey("Comprensorio", "CASCADE", "CASCADE",Arrays.asList("idComprensorio"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPista = new HashSet<TableInfo.Index>(1);
        _indicesPista.add(new TableInfo.Index("index_Pista_nome", true, Arrays.asList("nome"), Arrays.asList("ASC")));
        final TableInfo _infoPista = new TableInfo("Pista", _columnsPista, _foreignKeysPista, _indicesPista);
        final TableInfo _existingPista = TableInfo.read(_db, "Pista");
        if (! _infoPista.equals(_existingPista)) {
          return new RoomOpenHelper.ValidationResult(false, "Pista(roomdb.Pista).\n"
                  + " Expected:\n" + _infoPista + "\n"
                  + " Found:\n" + _existingPista);
        }
        final HashMap<String, TableInfo.Column> _columnsComprensorio = new HashMap<String, TableInfo.Column>(13);
        _columnsComprensorio.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("aperto", new TableInfo.Column("aperto", "INTEGER", true, 0, "0", TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("numPiste", new TableInfo.Column("numPiste", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("numImpianti", new TableInfo.Column("numImpianti", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("website", new TableInfo.Column("website", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("snowpark", new TableInfo.Column("snowpark", "INTEGER", true, 0, "0", TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("pisteNotturne", new TableInfo.Column("pisteNotturne", "INTEGER", true, 0, "0", TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("lat", new TableInfo.Column("lat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("long", new TableInfo.Column("long", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("maxAltitudine", new TableInfo.Column("maxAltitudine", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("minAltitudine", new TableInfo.Column("minAltitudine", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComprensorio.put("zoom", new TableInfo.Column("zoom", "INTEGER", true, 0, "16", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysComprensorio = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesComprensorio = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoComprensorio = new TableInfo("Comprensorio", _columnsComprensorio, _foreignKeysComprensorio, _indicesComprensorio);
        final TableInfo _existingComprensorio = TableInfo.read(_db, "Comprensorio");
        if (! _infoComprensorio.equals(_existingComprensorio)) {
          return new RoomOpenHelper.ValidationResult(false, "Comprensorio(roomdb.Comprensorio).\n"
                  + " Expected:\n" + _infoComprensorio + "\n"
                  + " Found:\n" + _existingComprensorio);
        }
        final HashMap<String, TableInfo.Column> _columnsPuntoMappa = new HashMap<String, TableInfo.Column>(3);
        _columnsPuntoMappa.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPuntoMappa.put("latitudine", new TableInfo.Column("latitudine", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPuntoMappa.put("longitudine", new TableInfo.Column("longitudine", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPuntoMappa = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPuntoMappa = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPuntoMappa = new TableInfo("PuntoMappa", _columnsPuntoMappa, _foreignKeysPuntoMappa, _indicesPuntoMappa);
        final TableInfo _existingPuntoMappa = TableInfo.read(_db, "PuntoMappa");
        if (! _infoPuntoMappa.equals(_existingPuntoMappa)) {
          return new RoomOpenHelper.ValidationResult(false, "PuntoMappa(roomdb.PuntoMappa).\n"
                  + " Expected:\n" + _infoPuntoMappa + "\n"
                  + " Found:\n" + _existingPuntoMappa);
        }
        final HashMap<String, TableInfo.Column> _columnsPuntiMappaTracciamenti = new HashMap<String, TableInfo.Column>(3);
        _columnsPuntiMappaTracciamenti.put("idTracciamento", new TableInfo.Column("idTracciamento", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPuntiMappaTracciamenti.put("idPuntoMappa", new TableInfo.Column("idPuntoMappa", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPuntiMappaTracciamenti.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPuntiMappaTracciamenti = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysPuntiMappaTracciamenti.add(new TableInfo.ForeignKey("Tracciamento", "CASCADE", "CASCADE",Arrays.asList("idTracciamento"), Arrays.asList("id")));
        _foreignKeysPuntiMappaTracciamenti.add(new TableInfo.ForeignKey("PuntoMappa", "CASCADE", "CASCADE",Arrays.asList("idPuntoMappa"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPuntiMappaTracciamenti = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPuntiMappaTracciamenti = new TableInfo("PuntiMappaTracciamenti", _columnsPuntiMappaTracciamenti, _foreignKeysPuntiMappaTracciamenti, _indicesPuntiMappaTracciamenti);
        final TableInfo _existingPuntiMappaTracciamenti = TableInfo.read(_db, "PuntiMappaTracciamenti");
        if (! _infoPuntiMappaTracciamenti.equals(_existingPuntiMappaTracciamenti)) {
          return new RoomOpenHelper.ValidationResult(false, "PuntiMappaTracciamenti(roomdb.PuntiMappaTracciamenti).\n"
                  + " Expected:\n" + _infoPuntiMappaTracciamenti + "\n"
                  + " Found:\n" + _existingPuntiMappaTracciamenti);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "b31b765ac9e5340ffeb8030b0dcba2a2", "ec72374850c6bdbb31850a19fe9ec907");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Utente","Tracciamento","Pista","Comprensorio","PuntoMappa","PuntiMappaTracciamenti");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Utente`");
      _db.execSQL("DELETE FROM `Tracciamento`");
      _db.execSQL("DELETE FROM `Pista`");
      _db.execSQL("DELETE FROM `Comprensorio`");
      _db.execSQL("DELETE FROM `PuntoMappa`");
      _db.execSQL("DELETE FROM `PuntiMappaTracciamenti`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LocalDatabaseDao.class, LocalDatabaseDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public LocalDatabaseDao localDatabaseDao() {
    if (_localDatabaseDao != null) {
      return _localDatabaseDao;
    } else {
      synchronized(this) {
        if(_localDatabaseDao == null) {
          _localDatabaseDao = new LocalDatabaseDao_Impl(this);
        }
        return _localDatabaseDao;
      }
    }
  }
}
