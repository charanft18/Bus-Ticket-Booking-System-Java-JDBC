import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.*;

public class SeatSelectionUI extends JFrame {

    ArrayList<JButton> selectedSeats = new ArrayList<>();

    String name, age, bus, source, dest;

    public SeatSelectionUI(String name, String age, String bus, String source, String dest) {

        this.name = name;
        this.age = age;
        this.bus = bus;
        this.source = source;
        this.dest = dest;

        setTitle("Select Seats");
        setSize(400, 400);
        setLayout(new GridLayout(6, 4, 10, 10));

        for (int i = 1; i <= 20; i++) {
            JButton seat = new JButton("" + i);
            seat.setBackground(Color.GREEN);

            seat.addActionListener(e -> toggleSeat(seat));

            add(seat);
        }

        JButton confirm = new JButton("Confirm Booking");
        confirm.setBackground(Color.BLUE);
        confirm.setForeground(Color.WHITE);

        confirm.addActionListener(e -> saveAndPay());

        add(confirm);

        setVisible(true);
    }

    void toggleSeat(JButton seat) {
        if (seat.getBackground() == Color.GREEN) {
            seat.setBackground(Color.RED);
            selectedSeats.add(seat);
        } else {
            seat.setBackground(Color.GREEN);
            selectedSeats.remove(seat);
        }
    }

    void saveAndPay() {

        if (selectedSeats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select at least 1 seat!");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO bookings(name, age, bus_no, source, destination) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(age));
            ps.setInt(3, Integer.parseInt(bus));
            ps.setString(4, source);
            ps.setString(5, dest);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        new PaymentUI(selectedSeats.size());
        dispose();
    }
}