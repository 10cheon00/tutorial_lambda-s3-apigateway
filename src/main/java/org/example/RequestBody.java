package org.example;

public class RequestBody {
    private String text;
    private String lang;

    // 기본 생성자 필요 (Jackson에서 역직렬화 시 사용)
    public RequestBody() {}

    public RequestBody(String text, String lang) {
        this.text = text;
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}

