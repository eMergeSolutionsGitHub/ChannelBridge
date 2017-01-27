package emerge.lk.channelbridge.Entity;

/**
 * Created by Himanshu on 1/5/2017.
 */

public class InvoiceEntity {

//
    String invoiceNumber,invoiceValue,invoiceDate, invoiceDueDate,invoicesBalance;


    public InvoiceEntity(String invoiceNumber,String invoiceDate,String invoiceValue, String invoicesBalance) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceValue = invoiceValue;
        this.invoiceDate = invoiceDate;
        this.invoicesBalance = invoicesBalance;
    }

    public InvoiceEntity(String invoiceNumber, String invoiceValue, String invoiceDueDate) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceValue = invoiceValue;
        this.invoiceDueDate = invoiceDueDate;
    }
    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoicesBalance() {
        return invoicesBalance;
    }

    public void setInvoicesBalance(String invoicesBalance) {
        this.invoicesBalance = invoicesBalance;
    }
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(String invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public String getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public void setInvoiceDueDate(String invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }
}
