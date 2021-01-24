package dev.rayma.AAOLConverter;

import net.miginfocom.swing.MigLayout;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicReference;

public class Launcher {
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();

    public static void main(String[] args) {
        Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = new Dimension(screenResolution.width - 100, screenResolution.height - 100);
        frame.setSize(windowSize);
        panel.setLayout(new MigLayout("fillx, filly"));
        panel.setSize(windowSize);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //TODO Saving?
            }
        });

        JLabel sourceSheetLabel = new JLabel("Source CSV File");
        sourceSheetLabel.setFont(new Font(sourceSheetLabel.getFont().getName(), Font.PLAIN, 35));
        panel.add(sourceSheetLabel, "center center");

        JButton sourceSheetChooserButton = new JButton("Choose File");
        panel.add(sourceSheetChooserButton, "center center");
        AtomicReference<List<CSVRecord>> records = new AtomicReference<>();

        sourceSheetChooserButton.addActionListener((ActionEvent e) -> {
            if (e.getSource() == sourceSheetChooserButton) {
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return f.isFile() && f.getName().toLowerCase().endsWith(".csv");
                    }

                    @Override
                    public String getDescription() {
                        return "CSV File (*.csv)";
                    }
                });
                int i = fc.showOpenDialog(frame);
                if (i == JFileChooser.APPROVE_OPTION) {
                    try (Reader in = new FileReader(fc.getSelectedFile())) {
                        records.set(CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in).getRecords());
                        sourceSheetChooserButton.setText(fc.getSelectedFile().getName());
                        stepTwo();
                    } catch (IOException exception) {
                        //Ignore
                    }
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void stepTwo() {
        panel.removeAll();
    }
}
