import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener{

    private final int WindowWidth = 800;
    private final int WindowHeight = 600;
    JTabbedPane tabbedPane;
    JScrollPane peopleScroll, locationsScroll, equipmentScroll;
    JPanel peopleCard, locationsCard, equipmentCard, actionPanel;
    JButton addButton, findButton, removeButton;
    JTable peopleTable, locationsTable, equipmentTable;
    JLabel alternativeLabel, conjuctionLabel;
    JTextField peoplePersonIDTxt, peopleLocationIDTxt, peopleNameTxt, peopleSurnameTxt, peoplePhoneNumberTxt,
            peopleAddressTxt, peopleMailTxt, peopleLoginTxt, peopleHashTxt, locationsLocationIDTxt, locationsCityTxt,
            locationsPostCodeTxt, equipmentEquipmentIdTxt, equipmentTypeTxt, equipmentBrandTxt, equipmentParamsTxt,
            equipmentConditionTxt, equipmentLocationIDTxt, equipmentPersonIDTxt, equipmentModelTxt;
    JCheckBox peoplePersonIDBox, peopleLocationIDBox, peopleNameBox, peopleSurnameBox, peoplePhoneNumberBox,
            peopleAddressBox, peopleMailBox, peopleLoginBox, peopleHashBox, locationsLocationIDBox, locationsCityBox,
            locationsPostCodeBox, equipmentEquipmentIdBox, equipmentTypeBox, equipmentBrandBox, equipmentParamsBox,
            equipmentConditionBox, equipmentLocationIDBox, equipmentPersonIDBox, equipmentModelBox, orBox, andBox;
    private final static String peopleTableCard = "People";
    private final static String locationsTableCard = "Locations";
    private final static String equipmentTableCard = "Equipment";
    private final static String [] peopleTableColumnNames = {"id_osoby", "id_lokalizacji", "imie", "nazwisko", "nr_tel","adres","mail","login", "hasło"};
    private final static String [] locationsTableColumnNames = {"id_lokalizacji", "miasto", "kod_pocztowy"};
    private final static String [] equipmentTableColumnNames = {"id_sprzetu", "typ", "marka", "parametry", "stan_sprzetu","id_lokalizacji","id_osoby","model"};
    Object [][] data;
    boolean [] chosenParams;
    String [] values;

    public MainWindow(){
        setSize(WindowWidth, WindowHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Database explorer");
        setLayout(null);
        createTabbedPane();
        createActionPanel();
    }

    void createTabbedPane(){
        createPeopleCard();
        createLocationsCard();
        createEquipmentCard();

        tabbedPane = new JTabbedPane();
        tabbedPane.add(peopleCard, peopleTableCard);
        tabbedPane.add(locationsCard, locationsTableCard);
        tabbedPane.add(equipmentCard, equipmentTableCard);
        tabbedPane.setBounds(0,0,800,500);
        add(tabbedPane);
    }

    private void createPeopleCard(){
        peopleCard = new JPanel();
        peopleCard.setLayout(null);
        peopleScroll = new JScrollPane();
        peopleScroll.setBounds(10,15, 770,350);
        Object [][] dataaa = {{"dupa", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki"},
                {"dupa", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki"}};
        data = dataaa ;//new DataBaseFactory().getData("osoby", chosenParams, values );
        peopleTable = new JTable(data, peopleTableColumnNames);
        peopleScroll.setViewportView(peopleTable);

        peoplePersonIDBox = new JCheckBox();
        peoplePersonIDBox.setBounds(43, 375,20,20);
        peopleLocationIDBox = new JCheckBox();
        peopleLocationIDBox.setBounds(129,375,20,20);
        peopleNameBox = new JCheckBox();
        peopleNameBox.setBounds(215,375,20,20);
        peopleSurnameBox = new JCheckBox();
        peopleSurnameBox.setBounds(301,375,20,20);
        peoplePhoneNumberBox = new JCheckBox();
        peoplePhoneNumberBox.setBounds(387,375,20,20);
        peopleAddressBox = new JCheckBox();
        peopleAddressBox.setBounds(473,375,20,20);
        peopleMailBox = new JCheckBox();
        peopleMailBox.setBounds(559,375,20,20);
        peopleLoginBox = new JCheckBox();
        peopleLoginBox.setBounds(645,375,20,20);
        peopleHashBox = new JCheckBox();
        peopleHashBox.setBounds(731,375,20,20);

        peoplePersonIDTxt = new JTextField();
        peoplePersonIDTxt.setBounds(18, 410,70,20);
        peopleLocationIDTxt = new JTextField();
        peopleLocationIDTxt.setBounds(104,410,70,20);
        peopleNameTxt = new JTextField();
        peopleNameTxt.setBounds(190,410,70,20);
        peopleSurnameTxt = new JTextField();
        peopleSurnameTxt.setBounds(276,410,70,20);
        peoplePhoneNumberTxt = new JTextField();
        peoplePhoneNumberTxt.setBounds(362,410,70,20);
        peopleAddressTxt = new JTextField();
        peopleAddressTxt.setBounds(448,410,70,20);
        peopleMailTxt = new JTextField();
        peopleMailTxt.setBounds(534,410,70,20);
        peopleLoginTxt = new JTextField();
        peopleLoginTxt.setBounds(620,410,70,20);
        peopleHashTxt = new JTextField();
        peopleHashTxt.setBounds(706,410,70,20);

        peopleCard.add(peopleScroll);
        peopleCard.add(peoplePersonIDTxt);
        peopleCard.add(peopleLocationIDTxt);
        peopleCard.add(peopleNameTxt);
        peopleCard.add(peopleSurnameTxt);
        peopleCard.add(peoplePhoneNumberTxt);
        peopleCard.add(peopleAddressTxt);
        peopleCard.add(peopleMailTxt);
        peopleCard.add(peopleLoginTxt);
        peopleCard.add(peopleHashTxt);
        peopleCard.add(peoplePersonIDBox);
        peopleCard.add(peopleLocationIDBox);
        peopleCard.add(peopleNameBox);
        peopleCard.add(peopleSurnameBox);
        peopleCard.add(peoplePhoneNumberBox);
        peopleCard.add(peopleAddressBox);
        peopleCard.add(peopleMailBox);
        peopleCard.add(peopleLoginBox);
        peopleCard.add(peopleHashBox);
    }

    private void createLocationsCard(){
        locationsCard = new JPanel();
        locationsCard.setLayout(null);
        locationsScroll = new JScrollPane();
        locationsScroll.setBounds(125,15,500, 350);
        Object [][] dataaa = {{"dupa","dupa","dupa"},{"cycki","cycki","cycki"}};
        data = dataaa; // DataBaseFactory().getData("lokalizacja", chosenParams, values );
        locationsTable = new JTable(data, locationsTableColumnNames);
        locationsScroll.setViewportView(locationsTable);

        locationsLocationIDBox = new JCheckBox();
        locationsLocationIDBox.setBounds(185,375,20,20);
        locationsCityBox = new JCheckBox();
        locationsCityBox.setBounds(365,375,20,20);
        locationsPostCodeBox = new JCheckBox();
        locationsPostCodeBox.setBounds(545,375,20,20);

        locationsLocationIDTxt = new JTextField();
        locationsLocationIDTxt.setBounds(145,410,100,20);
        locationsCityTxt = new JTextField();
        locationsCityTxt.setBounds(325,410,100,20);
        locationsPostCodeTxt = new JTextField();
        locationsPostCodeTxt.setBounds(505,410,100,20);

        locationsCard.add(locationsScroll);
        locationsCard.add(locationsLocationIDTxt);
        locationsCard.add(locationsCityTxt);
        locationsCard.add(locationsPostCodeTxt);
        locationsCard.add(locationsLocationIDBox);
        locationsCard.add(locationsCityBox);
        locationsCard.add(locationsPostCodeBox);
    }

    private void createEquipmentCard(){
        equipmentCard = new JPanel();
        equipmentCard.setLayout(null);
        equipmentScroll = new JScrollPane();
        equipmentScroll.setBounds(20,15,750,350);
        Object [][] dataaa = {{"dupa", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki", "cycki"},
                {"dupa", "dupa", "cycki", "dupa", "cycki", "dupa", "dupa", "cycki"}};
        data = dataaa; // DataBaseFactory().getData("sprzet", chosenParams, values );
        equipmentTable = new JTable(data, equipmentTableColumnNames);
        equipmentScroll.setViewportView(equipmentTable);

        equipmentEquipmentIdBox = new JCheckBox();
        equipmentEquipmentIdBox.setBounds(57,375,20,20);
        equipmentTypeBox = new JCheckBox();
        equipmentTypeBox.setBounds(151,375,20,20);
        equipmentBrandBox = new JCheckBox();
        equipmentBrandBox.setBounds(245,375,20,20);
        equipmentParamsBox = new JCheckBox();
        equipmentParamsBox.setBounds(339,375,20,20);
        equipmentConditionBox = new JCheckBox();
        equipmentConditionBox.setBounds(433,375,20,20);
        equipmentLocationIDBox = new JCheckBox();
        equipmentLocationIDBox.setBounds(527,375,20,20);
        equipmentPersonIDBox = new JCheckBox();
        equipmentPersonIDBox.setBounds(621,375,20,20);
        equipmentModelBox = new JCheckBox();
        equipmentModelBox.setBounds(715,375,20,20);

        equipmentEquipmentIdTxt = new JTextField();
        equipmentEquipmentIdTxt.setBounds(27,410,80,20);
        equipmentTypeTxt = new JTextField();
        equipmentTypeTxt.setBounds(121,410,80,20);
        equipmentBrandTxt = new JTextField();
        equipmentBrandTxt.setBounds(215,410,80,20);
        equipmentParamsTxt = new JTextField();
        equipmentParamsTxt.setBounds(309,410,80,20);
        equipmentConditionTxt = new JTextField();
        equipmentConditionTxt.setBounds(403,410,80,20);
        equipmentLocationIDTxt = new JTextField();
        equipmentLocationIDTxt.setBounds(497,410,80,20);
        equipmentPersonIDTxt = new JTextField();
        equipmentPersonIDTxt.setBounds(591,410,80,20);
        equipmentModelTxt = new JTextField();
        equipmentModelTxt.setBounds(685,410,80,20);

        equipmentCard.add(equipmentScroll);
        equipmentCard.add(equipmentEquipmentIdBox);
        equipmentCard.add(equipmentTypeBox);
        equipmentCard.add(equipmentBrandBox);
        equipmentCard.add(equipmentParamsBox);
        equipmentCard.add(equipmentConditionBox);
        equipmentCard.add(equipmentLocationIDBox);
        equipmentCard.add(equipmentPersonIDBox);
        equipmentCard.add(equipmentModelBox);

        equipmentCard.add(equipmentEquipmentIdTxt);
        equipmentCard.add(equipmentTypeTxt);
        equipmentCard.add(equipmentBrandTxt);
        equipmentCard.add(equipmentParamsTxt);
        equipmentCard.add(equipmentConditionTxt);
        equipmentCard.add(equipmentLocationIDTxt);
        equipmentCard.add(equipmentPersonIDTxt);
        equipmentCard.add(equipmentModelTxt);
    }

    private void createActionPanel(){
        actionPanel = new JPanel();
        actionPanel.setLayout(null);
        addButton = new JButton("Add");
        addButton.setBounds(200, 25,100,20);
        addButton.addActionListener(this);
        actionPanel.add(addButton);
        findButton = new JButton("Find");
        findButton.setBounds(350, 25, 100,20);
        findButton.addActionListener(this);
        actionPanel.add(findButton);
        removeButton = new JButton("Remove");
        removeButton.setBounds(500, 25, 100,20);
        removeButton.addActionListener(this);
        actionPanel.add(removeButton);
        orBox = new JCheckBox();
        orBox.setBounds(630,10,20,20);
        orBox.addActionListener(this);
        actionPanel.add(orBox);
        andBox = new JCheckBox();
        andBox.setBounds(630,40,20,20);
        andBox.setSelected(true);
        andBox.addActionListener(this);
        actionPanel.add(andBox);
        alternativeLabel = new JLabel("Alternatywa");
        alternativeLabel.setBounds(660,10, 100, 20);
        actionPanel.add(alternativeLabel);
        conjuctionLabel = new JLabel("Koniunkcja");
        conjuctionLabel.setBounds(660,40, 100, 20);
        actionPanel.add(conjuctionLabel);
        actionPanel.setBounds(0,500, 800, 100);
        add(actionPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == andBox){
            if(andBox.isSelected()) orBox.setSelected(false);
            else orBox.setSelected(true);
        }
        else if(source == orBox){
            if(andBox.isSelected()) andBox.setSelected(false);
            else andBox.setSelected(true);
        }
        else{
            int index = tabbedPane.getSelectedIndex();
            String table;
            DataBaseFactory dataBaseFactory = new DataBaseFactory();
            String linker;
            if(andBox.isSelected()) linker = " AND ";
            else linker = " OR ";
            if(index == 0){
                boolean [] chosenParams = new boolean[9];
                String [] params = new String [9];

                table = "osoby";

                chosenParams[0] = peoplePersonIDBox.isSelected();
                chosenParams[1] = peopleLocationIDBox.isSelected();
                chosenParams[2] = peopleNameBox.isSelected();
                chosenParams[3] = peopleSurnameBox.isSelected();
                chosenParams[4] = peoplePhoneNumberBox.isSelected();
                chosenParams[5] = peopleAddressBox.isSelected();
                chosenParams[6] = peopleMailBox.isSelected();
                chosenParams[7] = peopleLoginBox.isSelected();
                chosenParams[8] = peopleHashBox.isSelected();

                params[0] = peoplePersonIDTxt.getText();
                params[1] = peopleLocationIDTxt.getText();
                params[2] = peopleNameTxt.getText();
                params[3] = peopleSurnameTxt.getText();
                params[4] = peoplePhoneNumberTxt.getText();
                params[5] = peopleAddressTxt.getText();
                params[6] = peopleMailTxt.getText();
                params[7] = peopleLoginTxt.getText();
                params[8] = peopleHashTxt.getText();

                if(source == addButton){
                    dataBaseFactory.addData(table, params);
                }
                else if(source == findButton){
                    DefaultTableModel tableModel =  new DefaultTableModel(dataBaseFactory.getData(table, chosenParams, params, linker), peopleTableColumnNames);
                    peopleTable.setModel(tableModel);
                }
                else{
                    dataBaseFactory.removeData(table, chosenParams, params, linker);
                }
            } else if(index == 1){
                boolean [] chosenParams = new boolean[3];
                String [] params = new String [3];

                table = "lokalizacja";

                chosenParams[0] = locationsLocationIDBox.isSelected();
                chosenParams[1] = locationsCityBox.isSelected();
                chosenParams[2] = locationsPostCodeBox.isSelected();

                params[0] = locationsLocationIDTxt.getText();
                params[1] = locationsCityTxt.getText();
                params[2] = locationsPostCodeTxt.getText();
                if(source == addButton){
                    dataBaseFactory.addData(table, params);
                } else if(source == findButton){
                    DefaultTableModel tableModel =  new DefaultTableModel(dataBaseFactory.getData(table, chosenParams, params, linker), locationsTableColumnNames);
                    locationsTable.setModel(tableModel);
                } else{
                    dataBaseFactory.removeData(table, chosenParams, params, linker);
                }
            } else{
                boolean [] chosenParams = new boolean[8];
                String [] params = new String [8];

                table = "sprzet";

                chosenParams[0] = equipmentEquipmentIdBox.isSelected();
                chosenParams[1] = equipmentTypeBox.isSelected();
                chosenParams[2] = equipmentBrandBox.isSelected();
                chosenParams[3] = equipmentParamsBox.isSelected();
                chosenParams[4] = equipmentConditionBox.isSelected();
                chosenParams[5] = equipmentLocationIDBox.isSelected();
                chosenParams[6] = equipmentPersonIDBox.isSelected();
                chosenParams[7] = equipmentModelBox.isSelected();

                params[0] = equipmentEquipmentIdTxt.getText();
                params[1] = equipmentTypeTxt.getText();
                params[2] = equipmentBrandTxt.getText();
                params[3] = equipmentParamsTxt.getText();
                params[4] = equipmentConditionTxt.getText();
                params[5] = equipmentLocationIDTxt.getText();
                params[6] = equipmentPersonIDTxt.getText();
                params[7] = equipmentModelTxt.getText();
                if(source == addButton){
                    dataBaseFactory.addData(table, params);
                } else if(source == findButton){
                    DefaultTableModel tableModel =  new DefaultTableModel(dataBaseFactory.getData(table, chosenParams, params, linker), equipmentTableColumnNames);
                    equipmentTable.setModel(tableModel);
                } else{
                    dataBaseFactory.removeData(table, chosenParams, params, linker);
                }
            }
        }
    }
}
