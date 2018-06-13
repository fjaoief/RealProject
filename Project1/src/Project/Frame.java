package Project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//체력, 정신력, 지력, 힘
public class Frame {
	int al = 0;
	JLabel imgLabel1 = new JLabel();
	JLabel imgLabel2 = new JLabel();
	int assistHealth = 100;
	int professorHealth = 200;
	JLabel aStat = new JLabel("조교님 체력 :" + assistHealth);
	JPanel statPanel = new JPanel();
	int hearClass = 0;
	Font fontType4 = new Font("바탕", Font.PLAIN, 30);
	JFrame Frame = new JFrame();
	Container con;
	JPanel title = new JPanel();
	JPanel start = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel choiceButtonPanel = new JPanel();
	JPanel playerPanel = new JPanel();
	JLabel titleLabel;
	JLabel hpLabel, hpLabelNumber;
	JLabel healthLabel, mentalLabel, intLabel, strengthLabel;
	JLabel healthNumber, mentalNumber, intNumber, strengthNumber;
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHealth, playerMental, playerInt, playerStrength;
	String position;
	JPanel creator = new JPanel();
	int dayCount = 0;
	float grade = 0;
	ImageIcon img1 = new ImageIcon("user.jpg");
	ImageIcon img2 = new ImageIcon("background.jpg");
	ImageIcon img3 = new ImageIcon("assist.jpg");
	ImageIcon img4 = new ImageIcon("professor.jpg");
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {

		new Frame();
	}

	@SuppressWarnings("static-access")
	public Frame() {
		// 800 600
		// 1200 800
		Font fontType1 = new Font("바탕", Font.BOLD, 90);
		Font fontType2 = new Font("바탕", Font.BOLD, 70);
		Font fontType3 = new Font("바탕", Font.BOLD, 20);

		Frame.setSize(1200, 800);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setBackground(Color.black);
		Frame.setLayout(null);
		Frame.setVisible(true);

		con = Frame.getContentPane();

		creator.setBounds(1, 1, 220, 100);
		creator.setBackground(Color.black);
		JLabel creatorLabel = new JLabel("제작자: 최현우  정건");
		creatorLabel.setForeground(Color.white);
		creatorLabel.setFont(fontType3);

		title = new JPanel();
		title.setBounds(80, 120, 1000, 400);
		title.setBackground(Color.black);
		titleLabel = new JLabel("<html>성균<br>ADVENTRUE");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(fontType1);
		titleLabel.setHorizontalAlignment(titleLabel.CENTER);

		start = new JPanel();
		start.setBounds(450, 550, 200, 100);
		start.setBackground(Color.black);

		startButton = new JButton("시작");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(fontType2);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);

		creator.add(creatorLabel);
		title.add(titleLabel);
		start.add(startButton);

		con.add(creator);
		con.add(title);
		con.add(start);

	}

	public void createGameScreen() {
		//// 이미지

		aStat.setFont(fontType4);
		aStat.setForeground(Color.white);
		statPanel.setBounds(900, 450, 300, 200);
		statPanel.setBackground(Color.black);
		statPanel.add(aStat);
		imgLabel1.setIcon(img1);
		imgLabel2.setIcon(img2);
		imgLabel1.setBounds(50, 150, 200, 300);
		imgLabel2.setBounds(950, 150, 200, 300);
		con.add(imgLabel1);
		con.add(imgLabel2);
		Frame.setSize(1200, 800);
		creator.setVisible(false);
		title.setVisible(false);
		start.setVisible(false);

		textPanel = new JPanel();
		// 가로, 세로 실제 텍스트
		textPanel.setBounds(300, 180, 600, 250);
		textPanel.setBackground(Color.black);
		con.add(textPanel);

		mainTextArea = new JTextArea("");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(fontType4);
		mainTextArea.setLineWrap(true);
		textPanel.add(mainTextArea);

		firstChoice();

		playerPanel = new JPanel();
		playerPanel.setBounds(150, 50, 1000, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 8));
		con.add(playerPanel);

		strengthLabel = new JLabel("힘:");
		strengthLabel.setFont(fontType4);
		strengthLabel.setForeground(Color.white);

		mentalLabel = new JLabel("정신력:");
		mentalLabel.setFont(fontType4);
		mentalLabel.setForeground(Color.white);

		healthLabel = new JLabel("체력:");
		healthLabel.setFont(fontType4);
		healthLabel.setForeground(Color.white);

		intLabel = new JLabel("지력:");
		intLabel.setFont(fontType4);
		intLabel.setForeground(Color.white);

		playerPanel.add(healthLabel);
		healthNumber = new JLabel();
		healthNumber.setFont(fontType4);
		healthNumber.setForeground(Color.white);
		playerPanel.add(healthNumber);

		playerPanel.add(mentalLabel);
		mentalNumber = new JLabel();
		mentalNumber.setFont(fontType4);
		mentalNumber.setForeground(Color.white);
		playerPanel.add(mentalNumber);

		playerPanel.add(intLabel);
		intNumber = new JLabel();
		intNumber.setFont(fontType4);
		intNumber.setForeground(Color.white);
		playerPanel.add(intNumber);

		playerPanel.add(strengthLabel);
		strengthNumber = new JLabel();
		strengthNumber.setFont(fontType4);
		strengthNumber.setForeground(Color.white);
		playerPanel.add(strengthNumber);

		playerSetup();

	}

	public void firstChoice() {
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(200, 520, 750, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		con.add(choiceButtonPanel);

		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(fontType4);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(fontType4);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(fontType4);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);

		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(fontType4);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);

	}

	public void playerSetup() {
		playerHealth = 0;
		playerInt = 0;
		playerStrength = 0;
		playerMental = 0;
		assistHealth = 100;
		professorHealth = 200;
		healthNumber.setText("" + playerHealth);
		intNumber.setText("" + playerInt);
		mentalNumber.setText("" + playerMental);
		strengthNumber.setText("" + playerStrength);

		q1();
	}

	public void q1() {
		position = "q1";
		imgLabel2.setIcon(img2);
		con.add(imgLabel2);
		playerHealth = 0;
		playerMental = 0;
		playerInt = 0;
		playerStrength = 0;
		healthNumber.setText("" + playerHealth);
		mentalNumber.setText("" + playerMental);
		intNumber.setText("" + playerInt);
		strengthNumber.setText("" + playerStrength);
		statPanel.setVisible(false);
		playerHealth = 0;
		playerInt = 0;
		playerMental = 0;
		playerStrength = 0;
		mainTextArea.setText("성균관 대학교 율전 캠퍼스에 온 것을 환영합니다. 먼저 당신은:");
		choice1.setText("인간입니다.");
		choice2.setText("인간이 아닙니다.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q2() {
		position = "q2";
		mainTextArea.setText("혹시 학과가 무엇이죠?");
		choice1.setText("자연과학 계열입니다.");
		choice2.setText("공학계열입니다.");
		choice3.setText("소프트/컴공입니다.");
		choice4.setText("스과입니다.");
	}

	public void q3() {
		position = "q3";
		mainTextArea.setText("혹시 외행성에서 오셨나요?");
		choice1.setText("네.");
		choice2.setText("아니요.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q4() {
		position = "q4";
		mainTextArea.setText("아아! 당신이 바로 이번에 컴공 복전하는 박진철씨인가요?");
		choice1.setText("네.");
		choice2.setText("잘못 말했어요, 사실 다른 과입니다.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q5() {
		position = "q5";
		mainTextArea.setText("아아! 당신이 바로 이번에 컴공 복전하는 이철마양인가요?");
		choice1.setText("네.");
		choice2.setText("잘못 말했어요, 사실 다른 과입니다.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q6() {
		position = "q6";
		mainTextArea.setText("아아! 당신이 바로 이번에 컴공 복전하는 김혜성씨인가요?");
		choice1.setText("네.");
		choice2.setText("잘못 말했어요, 사실 다른 과입니다.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q7() {
		position = "q7";
		mainTextArea.setText("아아! 저는 소프트/컴공 학부 연구생 레오나르도 다 빈치입니다. 만나서 반가워요.");
		choice1.setText("반갑습니다! 저는 ____라 합니다!(사용자 입력)");
		choice2.setText("잘못 말했어요, 사실 다른 과입니다.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q8() {
		position = "q8";
		mainTextArea.setText("아아! 당신이 바로 이번에 컴공 복전하는 정영선양인가요?");
		choice1.setText("네.");
		choice2.setText("잘못 말했어요, 사실 다른 과입니다.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q9() {
		position = "q9";
		mainTextArea.setText("아아! 당신이 바로 이번에 컴공 복전하는 조꺽정씨인가요?");
		choice1.setText("네.");
		choice2.setText("잘못 말했어요, 사실 다른 과입니다.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q10() {
		position = "q10";
		mainTextArea.setText("아아! 당신이 바로 이번에 새로 온 외계 전학생 이운석씨인가요?");
		choice1.setText("네.");
		choice2.setText("잘못 말했어요, 사실 지구 태생입니다.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q11() {
		position = "q11";
		mainTextArea.setText("아아! 당신이 바로 이번에 새로 온 오크 전학생 지그문트씨인가요?");
		choice1.setText("네.");
		choice2.setText("잘못 말했어요, 사실 외계인입니다.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q12() {
		position = "q12";
		mainTextArea.setText("당신의 능력치는 다음과 같습니다:\r\n" + "진철 박\r\n" + "체력:50\r\n" + "정신력:50\r\n" + "지력:5\r\n"
				+ "힘:20\r\n" + "특수능력: 엘씨");
		playerHealth = 50;
		healthNumber.setText("" + playerHealth);
		playerMental = 50;
		mentalNumber.setText("" + playerMental);
		playerInt = 5;
		intNumber.setText("" + playerInt);
		playerStrength = 20;
		strengthNumber.setText("" + playerStrength);
		choice1.setText("잘 알았습니다!");
		choice2.setText("설명좀 해주세요.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q13() {
		position = "q11";
		mainTextArea.setText("당신의 능력치는 다음과 같습니다:\r\n" + "철마 이\r\n" + "체력:50\r\n" + "정신력:50\r\n" + "지력:5\r\n"
				+ "힘:20\r\n" + "특수능력: 엘씨");
		playerHealth = 50;
		healthNumber.setText("" + playerHealth);
		playerMental = 50;
		mentalNumber.setText("" + playerMental);
		playerInt = 5;
		intNumber.setText("" + playerInt);
		playerStrength = 20;
		strengthNumber.setText("" + playerStrength);
		choice1.setText("잘 알았습니다!");
		choice2.setText("설명좀 해주세요.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q14() {
		position = "q11";
		mainTextArea.setText("당신의 능력치는 다음과 같습니다:\r\n" + "혜성 김\r\n" + "체력:50\r\n" + "정신력:50\r\n" + "지력:5\r\n"
				+ "힘:20\r\n" + "특수능력: 엘씨");
		playerHealth = 50;
		healthNumber.setText("" + playerHealth);
		playerMental = 50;
		mentalNumber.setText("" + playerMental);
		playerInt = 5;
		intNumber.setText("" + playerInt);
		playerStrength = 20;
		strengthNumber.setText("" + playerStrength);
		choice1.setText("잘 알았습니다!");
		choice2.setText("설명좀 해주세요.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q15() {
		position = "q11";
		mainTextArea.setText("당신의 능력치는 다음과 같습니다:\r\n" + "(사용자 입력)\r\n" + "체력:50\r\n" + "정신력:50\r\n" + "지력:5\r\n"
				+ "힘:20\r\n" + "특수능력: 이름 사용자 입력");
		playerHealth = 50;
		healthNumber.setText("" + playerHealth);
		playerMental = 50;
		mentalNumber.setText("" + playerMental);
		playerInt = 5;
		intNumber.setText("" + playerInt);
		playerStrength = 20;
		strengthNumber.setText("" + playerStrength);
		choice1.setText("잘 알았습니다!");
		choice2.setText("설명좀 해주세요.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q16() {
		position = "q11";
		mainTextArea.setText("당신의 능력치는 다음과 같습니다:\r\n" + "영선 정\r\n" + "체력:50\r\n" + "정신력:50\r\n" + "지력:5\r\n"
				+ "힘:20\r\n" + "특수능력: 체력 회복 상승");
		playerHealth = 50;
		healthNumber.setText("" + playerHealth);
		playerMental = 50;
		mentalNumber.setText("" + playerMental);
		playerInt = 5;
		intNumber.setText("" + playerInt);
		playerStrength = 20;
		strengthNumber.setText("" + playerStrength);
		choice1.setText("잘 알았습니다!");
		choice2.setText("설명좀 해주세요.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q17() {
		position = "q17";
		mainTextArea.setText("당신의 능력치는 다음과 같습니다:\r\n" + "꺽정 조\r\n" + "체력:70\r\n" + "정신력:30\r\n" + "지력:5\r\n"
				+ "힘:25\r\n" + "특수능력: 체력을 정신력으로, 정신력을 체력으로 사용할 수 있습니다.");
		playerHealth = 70;
		healthNumber.setText("" + playerHealth);
		playerMental = 30;
		mentalNumber.setText("" + playerMental);
		playerInt = 5;
		intNumber.setText("" + playerInt);
		playerStrength = 25;
		strengthNumber.setText("" + playerStrength);
		choice1.setText("잘 알았습니다!");
		choice2.setText("설명좀 해주세요.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q18() {
		position = "q18";
		mainTextArea.setText("당신의 능력치는 다음과 같습니다:\r\n" + "운석 이\r\n" + "체력:20\r\n" + "정신력:100\r\n" + "지력:10\r\n"
				+ "힘:15\r\n" + "특수능력: 인문사회 질문 해독 불가.");
		playerHealth = 20;
		healthNumber.setText("" + playerHealth);
		playerMental = 100;
		mentalNumber.setText("" + playerMental);
		playerInt = 10;
		intNumber.setText("" + playerInt);
		playerStrength = 15;
		strengthNumber.setText("" + playerStrength);
		choice1.setText("잘 알았습니다!");
		choice2.setText("설명좀 해주세요.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q19() {
		position = "q19";
		mainTextArea.setText("당신의 능력치는 다음과 같습니다:\r\n" + "그문트 조\r\n" + "체력:100\r\n" + "정신력:20\r\n" + "지력:2\r\n"
				+ "힘:35\r\n" + "특수능력: 공부를 못합니다.");
		playerHealth = 100;
		healthNumber.setText("" + playerHealth);
		playerMental = 20;
		mentalNumber.setText("" + playerMental);
		playerInt = 2;
		intNumber.setText("" + playerInt);
		playerStrength = 35;
		strengthNumber.setText("" + playerStrength);
		choice1.setText("잘 알았습니다!");
		choice2.setText("설명좀 해주세요.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q20() {
		position = "q20";
		mainTextArea.setText(
				"당신은 개학 후 흥청망청 놀기만 하다가 어쩌다보니 기말고사 전 1주일이 되었다. 자신의 형편으로는 장학금 없이 다음 학기 등록이 불가능하다는 것을 깨달은 당신은 그제서야 공부를 시작하였다.");
		choice1.setText("다음");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void detailStat1() {
		position = "detailStat1";
		mainTextArea.setText(
				"체력: 얼마나 오래 살 수 있는지 알려줍니다. 0으로 떨어지면 죽습니다.\r\n" + "정신력: 얼마나 버틸 수 있는지 알려줍니다. 0으로 떨어지면 미쳐버립니다.\r\n");
		choice1.setText("->");
		choice2.setText("돌아가기...");
		choice3.setText("");
		choice4.setText("");
	}

	public void detailStat2() {
		position = "detailStat2";
		mainTextArea.setText(
				"지력: 캐릭터의 두개골이 머리인지 뚝배기인지 알려줍니다. 마법데미지가 증가합니다.\r\n" + "힘: 얼마나 강한지 알려줍니다. 힘이 강하면 전투에서 공격력이 높아집니다.");
		choice1.setText("돌아가기...");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void q24() {
		position = "q24";
		mainTextArea.setText("아침 8:00, 알람이 울렸다. 무엇을 할까요?");
		choice1.setText("늦잠…");
		choice2.setText("기상…");
		choice3.setText("");
		choice4.setText("");
	}

	public void q25() {
		position = "q25";
		mainTextArea.setText("첫번째 늦잠으로 아침밥을 잃은다. 체력 5감소, 정신력 5증가-> 두번째부터는 첫수업을 지각한다.");
		playerHealth -= 5;
		healthNumber.setText("" + playerHealth);
		playerMental += 5;
		mentalNumber.setText("" + playerMental);
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void q26() {
		position = "q26";
		mainTextArea.setText("아침밥 먹어서 체력을 증가시킨다. (체력+5) ");
		playerHealth += 5;
		healthNumber.setText("" + playerHealth);
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void q27() {
		position = "q27";
		mainTextArea.setText("수업을 갈 시간입니다. 작정하고 쨀까요? ");
		choice1.setText("예.");
		choice2.setText("아니오.");
		choice3.setText("");
		choice4.setText("");
	}

	public void q29() {
		position = "q29";
		assistHealth += 10;
		professorHealth += 30;
		mainTextArea.setText("수업 안 하고 뭘 할까요?");
		choice1.setText("독학!(지력+3, 정신력 +1, 체력 -1)");
		choice2.setText("놀자!(정신력+5, 지력 -1)");
		choice3.setText("");
		choice4.setText("");
	}

	public void q30() {
		position = "q30";
		mainTextArea.setText("강의실에 도착했습니다. 이제 뭘 할까요?");
		choice1.setText("열심히 듣는다.(지력+4, 정신력 -3, 체력 -3)");
		choice2.setText("듣는 척하자.( 정신력+1, 지력+1, 체력 -1)");
		choice3.setText("");
		choice4.setText("");
	}

	public void q32() {
		position = "q32";
		mainTextArea.setText("오늘의 수업이 끝났습니다. 뭘 할까요?");
		choice1.setText("과제하고 자야겠다.(정신력-5, 체력-8,  지력+2)");
		choice2.setText("씻고 자겠다.(정신력+2, 체력+4)");
		choice3.setText("");
		choice4.setText("");
	}

	public void q34() {
		position = "q34";
		mainTextArea.setText("정신력이 0에 도달했습니다. 당신은 마침내 미쳐버렸습니다. 다음 5번의 선택에서 당신은 무작위 선택을 하게 됩니다. 그 뒤 5의 정신력을 회복합니다.");
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void q35() {
		position = "q30";
		mainTextArea.setText("체력이 0에 도달했습니다. 당신은 입원하게 되었습니다. 그동안 공부를 사랑해서 감사합니다.");
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void q39() {
		position = "q39";
		mainTextArea.setText("시험날이 되었습니다.");
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void q41() {// 시험문제 출제//
		position = "q41";

		mainTextArea.setText("시험장에 도착했습니다. 마직막으로 무엇을 할까요?\n\n");

		choice1.setText("복습.(지력+1)");
		choice2.setText("초콜릿.(체력+5)");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void exam1() {// 시험문제 출제//
		position = "exam1";

		mainTextArea.setText("다음중 메소드 이름으로 적절한 것은?");

		if (playerInt > 8) {
			choice1.setText("MyFirstJavaMethod");
			choice2.setText("Helloworld");
			choice3.setText("easyQuestion");
			choice4.setText("메소드");
		} else {
			choice1.setText("지력이 낮아서 A번 문항을 알아보지 못합니다. 공부 좀 하지.");
			choice2.setText("지력이 낮아서 B번 문항을 알아보지 못합니다. 공부 좀 하지.");
			choice3.setText("easyQuestion");
			choice4.setText("메소드");
		}
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void exam2() {// 시험문제 출제//
		position = "exam2";

		mainTextArea.setText("스윙에서 사용 할 수 있는 컴포넌트가 아닌 것은?");
		if (playerInt > 11) {
			choice1.setText("JButton");
			choice2.setText("JCheckBox");
			choice3.setText("JLabel");
			choice4.setText("JJava");
		} else {
			choice1.setText("JButton");
			choice2.setText("JCheckBox");
			choice3.setText("지력이 낮아서 C번 문항을 알아보지 못합니다. 공부 좀 하지.");
			choice4.setText("지력이 낮아서 D번 문항을 알아보지 못합니다. 공부 좀 하지.");
		}
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void exam3() {// 시험문제 출제//
		position = "exam3";

		mainTextArea.setText("성균관대학교 설립 년도는?");
		if (al == 1) {
			choice1.setText("외계인학생은 성균관대학교의 역사를 알지 못합니다.");
			choice2.setText("외계인학생은 성균관대학교의 역사를 알지 못합니다.");
			choice3.setText("외계인학생은 성균관대학교의 역사를 알지 못합니다.");
			choice4.setText("외계인학생은 성균관대학교의 역사를 알지 못합니다.");
		} else {
			choice1.setText("1492");
			choice2.setText("1398");
			choice3.setText("1386");
			choice4.setText("518");
		}
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void exam4() {// 시험문제 출제//
		position = "exam4";

		mainTextArea.setText("성균관대학교 주소로 알맞은 것은?");
		choice1.setText("수원시 장안구 서부로 2066");
		choice2.setText("수원시 장안구 화산로 187");
		choice3.setText("수원시 장안구 대평로 1142");
		choice4.setText("수원시 팔달구 덕영대로 110");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void correct1() {// 시험문제 출제//
		position = "correct1";
		grade += 0.5;
		mainTextArea.setText("정답입니다." + "학점 : " + grade);

		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void correct2() {// 시험문제 출제//
		position = "correct2";
		grade += 0.5;
		mainTextArea.setText("정답입니다." + "학점 : " + grade);

		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void correct3() {// 시험문제 출제//
		position = "correct3";

		grade += 0.5;
		mainTextArea.setText("정답입니다." + "학점 : " + grade);

		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void correct4() {// 시험문제 출제//
		position = "correct4";
		grade += 0.5;
		mainTextArea.setText("정답입니다." + "학점 : " + grade);

		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void wrong1() {// 시험문제 출제//
		position = "wrong1";

		mainTextArea.setText("오답입니다.");

		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void wrong2() {// 시험문제 출제//
		position = "wrong2";

		mainTextArea.setText("오답입니다.");

		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void wrong3() {// 시험문제 출제//
		position = "wrong3";

		mainTextArea.setText("오답입니다.");

		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void wrong4() {// 시험문제 출제//
		position = "wrong4";

		mainTextArea.setText("오답입니다.");

		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void introFight1() {
		position = "introFight1";
		mainTextArea.setText("조교님 : 문제는 많이 어렵지는 않았죠? 다음 시험은 접니다. 싸움을 시작하죠!\n\n조교 체력 : " + assistHealth);
		statPanel.setVisible(true);
		aStat.setText("조교님 체력 :" + assistHealth);
		statPanel.add(aStat);
		imgLabel2.setIcon(img3);
		con.add(imgLabel2);
		con.add(statPanel);

		choice1.setText("물리공격");
		choice2.setText("마법공격");
		choice3.setText("학점 던지기(학점)");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void fight1() {
		position = "fight1";
		mainTextArea.setText("공격 하십시오.\n조교님 체력 : " + assistHealth);
		aStat.setText("조교님 체력 :" + assistHealth);
		statPanel.add(aStat);
		con.add(statPanel);
		choice1.setText("물리공격");
		choice2.setText("마법공격");
		choice3.setText("학점 던지기(학점)");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void assistAttack() {
		position = "assistAttack";
		mainTextArea.setText("조교님이 공격하였 습니다.");
		playerHealth -= 5;
		healthNumber.setText("" + playerHealth);
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void assistStat() {
		position = "assistStat";
		mainTextArea.setText("공격이 통했습니다.\n조교님 체력 : " + assistHealth);
		aStat.setText("조교님 체력 :" + assistHealth);
		statPanel.add(aStat);
		con.add(statPanel);
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void assistDie() {
		position = "assistDie";
		mainTextArea.setText("조교님을 이겼습니다.");
		choice1.setText("교수님과의 면담");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}
	/*   
	*/

	///////////////////////////////////////////////////////////
	public void introFight2() {
		position = "introFight2";
		mainTextArea.setText("교수님 : 어서오게 나쁘지 않은 학점이군. 마지막 테스트다!\n\n교수님 체력 : 200");
		aStat.setText("교수님 체력 :" + professorHealth);
		imgLabel2.setIcon(img4);
		con.add(imgLabel2);
		statPanel.add(aStat);
		con.add(statPanel);
		choice1.setText("물리공격");
		choice2.setText("마법공격");
		choice3.setText("학점 던지기(학점)");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void fight2() {
		position = "fight2";
		mainTextArea.setText("공격 하십시오.");
		aStat.setText("교수님 체력 :" + professorHealth);
		statPanel.add(aStat);
		con.add(statPanel);
		choice1.setText("물리공격");
		choice2.setText("마법공격");
		choice3.setText("학점 던지기(학점)");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void professorStat() {
		position = "professorStat";
		mainTextArea.setText("공격이 통했습니다.");
		aStat.setText("교수님 체력 :" + professorHealth);
		statPanel.add(aStat);
		con.add(statPanel);
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void professorAttack() {
		position = "professorAttack";
		mainTextArea.setText("교수님이 공격하였 습니다.");
		playerHealth -= 10;
		healthNumber.setText("" + playerHealth);
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void professorDie() {
		position = "professorDie";
		mainTextArea.setText("교수님을 이겼습니다.");
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public int checkDie() {
		// position="checkDie";
		if (playerHealth <= 0) {
			return 1;
		}
		if (professorHealth <= 0) {
			return 3;
		}
		if (assistHealth <= 0) {
			return 2;
		}

		return 0;
	}

	public void playerDie() {
		position = "playerDie";
		mainTextArea.setText("사망하였습니다.");
		choice1.setText("->");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public void ending() {
		position = "ending";
		mainTextArea.setText("수고하셨습니다.");
		choice1.setText("다음학기.");
		choice2.setText("휴학.");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			createGameScreen();
		}
	}

	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();

			switch (position) {
			case "q1":
				switch (yourChoice) {
				case "c1":
					q2();
					break;
				case "c2":
					q3();
					break;
				}
				break;
			case "q2":
				switch (yourChoice) {
				case "c1":
					q4();
					break;
				case "c2":
					q5();
					break;
				case "c3":
					q7();
					break;
				case "c4":
					q9();
					break;
				}
				break;
			case "q3":
				switch (yourChoice) {
				case "c1":
					q10();
					break;
				case "c2":
					q11();
					break;
				}
				break;
			case "q4":
				switch (yourChoice) {
				case "c1":
					q12();
					break;
				case "c2":
					q2();
					break;
				}
				break;
			case "q5":
				switch (yourChoice) {
				case "c1":
					q13();
					break;
				case "c2":
					q2();
					break;
				}
				break;

			case "q7":
				switch (yourChoice) {
				case "c1":
					q15();
					break;
				case "c2":
					q2();
					break;
				}
				break;
			case "q9":
				switch (yourChoice) {
				case "c1":
					q17();
					break;
				case "c2":
					q2();
					break;
				}
				break;
			case "q10":
				switch (yourChoice) {
				case "c1":
					al = 1;
					q18();
					break;
				case "c2":
					q2();
					break;
				}
				break;
			case "q11":
				switch (yourChoice) {
				case "c1":
					q19();
					break;
				case "c2":
					q10();
					break;
				}
				break;
			case "q12":
				switch (yourChoice) {
				case "c1":
					q20();
					break;
				case "c2":
					detailStat1();
					break;
				}
				break;
			case "q13":
				switch (yourChoice) {
				case "c1":
					q20();
					break;
				case "c2":
					detailStat1();
					break;
				}
				break;
			case "q14":
				switch (yourChoice) {
				case "c1":
					q20();
					break;
				case "c2":
					detailStat1();
					break;
				}
				break;
			case "q15":
				switch (yourChoice) {
				case "c1":
					q20();
					break;
				case "c2":
					detailStat1();
					break;
				}
				break;
			case "q16":
				switch (yourChoice) {
				case "c1":
					q20();
					break;
				case "c2":
					detailStat1();

					break;
				}
				break;
			case "q17":
				switch (yourChoice) {
				case "c1":
					q20();
					break;
				case "c2":
					detailStat1();
					break;
				}
				break;
			case "q18":
				switch (yourChoice) {
				case "c1":
					q20();
					break;
				case "c2":
					detailStat1();
					break;
				}
				break;
			case "q19":
				switch (yourChoice) {
				case "c1":
					q20();
					break;
				case "c2":
					detailStat1();
					break;
				}
				break;
			case "q20":
				switch (yourChoice) {
				case "c1":
					q24();
					break;
				}
				break;
			////////// 원래위치 6개중 정해진곳으로 가야함 수정필
			case "detailStat1":
				switch (yourChoice) {
				case "c1":
					detailStat2();
					break;
				case "c2":
					q24();
					break;
				}
				break;
			case "detailStat2":
				switch (yourChoice) {
				case "c1":
					q24();
					break;
				}
				break;
			case "q24":
				switch (yourChoice) {
				case "c1":
					q25();
					break;
				case "c2":
					q26();
					break;
				}
				break;
			case "q25":
				switch (yourChoice) {
				case "c1":
					q27();
					break;
				}
				break;
			case "q26":
				switch (yourChoice) {
				case "c1":
					q27();
					break;
				}
				break;
			case "q27":
				switch (yourChoice) {
				case "c1":
					q29();
					break;
				case "c2":
					q30();
					break;
				}
				break;
			case "q29":
				switch (yourChoice) {
				case "c1":
					if (dayCount == 4) {
						playerInt += 3;
						intNumber.setText("" + playerInt);
						q39();

						break;
					} else {
						playerInt += 3;
						intNumber.setText("" + playerInt);
						dayCount++;
						q24();
						break;
					}
				case "c2":
					if (dayCount == 4) {
						q39();
						playerMental += 5;
						mentalNumber.setText("" + playerMental);
						break;
					} else {
						playerMental += 5;
						mentalNumber.setText("" + playerMental);
						dayCount++;
						q24();
						break;
					}
				}
				break;
			case "q30":
				switch (yourChoice) {
				case "c1":
					playerInt += 2;
					intNumber.setText("" + playerInt);
					q32();
					break;
				case "c2":
					playerInt += 2;
					intNumber.setText("" + playerInt);
					playerMental += 1;
					mentalNumber.setText("" + playerMental);
					q32();
					break;
				}
				break;
			case "q32":
				switch (yourChoice) {
				case "c1":
					playerInt += 2;
					intNumber.setText("" + playerInt);
					playerMental -= 5;
					mentalNumber.setText("" + playerMental);
					playerHealth -= 10;
					healthNumber.setText("" + playerHealth);
					q39();
					break;
				case "c2":
					q39();
				}
				break;
			case "q39":
				switch (yourChoice) {
				case "c1":
					q41();
					break;
				}
				break;
			case "q41":
				switch (yourChoice) {
				case "c1":
					playerInt += 1;
					intNumber.setText("" + playerInt);
					exam1();
					break;
				case "c2":
					playerHealth += 5;
					healthNumber.setText("" + playerHealth);
					exam1();
					break;
				}
				break;
			case "exam1":
				switch (yourChoice) {
				case "c1":
					wrong1();
					break;
				case "c2":
					wrong1();
					break;
				case "c3":
					correct1();
					break;
				case "c4":
					wrong1();
					break;
				}
				break;
			case "exam2":
				switch (yourChoice) {
				case "c1":
					wrong2();
					break;
				case "c2":
					wrong2();
					break;
				case "c3":
					wrong2();
					break;
				case "c4":
					correct2();
					break;
				}
				break;
			case "exam3":
				switch (yourChoice) {
				case "c1":
					wrong3();
					break;
				case "c2":
					correct3();
					break;
				case "c3":
					wrong3();
					break;
				case "c4":
					wrong3();
					break;
				}
				break;
			case "exam4":
				switch (yourChoice) {
				case "c1":
					correct4();
					break;
				case "c2":
					wrong4();
					break;
				case "c3":
					wrong4();
					break;
				case "c4":
					wrong4();
					break;
				}
				break;
			case "correct1":
				switch (yourChoice) {
				case "c1":
					exam2();
					break;
				}
				break;
			case "correct2":
				switch (yourChoice) {
				case "c1":
					exam3();
					break;
				}
				break;
			case "correct3":
				switch (yourChoice) {
				case "c1":
					exam4();
					break;
				}
				break;
			case "correct4":
				switch (yourChoice) {
				case "c1":
					introFight1();
					break;
				}
				break;
			case "wrong1":
				switch (yourChoice) {
				case "c1":
					exam2();
					break;
				}
				break;
			case "wrong2":
				switch (yourChoice) {
				case "c1":
					exam3();
					break;
				}
				break;
			case "wrong3":
				switch (yourChoice) {
				case "c1":
					exam4();
					break;
				}
				break;
			case "wrong4":
				switch (yourChoice) {
				case "c1":
					introFight1();
					break;
				}
				break;
			case "introFight1":
				switch (yourChoice) {
				case "c1":
					assistHealth -= playerStrength;
					assistStat();
					if (checkDie() == 2) {
						assistDie();
					}
					break;
				case "c2":
					assistHealth -= playerInt * 3;
					assistStat();
					if (checkDie() == 2) {
						assistDie();
					}
					break;
				case "c3":
					assistHealth -= grade * 50;
					assistStat();
					if (checkDie() == 2) {
						assistDie();
					}
					break;
				}
				break;
			case "assistStat":
				switch (yourChoice) {
				case "c1":
					assistAttack();
					break;
				}
				break;
			case "assistAttack":
				switch (yourChoice) {
				case "c1":
					playerHealth -= 5;
					if (checkDie() == 1) {
						playerDie();
					} else {
						fight1();
					}
					break;
				}
				break;
			case "fight1":
				switch (yourChoice) {
				case "c1":
					assistHealth -= playerStrength;
					assistStat();
					if (checkDie() == 2) {
						assistDie();
					}
					break;
				case "c2":
					assistHealth -= playerInt * 3;
					assistStat();
					if (checkDie() == 2) {
						assistDie();
					}
					break;
				case "c3":
					assistHealth -= grade * 50;
					assistStat();
					if (checkDie() == 2) {
						assistDie();
					}
					break;
				}
				break;

			case "assistDie":
				switch (yourChoice) {
				case "c1":
					introFight2();
					break;
				}
				break;
			case "introFight2":
				switch (yourChoice) {
				case "c1":
					professorHealth -= playerStrength;
					professorStat();
					if (checkDie() == 3) {
						professorDie();
					}
					break;
				case "c2":
					professorHealth -= playerInt * 3;
					professorStat();
					if (checkDie() == 3) {
						professorDie();
					}
					break;
				case "c3":
					professorHealth -= grade * 50;
					professorStat();
					if (checkDie() == 3) {
						professorDie();
					}
					break;
				}
				break;
			case "fight2":
				switch (yourChoice) {
				case "c1":
					professorHealth -= playerStrength;
					professorStat();
					if (checkDie() == 3) {
						professorDie();
					}
					break;
				case "c2":
					professorHealth -= playerInt * 3;
					professorStat();
					if (checkDie() == 3) {
						professorDie();
					}
					break;
				case "c3":
					professorHealth -= grade * 50;
					professorStat();
					if (checkDie() == 3) {
						professorDie();
					}
					break;
				}
				break;
			case "professorStat":
				switch (yourChoice) {
				case "c1":
					professorAttack();
					break;
				}
				break;
			case "professorAttack":
				switch (yourChoice) {
				case "c1":
					playerHealth -= 5;
					if (checkDie() == 1) {
						playerDie();
					} else {
						fight2();
					}
					break;
				}
				break;
			case "playerDie":
				switch (yourChoice) {
				case "c1":
					ending();
					break;
				}
				break;
			case "professorDie":
				switch (yourChoice) {
				case "c1":
					ending();
					break;
				}
				break;
			case "ending":
				switch (yourChoice) {
				case "c1":
					q1();
					assistHealth = 100;
					professorHealth = 200;
					break;
				case "c2":
					Frame.dispose();
				}
				break;
			}
		}
	}
}