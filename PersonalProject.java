import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class PersonalProject extends JFrame implements ActionListener {

	static String name;
	static PersonalProject frame;
	int breakLength;
	String bL = "";
	JPanel panel = new JPanel();

	//ArrayLists
	static ArrayList<String> taskNames = new ArrayList<String>(); 
	static ArrayList<Integer> taskTimes = new ArrayList<Integer>();	
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<JButton> breakButtons = new ArrayList<JButton>();

	//JTextFields
	JTextField inputTask = new JTextField(12);
	JTextField inputTime = new JTextField(7);	
	JTextField breakTime = new JTextField(3);	

	//JLabels
	JLabel top = new JLabel("<html><div style='text-align: center;'>" +name + "'s Schedule</div></html>");
	JLabel taskLabel = new JLabel("Enter the name of the task");
	JLabel timeLabel = new JLabel("Enter the time taken in minutes");
	JLabel breakLabel = new JLabel();
	JLabel present = new JLabel();

	//Jbuttons
	JButton addTask = new JButton("Add Task");
	JButton makeSchedule = new JButton("Make me a new schedule!");
	JButton task;
	JButton clearSchedule = new JButton("Clear the Schedule");
	JButton Break;

	//GridBag Layout for frame and panel
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints layoutConst = new GridBagConstraints();
	GridBagLayout layoutPanel = new GridBagLayout();
	GridBagConstraints layoutConstPanel = new GridBagConstraints();

	//Color definitions
	Color turqoise= new Color(66, 158, 166);
	Color white= new Color(255, 255, 240);
	Color pink = new Color (249, 187, 156);
	Color purple = new Color (21, 59, 80);

	public PersonalProject(){
		breakLabel.setText("Change the length of your break");		
		this.setSize(800, 500);
		this.getContentPane().setBackground(purple);
		this.setLayout(layout);
		panel.setLayout(layoutPanel);

		top.setForeground(Color.WHITE);
		panel.setBackground(turqoise);
		panel.add(top);
		panel.setSize(300, 600);
		//Layout for frame
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		taskLabel.setForeground(Color.WHITE);
		this.add(taskLabel, layoutConst);		
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		this.add(inputTask, layoutConst);
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		timeLabel.setForeground(Color.WHITE);
		this.add(timeLabel, layoutConst);
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		breakLabel.setForeground(Color.WHITE);
		this.add(breakLabel, layoutConst);		
		layoutConst.gridx = 1;
		layoutConst.gridy = 3;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		this.add(breakTime, layoutConst);		
		layoutConst.gridx = 1;
		layoutConst.gridy = 5;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		this.add(clearSchedule, layoutConst);		
		layoutConst.gridx = 1;
		layoutConst.gridy = 2;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		this.add(inputTime, layoutConst);
		layoutConst.gridx = 0;
		layoutConst.gridy = 4;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		this.add(addTask, layoutConst);
		layoutConst.gridx = 6;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets (10, 10, 10, 10);		
		this.add(present, layoutConst);
		layoutConst.gridx = 0;
		layoutConst.gridy = 5;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		this.add(makeSchedule, layoutConst);

		addTask.addActionListener(this);
		//		addTask.setHorizontalAlignment(SwingConstants.CENTER);
		//		addTask.setHorizontalTextPosition(SwingConstants.CENTER);
		makeSchedule.addActionListener(this);
		clearSchedule.addActionListener(this);
		layoutConst.gridx = 0;
		layoutConst.gridy = 6;
		layoutConst.insets = new Insets (10, 10, 10, 10);
		this.add(panel, layoutConst);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) throws FileNotFoundException {
		name = JOptionPane.showInputDialog(null, "As you know, finals week is approaching and the only way\n "
				+ "I can get through it is by planning what I have to do everyday.\n "
				+ "I use the Pomodoro Method where I set a timer for myself, \n"
				+ "finish my tasks without any distraction and then take a small break.\n"
				+ "This was my inspiration for this assignment.\n\n "
				+ "To add a small touch of personalization, please enter your preferred name");
		//String answer = JOptionPane.showInputDialog(null, "Is this your first time using this scheduler, please enter exactly yes or no");
		//	if (answer == null ||(answer.equalsIgnoreCase(""))) {
		try {
			JOptionPane.showMessageDialog(null,"In this program, you enter in the task and time taken.\n" +  
					"If you would like to customize your break time, enter the amount of time for break before you click add schedule.\n" 
					+"(Default value is 10 minutes for tasks more than 45 minutes less than 90 minutes and 20 minutes otherwise).\n"
					+"Click make schedule once you're done adding tasks.\n "
					+"Click on each task once you are done to mark that you have finished it!");
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		//} else if (answer.equalsIgnoreCase("no")){

		//reads file
		try {
			FileReader fileR = new FileReader(name +"MyFile.txt");
			if (name.equals("")) {
			}else {
				BufferedReader reader = new BufferedReader(fileR);
				String line = "";
				while ((line = reader.readLine()) != null){
					String task= "";
					String sTime = "";
					int time = 0;
					int takes = 0;
					//for (int i = 0; i <line.length(); i++) {
					//if (i == line.indexOf(" ")) {
					task = line.substring(0, line.indexOf(" "));
					taskNames.add(task);
					System.out.println("task: " + task);
					takes = line.indexOf("takes") + 6;
					System.out.println("takes: " + takes);
					String lineTemp = line.substring(takes); 
					System.out.println("lineTemp: " + lineTemp);
					sTime = lineTemp.substring(0, lineTemp.indexOf(" "));
					System.out.println("sTime: " + sTime);
					time = Integer.parseInt(sTime);
					taskTimes.add(time);
					//}
					//}
				}
				reader.close();
				//				}catch (IOException e) {
				//					e.printStackTrace();
			}
		}catch (FileNotFoundException f) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//}
		frame = new PersonalProject();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				FileWriter writer;
				if (name.equals(null)) {
					try {
						writer = new FileWriter("MyFile.txt");
						for (int i = 0 ; i <taskNames.size(); i++) {
							if(buttons.get(i).isEnabled()) {
								writer.write(taskNames.get(i) + " takes "+taskTimes.get(i)+" minutes.");	
								writer.write("\r\n");   
							}
						}
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					try {
						writer = new FileWriter(name+"MyFile.txt");
						for (int i = 0 ; i <taskNames.size(); i++) {
							if(buttons.get(i).isEnabled()) {
								writer.write(taskNames.get(i) + " takes "+taskTimes.get(i)+" minutes.");	
								writer.write("\r\n");   
							}  
						}
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}


		});


		//add task button functions
		if (e.getSource()==addTask) {
			String input = inputTask.getText();
			if (input.equals("")) {
				JOptionPane.showMessageDialog(this, "Please provide a task name before adding tasks", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			taskNames.add(input);
			String text = inputTime.getText();
			try { 
				int inTime = Integer.parseInt(text);
				if (inTime <0) {
					JOptionPane.showMessageDialog(this, "Please provide a positive number for the time taken (as an integer) to finish tasks before adding tasks", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}else {
					taskTimes.add(inTime);	
				}
			}catch(NumberFormatException e5){
				JOptionPane.showMessageDialog(this, "Please provide the time taken (as an integer) to finish tasks before adding tasks", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			bL = breakTime.getText();
			breakTime.setText("");
			inputTask.setText("");
			inputTime.setText("");
			//breakTime.setText("");


			//make schedule button functions
		}else if (e.getSource()==makeSchedule) {
			if(taskNames.size() == 0) {
				JOptionPane.showMessageDialog(this, "Please enter tasks before trying to make a schedule", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				while (!buttons.isEmpty()) {
					panel.remove(buttons.get(0));
					buttons.remove(0);
				}
				while (!breakButtons.isEmpty()) {
					panel.remove(breakButtons.get(0));
					breakButtons.remove(0);
				}
				System.out.println(buttons);
				System.out.println(breakButtons);
				//				for (int i = 0; i < buttons.size(); i++) {
				//					panel.remove(buttons.get(0));
				//				}
				//				buttons.clear();
				int count = 0;
				for (int i = 0; i < taskNames.size(); i++) {
					System.out.println(taskNames.get(i) + taskTimes.get(i));
					if (taskNames.get(i).equals("")) continue;
					else {
						count += taskTimes.get(i);
						task = new JButton(taskNames.get(i) + " takes "+taskTimes.get(i)+" minutes.");
						task.setBackground(white);
						task.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) { 
								//((JButton)e.getSource() ).setBackground(Color.DARK_GRAY); //button is not working
								( (JButton)e.getSource() ).setEnabled(false);
							}
						});
						buttons.add(task);
						//					task.addActionListener((ActionEvent ee) -> {
						//						ee.getSource();
						//					});
						//	buttons.get(i).addActionListener(new ActionListener() {
						//						@Override
						//						public void actionPerformed(ActionEvent e) { 
						//							//( (JButton)e.getSource() ).setBackground(turqoise); //button is not working
						//							System.out.println("DEBUG"); //DEBUG
						//							( (JButton)e.getSource() ).setEnabled(false);
						//						}
						//					});
						layoutConstPanel.gridx = 0;
						layoutConstPanel.gridy = i+1;
						layoutConstPanel.insets = new Insets (10, 10, 10, 10);		

						//writes breaks
						if (count >45 && count<90) {
							if (bL.equals("")) {
								breakLength = 10;							
							}else {
								breakLength = Integer.parseInt(bL);							
							}
							Break = new JButton("Break takes "+ breakLength +" minutes");
							Break.setBackground(pink);
							Break.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent e) { 
									//((JButton)e.getSource() ).setBackground(Color.DARK_GRAY); //button is not working
									//									if (e.getSource() == Break ) {
									//									Break.setEnabled(false);
									//									}
									( (JButton)e.getSource() ).setEnabled(false);
								}
							});
							breakButtons.add(Break);
							//buttons.add(new JButton("Break takes 10 minutes"));
							layoutConstPanel.gridx = 6;
							layoutConstPanel.gridy = i+2;
							layoutConstPanel.insets = new Insets (10, 10, 10, 10);		
							count =0;
							buttons.add(Break);
							//frame.add(Break, layoutConst);
						} else if (count >=90) {
							if (bL.equals("")) {
								breakLength = 20;							
							}else {
								breakLength = Integer.parseInt(bL);							
							}
							Break = new JButton("Break takes "+ breakLength +" minutes");
							Break.setBackground(pink);
							Break.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent e) { 
									//((JButton)e.getSource() ).setBackground(Color.DARK_GRAY); //button is not working
									//									if (e.getSource() == Break ) {
									//										Break.setEnabled(false);
									//									}
									( (JButton)e.getSource() ).setEnabled(false);
								}
							});
							breakButtons.add(Break);
							//buttons.add(new JButton("Break takes 20 minutes"));
							layoutConstPanel.gridx = 6;
							layoutConstPanel.gridy = i+2;
							layoutConstPanel.insets = new Insets (10, 10, 10, 10);		
							count =0;
							buttons.add(Break);
							//frame.add(Break, layoutConst);
						}
						present.setText(taskNames.get(i)+" "+taskTimes.get(i));
						present.setText("");
					}
				}
				for (int i = 0; i <buttons.size(); i++) {
					layoutConstPanel.gridx = 6;
					layoutConstPanel.gridy = i+1;
					layoutConstPanel.insets = new Insets (10, 10, 10, 10);		
					panel.add(buttons.get(i), layoutConstPanel); 
				}

				//writes all the tasks into files

			} catch (IndexOutOfBoundsException IOBE) {
				JOptionPane.showMessageDialog(this, "Please enter tasks before trying to make a schedule", "Error", JOptionPane.ERROR_MESSAGE);
			}

			//clears the schedule
		}else if (e.getSource()==clearSchedule) {
			System.out.println("button pressed");
			//			for (int i = 0; i < buttons.size();i++) {
			//				panel.remove(buttons.get(0));
			//				buttons.remove(0);
			//				//frame.remove(buttons.get(0));
			//				//frame.remove(Break);
			//			}
			while (!buttons.isEmpty()) {
				panel.remove(buttons.get(0));
				buttons.remove(0);

			}
			while (!breakButtons.isEmpty()) {
				panel.remove(breakButtons.get(0));
				breakButtons.remove(0);
			}
			System.out.println(buttons);
			System.out.println(breakButtons);

			//			for (int i = 0; i < breakButtons.size(); i++) {
			//				panel.remove(breakButtons.get(i));
			//				breakButtons.remove(i);
			//			}
			//			if(Break!= null)
			//				panel.remove(Break);
			//buttons.clear();
			System.out.println(buttons);

			//clears the file
			FileWriter writer;
			if (name.equals(null)) {
				try {
					writer = new FileWriter("MyFile.txt");
					writer.write("");	
					writer.close();
					taskNames.clear();
					taskTimes.clear();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}else {
				try {
					writer = new FileWriter(name+"MyFile.txt");
					writer.write("");	
					writer.close();
					taskNames.clear();
					taskTimes.clear();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			frame.setVisible(true);
		} 
	}
}