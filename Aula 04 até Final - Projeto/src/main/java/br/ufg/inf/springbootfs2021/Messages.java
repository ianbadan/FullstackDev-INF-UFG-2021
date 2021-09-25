package br.ufg.inf.springbootfs2021;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Messages {

    public static Properties props = load();

    private static Properties load() {
        Properties pros = new Properties();

        FileInputStream fs = null;
        try{
            fs = new FileInputStream("src/main/resources/messages.properties");
            pros.load(fs);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pros;
    }

    public static String get(String key){
        return props.getProperty(key);
    }
}
