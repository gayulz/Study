package dto;

public class WordDTO {
    private String engWord;
    private String korWord;
    private static WordDTO self;

    public static WordDTO getInstance(){
        if (self == null) self = new WordDTO();
        return self;
    }
    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        if (engWord != null && engWord.length() >= 1) {
            this.engWord = engWord;
        }
    }

    public String getKorWord() {
        return korWord;
    }

    public void setKorWord(String korWord) {
        if (korWord.length() >= 1 ) this.korWord = korWord;
    }
}
