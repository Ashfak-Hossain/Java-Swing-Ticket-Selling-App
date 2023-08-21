package authenticaton;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Calendar;

public class DobPicker extends JPanel {
    private final JComboBox<Integer> days;
    private final JComboBox<String> months;
    private final JComboBox<Integer> years;

    public DobPicker() {
        //  day dropdown
        days = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            days.addItem(i);
        }

        //  month dropdown
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.months = new JComboBox<>(months);

        // Year dropdown
        years = new JComboBox<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int startYear = currentYear - 100;
        for (int i = currentYear; i >= startYear; i--) {
            years.addItem(i);
        }


        add(days);
        add(this.months);
        add(years);
    }

    public LocalDate getSelectedDate() {
        Integer selectedDay = (Integer) days.getSelectedItem();
        String selectedMonth = (String) months.getSelectedItem();
        Integer selectedYear = (Integer) years.getSelectedItem();

        if (selectedDay == null || selectedMonth == null || selectedYear == null) {
            return null;
        }

        int day = selectedDay;
        int month = months.getSelectedIndex() + 1;
        int year = selectedYear;


        return LocalDate.of(year, month, day);
    }

    /* For reset */
    public void resetDate() {
        days.setSelectedIndex(0);
        months.setSelectedIndex(0);
        years.setSelectedIndex(0);
    }
}
