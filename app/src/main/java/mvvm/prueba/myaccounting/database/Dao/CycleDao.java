package mvvm.prueba.myaccounting.database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import mvvm.prueba.myaccounting.database.Entity.CycleEntity;

@Dao
public interface CycleDao {
  @Query("SELECT * FROM cycle WHERE id = :id")
  CycleEntity getCycle(int id);

  @Query("SELECT * FROM cycle ORDER BY id DESC LIMIT 1")
  CycleEntity getLastCycle();

  @Query("SELECT * FROM cycle")
  List<CycleEntity> getAllCycles();

  @Insert
  void insert(CycleEntity cycleEntity);

  @Update
  void update(CycleEntity cycleEntity);

  @Delete
  void delete(CycleEntity cycleEntity);
}
