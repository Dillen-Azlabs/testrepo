package sg.ihh.ms.fms.app.util.string;

public class StringHelper {

    // private constructor
    private StringHelper() {
    }

    // return empty string if null.
    public static String emptyIfNull(String str) {
        return (str != null) ? str : "";
    }

    // return null if empty string found
    // else return the original string
    public static String nullIfEmpty(String str) {
        return (str == null || str.isEmpty()) ? null : str;
    }

}
