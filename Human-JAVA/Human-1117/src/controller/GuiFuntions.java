package controller;

import javax.swing.*;
import java.awt.*;

public class GuiFuntions {
    public JTextArea newTextArea() {
        JTextArea addArea = new JTextArea();
        addArea.setLineWrap(true);
        addArea.append("     << 단어를 클릭하세요\n ");
        addArea.append("     단어 설명 출력됩니다\n");
        addArea.append("------------------\n");
        return addArea;
    }


    public JLabel titleFont(String text) {
        Font font = new Font("맑은 고딕", Font.BOLD, 20);
        JLabel jLabel = new JLabel(text);
        jLabel.setFont(font);
        return jLabel;
    }

    public JLabel semiTitle(String text) {
        Font font = new Font("맑은 고딕", Font.PLAIN, 13);
        JLabel jLabel = new JLabel(text);
        jLabel.setForeground(Color.BLUE);
        jLabel.setFont(font);
        return jLabel;
    }

    public Button commit() {
        Font commitFont = new Font("맑은 고딕", Font.PLAIN, 30);
        Button commit = new Button("COMMIT");
        commit.setFont(commitFont);
        return commit;
    }
}
