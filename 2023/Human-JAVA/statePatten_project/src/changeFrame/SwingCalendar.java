package changeFrame;

import dto.UserNeedsRoomSearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class SwingCalendar extends JPanel implements ActionListener {
    private final JLabel label;
    private final JButton prevBtn = new JButton("◀");
    private final JButton nextBtn = new JButton("▶");
    private final JComboBox<Integer> yearCombo = new JComboBox<>();
    private final DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<>();
    private final JComboBox<Integer> monthCombo = new JComboBox<>();
    private final DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<>();

    private final JPanel centerPane = new JPanel(new BorderLayout());
    private final JPanel titlePane = new JPanel(new GridLayout(1, 7));
    private final String[] titleStr = {"일", "월", "화", "수", "목", "금", "토"};
    private final JPanel datePane = new JPanel(new GridLayout(0, 7));

    private final Calendar now;
    private final int year;
    private final int month;
    private final int date;
    private boolean clicked;


    public SwingCalendar(String labelStr) {
        this.setLayout(new BorderLayout());
        this.label = new JLabel(labelStr);
        this.setSize(350, 250);
        add(label, BorderLayout.NORTH);

        now = Calendar.getInstance();
        year = now.get(Calendar.YEAR);
        month = now.get(Calendar.MONTH) + 1;
        date = now.get(Calendar.DATE);

        JPanel topPane = new JPanel();
        topPane.add(prevBtn);

        for (int i = year - 10; i < year + 10; i++) {
            yearModel.addElement(i);
        }

        yearCombo.setModel(yearModel);
        yearCombo.setSelectedItem(year);
        topPane.add(yearCombo);

        JLabel yearLbl = new JLabel("년");
        topPane.add(yearLbl);

        for (int i = 1; i <= 12; i++) {
            monthModel.addElement(i);
        }
        monthCombo.setModel(monthModel);
        monthCombo.setSelectedItem(month);
        topPane.add(monthCombo);

        JLabel monthLbl = new JLabel("월");
        topPane.add(monthLbl);

        topPane.add(nextBtn);

        topPane.setBackground(new Color(100, 200, 200));
        add(topPane, BorderLayout.CENTER);

        titlePane.setBackground(Color.WHITE);
        for (String s : titleStr) {
            JLabel lbl = new JLabel(s, JLabel.CENTER);
            if (s.equals("일")) {
                lbl.setForeground(Color.RED);
            } else if (s.equals("토")) {
                lbl.setForeground(Color.BLUE);
            }
            titlePane.add(lbl);
        }

        centerPane.add(titlePane, BorderLayout.NORTH);
        dayPrint(year, month);
        centerPane.add(datePane, BorderLayout.CENTER);
        datePane.setBackground(Color.white);
        add(centerPane, BorderLayout.SOUTH);

        setSize(400, 300);
        setVisible(true);

        prevBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        yearCombo.addActionListener(this);
        monthCombo.addActionListener(this);
        addDateLabelsMouseListener();
    }

    private void addDateLabelsMouseListener() {
        UserNeedsRoomSearch sendObject = SearchFrame.getSendObject();
        for (Component comp : datePane.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel lbl = (JLabel) comp;
                lbl.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        lblsObject(sendObject, lbl);
                    }
                });
            }
        }
    }

    private void updateDateLabels() {
        datePane.setVisible(false);
        datePane.removeAll();
        dayPrint((Integer) yearCombo.getSelectedItem(), (Integer) monthCombo.getSelectedItem());
        datePane.setVisible(true);

        // Remove all previous mouse listeners
        for (Component comp : datePane.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel lbl = (JLabel) comp;
                for (MouseListener mouseAdapter : lbl.getMouseListeners()) {
                    lbl.removeMouseListener(mouseAdapter);
                }
            }
        }

        addDateLabelsMouseListener(); // Add mouse listener to the new date labels
        datePane.revalidate();
    }

    public void dayPrint(int y, int m) {
        Font font = new Font("맑은 고딕", Font.PLAIN, 20);
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, 1);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i < week; i++) {
            datePane.add(new JLabel(" "));
        }

        for (int i = 1; i <= lastDate; i++) {
            JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);
            lbl.setFont(font);
            cal.set(y, m - 1, i);
            int outWeek = cal.get(Calendar.DAY_OF_WEEK);

            if (outWeek == 1) {
                lbl.setForeground(Color.RED);
            } else if (outWeek == 7) {
                lbl.setForeground(Color.BLUE);
            }

            lbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    UserNeedsRoomSearch sendObject = SearchFrame.getSendObject();
                    lblsObject(sendObject, lbl);
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                    if (!clicked){
                        lbl.setOpaque(false);
                        lbl.setBackground(datePane.getBackground());
                    }
                }
            });
            datePane.add(lbl);
        }
    }

    private void lblsObject(UserNeedsRoomSearch sendObject, JLabel lbl) {
        int selectedYear = (Integer) yearCombo.getSelectedItem();
        int selectedMonth = (Integer) monthCombo.getSelectedItem();
        int selectedDay = Integer.parseInt(lbl.getText());

        String formattedDate = String.format("%04d-%02d-%02d", selectedYear, selectedMonth, selectedDay);
        if (label.getText().equals("checkOutdate")) sendObject.setCheckOut(formattedDate);
        else if (label.getText().equals("checkIndate")) sendObject.setCheckIn(formattedDate);

        if (!clicked) {
            lbl.setOpaque(true);
            lbl.setBackground(Color.YELLOW);
        }
        clicked = true;
        SearchFrame.setSendObject(sendObject);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JButton) {
            JButton eventBtn = (JButton) obj;
            int yy = (Integer) yearCombo.getSelectedItem();
            int mm = (Integer) monthCombo.getSelectedItem();
            if (eventBtn.equals(prevBtn)) {
                if (mm == 1) {
                    yy--;
                    mm = 12;
                } else mm--;
            } else if (eventBtn.equals(nextBtn)) {
                if (isNextMonthAllowed(yy, mm)) {
                    if (mm == 12) {
                        yy++;
                        mm = 1;
                    } else {
                        mm++;
                    }
                }
            }

            yearCombo.setSelectedItem(yy);
            monthCombo.setSelectedItem(mm);
            updateDateLabels();
        } else if (obj instanceof JComboBox) {
            updateDateLabels();
        }
    }

    private boolean isNextMonthAllowed(int year, int month) {
        Calendar nextMonth = Calendar.getInstance();
        nextMonth.set(year, month - 1, 1);

        Calendar now = Calendar.getInstance();
        now.set(Calendar.DAY_OF_MONTH, 1);

        return nextMonth.after(now) || nextMonth.equals(now);
    }

}


