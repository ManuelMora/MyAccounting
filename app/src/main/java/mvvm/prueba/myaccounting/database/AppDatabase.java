package mvvm.prueba.myaccounting.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import mvvm.prueba.myaccounting.database.Dao.CycleDao;
import mvvm.prueba.myaccounting.database.Entity.ActualEntity;
import mvvm.prueba.myaccounting.database.Entity.CycleEntity;
import mvvm.prueba.myaccounting.database.Entity.ExpenditureEntity;
import mvvm.prueba.myaccounting.database.Entity.IncomeEntity;

@Database(entities = {
    CycleEntity.class,
    ActualEntity.class,
    IncomeEntity.class,
    ExpenditureEntity.class
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  private static volatile AppDatabase INSTANCE;
  private static final String DATABASE_NAME = "MyAccountingDB";
  private static final int NUMBER_OF_THREADS = 4;
  private static RoomDatabase.Callback sAppDatabaseCallback = new RoomDatabase.Callback() {};
  static final ExecutorService databaseWriteExecutor =
      Executors.newFixedThreadPool(NUMBER_OF_THREADS);

  public abstract CycleDao cycleDao();

  /**
   * Get class' unique instance
   * @param context Application context
   * @return instance of the class
   */
  static AppDatabase getInstance(final Context context) {
    if(INSTANCE == null) {
      synchronized (AppDatabase.class) {
        if(INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(
              context.getApplicationContext(),
              AppDatabase.class,
              DATABASE_NAME
          ).addCallback(sAppDatabaseCallback).build();
        }
      }
    }

    return INSTANCE;
  }
}
