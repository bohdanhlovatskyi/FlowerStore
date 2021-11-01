package payments;

import internalService.InternalStatus;

public enum PaymentStatus implements InternalStatus {
    PAYMENT_STATUS_OK, PAYMENT_STATUS_FAULT;
}
