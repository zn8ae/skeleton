package api;
import api.CreateReceiptRequest;
import api.ReceiptResponse;
import controllers.ReceiptController;
import dao.ReceiptDao;
import generated.tables.records.ReceiptsRecord;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ReceiptControllerTest {

    private ReceiptController controller;
    private ReceiptDao receiptDao;

    @Before
    public void setup() {
        receiptDao = mock(ReceiptDao.class);
        controller = new ReceiptController(receiptDao);
    }

    @Test
    public void createReceipt() throws Exception {
        CreateReceiptRequest request = new CreateReceiptRequest();
        request.amount = new BigDecimal(10.00);
        request.merchant = "DexingXu";
        when(receiptDao.insert(request.merchant, request.amount)).thenReturn(666);
        int result = controller.createReceipt(request);
        assertThat(result, equalTo(666));
    }

    @Test
    public void getReceipts() throws Exception {
        ReceiptsRecord receipt = new ReceiptsRecord();
        receipt.setId(666);
        List<ReceiptsRecord> receipts = new ArrayList<>();
        receipts.add(receipt);
        when(receiptDao.getAllReceipts()).thenReturn(receipts);
        List<ReceiptResponse> result = controller.getReceipts();

        assertThat(result.size(), equalTo(1));
    }

}