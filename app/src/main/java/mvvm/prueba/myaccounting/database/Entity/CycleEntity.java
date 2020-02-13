package mvvm.prueba.myaccounting.database.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import mvvm.prueba.myaccounting.model.Cycle;

@Entity(tableName = "cycle")
public class CycleEntity implements Cycle {
  @PrimaryKey(autoGenerate = true)
  private int id;
  @NonNull
  private String start;
  private String finish;
  @ColumnInfo(defaultValue = "0")
  private boolean close;
  @ColumnInfo(defaultValue = "0")
  private double totalIncome;
  @ColumnInfo(defaultValue = "0")
  private double totalExpenditure;
  @ColumnInfo(defaultValue = "0")
  private double totalActual;

  public CycleEntity(@NonNull String start) {
    this.start = start;
    this.finish = null;
    this.close = false;
    this.totalIncome = 0;
    this.totalExpenditure = 0;
    this.totalActual = 0;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @NonNull
  public String getStart() {
    return start;
  }

  public void setStart(@NonNull String start) {
    this.start = start;
  }

  public String getFinish() {
    return finish;
  }

  public void setFinish(String finish) {
    this.finish = finish;
  }

  public boolean isClose() {
    return close;
  }

  public void setClose(boolean close) {
    this.close = close;
  }

  public double getTotalIncome() {
    return totalIncome;
  }

  public void setTotalIncome(double totalIncome) {
    this.totalIncome = totalIncome;
  }

  public double getTotalExpenditure() {
    return totalExpenditure;
  }

  public void setTotalExpenditure(double totalExpenditure) {
    this.totalExpenditure = totalExpenditure;
  }

  public double getTotalActual() {
    return totalActual;
  }

  public void setTotalActual(double totalActual) {
    this.totalActual = totalActual;
  }

  public void close() {
    this.close = true;
    final String FORMAT = "yyyy/MM/dd HH:mm:ss";
    String actualDate;
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
      // API 26 and superior
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT);
      actualDate = dateTimeFormatter.format(LocalDateTime.now());
    } else  {
      // API 25
      DateFormat simpleDateFormat = new SimpleDateFormat(
          FORMAT,
          Locale.getDefault()
      );
      actualDate = simpleDateFormat.format(Calendar.getInstance().getTime());
    }
    this.finish = actualDate;
  }
}
