import java.sql.*;
import javax.swing.*;

public class CancelUI extends JFrame {

    JTextField id;

    public CancelUI() {
        setTitle("Cancel Ticket");
        setSize(300, 200);
        setLayout(null);

        JLabel l = new JLabel("Booking ID:");
        l.setBounds(50, 50, 100, 20);

        id = new JTextField();
        id.setBounds(150, 50, 80, 25);

        JButton btn = new JButton("Cancel");
        btn.setBounds(100, 100, 100, 30);

        btn.addActionListener(e -> cancel());

        add(l); add(id); add(btn);
        setVisible(true);
    }

    void cancel() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM bookings WHERE id=?"
            );

            ps.setInt(1, Integer.parseInt(id.getText()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Cancelled!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}