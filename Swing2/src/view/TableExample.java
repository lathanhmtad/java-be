package view;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create data for the table
        Object[][] data = {
                {"John", 25, "Male"},
                {"Mary", 32, "Female"},
                {"Bob", 45, "Male"}
        };

        // Create column names for the table
        String[] columns = {"Name", "Age", "Gender"};

        // Create a JTable with the data and column names
        JTable table = new JTable(data, columns);

        // Create a JScrollPane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        frame.add(scrollPane);

        // Pack the JFrame and make it visible
        frame.pack();
        frame.setVisible(true);
    }
}
