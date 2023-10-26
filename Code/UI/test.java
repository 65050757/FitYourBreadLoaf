import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import service.*;
import service.api.bread.BreadAPI;

public class test extends JFrame {


    private APIbreadLoaf breadapi;

    private BreadLoaf selectedBreadLoaf;
    
    private BreadLoaf resultBreadLoaf = new BreadLoaf();

    String result;

    private Convertor convertor;

    private CardLayout cards;
    private JPanel cardPanel;
    private int addButtonCount = 0;
    private ArrayList<String> stringValues = new ArrayList<>();
    private ArrayList<Integer> intValues = new ArrayList<>();

    ImageIcon img1 = new ImageIcon(getClass().getResource("page1.png"));
    ImageIcon img2 = new ImageIcon(getClass().getResource("page2.png"));
    ImageIcon img3 = new ImageIcon(getClass().getResource("page3.png"));

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            test frame = new test();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 920);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public test() {
        createUI();
    }

    private void createUI() {
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);

        cards = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cards);

        JPanel panel1 = createPanel1();
        JPanel panel2 = createPanel2(stringValues,intValues);;
        JPanel panel3 = createPanel3();
        JPanel panel4 = createPanel4();
        JPanel panel5 = createPanel5(stringValues, intValues);;

        cardPanel.add(panel1, "Panel 1");
        cardPanel.add(panel2, "Panel 4");
        cardPanel.add(panel3, "Panel 2");
        cardPanel.add(panel4, "Panel 3");
        cardPanel.add(panel5, "Panel 3");

        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }

    //-----------------------------------------Panel 1--------------------------------------------------
    private JPanel createPanel1() {
        JPanel panel1 = new JPanel();
        JLabel ingredient = new JLabel(img1);
        ingredient.setSize(1200, 920);

        //checkbox1
        JCheckBox checkBox1 = new JCheckBox("Original");
        checkBox1.setBounds(525, 225, 150, 30);
        checkBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox1.isSelected()) {
                    //  Checkbox1 ถูกเลือก
                } else {
                    //  Checkbox1 ไม่ถูกเลือก
                }
            }
        });

        //checkbox2
        JCheckBox checkBox2 = new JCheckBox("Chocolate");
        checkBox2.setBounds(525, 275, 150, 30);
        checkBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox2.isSelected()) {
                    //  Checkbox2 ถูกเลือก
                } else {
                    //  Checkbox2 ไม่ถูกเลือก
                }
            }
        });

        //checkbox3
        JCheckBox checkBox3 = new JCheckBox("Butter");
        checkBox3.setBounds(525, 325, 150, 30);
        checkBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox3.isSelected()) {
                    //  Checkbox3 ถูกเลือก
                } else {
                    //  Checkbox3 ไม่ถูกเลือก
                }
            }
        });

        //checkbox 4
        JCheckBox checkBox4 = new JCheckBox("API");
        checkBox4.setBounds(525, 375, 150, 30);
        checkBox4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox4.isSelected()) {
                    //  Checkbox3 ถูกเลือก
                } else {
                    //  Checkbox3 ไม่ถูกเลือก
                }
            }
        });

        //checkbox 5
        JCheckBox checkBox5 = new JCheckBox("Self Ingredients");
        checkBox5.setBounds(525, 425, 150, 30);
        checkBox5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox5.isSelected()) {
                    //  Checkbox3 ถูกเลือก
                } else {
                    //  Checkbox3 ไม่ถูกเลือก
                }
            }
        });

        ButtonGroup groupBread = new ButtonGroup();
        groupBread.add(checkBox1);
        groupBread.add(checkBox2);
        groupBread.add(checkBox3);
        groupBread.add(checkBox4);
        groupBread.add(checkBox5);

        //NEXT Button
        JButton next = new JButton("NEXT");
        next.setBounds(525, 560, 150, 30);
        next.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if(checkBox4.isSelected()) {
                    cards.next(cardPanel);
                    cards.next(cardPanel);
                }
        		else { cards.next(cardPanel); }
        	}
        });

        panel1.add(ingredient); //panel ใส่รูป ingredient เป็น BG
        ingredient.add(checkBox1); //BG'ingredient'เพิ่ม checkbox เข้าไปในรูป
        ingredient.add(checkBox2);
        ingredient.add(checkBox3);
        ingredient.add(checkBox4);
        ingredient.add(checkBox5);
        ingredient.add(next);
        return panel1;
    }

    //-----------------------------------------Panel 2--------------------------------------------------
    private JPanel createPanel2(ArrayList<String> stringValues, ArrayList<Integer> intValues) {
        JPanel panel2 = new JPanel();
        JLabel ingredient2 = new JLabel(img1);
        ingredient2.setSize(1200, 920);

        JLabel self = new JLabel("Self Ingredients");
        self.setBounds(460, 200, 150, 30);

        // สร้าง TextField
        JButton addButton = new JButton("✚");
        addButton.setBounds(605, 200, 45, 30);

        ArrayList<JTextField> textFields = new ArrayList<>();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButtonCount++;
                int x = 445; int y = 385;
                for (int i = 0; i < 2; i++) {
                    JTextField textField = new JTextField(20);
                    textField.setBounds(x, 30*addButtonCount+y, 150, 25);
                    textFields.add(textField);
                    ingredient2.add(textField);
                    x = 630;
                }
                ingredient2.revalidate();
                ingredient2.repaint();
            }
        });

        //flour--water--butter
        JLabel flour = new JLabel("Flour (g)");
        flour.setBounds(460, 230, 150, 30);
        JLabel water = new JLabel("Water (ml)");
        water.setBounds(460, 260, 150, 30);
        JLabel yeast = new JLabel("Yeast (g)");
        yeast.setBounds(460, 290, 150, 30);
        JLabel butter = new JLabel("Butter (g)");
        butter.setBounds(460, 320, 150, 30);
        JLabel sugar = new JLabel("Sugar (g)");
        sugar.setBounds(460, 350, 150, 30);
        JLabel pan = new JLabel("Pan (cm3)");
        pan.setBounds(460, 380, 150, 30);

        //กรอก
        JTextField s1 = new JTextField(20);
        s1.setBounds(630, 235, 150, 25);
        JTextField s2 = new JTextField(20);
        s2.setBounds(630, 265, 150, 25);
        JTextField s3 = new JTextField(20);
        s3.setBounds(630, 295, 150, 25);
        JTextField s4 = new JTextField(20);
        s4.setBounds(630, 325, 150, 25);
        JTextField s5 = new JTextField(20);
        s5.setBounds(630, 355, 150, 25);
        JTextField s6 = new JTextField(20);
        s6.setBounds(630, 385, 150, 25);

        //NEXT Button
        JButton next2 = new JButton("NEXT");
        next2.setBounds(525, 600, 150, 30);
        next2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                for (JTextField textField : textFields) {
                    stringValues.add(flour.getText());
                    stringValues.add(water.getText());
                    stringValues.add(yeast.getText());
                    stringValues.add(butter.getText());
                    stringValues.add(sugar.getText());

                try {
                    intValues.add(Integer.parseInt(s1.getText()));
                    intValues.add(Integer.parseInt(s2.getText()));
                    intValues.add(Integer.parseInt(s3.getText()));
                    intValues.add(Integer.parseInt(s4.getText()));
                    intValues.add(Integer.parseInt(s5.getText()));
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid Input");
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println(stringValues.get(i));
                    System.out.println(intValues.get(i));
                }
                }

                for (JTextField textField : textFields) {
                    try {
                        int value = Integer.parseInt(textField.getText());
                        // Handle the integer value as needed
                        System.out.println("Value: " + value);
                    } catch (NumberFormatException ex) {
                        // Handle invalid input if needed
                        System.out.println("Invalid Input");
                    }
                }
        		cards.next(cardPanel);
        	}
        });

        panel2.add(ingredient2);
        ingredient2.add(next2);
        ingredient2.add(self);
        //ingredient2.add(checkBoxING1);
        ingredient2.add(addButton);
        ingredient2.add(flour);
        ingredient2.add(water);
        ingredient2.add(yeast);
        ingredient2.add(butter);
        ingredient2.add(sugar);
        ingredient2.add(pan);
        ingredient2.add(s1);
        ingredient2.add(s2);
        ingredient2.add(s3);
        ingredient2.add(s4);
        ingredient2.add(s5);
        ingredient2.add(s6);
        //ingredient2.add(checkBoxING2);
        return panel2;
    }

    //-----------------------------------------Panel 3--------------------------------------------------
    private JPanel createPanel3(){
        JPanel panel3 = new JPanel();
        JLabel Api = new JLabel(img1);
        Api.setSize(1200, 920);

        String[] menuItems;
        try {
            breadapi = new APIbreadLoaf();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int size = breadapi.getImportTool().getMenuList().size();
        menuItems = new String[size];

        int n = 0;

        for(BreadAPI bread: breadapi.getImportTool().getMenuList()){
            menuItems[n++] = bread.getTitle();
        }


        JComboBox<String> foodMenu = new JComboBox<>(menuItems);
        foodMenu.setSelectedIndex(0);
        foodMenu.setBounds(500, 270, 200, 30);

        //Done Button
        JButton done = new JButton("Done");
        done.setBounds(525, 560, 150, 30);
        done.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) foodMenu.getSelectedItem();
                try {
                    breadapi.makeABreadLoaf(selectedOption);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                selectedBreadLoaf = breadapi.getBread();
        		//System.out.println(selectedBreadLoaf);
                cards.next(cardPanel);
        	}
        });

        panel3.add(Api);
        Api.add(foodMenu);
        Api.add(done);
        return panel3;
    }
    //-----------------------------------------Panel 4--------------------------------------------------
    private JPanel createPanel4() {
        JPanel panel4 = new JPanel();
        JLabel loaf = new JLabel(img2);
        loaf.setSize(1200, 920);

        JLabel owner = new JLabel("owner");
        owner.setBounds(525, 390, 150, 30);

        JTextField t1 = new JTextField(20);
        t1.setBounds(525, 440, 150, 30);

        JLabel ownerVol = new JLabel("cm3");
        ownerVol.setBounds(685, 440, 150, 30);

        // สร้าง Checkbox page2 1
        /*JCheckBox checkBoxP21 = new JCheckBox("default");
        checkBoxP21.setBounds(525, 325, 150, 30);

        JLabel defaultVol = new JLabel("??? Nuay rai a");
        defaultVol.setBounds(685, 325, 150, 30);

        // สร้าง Checkbox page2 2
        JCheckBox checkBoxP22 = new JCheckBox("owner");
        checkBoxP22.setBounds(525, 390, 150, 30);

        // สร้าง TextField 
        JTextField textField2 = new JTextField(20);
        textField2.setBounds(525, 440, 150, 30);
        textField2.setEnabled(false); // ปิดการใช้งานเริ่มต้น

        JLabel ownerVol = new JLabel("cm3");
        ownerVol.setBounds(685, 440, 150, 30);

        // ใส่ ActionListener ให้ Checkbox page2
        checkBoxP22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBoxP22.isSelected()) {
                    textField2.setEnabled(true);
                } else {
                    textField2.setEnabled(false);
                }
            }
        });

        ButtonGroup groupP2 = new ButtonGroup();
        groupP2.add(checkBoxP21);
        groupP2.add(checkBoxP22);*/

        //Done Button
        JButton done = new JButton("Done");
        done.setBounds(525, 560, 150, 30);
        done.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                
                String panSizeString = t1.getText();
                //System.out.println(panSizeString);

                convertor = new Convertor(selectedBreadLoaf);
                resultBreadLoaf = convertor.calculateIngredient(Double.parseDouble(panSizeString));

                System.out.println(resultBreadLoaf);
                result = resultBreadLoaf.toString();
                

        		cards.next(cardPanel);
        	}
        });

        panel4.add(loaf);
        //loaf.add(checkBoxP21);
        //loaf.add(defaultVol);
        //loaf.add(checkBoxP22);
        //loaf.add(textField2);
        loaf.add(owner);
        loaf.add(t1);
        loaf.add(ownerVol);
        loaf.add(done);
        return panel4;
    }

    //-----------------------------------------Panel 5--------------------------------------------------
    private JPanel createPanel5(ArrayList<String> stringValues, ArrayList<Integer> intValues) {
        JPanel panel5 = new JPanel();
        JLabel process = new JLabel(img3);
        process.setSize(1200, 900);

        JLabel text = new JLabel("Result");
        text.setBounds(525, 225, 150, 30);

        JLabel label = new JLabel("<html><p>menuName='Autumn Beer Bread</p><p>ingredients=[flour 194.0 gram, pumpkin beer 264.5724050058116 gram, brown sugar 2.3314463733618345 gram, brown sugar 2.329778562011694 gram, baking powder 0.7769669487637185 gram, golden raisins 56.29436727818974 gram, pecans 21.15270380403591 gram, salt 0.38784475886236036 gram]</p><p>panSize=1800.0</p></p><p>process='Depented ou you... Luckily!!</p>/html>");
        // String txt= "menuName='Autumn Beer Bread', ingredients=[flour 194.0 gram, pumpkin beer 264.5724050058116 gram, brown sugar 2.3314463733618345 gram, brown sugar 2.329778562011694 gram, baking powder 0.7769669487637185 gram, golden raisins 56.29436727818974 gram/n, pecans 21.15270380403591 gram, salt 0.38784475886236036 gram], panSize=1245.0, process='Depented ou you... Luckily!!'";
        


        // กำหนดข้อความใน JLabel
        // label.setText(txt);
        label.setBounds(200, 100 , 550, 600);

      

        // เปิดใช้งาน "line wrapping" และ "word wrapping"
       


        //Back Button
        JButton back = new JButton("Back");
        back.setBounds(1050,15,100,50);
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                int i = 0;
                while (i < 4) {
                    cards.previous(cardPanel);
                    i++;
                }
        	}
        });
        
        panel5.add(process);
        process.add(back);        
        process.add(text);
        process.add(label);
        return panel5;
    }
}