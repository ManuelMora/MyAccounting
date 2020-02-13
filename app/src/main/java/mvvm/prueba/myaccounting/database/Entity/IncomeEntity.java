package mvvm.prueba.myaccounting.database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import mvvm.prueba.myaccounting.model.Income;

@Entity(tableName = "income",
foreignKeys = {
    @ForeignKey(entity = CycleEntity.class,
    parentColumns = "id",
    childColumns = "id_cycle",
    onDelete = ForeignKey.RESTRICT),
    @ForeignKey(entity = ActualEntity.class,
    parentColumns = "id",
    childColumns = "id_actual",
    onDelete = ForeignKey.RESTRICT)
}, indices = {
    @Index(value = "id_cycle"),
    @Index(value = "id_actual")
})
public class IncomeEntity implements Income {
  @PrimaryKey(autoGenerate = true)
  private int id;
  @ColumnInfo(name = "id_cycle")
  private int cycleId;
  @ColumnInfo(name = "id_actual")
  private int actualId;
  private String name;
  private double value;
  private String description;

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int getCycleId() {
    return cycleId;
  }

  public void setCycleId(int cycleId) {
    this.cycleId = cycleId;
  }

  @Override
  public int getActualId() {
    return actualId;
  }

  public void setActualId(int actualId) {
    this.actualId = actualId;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public double getValue() {
    return value;
  }

  @Override
  public void setValue(double value) {
    this.value = value;
  }

  @Override
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
