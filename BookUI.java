import java.awt.*;
import javax.swing.*;

public class BookUI extends JFrame {

    JTextField nameField, ageField, busField, sourceField, destField;

    public BookUI() {

        setTitle("Book Ticket");
        setSize(400, 350);
        setLayout(null);
        getContentPane().setBackground(new Color(34, 49, 63));

        nameField = createField("Name", 50);
        ageField = createField("Age", 90);
        busField = createField("Bus No", 130);
        sourceField = createField("Source", 170);
        destField = createField("Destination", 210);

        JButton btn = new JButton("NEXT");
        btn.setBounds(130, 260, 120, 30);
        btn.setBackground(new Color(0, 184, 148));
        btn.setForeground(Color.WHITE);

        btn.addActionListener(e -> goToSeatSelection());

        add(btn);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JTextField createField(String label, int y) {
        JLabel l = new JLabel(label);
        l.setBounds(50, y, 100, 20);
        l.setForeground(Color.WHITE);

        JTextField t = new JTextField();
        t.setBounds(160, y, 150, 25);

        add(l);
        add(t);

        return t;
    }

    private void goToSeatSelection() {

        String name = nameField.getText();
        String ageText = ageField.getText();
        String busText = busField.getText();
        String source = sourceField.getText();
        String dest = destField.getText();

        if (name.isEmpty() || ageText.isEmpty() || busText.isEmpty() || source.isEmpty() || dest.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill all fields!");
            return;
        }

        try {
            Integer.parseInt(ageText);
            Integer.parseInt(busText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Age & Bus must be numbers!");
            return;
        }

        //  Pass booking data to next screen
        new SeatSelectionUI(name, ageText, busText, source, dest);

        dispose();
    }
}