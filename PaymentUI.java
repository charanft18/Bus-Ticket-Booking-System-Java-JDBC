import javax.swing.*;

public class PaymentUI extends JFrame {

    public PaymentUI(int seats) {
        setTitle("Payment");
        setSize(300, 200);
        setLayout(null);

        int amount = seats * 500;

        JLabel info = new JLabel("Total Amount: ₹" + amount);
        info.setBounds(50, 40, 200, 30);

        JButton pay = new JButton("Pay Now");
        pay.setBounds(80, 100, 120, 30);

        pay.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Payment Successful!");
            dispose();
        });

        add(info);
        add(pay);

        setVisible(true);
    }
}