import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class LoginUI extends JFrame {

    JTextField user;
    JPasswordField pass;

    public LoginUI() {
        setTitle("Login");
        setSize(350, 250);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.setBackground(new Color(44, 62, 80));
        p.setLayout(null);

        JLabel title = new JLabel("LOGIN");
        title.setBounds(130, 20, 100, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        user = new JTextField();
        pass = new JPasswordField();

        user.setBounds(90, 80, 150, 25);
        pass.setBounds(90, 120, 150, 25);

        JButton btn = new JButton("Login");
        btn.setBounds(110, 160, 100, 30);

        btn.addActionListener(e -> login());

        p.add(title); p.add(user); p.add(pass); p.add(btn);
        add(p);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
void login() {
    System.out.println("Login button clicked"); // ✅ debug

    try {
        Connection con = DBConnection.getConnection();

        if (con == null) {
            JOptionPane.showMessageDialog(this, "DB Connection Failed!");
            return;
        }

        System.out.println("DB Connected"); // ✅ debug

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM users WHERE username=? AND password=?"
        );

        ps.setString(1, user.getText());
        ps.setString(2, new String(pass.getPassword()));

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Login Success");
            new DashboardUI();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username/Password");
        }

    } catch (Exception e) {
        e.printStackTrace(); // ✅ VERY IMPORTANT
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
     
    }