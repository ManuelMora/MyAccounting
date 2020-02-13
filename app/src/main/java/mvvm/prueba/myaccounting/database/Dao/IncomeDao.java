package mvvm.prueba.myaccounting.database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import mvvm.prueba.myaccounting.database.Entity.IncomeEntity;
import mvvm.prueba.myaccounting.model.Income;

@Dao
public interface IncomeDao {
  @Query("SELECT * FROM income WHERE id_cycle = :cycleId")
  List<IncomeEntity> getIncomesByCycle(int cycleId);

  @Insert
  void insert(IncomeEntity income);

  @Update
  void update(IncomeEntity income);

  @Delete
  void delete(IncomeEntity income);
}
