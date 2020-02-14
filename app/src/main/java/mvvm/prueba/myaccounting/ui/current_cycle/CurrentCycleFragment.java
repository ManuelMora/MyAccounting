package mvvm.prueba.myaccounting.ui.current_cycle;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import mvvm.prueba.myaccounting.R;
import mvvm.prueba.myaccounting.model.Cycle;

public class CurrentCycleFragment extends Fragment {

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    final View root = inflater.inflate(R.layout.fragment_current_cycle, container, false);
    final Resources resources = root.getResources();

    final TextView txtCCStart = root.findViewById(R.id.txt_cc_start);
    final TextView txtCCTExpenditure = root.findViewById(R.id.txt_cc_texpenditure);
    final TextView txtCCTCurrent = root.findViewById(R.id.txt_cc_tcurrent);
    final TextView txtCCTIncome = root.findViewById(R.id.txt_cc_tincome);

    CurrentCycleViewModel currentCycleViewModel = new ViewModelProvider(this)
        .get(CurrentCycleViewModel.class);
    currentCycleViewModel.getCurrentCycle().observe(this.getViewLifecycleOwner(),
        new Observer<Cycle>() {
      @Override
      public void onChanged(Cycle cycle) {
        txtCCStart.setText(cycle.getStart());
        txtCCTExpenditure.setText(resources.getString(R.string.money_value, cycle.getTotalExpenditure()));
        txtCCTCurrent.setText(resources.getString(R.string.money_value, cycle.getTotalActual()));
        txtCCTIncome.setText(resources.getString(R.string.money_value, cycle.getTotalIncome()));
      }
    });

    return root;
  }
}