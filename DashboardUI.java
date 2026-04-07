import java.awt.*;
import javax.swing.*;

public class DashboardUI extends JFrame {

    public DashboardUI() {
        setTitle("Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(52, 73, 94));
        sidebar.setBounds(0, 0, 150, 400);
        sidebar.setLayout(new GridLayout(5,1));

        JButton book = new JButton("Book");
        JButton view = new JButton("View");
        JButton cancel = new JButton("Cancel");
        JButton exit = new JButton("Exit");

        sidebar.add(book);
        sidebar.add(view);
        sidebar.add(cancel);
        sidebar.add(exit);

        book.addActionListener(e -> new BookUI());
        view.addActionListener(e -> new ViewUI());
        cancel.addActionListener(e -> new CancelUI());
        exit.addActionListener(e -> System.exit(0));

        add(sidebar);
        setLayout(null);
        setVisible(true);
    }
}