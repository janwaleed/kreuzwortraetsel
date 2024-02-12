import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;


public class KreuzwortraetselGUI extends JFrame {
    private JTable kreuzwortraetselTabelle;
    private JTable buchstabenZuordnungTabelle;
    private JButton abgebenButton;

    public KreuzwortraetselGUI() {
        setTitle("Kreuzworträtsel Editor");
        setSize(1200, 800); // Set the initial size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application closes when the window is closed
        setLayout(new BorderLayout(5, 5)); // Use BorderLayout with gaps

        initialisiereKomponenten(); // Initialize components

        pack(); // Pack the components before displaying
        setVisible(true); // Make the window visible
    }

    private void initialisiereKomponenten() {
        // Initialize the crossword puzzle table with 8 rows and 18 columns
        DefaultTableModel kreuzwortModel = new DefaultTableModel(8, 18);
        kreuzwortraetselTabelle = new JTable(kreuzwortModel);

        // Initialize the letter-to-number mapping table with 2 rows and 21 columns
        DefaultTableModel buchstabenModel = new DefaultTableModel(2, 21) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return row == 1; // Make only the second row editable
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class; // Treat all inputs as String
            }
        };

        // Populate the first row of the mapping table with numbers 1 to 21
        for (int i = 0; i < 21; i++) {
            buchstabenModel.setValueAt(i + 1, 0, i);
        }
        buchstabenZuordnungTabelle = new JTable(buchstabenModel);
        buchstabenZuordnungTabelle.setTableHeader(null); // Remove the table header

        // Initialize the submit button
        abgebenButton = new JButton("Abgeben");
        abgebenButton.addActionListener(e -> ersetzeBuchstaben());

        // Wrap the tables in JScrollPane
        JScrollPane kreuzwortScrollPane = new JScrollPane(kreuzwortraetselTabelle);
        JScrollPane buchstabenScrollPane = new JScrollPane(buchstabenZuordnungTabelle);

        // Create a panel to hold both tables vertically
        JPanel tablesPanel = new JPanel();
        tablesPanel.setLayout(new BoxLayout(tablesPanel, BoxLayout.Y_AXIS));
        tablesPanel.add(kreuzwortScrollPane);
        tablesPanel.add(buchstabenScrollPane);

        // Add the tables panel and the submit button to the main frame
        add(tablesPanel, BorderLayout.CENTER);
        add(abgebenButton, BorderLayout.PAGE_END);
    }

    private void ersetzeBuchstaben() {
        // Create a mapping of numbers to letters based on the user input in buchstabenZuordnungTabelle
        HashMap<Integer, String> mapping = new HashMap<>();
        for (int i = 0; i < buchstabenZuordnungTabelle.getColumnCount(); i++) {
            Object nummerObjekt = buchstabenZuordnungTabelle.getValueAt(0, i);
            Object buchstabeObjekt = buchstabenZuordnungTabelle.getValueAt(1, i);
            if (nummerObjekt != null && buchstabeObjekt != null) {
                try {
                    int nummer = Integer.parseInt(nummerObjekt.toString());
                    String buchstabe = buchstabeObjekt.toString();
                    mapping.put(nummer, buchstabe);
                } catch (NumberFormatException e) {
                    // Handle the case where the number is not properly formatted
                    System.out.println("Number format exception for input: " + nummerObjekt);
                }
            }
        }

        // Update kreuzwortraetselTabelle based on the mapping
        for (int row = 0; row < kreuzwortraetselTabelle.getRowCount(); row++) {
            for (int col = 0; col < kreuzwortraetselTabelle.getColumnCount(); col++) {
                Object cellValue = kreuzwortraetselTabelle.getValueAt(row, col);
                if (cellValue != null && !cellValue.toString().isEmpty()) {
                    try {
                        int zahlenwert = Integer.parseInt(cellValue.toString());
                        String ersatzBuchstabe = mapping.get(zahlenwert);
                        if (ersatzBuchstabe != null) {
                            kreuzwortraetselTabelle.setValueAt(ersatzBuchstabe, row, col);
                        }
                    } catch (NumberFormatException e) {
                        // Handle the case where the cell value is not a valid number
                        System.out.println("Number format exception for cell value: " + cellValue);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KreuzwortraetselGUI::new);
    }
}
