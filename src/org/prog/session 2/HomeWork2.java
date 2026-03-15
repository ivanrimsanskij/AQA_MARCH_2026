public class HomeWork2 {
    public static void main(String[] args) {
        String[] emails = new String[] {
                "abcd@gmail.com",
                "john.doe@gmail.com",
                "mymailgmail.com",
                "badmail@@gmail.com",
                "somemail@gmailcom",
                "somemail@gmail.com",
                "a@gmail.com",
                "abcdedfg@x.com",
                "abcdedfg@xzfgdasd.com"
        };

        for (int i = 0; i < emails.length; i++) {
            String pochta = emails[i];

            if (pochta.lastIndexOf("@") == pochta.indexOf("@") && (pochta.indexOf("@") > 3)
                    && ((pochta.lastIndexOf(".") - pochta.indexOf("@") > 3) && pochta.contains("@") && pochta.contains("."))
                    && (pochta.split("@"))[1].contains(".")) {
                System.out.println("valid email: " + pochta);
            }
        }
    }
}











