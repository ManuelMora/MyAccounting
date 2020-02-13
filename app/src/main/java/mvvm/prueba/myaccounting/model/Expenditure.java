package mvvm.prueba.myaccounting.model;

public interface Expenditure {
  int getId();
  int getCycleId();
  int getActualId();
  String getName();
  double getValue();
  void setValue(double value);
  String getDescription();
}
