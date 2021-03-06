/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jifi.ui.view;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author antunes2
 */
public class MessageTab implements View {

    private static class Data {

        public int level;
        public Object focusable;
        public String msg;

        public Data(int level, Object focusable, String msg) {
            this.level = level;
            this.focusable = focusable;
            this.msg = msg;
        }
    }

    private static final ArrayList<Data> messages = new ArrayList<>();
    private static final MyTableModel model = new MyTableModel();
    private final ViewData data;
    private final JTable table;
    private final JScrollPane scrollPane;

    public MessageTab() {
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        data = new ViewData("Mensagens", null, "testet", scrollPane);
        TableColumn column;
        for (int i = 0; i < 3; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i != 2) {
                column.setMaxWidth(100);
            }
        }

        for (int i = 0; i < 20; i++) {
            log(i, UIManager.getIcon("FileView.fileIcon"), "asd " + Math.random());
        }

    }

    @Override
    public ViewData getData() {
        return data;
    }

    @Override
    public void update() {
    }

    @Override
    public void selected() {

    }

    public static void log(int level, Object focusable, String msg) {
        messages.add(new Data(level, focusable, msg));
        model.fireTableDataChanged();
    }

    static class MyTableModel extends AbstractTableModel {

        private final String[] columnNames = {"Level", "Local", "Mensagem"};

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public int getRowCount() {
            return messages.size();
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            if (col == 0) {
                return messages.get(row).level;
            } else if (col == 1) {
                return messages.get(row).focusable;
            } else if (col == 2) {
                return messages.get(row).msg;
            }
            return "";
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }

}
