package mvvm.prueba.myaccounting.database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import mvvm.prueba.myaccounting.model.Actual;

@Entity(tableName = "actual",
foreignKeys = {
    @ForeignKey(entity = CycleEntity.class,
    parentColumns = "id",
    childColumns = "id_cycle",
    onDelete = ForeignKey.RESTRICT),
}, indices = {
    @Index(value = "id_cycle")
})
public class ActualEntity implements Actual {
  @PrimaryKey(autoGenerate = true)
  private int id;
  @ColumnInfo(name = "id_cycle")
  private int cycleId;
  private String name;
  private double valor;
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
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  @Override
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
