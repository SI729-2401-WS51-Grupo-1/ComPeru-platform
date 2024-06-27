package pe.edu.upc.comperu_platform.payment.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.comperu_platform.payment.domain.model.queries.GetAllPaymentsQuery;
import pe.edu.upc.comperu_platform.payment.domain.services.PaymentCommandService;
import pe.edu.upc.comperu_platform.payment.domain.services.PaymentQueryService;
import pe.edu.upc.comperu_platform.payment.interfaces.rest.resources.CreatePaymentResource;
import pe.edu.upc.comperu_platform.payment.interfaces.rest.resources.PaymentResource;
import pe.edu.upc.comperu_platform.payment.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import pe.edu.upc.comperu_platform.payment.interfaces.rest.transform.PaymentResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "/api/v1/payments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Payments", description = "Payment Management Endpoints")
public class PaymentController {
    private final PaymentQueryService paymentQueryService;
    private final PaymentCommandService paymentCommandService;

    public PaymentController(PaymentQueryService paymentQueryService, PaymentCommandService paymentCommandService) {
        this.paymentQueryService = paymentQueryService;
        this.paymentCommandService = paymentCommandService;
    }

    @GetMapping
    public ResponseEntity<Iterable<PaymentResource>> getAllPayments(){
        var getAllPaymentsQuery = new GetAllPaymentsQuery();
        var payments = paymentQueryService.handle(getAllPaymentsQuery);
        var paymentResources = payments.stream()
                .map(PaymentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(paymentResources);
    }


    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource createPaymentResource){
        var createPaymentCommand = CreatePaymentCommandFromResourceAssembler
                .toCommandFromResource(createPaymentResource);
        var payment = paymentCommandService.handle(createPaymentCommand);
        if (payment.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var paymentResource = PaymentResourceFromEntityAssembler
                .toResourceFromEntity(payment.get());
        return new ResponseEntity<>(paymentResource, HttpStatus.CREATED);
    }
}
