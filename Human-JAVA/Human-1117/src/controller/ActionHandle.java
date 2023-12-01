package controller;

import dto.WordDTO;

import javax.swing.*;

public class ActionHandle extends UserMenu{
    // Singleton
    private static ActionHandle self = null;
    private ActionHandle(){}
    public static ActionHandle getInstance(){
        if(self == null){
            self = new ActionHandle();
        }
        return self;
    }

    // commit 버튼 Action 처리
    protected void saveButtonAction() {
        String eng = engField.getText();
        String kor = korField.getText();
        if (isFieldEmpty(eng) || isFieldEmpty(kor)) {
            showErrorMessage("영어 단어와 설명을 모두 입력해주세요", "Input Error");
            return;
        }
        WordDTO actionWdto = WordDTO.getInstance();
        actionWdto.setEngWord(eng);
        actionWdto.setKorWord(kor);
        AdminSection.saveTransfer(actionWdto);
        engList.add(eng);
    }

    // engList Action 처리
    protected void engListAction() {
        WordDTO tmpDto = WordDTO.getInstance();
        String choiceEngWord = UserMenu.engList.getSelectedItem();
        if (choiceEngWord != null){
            tmpDto.setEngWord(choiceEngWord);
            WordDTO actionWdto = AdminSection.findTransfer(tmpDto);
            String tmp = actionWdto.getKorWord();
            appendTextToKorArea(tmpDto.getEngWord(),tmp);
        }
    }

    // korArea에 Text 추가
    private void appendTextToKorArea(String engWord, String korWord) {
        String indentedText = korArea.getText() + "\n" + engWord + ": " + korWord;
        super.korArea.setText(indentedText);
    }

    // Field가 비어있는지 확인
    private boolean isFieldEmpty(String fieldText) {
        return fieldText.isEmpty();
    }

    // Error Message 출력
    private void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
