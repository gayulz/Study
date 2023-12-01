package controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static dao.FindDao.getAllWordsDB;

public class UserMenu extends JFrame implements ActionListener, MouseListener {
    private final GuiFuntions fn = new GuiFuntions();
    private final Button commit = fn.commit();
    private final JLabel engTitle = fn.semiTitle(" 영문 입력 >> ");
    private final JLabel korTitle = fn.semiTitle(" 설명 입력 >> ");
    protected final JTextField engField = new JTextField(15);
    protected final JTextField korField = new JTextField(15);
    protected static final List engList = new List(15);
    protected final JTextArea korArea = fn.newTextArea();
    private static java.util.List<String> allWords;

    // 생성자
    public UserMenu() {
        super("Word Note __ by.yuuri");
        settingUI();
        setLayout();
        // 기존 DB에 있는 단어들을 List에 추가
        databaseAppendList();
        addListeners();
    }

    // Frame UI 설정
    private void settingUI() {
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Frame Layout 설정
    private void setLayout() {
        JPanel mainPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        northPanel.setLayout(new GridLayout());
        northPanel.add(createTitlePanel(" 단어 입력 "), BorderLayout.WEST);
        northPanel.add(createTitlePanel(" 단어 전체 보기 "), BorderLayout.EAST);

        centerPanel.setLayout(new GridLayout());
        centerPanel.add(centerWestPanel());
        centerPanel.add(centerEastPanel());

        southPanel.add(createTitlePanel("개발자 : 김가율"));

        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Title Panel 생성
    private JPanel createTitlePanel(String titleText) {
        JPanel titlePanel = new JPanel();
        titlePanel.add(fn.titleFont(titleText));
        return titlePanel;
    }

    // Center East Panel 생성
    private JPanel centerEastPanel() {
        JPanel centerEastPanel = new JPanel();
        centerEastPanel.setLayout(new GridLayout(0, 2));
        centerEastPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JScrollPane scrollPane = new JScrollPane(korArea);
        centerEastPanel.add(engList);
        centerEastPanel.add(scrollPane);
        return centerEastPanel;
    }

    // Center West Panel 생성
    private JPanel centerWestPanel() {
        JPanel westCenterPanel = new JPanel();
        westCenterPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        westCenterPanel.add(engTitle);
        westCenterPanel.add(engField);
        westCenterPanel.add(korTitle);
        westCenterPanel.add(korField);
        westCenterPanel.add(commit);
        return westCenterPanel;
    }

    // Listener 추가
    private void addListeners() {
        commit.addActionListener(this);
        engField.addActionListener(this);
        korField.addActionListener(this);
        engList.addActionListener(this);
        korArea.addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle mouse click if needed
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Handle mouse press if needed
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Handle mouse release if needed
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Handle mouse enter if needed
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // Handle mouse exit if needed
    }


    // Action Listener 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        ActionHandle actionHandle = ActionHandle.getInstance();
        if (e.getSource() == commit) {
            actionHandle.saveButtonAction();
        } else if (e.getSource() == engList) {
            actionHandle.engListAction();
        }
    }

    // DB에 있는 단어들을 List에 추가
    private void databaseAppendList(){
        allWords = getAllWordsDB();
        for (String word : allWords) {
            engList.add(word);
        }
    }
}
