package utils;

import importer.Args;

public class TestUtils {

    public static Args buildMysqlArgs() {
        Args args = new Args();
        args.setDatabaseType("mysql");
        args.setHost("localhost");
        args.setDatabase("test");
        args.setPort("3306");
        args.setUser("root");
        args.setPassword("root");
        return args;
    }

}
