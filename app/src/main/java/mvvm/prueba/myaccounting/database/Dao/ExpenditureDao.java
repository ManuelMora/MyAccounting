package mvvm.prueba.myaccounting.database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import mvvm.prueba.myaccounting.database.Entity.ExpenditureEntity;
import mvvm.prueba.myaccounting.model.Expenditure;

@Dao
public interface ExpenditureDao {
  @Query("SELECT * FROM expenditure WHERE id_cycle = :cycleId")
  List<Expenditure> getExpendituresByCycle(int cycleId);

  @Insert
  void insert(ExpenditureEntity expenditure);

  @Update
  void update(ExpenditureEntity expenditure);

  @Delete
  void delete(ExpenditureEntity expenditure);
}
