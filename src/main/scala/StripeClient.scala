class StripeClient {

  val data = com.stripe.model.Invoice.list(new java.util.TreeMap[String, Object]()).getData
  // IDEA doesn't know anything about data here, no auto-completion, etc; but this line actually compiles

  val data2 = com.stripe.model.Invoice.list(new java.util.TreeMap[String, Any]()).getData
  // IDEA knows about data2; but this line doesn't compile

}
