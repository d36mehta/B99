/*Brooklyn Nine-Nine Quiz
 * May 10, 2019 to June 6, 2019
 * Catherine, Drasti, Nicole
 * The purpose of this program is to quiz users on their knowledge * on Brooklynn Nine-Nine, through seasons 1 to 5. */
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
public class B99 {
	/*Order of static variables from character menus: * 0. Main Menu
	 * 1. Characters
	 * 2. Specials
	 * 3. Episode Plots
	 * 4. Who Said What * 5. Slang
	 * 6. Mug Shots
	 * 7. Answers */
	//Frames
	static JFrame mainFrame = new JFrame ("Main Menu");
	static JFrame mugMenuFrame = new JFrame ("Mug Shot Menu"); static JFrame answersFrame = new JFrame ("Answers");
	static JFrame contentFrame[] = new JFrame [5];
	static JFrame charFrame[] = new JFrame [3];
	static JFrame specFrame[] = new JFrame [3];
	static JFrame epiFrame[] = new JFrame [3];
	static JFrame whoFrame[] = new JFrame [3];
	static JFrame slanFrame[] = new JFrame [3];
	//Colours
	static Color blue1 = Color.decode("#A9B4EC"); 
	static Color yellow1 = Color.decode("#ECE5A9"); 
	static Color red1 = Color.decode("#C72C2C");
	static Color green1 = Color.decode("#589F61"); 
	static Color pink1 = Color.decode("#AF5B5B");
	//Font
	static Font titleFont = new Font ("TimesRoman", Font.BOLD, 24); 
	static Font otherFont = new Font ("Arial", Font.PLAIN, 16);
	static Font buttonFont = new Font ("Arial", Font.BOLD, 16);
	//Labels
	static JLabel titleMain, instruc, mainBlank;
	static JLabel titleMenu[] = new JLabel [5], titleInstructQ[] = new JLabel[3], titleCharQ[] = new JLabel [3], charLbl [] = new JLabel [3], charPicLbl [] = new JLabel[3], charNameLbl;
	static JLabel titleSpecial,instrucSpecial,spQ[]= new JLabel[3],spQT[]= new JLabel[3],spQT2[]=new JLabel[3];
	static JLabel titleEpisode,instrucEpisode,epQ[]= new JLabel[3],epQT[]= new JLabel[3],epQT2[]=new JLabel[3];
	static JLabel titleWho, titleWhoInstruct;
	static JLabel titleWhoQ [] = new JLabel [3];
	static JLabel instructWhoQ [] = new JLabel [3];
	static JLabel pointWhoQ [] = new JLabel [3];
	static JLabel stateWhoQ [] = new JLabel [3];
	static JLabel picWhoLbl [] =new JLabel [12];
	static JLabel titleSlanQ[] = new JLabel [3], slanLbl[] = new JLabel [3];
	static JLabel titleMug, titleMugInstruct, mugPicA, mugPicB, mugPicC, mugPicD, mugQA, mugQB, mugQC, mugQD;
	static JLabel titleAnswer,finalPoints, picAnsLbl [] = new JLabel [3];
	//Strings
	static String epAnswer[]= new String [3];
	//Integers
	static int pointsQ1=0,pointsQ2=0,pointsQ3=0,countQ1=0,countQ2=0,countQ3=0, totalPoints=0;
	//Check boxes
	static JCheckBox spA1[]= new JCheckBox[4],spA2[]= new JCheckBox[4],spA3[]= new JCheckBox[4];
	//Radio buttons
	static JRadioButton who[] = new JRadioButton [12]; 
	static ButtonGroup whoGroup1, whoGroup2, whoGroup3; 
	static ButtonGroup slanGroup1, slanGroup2, slanGroup3; 
	static JRadioButton tfSlan[] = new JRadioButton [6];
	//Lists
	static List listAnswer;
	//Images
	static ImageIcon picWho [] = new ImageIcon [12];
	static ImageIcon picChar1 = new ImageIcon ("Boyle.jpg"); 
	static ImageIcon picChar2 = new ImageIcon ("Pimento.jpg"); 
	static ImageIcon picMug1 = new ImageIcon ("Doug Judy.jpg"); 
	static ImageIcon picMug2 = new ImageIcon ("Melanie.jpg"); 
	static ImageIcon picMug3 = new ImageIcon ("Wuntch.jpg"); 
	static ImageIcon picMug4 = new ImageIcon ("Jimmy.jpg"); 
	static ImageIcon picAns [] = new ImageIcon [3];
	//Text fields
	static JTextField txtChar [] = new JTextField [3]; 
	static JTextField epA[]= new JTextField[3]; 
	static JTextField txtMug[] = new JTextField [4];
	//Buttons
	static JButton btnMenuChar, btnMenuSpec, btnMenuEpi, btnMenuWho, btnMenuSlan, btnMenuMug, btnFinishMain, btnQuit;
	static JButton btnQ[] = new JButton [15];
	static JButton btnCharQ[] = new JButton [3];
	static JButton spBQ[]=new JButton[3];
	static JButton epBQ[]=new JButton[3];
	static JButton btnWhoQ[] = new JButton [3];
	static JButton btnSlangQ[] = new JButton [3];
	static JButton btnExit [] = new JButton [22];

	static JButton btnSubmit [] = new JButton [16]; 
	static JButton endGame;
	//Other
	static JOptionPane error = new JOptionPane ();
	
	
	private static void guiApp () {
		//Declare frames
		mainFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //main menu 
		mugMenuFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //mug menu 
		answersFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //answers menu
		for (int i=0; i<5; i++) {
			contentFrame[i] = new JFrame ("Questions"); 
			contentFrame[i].setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		}
		for (int i=0; i<3; i++) {
			charFrame[i] = new JFrame ("Question "+(i+1));
			specFrame[i] = new JFrame ("Question "+(i+1));
			epiFrame[i] = new JFrame ("Question "+(i+1));
			whoFrame[i] = new JFrame("Question "+(i+1));
			slanFrame[i] = new JFrame ("Question "+(i+1)); charFrame[i].setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //character frame 
			specFrame[i].setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //specials frame 
			epiFrame[i].setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //episode frame 
			whoFrame[i].setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //who said what
			slanFrame[i].setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // slang frame
		}
		//Main frame menu
		JPanel panel = new JPanel(new GridLayout(3, 1));
		JPanel panel1 = new JPanel(new GridLayout (2, 1));
		panel1.setBackground(blue1);
		JPanel panel2 = new JPanel (new GridLayout (2,3,10,10)); panel2.setBackground(blue1);
		JPanel panel3 = new JPanel (new GridLayout (1,2));
		panel3.setBackground(blue1);
		titleMain= new JLabel("Brooklyn 99 Quiz",JLabel.CENTER); titleMain.setForeground(Color.DARK_GRAY);
		titleMain.setFont(titleFont);
		instruc= new JLabel("Choose the type of question you want to answer from the selection below.",JLabel.CENTER); instruc.setForeground(Color.DARK_GRAY); instruc.setFont(otherFont);
		//Buttons to open sub menus
		btnMenuChar = new JButton("Characters"); btnMenuChar.setBackground(yellow1); btnMenuChar.setFont(otherFont);
		btnMenuSpec = new JButton("Episode Specials"); btnMenuSpec.setBackground(yellow1); btnMenuSpec.setFont(otherFont);

		btnMenuEpi = new JButton("Episode Plots"); btnMenuEpi.setBackground(yellow1); btnMenuEpi.setFont(otherFont);
		btnMenuWho = new JButton("Who Said What"); btnMenuWho.setBackground(yellow1); btnMenuWho.setFont(otherFont);
		btnMenuSlan = new JButton("Slang"); btnMenuSlan.setBackground(yellow1); btnMenuSlan.setFont(otherFont);
		btnMenuMug = new JButton("Mug Shots"); btnMenuMug.setBackground(yellow1); btnMenuMug.setFont(otherFont);
		btnFinishMain=new JButton("Finish/View Answers"); btnFinishMain.setBackground(pink1);
		btnFinishMain.setFont(otherFont); btnQuit = new JButton ("Quit"); btnQuit.setBackground(pink1);
		btnQuit.setFont(otherFont);
		ButtonHandlerMain main = new ButtonHandlerMain (); 
		btnMenuChar.addActionListener (main);
		btnMenuSpec.addActionListener (main); 
		btnMenuEpi.addActionListener (main); 
		btnMenuWho.addActionListener (main); 
		btnMenuSlan.addActionListener (main); 
		btnMenuMug.addActionListener (main); 
		btnFinishMain.addActionListener(main); 
		btnQuit.addActionListener(main);
		panel1.add(titleMain); panel1.add(instruc);
		panel2.add(btnMenuChar); 
		panel2.add(btnMenuSpec); 
		panel2.add(btnMenuEpi); 
		panel2.add(btnMenuWho); 
		panel2.add(btnMenuSlan); 
		panel2.add(btnMenuMug);
		panel3.add(btnQuit); 
		panel3.add(btnFinishMain); 
		panel.add(panel1); 
		panel.add(panel2); 
		panel.add(panel3);
		Container contentPane = mainFrame.getContentPane (); 
		contentPane.add (panel1, BorderLayout.PAGE_START); 
		contentPane.add (panel2, BorderLayout.CENTER); 
		contentPane.add (panel3, BorderLayout.PAGE_END); 
		mainFrame.setSize (550, 350);
		mainFrame.setVisible (true); 
		////////////////////////////////////////////

		//Sub Menus (excluding Mug Shots) 
		JPanel[] topPanel = new JPanel[5]; 
		JPanel[] midPanel = new JPanel[5]; 
		JPanel[] btmPanel = new JPanel[5]; 
		JPanel qMenu [] = new JPanel [5]; 
		for (int i = 0; i < 5; i++) {
			topPanel [i] = new JPanel(new GridLayout(2, 1)); 
			midPanel [i] = new JPanel (new GridLayout (3,1,15,15)); 
			btmPanel [i] = new JPanel (new GridLayout (1,2));
		}
		for (int i = 6; i < 22; i++)
			btnExit[i] = new JButton("Back"); 
		for (int i=0; i<6; i++)
			btnExit[i] = new JButton("Main Menu");

		titleMenu[0] = new JLabel ("Character Name",JLabel.CENTER); 
		titleMenu[1] = new JLabel ("Specials",JLabel.CENTER);
		titleMenu[2] = new JLabel ("Episode Plot",JLabel.CENTER);
		titleMenu[3] = new JLabel ("Who Said What?",JLabel.CENTER); 
		titleMenu[4] = new JLabel ("Slang!",JLabel.CENTER);

		for (int i=0; i<5; i++) { 
			titleMenu[i].setForeground(Color.DARK_GRAY); 
			titleMenu[i].setFont(titleFont);
		}
		ButtonHandlerChar charQ = new ButtonHandlerChar(); 
		ButtonHandlerSpecial specialQ = new ButtonHandlerSpecial();
		ButtonHandlerEpisode epiQ = new ButtonHandlerEpisode(); 
		ButtonHandlerWho whoQ = new ButtonHandlerWho(); 
		ButtonHandlerSlang slangQ = new ButtonHandlerSlang();
		for (int y=0; y<15; y=y+3) {
			btnQ[y] = new JButton ("Question 1"); 
			btnQ[y+1] = new JButton ("Question 2"); 
			btnQ[y+2] = new JButton ("Question 3");
		}
		for (int y=0; y<15; y=y+3) {
			btnQ[y].setBackground(Color.WHITE); 
			btnQ[y+1].setBackground(pink1); 
			btnQ[y+2].setBackground(red1); 
			btnQ[y].setForeground(Color.BLACK); 
			btnQ[y+1].setForeground(yellow1); 
			btnQ[y+2].setForeground(Color.WHITE); 
			btnQ[y].setFont(otherFont); 
			btnQ[y+1].setFont(otherFont);
			btnQ[y+2].setFont(otherFont);
		}
		btnExit[0].addActionListener (charQ); 
		btnExit[1].addActionListener (specialQ);
		btnExit[2].addActionListener (epiQ);
		btnExit[3].addActionListener (whoQ);

		btnExit[4].addActionListener (slangQ); 
		for (int i=0; i<3; i++)
			btnQ[i].addActionListener (charQ); 
		for (int i=3; i<6; i++)
			btnQ[i].addActionListener (specialQ); 
		for (int i=6; i<9; i++)
			btnQ[i].addActionListener (epiQ); 
		for (int i=9; i<12; i++)
			btnQ[i].addActionListener (whoQ); 
		for (int i=12; i<15; i++)
			btnQ[i].addActionListener (slangQ);

		JLabel instructQ [] = new JLabel [5]; 
		for (int y = 0; y < 5; y++) {
			topPanel[y].add(titleMenu[y]); 
			topPanel[y].setBackground(yellow1);
			instructQ [y] = new JLabel ("Click below to choose a question tomanswer!",JLabel.CENTER); 
			instructQ[y].setForeground(Color.DARK_GRAY);
			instructQ[y].setFont(otherFont); 
			topPanel[y].add(instructQ[y]);
		}
		int count = 0; //Count to increase button numbers 
		for (int i = 0; i < 5; i++) {
			midPanel[i].add(btnQ[count]); 
			midPanel[i].add(btnQ[count+1]); 
			midPanel[i].add(btnQ[count+2]); 
			count += 3;
			midPanel[i].setBackground(yellow1);
			btmPanel[i].add(btnExit[i]);
			btmPanel[i].setBackground(yellow1);
			qMenu [i] = new JPanel (new GridLayout (3,1));
		}
		for (int y = 0; y < 5; y++) {
			qMenu[y].add (topPanel[y]);
			qMenu[y].add (midPanel[y]); 
			qMenu[y].add (btmPanel[y]);
		}
		Container contentPaneMenu [] = new Container [5]; 
		for (int y = 0; y < 5; y++) {
			contentPaneMenu[y] = contentFrame[y].getContentPane (); 
			contentPaneMenu[y].add(topPanel[y], BorderLayout.PAGE_START); 
			contentPaneMenu[y].add(midPanel[y], BorderLayout.CENTER); 
			contentPaneMenu[y].add(btmPanel[y], BorderLayout.PAGE_END); 
			contentFrame[y].setSize (500, 480);
			contentFrame[y].setVisible (false);
		} 

		////////////////////////////////////////////
		//Characters
		////Character Questions
		Container contentPaneChar [] = new Container [3];

		JPanel charTopPanel [] = new JPanel [3]; 
		JPanel charCenterPanel [] = new JPanel [3]; 
		JPanel charTxtPanel [] = new JPanel [3]; 
		JPanel charPicPanel[] = new JPanel [3];
		JPanel charBtmPanel [] = new JPanel [3];
		for (int i = 0; i < titleCharQ.length; i++) {
			charTopPanel [i]= new JPanel (new GridLayout (3,1)); 
			charTopPanel[i].setBackground(yellow1);
			charBtmPanel [i] = new JPanel (new GridLayout (1,2)); 
			charBtmPanel[i].setBackground(yellow1);
			charPicPanel [i] = new JPanel (new GridLayout (1,1)); 
			charPicPanel[i].setBackground(yellow1);
			charTxtPanel [i] = new JPanel (new GridLayout (2,2)); 
			charTxtPanel[i].setBackground(yellow1);
			charCenterPanel [i] = new JPanel (new GridLayout (2,1)); 
			charCenterPanel[i].setBackground(yellow1);
			titleCharQ [i] = new JLabel ("Question "+(i+1), JLabel.CENTER); 
			titleCharQ[i].setFont(titleFont); 
			titleCharQ[i].setForeground(Color.DARK_GRAY);
			charLbl [i] = new JLabel ("Worth "+(i+1)+" point(s).", JLabel.CENTER); 
			charLbl [i].setForeground(Color.DARK_GRAY);
			charLbl [i].setFont(otherFont);
			titleInstructQ[i] = new JLabel ("Who is this character?", JLabel.CENTER); 
			titleInstructQ[i].setForeground(Color.DARK_GRAY); 
			titleInstructQ[i].setFont(otherFont);
		}

		for (int i=6; i<9; i++)
			btnExit[i] = new JButton("Back");
		for (int i=0; i<3; i++)
			btnSubmit[i] = new JButton("Submit");
		for (int i=0; i<txtChar.length; i++) {
			txtChar[i] = new JTextField(); 
			txtChar[i].setHorizontalAlignment(JTextField.CENTER);
		}

		picChar1 = new ImageIcon ("Boyle.jpg"); 
		picChar2 = new ImageIcon ("Pimento.jpg");
		charPicLbl[0] = new JLabel(picChar1);
		charPicLbl[1] = new JLabel(picChar2);
		charPicLbl[2] = new JLabel ("What is Holt’s husband’s name?", JLabel.CENTER);
		charPicLbl[2].setForeground(Color.DARK_GRAY); 
		charPicLbl[2].setFont(otherFont);
		ButtonHandlerCharQ1 charQ1 = new ButtonHandlerCharQ1(); 
		btnExit[6].addActionListener(charQ1); 
		btnSubmit[0].addActionListener(charQ1);
		ButtonHandlerCharQ2 charQ2 = new ButtonHandlerCharQ2(); 
		btnExit[7].addActionListener(charQ2);

		btnSubmit[1].addActionListener(charQ2);
		ButtonHandlerCharQ3 charQ3 = new ButtonHandlerCharQ3(); 
		btnExit[8].addActionListener(charQ3); 
		btnSubmit[2].addActionListener(charQ3);
		charNameLbl = new JLabel ("Name: ", JLabel.CENTER); 
		charNameLbl.setForeground(Color.DARK_GRAY); 
		charNameLbl.setFont(otherFont);
		for (int i=0; i<3; i++) {
			charTxtPanel [i].add(charNameLbl); 
			charTxtPanel [i].add(txtChar[i]);
		}
		for (int i = 0; i < titleCharQ.length; i++) { 
			charTopPanel[i].add(titleCharQ[i]);
			charTopPanel[i].add(charLbl [i]); 
			charTopPanel[i].add(titleInstructQ[i]); 
			charPicPanel[i].add(charPicLbl[i]);
		}
		charBtmPanel[0].add(btnExit[6]); 
		charBtmPanel[1].add(btnExit[7]); 
		charBtmPanel[2].add(btnExit[8]); 
		charBtmPanel[0].add(btnSubmit[0]);
		charBtmPanel[1].add(btnSubmit[1]); 
		charBtmPanel[2].add(btnSubmit[2]);
		for (int i=0; i<3; i++) {
			charCenterPanel[i].add(charPicPanel[i]); 
			charCenterPanel[i].add(charTxtPanel[i]);
		}
		for (int i=0; i<3; i++) {
			contentPaneChar[i] = charFrame[i].getContentPane (); 
			contentPaneChar[i].add (charTopPanel[i],BorderLayout.PAGE_START); 
			contentPaneChar[i].add (charCenterPanel[i],BorderLayout.CENTER); 
			contentPaneChar[i].add (charBtmPanel[i],BorderLayout.PAGE_END); 
			charFrame[i].pack();
			charFrame[i].setSize (500, 480);
			charFrame[i].setVisible (false);
		} ///////////////////////////////////////////
		//Specials
		JPanel spPanelQM1=new JPanel(); 
		JPanel spPanelQM2=new JPanel(); 
		JPanel spPanelQM3=new JPanel(); 
		spPanelQM1.setBackground(yellow1);

		spPanelQM2.setBackground(yellow1); spPanelQM3.setBackground(yellow1);
		JPanel spPanelQ11=new JPanel(new GridLayout(3,1));
		JPanel spPanelQ12=new JPanel(new GridLayout(3,2)); 
		spPanelQ11.setBackground(yellow1); 
		spPanelQ12.setBackground(yellow1);
		JPanel spPanelQ21=new JPanel(new GridLayout(3,1)); 
		JPanel spPanelQ22=new JPanel(new GridLayout(3,2)); 
		spPanelQ21.setBackground(yellow1);
		spPanelQ22.setBackground(yellow1);
		JPanel spPanelQ31=new JPanel(new GridLayout(3,1));
		JPanel spPanelQ32=new JPanel(new GridLayout(3,2)); 
		spPanelQ31.setBackground(yellow1); 
		spPanelQ32.setBackground(yellow1);
		////Question 1 (Special)
		spQ[0]= new JLabel("What item(s) does Jake Peralta try to steal in throughout the Halloween special(s)?", JLabel.CENTER);
		spQ[0].setForeground(Color.DARK_GRAY); spQ[0].setFont(otherFont);
		//declaring all jcheckboxes for specials
		spA1[0]= new JCheckBox("Medal of Valour",false);//right answer 
		spA1[1]= new JCheckBox("A Diamond Ring",false);
		spA1[2]= new JCheckBox("1000 Pounds of Fentanyl",false);
		spA1[3]= new JCheckBox("A Championship Cummerbund",false);//right
		spA2[0]= new JCheckBox("Boyle",false); spA2[1]= new JCheckBox("Gina",false);//right 
		spA2[2]= new JCheckBox("Holt",false);//right 
		spA2[3]= new JCheckBox("Rosa",false);
		spA3[0]= new JCheckBox("A Sergeant",false);
		spA3[1]= new JCheckBox("Engaged",false);//right
		spA3[2]= new JCheckBox("A Mother",false);
		spA3[3]= new JCheckBox("Ultimate Human/Genius",false);//right

		for(int x=0;x<3;x++) {
			spQT[x]=new JLabel("Choose the correct answer(s).", JLabel.CENTER); 
			spQT[x].setForeground(Color.DARK_GRAY);
			spQT[x].setFont(otherFont);
			spQT2[x]=new JLabel("Worth "+(x+1)+" point(s)", JLabel.CENTER); 
			spQT2[x].setForeground(Color.DARK_GRAY); 
			spQT2[x].setFont(otherFont);
		}
		for(int x=0;x<4;x++) {
			spA1[x].setBackground(yellow1); 
			spA1[x].setForeground(Color.DARK_GRAY);
			spA1[x].setFont(otherFont); 
			spA2[x].setBackground(yellow1); 
			spA2[x].setForeground(Color.DARK_GRAY); 
			spA2[x].setFont(otherFont); 
			spA3[x].setBackground(yellow1); 
			spA3[x].setForeground(Color.DARK_GRAY);
			spA3[x].setFont(otherFont);
		}
		btnSubmit[3]=new JButton("Submit"); 
		btnSubmit[3].setBackground(blue1); 
		btnSubmit[3].setForeground(Color.white);
		ButtonHandlerSpecialQ1 submitsp1 = new ButtonHandlerSpecialQ1();
		btnSubmit[3].addActionListener(submitsp1);
		btnExit[9]=new JButton("Back");
		btnExit[9].setBackground(blue1); 
		btnExit[9].setForeground(Color.white);
		ButtonHandlerSpecialQ1 backsp1 = new ButtonHandlerSpecialQ1(); 
		btnExit[9].addActionListener(backsp1);
		spPanelQ11.add(spQT[0]); 
		spPanelQ11.add(spQT2[0]);
		spPanelQ11.add(spQ[0]);

		for(int x=0;x<4;x++) 
			spPanelQ12.add(spA1[x]);
		spPanelQ12.add(btnExit[9]);
		spPanelQ12.add(btnSubmit[3]);
		spPanelQM1.add(spPanelQ11);
		spPanelQM1.add(spPanelQ12);
		////Question 2 (Special)
		spQ[1]= new JLabel("Who has won a halloween heist?", JLabel.CENTER);
		spQ[1].setForeground(Color.DARK_GRAY);
		spQ[1].setFont(otherFont);
		btnSubmit[4]=new JButton("Submit");
		btnSubmit[4].setBackground(blue1); 
		btnSubmit[4].setForeground(Color.white);
		ButtonHandlerSpecialQ2 submitsp2 = new ButtonHandlerSpecialQ2(); 
		btnSubmit[4].addActionListener(submitsp2);
		btnExit[10]=new JButton("Back");
		btnExit[10].setBackground(blue1);
		btnExit[10].setForeground(Color.white);
		ButtonHandlerSpecialQ2 backsp2 = new ButtonHandlerSpecialQ2(); 
		btnExit[10].addActionListener(backsp2);
		spPanelQ21.add(spQT[1]); 
		spPanelQ21.add(spQT2[1]); 
		spPanelQ21.add(spQ[1]);

		for(int x=0;x<4;x++) 
			spPanelQ22.add(spA2[x]);
		spPanelQ22.add(btnExit[10]); 
		spPanelQ22.add(btnSubmit[4]);
		spPanelQM2.add(spPanelQ21); 
		spPanelQM2.add(spPanelQ22);

		////Question 3 (Special)
		spQ[2]= new JLabel("What does Amy Santiago become after the Halloween heists?", JLabel.CENTER);
		spQ[2].setForeground(Color.DARK_GRAY); 
		spQ[2].setFont(otherFont);
		btnSubmit[5]=new JButton("Submit"); 
		btnSubmit[5].setBackground(blue1);
		btnSubmit[5].setForeground(Color.white);
		ButtonHandlerSpecialQ3 submitsp3 = new ButtonHandlerSpecialQ3(); 
		btnSubmit[5].addActionListener(submitsp3);
		btnExit[11]=new JButton("Back"); 
		btnExit[11].setBackground(blue1); 
		btnExit[11].setForeground(Color.white);
		ButtonHandlerSpecialQ3 backsp3 = new ButtonHandlerSpecialQ3();
		btnExit[11].addActionListener(backsp3);
		spPanelQ31.add(spQT[2]); 
		spPanelQ31.add(spQT2[2]); 
		spPanelQ31.add(spQ[2]);
		for(int x=0;x<4;x++) 
			spPanelQ32.add(spA3[x]);
		spPanelQ32.add(btnExit[11]); 
		spPanelQ32.add(btnSubmit[5]);
		spPanelQM3.add(spPanelQ31); 
		spPanelQM3.add(spPanelQ32);
		contentPaneMenu[1]=contentFrame[1].getContentPane();
		Container contentPaneSpec[]=new Container[3];
		for(int x=0;x<3;x++)
		{
			contentPaneSpec[x]=specFrame[x].getContentPane(); 
			specFrame[x].pack();
			specFrame[x].setVisible(false); 
			specFrame[x].setSize(600,200);
		}
		specFrame[1].setSize(300,200);
		contentPaneSpec[0].add(spPanelQM1);
		contentPaneSpec[1].add(spPanelQM2);
		contentPaneSpec[2].add(spPanelQM3);
		//////////////////////////////////////////

		//Episode plots
		JPanel epPanelQM1=new JPanel(); 
		JPanel epPanelQM2=new JPanel();
		JPanel epPanelQM3=new JPanel();
		epPanelQM1.setBackground(yellow1);
		epPanelQM2.setBackground(yellow1); 
		epPanelQM3.setBackground(yellow1);
		JPanel epPanelQ11=new JPanel((new GridLayout(4,1)));
		JPanel epPanelQ12=new JPanel((new GridLayout(1,2)));
		epPanelQ11.setBackground(yellow1); 
		epPanelQ12.setBackground(yellow1);
		JPanel epPanelQ21=new JPanel((new GridLayout(4,1)));
		JPanel epPanelQ22=new JPanel((new GridLayout(1,2)));
		epPanelQ21.setBackground(yellow1);
		epPanelQ22.setBackground(yellow1);
		JPanel epPanelQ31=new JPanel((new GridLayout(4,1)));
		JPanel epPanelQ32=new JPanel((new GridLayout(1,2)));
		epPanelQ31.setBackground(yellow1);
		epPanelQ32.setBackground(yellow1);
		for(int x=0;x<3;x++) {
			epQT[x]=new JLabel("Input the correct answer.", JLabel.CENTER); 
			epQT[x].setForeground(Color.DARK_GRAY); 
			epQT[x].setFont(otherFont);
			epQT2[x]=new JLabel("Worth "+(x+1)+" point(s)", JLabel.CENTER);
			epQT2[x].setForeground(Color.DARK_GRAY); 
			epQT2[x].setFont(otherFont);
		}
		epQ[0]= new JLabel("In the pilot episode, how were the robbers discovered?"); 
		epQ[0].setForeground(Color.DARK_GRAY);
		epQ[0].setFont(otherFont);
		epA[0]=new JTextField("");
		btnSubmit[6]=new JButton("Submit");
		ButtonHandlerEpisodeQ1 submitep1 = new ButtonHandlerEpisodeQ1(); 
		btnSubmit[6].addActionListener(submitep1);
		ButtonHandlerEpisodeQ1 backep1 = new ButtonHandlerEpisodeQ1(); 
		btnExit[12].addActionListener(backep1);
		epPanelQ11.add(epQT[0]); 
		epPanelQ11.add(epQT2[0]);
		epPanelQ11.add(epQ[0]); 
		epPanelQ11.add(epA[0]);
		epPanelQ12.add(btnExit[12]); 
		epPanelQ12.add(btnSubmit[6]);

		epPanelQM1.add(epPanelQ11);
		epPanelQM1.add(epPanelQ12);
		////Second Question (episode)
		epQ[1]= new JLabel("Why was Jake and Amy’s wedding postponed?");
		epQ[1].setForeground(Color.DARK_GRAY); epQ[1].setFont(otherFont);
		epA[1]=new JTextField("");
		btnSubmit[7]=new JButton("Submit");
		btnSubmit[7].setBackground(blue1); 
		btnSubmit[7].setForeground(Color.white);
		ButtonHandlerEpisodeQ2 submitep2 = new ButtonHandlerEpisodeQ2(); 
		btnSubmit[7].addActionListener(submitep2);
		ButtonHandlerEpisodeQ2 backep2 = new ButtonHandlerEpisodeQ2();
		btnExit[13].addActionListener(backep2); 
		btnExit[13].setBackground(blue1); 
		btnExit[13].setForeground(Color.white); 
		btnExit[13].setFont(otherFont);
		epPanelQ21.add(epQT[1]); 
		epPanelQ21.add(epQT2[1]); 
		epPanelQ21.add(epQ[1]); 
		epPanelQ21.add(epA[1]);
		epPanelQ22.add(btnExit[13]); 
		epPanelQ22.add(btnSubmit[7]);
		epPanelQM2.add(epPanelQ21); 
		epPanelQM2.add(epPanelQ22);

		////Third Question (episode)
		epQ[2]= new JLabel("What is Jake and Amy’s wedding cake shaped as?");
		epQ[2].setForeground(Color.DARK_GRAY);
		epQ[2].setFont(otherFont);
		epA[2]=new JTextField("");
		btnSubmit[8]=new JButton("Submit");
		btnSubmit[8].setBackground(blue1);
		btnSubmit[8].setForeground(Color.white);
		ButtonHandlerEpisodeQ3 submitep3 = new ButtonHandlerEpisodeQ3();
		btnSubmit[8].addActionListener(submitep3);
		ButtonHandlerEpisodeQ3 backep3 = new ButtonHandlerEpisodeQ3();
		btnExit[14].addActionListener(backep3); 
		btnExit[14].setBackground(blue1);
		btnExit[14].setForeground(Color.white); 
		btnExit[14].setFont(otherFont);
		epPanelQ31.add(epQT[2]);
		epPanelQ31.add(epQT2[2]); 
		epPanelQ31.add(epQ[2]); 
		epPanelQ31.add(epA[2]);

		epPanelQ32.add(btnExit[14]); 
		epPanelQ32.add(btnSubmit[8]);
		epPanelQM3.add(epPanelQ31); 
		epPanelQM3.add(epPanelQ32);
		contentPaneMenu[2]=contentFrame[2].getContentPane();
		Container contentPaneEpi[]=new Container[3];
		for(int x=0;x<3;x++)
		{
			contentPaneEpi[x]=epiFrame[x].getContentPane();
			epiFrame[x].pack();
			epiFrame[x].setVisible(false); 
			epiFrame[x].setSize(450,200);
		}
		contentPaneEpi[0].add(epPanelQM1);
		contentPaneEpi[1].add(epPanelQM2);
		contentPaneEpi[2].add(epPanelQM3);


		/////////////////////////////////////////
		//Who - Questions
		JPanel whoPanelQ [] = new JPanel [3] ; 
		JPanel whoPanelQTop [] = new JPanel [3];
		JPanel whoPanelQPic [] = new JPanel [3] ;
		JPanel whoPanelQBtm [] = new JPanel [3] ; 
		for (int i=0; i<3; i++)
		{
			whoPanelQ[i]= new JPanel (new GridLayout (3,1));
			whoPanelQTop [i] = new JPanel (new GridLayout (4,1));
			whoPanelQPic [i] = new JPanel( new GridLayout (2,4)); 
			whoPanelQBtm [i] = new JPanel( new GridLayout (1,2)); 
			whoPanelQ[i].setBackground(yellow1);
			whoPanelQTop[i].setBackground(yellow1);
			whoPanelQPic[i].setBackground(yellow1); 
			whoPanelQBtm[i].setBackground(yellow1);
			titleWhoQ[i] = new JLabel("Question #" + (i+1), JLabel.CENTER);
			titleWhoQ[i].setFont(titleFont);
			pointWhoQ[i] = new JLabel ("Worth #" + (i+1)+" Points", JLabel.CENTER);
			pointWhoQ[i].setFont(otherFont);
			instructWhoQ[i] = new JLabel ("Click on the person who made this statement.", JLabel.CENTER); instructWhoQ[i].setFont(otherFont);
		}
		stateWhoQ[0] = new JLabel ("If we're away from our desks for too long, they'll update our computers and we'll lose Minesweeper.", JLabel.CENTER);
		stateWhoQ[0].setFont(otherFont);
		picWho[0] = new ImageIcon ("Hitchcock.jpg");
		picWho[1] = new ImageIcon ("Jake.jpg");
		picWho[2] = new ImageIcon ("Terry.jpg");
		picWho[3] = new ImageIcon ("Scully.jpg");//right
		stateWhoQ[1] = new JLabel ("I was thinking how I would make the perfect American president, based upon my skill set, dance ability and bloodlust.", JLabel.CENTER);
		stateWhoQ[1].setFont(otherFont);
		picWho[4] = new ImageIcon ("Boyle.jpg");
		picWho[5] = new ImageIcon ("Gina.jpg");//right
		picWho[6] = new ImageIcon ("Rosa.jpg");
		picWho[7] = new ImageIcon ("Terry.jpg");
		stateWhoQ[2] = new JLabel ("My name is Adelaide Van Hoyt. I'm eighty-nine years old, and I'm here to report a crime.", JLabel.CENTER); 
		stateWhoQ[2].setFont(otherFont);
		picWho[8] = new ImageIcon ("Rosa.jpg");
		picWho[9] = new ImageIcon ("Adelaide.jpg"); 
		picWho[10] = new ImageIcon ("Terry.jpg");//right 
		picWho[11] = new ImageIcon ("Boyle.jpg");
		for (int i=0; i<who.length; i++) {
			who[i] = new JRadioButton(); 
			who[i].setBackground(yellow1); 
			picWhoLbl[i] = new JLabel (picWho[i]);
		}
		for (int i=0; i<3; i++) {
			who[i*4].setText("A");
			who[(i*4)+1].setText("B"); 
			who[(i*4)+2].setText("C"); 
			who[(i*4)+3].setText("D");
		}
		whoGroup1 = new ButtonGroup();
		whoGroup2 = new ButtonGroup(); 
		whoGroup3 = new ButtonGroup();
		for (int i=0; i<4;i++)
		{
			whoGroup1.add(who[i]);
			whoGroup2.add(who[i+4]); 
			whoGroup3.add(who[i+8]);
		}
		for (int i =13; i<16; i++)
			btnExit[i] = new JButton("Back");
		for (int i=9; i<12; i++)
			btnSubmit[i] = new JButton("Submit");
		ButtonHandlerWhoQ1 whoQ1 = new ButtonHandlerWhoQ1(); 
		btnExit[13].addActionListener(whoQ1);
		btnSubmit[9].addActionListener(whoQ1);
		for (int i=0; i<4; i++)
			who[i].addActionListener(whoQ1);
		ButtonHandlerWhoQ2 whoQ2 = new ButtonHandlerWhoQ2(); 
		btnExit[14].addActionListener(whoQ2); 
		btnSubmit[10].addActionListener(whoQ2);
		for (int i=4; i<8; i++)
			who[i].addActionListener(whoQ2); 
		ButtonHandlerWhoQ3 whoQ3 = new ButtonHandlerWhoQ3();

		btnExit[15].addActionListener(whoQ3);
		btnSubmit[11].addActionListener(whoQ3); 
		for (int i=8; i<12; i++)
			who[i].addActionListener(whoQ3); //who assembling
		for (int i=0; i<3; i++) {
			whoPanelQTop[i].add(titleWhoQ[i]);
			whoPanelQTop[i].add(pointWhoQ[i]); 
			whoPanelQTop[i].add(instructWhoQ[i]); 
			whoPanelQTop[i].add(stateWhoQ[i]);
		}
		for (int i=0; i<4; i++) {
			whoPanelQPic[0].add(who[i]); 
			whoPanelQPic[0].add(picWhoLbl[i]);
		}
		for (int i=4; i<8; i++) {
			whoPanelQPic[1].add(who[i]); 
			whoPanelQPic[1].add(picWhoLbl[i]);
		}
		for (int i=8; i<12; i++) {
			whoPanelQPic[2].add(who[i]); 
			whoPanelQPic[2].add(picWhoLbl[i]);
		}
		whoPanelQBtm[0].add(btnExit[13]);
		whoPanelQBtm[1].add(btnExit[14]); 
		whoPanelQBtm[2].add(btnExit[15]);
		whoPanelQBtm[0].add(btnSubmit[9]);
		whoPanelQBtm[1].add(btnSubmit[10]); 
		whoPanelQBtm[2].add(btnSubmit[11]);
		for (int i=0; i<3; i++) {
			whoPanelQ[i].add(whoPanelQTop[i]);
			whoPanelQ[i].add(whoPanelQPic[i]); 
			whoPanelQ[i].add(whoPanelQBtm[i]);
		}
		//who container
		Container contentPaneWhoQ [] = new Container [3]; 
		for (int i=0; i<3; i++)
		{
			contentPaneWhoQ[i] = whoFrame[i].getContentPane (); 
			contentPaneWhoQ[i].add (whoPanelQTop[i],BorderLayout.PAGE_START);
			contentPaneWhoQ[i].add (whoPanelQPic[i],BorderLayout.CENTER); 
			contentPaneWhoQ[i].add (whoPanelQBtm[i],BorderLayout.PAGE_END);
			whoFrame[i].pack();
			whoFrame[i].setSize (850, 480);
			whoFrame[i].setVisible (false);
		}

		/////////////////////////////////////////
		//Slang Questions
		Container contentPaneSlan [] = new Container [3]; 
		JPanel slanTopPanel [] = new JPanel [3];
		JPanel slanCenterPanel [] = new JPanel [3]; 
		JPanel slanBtmPanel [] = new JPanel [3];
		titleInstructQ[0] = new JLabel ("“Noice/Toit” is a phrase used by Jake.", JLabel.CENTER); 
		titleInstructQ[1] = new JLabel ("“Nicolaj” is always pronounced correctly.", JLabel.CENTER); 
		titleInstructQ[2] = new JLabel ("“Get Shwifty!” is a phrase used by Holt in episode 5 of season 3.", JLabel.CENTER);
		for (int i = 0; i < titleSlanQ.length; i++) {
			slanTopPanel [i]= new JPanel (new GridLayout (3,1));
			slanBtmPanel [i] = new JPanel (new GridLayout (1,2)); 
			slanCenterPanel [i] = new JPanel (new GridLayout (1,2)); 
			slanTopPanel[i].setBackground(yellow1); 
			slanBtmPanel[i].setBackground(yellow1); 
			slanCenterPanel[i].setBackground(yellow1);
			titleSlanQ [i] = new JLabel ("Question "+(i+1), JLabel.CENTER);
			titleSlanQ[i].setFont(titleFont);
			slanLbl [i] = new JLabel ("Worth "+(i+1)+" point.", JLabel.CENTER); 
			titleInstructQ[i].setFont(otherFont);
		}
		for (int i=16; i<19; i++)
			btnExit[i] = new JButton("Back");
		for (int i=12; i<15; i++)
			btnSubmit[i] = new JButton("Submit");
		for (int i=0; i<tfSlan.length; i=i+2) 
		{
			tfSlan[i] = new JRadioButton("True");
			tfSlan[i+1] = new JRadioButton("False"); 
			tfSlan[i].setBackground(yellow1); 
			tfSlan[i+1].setBackground(yellow1);
			tfSlan[i].setHorizontalAlignment(JRadioButton.CENTER); 
			tfSlan[i+1].setHorizontalAlignment(JRadioButton.CENTER);
		}
		slanGroup1 = new ButtonGroup(); 
		slanGroup2 = new ButtonGroup(); 
		slanGroup3 = new ButtonGroup();
		slanGroup1.add(tfSlan[0]); 
		slanGroup1.add(tfSlan[1]); 
		slanGroup2.add(tfSlan[2]);
		slanGroup2.add(tfSlan[3]); 
		slanGroup3.add(tfSlan[4]); 
		slanGroup3.add(tfSlan[5]);
		ButtonHandlerSlanQ1 slanQ1 = new ButtonHandlerSlanQ1();
		btnExit[16].addActionListener(slanQ1); 
		btnSubmit[12].addActionListener(slanQ1);

		ButtonHandlerSlanQ2 slanQ2 = new ButtonHandlerSlanQ2();
		btnExit[17].addActionListener(slanQ2);
		btnSubmit[13].addActionListener(slanQ2);
		ButtonHandlerSlanQ3 slanQ3 = new ButtonHandlerSlanQ3();
		btnExit[18].addActionListener(slanQ3);
		btnSubmit[14].addActionListener(slanQ3);
		for (int i = 0; i < titleSlanQ.length; i++) 
		{ 
			slanTopPanel[i].add(titleSlanQ[i]);
			slanTopPanel[i].add(slanLbl [i]); 
			slanTopPanel[i].add(titleInstructQ[i]);
		}
		slanBtmPanel[0].add(btnExit[16]); 
		slanBtmPanel[1].add(btnExit[17]);
		slanBtmPanel[2].add(btnExit[18]); 
		slanBtmPanel[0].add(btnSubmit[12]); 
		slanBtmPanel[1].add(btnSubmit[13]); 
		slanBtmPanel[2].add(btnSubmit[14]);
		slanCenterPanel[0].add(tfSlan[0]);
		slanCenterPanel[0].add(tfSlan[1]);
		slanCenterPanel[1].add(tfSlan[2]); 
		slanCenterPanel[1].add(tfSlan[3]); 
		slanCenterPanel[2].add(tfSlan[4]); 
		slanCenterPanel[2].add(tfSlan[5]);
		for (int i=0; i<3; i++) {
			contentPaneSlan[i] = slanFrame[i].getContentPane (); 
			contentPaneSlan[i].add (slanTopPanel[i],BorderLayout.PAGE_START); 
			contentPaneSlan[i].add (slanCenterPanel[i],BorderLayout.CENTER); 
			contentPaneSlan[i].add (slanBtmPanel[i],BorderLayout.PAGE_END);
			slanFrame[i].pack();
			slanFrame[i].setSize (500, 200);
			slanFrame[i].setVisible (false);
		} 
		////////////////////////////////////////
		//Mug Shots Main Menu
		JPanel mugPanel = new JPanel (new GridLayout (3,1));
		JPanel titleMugPanel = new JPanel (new GridLayout (2,1)); 
		JPanel crtMugPanel = new JPanel (new GridLayout (3,1));
		JPanel crtPicMugPanel = new JPanel (new GridLayout (1,4));
		JPanel crtTxtMugPanel = new JPanel (new GridLayout (1,4)); 
		JPanel crtQMugPanel = new JPanel (new GridLayout (1,4)); 
		JPanel btmMugPanel = new JPanel (new GridLayout (1,2));
		mugPanel.setBackground(yellow1); 
		titleMugPanel.setBackground(yellow1); 
		crtMugPanel.setBackground(yellow1); 
		crtPicMugPanel.setBackground(yellow1);

		crtTxtMugPanel.setBackground(yellow1); 
		crtQMugPanel.setBackground(yellow1); 
		btmMugPanel.setBackground(yellow1);
		titleMug = new JLabel ("Mug Shots", JLabel.CENTER);
		titleMug.setFont(titleFont);
		titleMugInstruct = new JLabel ("Match the Villian Names (from word bank below) with the Villian's Picture", JLabel.CENTER); 
		titleMugInstruct.setFont(otherFont);
		titleMugPanel.add(titleMug); 
		titleMugPanel.add(titleMugInstruct);
		mugPicA = new JLabel (picMug1); 
		mugPicB = new JLabel (picMug2);
		mugPicC = new JLabel (picMug3); 
		mugPicD = new JLabel (picMug4); 
		crtPicMugPanel.add(mugPicD); 
		crtPicMugPanel.add(mugPicB); 
		crtPicMugPanel.add(mugPicC); 
		crtPicMugPanel.add(mugPicA);

		for (int i=0; i<txtMug.length; i++) 
		{
			txtMug[i] = new JTextField(); 
			txtMug[i].setHorizontalAlignment(JTextField.CENTER);
			crtTxtMugPanel.add(txtMug[i]);
		}

		mugQA = new JLabel ("A. Doug Judy", JLabel.CENTER); 
		mugQB = new JLabel ("B. Melanie Kawkins", JLabel.CENTER); 
		mugQC = new JLabel ("C. Madeline Wuntch", JLabel.CENTER); 
		mugQD = new JLabel ("D. Jimmy Figgis", JLabel.CENTER); 
		mugQA.setFont(otherFont);
		mugQB.setFont(otherFont);
		mugQC.setFont(otherFont);
		mugQD.setFont(otherFont);
		crtQMugPanel.add(mugQA);
		crtQMugPanel.add(mugQB);
		crtQMugPanel.add(mugQC);
		crtQMugPanel.add(mugQD);
		btnExit[20] = new JButton("Back");
		btnSubmit[15] = new JButton ("Submit"); 
		ButtonHandlerMug mugQ = new ButtonHandlerMug(); 
		btnExit[20].addActionListener(mugQ); 
		btnSubmit[15].addActionListener(mugQ); 
		btmMugPanel.add(btnExit[20]); 
		btmMugPanel.add(btnSubmit[15]);
		crtMugPanel.add(crtPicMugPanel); 
		crtMugPanel.add(crtTxtMugPanel); 
		crtMugPanel.add(crtQMugPanel);
		mugPanel.add(titleMugPanel);

		mugPanel.add(crtMugPanel); 
		mugPanel.add(btmMugPanel);
		Container contentPaneMug = mugMenuFrame.getContentPane ();
		contentPaneMug.add (mugPanel);
		contentPaneMug.add (titleMugPanel,BorderLayout.PAGE_START); 
		contentPaneMug.add (crtMugPanel,BorderLayout.CENTER);
		contentPaneMug.add (btmMugPanel,BorderLayout.PAGE_END); 
		mugMenuFrame.setSize (700, 480);
		mugMenuFrame.setVisible (false);
		///////////////////////////////////////
		//Answers
		JPanel ansPanel=new JPanel((new GridLayout(3,1))); 
		JPanel ansPanelTp=new JPanel((new GridLayout(1,1)));
		JPanel ansPanelList=new JPanel((new GridLayout(1,1)));
		JPanel ansPanelBt=new JPanel((new GridLayout(1,3))); 
		ansPanel.setBackground(yellow1); 
		ansPanelTp.setBackground(yellow1); 
		ansPanelList.setBackground(yellow1); 
		ansPanelBt.setBackground(yellow1);
		titleAnswer= new JLabel("Answers", JLabel.CENTER); 
		titleAnswer.setFont(titleFont);
		picAns[0] = new ImageIcon ("Scully.jpg"); 
		picAns[1] = new ImageIcon ("Gina.jpg"); 
		picAns[2] = new ImageIcon ("Terry.jpg");

		for (int i=0; i<3; i++)
			picAnsLbl[i] = new JLabel ("");

		listAnswer = new List(); listAnswer.setFont(otherFont);
		listAnswer.add("Names Q1.Charles Boyle"); 
		listAnswer.add("Names Q2.Adrian Pimento"); 
		listAnswer.add("Names Q3.Kevin Cozner");
		listAnswer.add("Specials Q1.Medal of Valour & A Championship Cummerbund"); 
		listAnswer.add("Specials Q2.Engaged & Ultimate Human/Genius"); 
		listAnswer.add("Specials Q3.Gina & Holt");
		listAnswer.add("Episode Plot Q1.Jake finds a teddy bear camera"); 
		listAnswer.add("Episode Plot Q2.Bomb threat"); 
		listAnswer.add("Episode Plot Q3.Nakatomi Plaza from Die Hard");
		listAnswer.add("Who Said Q1. D - Scully, the guy wearing a napkin.");
		listAnswer.add("Who Said Q2. B - Gina, the girl wearing red."); 
		listAnswer.add("Who Said Q3. C - Terry, the man wearing peach grids on his shirt.");
		listAnswer.add("Slang Q1.True"); 
		listAnswer.add("Slang Q2.False");
		listAnswer.add("Slang Q3.False");
		listAnswer.add("Mugshot 1: d.Jimmy Figgis"); 
		listAnswer.add("Mugshot 2: b.Melanie Kawkins"); 
		listAnswer.add("Mugshot 3: c.Madeline Wuntch"); 
		listAnswer.add("Mugshot 4: a.Doug Judy");
		btnExit[21]= new JButton("Main Menu"); 
		ButtonHandlerAnswer backAns = new ButtonHandlerAnswer();
		btnExit[21].addActionListener(backAns);
		finalPoints= new JLabel((pointsQ1+pointsQ2+pointsQ3)+"/34 points", JLabel.CENTER); 
		finalPoints.setFont(otherFont);
		endGame= new JButton("End Game");
		endGame.setFont(buttonFont); 
		endGame.setForeground(Color.WHITE); 
		endGame.setBackground(blue1); 
		endGame.addActionListener(backAns);
		ansPanelTp.add(titleAnswer); 
		ansPanelList.add(listAnswer);
		ansPanelBt.add(btnExit[21]);
		ansPanelBt.add(finalPoints); 
		ansPanelBt.add(endGame);
		ansPanel.add(ansPanelTp);
		ansPanel.add(ansPanelList); 
		ansPanel.add(ansPanelBt);
		Container contentPaneAnswer=answersFrame.getContentPane(); 
		contentPaneAnswer.add(ansPanelTp, BorderLayout.PAGE_START); 
		contentPaneAnswer.add(ansPanelList, BorderLayout.CENTER); 
		contentPaneAnswer.add(ansPanelBt, BorderLayout.PAGE_END);
		answersFrame.pack(); 
		answersFrame.setVisible(false); 
		answersFrame.setSize(500,350);
		//Button submit and exit design 
		for (int i=0; i <16; i++)
		{
			btnSubmit[i].setBackground(blue1); 
			btnSubmit[i].setFont(buttonFont); 
			btnSubmit[i].setForeground(Color.WHITE);
		}
		for (int i=0; i <22; i++) {
			btnExit[i].setBackground(blue1); 
			btnExit[i].setFont(otherFont); 
			btnExit[i].setForeground(Color.WHITE);
		}
	}
	//Button Handler for main menu
	private static class ButtonHandlerMain implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String whichOne = e.getActionCommand ();
			//characters
			if (whichOne.equals("Characters"))
				contentFrame[0].setVisible (true); 
			//specials
			if (whichOne.equals("Episode Specials")) 
				contentFrame[1].setVisible(true);
			//episode plots
			if (whichOne.equals("Episode Plots"))
				contentFrame[2].setVisible(true); 
			//who said what
			if (whichOne.equals("Who Said What")) 
				contentFrame[3].setVisible(true);
			//slang
			if (whichOne.equals("Slang"))
				contentFrame[4].setVisible(true); 
			//mug shots
			if (whichOne.equals("Mug Shots")) 
				mugMenuFrame.setVisible(true);
			//answers
			if (whichOne.equals("Finish/View Answers")) {
				for (int i=0; i<3; i++) picAnsLbl[i].setIcon(picAns[i]);
				pointsQ1=countQ1;
				pointsQ2=(countQ2*2); pointsQ3=(countQ3*3);
				totalPoints =(pointsQ1+pointsQ2+pointsQ3); 
				finalPoints.setText((totalPoints)+"/34 points"); 
				answersFrame.setVisible(true);
			}
			//quit
			if (whichOne.equals("Quit"))
				System.exit(0);

		}
	}
	//Character menu Q1-3 and back buttons
	private static class ButtonHandlerChar implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String buttonName = e.getActionCommand();
			for (int x=0; x<3; x++)
			{
				if (buttonName.equals("Question " + (x+1)))
				{
					charFrame[x].setVisible(true);
				}
				if(buttonName.contentEquals("Main Menu"))
				{
					contentFrame[0].setVisible(false);
				}
			}

		}
	}

	private static class ButtonHandlerCharQ1 implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String guess = e.getActionCommand(); 
			if (guess.equals("Submit"))
			{
				String answer = txtChar[0].getText(); 
				if (answer.equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(error, "Please enter an answer in the text box.");
				if (answer.equalsIgnoreCase("Charles Boyle")||answer.equalsIgnoreCase("Charles")||answer.equalsIgnoreCase("Boyle"))
				{
					countQ1++;
					btnSubmit[0].setEnabled(false);
					txtChar[0].setEnabled(false); 
					btnQ[0].setBackground(green1);
				} 
			}
			if (guess.equals("Back")) 
				charFrame[0].setVisible(false);
		}
	}

	private static class ButtonHandlerCharQ2 implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String guess = e.getActionCommand();
			if (guess.equals("Submit"))
			{
				String answer = txtChar[1].getText(); 
				if (answer.equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(error, "Please enter an answer in the text box.");
				else if (answer.equalsIgnoreCase("Adrian Pimento")||answer.equalsIgnoreCase("Adrian")||answer.equalsIgnoreCase("Pimento"))
				{
					countQ2++;
					btnSubmit[1].setEnabled(false); 
					txtChar[1].setEnabled(false); 
					btnQ[1].setBackground(green1);

				} 
			}
			if (guess.equals("Back"))
				charFrame[1].setVisible(false);
		}
	}

	private static class ButtonHandlerCharQ3 implements ActionListener 
	{
		public void actionPerformed (ActionEvent e)
		{
			String guess = e.getActionCommand(); 
			if (guess.equals("Submit"))
			{
				String answer = txtChar[2].getText(); 
				if (answer.equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(error, "Please enter an answer in the text box.");
				else if (answer.equalsIgnoreCase("Kevin Cozner")||answer.equalsIgnoreCase("Kevin")||answer.equalsIgnoreCase("Cozner"))
				{
					countQ3++;
					btnSubmit[2].setEnabled(false);
					txtChar[2].setEnabled(false); 
					btnQ[2].setBackground(green1);	
				}
			}
			if (guess.equals("Back"))
				charFrame[2].setVisible(false);
		}
	}
	//Specials menu Q1-3 and back buttons
	private static class ButtonHandlerSpecial implements ActionListener 
	{
		public void actionPerformed (ActionEvent e)
		{
			String choice = e.getActionCommand ();
			for(int x=0;x<3;x++) 
			{
				if(choice.equals("Question "+(x+1))) 
					specFrame[x].setVisible(true);
			}
			if( choice.equals("Main Menu"))
				contentFrame[1].setVisible(false);
		}
	}
	private static class ButtonHandlerSpecialQ1 implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String choice = e.getActionCommand (); 
			if(choice.equals("Back"))
			{
				specFrame[0].setVisible(false);
			} 
			if(choice.equals("Submit"))
			{
				if((spA1[0].isSelected() && spA1[3].isSelected())&&(!spA1[1].isSelected() && !spA1[2].isSelected()))
				{
					countQ1++;
					btnSubmit[3].setEnabled(false); 
					btnQ[3].setBackground(green1);
				} 
			}
		}
	}
	private static class ButtonHandlerSpecialQ2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String choice = e.getActionCommand ();
			if(choice.equals("Back")) 
			{
				specFrame[1].setVisible(false);
			} 
			if(choice.equals("Submit")) 
			{
				if((spA2[1].isSelected()&&spA2[2].isSelected())&&(!spA2[0].isSelected()&&!spA2[3].isSelected())) 
				{
					countQ2++; 
					btnSubmit[4].setEnabled(false); 
					btnQ[4].setBackground(green1);
				}
			}
		}
	}
	private static class ButtonHandlerSpecialQ3 implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String choice = e.getActionCommand (); 
			if(choice.equals("Back"))
			{
				specFrame[2].setVisible(false);
			}
			if(choice.equals("Submit")) 
			{
				if((spA3[1].isSelected()&&spA3[3].isSelected())&&(!spA3[0].isSelected()&&!spA3[2].isSelected())) 
				{
					countQ3++; 
					btnSubmit[5].setEnabled(false); 
					btnQ[5].setBackground(green1);
				}
			}
		}
	}
	//Episode plots menu Q1-3 and back buttons
	private static class ButtonHandlerEpisode implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String choice = e.getActionCommand ();
			for(int x=0;x<3;x++)
			{
				if(choice.equals("Question "+(x+1))) 
				{
					epiFrame[x].setVisible(true);
				} 
			}
			if(choice.equals("Main Menu")) {
				contentFrame[2].setVisible(false);
			} 
		}
	}
	private static class ButtonHandlerEpisodeQ1 implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String choice = e.getActionCommand ();

			if(choice.equals("Back"))
			{
				epiFrame[0].setVisible(false);
			}
			if(choice.equals("Submit")) 
			{
				epAnswer[0]=epA[0].getText();
				if(epAnswer[0].equalsIgnoreCase("Jake finds a teddy bear camera")||epAnswer[0].equalsIgnoreCase("teddy bear camera")||epAnswer[0].equalsIgnoreCase("teddybear cam")) 
				{ 
					countQ1++;
					btnSubmit[6].setEnabled(false);
					btnQ[6].setBackground(green1);
				}

				if (epAnswer[0].equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(error, "Please enter an answer in the text box.");
			}
		}
	}

	private static class ButtonHandlerEpisodeQ2 implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String choice = e.getActionCommand ();
			if(choice.equals("Back")) 
			{
				epiFrame[1].setVisible(false);
			}
			if(choice.equals("Submit")) 
			{
				epAnswer[1]=epA[1].getText();
				
				if(epAnswer[1].equalsIgnoreCase("a Bomb threat")||epAnswer[1].equalsIgnoreCase("Bomb threat"))
				{
					countQ2++;
					btnSubmit[7].setEnabled(false); 
					btnQ[7].setBackground(green1);
				}
				
				if (epAnswer[1].equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(error, "Please enter an answer in the text box.");
			}
		}
	}

	private static class ButtonHandlerEpisodeQ3 implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String choice = e.getActionCommand ();
			if(choice.equals("Back"))
			{
				epiFrame[2].setVisible(false);
			}
			if(choice.equals("Submit")) 
			{
				epAnswer[2]=epA[2].getText();
				if(epAnswer[2].equalsIgnoreCase("Nakatomi Plaza")) 
				{
					countQ3++; 
					btnSubmit[8].setEnabled(false);
					btnQ[8].setBackground(green1);
				}
				if (epAnswer[2].equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(error, "Please enter an answer in the text box.");
			}
		}
	}
	//Who said what menu Q1-3 and back buttons
	private static class ButtonHandlerWho implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String choice = e.getActionCommand (); 
			for(int x=0;x<3;x++)
			{
				if(choice.equals("Question "+(x+1))) 
				{
					whoFrame[x].setVisible(true);
				} 
			}
			if (choice.equals("Main Menu")) 
				contentFrame[3].setVisible(false);
			if (choice.equals("Main Menu")) 
				contentFrame[2].setVisible(false);
		}
	}

	private static class ButtonHandlerWhoQ1 implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String guess = e.getActionCommand(); 
			if (guess.equals("Submit"))
			{
				if (who[3].isSelected())
				{
					countQ1++; 
					btnSubmit[9].setEnabled(false);
					btnQ[9].setBackground(green1);
				} }
			else if (guess.equals("Back"))
				whoFrame[0].setVisible(false);
		}
	}

	private static class ButtonHandlerWhoQ2 implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String guess = e.getActionCommand(); 
			if (guess.equals("Submit"))
			{
				if (who[5].isSelected()) 
				{
					countQ2++; 
					btnSubmit[10].setEnabled(false); 
					btnQ[10].setBackground(green1);
				} 
			}
			else if (guess.equals("Back"))
			{
				whoFrame[1].setVisible(false);
			} 
		}
	}
	private static class ButtonHandlerWhoQ3 implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String guess = e.getActionCommand();
			if (guess.equals("Submit"))
			{
				if (who[10].isSelected()) 
				{
					countQ3++; btnSubmit[11].setEnabled(false); btnQ[11].setBackground(green1);
				} 
			}
			else if (guess.equals("Back")) 
			{
				whoFrame[2].setVisible(false);
			} 
		}
	}
	//Slang menu Q1-3 and back buttons
	private static class ButtonHandlerSlang implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String buttonName = e.getActionCommand (); 
			if(buttonName.equals("Main Menu"))
				contentFrame[4].setVisible(false);

			else {
				for(int x=0;x<3;x++)
				{
					if(buttonName.equals("Question "+(x+1))) 
						slanFrame[x].setVisible(true);
				}
			}
		}
	}
	private static class ButtonHandlerSlanQ1 implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String guess = e.getActionCommand(); 
			if (guess.equals("Submit"))
			{
				if (tfSlan[0].isSelected()) 
				{
					countQ1++; 
					tfSlan[0].setEnabled(false); 
					tfSlan[1].setEnabled(false); 
					btnSubmit[12].setEnabled(false); 
					btnQ[12].setBackground(green1);
				} 
			}
			else if (guess.equals("Back"))
			{
				slanFrame[0].setVisible(false);
			} 
		}
	}
	private static class ButtonHandlerSlanQ2 implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String guess = e.getActionCommand(); 
			if (guess.equals("Submit"))
			{
				if (tfSlan[3].isSelected())
				{
					countQ2++; 
					tfSlan[2].setEnabled(false); 
					tfSlan[3].setEnabled(false); 
					btnSubmit[13].setEnabled(false);
					btnQ[13].setBackground(green1);
				}
			}
			else if (guess.equals("Back")) 
			{
				slanFrame[1].setVisible(false);
			} 
		}
	}
	private static class ButtonHandlerSlanQ3 implements ActionListener
	{

		public void actionPerformed (ActionEvent e)
		{
			String guess = e.getActionCommand(); 
			if (guess.equals("Submit"))
			{
				if (tfSlan[5].isSelected()) 
				{
					countQ3++; 
					tfSlan[4].setEnabled(false); 
					tfSlan[5].setEnabled(false); 
					btnSubmit[14].setEnabled(false);
					btnQ[14].setBackground(green1);
				} 
			}
			else if (guess.equals("Back")) 
			{
				slanFrame[2].setVisible(false);
			}
		}
	}
	//Mug Shots
	private static class ButtonHandlerMug implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String guess = e.getActionCommand(); 
			String q1, q2, q3, q4;
			if (guess.equals(("Submit"))) {
				btnSubmit[9].setEnabled(false);
				q1 = txtMug[3].getText();
				q2 = txtMug[1].getText();
				q3 = txtMug[2].getText();
				q4 = txtMug[0].getText();
				if ((q1.equalsIgnoreCase("A. Doug Judy") || q1.equalsIgnoreCase("A")||q1.equalsIgnoreCase("Doug Judy")||q1.equalsIgnoreCase("Judy")||q1.equalsIgnoreCase("Doug"))) 
				{
					countQ1++; btnSubmit[15].setEnabled(false);
				}
				if ((q2.equalsIgnoreCase("B. Melanie Kawkins") || q2.equalsIgnoreCase("B")||q2.equalsIgnoreCase("Melanie Kawkins")||q2.equalsIgnoreCase("Kawkins")||q2.equalsIgnoreCase("Melanie"))) 
				{
					countQ1++; btnSubmit[15].setEnabled(false);
				}
				if ((q3.equalsIgnoreCase("C. Madeline Wuntch") || q3.equalsIgnoreCase("C")||q3.equalsIgnoreCase("Madeline Wuntch")||q3.equalsIgnoreCase("Wuntch")||q3.equalsIgnoreCase("Madeline"))) 
				{
					countQ1++; btnSubmit[15].setEnabled(false);
				}
				if ((q4.equalsIgnoreCase("D. Jimmy Figgis") || q4.equalsIgnoreCase("D")||q4.equalsIgnoreCase("Jimmy Figgis")||q4.equalsIgnoreCase("Figgis")||q4.equalsIgnoreCase("Jimmy"))) 
				{
					countQ1++; btnSubmit[15].setEnabled(false);
				} 
			}
			else if (guess.equals(("Back"))) 
			{
				mugMenuFrame.setVisible(false);
			} 
		}
	}
	//Answers
	private static class ButtonHandlerAnswer implements ActionListener 
	{
		public void actionPerformed (ActionEvent e) 
		{
			String choice = e.getActionCommand ();
			if (choice.equals("Main Menu")) 
			{
				answersFrame.setVisible(false);
			}
			if (choice.equals("End Game")) 
			{
				if (totalPoints >= 28) 
				{
					JOptionPane.showMessageDialog(error, "Congrats on your great score!");
					System.exit(0);
				}
				if (totalPoints <28 && totalPoints> 17 )
				{
					JOptionPane.showMessageDialog(error, "You did okay... :/");
					System.exit(0); 
				}
				if (totalPoints <17) 
				{
					JOptionPane.showMessageDialog(error, "Maybe you can do better next time :(");
					System.exit(0); 
				}
			}
		}
	}
	//GuiApp
	public static void main (String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater (new Runnable ()
		{
			public void run () 
			{
				guiApp();
			}
		}
				);
	}
}
