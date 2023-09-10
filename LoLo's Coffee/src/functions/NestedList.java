package functions;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class NestedList extends JPanel implements ListSelectionListener
{
	private DefaultListModel model = new DefaultListModel();
	
	private JList drinkList = new JList(model);
	private JList drinkAddOns = new JList();

	public NestedList()
	{
		super(new GridLayout(0, 2));
		add(drinkList);
		add(drinkAddOns);
		
		drinkList.addListSelectionListener(this);
		drinkList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	}
	
	public void addItem(String item, String[] subitems)
	{
		model.addElement(new NestedItem(item, subitems));
	}
	
	public void valueChanged(ListSelectionEvent e)
	{
		if (e.getValueIsAdjusting() == false) {

	        if (drinkList.getSelectedIndex() == -1) {
	        //No selection, disable fire button.
	            //btnVoid.setEnabled(false);

	        } else {
	        //Selection, enable the fire button.
	           // btnVoid.setEnabled(true);
	        }
	    }
		
		
		NestedItem item = (NestedItem) drinkList.getSelectedValue();
		drinkAddOns.setModel(item.subitems);
		
	}
	
	

	private static class NestedItem
	{
		private String item = null;
		private DefaultListModel subitems = 
                   new DefaultListModel();
		
		NestedItem(String item, String[] subitems)
		{
			this.item = item;
			for (String subitem : subitems)
			this.subitems.addElement(subitem);
		}
		
		public String toString()
		{
			return item;
		}
	}
	
	/**
	 * @param args
	 */
//	public static void main(String[] args)
//	{
//		JFrame frame = new JFrame("Nested Lists");
//		frame.setDefaultCloseOperation(
//                    JFrame.DISPOSE_ON_CLOSE);
//		NestedList list = new NestedList();
//		list.addItem("numbers", 
//                   new String[] { "1", "2", "3" });
//		list.addItem("letters", 
//                   new String[] { "A", "B", "C" });
//		list.addItem("symbols", 
//                   new String[] { "+", "=", ">", "?" });
//		frame.add(list);
//		frame.pack();
//		frame.setVisible(true);
//	}
}

