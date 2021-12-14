package checkout;

import java.util.HashMap;
import java.util.Map;

class Receipt {

    private String text;
    private Map<String, Integer> numbersOfProducts;
    private int total;

    public Receipt() {
        text = "";
        numbersOfProducts = new HashMap<>();
        numbersOfProducts.put("A", 0);
        numbersOfProducts.put("B", 0);
        numbersOfProducts.put("C", 0);
        numbersOfProducts.put("D", 0);
    }

    String text() {
        return text + "Total: " + total;
    }

    void scannedA() {
        numbersOfProducts.put("A", numbersOfProducts.get("A") + 1);
        total += 50;
        text += "A: 50";
        text += dealText("A", 50, 5, 30);
    }

    void scannedB() {
        numbersOfProducts.put("B", numbersOfProducts.get("B") + 1);
        total += 30;
        text += "B: 30";
        text += dealText("B", 30, 2, 15);
    }

    void scannedC() {
        numbersOfProducts.put("C", numbersOfProducts.get("C") + 1);
        total += 20;
        text += "C: 20";
        text += dealText("C", 20, 4, 10);
    }

    void scannedD() {
        numbersOfProducts.put("D", numbersOfProducts.get("D") + 1);
        total += 15;
        text += "D: 15\n";
    }

    private String dealText(String product, int productPrice, int dealNumber, int dealDiscount) {
        int numberOfProduct = numbersOfProducts.get(product);
        if (numberOfProduct % dealNumber == 0) {
            total -= dealDiscount;
            return String.format(" - %s (%s for %s)\n",
                    dealDiscount, dealNumber, dealNumber * productPrice - dealDiscount);
        } else {
            return "\n";
        }
    }
}
