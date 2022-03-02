package util;

public class Constants {
    public static final String TASKLIST_WINDOWS = "TASKLIST /FO TABLE";
    public static final String TASKLIST_LINUX = "ps -ef";

    public static final String KILL_BY_PID_WINDOWS = "TASKKILL /PID ";
    public static final String KILL_BY_PID_LINUX = "kill -9 ";

    public static final String KILL_BY_NAME_WINDOWS = "TASKKILL /IM ";
    public static final String KILL_BY_NAME_LINUX = "pkill -f ";
    
}
