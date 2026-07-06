package io.github.unawarespecs.bankapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "loan_plan_data")
public class LoanPlanData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int duration;
    private double maxAmount;
    private double interestRate;

    public LoanPlanData() {}

    public LoanPlanData(int id, String name, int duration, double maxAmount, double interestRate) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.maxAmount = maxAmount;
        this.interestRate = interestRate;
    }
}
