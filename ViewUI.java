import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewUI extends JFrame {

    public ViewUI() {
        setTitle("Bookings");
        setSize(500, 300);

        JTable table = new JTable();
        add(new JScrollPane(table));

        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM bookings");

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID","Name","Age","Bus","Source","Destination"});

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)
                });
            }

            table.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}
