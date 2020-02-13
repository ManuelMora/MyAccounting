package mvvm.prueba.myaccounting.database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import mvvm.prueba.myaccounting.database.Entity.ActualEntity;

@Dao
public interface ActualDao {
  @Query("SELECT * FROM actual WHERE id_cycle = :idCycle")
  List<ActualEntity> getActualsByCycle(int idCycle);

  @Update
  void update(ActualEntity actual);

  @Delete
  void delete(ActualEntity actual);
}
