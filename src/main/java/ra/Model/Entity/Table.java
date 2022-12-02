package ra.Model.Entity;

public class Table {
    private int tableID;
    private String tableName;
    private int tableSeat;
    private boolean tableStatus;

    public Table() {
    }

    public Table(int tableID, String tableName, int tableSeat, boolean tableStatus) {
        this.tableID = tableID;
        this.tableName = tableName;
        this.tableSeat = tableSeat;
        this.tableStatus = tableStatus;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableSeat() {
        return tableSeat;
    }

    public void setTableSeat(int tableSeat) {
        this.tableSeat = tableSeat;
    }

    public boolean isTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }
}
