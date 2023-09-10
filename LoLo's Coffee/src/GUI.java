

import Merch.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import functions.*;
//import functions.NestedList.NestedItem;




public class GUI {
	
	//Creating GUI Attributes
	private static JFrame mainFrame;
	private static JTabbedPane tabPane;
	private static JPanel foodPanel,teaPanel, espressoPanel, mainPanel, syrupPanel, funcPanel;
	private static JScrollPane displayPane;
	private static JLabel totLabel = new JLabel("$0.00");
	
	
	private static JList drinkList, drinkAddOns;
	
	private static LinkedList< Drinks > Order = new LinkedList<Drinks>();
	private static DefaultListModel<Drinks> drinkModel;
	
	static NestedList nlist;
	
	
	static JButton btnVanilla, btnHazelnut, btnCaramel, btnMocha,btnWhMocha, // syrups
	
	btnVoid, btnTender, btnClear, btnPrint, btnHistory,		  //functions
	btnIced, btnHot, btnSm, btnMd, btnLg,
	
	btnSingle, btnDouble, btnTriple, btnQuad,				  //Shots
	
	btnLatte, btnMatcha, btnCarMac, btnCortado,				  //Espresso
	btnFltWh, btnDChai,
	
	btnLight, btnMedium,btnDark,
	
	btnBlack, btnGreen, btnWhite, btnMint, 					  //Teas
	
	
	btnToast,btnBagel, btnAvoToast, btnGldnOats;						  //Food
	
	
	
	//Drink Object
	static Drinks drink;
	static double total =0.0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initComponents();
		
	}//end Main class
	
	
	
	private static void initJButtons() {
		//JButtons
	    btnIced = new JButton("Iced");
	    btnHot = new JButton("Hot");
	    btnSm = new JButton("Small");
	    btnMd = new JButton("Medium");
	    btnLg = new JButton("Large");
	    
	    btnVoid = new JButton("Void");
	    btnTender = new JButton("Tender");
	    
	    btnVanilla = new JButton("Vanilla");
	    btnCaramel = new JButton("Caramel");
	    btnHazelnut = new JButton("Hazelnut");
	    btnMocha = new JButton("Mocha");
	    btnWhMocha = new JButton("White Mocha");
	    
	    btnSingle = new JButton(String.valueOf(Drinks.Espresso.Single));
	    btnDouble = new JButton(String.valueOf(Drinks.Espresso.Double));
	    btnTriple = new JButton(String.valueOf(Drinks.Espresso.Triple));
	    btnQuad = new JButton(String.valueOf(Drinks.Espresso.Quad));
	    btnLatte = new JButton(String.valueOf(Drinks.Espresso.Latte));
	    btnMatcha = new JButton(String.valueOf(Drinks.Espresso.Matcha));
	    btnCarMac = new JButton(String.valueOf(Drinks.Espresso.Caramel_Macchiato).replace("_", " "));
	    btnCortado = new JButton(String.valueOf(Drinks.Espresso.Cortado));
	    btnFltWh = new JButton(String.valueOf(Drinks.Espresso.Flat_White).replace("_", " "));
	    btnDChai = new JButton(String.valueOf(Drinks.Espresso.Cortado));
	    
	    btnBlack = new JButton(String.valueOf(Drinks.Teas.Black));
	    btnWhite = new JButton(String.valueOf(Drinks.Teas.White));
	    btnGreen = new JButton(String.valueOf(Drinks.Teas.Green));
	    btnMint = new JButton(String.valueOf(Drinks.Teas.Mint));
	    
	    //Function Buttons
	    btnVoid.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		 
	    		 int index = drinkList.getSelectedIndex();
	    		 if(index > -1)
	    			 //nlist.remove(index);
	    			 drinkModel.remove(index);
	    		 
	    		 Drinks d = Order.get(index);
	    		 
	    		 total -= d.getPrice();
	    		 totLabel.setText("$"+String.valueOf(total));
	    		 
	    		 
	    		 
	    	  }
	    });
	    
	    btnTender.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		      		  
	    		 
	    	  }
	    });
	    
	    //button functions (methods)
	    btnSingle.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.Single, 1.25);
	    		  Order.add(drink);
	    		  drinkModel.addElement(drink);
	    		  
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk()) });
	    		  
	    		  calcTotal();
	    		 
	    	  } 
	    	  
	    });
	    
	    btnDouble.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.Double, 2.75);
	    		  Order.add(drink);
	    		  drinkModel.addElement(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk()),String.valueOf(drink.getPrice()) });
	    		  calcTotal();
	    		  
	    		  
	    	  } 
	    });
	    
	    btnTriple.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.Triple, 4.25);
	    		  Order.add(drink);
	    		  drinkModel.addElement(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk()) });
	    		  calcTotal();
	    		  
	    	  } 
	    });
	    
	    btnQuad.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.Quad, 4.5);
	    		  Order.add(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk()) });
	    		  calcTotal();
	    		  
	    	  } 
	    });
	    
	    btnLatte.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.Latte,4.75);
	    		  Order.add(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk()) });
	    		  calcTotal();
	    		  
	    	  } 
	    });
	    
	    btnFltWh.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.Flat_White, 4.0);
	    		  Order.add(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk())});
	    		  calcTotal();
	    		  
	    	  } 
	    });
	    
	    btnDChai.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.DChai,5);
	    		  Order.add(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk())});
	    		  calcTotal();
	    		  
	    	  } 
	    });
	    
	    btnMatcha.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.Matcha,5);
	    		  Order.add(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk())});
	    		  calcTotal();
	    		  
	    	  } 
	    });
	    
	    btnCarMac.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.Caramel_Macchiato, 5.25, new String[] {String.valueOf(Drinks.Syrups.Vanilla)});
	    		  Order.add(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk())});
	    		  calcTotal();
	    		  
	    	  }
	    });
	    
	    btnCortado.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Espresso.Cortado, 3.75,Drinks.Milks.Half);
	    		  Order.add(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk())});
	    		  calcTotal();
	    		  
	    	  } 
	    });
	    
	    // Syrups Buttons
	    btnVanilla.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  
	    		  
	    	  } 
	    });
	    
	    btnCaramel.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  
	    		  
	    		  
	    	  } 
	    });
	    
	    btnMocha.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  
	    		  
	    	  } 
	    });
	    
	    btnWhMocha.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  
	    		  
	    	  } 
	    });
	    
	    btnHazelnut.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  
	    		  
	    	  } 
	    });
	    
	    //Teas buttons
	    btnBlack.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  //md=3.75 lg=4
	    		  
	    		  drink = new Drinks(Drinks.Teas.Black,2.75);
	    		  Order.add(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk())});
	    		  calcTotal();
	    	  } 
	    });
	    
	    btnWhite.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Teas.White,2.75);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk())});
	    		  calcTotal();
	    		  
	    	  } 
	    });
	    
	    btnGreen.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  drink = new Drinks(Drinks.Teas.Green,2.75);
	    		  Order.add(drink);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk())});
	    		  calcTotal();
	    	  } 
	    });
	    
	    btnMint.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {

	    		  
	    		  drink = new Drinks(Drinks.Teas.Mint,2.75);
	    		  nlist.addItem(String.valueOf(drink.getDrink()),
	    				  new String[] { String.valueOf(drink.getMilk())});
	    		  calcTotal();
	    	  } 
	    });
	    
	    
	}// end initJButton()
	
	
	
	
	
	private static void initComponents() {
		
		initJButtons();
		
		drinkModel = new DefaultListModel<Drinks>();
		
		drinkList = new JList(drinkModel);
		drinkAddOns = new JList();
		
		drinkList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		drinkList.setLayoutOrientation(JList.VERTICAL);
		drinkList.setVisibleRowCount(-1);
		
		
		nlist = new NestedList();
		
	    displayPane = new JScrollPane(drinkList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    tabPane = new JTabbedPane();
	    
	    mainPanel = new JPanel();
	    espressoPanel = new JPanel();
	    teaPanel = new JPanel();
	    syrupPanel = new JPanel();
	    foodPanel = new JPanel();
	    funcPanel = new JPanel();
	    
	    
	    
	    
	    //Espresso's layout
	    GroupLayout espressolayout = new GroupLayout(espressoPanel);
	    espressoPanel.setLayout(espressolayout);
	    espressolayout.setAutoCreateGaps(true);
	    espressolayout.setAutoCreateContainerGaps(true);
	    
	    espressolayout.setHorizontalGroup(
		    	espressolayout.createSequentialGroup()
		    	.addGroup(espressolayout.createParallelGroup()
	    				.addComponent(btnSingle,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnLatte,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnFltWh,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		    	.addGroup(espressolayout.createParallelGroup()
	    				.addComponent(btnDouble,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnMatcha,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnDChai,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		    	.addGroup(espressolayout.createParallelGroup()
	    				.addComponent(btnTriple,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnCarMac,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		    	.addGroup(espressolayout.createParallelGroup()
	    				.addComponent(btnQuad,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnCortado,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	    
	    espressolayout.setVerticalGroup(
	    		espressolayout.createSequentialGroup()
	    		.addGroup(espressolayout.createParallelGroup()
	    				.addComponent(btnSingle,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    		    	.addComponent(btnDouble,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    		    	.addComponent(btnTriple,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    		    	.addComponent(btnQuad,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    		.addGroup(espressolayout.createParallelGroup()
	    				.addComponent(btnLatte,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnMatcha,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnCarMac,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnCortado,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    		.addGroup(espressolayout.createParallelGroup()
	    				.addComponent(btnFltWh,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(btnDChai,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	    
	    
	    // Teas's layout
	    GroupLayout tealayout = new GroupLayout(teaPanel);
	    teaPanel.setLayout(tealayout);
	    
	    tealayout.setAutoCreateGaps(true);
	    tealayout.setAutoCreateContainerGaps(true);
	    
	    tealayout.setHorizontalGroup(
		    	tealayout.createSequentialGroup()
		    	.addComponent(btnBlack)
		    	.addComponent(btnWhite)
		    	.addComponent(btnGreen)
		    	.addComponent(btnMint)
	    );
	    
	    tealayout.setVerticalGroup(
	    		tealayout.createSequentialGroup()
	    		.addGroup(tealayout.createParallelGroup()
	    				.addComponent(btnBlack)
	    		    	.addComponent(btnWhite)
	    		    	.addComponent(btnGreen)
	    		    	.addComponent(btnMint))
	    );
	    
	    
	    // Syrup's layout
	    GroupLayout syruplayout = new GroupLayout(syrupPanel);
	    syrupPanel.setLayout(syruplayout);
	    
	    syruplayout.setHorizontalGroup(
		    	syruplayout.createSequentialGroup()
		    	.addComponent(btnVanilla)
		    	.addComponent(btnHazelnut)
		    	.addComponent(btnMocha)
		    	.addComponent(btnWhMocha)
		    	
	    );
	    
	    syruplayout.setVerticalGroup(
	    		syruplayout.createSequentialGroup()
	    		.addGroup(syruplayout.createParallelGroup()
	    				.addComponent(btnVanilla)
	    				.addComponent(btnHazelnut)
	    				.addComponent(btnMocha)
	    				.addComponent(btnWhMocha))
	    				
	    );
	    
	  //function layout
	    GroupLayout funclayout = new GroupLayout(funcPanel);
	    funcPanel.setLayout(funclayout);
	    
	    funclayout.setAutoCreateGaps(true);
	    funclayout.setAutoCreateContainerGaps(true);
	    
	    funclayout.setHorizontalGroup(
		    	funclayout.createParallelGroup()
		    	.addComponent( displayPane )
		    	.addGroup(funclayout.createSequentialGroup()
		    			.addComponent(btnVoid)
		    			.addComponent(btnTender)
		    			.addComponent(totLabel))
		    	
	    );
	    
	    funclayout.setVerticalGroup(
	    		funclayout.createSequentialGroup()
	    		.addComponent( displayPane )
	    		.addGroup(funclayout.createParallelGroup( )
	    				.addComponent(btnVoid)
	    				.addComponent(btnTender)
	    				.addComponent(totLabel))
	    		
	    );
	    
	    
	    //Main frame's layout
	    GroupLayout layout = new GroupLayout(mainPanel);
	    mainPanel.setLayout(layout);
	    
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
	    
	    layout.setHorizontalGroup(
		    	layout.createSequentialGroup()
		    	.addComponent(funcPanel)
		    	.addComponent(tabPane)
		    	
	    	
	    );
	    
	    layout.setVerticalGroup(
	    		layout.createSequentialGroup()
	    		.addGroup(layout.createParallelGroup()
	    				.addComponent(funcPanel)
	    				.addComponent(tabPane))
	    );
	    
	    tabPane.add("Espresso",espressoPanel);
	    tabPane.add("Teas",teaPanel);
	    tabPane.add("Syrup",syrupPanel);
	    tabPane.add("Food",foodPanel);
	   
	    initFrame();
	    
	}// initComponents()
	
	
	
	private static void initFrame() {
		//JFrames
		mainFrame = new JFrame("Lolo's Coffee shop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(mainPanel);
	    mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    mainFrame.setUndecorated(false);
	    mainFrame.pack();
	    mainFrame.setVisible(true);
				
	}// initFrames()
	
	private static void calcTotal() {
		
		total=0.0;
		for(Drinks d: Order ) {
			total += d.getPrice();
		}
		  
		totLabel.setText("$"+String.valueOf(total));
		
	}//end calcTotal
	
	
}//end GUI Class
