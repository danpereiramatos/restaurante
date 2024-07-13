package br.com.nomeempresa.restaurante.core.domain.entities.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

        private Long id;
        private LocalDateTime date;
        private String description;
        private BigDecimal transactionAmount;
        private String paymentMethodId;
        private Payer payer;
        private AdditionalInfo additionalInfo;

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public BigDecimal getTransactionAmount() {
                return transactionAmount;
        }

        public void setTransactionAmount(BigDecimal transactionAmount) {
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

        public LocalDateTime getDate() {
                return date;
        }

        public void setDate(LocalDateTime date) {
                this.date = date;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }
}
