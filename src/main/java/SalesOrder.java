import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class SalesOrder {

  String customerId;
  String orderId;
  String status;
  String comment;
  String salesAssociate;
  String orderDate;
  float subTotal;
  float salesTax;
  float totalOrderAmount;
  float payments;
  float financing;
  float balanceDue;
  Map<String, String> deliverySchedule; // productName,quantity, deliveryService,delivery date, invoiced
  HashMap<String, OrderProduct> orderProductList; // product name, product quantity, sticker price, sale price, total price
  // Map<String, Product> inventory; // sub total, sales tax, total order amount, payments, financing, insert balance due
  CustomerAccount customerAccount;


  SalesOrder(String customerId, String orderId, String status, String comment,
             String salesAssociate, String orderDate, float subTotal, float salesTax,
             float totalOrderAmount, float financing, float balanceDue) {
    this.customerId = customerId;
    this.orderId = orderId;
    this.status = status;
    this.comment = comment;
    this.salesAssociate = salesAssociate;
    this.orderDate = orderDate;
    this.subTotal = subTotal;
    this.salesTax = salesTax;
    this.totalOrderAmount = totalOrderAmount;
    this.financing = financing;
    this.balanceDue = balanceDue;
  }
}



class OrderProduct {
  String orderId;
  String productId;
  String productName;
  String size;
  String disposition;
  String vendorName;
  String type;
  String deliveryDate;
  String deliveryService;
  String atpDate;
  boolean invoiced;
  int quantity;
  float stickerPrice;
  float salePrice;
  float totalSalePrice;
  float percDiscount;

  OrderProduct(String orderId, String productId, String productName, String size, String disposition, int quantity,
               float stickerPrice, float salePrice, float percDiscount, float totalSalePrice)
  {
    this.orderId = orderId;
    this.productId = productId;
    this.productName = productName;
    this.size = size;
    this.disposition = disposition;
    this.quantity = quantity;
    this.stickerPrice = stickerPrice;
    this.salePrice = salePrice;
    this.percDiscount = percDiscount;
    this.totalSalePrice = totalSalePrice;
  }





  OrderProduct(String productId, String productName, String size, String disposition, String vendorName, String atpDate)
    {
    this.productId = productId;
    this.productName = productName;
    this.size = size;
    this.disposition = disposition;
    this.vendorName = vendorName;
    this.atpDate = atpDate;

    }

}

class Product {

  String productId;
  String productName;
  String size;
  String disposition;
  String vendorName;
  String atpDate;
  int quantity;
  float stickerPrice;

}

