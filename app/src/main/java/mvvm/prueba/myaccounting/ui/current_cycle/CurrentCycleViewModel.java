package mvvm.prueba.myaccounting.ui.current_cycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import mvvm.prueba.myaccounting.model.Cycle;

public class CurrentCycleViewModel extends ViewModel {

  private MutableLiveData<Cycle> mCurrentCycle;

  public CurrentCycleViewModel() {
    mCurrentCycle = new MutableLiveData<>();
    mCurrentCycle.setValue(new Cycle() {
      @Override
      public int getId() {
        return 0;
      }

      @NonNull
      @Override
      public String getStart() {
        return "2020-02-14 00:00:00";
      }

      @Override
      public String getFinish() {
        return null;
      }

      @Override
      public double getTotalIncome() {
        return 1;
      }

      @Override
      public double getTotalExpenditure() {
        return 1;
      }

      @Override
      public double getTotalActual() {
        return 1;
      }

      @Override
      public boolean isClose() {
        return false;
      }

      @Override
      public void close() {

      }
    });
  }

  LiveData<Cycle> getCurrentCycle() {
    return mCurrentCycle;
  }

}