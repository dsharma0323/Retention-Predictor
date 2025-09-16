import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Scanner;

public class RetentionTableChart {

    public static String getPrediction(int tenure, String contract, double charges) {
        String lc = contract.toLowerCase();
        boolean isMonthToMonth = lc.contains("month");
        boolean isTwoYear = lc.contains("two");

        if (isMonthToMonth && charges > 70 && tenure < 12) {
            return "Likely to Leave";
        } else if (isTwoYear || tenure > 24) {
            return "Likely to Stay";
        } else if (charges < 50) {
            return "Likely to Stay";
        } else {
            return "Medium Risk";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter tenure (months): ");
        int tenure = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Enter contract type (Month-to-Month / One-Year / Two-Year): ");
        String contract = scanner.nextLine();

        System.out.print("Enter monthly charges: ");
        double charges = scanner.nextDouble();

        scanner.close();

        String prediction = getPrediction(tenure, contract, charges);

        // Build table data
        String[] columnNames = {"Tenure (months)", "Contract Type", "Monthly Charges", "Prediction"};
        Object[][] data = {
            {tenure, contract, "$" + charges, prediction}
        };

        // Create table
        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        // Put table inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Create frame
        JFrame frame = new JFrame("Customer Retention Prediction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(600, 200);
        frame.setLocationRelativeTo(null); // center screen
        frame.setVisible(true);
    }
}
