import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Importer {

    private Args args;

    public Importer(Args args){
        this.args = args;
    }

    public boolean showForm() {
        return args.getHost() == null
                || args.getPort() == null
                || args.getDatabase() == null
                || args.getUser() == null
                || args.getPassword() == null;
    }

    public List<Message> loadMessages() throws IOException, ClassNotFoundException, SQLException {
        List<Message> messages = new ArrayList<>();
        Statement stmt;
        try (Connection connection = new JdbcConfiguration(args).getConnection()) {
            stmt = connection.createStatement();
            String selectSql = "SELECT 0 AS amount,\n" +
                    "scadenza AS due_date,\n" +
                    "destinatario AS fiscal_code,\n" +
                    "false AS invalid_after_due_date,\n" +
                    "testo AS markdown,\n" +
                    "1 AS notice_number,\n" +
                    "titolo AS subject FROM messages";
            ResultSet resultSet = stmt.executeQuery(selectSql);

            while (resultSet.next()) {
                Message msg = new Message(
                    resultSet.getInt("amount"),
                    resultSet.getString("due_date"),
                    resultSet.getString("fiscal_code"),
                    resultSet.getBoolean("invalid_after_due_date"),
                    resultSet.getString("markdown"),
                    resultSet.getInt("notice_number"),
                    resultSet.getString("notice_number"));
                messages.add(msg);
            }

        }
        return messages;
    }

}
