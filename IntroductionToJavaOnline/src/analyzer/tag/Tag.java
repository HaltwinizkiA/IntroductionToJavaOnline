package analyzer.tag;

public class Tag {
    String open="";
    String body="";
    String close="";


    public Tag(String open, String body, String close) {
        this.open = open;
        this.body = body;
        this.close = close;
    }

    public String getOpen() {
        return open;
    }

    public String getBody() {
        return body;
    }

    public String getClose() {
        return close;
    }
}