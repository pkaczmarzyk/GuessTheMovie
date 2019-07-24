public class Movie {

    private String title;
    private String titleEncode;
    private String charFinded;
    private String charNotFinded;

    public Movie (String title) {
        this.charFinded = "";
        this.charNotFinded = "";
        this.title = title;
        this.titleEncode = titleEncode (title);
    }

    public String getTitle () {
        return title;
    }

    public String getChatNotFinded () {
        return this.charNotFinded;
    }

    public String getTitleEncode () {
        return titleEncode;
    }

    public void setTitleEncode (String titleEncode) {
        this.titleEncode = titleEncode;
    }


    public String titleEncode (String title) {
        String encode = "";
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            if ( (c == ' ') || (charFinded.indexOf(c) >= 0)) {
                encode += c;
            }
            else {
                encode += '_';
            }
        }
        return encode;
    }

    public boolean charSearch(char charToFind) {

        boolean result = false;
        if (charFinded.indexOf (charToFind) >= 0 || charNotFinded.indexOf (charToFind) >= 0) {
            // nic
        }
        else {
            // szukaj i dodaj
            if (title.indexOf (charToFind) >= 0) {
                this.charFinded += charToFind;
                result = true;
            } else {
                this.charNotFinded += charToFind;
            }
        }

        if (result)
            setTitleEncode(titleEncode (title));

        return result;
    }

    public boolean winnerTest () {

        return getTitle().equals(titleEncode(getTitle()));
    }

}
