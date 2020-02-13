package mvvm.prueba.myaccounting.model;

public interface Income {
  int getId();
  int getActualId();
  int getCycleId();
  String getName();
  double getValue();
  void setValue(double value);
  String getDescription();
}
