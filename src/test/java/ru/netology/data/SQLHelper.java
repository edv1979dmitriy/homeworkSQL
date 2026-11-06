package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {

    public SQLHelper() {
    }

    private static final QueryRunner runner = new QueryRunner();

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "user");
    }

    @SneakyThrows
    public static DataHelper.VerificationCode getCode() {
        var codeSQL = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1";
        try (var conn = connect()) {
            return runner.query(conn, codeSQL, new BeanHandler<>(DataHelper.VerificationCode.class));
        }
    }

    @SneakyThrows
    public static void cleanAuthInfo() {
        try (var conn = connect()) {
            runner.update(conn, "DELETE FROM auth_codes");
        }
    }

    @SneakyThrows
    public static void cleanDB() {
        try (var conn = connect()) {
            runner.update(conn, "DELETE FROM auth_codes");
            runner.update(conn, "DELETE FROM card_transactions");
            runner.update(conn, "DELETE FROM cards");
            runner.update(conn, "DELETE FROM users");
        }
    }
}
