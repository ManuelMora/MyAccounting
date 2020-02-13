package mvvm.prueba.myaccounting.model;

import androidx.annotation.NonNull;

public interface Cycle {
  int getId();
  @NonNull
  String getStart();
  String getFinish();
  double getTotalIncome();
  double getTotalExpenditure();
  double getTotalActual();
  boolean isClose();
  void close();
}
