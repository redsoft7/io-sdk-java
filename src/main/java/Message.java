public class Message {

    private int amount;
    private String dueDate;
    private String fiscalCode;
    private boolean invalidAfterDueDate;
    private String markdown;
    private int noticeNumber;
    private String subject;

    public Message(int amount, String dueDate, String fiscalCode, boolean invalidAfterDueDate, String markdown, int noticeNumber, String subject) {
        this.amount = amount;
        this.dueDate = dueDate;
        this.fiscalCode = fiscalCode;
        this.invalidAfterDueDate = invalidAfterDueDate;
        this.markdown = markdown;
        this.noticeNumber = noticeNumber;
        this.subject = subject;
    }

    public int getAmount() {
        return amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public boolean getInvalidAfterDueDate() {
        return invalidAfterDueDate;
    }

    public String getMarkdown() {
        return markdown;
    }

    public int getNoticeNumber() {
        return noticeNumber;
    }

    public String getSubject() {
        return subject;
    }
}
