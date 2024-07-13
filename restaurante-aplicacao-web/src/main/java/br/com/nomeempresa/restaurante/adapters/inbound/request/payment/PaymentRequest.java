package br.com.nomeempresa.restaurante.adapters.inbound.request.payment;


public class PaymentRequest {

        private String description;
        private double transactionAmount;
        private String paymentMethodId;
        private Payer payer;
        private AdditionalInfo additionalInfo;

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public double getTransactionAmount() {
                return transactionAmount;
        }

        public void setTransactionAmount(double transactionAmount) {
                this.transactionAmount = transactionAmount;
        }

        public String getPaymentMethodId() {
                return paymentMethodId;
        }

        public void setPaymentMethodId(String paymentMethodId) {
                this.paymentMethodId = paymentMethodId;
        }

        public Payer getPayer() {
                return payer;
        }

        public void setPayer(Payer payer) {
                this.payer = payer;
        }

        public AdditionalInfo getAdditionalInfo() {
                return additionalInfo;
        }

        public void setAdditionalInfo(AdditionalInfo additionalInfo) {
                this.additionalInfo = additionalInfo;
        }
}
