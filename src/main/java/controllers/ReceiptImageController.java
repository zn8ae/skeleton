package controllers;

import api.ReceiptSuggestionResponse;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.Collections;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.hibernate.validator.constraints.NotEmpty;

import static java.lang.System.out;

@Path("/images")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
public class ReceiptImageController {
    private final AnnotateImageRequest.Builder requestBuilder;

    public ReceiptImageController() {
        // DOCUMENT_TEXT_DETECTION is not the best or only OCR method available
        Feature ocrFeature = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
        this.requestBuilder = AnnotateImageRequest.newBuilder().addFeatures(ocrFeature);

    }

    /**
     * This borrows heavily from the Google Vision API Docs.  See:
     * https://cloud.google.com/vision/docs/detecting-fulltext
     *
     * YOU SHOULD MODIFY THIS METHOD TO RETURN A ReceiptSuggestionResponse:
     *
     * public class ReceiptSuggestionResponse {
     *     String merchantName;
     *     String amount;
     * }
     */
    @POST
    public ReceiptSuggestionResponse parseReceipt(@NotEmpty String base64EncodedImage) throws Exception {
        Image img = Image.newBuilder().setContent(ByteString.copyFrom(Base64.getDecoder().decode(base64EncodedImage))).build();
        AnnotateImageRequest request = this.requestBuilder.setImage(img).build();

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse responses = client.batchAnnotateImages(Collections.singletonList(request));
            AnnotateImageResponse res = responses.getResponses(0);

            String merchantName = null;
            BigDecimal amount = null;

            // Your Algo Here!!
            boolean f1 = false;
            // boolean f2 = false;
            // Sort text annotations by bounding polygon.  Top-most non-decimal text is the merchant
            // bottom-most decimal text is the total amount

            TextAnnotation fullTextAnnotation = res.getFullTextAnnotation();
            String result = fullTextAnnotation.getText();
            //System.out.println(res.getTextAnnotationsList().get(0).getDescription().split("\n")[0]);
            for(String s : result.split("\n")) {

                if (!f1) {
                    merchantName = s.split(" ")[0];
                    f1 = true;
                }

                for (String s2 : s.split(" ")) {
                    if (s2.contains(".") && Character.isDigit(s2.charAt(s2.length() - 1)) &&
                            Character.isDigit(s2.charAt(s2.length() - 2))) {
                        if (s2.contains("$")) {
                            s2 = s2.substring(1, s2.length());
                            try {
                                amount = new BigDecimal(s2);
                            } catch (Exception e) {
                                amount = null;
                            }
                        } else {
                            try {
                                amount = new BigDecimal(s2);
                            } catch (Exception e) {
                                amount = null;
                            }
                        }
                    }
                }
            }




            //TextAnnotation fullTextAnnotation = res.getFullTextAnnotation();
            return new ReceiptSuggestionResponse(merchantName, amount);
        }
    }
}
