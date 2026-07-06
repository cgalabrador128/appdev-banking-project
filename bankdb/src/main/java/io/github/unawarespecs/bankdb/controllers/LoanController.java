package io.github.unawarespecs.bankdb.controllers;

import org.springframework.web.bind.annotation.RestController;
import io.github.unawarespecs.bankapp.service.BankInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.github.unawarespecs.bankapp.model.LoanPlan;
import io.github.unawarespecs.bankapp.model.Loan;

@RestController
public class LoanController {
}
